package com.ec.onlineplantnursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.onlineplantnursery.entity.Seed;

public interface ISeedRepository extends JpaRepository<Seed, Integer>, CustomSeedRepository {

}
