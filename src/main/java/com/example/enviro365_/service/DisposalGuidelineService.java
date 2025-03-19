package com.example.enviro365_.service;

import com.example.enviro365_.model.DisposalGuideline;
import com.example.enviro365_.repository.DisposalGuidelineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposalGuidelineService {

    private final DisposalGuidelineRepository disposalGuidelineRepository;

    public DisposalGuidelineService(DisposalGuidelineRepository disposalGuidelineRepository) {
        this.disposalGuidelineRepository = disposalGuidelineRepository;
    }


    public DisposalGuideline saveDisposalGuideline(DisposalGuideline disposalGuideline){
        return disposalGuidelineRepository.save(disposalGuideline);
    }

    public List<DisposalGuideline> getAllDisposalGuidelines(){
        return disposalGuidelineRepository.findAll();
    }

    public DisposalGuideline findDisposalGuidelineById(int id){
        return disposalGuidelineRepository.findById(id).
                orElseThrow(() -> new NullPointerException("Id not found"));
    }

    public DisposalGuideline updateDisposalGuideline(int id, DisposalGuideline disposalGuideline){
        DisposalGuideline existingDisposalGuideline = findDisposalGuidelineById(id);
        existingDisposalGuideline.setDisposalMethod(disposalGuideline.getDisposalMethod());
        existingDisposalGuideline.setLocation(disposalGuideline.getLocation());
        return disposalGuidelineRepository.save(existingDisposalGuideline);
    }

    public void deleteDisposalGuidelineById(int id){
        disposalGuidelineRepository.deleteById(id);
    }

    public void deleteAllDisposalGuidelines(){
        disposalGuidelineRepository.deleteAll();
    }

}
