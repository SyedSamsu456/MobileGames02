package com.capg.mobilegamesrest.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MobileGamesRestConstants {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(MobileGamesRestConstants.class);
	
	public static final String NULLMESSSAGE = " Game name should not be null";
	public static final String BLANKMESSSAGE = " Game name should not be blank";
	public static final String MINMESSSAGE = " Game rating should be 1 to 10";
	public static final String MAXMESSSAGE = " Game rating should be 1 to 10";
	
	public static final String REST_API = "${restAPI}";
	public static final String FEIGN_API = "${feignAPI}";
	public static final String GET = "${GET}";
	public static final String POST = "${POST}";
	public static final String REST_HEALTH = "${restHEALTH}";
	
	public static final String FEIGN_URL = "${feignurl}";
	
	@Value("${resturl}")
	public String REST_URL;
	
	@Value("${getPath}")
	public String GET_PATH;
	
	@Value("${addPath}")
	public String POST_PATH;
	
	@Value("${getHealth}")
	public String HEALTH_PATH;
	
}
