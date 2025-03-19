package com.enviro.assessment.grad001.KaraboMashao;

import com.enviro.assessment.grad001.KaraboMashao.model.Category;
import com.enviro.assessment.grad001.KaraboMashao.model.DisposalGuideline;
import com.enviro.assessment.grad001.KaraboMashao.model.RecyclingTip;
import com.enviro.assessment.grad001.KaraboMashao.model.WasteType;
import com.enviro.assessment.grad001.KaraboMashao.repository.CategoryRepository;
import com.enviro.assessment.grad001.KaraboMashao.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.KaraboMashao.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.KaraboMashao.repository.WasteTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Enviro365Application {

	public static void main(String[] args) {
		SpringApplication.run(Enviro365Application.class, args);
	}


	@Bean
	CommandLineRunner initializeDatabase(
			CategoryRepository categoryRepository,
			WasteTypeRepository wasteTypeRepository,
			DisposalGuidelineRepository disposalGuidelineRepository,
			RecyclingTipRepository recyclingTipRepository){
		return args -> {


			Category recyclable = categoryRepository.save(new Category("Recyclable",
					"Materials that can be processed and reused"));
			Category hazardous = categoryRepository.save(new Category("Hazardous",
					"Waste that poses substantial or potential threats to public health or the environment"));
			Category organic = categoryRepository.save(new Category("Organic",
					"Biodegradable waste that comes from living organisms, such as food scraps, yard clippings, and paper."));

			WasteType paper = wasteTypeRepository.save(new WasteType("Paper", "newspapers, magazines, cardboard", recyclable));
			WasteType battery = wasteTypeRepository.save(new WasteType("Battery", "lithium-ion", hazardous));
			WasteType yardTrimmings = wasteTypeRepository.save(new WasteType("Yard Trimmings", "grass", organic));

			DisposalGuideline batteryDisposal = disposalGuidelineRepository.save(new DisposalGuideline("Should not be thrown in regular trash",
					"Dedicated recycling centers", battery));


			RecyclingTip recyclingTip = recyclingTipRepository.save(new RecyclingTip(battery,
					"Sort batteries into categories like single-use.",
					"Never dispose of batteries in regular household trash as they can leak harmful chemicals into the environment.",
					"alkaline"));

//			RecyclingTip recyclingTip = new RecyclingTip();
//			recyclingTip.setWasteType(battery);
//			recyclingTip.setTipDescription("Sort batteries into categories like single-use.");
//			recyclingTip.setAdditionalInfo("Never dispose of batteries in regular household trash as they can leak harmful chemicals into the environment.");
//			recyclingTip.setMaterial("alkaline");
//
//			recyclingTipRepository.save(recyclingTip);
		};
	}

}
