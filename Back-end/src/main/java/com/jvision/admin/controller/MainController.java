package com.jvision.admin.controller;

import com.jvision.admin.dto.HelloResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController// 스프링 MVC 컨트롤러 지정 (JSON 형태로 객체 데이터 반환)
public class MainController {

    @GetMapping("/hello")// Get 방식으로 데이터 전송
    public String hello(){
        return "hello";
    }

    @GetMapping("/admin")// Get 방식으로 데이터 전송
    public String admin(){
        return "admin";
    }

    @GetMapping("/hello/dto")// Get 방식으로 데이터 전송
    public HelloResponseDTO helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount,
                                     @RequestParam("address") String address){
        HelloResponseDTO dto = new HelloResponseDTO(name,amount,address);
        return dto;
    }
}
