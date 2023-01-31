package com.example.model.entity.order;

import java.sql.Timestamp;
import java.util.List;

public record Order(Timestamp orderDate, List<OrderItem> orderItems) {

}
