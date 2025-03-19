package com.enviro.assessment.grad001.KaraboMashao.service;


import com.enviro.assessment.grad001.KaraboMashao.model.WasteType;
import com.enviro.assessment.grad001.KaraboMashao.repository.WasteTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteTypeService {

    private final WasteTypeRepository wasteTypeRepository;

    public WasteTypeService(WasteTypeRepository wasteTypeRepository) {
        this.wasteTypeRepository = wasteTypeRepository;
    }

    public WasteType saveWasteType(WasteType wasteType){
        return wasteTypeRepository.save(wasteType);
    }

    public List<WasteType> getAllWasteTypes(){
        return wasteTypeRepository.findAll();
    }

    public WasteType findWasteTypeById(int id){
        return wasteTypeRepository.findById(id).
                orElseThrow(() -> new NullPointerException("Id not found"));
    }

    public WasteType updateWasteType(int id, WasteType wasteType){
        WasteType existingWasteType = findWasteTypeById(id);
        existingWasteType.setExample(wasteType.getExample());
        existingWasteType.setWasteType(wasteType.getWasteType());
        return wasteTypeRepository.save(existingWasteType);
    }

    public void deleteWasteTypeById(int id){
        findWasteTypeById(id);
        wasteTypeRepository.deleteById(id);
    }

    public void deleteAllWasteTypes(){
        wasteTypeRepository.deleteAll();
    }

}
