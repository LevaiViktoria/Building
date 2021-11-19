package hu.validation.controllers;

import hu.validation.domain.Building;
import hu.validation.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/buildings")
public class BuildingController {

    @Autowired
    private BuildingService service;


    @GetMapping("")
    private List<Building> getBuildings(){
        return service.getBuilding();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    private Building createBuilding(@Valid @RequestBody Building building){
        return service.creaeBuilding(building);
    }

}
