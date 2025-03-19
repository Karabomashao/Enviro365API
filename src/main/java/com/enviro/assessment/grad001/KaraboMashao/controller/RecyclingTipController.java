package com.enviro.assessment.grad001.KaraboMashao.controller;

import com.enviro.assessment.grad001.KaraboMashao.model.RecyclingTip;
import com.enviro.assessment.grad001.KaraboMashao.service.RecyclingTipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    private final RecyclingTipService recyclingTipService;

    public RecyclingTipController(RecyclingTipService recyclingTipService) {
        this.recyclingTipService = recyclingTipService;
    }


    @PostMapping()
    public RecyclingTip recyclingTip(@RequestBody RecyclingTip recyclingTip){
        return recyclingTipService.saveRecyclingTip(recyclingTip);
    }

    @PostMapping("/{id}")
    public RecyclingTip recyclingTip(@PathVariable int id, @RequestBody RecyclingTip recyclingTip){
        return recyclingTipService.updateRecyclingTip(id, recyclingTip);
    }

    @GetMapping()
    public List<RecyclingTip> getAllRecyclingTips(){
        return recyclingTipService.findAllRecyclingTips();
    }

    @GetMapping("/{id}")
    public RecyclingTip recyclingTip(@PathVariable int id){
        return recyclingTipService.findRecyclingTipById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRecyclingTipById(@PathVariable int id){
        recyclingTipService.deleteRecyclingTipById(id);
    }

    @DeleteMapping()
    public void deleteAllRecyclingTips(){
        recyclingTipService.deleteAllRecyclingTips();
    }
}
