package com.telstra.codechallenge.repousers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitHubUserController {
	
	@GetMapping("/account")
	public String getAccountsWithZeroFollowers() {
		return "no";
	}

}
