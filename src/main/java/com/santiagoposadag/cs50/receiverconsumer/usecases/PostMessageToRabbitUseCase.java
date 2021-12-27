package com.santiagoposadag.cs50.receiverconsumer.usecases;


import com.google.gson.Gson;
import com.santiagoposadag.cs50.receiverconsumer.config.GeneralActionConsumerRabbitMQ;
import com.santiagoposadag.cs50.receiverconsumer.dto.CryptoCurrencyDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
public class PostMessageToRabbitUseCase implements Function<CryptoCurrencyDto, Mono<CryptoCurrencyDto>> {

    private RabbitTemplate rabbitTemplate;
    private Gson gson = new Gson();

    public PostMessageToRabbitUseCase(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }


    @Override
    public Mono<CryptoCurrencyDto> apply(@Validated CryptoCurrencyDto cryptoCurrencyDto) {
        //rabbitTemplate.convertAndSend(GeneralActionConsumerRabbitMQ.EXCHANGE, cryptoCurrencyDto.getRoutingKey(), gson.toJson(cryptoCurrencyDto));
        return Mono.just(cryptoCurrencyDto);
    }
}