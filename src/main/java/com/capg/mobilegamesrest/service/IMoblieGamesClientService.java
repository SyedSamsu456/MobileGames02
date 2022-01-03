package com.capg.mobilegamesrest.service;

import com.capg.mobilegamesrest.beans.MobileGames;
import com.capg.mobilegamesrest.dto.MobileGamesRestDTO;

public interface IMoblieGamesClientService {
	
	MobileGamesRestDTO getGameByID(long id);
	
	MobileGamesRestDTO addMobileGame(MobileGames mobileGame);
	
	

}
