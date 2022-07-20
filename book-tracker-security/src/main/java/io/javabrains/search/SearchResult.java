package io.javabrains.search;

import java.util.List;

import lombok.Data;

@Data
public class SearchResult {
	
	private int numFound;	
	private List<SearchResultBook> docs;
	
	
	

}
