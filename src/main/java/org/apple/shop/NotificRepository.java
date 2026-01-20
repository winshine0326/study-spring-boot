package org.apple.shop;


import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificRepository extends JpaRepository<Notification, Integer> {
}
