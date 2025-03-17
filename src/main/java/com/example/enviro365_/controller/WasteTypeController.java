package com.example.enviro365_.controller;


import com.example.enviro365_.model.WasteType;
import com.example.enviro365_.service.WasteTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waste-types")
public class WasteTypeController {

    private final WasteTypeService wasteTypeService;

    public WasteTypeController(WasteTypeService wasteTypeService) {
        this.wasteTypeService = wasteTypeService;
    }

    @PostMapping()
    public WasteType saveWasteType(@RequestBody WasteType wasteType){
        return wasteTypeService.saveWasteType(wasteType);
    }

    @PostMapping("/{id}")
    public WasteType updateWasteType(@PathVariable int id, @RequestBody WasteType wasteType){
        return wasteTypeService.updateWasteType(id, wasteType);
    }

    @GetMapping()
    public List<WasteType> getAllWasteTypes(){
        return wasteTypeService.getAllWasteTypes();
    }

    @GetMapping("/{id}")
    public WasteType wasteType(@PathVariable int id){
        return wasteTypeService.findWasteTypeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteWasteTypeById(@PathVariable int id){
        wasteTypeService.deleteWasteTypeById(id);
    }

    @DeleteMapping()
    public void deleteAllWasteTypes(){
        wasteTypeService.deleteAllWasteTypes();
    }

}
