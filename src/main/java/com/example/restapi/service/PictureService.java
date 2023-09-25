package com.example.restapi.service;

import com.example.restapi.model.dto.cloudinaryPictureDto.PictureBindingModel;
import com.example.restapi.model.dto.cloudinaryPictureDto.PictureViewModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PictureService {

    PictureViewModel addPicture(MultipartFile file, Long id) throws IOException;

    PictureViewModel getPicture(Long id);
}
