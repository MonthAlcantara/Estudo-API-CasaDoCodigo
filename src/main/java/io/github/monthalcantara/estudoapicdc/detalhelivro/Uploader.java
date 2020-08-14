package io.github.monthalcantara.estudoapicdc.detalhelivro;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


public interface Uploader {

    public String upload(MultipartFile file);
}
