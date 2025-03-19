package com.enviro.assessment.grad001.KaraboMashao.controller;


import com.enviro.assessment.grad001.KaraboMashao.model.DisposalGuideline;
import com.enviro.assessment.grad001.KaraboMashao.service.DisposalGuidelineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    private final DisposalGuidelineService disposalGuidelineService;

    public DisposalGuidelineController(DisposalGuidelineService disposalGuidelineService) {
        this.disposalGuidelineService = disposalGuidelineService;
    }

    @PostMapping()
    public DisposalGuideline saveDisposalGuideline(@RequestBody DisposalGuideline disposalGuideline){
        return disposalGuidelineService.saveDisposalGuideline(disposalGuideline);
    }

    @PostMapping("/{id}")
    public DisposalGuideline updateDisposalGuideline(@PathVariable int id, @RequestBody DisposalGuideline disposalGuideline){
        return disposalGuidelineService.updateDisposalGuideline(id, disposalGuideline);
    }

    @GetMapping()
    public List<DisposalGuideline> getAllDisposalGuidelines(){
        return disposalGuidelineService.getAllDisposalGuidelines();
    }

    @GetMapping("/{id}")
    public DisposalGuideline disposalGuideline(@PathVariable int id){
        return disposalGuidelineService.findDisposalGuidelineById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteWasteTypeById(@PathVariable int id){
        disposalGuidelineService.deleteDisposalGuidelineById(id);
    }

    @DeleteMapping()
    public void deleteAllDisposalGuidelines(){
        disposalGuidelineService.deleteAllDisposalGuidelines();
    }
}
