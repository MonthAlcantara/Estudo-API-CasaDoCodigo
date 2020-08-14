package io.github.monthalcantara.estudoapicdc.detalhelivro;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class LocalUploader implements  Uploader{

    @Override
    public String upload(MultipartFile file) {
        System.out.println("Enviando arquivo...");
        return "null";
    }
}
