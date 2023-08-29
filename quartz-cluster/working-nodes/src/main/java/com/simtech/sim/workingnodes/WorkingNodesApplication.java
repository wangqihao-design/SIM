package com.simtech.sim.workingnodes;

import com.simtech.sim.workingnodes.service.JobExecutionMonitor;
import com.simtech.sim.workingnodes.service.ReportingService;
import com.simtech.sim.workingnodes.service.impl.JobExecutorServiceImpl;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.Random;
import java.util.List;

import static org.slf4j.LoggerFactory.*;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@Slf4j
public class WorkingNodesApplication {

	@Autowired
	private ReportingService reportingService; // 假设这是一个用于上报的服务

	private Boolean flag = true;

	public static void main(String[] args) {
		SpringApplication.run(WorkingNodesApplication.class, args);
	}

	@PostConstruct
	public void startReportingThread() {
		Thread thread = new Thread(this::runReportingLoop);
		thread.start();
	}

	@PreDestroy
	public void stopReportingThread() {
		// 在适当的地方停止线程
		this.flag = false;
	}

	private void runReportingLoop() {
		while (this.flag) {
			// 在这里使用注入的 reportingService 执行定时上报的逻辑

			// 休眠一段时间，例如每隔 1分钟 执行一次上报任务
			try {
				log.info("Reporting System Status");
				reportingService.pushThreadStatus();
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// 处理中断异常
				e.printStackTrace();
				break;
			}
		}
	}



}
