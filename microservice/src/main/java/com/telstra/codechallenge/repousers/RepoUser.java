package com.telstra.codechallenge.repousers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.telstra.codechallenge.quotes.Quote;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class RepoUser {

	private RepoAccounts[] items;

	@JsonIgnoreProperties(ignoreUnknown = true)
	@Data
	public static class RepoAccounts {

		private Long id;
		private RepoOwner owner;
		
		private String html_url;


		@JsonIgnoreProperties(ignoreUnknown = true)
		@Data 
		public class RepoOwner {

			private String login;


		}


	}
}
