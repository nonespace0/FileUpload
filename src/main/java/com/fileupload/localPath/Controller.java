package com.fileupload.localPath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@org.springframework.stereotype.Controller
public class Controller {
    public static String uploadDir = System.getProperty("user.dir")  + "/src/main/resources/static/images";
    @Autowired
    UserRepository userRepository;

    @GetMapping("/page")
    public String getData(){
        return "register";
    }
    @PostMapping("/save")
    public String postDate(@RequestParam ("userImage")MultipartFile file, User user, RedirectAttributes re) throws IOException {
        if (file.isEmpty()){
            re.addAttribute("errorMessage", "Please select file") ;
        return "redirect:/";
        }
        Path path = Paths.get(uploadDir, file.getOriginalFilename());
        Files.write(path, file.getBytes());
        re.addAttribute("successMessage","File Upload Success");
    return "redirect:/";
    }

}
