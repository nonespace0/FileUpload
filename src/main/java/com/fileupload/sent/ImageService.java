package com.fileupload.sent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepo;
    public Image sendData(MultipartFile file) throws IOException {
        String name = file.getOriginalFilename();
        Image image = new Image(name, file.getContentType(), file.getBytes());
        return imageRepo.save(image);
    }
    public List<Image> getFile(){
        return imageRepo.findAll();

    }

    public Optional<Image> download(int id){
        return imageRepo.findById(id);
    }
}
