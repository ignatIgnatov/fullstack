package com.example.restapi.service.impl;

import com.example.restapi.exception.ImageNotFoundException;
import com.example.restapi.exception.UserNotFoundException;
import com.example.restapi.model.CloudinaryPictureEntity;
import com.example.restapi.model.UserEntity;
import com.example.restapi.model.dto.cloudinaryPictureDto.CloudinaryImage;
import com.example.restapi.model.dto.cloudinaryPictureDto.PictureViewModel;
import com.example.restapi.repository.CloudinaryRepository;
import com.example.restapi.repository.UserRepository;
import com.example.restapi.service.CloudinaryService;
import com.example.restapi.service.PictureService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PictureServiceImpl implements PictureService {

    private final CloudinaryRepository cloudinaryRepository;
    private final CloudinaryService cloudinaryService;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public PictureServiceImpl(CloudinaryService cloudinaryService,
                              CloudinaryRepository cloudinaryRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.cloudinaryService = cloudinaryService;
        this.cloudinaryRepository = cloudinaryRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public PictureViewModel addPicture(MultipartFile file, Long id) throws IOException {
        CloudinaryPictureEntity picture = createPictureEntity(file);

        UserEntity user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

        if (user.getPicture() != null) {
            cloudinaryRepository.deleteById(user.getPicture().getId());
        }

        user.setPicture(picture);
        userRepository.save(user);

        return new PictureViewModel()
                .setImgUrl(picture.getImgUrl())
                .setPublicId(picture.getPublicId())
                .setTitle(picture.getTitle());
    }

    private CloudinaryPictureEntity createPictureEntity(MultipartFile file) throws IOException {
        final CloudinaryImage uploaded = this.cloudinaryService.uploadImage(file);
        return new CloudinaryPictureEntity()
                .setPublicId(uploaded.getPublicId())
                .setTitle(file.getOriginalFilename())
                .setImgUrl(uploaded.getUrl());
    }


    public PictureViewModel getPicture(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

        CloudinaryPictureEntity picture = cloudinaryRepository.findById(user.getPicture().getId()).orElseThrow(
                () -> new ImageNotFoundException("Picture not found"));

        return modelMapper.map(picture, PictureViewModel.class);
    }
}
