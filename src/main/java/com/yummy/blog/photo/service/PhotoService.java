package com.yummy.blog.photo.service;

import com.yummy.blog.photo.entity.PhotoEntity;
import com.yummy.blog.photo.mapper.PhotoMapper;
import com.yummy.blog.photo.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class PhotoService {

    @Value("${mediaRootLocation}")
    private String path;

    @Autowired
    private PhotoRepository photoRepository;

    public String showPath(String name) {
        PhotoEntity photo = photoRepository.findOneByName(name);
        return path + File.separator + photo.getName();
    }

    public String showName(String name) {
        PhotoEntity photo = photoRepository.findOneByName(name);
        return PhotoMapper.map(photo).getName();
    }

    public PhotoEntity store(MultipartFile photo) {
        try {
            String newPhotoName = UUID.randomUUID().toString() + ".jpg";
            Path destinationFile = Paths.get(path)
                    .resolve(Paths.get(newPhotoName))
                    .normalize()
                    .toAbsolutePath();

            try (InputStream inputStream = photo.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }

            PhotoEntity entity = photoRepository.saveAndFlush(new PhotoEntity(
                    newPhotoName,
                    photo.getOriginalFilename(),
                    photo.getContentType()
            ));

            return entity;
        } catch (Exception e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }
}
