package com.ms.email.consumers;

import com.ms.email.dtos.EmailDto;
import com.ms.email.models.EmailModel;
import com.ms.email.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
   private EmailService emailService;

    // Método que vai escutar a fila que ja definimos

    /*
           Nao precisamos entrar na instancia do RabbitMQ no CloudAMPQ
           Qnd iniciamos o serviço ele automaticamente pega as configurações
           e já cria essa fila pra gente no Broker ( onde criamos a instância )
           como n usamos ''Exchanges'' ele vai usar o default.

     */

    /*
            Recebe uma mensagem do EmailDTO

     */
    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDto emailDto) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);
        System.out.println("Email Status: " + emailModel.getStatusEmail().toString());
    }
}
