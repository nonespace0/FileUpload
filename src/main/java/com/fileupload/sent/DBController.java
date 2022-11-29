package com.fileupload.sent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Controller
public class DBController {

    @Autowired
    ImageService imageService;
    @GetMapping("/db")
    public String getPage(Model model){
    List<Image> image = imageService.getFile();
    model.addAttribute("images", image);
        return "new";
    }
@PostMapping("/sendData")
    public String postData(@RequestParam("image") MultipartFile file) throws IOException {
        imageService.sendData(file);
        return "redirect:/";
    }
    @GetMapping("/downloadFile/{id}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable int id){
       Image image = imageService.download(id).get();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+image.getName()+"\"")
                .body(new ByteArrayResource(image.getData()));
    }
}
