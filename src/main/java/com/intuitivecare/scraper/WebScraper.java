package com.intuitivecare.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class WebScraper {
    public static void main(String[] args) {
        System.out.println("Iniciando o Web Scraping");

        try {
            String url = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";
            Document doc = Jsoup.connect(url).get();

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

        } catch (Exception e) {
            System.out.println("Erro ao acessar a página: " + e.getMessage());
        }

    }

}
