package com.example.model.entity;

import com.example.model.property.Price;
import com.example.model.property.StockLevel;

import java.util.UUID;

public record Shoe(Id id, UUID sku, Price price, StockLevel stockLevel, ShoeSize size, Style style) {

}
