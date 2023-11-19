package com.oracle.library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import com.oracle.library.model.BookData;

public class BookDataSpecificationsBuilder {
    private final List<SearchCriteria> params;

    public BookDataSpecificationsBuilder() {
        params = new ArrayList<SearchCriteria>();
    }

    public BookDataSpecificationsBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<BookData> build() {
        if (params.size() == 0) {
            return null;
        }

        List<BookDataSpecification> specs = params.stream()
          .map(BookDataSpecification::new)
          .collect(Collectors.toList());
        
        Specification<BookData> result = specs.get(0);

        for (int i = 1; i < params.size(); i++) {
            result = Specifications.where(result).and(specs.get(i));
        }       
        return result;
    }
}
