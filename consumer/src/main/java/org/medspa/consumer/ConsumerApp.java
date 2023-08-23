package org.medspa.consumer;

import org.medspa.consumer.service.SQSMessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "org.medspa.consumer")
public class ConsumerApp {
    public static void main(String[] args){
        SpringApplication.run(ConsumerApp.class,args);

//        ConfigurableApplicationContext app = SpringApplication.run(ConsumerApp.class,args);
//        SQSMessageService messageService = app.getBean(SQSMessageService.class);
        //@Autowired
        //
//
//        messageService.receiveMessage();

    }
}
