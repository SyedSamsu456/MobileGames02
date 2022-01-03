package com.capg.mobilegamesrest.resttemplate;

import static com.capg.mobilegamesrest.utils.MobileGamesRestConstants.LOGGER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.capg.mobilegamesrest.beans.MobileGames;
import com.capg.mobilegamesrest.dto.MobileGamesRestDTO;
import com.capg.mobilegamesrest.utils.MobileGamesRestConstants;

@Component
public class MobileGamesRest implements IMobileGamesRest {

	@Autowired
	private MobileGamesRestConstants constant;


	@Override
	public MobileGamesRestDTO getMobileGame(long id) {

		LOGGER.info("Mobile Games Rest: getMobileGame method is initialized");

		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<MobileGamesRestDTO> response = restTemplate.getForEntity(constant.REST_URL + constant.GET_PATH + id, MobileGamesRestDTO.class);

		LOGGER.info("Mobile Games Rest: getMobileGame method is executed");

		return response.getBody();
	}

	@Override
	public MobileGamesRestDTO addMobileGame(MobileGames mobileGame) {

		LOGGER.info("Mobile Games Rest: addMobileGame method is initialized");
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity< MobileGamesRestDTO> response = restTemplate.postForEntity(constant.REST_URL+constant.POST_PATH, mobileGame, MobileGamesRestDTO.class);
		
		LOGGER.info("Mobile Games Rest: addMobileGame method is executed");
		
		return response.getBody();
	}

	@Override
	public String getHealth() {

		LOGGER.info("MobileGamesRest: getHealth method is initialized");

		RestTemplate restTemplate = new RestTemplate();

		String response = restTemplate.getForObject(constant.HEALTH_PATH, String.class);

		return response;
	}

}
