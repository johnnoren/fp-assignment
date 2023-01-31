package com.example.model.entity.shoe;

import java.util.UUID;

public record Shoe(UUID uuid, UUID sku, Price price, StockLevel stockLevel, ShoeSize size, Style style) {

}
