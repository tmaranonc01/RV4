package com.example.rv4.Pieza.Service;

import com.example.rv4.Pieza.utils.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageService {
    private final Path fileStorageLocation;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation =
                Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't create the directory where the upload files will be saved.", ex);
        }
    }

    public String storeFile(MultipartFile file) {
        UUID uuid = UUID.randomUUID();
        String fileName = StringUtils.cleanPath(uuid + "_"
                + file.getOriginalFilename());
        try {
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation,
                    StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
