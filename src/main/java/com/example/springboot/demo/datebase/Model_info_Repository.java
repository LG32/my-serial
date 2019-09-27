package com.example.springboot.demo.datebase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface Model_info_Repository extends JpaRepository<Model_info,Integer> {

}
