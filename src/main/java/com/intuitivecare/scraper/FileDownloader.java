package com.intuitivecare.scraper;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.net.URL;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileDownloader {

    public static void downloadFile(String fileURL, String fileName) throws Exception {
        URL url = new URL(fileURL);
        InputStream inputStream = url.openStream();

        File targetFile = new File("downloads/" + fileName);
        targetFile.getParentFile().mkdirs(); // cria a pasta "downloads" se não existir

        try (FileOutputStream outputStream = new FileOutputStream(targetFile)) {
            IOUtils.copy(inputStream, outputStream);
        }

        System.out.println("Arquivo salvo: " + targetFile.getAbsolutePath());
    }

}
