package com.kalibek.ttleague.domain.repo;

import com.kalibek.ttleague.domain.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepo extends JpaRepository<Rating, Long> {

}
