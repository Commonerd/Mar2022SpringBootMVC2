package spring.service;

import org.springframework.stereotype.Service;

@Service
public class SearchService {
	public SearchResult search(SearchCommand command) {
		return new SearchResult();
	}
}
