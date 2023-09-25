package com.example.restapi.web;

import com.example.restapi.model.CloudinaryPictureEntity;
import com.example.restapi.model.dto.cloudinaryPictureDto.PictureBindingModel;
import com.example.restapi.model.dto.cloudinaryPictureDto.PictureViewModel;
import com.example.restapi.service.PictureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/cloudinary")
public class CloudinaryController {


    private final PictureService pictureService;

    public CloudinaryController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @PostMapping("/upload/{id}")
    public ResponseEntity<PictureViewModel> upload(@RequestParam("image") MultipartFile pictureBindingModel,
                                                   @PathVariable("id") Long id) throws IOException {

        pictureService.addPicture(pictureBindingModel, id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PictureViewModel> getPicture(@PathVariable("id") Long id) {

        return ResponseEntity.ok(pictureService.getPicture(id));
    }
}
