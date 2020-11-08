package com.mindtree.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.docker.entity.User;

@Repository
public interface LoginRepo extends JpaRepository<User, Integer> {

	public User findByEmailId(String emailId);

}
