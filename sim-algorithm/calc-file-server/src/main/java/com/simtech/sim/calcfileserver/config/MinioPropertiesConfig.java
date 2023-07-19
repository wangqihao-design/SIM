package com.simtech.sim.calcfileserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioPropertiesConfig {


    private String endpoint;


    private String accessKey;

    private String secretKey;

    private String bucketName;
}