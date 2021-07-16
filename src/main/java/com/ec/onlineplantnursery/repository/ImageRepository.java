package com.ec.onlineplantnursery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ec.onlineplantnursery.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer>{

	Optional<Image> findByProduct_pId(int pId);
}
