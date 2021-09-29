package com.kalibek.ttleague.service.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageableUtils {

  public static Pageable toPagebale(Integer offset, Integer limit, String sortBy,
      String sortOrder) {
    if (offset == null) {
      offset = 0;
    }
    if (limit == null) {
      limit = 20;
    }
    if (sortBy == null) {
      return PageRequest.of(
          offset / limit,
          limit
      );
    }
    if (sortOrder == null) {
      return PageRequest.of(
          offset / limit,
          limit,
          Sort.by(sortBy).ascending()
      );
    }

    return PageRequest.of(
        offset / limit,
        limit,
        "DESC".equals(sortOrder) ?
            Sort.by(sortBy).descending() :
            Sort.by(sortBy).ascending()
    );
  }
}
