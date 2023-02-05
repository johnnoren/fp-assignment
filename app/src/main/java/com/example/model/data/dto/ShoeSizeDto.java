package com.example.model.data.dto;

import com.example.model.entity.ShoeSize;
import com.example.model.property.EuropeanSize;

public record ShoeSizeDto(EuropeanSize europeanSize) implements Dto<ShoeSize> {

}
