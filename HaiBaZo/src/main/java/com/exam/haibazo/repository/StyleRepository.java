package com.exam.haibazo.repository;

import com.exam.haibazo.model.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends JpaRepository<Style,Long> {
}
