package org.apple.shop;

import lombok.Getter;

public class Homework {
  private String name;
  @Getter
  private int age;

  public void 한살더하기() {
    this.age = age+1;
  }
  public void 나이설정(int age){
    if (age >= 100 || age < 0){
      System.out.println("잘못된 나이 입력입니다.");
    } else{
      this.age = age;
    }
  }
}
