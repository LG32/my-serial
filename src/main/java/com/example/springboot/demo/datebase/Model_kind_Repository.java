package com.example.springboot.demo.datebase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface Model_kind_Repository extends JpaRepository<Model_kind,Integer> {
}
