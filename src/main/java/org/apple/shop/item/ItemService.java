package org.apple.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor @Transactional
public class ItemService {

  private final ItemRepository itemRepository;

  public void saveItem(String title, Integer price){

    Item item = new Item();
    item.setTitle(title);
    item.setPrice(price);
    itemRepository.save(item);
  }

  public List<Item> getItemList(){
    return itemRepository.findAll();
  }

  public Optional<Item> getItem(Long id){
    return itemRepository.findById(id);
  }

  public void editItem(Long id, String title, Integer price){
    Optional<Item> optionalItem = itemRepository.findById(id);
    if(optionalItem.isPresent()){
      Item item = optionalItem.get();
      item.setTitle(title);
      item.setPrice(price);
      itemRepository.save(item);
    } else{
      System.out.println("에러남;;");
    }
  }
}
