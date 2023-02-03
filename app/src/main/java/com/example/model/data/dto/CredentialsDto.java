package com.example.model.data.dto;

import com.example.model.entity.Credentials;

public record CredentialsDto(String email, String salt, String hashedPassword) implements Dto<Credentials> {

}
