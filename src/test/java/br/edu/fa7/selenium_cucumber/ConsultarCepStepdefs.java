package br.edu.fa7.selenium_cucumber;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ConsultarCepStepdefs {

	private WebDriver firefoxDriver;
	private PaginaDosCorreios pagina;

	@Before
	public void inicializa() {
		firefoxDriver = new FirefoxDriver();
		pagina = new PaginaDosCorreios(firefoxDriver);
	}

	@Dado("^que acesso o site dos Correios$")
	public void que_acesso_o_site_dos_Correios() throws Throwable {
		pagina.acessaPaginaInicial();
	}

	@Quando("^clico no link \"([^\"]*)\"$")
	public void clico_no_link(String texto) throws Throwable {
		pagina.clicaNoLink(texto);
	}

	@Entao("^deveria visualizar \"([^\"]*)\"$")
	public void deveria_visualizar(String texto) throws Throwable {
		String corpo = pagina.recuperaCorpoDoSite();
		assertTrue(corpo.contains(texto));
	}

	@Quando("^seleciono \"([^\"]*)\" no campo UF$")
	public void seleciono_no_campo_UF(String texto) throws Throwable {
		Select uf = pagina.recuperaCombo("UF");
		pagina.selecionaOpcao(uf, texto);
	}

	@Quando("^digito \"([^\"]*)\" no campo Localidade$")
	public void digito_no_campo_Localidade(String texto) throws Throwable {
		WebElement localidade = pagina.recuperaCampo("Localidade");
		pagina.limpaCampo(localidade);
		pagina.digitaNoCampo(localidade, texto);
	}

	@Quando("^seleciono \"([^\"]*)\" no campo Tipo$")
	public void seleciono_no_campo_Tipo(String texto) throws Throwable {
		Select tipo = pagina.recuperaCombo("Tipo");
		pagina.selecionaOpcao(tipo, texto);
	}

	@Quando("^digito \"([^\"]*)\" no campo Logradouro$")
	public void digito_no_campo_Logradouro(String texto) throws Throwable {
		WebElement logradouro = pagina.recuperaCampo("Logradouro");
		pagina.limpaCampo(logradouro);
		pagina.digitaNoCampo(logradouro, texto);
	}

	@Quando("^digito \"([^\"]*)\" no campo Numero$")
	public void digito_no_campo_Numero(String texto) throws Throwable {
		WebElement numero = pagina.recuperaCampo("Numero");
		pagina.limpaCampo(numero);
		pagina.digitaNoCampo(numero, texto);
	}

	@Quando("^clico no botao Buscar$")
	public void clico_no_botao_Buscar() throws Throwable {
		WebElement buscar = pagina.recuperaBotaoBuscar();
		pagina.clicaNoBotao(buscar);
	}

	@Quando("^clico no resultado \"([^\"]*)\"$")
	public void clico_no_resultado(String texto) throws Throwable {
		pagina.clicaNoResultado();
	}

	@After
	public void finaliza() {
		firefoxDriver.close();
		pagina = null;
	}
}
