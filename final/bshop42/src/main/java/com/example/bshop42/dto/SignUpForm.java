package com.example.bshop42.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class SignUpForm {

    @NotBlank
    private String firstname;
    @NotBlank
    private String email;
    @NotBlank
    @Length(min = 5)
    private String password;
}
