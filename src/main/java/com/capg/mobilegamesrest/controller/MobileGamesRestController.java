package com.capg.mobilegamesrest.controller;

import static com.capg.mobilegamesrest.utils.MobileGamesRestConstants.GET;
import static com.capg.mobilegamesrest.utils.MobileGamesRestConstants.LOGGER;
import static com.capg.mobilegamesrest.utils.MobileGamesRestConstants.POST;
import static com.capg.mobilegamesrest.utils.MobileGamesRestConstants.REST_API;
import static com.capg.mobilegamesrest.utils.MobileGamesRestConstants.REST_HEALTH;

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
import org.springframework.web.client.HttpClientErrorException;

import com.capg.mobilegamesrest.beans.MobileGames;
import com.capg.mobilegamesrest.dto.MobileGamesRestDTO;
import com.capg.mobilegamesrest.service.IMobileGamesRestService;

@RestController
@RefreshScope
@RequestMapping(REST_API)
public class MobileGamesRestController {

	@Autowired
	private IMobileGamesRestService mobileGamesService;

	@PostMapping(POST)
	public ResponseEntity<MobileGamesRestDTO> addMobileGame(@RequestBody MobileGames mobileGame) {

		LOGGER.info("Mobile Games Rest Controller: addMobileGame method is initialized");

		MobileGamesRestDTO mobileGamesDTO = mobileGamesService.addMobileGame(mobileGame);
		
		LOGGER.info("Mobile Games Rest Controller: addMobileGame method is executed");

		return new ResponseEntity<MobileGamesRestDTO>(mobileGamesDTO, HttpStatus.OK);

	}

	@GetMapping(GET)
	public ResponseEntity<MobileGamesRestDTO> getMobileGame(@PathVariable long id) {

		LOGGER.info("Mobile Games Rest Controller: getMobileGame method is initialized");
		
		MobileGamesRestDTO mobileGamesDTO =mobileGamesService.getMobileGame(id);
		
		LOGGER.info("Mobile Games Rest Controller: getMobileGame method is executed");

		return new ResponseEntity<MobileGamesRestDTO>(mobileGamesDTO, HttpStatus.OK);
	}
	
	@GetMapping(REST_HEALTH)
	public ResponseEntity<String> getHealth(){
		LOGGER.info("MobileGamesRestController: getHealthmethod is initialized");
		
		String health = mobileGamesService.getHealth();
		
		return new ResponseEntity<String>(health, HttpStatus.OK);
			
	}

	@ExceptionHandler(value = HttpClientErrorException.class)
	public ResponseEntity<Object> exceptionHttpClientErrorException(HttpClientErrorException exception){
		
		LOGGER.info("Mobile Games Rest Controller Exception : Http Client Error Exception is handled");
		
		return new ResponseEntity<>(exception.getMessage().substring(6), HttpStatus.NOT_ACCEPTABLE);
	}

}
