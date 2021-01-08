package com.imnu.mm.controller;

import java.util.ArrayList;
import java.util.List;

public class PagingController<K> {
	public List pagingController(List<K> List,Integer pageNum){
		List<K> pageList = new ArrayList<K>();
		Integer pageCount = 10;
		Integer startPage = (pageNum-1)*pageCount;
		Integer lastPage = startPage + pageCount;
		for(int i=startPage; i<lastPage; i++) {
			pageList.add((K)List.get(i));
		}
		return pageList;
	}

}
