package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JewelRepository extends JpaRepository<Jewel, Long> {
    Jewel findByPrice(int price);
    public List<Jewel> findAll();
}