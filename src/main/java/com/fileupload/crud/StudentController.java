package com.fileupload.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
    public static String uploadDirectory = System.getProperty("user.dir")  + "/src/main/resources/static/crud";
    @Autowired
    StudentService studentService;

    @GetMapping("/student")
    public String getPage(Model model) {
        List<Student> student = studentService.showAll();
        model.addAttribute("student", student);
        return "table";
    }

    @GetMapping("/add")
    public String addStudent(Model model, Student student) {

        model.addAttribute("students", student);
        return "Student";
    }

    @PostMapping("/student/add")
    public String addData(Model model,@RequestParam("photo")MultipartFile file, @ModelAttribute("students") Student student) throws IOException {
        String fileName ;
        if (file.isEmpty()) {

            return "Student";
        }
        else {
            fileName = file.getOriginalFilename();
            student.setImageName(fileName);
            Path pathAndFileName = Paths.get(uploadDirectory, file.getOriginalFilename());
            Files.write(pathAndFileName, file.getBytes());
            studentService.sendData(student);
            return "redirect:/student";
        }
    }

    @GetMapping("/student/update/{id}")
    public String update(@PathVariable int id, Model model, RedirectAttributes re) {
        Optional<Student> findId = studentService.update(id);
        if (findId.isPresent()) {
            model.addAttribute("students", findId.get());
            return "Student";
        } else {
            re.addAttribute("errorMessage", "Invalid");
        }
        return "redirect:/student";
    }
    @GetMapping("/student/delete/{id}")
    public String delete(@PathVariable int id){
        studentService.delete(id);
        return "redirect:/student";
    }

}
