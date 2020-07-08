package com.telstra.codechallenge.repousers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.telstra.codechallenge.repousers.RepoUser.RepoAccounts;

@Service
public class RepoUserService {
	Logger logger = LoggerFactory.getLogger(RepoUserService.class);

	@Value("${github.base.url}")
	private String githubBaseUrl;

	private RestTemplate restTemplate;


	public RepoUserService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}



	public RepoAccounts[] getOldestAccounts(int count) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(githubBaseUrl)
				.queryParam("sort", "joined")
				.queryParam("order", "asc")
				.queryParam("q", "followers:0");

		RepoUser response =null;

		try { 
			response = restTemplate.getForObject(uriBuilder.toUriString(),
				RepoUser.class); 
		} catch (Exception e) { 
			logger.error("Exception : {}", e);
		}

		logger.info("json response : {}", response);

		return response.getItems();
	}


}
