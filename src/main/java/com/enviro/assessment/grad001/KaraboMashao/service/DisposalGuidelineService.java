package com.enviro.assessment.grad001.KaraboMashao.service;


import com.enviro.assessment.grad001.KaraboMashao.model.DisposalGuideline;
import com.enviro.assessment.grad001.KaraboMashao.repository.DisposalGuidelineRepository;
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
        findDisposalGuidelineById(id);
        disposalGuidelineRepository.deleteById(id);
    }

    public void deleteAllDisposalGuidelines(){
        disposalGuidelineRepository.deleteAll();
    }

}
