package org.apple.shop;

import jakarta.persistence.*;

@Entity
public class Item {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Column(length = 1000)
  public String title;
  public Integer price;
}