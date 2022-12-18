package com.jvision.admin.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter// Get 메소드를 자동생성
@RequiredArgsConstructor// final 멤버변수를 매개변수로 가진 생성자 자동 생성
public class HelloResponseDTO {
    private final String name;
    private final int amount;
    private final String address;
}
