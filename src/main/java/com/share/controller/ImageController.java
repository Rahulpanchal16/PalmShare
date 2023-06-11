package com.share.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.share.entity.Image;
import com.share.service.ImageService;

@RestController
public class ImageController {

	@Autowired
	private ImageService imageService;
	
	@PostMapping(path = "/upload")
	public ResponseEntity<Image> upload(@RequestParam("img") MultipartFile file){
		
		try {
			Image uploadFile = imageService.uploadFile(file);
			return ResponseEntity.ok(uploadFile);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		
	}
}
