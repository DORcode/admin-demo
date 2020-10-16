package com.cjsjy.minio;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * @ClassName MinioConfig
 * @Description: TODO
 * @Author kh
 * @Date 2020-10-15 15:19
 * @Version V1.0
 **/
@Configuration
@ConditionalOnProperty(name = "minio.endpoint")
@EnableConfigurationProperties({MinioProperties.class})
public class MinioConfiguration {

    @Autowired
    MinioProperties minioProperties;

    @Bean("minioClient")
    @ConditionalOnProperty(name = "minio.endpoint")
    @ConditionalOnMissingBean(MinioClient.class)
    public MinioClient minioClient() {
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint(minioProperties.getEndpoint())
                        .credentials(minioProperties.getAccessKey(), minioProperties.getSecrectKey())
                        .build();
        return minioClient;
    }

    @Bean
    @DependsOn("minioClient")
    @ConditionalOnMissingBean(MinioTemplate.class)
    public MinioTemplate minioTemplate() {
        return new MinioTemplate();
    }
}
