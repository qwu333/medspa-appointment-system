package org.medspa.training.config;

import org.hibernate.SessionFactory;
import org.medspa.training.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {
    @Bean
    public SessionFactory getHibernateSessionFactory(){
        return HibernateUtil.getSessionFactory();
    }
}
