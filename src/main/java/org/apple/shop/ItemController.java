package org.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

  private final ItemRepository itemRepositry;

  @GetMapping("/list")
  String list(Model model){
    List<Item> result = itemRepositry.findAll();
    System.out.println(result.get(0).getTitle());
    var a = new Item();
    System.out.println(a);

    a.setTitle("adsf");
    System.out.println(a);

    model.addAttribute("items", result);
    return "list.html";
  }
}
