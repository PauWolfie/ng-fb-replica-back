package com.wsproject.webserviceproject.controller;

import com.wsproject.webserviceproject.entity.House;
import com.wsproject.webserviceproject.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping(value = "")
public class HouseController {
    @Autowired
    private HouseService houseService;

    /**
     * Controller for create or update a specified house. (https://www.baeldung.com/spring-boot-json)
     *
     * @param house JSON attached to the POST request
     * @return JSON of the created entity inside the db
     * @throws URISyntaxException semantically clear HTTP Status
     */
    @PostMapping("/{name}/{address}/{description}")
    public ResponseEntity<House> create(@RequestBody House house)
            throws URISyntaxException {
        House createdHouse = houseService.insert(house);
        if (createdHouse == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{name}")
                    .buildAndExpand(createdHouse.getName())
                    .toUri();

            return ResponseEntity.created(uri).body(createdHouse);
        }
    }

    @PutMapping("/{name}/{address}/{description}")
    public ResponseEntity<House> update(@RequestBody House house) {
        House updatedStudent = houseService.update(house);
        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedStudent);
        }
    }

    @DeleteMapping("/delete")
    public void deleteHouse(@RequestBody House house) {
        houseService.delete(house);
    }

    @GetMapping("/{id}")
    public Optional<House> getHomes(@PathVariable("id") Integer id) {
        return houseService.list(id);
    }
}