package org.apple.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor @Transactional
public class MemberService {

  private final MemberRepository memberRepository;

  public void addUser(String username, String password, String displayName){
    var encoder = new BCryptPasswordEncoder();
    String hashedPassword = encoder.encode(password);

    Member member = new Member();
    member.setUsername(username);
    member.setPassword(hashedPassword);
    member.setDisplayName(displayName);

    memberRepository.save(member);
  }
}
