package com.go.sports.repository;

import com.go.sports.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, String> {
    public List<Category> findByEventId(String eventId);
}
