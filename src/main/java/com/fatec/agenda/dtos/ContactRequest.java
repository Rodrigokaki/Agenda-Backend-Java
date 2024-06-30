package com.fatec.agenda.dtos;

public record ContactRequest(String name, Integer age, Integer gender, String telephone, Boolean favorite) {
    
}
