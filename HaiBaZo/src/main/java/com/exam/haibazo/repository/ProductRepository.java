package com.exam.haibazo.repository;

import com.exam.haibazo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {


    Optional<Product> findById(Long id);

    @Query("SELECT p FROM Product p " +
            "LEFT JOIN p.styles s " +
            "LEFT JOIN p.colors c " +
            "LEFT JOIN p.sizes sz " +
            "WHERE (:category IS NULL OR p.category.name = :category) " +
            "AND (:color IS NULL OR c.name = :color) " +
            "AND (:size IS NULL OR sz.sizeLabel = :size) " +
            "AND (:minPrice IS NULL OR p.price >= :minPrice) " +
            "AND (:maxPrice IS NULL OR p.price <= :maxPrice) " +
            "AND (:style IS NULL OR s.name = :style)")
    List<Product> findByFilters(String category, String color, String size, Double minPrice, Double maxPrice, String style);


}
