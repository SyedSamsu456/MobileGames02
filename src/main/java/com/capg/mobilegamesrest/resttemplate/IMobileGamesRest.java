package com.capg.mobilegamesrest.resttemplate;

import com.capg.mobilegamesrest.beans.MobileGames;
import com.capg.mobilegamesrest.dto.MobileGamesRestDTO;

public interface IMobileGamesRest {
	
	MobileGamesRestDTO getMobileGame(long id);

	MobileGamesRestDTO addMobileGame(MobileGames mobileGame);

	String getHealth();


}
