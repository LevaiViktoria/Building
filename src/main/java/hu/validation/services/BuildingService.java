package hu.validation.services;


import hu.validation.domain.Building;
import hu.validation.exceptions.BuildingAlreadyExistException;
import hu.validation.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository repository;

    public List<Building> getBuilding() {
        return repository.findAll();
    }

    public Building creaeBuilding(Building building) {
        if (isUnique(building.getAddress())){
            return repository.save(building);
        }
        throw new BuildingAlreadyExistException(building.getAddress());
    }

    private boolean isUnique(String address) {
        List<Building> buildings = repository.findAll();
        for (Building building : buildings) {
            if (building.getAddress().equalsIgnoreCase(address));
                return false;
            }
        return true;
    }
}
