package com.ms.email.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    @Value("${spring.rabbitmq.queue}")
    private String queue;


    // Retornamos uma Fila , com seu nome (ms-email) e se fila vai ser duravel ou n (true)..
    // se RabbitMQ interrompido n perde os dados

    @Bean
    public Queue queue() {
        return new Queue(queue, true);
    }

    // Conversor : Recebe corretamente a mensagem do EmailDTO
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}


