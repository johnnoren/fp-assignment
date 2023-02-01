package com.example.model.entity;

import java.sql.Timestamp;
import java.util.UUID;

public record Order(Id id, Timestamp orderDate, UUID orderNumber, Customer customer) {

}
