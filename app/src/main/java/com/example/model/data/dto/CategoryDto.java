package com.example.model.data.dto;

import com.example.model.entity.Category;

public record CategoryDto(String name) implements Dto<Category> {

}
