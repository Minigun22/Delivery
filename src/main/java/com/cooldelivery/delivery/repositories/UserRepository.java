package com.cooldelivery.delivery.repositories;

import com.cooldelivery.delivery.modells.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
