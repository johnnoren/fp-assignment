package com.example.model.entity;

import com.example.model.property.ModelDescription;
import com.example.model.property.ModelName;

public record Model(Id id, ModelName name, ModelDescription description, Brand brand) {

}
