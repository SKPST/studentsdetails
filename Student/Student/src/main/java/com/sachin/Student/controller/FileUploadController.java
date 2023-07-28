package com.sachin.Student.controller;

import java.io.FileWriter;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sachin.Student.helper.FileUploadHelper;

@RestController
public class FileUploadController implements Serializable{
	
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping("/fileupload")
	public String addfile(@RequestParam("file") MultipartFile multipart)
	{
		try {
			//System.out.println(multipart.getOriginalFilename());
			//fileUploadHelper.uploadFile(multipart);
			fileUploadHelper.uploadFileNew(multipart);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "ok its working";
		//return ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(multipart.getOriginalFilename()).toUriString();
	}
	
	@GetMapping("images/{file}")
	public String getFile(@PathVariable("file") String name) {
		
		
		
		
		return "its working";
		
	}

}
