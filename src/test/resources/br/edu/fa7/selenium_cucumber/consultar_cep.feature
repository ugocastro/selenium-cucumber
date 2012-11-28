# language: pt

Funcionalidade: Pesquisa de CEP

	Como um usuario comum
	Gostaria de pesquisar enderecos no site dos Correios
	Para localizar CEPs

Cenario: CEP localizado com sucesso pela localidade e logradouro
	Dado que acesso o site dos Correios
	Quando clico no link "Busca CEP"
	Entao deveria visualizar "CEP por localidade | Logradouro"
	Quando clico no link "CEP por localidade | Logradouro"
	Entao deveria visualizar "Busca CEP - Localidade / Logradouro"
	Quando seleciono "CE" no campo UF
	E digito "Fortaleza" no campo Localidade
	E seleciono "Rua" no campo Tipo
	E digito "Senador Pompeu" no campo Logradouro
	E digito "2508" no campo Numero
	E clico no botao Buscar
	Entao deveria visualizar "Condomínio Liege"
	
Cenario: Exibicao de detalhes do CEP encontrado
	Dado que acesso o site dos Correios
	Quando clico no link "Busca CEP"
	Entao deveria visualizar "CEP por localidade | Logradouro"
	Quando clico no link "CEP por localidade | Logradouro"
	Entao deveria visualizar "Busca CEP - Localidade / Logradouro"
	Quando seleciono "CE" no campo UF
	E digito "Fortaleza" no campo Localidade
	E seleciono "Rua" no campo Tipo
	E digito "Senador Pompeu" no campo Logradouro
	E digito "2508" no campo Numero
	E clico no botao Buscar
	Entao deveria visualizar "Condomínio Liege"
	Quando clico no resultado "Condomínio Liege"
	Entao deveria visualizar "Cep Especial"
	E deveria visualizar "Condomínio Liege"
	E deveria visualizar "Rua Senador Pompeu, 2508"
	E deveria visualizar "Benfica"
	E deveria visualizar "Fortaleza/CE"
	E deveria visualizar "60025-900"
	
Cenario: CEP nao localizado pois logradouro nao existe
	Dado que acesso o site dos Correios
	Quando clico no link "Busca CEP"
	Entao deveria visualizar "CEP por localidade | Logradouro"
	Quando clico no link "CEP por localidade | Logradouro"
	Entao deveria visualizar "Busca CEP - Localidade / Logradouro"
	Quando seleciono "CE" no campo UF
	E digito "Fortaleza" no campo Localidade
	E seleciono "Rua" no campo Tipo
	E digito "Augusta Alves" no campo Logradouro
	E digito "143" no campo Numero
	E clico no botao Buscar
	Entao deveria visualizar "LOGRADOURO NAO ENCONTRADO."
	