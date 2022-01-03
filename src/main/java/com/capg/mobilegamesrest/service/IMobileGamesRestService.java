package com.capg.mobilegamesrest.service;

import com.capg.mobilegamesrest.beans.MobileGames;
import com.capg.mobilegamesrest.dto.MobileGamesRestDTO;

public interface IMobileGamesRestService {
	
	MobileGamesRestDTO addMobileGame(MobileGames mobileGames);
	
	MobileGamesRestDTO getMobileGame(long id);

	String getHealth();
}
