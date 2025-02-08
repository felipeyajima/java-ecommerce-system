package com.barretoyajima.billing.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record BillDto(
        UUID id,
        UUID demand,
        Double cost,
        LocalDateTime dateTime,
        String status

) {
}
