package com.capg.mobilegamesrest.dto;

import org.springframework.stereotype.Component;

@Component
public class MobileGamesRestDTO {
	
	private long id;
	
	private String gameName;
	
	private int gameRating;
	
	public MobileGamesRestDTO() {
		super();
	}

	public MobileGamesRestDTO(long id, String gameName, int gameRating) {
		super();
		this.id = id;
		this.gameName = gameName;
		this.gameRating = gameRating;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public int getGameRating() {
		return gameRating;
	}

	public void setGameRating(int gameRating) {
		this.gameRating = gameRating;
	}

	

}
