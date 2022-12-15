package com.wsproject.webserviceproject.repo;

import com.wsproject.webserviceproject.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepo extends JpaRepository<House, Integer> {

}