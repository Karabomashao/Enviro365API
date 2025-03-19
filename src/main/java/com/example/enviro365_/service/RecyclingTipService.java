package com.example.enviro365_.service;


import com.example.enviro365_.model.RecyclingTip;
import com.example.enviro365_.model.WasteType;
import com.example.enviro365_.repository.RecyclingTipRepository;
import com.example.enviro365_.repository.WasteTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipService {

    private RecyclingTipRepository recyclingTipRepository;
    private WasteTypeRepository wasteTypeRepository;


    public RecyclingTipService(RecyclingTipRepository recyclingTipRepository, WasteTypeRepository wasteTypeRepository){
        this.recyclingTipRepository = recyclingTipRepository;
        this.wasteTypeRepository = wasteTypeRepository;
    }

    public List<RecyclingTip> findAllRecyclingTips(){
        return recyclingTipRepository.findAll();
    }

    public RecyclingTip findRecyclingTipById(int id){
        return recyclingTipRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Id not found"));
    }

    public RecyclingTip saveRecyclingTip(RecyclingTip recyclingTip){
        return recyclingTipRepository.save(recyclingTip);
    }

    public RecyclingTip updateRecyclingTip(int id, RecyclingTip updateRecyclingTip){
        RecyclingTip existingRecyclingTip = findRecyclingTipById(id);
        existingRecyclingTip.setAdditionalInfo(updateRecyclingTip.getAdditionalInfo());
        existingRecyclingTip.setMaterial(updateRecyclingTip.getMaterial());
        existingRecyclingTip.setTipDescription(updateRecyclingTip.getTipDescription());
        return recyclingTipRepository.save(existingRecyclingTip);
    }

    public void deleteRecyclingTipById(int id){
        findRecyclingTipById(id);
        recyclingTipRepository.deleteById(id);
    }

    public void deleteAllRecyclingTips(){
        recyclingTipRepository.deleteAll();
    }

}
