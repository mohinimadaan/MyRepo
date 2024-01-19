package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre,Integer> {

}
