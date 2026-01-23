package org.apple.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MemberController {
  private final MemberService memberService;

  @GetMapping("/register")
  String register(){
    return("/register");
  }

  @PostMapping("/adduser")
  String adduser(@RequestParam Map<String, String> formData){
    String username = formData.get("username");
    String password = formData.get("password");
    String displayName = formData.get("displayName");
//    System.out.println(username);
//    System.out.println(password);
    memberService.addUser(username, password, displayName);
    return("redirect:/list");
  }

}
