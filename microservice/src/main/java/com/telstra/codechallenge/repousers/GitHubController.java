package com.telstra.codechallenge.repousers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.codechallenge.repousers.RepoUser.RepoAccounts;

@RestController
public class GitHubController {

	private RepoUserService repoUserService;

	public GitHubController(RepoUserService repoUserService) {
		this.repoUserService = repoUserService;
	}

	@GetMapping(path = "/accounts/nofollower")
	public List<RepoAccounts> getOldestAccounts(@RequestParam int count) {
		
		return Arrays.asList(repoUserService.getOldestAccounts(count)).stream().limit(count).collect(Collectors.toList());
	}


}
