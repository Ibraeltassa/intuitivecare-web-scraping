package com.intuitivecare.scraper;

import net.lingala.zip4j.ZipFile;
import java.io.File;

public class ZipCompressor {
    public static void zipFiles(String[] filesToZip, String outputZipPath) {
        try {
            ZipFile zipFile = new ZipFile(outputZipPath);

            for (String filePath : filesToZip) {
                zipFile.addFile(new File(filePath));
            }

            System.out.println("Arquivos compactados com sucesso em: " + outputZipPath);
        } catch (Exception e) {
            System.out.println("Erro ao compactar arquivos: " + e.getMessage());
        }
    }
}
