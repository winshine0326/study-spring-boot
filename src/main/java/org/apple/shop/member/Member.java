package org.apple.shop.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Member {
  @Id
  private String username;

  private String password;

  @Column(name = "displayName")
  private String displayName;
}
