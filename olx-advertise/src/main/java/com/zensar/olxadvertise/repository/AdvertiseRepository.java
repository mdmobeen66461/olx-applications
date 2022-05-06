package com.zensar.olxadvertise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.olxadvertise.entity.AdvertiseDetails;

public interface AdvertiseRepository extends JpaRepository<AdvertiseDetails, Long>{

}
