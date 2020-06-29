package com.driveeat.config;

import java.nio.file.Paths;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.driveeat.DriveeatApplication;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	String currentPath = DriveeatApplication.class.getProtectionDomain().getCodeSource().getLocation().getPath();

	String baseDir = Paths.get(currentPath).getParent().getParent().getParent().toString().replaceFirst("file:", "");

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/DriveatBackend/**").addResourceLocations("file:" + baseDir + "/DriveatBackend/");

	}

	@Bean("baseDir")
	public String getBaseDir() {

		return baseDir;
	}
}
