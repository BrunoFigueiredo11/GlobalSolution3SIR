# GlobalSolution3SIR
Global Solution Microservice and Web Engineering

Imagine que você faz parte da equipe de desenvolvimento de software da empresa
"Tourism on Mars Company". O objetivo dessa empresa é proporcionar aos seus clientes a
possibilidade de visitar Marte até o ano 2.050. 

O time de operações tem como estimativa um tempo médio de
viagem de ida à Marte com 260 dias de duração. Estima-se o mesmo tempo para retorno ao
nosso planeta. Diante disso, o time de operações solicitou que fosse criado um sistema web
para realizar a gestão das viagens à Marte da empresa "Tourism on Mars Company".

1) Os requisitos funcionais estão enumerados abaixo:

· Cadastro de viagem à Marte;
· Listagem de viagens cadastradas;
· Alteração de viagens cadastradas;
· Exclusão de viagens cadastradas.

Para cadastrar a viagem à Marte, os seguintes dados deverão ser solicitados ao
analista de operações:

a) Data de decolagem. Formato dd/MM/yyyy (dd – dia, MM – mês, yyyy – Ano);

b) Duração de dias de estadia em Marte. (Somente números inteiros
positivos);

c) Quantidade de assentos disponíveis na nave (Somente inteiros, positivos,
multiplos de 3);

d) Nome do modelo da nave. No formato aaaa-9999, onde a são letras de a-z
e 9 representam números de 0 a 9.

e) Nome do Primeiro comandante. Texto livre, não nulo.

f) Matrícula interespacial do Primeiro comandante. Formato XXX-9999-X9X,
onde XXX é o código internacional do país de nascimento do comandante,
9999 é o ano de emissão do certificado interespacial de pilotagem e X9X é
um código sequencial de emissão do certificado.

g) Nome do Segundo comandante. Texto livre, não nulo.

h) Matrícula interespacial do Primeiro comandante. Formato XXX-9999-X9X,
onde XXX é o código internacional do país de nascimento do comandante,
9999 é o ano de emissão do certificado interespacial de pilotagem e X9X é
um código sequencial de emissão do certificado


2) Requisitos não funcionais

a) A aplicação deverá ser escrita utilizando Java com SpringBoot;

b) A aplicação deverá ter uma interface utilizando JSP ou Thymeleaf;

c) Os formatos de entrada de dados deverão ser validados;
