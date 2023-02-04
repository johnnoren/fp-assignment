package com.example.model.data.dto;

import com.example.model.entity.Id;
import com.example.model.entity.ModelCategory;

public record ModelCategoryDto(Id modelId, Id categoryId) implements Dto<ModelCategory> {

}
