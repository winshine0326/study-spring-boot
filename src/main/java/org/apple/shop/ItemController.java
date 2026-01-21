package org.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  private final ItemService itemService;

  @GetMapping("/list")
  String list(Model model){

    List<Item> result = itemService.getItemList();
//    System.out.println(result.get(0).getTitle());
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
//    System.out.println(title);
//    System.out.println(price);

    itemService.saveItem(title,price);

    return "redirect:/list";
  }

//  @PostMapping("/add") //참고
//  String addPost(@ModelAttribute Item item){
//    itemRepository.save(item);
//    return "redirect:/list";
//  }

//  @GetMapping("/detail/{id}")
//  String detail(@PathVariable Integer id, Model model){
//
//    try{
//      Optional<Item> result = itemRepository.findById(id.longValue());
//      if (result.isPresent()){
//        model.addAttribute("item", result.get());
//        return "detail.html";
//      }else{
//        return "redirect:/list";
//      }
//    } catch(Exception e){
//      System.out.println(e.getMessage()); // login Library 추천
////      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("니잘못임"); // REST API 개발 시
//      return "redirect:/list";
//    } // try catch 사용

  @GetMapping("/detail/{id}")
  String detail(@PathVariable Long id, Model model){
    Optional<Item> result = itemService.getItem(id);
      if (result.isPresent()){
        model.addAttribute("item", result.get());
        return "detail.html";
      }else{
        return "redirect:/list";
      }
  }

//  @ExceptionHandler(Exception.class)
//  public void handler(){
//    return ResponseEntity.status().body();
//  } // controller 안에 모든 api에서 error가 나면 실행(REST API 만들 떄 편함)
}
