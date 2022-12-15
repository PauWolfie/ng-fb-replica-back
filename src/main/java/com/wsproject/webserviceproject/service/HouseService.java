package com.wsproject.webserviceproject.service;

import com.wsproject.webserviceproject.entity.House;
import com.wsproject.webserviceproject.repo.HouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HouseService {

    //Injecta instacia de forma que serà accessible des de tot el framework (27:22)
    @Autowired
    private HouseRepo houseRepo;

    public House insert(House house) {
        return houseRepo.save(house);
    }

    public House update(House house) {
        return houseRepo.save(house);
    }

    public Optional<House> list(Integer id) {
        return houseRepo.findById(id);
    }

    public void delete(House house) {
        houseRepo.delete(house);
    }
}