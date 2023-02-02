package com.example.model.data.dto;

import com.example.model.entity.Country;

public record CountryDTO(String name) implements Dto<Country>{}
