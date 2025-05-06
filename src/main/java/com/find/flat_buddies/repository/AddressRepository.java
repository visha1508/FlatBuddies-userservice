package com.find.flat_buddies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.find.flat_buddies.model.Address;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
