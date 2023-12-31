package org.medspa.training.config;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.sqs.AmazonSQS;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static org.mockito.Mockito.mock;

@Configuration
@Profile("unit")
public class AWSTestConfig {
    @Bean
    public AmazonS3 getAmazonS3(){
        return mock(AmazonS3.class);
    }

    @Bean
    public AmazonSQS sendMessage(){
        return mock(AmazonSQS.class);
    }
}
