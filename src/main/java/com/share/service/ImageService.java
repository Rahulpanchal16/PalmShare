package com.share.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.share.entity.Image;
import com.share.repository.ImageRepo;

@Service
public class ImageService {
	
	@Autowired
	private ImageRepo imageRepo;

	private final String uploadDir="C:\\Users\\WIN10\\Desktop\\client_imgs";
	
	public Image uploadFile(MultipartFile file) throws IllegalStateException, IOException {
		String fileName=file.getOriginalFilename();
		java.io.File destFile=new java.io.File(uploadDir+java.io.File.separator+fileName);
		file.transferTo(destFile);
		
		Image img=new Image();
		img.setFileName(fileName);
		img.setFileUrl(destFile.getAbsolutePath());
		return imageRepo.save(img);				
	}	
}
