package com.example.enviro365_.repository;

import com.example.enviro365_.model.WasteType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface WasteTypeRepository extends JpaRepository<WasteType, Integer> {

}
