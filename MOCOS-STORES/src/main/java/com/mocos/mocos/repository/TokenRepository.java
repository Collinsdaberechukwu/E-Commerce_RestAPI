package com.mocos.mocos.repository;

import com.mocos.mocos.model.AuthenticationToken;
import com.mocos.mocos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {
    AuthenticationToken findByUser(User user);
}
