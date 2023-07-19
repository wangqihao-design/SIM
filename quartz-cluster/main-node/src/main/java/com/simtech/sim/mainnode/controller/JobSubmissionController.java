package com.simtech.sim.mainnode.controller;


import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController

public class JobSubmissionController {

    private final WebClient.Builder loadBalancedWebClientBuilder;
    private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

    public JobSubmissionController(WebClient.Builder webClientBuilder,
                               ReactorLoadBalancerExchangeFilterFunction lbFunction) {
        this.loadBalancedWebClientBuilder = webClientBuilder;
        this.lbFunction = lbFunction;
    }

    @RequestMapping("/hi")
    public Mono<String> hi(@RequestParam(value = "name", defaultValue = "Mary") String name) {
        return loadBalancedWebClientBuilder.build().get().uri("http://quartz-cluster-node/greeting")
                .retrieve().bodyToMono(String.class)
                .map(greeting -> String.format("%s, %s!", greeting, name));
    }

}
