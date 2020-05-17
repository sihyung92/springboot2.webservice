package com.sihyung.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//멤버 변수들에 대한 게터 자동생성
//멤버 변수들에 대한 생성자 자동생성
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
