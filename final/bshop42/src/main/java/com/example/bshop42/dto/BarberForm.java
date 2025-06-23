package com.example.bshop42.dto;

import com.example.bshop42.model.Workplace;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BarberForm {
    @NotBlank
    private String barber_name;
    @NotNull
    private Integer barber_experience;
    @NotNull
    private UUID workplace_id;
}
