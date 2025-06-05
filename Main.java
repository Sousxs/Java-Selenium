package com.example;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\psouza\\Desktop\\Selenium\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        options.addArguments("-private");
        WebDriver driver = new FirefoxDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        try {
            // Realiza o login do corretor
            LoginUtil.loginCorretorENavegar(driver, "http://propostadigital-hmg.fgr.com.br/");

            String caminhoArquivoPessoas = "C:\\Users\\psouza\\Desktop\\Selenium\\pessoas - Copiar.xlsx";
            List<Pessoa> pessoas = PessoasReader.lerPessoasOuEncerrar(driver, caminhoArquivoPessoas);

            // Pré-cadastro
            preCadastro cadastro = new preCadastro(driver, wait);
            for (Pessoa pessoa : pessoas) {
                cadastro.executar(pessoa);
    
                System.out.println("Pré-cadastro concluído com sucesso!");

                // Simulação de lote
                SimuladorLotes simulador = new SimuladorLotes(driver, wait);
                String codigoSimulacao = simulador.executar();
                System.out.println("Simulação de lote realizada com sucesso!");

                // Gerar uma Proposta
                Proposta proposta = new Proposta(driver);
                proposta.executar(codigoSimulacao,pessoa.cpf); 
                System.out.println("Proposta executada com sucesso!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}