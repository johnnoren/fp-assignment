package com.example.model.entity;

import com.example.model.property.ProductImage;
import com.example.model.property.StyleName;

public record Style(Id id, StyleName styleName, ProductImage productImage, Model model) {

}
