package org.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

  private final ItemRepository itemRepository;

  @GetMapping("/list")
  String list(Model model){
    List<Item> result = itemRepository.findAll();
//    System.out.println(result.get(0).getTitle());
    var a = new Item();
//    System.out.println(a);

    a.setTitle("adsf");
//    System.out.println(a);

    model.addAttribute("items", result);
    return "list.html";
  }

  @GetMapping("/write")
  String write(){
    return "write.html";
  }

  @PostMapping("/add")
  String addPost(@RequestParam Map<String, String> formData){
    String title = (String) formData.get("title");
    Integer price = Integer.valueOf((String) formData.get("price"));

    System.out.println(title);
    System.out.println(price);
    Item item = new Item();
    item.setTitle(title);
    item.setPrice(price);
    itemRepository.save(item);
    return "redirect:/list";
  }
//  @PostMapping("/add") //참고
//  String addPost(@ModelAttribute Item item){
//    itemRepository.save(item);
//    return "redirect:/list";
//  }

  @GetMapping("/detail/{id}")
  String detail(@PathVariable Integer id, Model model){

    Optional<Item> result = itemRepository.findById(id.longValue());
    result.ifPresent(System.out::println);

    model.addAttribute("item", result.get());
    return "detail.html";
  }
}
