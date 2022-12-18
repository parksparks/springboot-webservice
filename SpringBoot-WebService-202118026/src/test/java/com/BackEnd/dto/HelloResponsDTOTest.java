package com.BackEnd.dto;


import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponsDTOTest {

    @Test
    public void Lombok(){
        String name = "test";
        String address = "vision";
        int amount = 1000;

        HelloResponseDTO dto = new HelloResponseDTO(name,amount,address);

        assertThat(dto.getName());
        assertThat(dto.getAmount());
        assertThat(dto.getAddress());
    }
}
