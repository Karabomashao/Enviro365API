package com.enviro.assessment.grad001.KaraboMashao.repository;

import com.enviro.assessment.grad001.KaraboMashao.model.WasteType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteTypeRepository extends JpaRepository<WasteType, Integer> {

}
