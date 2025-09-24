package br.edu.utfpr.e_station.dto;

import java.util.List;
import java.util.UUID;

import jakarta.annotation.Nonnull;

public record DeviceDTO (
    @Nonnull
    String model,
    String location,
    UUID propertyId,
    List<SensorDTO> sensors
)
{
}
