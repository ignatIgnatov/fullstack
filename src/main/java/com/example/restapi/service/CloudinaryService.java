package com.example.restapi.service;

import com.example.restapi.model.dto.cloudinaryPictureDto.CloudinaryImage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CloudinaryService {

    CloudinaryImage uploadImage(MultipartFile multipartFile) throws IOException;
}
