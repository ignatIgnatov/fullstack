package com.example.restapi.service;

import com.example.restapi.model.ImageEntity;
import com.example.restapi.model.UserEntity;
import com.example.restapi.model.dto.imageDto.ImageResponse;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ImageService {

    ImageResponse uploadFile(MultipartFile file, Long id) throws IOException;
    Resource fetchFileAsResource(String fileName) throws FileNotFoundException;
    ImageResponse getImage(Long userId);
}
