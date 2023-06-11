package com.share.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.share.entity.Image;

public interface ImageRepo  extends JpaRepository<Image, Long>{

}
