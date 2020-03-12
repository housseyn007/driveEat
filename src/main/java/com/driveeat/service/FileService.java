package com.driveeat.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	@Autowired
	private String baseDir;

	@Value("${app.uploadPictures.dir}")
	private String uploadPicturesDir;

	public String uploadFile(MultipartFile file) {

		String random = Math.random() + (file.getOriginalFilename());

		try {

			Path copyLocation = Paths.get(baseDir + uploadPicturesDir + File.separator + StringUtils.cleanPath(random));
			Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return random;
	}

	public void deleteFile(String file) {

		try {
			File deleteFile = new File(file);
			System.out.println(file);
			deleteFile.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
