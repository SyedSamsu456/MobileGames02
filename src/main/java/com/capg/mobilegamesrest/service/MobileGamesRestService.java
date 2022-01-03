package com.capg.mobilegamesrest.service;

import static com.capg.mobilegamesrest.utils.MobileGamesRestConstants.LOGGER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.mobilegamesrest.beans.MobileGames;
import com.capg.mobilegamesrest.dto.MobileGamesRestDTO;
import com.capg.mobilegamesrest.resttemplate.IMobileGamesRest;

@Service
public class MobileGamesRestService implements IMobileGamesRestService {
	
	@Autowired
	private IMobileGamesRest mobileGamesRest;

	@Override
	public MobileGamesRestDTO addMobileGame(MobileGames mobileGames) {
		
		LOGGER.info("Mobile Games Rest Service: addMobileGame method is initialized and executed");
		
		return mobileGamesRest.addMobileGame(mobileGames);
	}

	@Override
	public MobileGamesRestDTO getMobileGame(long id) {
		

		LOGGER.info("Mobile Games Rest Service: getMobileGame method is initialized and executed");
		
		return mobileGamesRest.getMobileGame(id);
	}
	
	@Override
	public String getHealth() {
		

		LOGGER.info("MobileGamesService: getHealth method is initialized");
		
		return mobileGamesRest.getHealth();
	}



}
