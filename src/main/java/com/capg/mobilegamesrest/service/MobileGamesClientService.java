package com.capg.mobilegamesrest.service;

import static com.capg.mobilegamesrest.utils.MobileGamesRestConstants.LOGGER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.mobilegamesrest.beans.MobileGames;
import com.capg.mobilegamesrest.dto.MobileGamesRestDTO;
import com.capg.mobilegamesrest.feignclient.IMobileGamesFeignClient;

@Service
public class MobileGamesClientService implements IMoblieGamesClientService {

	@Autowired
	private IMobileGamesFeignClient client;
	
	@Override
	public MobileGamesRestDTO getGameByID(long id) {
		
		LOGGER.info("Mobile Games Client Service: getGameByID method is initialized and executed");

		return client.getGameByID(id);
	}

	@Override
	public MobileGamesRestDTO addMobileGame(MobileGames mobileGame) {
		
		LOGGER.info("Mobile Games Client Service: addGameByID method is initialized and executed");

		return client.addMobileGame(mobileGame);
	}

}
