package com.capg.mobilegamesrest.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.capg.mobilegamesrest.beans.MobileGames;
import com.capg.mobilegamesrest.dto.MobileGamesRestDTO;

import static com.capg.mobilegamesrest.utils.MobileGamesRestConstants.POST;
import static com.capg.mobilegamesrest.utils.MobileGamesRestConstants.GET;
import static com.capg.mobilegamesrest.utils.MobileGamesRestConstants.FEIGN_URL;

@FeignClient(name = "client", url = FEIGN_URL)
public interface IMobileGamesFeignClient {
	
	@GetMapping(GET)
	MobileGamesRestDTO getGameByID(@PathVariable("id") long id);
	
	@PostMapping(POST)
	MobileGamesRestDTO addMobileGame( MobileGames mobileGame); 

}
