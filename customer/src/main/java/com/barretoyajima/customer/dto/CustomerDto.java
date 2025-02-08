package com.barretoyajima.customer.dto;

import java.util.UUID;

public record CustomerDto(
        UUID id,
        String name,
        String cpf,
        String email,
        String address,
        Integer addressNumber
) {
}
