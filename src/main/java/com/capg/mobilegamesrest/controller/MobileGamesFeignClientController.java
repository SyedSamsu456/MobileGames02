package com.capg.mobilegamesrest.controller;

import static com.capg.mobilegamesrest.utils.MobileGamesRestConstants.GET;
import static com.capg.mobilegamesrest.utils.MobileGamesRestConstants.LOGGER;
import static com.capg.mobilegamesrest.utils.MobileGamesRestConstants.POST;
import static com.capg.mobilegamesrest.utils.MobileGamesRestConstants.FEIGN_API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.mobilegamesrest.beans.MobileGames;
import com.capg.mobilegamesrest.dto.MobileGamesRestDTO;
import com.capg.mobilegamesrest.service.IMoblieGamesClientService;

import feign.FeignException;

@RestController
@RefreshScope
@RequestMapping(FEIGN_API)
public class MobileGamesFeignClientController {
	
	@Autowired
	private IMoblieGamesClientService service;

	@GetMapping(GET)
	public MobileGamesRestDTO getGameByID(@PathVariable long id) {
		
		LOGGER.info("Mobile Games Client Controller: getMobileGame method is initialized and executed");
		
		return service.getGameByID(id);
	}

	@PostMapping(POST)
	public MobileGamesRestDTO addMobileGame(@RequestBody MobileGames mobileGame) {
		
		LOGGER.info("Mobile Games Client Controller: addMobileGame method is initialized and executed");
		
		return service.addMobileGame(mobileGame);
	}
	
	@ExceptionHandler(value = FeignException.class)
	public ResponseEntity<Object> exceptionHttpClientErrorException(FeignException exception){
		
		LOGGER.info("Mobile Games Rest Controller Exception :Feign Exception is handled");
		
		return new ResponseEntity<>(exception.getMessage().substring(120), HttpStatus.NOT_ACCEPTABLE);
	}
	
}
