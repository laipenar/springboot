package com.lrp.demo.repository;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lrp.demo.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

		 
	User findUserByEmail(String email);
		
	@Query("select u from User u where u.email = :email and u.passwrd = :passwrd ")
	User findUserByEmailAndPasswrd(String email, String passwrd);
	
}
