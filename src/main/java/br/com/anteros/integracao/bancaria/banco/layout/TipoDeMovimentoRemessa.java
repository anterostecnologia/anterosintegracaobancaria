/*******************************************************************************
 * Copyright 2016 Anteros Tecnologia
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package br.com.anteros.integracao.bancaria.banco.layout;

import static java.lang.String.format;

public enum TipoDeMovimentoRemessa {
	
	ENTRADA_TITULOS(1),
	PEDIDO_BAIXA(2),
	PROTESTO_FINS_FALIMENTARES(3),
	CONCESSAO_ABATIMENTO(4),
	CANCELAMENTO_ABATIMENTO(5),
	ALTERACAO_VENCIMENTO(6),
	CONCESSAO_DESCONTO(7),
	CANCELAMENTO_DESCONTO(8),
	PROTESTAR(9),
	SUSTAR_PROTESTO_BAIXAR_TITULO(10),
	SUSTAR_PROTESTO_MANTER_CARTEIRA(11),
	ALTERACAO_JUROS_MORA(12),
	DISPENSAR_COBRANCA_JUROS_MORA(13),
	ALTERACAO_VL_PERCENTUAL_MULTA(14),
	DISPENSAR_COBRANCA_MULTA(15),
	ALTERACAO_VALOR_DESCONTO(16),
	NAO_CONCEDER_DESCONTO(17),
	ALTERACAO_VALOR_ABATIMENTO(18),
	PRAZO_LIMITE_RECEBIMENTO_ALTERAR(19),
	PRAZO_LIMITE_RECEBIMENTO_DISPENSAR(20),
	ALTERAR_NR_TITULO_DADO_BENEFICIARIO(21),
	ALTERAR_NR_CONTROLE_PARTICIPANTE(22),
	ALTERAR_DADOS_PAGADOR(23),
	ALTERAR_DADOS_SACADOR_AVALISTA(24),
	RECUSA_ALEGACAO_PAGADOR(30),
	ALTERACAO_OUTROS_DADOS(31),
    ALTERACAO_DADOS_RATEIO_CREDITO(33),
    PEDIDO_CANCELAMENTO_DADOS_RATEIO_CREDITO(34),
    PEDIDO_DESAGENDAMENTO_DEBITO_AUTOMATICO(35),
    ALTERACAO_CARTEIRA(40),
    CANCELAR_PROTESTO(41),
    ALTERACAO_ESPECIE_TITULO(42),
    TRANSFERENCIA_CARTEIRA_MODALIDADE_COBRANCA(43),
    ALTERACAO_CONTRATO_COBRANCA(44),
    NEGATIVACAO_SEM_PROTESTO(45),
    SOLICITACAO_BAIXA_TITULO_NEGATIVADO_SEM_PROTESTO(46);
    
    
    
    private Integer tipo;

	private TipoDeMovimentoRemessa(Integer tipo){
		this.tipo = tipo;
	}
	
	public Integer getTipo(){
		return tipo;
	}
	
	public static TipoDeMovimentoRemessa valueOfTipo(Integer tipo){
		for(TipoDeMovimentoRemessa t : values()){
			if(t.getTipo().equals(tipo)){
				return t;
			}
		}
		throw  new IllegalArgumentException(format("Nenhuma constante enum %s com tipo igual a %s!", TipoDeMovimentoRemessa.class, tipo));
	}

}
