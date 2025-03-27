package com.intuitivecare.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraper {
    public static void main(String[] args) {
        System.out.println("Iniciando o Web Scraping");

        try {
            // URL da página com os anexos PDF
            String url = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";

            // Faz a requisição e obtém o conteúdo HTML da página
            Document doc = Jsoup.connect(url).get();

            // Seleciona os links que terminam com ".pdf"
            Elements links = doc.select("a[href$=.pdf]");

            for (Element link : links) {
                String texto = link.text().toLowerCase();

                if (texto.contains("anexo i") && !texto.contains("anexo ii")) {
                    String pdfUrl = link.absUrl("href");
                    System.out.println("Baixando Anexo I...");
                    FileDownloader.downloadFile(pdfUrl, "Anexo_I.pdf");
                } else if (texto.contains("anexo ii")) {
                    String pdfUrl = link.absUrl("href");
                    System.out.println("Baixando Anexo II...");
                    FileDownloader.downloadFile(pdfUrl, "Anexo_II.pdf");
                }
            }

            // Após baixar os arquivos, compactar
            String[] arquivos = {
                    "downloads/Anexo_I.pdf",
                    "downloads/Anexo_II.pdf"
            };
            ZipCompressor.zipFiles(arquivos, "downloads/Anexos_Completos.zip");

        } catch (Exception e) {
            System.out.println("Erro ao acessar a página: " + e.getMessage());
        }

    }

}