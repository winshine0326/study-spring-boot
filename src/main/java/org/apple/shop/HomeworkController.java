package org.apple.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeworkController {
  @GetMapping("/homework")
  @ResponseBody
  String homework(){
    Homework homework = new Homework();
    homework.나이설정(10);
    System.out.println(homework.getAge());
    homework.한살더하기();
    System.out.println(homework.getAge());
    homework.나이설정(-1);
    System.out.println(homework.getAge());

    return "숙제입니다.";
  }
}
