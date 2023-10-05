package com.nissan.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.entity.User;
@Repository
public interface IUserRepository extends CrudRepository<User, Integer> {
	@Query("from User where userName=?1 and password=?2")
	public User findUserByNameAndPassword(String userName, String password);

}
