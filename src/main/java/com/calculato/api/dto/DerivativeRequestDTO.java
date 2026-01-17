package com.calculato.api.dto;

import lombok.Data;

@Data
public class DerivativeRequestDTO {
        String expression;
        String variable;
}
