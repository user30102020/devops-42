package com.example.bshop42.dto;

import com.example.bshop42.model.Office;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegForm {
    @NotEmpty
    private List<UUID> offices;
    @NotNull
    private Date date;
    @NotNull
    private Integer time;
    @NotNull
    private UUID barber_id;
}
