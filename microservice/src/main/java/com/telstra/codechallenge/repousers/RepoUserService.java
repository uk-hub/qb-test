package com.telstra.codechallenge.repousers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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

		RepoUser response = restTemplate.getForObject(uriBuilder.toUriString(), RepoUser.class); 

		logger.info("json response : {}", response);

		return response.getItems();
	}


}
