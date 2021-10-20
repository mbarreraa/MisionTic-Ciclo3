package com.boat.service;

import com.boat.model.Boat;
import com.boat.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoatService {

    @Autowired
    private BoatRepository boatRepository;

    public List<Boat> getAll() {
        return boatRepository.getAll();
    }

    public Optional<Boat> getBoat(int id) {
        return boatRepository.getBoat(id);
    }

    public Boat save(Boat boat) {
        if (boat.getId() == null) {
            return boatRepository.save(boat);
        } else {
            Optional<Boat> e = boatRepository.getBoat(boat.getId());
            if (e.isEmpty()) {
                return boatRepository.save(boat);
            } else {
                return boat;
            }
        }
    }
}
