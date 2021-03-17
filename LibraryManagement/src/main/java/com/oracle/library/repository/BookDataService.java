package com.oracle.library.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import com.oracle.library.BookDataSpecification;
import com.oracle.library.BookDataSpecificationsBuilder;
import com.oracle.library.SearchCriteria;
import com.oracle.library.model.BookData;

@Service
public class BookDataService {

	@Autowired
	private BookDataRepository bookDataRepository;

	public List<BookData> getAllData() {
		return bookDataRepository.findAll();
	}

	public List<BookData> test() {
		BookDataSpecification spec1 = new BookDataSpecification(
				new SearchCriteria("issueUsername", ":", "sampleUser"));
		BookDataSpecification spec2 = new BookDataSpecification(
				new SearchCriteria("lastName", ":", "doe"));

		List<BookData> results = bookDataRepository.findAll(Specifications.where(spec1).and(spec2));
		return results;
	}

	public List<BookData> findWithSearch(List<SearchCriteria> params) {
		BookDataSpecificationsBuilder builder = new BookDataSpecificationsBuilder();
		params.forEach(param->{
			builder.with(param.getKey(), param.getOperation(), param.getValue());
		});
        Specification<BookData> spec = builder.build();
        return bookDataRepository.findAll(spec);
	}
}
