package org.apple.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {
  @GetMapping("/")
  @ResponseBody
  String hello(){
    return "index.html";
  }

  @GetMapping("/mypage")
  @ResponseBody
  String mypage(){
    return"마이페이지입니다~";
  }
}
