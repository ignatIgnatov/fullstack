package com.example.restapi.service.impl;

import com.example.restapi.exception.ImageNotFoundException;
import com.example.restapi.exception.UserNotFoundException;
import com.example.restapi.model.ImageEntity;
import com.example.restapi.model.UserEntity;
import com.example.restapi.model.dto.imageDto.ImageResponse;
import com.example.restapi.repository.ImageRepository;
import com.example.restapi.repository.UserRepository;
import com.example.restapi.service.ImageService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ImageServiceImpl implements ImageService {

    private final Path UPLOAD_PATH =
            Paths.get(new ClassPathResource("").getFile().getAbsolutePath() + File.separator + "static" + File.separator + "image");


    private final ImageRepository imageRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public ImageServiceImpl(UserRepository userRepository, ImageRepository imageRepository, ModelMapper modelMapper) throws IOException {
        this.userRepository = userRepository;
        this.imageRepository = imageRepository;
        this.modelMapper = modelMapper;
    }

//    @Transactional
//    @Override
//    public ImageResponse uploadFile(MultipartFile file, Long id) throws IOException {
//
//        if (!Files.exists(UPLOAD_PATH)) {
//            Files.createDirectories(UPLOAD_PATH);
//        }
//
//
//        UserEntity user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
//
//        if (user.getImage() != null) {
//            imageRepository.deleteById(user.getImage().getId());
//        }
//
//
//        if (!file.getContentType().equals("image/jpeg") && !file.getContentType().equals("image/png")) {
//            throw new RuntimeException("only .jpeg and .png images are supported");
//        }
//
//
//        String timeStampedFileName = new SimpleDateFormat("ssmmHHddMMyyyy")
//                .format(new Date()) + "_" + file.getOriginalFilename();
//
//        Path filePath = UPLOAD_PATH.resolve(timeStampedFileName);
//        Files.copy(file.getInputStream(), filePath);
//
//        String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/image/").path(timeStampedFileName).toUriString();
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/file/download/").path(timeStampedFileName).toUriString();
//
//        ImageEntity image = new ImageEntity(file.getOriginalFilename(), fileUri, fileDownloadUri, file.getSize(), user);
//
//        user.setImage(image);
//        userRepository.save(user);
//
//        return modelMapper.map(image, ImageResponse.class);
//    }

//    @Override
//    public Resource fetchFileAsResource(String fileName) throws FileNotFoundException {
//
//        try {
//            Path filePath = UPLOAD_PATH.resolve(fileName).normalize();
//            Resource resource = new UrlResource(filePath.toUri());
//            if (resource.exists()) {
//                return resource;
//            } else {
//                throw new FileNotFoundException("File not found " + fileName);
//            }
//        } catch (MalformedURLException ex) {
//            throw new FileNotFoundException("File not found " + fileName);
//        }
//    }

//    @Override
//    public ImageResponse getImage(Long userId) {
//        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
//
//        ImageEntity image = imageRepository.findById(user.getImage().getId()).orElseThrow(() -> new ImageNotFoundException("Image not found"));
//        return modelMapper.map(image, ImageResponse.class);
//    }
}
