package com.boat.controller;

import com.boat.model.Boat;
import com.boat.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/Boat")
public class BoatController {

    @Autowired
    private BoatService boatService;
    @GetMapping("/all")
    public List<Boat> getAll(){
        return boatService.getAll();
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat save(@RequestBody Boat boat) {
        return boatService.save(boat);
    }
}
