package com.simtech.sim.mainnode.service.impl;

import com.google.gson.Gson;
import com.rabbitmq.client.*;
import com.simtech.sim.mainnode.MainNodeApplication;
import com.simtech.sim.mainnode.config.mq.RabbitMQConnectionPool;
import com.simtech.sim.mainnode.entity.JobInputInfoEntity;
import com.simtech.sim.mainnode.service.JobAcceptor;
import com.simtech.sim.quartzclustercommon.entity.JobInfoEntity;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;


@Service
public class JobAcceptorImpl implements JobAcceptor {


    private final WebClient.Builder loadBalancedWebClientBuilder;
    private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

    public JobAcceptorImpl(WebClient.Builder webClientBuilder,
                                   ReactorLoadBalancerExchangeFilterFunction lbFunction) {
        this.loadBalancedWebClientBuilder = webClientBuilder;
        this.lbFunction = lbFunction;
    }


    private static final Logger log = getLogger(MainNodeApplication.class);



    @RabbitHandler
    @RabbitListener(queues = "sender")
    public void receiveJobInfo(byte[] body) {
        String response = new String(body, StandardCharsets.UTF_8);

        log.info("Job Instance received : " + response);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        loadBalancedWebClientBuilder.build().post().uri("http://quartz-cluster-node/JobAccepter/addJob")
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .bodyValue(response)
                .retrieve().bodyToMono(String.class)
                .subscribe();


    }

}
