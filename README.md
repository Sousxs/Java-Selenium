# Selenium - Instruções de Uso

Este projeto utiliza Selenium WebDriver com Firefox para automação de testes. 

---

## 1. Geckodriver(Firefox driver)

O `geckodriver` é necessário para que o Selenium controle o navegador Firefox.

### Passos para baixar e configurar:

1. **Acesse:**  
   [https://github.com/mozilla/geckodriver/releases](https://github.com/mozilla/geckodriver/releases)

2. **Baixe a versão compatível com seu sistema operacional**  
   (Exemplo: `geckodriver-vX.XX.X-win64.zip` para Windows 64 bits).

3. **Extraia o arquivo**  
   Após o download, extraia o arquivo `geckodriver.exe`.

4. **Coloque o `geckodriver.exe` na pasta correta**  
   Recomenda-se colocar em:  
   `C:\Users\psouza\Desktop\Selenium\geckodriver.exe`

5. **Se desejar alterar o local:**  
   - Altere o caminho no código, na linha:
     ```java
     System.setProperty("webdriver.gecko.driver", "CAMINHO_DO_GECKODRIVER");
     ```
---

## 2. Anexando e Configurando as Planilhas

O projeto utiliza duas planilhas principais:

- **logins.xlsx**: Contém os dados de login.
- **pessoas.xlsx** (ou similar): Contém os dados das pessoas para cadastro.


#### Para o login (arquivo [LoginUtil.java](http://_vscodecontentref_/0)):

```java
private static final String CAMINHO_ARQUIVO = "CAMINHO_DO_ARQUIVO_DE_LOGIN";
```
