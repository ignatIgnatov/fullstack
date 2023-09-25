package com.example.restapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fileName;
    @Column
    private String fileUri;
    @Column
    private String fileDownloadUri;
    @Column
    private long fileSize;

//    @OneToOne(mappedBy = "image")
//    private UserEntity user;

//    public ImageEntity(String fileName, String fileUri, String fileDownloadUri, long fileSize, UserEntity user) {
//
//        this.fileName = fileName;
//        this.fileUri = fileUri;
//        this.fileDownloadUri = fileDownloadUri;
//        this.fileSize = fileSize;
//        this.user = user;
//    }

    public ImageEntity() {
    }

    public Long getId() {
        return id;
    }

    public ImageEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public ImageEntity setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getFileUri() {
        return fileUri;
    }

    public ImageEntity setFileUri(String fileUri) {
        this.fileUri = fileUri;
        return this;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public ImageEntity setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
        return this;
    }

    public long getFileSize() {
        return fileSize;
    }

    public ImageEntity setFileSize(long fileSize) {
        this.fileSize = fileSize;
        return this;
    }

//    public UserEntity getUser() {
//        return user;
//    }
//
//    public ImageEntity setUser(UserEntity user) {
//        this.user = user;
//        return this;
//    }
}