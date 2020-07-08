package com.telstra.codechallenge.repousers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitHubController {

	private RepoUserService repoUserService;

	public GitHubController(RepoUserService repoUserService) {
		this.repoUserService = repoUserService;
	}

	@GetMapping(path = "/accounts/nofollower")
	public List<RepoAccountsDTO> getOldestAccounts(@Valid @RequestParam int count) {

		return Arrays.asList(repoUserService.getOldestAccounts(count)).stream().limit(count)
				.map(repo -> new RepoAccountsDTO(repo.getId(), repo.getHtml_url(), repo.getOwner().getLogin()))
				.collect(Collectors.toList());
	}

}
