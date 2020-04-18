package com.driveeat;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent>{

	@Autowired
	private String baseDir;
	@Value("${app.upload.dir}")
	private String uploadDir;
	@Value("${app.uploadPictures.dirName}")
	private String uploadPicName;



	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		File uploadsDir = new File(baseDir + uploadDir);
		File uploadsPicturesDir = new File(uploadsDir, uploadPicName);
		if (!uploadsPicturesDir.exists()) {
			uploadsPicturesDir.mkdirs();
		}
		
	}
}
