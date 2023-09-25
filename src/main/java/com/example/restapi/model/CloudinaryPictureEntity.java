package com.example.restapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pictures")
public class CloudinaryPictureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String imgUrl;
    private String publicId;

    @OneToOne(mappedBy = "picture")
    private UserEntity user;

    public long getId() {
        return id;
    }

    public CloudinaryPictureEntity setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CloudinaryPictureEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public CloudinaryPictureEntity setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public CloudinaryPictureEntity setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }
}
