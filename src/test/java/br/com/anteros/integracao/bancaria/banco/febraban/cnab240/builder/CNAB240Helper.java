package br.com.anteros.integracao.bancaria.banco.febraban.cnab240.builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.anteros.automacao.bancaria.comum.pessoa.contato.NumeroDeTelefone;
import br.com.anteros.automacao.bancaria.comum.pessoa.endereco.CEP;
import br.com.anteros.automacao.bancaria.comum.pessoa.endereco.Endereco;
import br.com.anteros.automacao.bancaria.comum.pessoa.endereco.UnidadeFederativa;
import br.com.anteros.core.utils.DateUtil;
import br.com.anteros.integracao.bancaria.banco.Banco;
import br.com.anteros.integracao.bancaria.banco.febraban.Agencia;
import br.com.anteros.integracao.bancaria.banco.febraban.Carteira;
import br.com.anteros.integracao.bancaria.banco.febraban.Cedente;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.febraban.NumeroDaConta;
import br.com.anteros.integracao.bancaria.banco.febraban.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.Sacado;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoDeBaixaDevolucao;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoDeCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoDeDesconto;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoDeDistribuicaoBoleto;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoDeEmissaoBoleto;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoDeJurosMora;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoDeMoeda;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoDeMovimentoRemessa;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoDeProtesto;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoDeTitulo;
import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;
import br.com.anteros.integracao.bancaria.banco.febraban.Titulo.Aceite;

public class CNAB240Helper {

	public static List<RemessaCobranca> gerarTitulosParaRemessaCobranca(Banco banco) {
		List<RemessaCobranca> result = new ArrayList<RemessaCobranca>();
		ContaBancaria contaBancaria = criarContaBancaria(banco);
		Cedente cedente = criarCedente(banco);
		Carteira carteira = criarCarteira();
		result.add(criarRemessa(contaBancaria, cedente, carteira, criarSacado1(), new BigDecimal("12347.34"),
				"100000001", DateUtil.stringToDate("10/05/2016", "dd/MM/yyyy"), "188282828282", "2", 1000));
		result.add(criarRemessa(contaBancaria, cedente, carteira, criarSacado2(), new BigDecimal("52347.14"),
				"100000001", DateUtil.stringToDate("15/06/2016", "dd/MM/yyyy"), "288282828282", "2", 1000));
		result.add(criarRemessa(contaBancaria, cedente, carteira, criarSacado3(), new BigDecimal("61247.24"),
				"100000001", DateUtil.stringToDate("12/07/2016", "dd/MM/yyyy"), "388282828282", "2", 1000));
		result.add(criarRemessa(contaBancaria, cedente, carteira, criarSacado4(), new BigDecimal("234.54"), "100000001",
				DateUtil.stringToDate("11/08/2016", "dd/MM/yyyy"), "488282828282", "2", 1000));
		return result;
	}

	private static RemessaCobranca criarRemessa(ContaBancaria contaBancaria, Cedente cedente, Carteira carteira,
			Sacado sacado, BigDecimal valorTitulo, String numeroDocumento, Date dataVencimento, String nossoNumero,
			String digitoNossoNumero, Integer nrLote) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, Calendar.MAY, 10);
		Titulo titulo = new Titulo(contaBancaria, sacado, cedente, carteira);
		titulo.setAceite(Aceite.N);
		titulo.setDataDesconto(calendar.getTime());
		titulo.setDataDoDocumento(calendar.getTime());
		titulo.setDataDoVencimento(calendar.getTime());
		titulo.setDataJurosMora(calendar.getTime());
		titulo.setDigitoDoNossoNumero("1");
		titulo.setJurosMora(BigDecimal.TEN);
		titulo.setNossoNumero(nossoNumero);
		titulo.setNrDiasBaixaDevolucao(10);
		titulo.setNrDiasProtesto(5);
		titulo.setNumeroDoDocumento(numeroDocumento);
		titulo.setPercentualDesconto(BigDecimal.TEN);
		titulo.setTipoDeBaixaDevolucao(TipoDeBaixaDevolucao.NAO_BAIXAR);
		titulo.setTipoDeDesconto(TipoDeDesconto.VALOR_FIXO_ATE_A_DATA);
		titulo.setTipoDeDocumento(TipoDeTitulo.DM_DUPLICATA_MERCANTIL);
		titulo.setTipoDeJurosMora(TipoDeJurosMora.VALOR_POR_DIA);
		titulo.setTipoDeMoeda(TipoDeMoeda.REAL);
		titulo.setTipoDeProtesto(TipoDeProtesto.NAO_PROTESTAR);
		titulo.setValor(valorTitulo);
		titulo.setValorAbatimento(BigDecimal.TEN);
		titulo.setValorAcrecimo(BigDecimal.TEN);
		titulo.setValorCobrado(valorTitulo);
		titulo.setValorDeducao(BigDecimal.TEN);
		titulo.setValorDesconto(BigDecimal.TEN);
		titulo.setValorIOF(BigDecimal.TEN);
		titulo.setValorJurosMora(BigDecimal.TEN);

		return RemessaCobranca.of(TipoDeMovimentoRemessa.ENTRADA_TITULOS, titulo, nrLote);
	}

	public static final Cedente criarCedente(Banco banco) {
		Endereco enderecoCedente = new Endereco();
		enderecoCedente.setBairro("Centro");
		enderecoCedente.setCep("87260000");
		enderecoCedente.setComplemento("");
		enderecoCedente.setLocalidade("Araruna");
		enderecoCedente.setLogradouro("Av. Teste");
		enderecoCedente.setNumero("300");
		enderecoCedente.setPais("Brasil");
		enderecoCedente.setUF(UnidadeFederativa.PR);

		Cedente cedente = new Cedente("Anteros Tecnologia Ltda", "16611534000194");
		cedente.addContaBancaria(criarContaBancaria(banco));
		cedente.addTelefone(criarTelefone());
		cedente.addEndereco(enderecoCedente);
		return cedente;
	}

	private static NumeroDeTelefone criarTelefone() {
		NumeroDeTelefone telefone = new NumeroDeTelefone();
		telefone.setDDD(44);
		telefone.setDDI(55);
		telefone.setTelefone("87586514");
		return telefone;
	}

	public static ContaBancaria criarContaBancaria(Banco banco) {
		Agencia agencia = new Agencia(1212, "3");
		NumeroDaConta numeroDaConta = new NumeroDaConta(232323, "2");
		ContaBancaria contaBancaria = new ContaBancaria(banco);
		contaBancaria.setAgencia(agencia);
		contaBancaria.setNumeroDaConta(numeroDaConta);
		return contaBancaria;
	}

	public static final Sacado criarSacado1() {

		Sacado sacado = new Sacado("Empresa Teste Ltda", "17440867000160");
		Endereco enderecoSacado = new Endereco();
		enderecoSacado.setUF(UnidadeFederativa.PR);
		enderecoSacado.setLocalidade("Araruna");
		enderecoSacado.setCep(new CEP("87260-000"));
		enderecoSacado.setBairro("Centro");
		enderecoSacado.setLogradouro("Av. Presidente Vargas");
		enderecoSacado.setNumero("140");
		sacado.addEndereco(enderecoSacado);

		return sacado;
	}

	public static final Sacado criarSacado2() {

		Sacado sacado = new Sacado("Empresa XYZ Ltda", "92584124000180");
		Endereco enderecoSacado = new Endereco();
		enderecoSacado.setUF(UnidadeFederativa.PR);
		enderecoSacado.setLocalidade("Peabiru");
		enderecoSacado.setCep(new CEP("87250-000"));
		enderecoSacado.setBairro("Centro");
		enderecoSacado.setLogradouro("Rua do Mercado");
		enderecoSacado.setNumero("140");
		sacado.addEndereco(enderecoSacado);

		return sacado;
	}

	public static final Sacado criarSacado3() {

		Sacado sacado = new Sacado("Construtora ABC Ltda", "54463711000121");
		Endereco enderecoSacado = new Endereco();
		enderecoSacado.setUF(UnidadeFederativa.PR);
		enderecoSacado.setLocalidade("Campo Mourão");
		enderecoSacado.setCep(new CEP("87300-000"));
		enderecoSacado.setBairro("Centro");
		enderecoSacado.setLogradouro("Av. Manoel Mendes de Camargo");
		enderecoSacado.setNumero("340");
		sacado.addEndereco(enderecoSacado);

		return sacado;
	}

	public static final Sacado criarSacado4() {

		Sacado sacado = new Sacado("Imobiliaria S/C", "15222634000166");
		Endereco enderecoSacado = new Endereco();
		enderecoSacado.setUF(UnidadeFederativa.PR);
		enderecoSacado.setLocalidade("Araruna");
		enderecoSacado.setCep(new CEP("87260-000"));
		enderecoSacado.setBairro("Centro");
		enderecoSacado.setLogradouro("Av. Presidente Vargas");
		enderecoSacado.setNumero("140");
		sacado.addEndereco(enderecoSacado);

		return sacado;
	}

	private static Carteira criarCarteira() {
		Carteira carteira = new Carteira(1);
		carteira.setCodigoConvenio("123456");
		carteira.setNome("CARTEIRA");
		carteira.setTipoDeCobranca(TipoDeCobranca.COM_REGISTRO);
		carteira.setTipoDeDistribuicaoBoleto(TipoDeDistribuicaoBoleto.CLIENTE_DISTRIBUI);
		carteira.setTipoDeEmissaoBoleto(TipoDeEmissaoBoleto.CLIENTE_EMITE);
		return carteira;
	}

}
