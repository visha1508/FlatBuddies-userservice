package com.find.flat_buddies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.find.flat_buddies.model.Occupancy;

@Repository
public interface OccupancyRepository extends JpaRepository<Occupancy, Long>  {

}
