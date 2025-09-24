package br.edu.utfpr.e_station.dto;

import java.util.UUID;

public record PropertyDTO(
     String name,
     String address,
     UUID ownerId,
     float areaSize
) 
{

}
