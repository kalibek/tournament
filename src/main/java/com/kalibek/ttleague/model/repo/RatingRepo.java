package com.kalibek.ttleague.model.repo;

import com.kalibek.ttleague.model.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepo extends JpaRepository<Rating, Long> {

}
