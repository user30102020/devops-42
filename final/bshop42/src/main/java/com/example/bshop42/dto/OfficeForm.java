package com.example.bshop42.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfficeForm {
    @NotBlank
    private String office_name;
    @NotNull
    private Integer office_price;
    private String office_description;
}
