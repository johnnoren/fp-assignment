package com.example.model.data.dto;

import com.example.model.entity.Country;

public record CountryDto(String name) implements Dto<Country>{}
