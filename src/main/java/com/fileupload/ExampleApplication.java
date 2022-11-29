package com.fileupload;

import com.fileupload.crud.StudentController;
import com.fileupload.localPath.Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		new File(Controller.uploadDir).mkdir();
		new File(StudentController.uploadDirectory).mkdir();
		SpringApplication.run(ExampleApplication.class, args);
	}

}
