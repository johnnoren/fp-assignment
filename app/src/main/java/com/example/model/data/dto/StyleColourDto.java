package com.example.model.data.dto;

import com.example.model.entity.Id;
import com.example.model.entity.StyleColour;

public record StyleColourDto(Id styleId, Id colourId) implements Dto<StyleColour>{

}
