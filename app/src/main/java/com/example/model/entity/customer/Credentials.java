package com.example.model.entity.customer;

import com.example.model.security.HashedPassword;
import com.example.model.security.Salt;

public record Credentials(Email email, Salt salt, HashedPassword hashedPassword) {}