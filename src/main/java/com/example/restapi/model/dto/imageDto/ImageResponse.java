package com.example.restapi.model.dto.imageDto;

public class ImageResponse {

    private int id;

    private String fileName;

    private String fileUri;

    private String fileDownloadUri;

    private long fileSize;

    public ImageResponse() {
    }

    public ImageResponse(int id, String fileName, String fileUri, String fileDownloadUri, long fileSize) {
        this.id = id;
        this.fileName = fileName;
        this.fileUri = fileUri;
        this.fileDownloadUri = fileDownloadUri;
        this.fileSize = fileSize;
    }

    public int getId() {
        return id;
    }

    public ImageResponse setId(int id) {
        this.id = id;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public ImageResponse setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getFileUri() {
        return fileUri;
    }

    public ImageResponse setFileUri(String fileUri) {
        this.fileUri = fileUri;
        return this;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public ImageResponse setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
        return this;
    }

    public long getFileSize() {
        return fileSize;
    }

    public ImageResponse setFileSize(long fileSize) {
        this.fileSize = fileSize;
        return this;
    }
}
