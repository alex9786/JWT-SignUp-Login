package com.example.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.mobile.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


@Query(value="select * from user where emailId=:emailId or password=:password",nativeQuery = true)
	User findOneByEmailIdPassword(String emailId, String password);

}
