package br.edu.fa7.selenium_cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PaginaDosCorreios {

	private static final String URL = "http://www.correios.com.br";

	private WebDriver driver;

	public PaginaDosCorreios(WebDriver driver) {
		this.driver = driver;
	}

	public void acessaPaginaInicial() {
		driver.get(URL);
	}

	public void clicaNoLink(String texto) {
		driver.findElement(By.linkText(texto)).click();
	}

	public String recuperaCorpoDoSite() {
		return driver.findElement(By.tagName("body")).getText();
	}

	public Select recuperaCombo(String texto) {
		return new Select(driver.findElement(By.name(texto)));
	}

	public void selecionaOpcao(Select combo, String texto) {
		combo.selectByVisibleText(texto);
	}

	public WebElement recuperaCampo(String texto) {
		return driver.findElement(By.name(texto));
	}

	public void limpaCampo(WebElement campo) {
		campo.clear();
	}

	public void digitaNoCampo(WebElement campo, String texto) {
		campo.sendKeys(texto);
	}

	public WebElement recuperaBotaoBuscar() {
		return driver.findElement(By.className("btn1"));
	}

	public void clicaNoBotao(WebElement botao) {
		botao.click();
	}

	public void clicaNoResultado() {
		driver.findElement(
				By.xpath("//div[@id='lamina']/div[2]/div[2]/div[2]/div/table/tbody/tr[5]/td"))
				.click();
	}
}
