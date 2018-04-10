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
import br.com.anteros.integracao.bancaria.banco.layout.Agencia;
import br.com.anteros.integracao.bancaria.banco.layout.Carteira;
import br.com.anteros.integracao.bancaria.banco.layout.Cedente;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.NumeroDaConta;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.layout.Sacado;
import br.com.anteros.integracao.bancaria.banco.layout.TipoDeBaixaDevolucao;
import br.com.anteros.integracao.bancaria.banco.layout.TipoDeCobranca;
import br.com.anteros.integracao.bancaria.banco.layout.TipoDeDistribuicaoBoleto;
import br.com.anteros.integracao.bancaria.banco.layout.TipoDeEmissaoBoleto;
import br.com.anteros.integracao.bancaria.banco.layout.TipoDeMovimentoRemessa;
import br.com.anteros.integracao.bancaria.banco.layout.TipoDesconto;
import br.com.anteros.integracao.bancaria.banco.layout.TipoJurosMora;
import br.com.anteros.integracao.bancaria.banco.layout.TipoMoeda;
import br.com.anteros.integracao.bancaria.banco.layout.TipoMulta;
import br.com.anteros.integracao.bancaria.banco.layout.TipoProtesto;
import br.com.anteros.integracao.bancaria.banco.layout.TipoTitulo;
import br.com.anteros.integracao.bancaria.banco.layout.Titulo;
import br.com.anteros.integracao.bancaria.banco.layout.Titulo.Aceite;
import br.com.anteros.integracao.bancaria.util.Constants;

public class CNAB240Helper {

	public static List<RemessaCobranca> gerarTitulosParaRemessaCobranca(Banco banco, Carteira carteira) {
		List<RemessaCobranca> result = new ArrayList<RemessaCobranca>();
		ContaBancaria contaBancaria = criarContaBancaria(banco);
		Cedente cedente = criarCedente(banco);
		if (banco.getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.CAIXA_ECONOMICA_FEDERAL)) {
			result.add(criarRemessa(contaBancaria, cedente, carteira, criarSacado1(), new BigDecimal("12347.34"),
					"100000001", DateUtil.stringToDate("10/05/2016", "dd/MM/yyyy"), "12345605009401448", "1", 1000));
			result.add(criarRemessa(contaBancaria, cedente, carteira, criarSacado2(), new BigDecimal("52347.14"),
					"100000001", DateUtil.stringToDate("15/06/2016", "dd/MM/yyyy"), "12345605009401449", "1", 1000));
			result.add(criarRemessa(contaBancaria, cedente, carteira, criarSacado3(), new BigDecimal("61247.24"),
					"100000001", DateUtil.stringToDate("12/07/2016", "dd/MM/yyyy"), "12345605009401440", "1", 1000));
			result.add(criarRemessa(contaBancaria, cedente, carteira, criarSacado4(), new BigDecimal("234.54"),
					"100000001", DateUtil.stringToDate("11/08/2016", "dd/MM/yyyy"), "12345605009401447", "1", 1000));
		} else if (banco.getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.ITAU)) {
			result.add(criarRemessa(contaBancaria, cedente, carteira, criarSacado1(), new BigDecimal("12347.34"),
					"100000001", DateUtil.stringToDate("10/05/2016", "dd/MM/yyyy"), "09401448", "1", 1000));
			result.add(criarRemessa(contaBancaria, cedente, carteira, criarSacado2(), new BigDecimal("52347.14"),
					"100000001", DateUtil.stringToDate("15/06/2016", "dd/MM/yyyy"), "09401449", "1", 1000));
			result.add(criarRemessa(contaBancaria, cedente, carteira, criarSacado3(), new BigDecimal("61247.24"),
					"100000001", DateUtil.stringToDate("12/07/2016", "dd/MM/yyyy"), "09401440", "1", 1000));
			result.add(criarRemessa(contaBancaria, cedente, carteira, criarSacado4(), new BigDecimal("234.54"),
					"100000001", DateUtil.stringToDate("11/08/2016", "dd/MM/yyyy"), "09401447", "1", 1000));
		} else if (banco.getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.HSBC)) {
			result.add(criarRemessa(contaBancaria, cedente, carteira, criarSacado1(), new BigDecimal("12347.34"),
					"100000001", DateUtil.stringToDate("10/05/2016", "dd/MM/yyyy"), "5009401448", "1", 1000));
			result.add(criarRemessa(contaBancaria, cedente, carteira, criarSacado2(), new BigDecimal("52347.14"),
					"100000001", DateUtil.stringToDate("15/06/2016", "dd/MM/yyyy"), "5009401449", "1", 1000));
			result.add(criarRemessa(contaBancaria, cedente, carteira, criarSacado3(), new BigDecimal("61247.24"),
					"100000001", DateUtil.stringToDate("12/07/2016", "dd/MM/yyyy"), "5009401440", "1", 1000));
			result.add(criarRemessa(contaBancaria, cedente, carteira, criarSacado4(), new BigDecimal("234.54"),
					"100000001", DateUtil.stringToDate("11/08/2016", "dd/MM/yyyy"), "5009401447", "1", 1000));
		} else {
			result.add(criarRemessa(contaBancaria, cedente, carteira, criarSacado1(), new BigDecimal("376.80"), 
					"429106-FR/1", DateUtil.stringToDate("02/11/2017", "dd/MM/yyyy"), "001790000901014", "1", 1000));
			result.add(criarRemessa(contaBancaria, cedente, carteira, criarSacado2(), new BigDecimal("52347.14"),
					"100000001", DateUtil.stringToDate("15/06/2016", "dd/MM/yyyy"), "05009401449", "1", 1000));
			result.add(criarRemessa(contaBancaria, cedente, carteira, criarSacado3(), new BigDecimal("61247.24"),
					"100000001", DateUtil.stringToDate("12/07/2016", "dd/MM/yyyy"), "05009401440", "1", 1000));
			result.add(criarRemessa(contaBancaria, cedente, carteira, criarSacado4(), new BigDecimal("234.54"),
					"100000001", DateUtil.stringToDate("11/08/2016", "dd/MM/yyyy"), "05009401447", "1", 1000));
		}
		return result;
	}

	private static RemessaCobranca criarRemessa(ContaBancaria contaBancaria, Cedente cedente, Carteira carteira,
			Sacado sacado, BigDecimal valorTitulo, String numeroDocumento, Date dataVencimento, String nossoNumero,
			String digitoNossoNumero, Integer nrLote) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, Calendar.MAY, 10);
		Titulo titulo = new Titulo(contaBancaria, sacado, cedente, carteira);
		titulo.setAceite(Aceite.A);
		titulo.setDataDocumento(DateUtil.stringToDate("03/10/2017", "dd/MM/yyyy"));
		titulo.setDataVencimento(dataVencimento);
		titulo.setDataJurosMora(DateUtil.stringToDate("03/11/2017", "dd/MM/yyyy"));
		titulo.setDigitoNossoNumero("1");
		titulo.setJurosMora(BigDecimal.TEN);
		titulo.setNossoNumero(nossoNumero);
		titulo.setNrDiasBaixaDevolucao(10);
		titulo.setNrDiasProtesto(3);
		titulo.setNumeroDocumento(numeroDocumento);
		titulo.setTipoBaixaDevolucao(TipoDeBaixaDevolucao.NAO_BAIXAR);
		titulo.setTipoDesconto(TipoDesconto.NAO_CONCEDER_DESCONTO);
		titulo.setTipoDocumento(TipoTitulo.DM_DUPLICATA_MERCANTIL);
		titulo.setTipoJurosMora(TipoJurosMora.TAXA_MENSAL);
		titulo.setTipoMoeda(TipoMoeda.REAL);
		titulo.setTipoProtesto(TipoProtesto.PROTESTAR_DIAS_UTEIS);
		titulo.setValorTitulo(valorTitulo);
		titulo.setValorAcrecimo(BigDecimal.TEN);
		titulo.setValorCobrado(valorTitulo);
		titulo.setValorDeducao(BigDecimal.TEN);
		titulo.setTipoMulta(TipoMulta.PERCENTUAL);
		titulo.setPercentualMulta(new BigDecimal("2.00"));
		titulo.setDataMulta(DateUtil.stringToDate("03/11/2017", "dd/MM/yyyy"));
		titulo.setValorJurosMoraPorAtraso(new BigDecimal("33.00"));

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
		telefone.setTelefone("35621206");
		return telefone;
	}

	public static ContaBancaria criarContaBancaria(Banco banco) {
		Agencia agencia = new Agencia(4340, "0");
		NumeroDaConta numeroDaConta = new NumeroDaConta(110042L, "4");
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
		CEP cep = new CEP("87260000");
		cep.setPrefixo(87260);
		cep.setSufixo(000);
		enderecoSacado.setCep(cep);
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
		CEP cep = new CEP("87260000");
		cep.setPrefixo(87260);
		cep.setSufixo(000);
		enderecoSacado.setCep(cep);
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
		CEP cep = new CEP("87303180");
		cep.setPrefixo(87303);
		cep.setSufixo(180);
		enderecoSacado.setCep(cep);
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
		CEP cep = new CEP("87260000");
		cep.setPrefixo(87260);
		cep.setSufixo(000);
		enderecoSacado.setCep(cep);
		enderecoSacado.setBairro("Centro");
		enderecoSacado.setLogradouro("Av. Presidente Vargas");
		enderecoSacado.setNumero("140");
		sacado.addEndereco(enderecoSacado);

		return sacado;
	}

	public static Carteira criarCarteira(int codigoCarteira) {
		Carteira carteira = new Carteira(codigoCarteira);
		carteira.setCodigo(1);
		carteira.setCodigoConvenio("      ");
		carteira.setNome("CARTEIRA");
		carteira.setTipoDeCobranca(TipoDeCobranca.COM_REGISTRO);
		carteira.setTipoDeDistribuicaoBoleto(TipoDeDistribuicaoBoleto.CLIENTE_DISTRIBUI);
		carteira.setTipoDeEmissaoBoleto(TipoDeEmissaoBoleto.CLIENTE_EMITE);
		return carteira;
	}

}
