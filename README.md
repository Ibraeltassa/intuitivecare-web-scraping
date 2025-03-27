# Web Scraping - IntuitiveCare

Este repositório contém a solução para o desafio de **Web Scraping** do processo seletivo da **IntuitiveCare**.

##  Descrição

O sistema realiza as seguintes etapas automaticamente:

1. Acessa a página da ANS contendo os anexos PDF:
   [https://www.gov.br/ans/.../atualizacao-do-rol-de-procedimentos](https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos)
2. Identifica e baixa os arquivos **Anexo I** e **Anexo II**.
3. Salva os PDFs na pasta `downloads/`.
4. Compacta os dois arquivos em um único ZIP chamado `Anexos_Completos.zip`.

## 🛠️ Tecnologias Utilizadas

- Java 17
- Maven
- Biblioteca [**Jsoup**](https://jsoup.org/) para web scraping
- Biblioteca [**Zip4j**](https://github.com/srikanth-lingala/zip4j) para compactação


## ▶️ Como Executar

```bash
# Clone o repositório
git clone https://github.com/Ibraeltassa/intuitivecare-web-scraping.git

# Navegue até o projeto
cd intuitivecare-web-scraping

# Compile e execute com Maven ou pela sua IDE preferida