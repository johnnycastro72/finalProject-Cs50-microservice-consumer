package com.santiagoposadag.cs50.receiverconsumer.usecases;

import com.google.gson.Gson;
import com.santiagoposadag.cs50.receiverconsumer.collections.User;
import com.santiagoposadag.cs50.receiverconsumer.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class RecieveFromUserActionQueueUseCase {
    private Gson gson = new Gson();
    private UserRepository repository;

    public RecieveFromUserActionQueueUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public void receiveMessage(String message){
        User user = gson.fromJson(message, User.class);
        repository.save(user).subscribe();
    }

}
