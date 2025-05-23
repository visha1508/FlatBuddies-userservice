package com.find.flat_buddies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.find.flat_buddies.model.PropertyDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyDetailsRepository extends JpaRepository<PropertyDetails, Long> {

}
