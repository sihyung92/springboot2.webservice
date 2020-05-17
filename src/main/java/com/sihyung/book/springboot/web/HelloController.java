package com.sihyung.book.springboot.web;

import com.sihyung.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어주는 어노테이션
// Spring에서 @ResponseBody를 각 메소드마다 설정해주던 것을 한번에 사용할 수 있게 해준다.
@RestController
public class HelloController {
    //HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어 준다.
    //Spring에서의 @RequestMapping(method=RequestMethod.GET) 과 동일
    @GetMapping
    public HelloResponseDto hello(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
