package com.example.digitallibrary.Repository;

import com.example.digitallibrary.Model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RateRepository extends JpaRepository<Rate,Integer> {
    Rate findRateById(Integer id);
    public List<Rate> findAllByBookname(String name);
    public List<Rate> findAllByRatingGreaterThanEqual(Integer r);
    public List<Rate> findAllByRatingLessThanEqual(Integer r);
}
