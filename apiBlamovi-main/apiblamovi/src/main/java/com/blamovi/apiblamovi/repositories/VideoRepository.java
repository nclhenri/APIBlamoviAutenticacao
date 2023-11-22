package com.blamovi.apiblamovi.repositories;

import com.blamovi.apiblamovi.models.VideoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<VideoModel, Integer> {

}