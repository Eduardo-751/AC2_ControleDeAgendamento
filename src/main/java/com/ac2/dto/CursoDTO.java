package com.ac2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {
    private Long id;
    private String desc;
    private String hours;
    private String objectives;
    private String ementa;
}
