package com.example.rentcar.dao;

import com.example.rentcar.model.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserinfoDao extends JpaRepository<Userinfo,Integer> {
}
