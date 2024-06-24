package com.example.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mobile.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
