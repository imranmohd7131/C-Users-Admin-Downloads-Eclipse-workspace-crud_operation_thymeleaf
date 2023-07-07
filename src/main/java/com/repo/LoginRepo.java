package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Login;


@Repository
public interface LoginRepo extends JpaRepository<Login, String>{
	
	@Query(value="select email from tbl_login where email=?1 and pswd=?2",nativeQuery = true)
	public Login findByEmail(String email,String pswd);
	
	//Login findByPswd(String pswd);
}
