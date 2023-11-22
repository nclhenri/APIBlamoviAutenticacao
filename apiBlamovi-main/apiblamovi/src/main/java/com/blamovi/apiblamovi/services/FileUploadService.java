package com.blamovi.apiblamovi.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class FileUploadService {

    private final Path diretorioImg = Paths.get(System.getProperty("user.dir")+ "\\src\\main\\resources\\static\\img");

    public String fazerUpload(MultipartFile foto) throws IOException{
        if (foto.isEmpty()){
            System.out.println("Imagem vazia!");
            return null;
        }
        //nomeArquivo.png
        //nome
        //png
        //nome.Arquivo.jpg
        String[] nomeArquivoArray = foto.getOriginalFilename().split("\\.");
        String novoNome = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyyHHmmss"));
        String extensaoArquivo = nomeArquivoArray[nomeArquivoArray.length - 1];

        String nomeFoto = novoNome + "." + extensaoArquivo;
        File fotoCriada = new File(diretorioImg + "\\"+ nomeFoto);

        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fotoCriada));

        stream.write(foto.getBytes());
        stream.close();

        return nomeFoto;
    }
}
