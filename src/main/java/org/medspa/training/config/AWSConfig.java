package org.medspa.training.config;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AWSConfig {
    @Bean
    public AmazonS3 getAmazonS3(){
        return  AmazonS3ClientBuilder.standard()
                .withRegion(Regions.US_WEST_1)
                .build();
    }

}
