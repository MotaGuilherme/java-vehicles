package com.guilherme.vehicles.dtos;

import com.guilherme.vehicles.entities.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
