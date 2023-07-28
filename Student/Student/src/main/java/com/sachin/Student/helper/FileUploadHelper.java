package com.sachin.Student.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

//	public final String Upload_Dir ="G:\\anamika\\Student\\Student\\src\\main\\resources\\static\\images"; //static karne k liye
	public final String Upload_Dir =new ClassPathResource("static/images").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException
	{
		
	}
	
	// io file se karne k liye eska use karenge
	public boolean uploadFile(MultipartFile multipart)
	{
		boolean f = false;
		try {
			InputStream is = multipart.getInputStream();
			byte data[] = new byte[is.available()];
			is.read(data);
			
			FileOutputStream fos = new FileOutputStream(Upload_Dir+"\\"+multipart.getOriginalFilename());
			fos.write(data);
			fos.flush();
			fos.close();
			f = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	// nio file se use karne k liye eska use karenge
	public boolean uploadFileNew(MultipartFile multipart)
	{
		boolean f = false;
		
		try
		{
			Files.copy(multipart.getInputStream(),Paths.get(Upload_Dir+File.separator+multipart.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			f = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
}
