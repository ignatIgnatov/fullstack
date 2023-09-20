package com.example.restapi.model.dto.imageDto;


import jakarta.persistence.Lob;

public class PictureDownloadModel {

    @Lob
    private final byte[] fileData;
    private final String contentType;

    private final String fileName;

    public PictureDownloadModel(byte[] fileData, String contentType, String fileName) {
        this.fileData = fileData;
        this.contentType = contentType;
        this.fileName = fileName;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public String getContentType() {
        return contentType;
    }

    public String getFileName() {
        return fileName;
    }

}
