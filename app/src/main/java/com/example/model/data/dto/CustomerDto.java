package com.example.model.data.dto;

import com.example.model.entity.Customer;

public record CustomerDto(String firstName, String lastName, String email, String salt, String hashedPassword,
						  String street, String number, String other, String postalCode, String city, String country) implements Dto<Customer> {}