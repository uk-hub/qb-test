package com.telstra.codechallenge.repousers;

import lombok.Data;

@Data
public class RepoAccountsDTO {
	private Long id;
	private String htmlUrl;
	private String login;
	
	public RepoAccountsDTO(Long id, String htmlUrl, String login) {
		this.id = id;
		this.htmlUrl = htmlUrl;
		this.login = login;
	}
	
	

}
