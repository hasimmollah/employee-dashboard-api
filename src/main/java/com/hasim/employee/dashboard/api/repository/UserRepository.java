package com.hasim.employee.dashboard.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hasim.employee.dashboard.api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
