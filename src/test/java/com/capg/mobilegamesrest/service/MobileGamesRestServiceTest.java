package com.capg.mobilegamesrest.service;

import static com.capg.mobilegamesrest.utils.MobileGamesRestConstants.LOGGER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capg.mobilegamesrest.beans.MobileGames;
import com.capg.mobilegamesrest.dto.MobileGamesRestDTO;
import com.capg.mobilegamesrest.resttemplate.IMobileGamesRest;

@ExtendWith(MockitoExtension.class)
class MobileGamesRestServiceTest {
	
	@Mock
	private IMobileGamesRest mobileGamesRest;
	
	@InjectMocks
    private MobileGamesRestService service;
	
	private MobileGames mg = mock(MobileGames.class);
	
	private MobileGamesRestDTO mgDTO = mock(MobileGamesRestDTO.class);
	
	private String health ;
	
	@Test
	void testAddMobileGame() {
		
		LOGGER.info("Mobile Games Rest Service Test: testaddMobileGame method is initialized");
		
		when(mobileGamesRest.addMobileGame(mg)).thenReturn(mgDTO);
		
		MobileGamesRestDTO mgNewDTO = service.addMobileGame(mg);
		
		assertEquals(mgDTO, mgNewDTO);
		
		LOGGER.info("Mobile Games Rest Service Test: testaddMobileGame method is executed");
		
	}

	@Test
	void testGetMobileGame() {
		
		LOGGER.info("Mobile Games Rest Test: testgetMobileGame method is initialized");
		
		when(mobileGamesRest.getMobileGame(any(Long.class))).thenReturn(mgDTO);
		
		MobileGamesRestDTO mgNewDTO = service.getMobileGame(any(Long.class));
		
		assertEquals(mgDTO, mgNewDTO);
		
		LOGGER.info("Mobile Games Rest Test: testgetMobileGame method is executed");
	}
	
	@Test
	void testGetHealth() {
		
		when(mobileGamesRest.getHealth()).thenReturn(health);
		
		String getHealth =service.getHealth();
		
		assertEquals(health, getHealth);
		
		
	}



}
