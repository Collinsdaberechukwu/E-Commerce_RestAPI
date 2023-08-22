package com.mocos.mocos.repository;

import com.mocos.mocos.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AdminRepo extends JpaRepository<Admin,Long> {
}
