package org.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NotificController {
  private final NotificRepository notificRepository;

  @GetMapping("/notification")
  String notification(Model model){
    List<Notification> result = notificRepository.findAll();

    System.out.println(result.get(0).date);
    model.addAttribute("items", result);
    return "notification.html";
  }
}
