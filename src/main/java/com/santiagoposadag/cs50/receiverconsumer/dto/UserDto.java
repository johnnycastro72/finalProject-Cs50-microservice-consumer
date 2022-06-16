package com.santiagoposadag.cs50.receiverconsumer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String Id;
    private String name;
    private String lastName;
    private String dni;
    private String routingKey;
}
