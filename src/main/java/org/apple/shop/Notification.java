package org.apple.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Notification {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;
  public String 글제목;
  public Date date;
}
