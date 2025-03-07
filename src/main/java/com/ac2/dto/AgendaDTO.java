package com.ac2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendaDTO {

    private String start_date;
    private String end_date;
    private String city;
    private String state;
    private String cep;

}
