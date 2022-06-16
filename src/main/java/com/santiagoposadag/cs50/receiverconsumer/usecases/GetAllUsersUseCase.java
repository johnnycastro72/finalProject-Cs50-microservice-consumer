package com.santiagoposadag.cs50.receiverconsumer.usecases;

import com.santiagoposadag.cs50.receiverconsumer.dto.UserDto;
import com.santiagoposadag.cs50.receiverconsumer.helpers.UserMappers;
import com.santiagoposadag.cs50.receiverconsumer.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class GetAllUsersUseCase implements Supplier<Flux<UserDto>> {
    private UserRepository repository;
    private UserMappers mapper;

    public GetAllUsersUseCase(UserRepository repository, UserMappers mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Flux<UserDto> get() {
        return repository.findAll().map(mapper.fromUserEntityToDto());
    }
}
