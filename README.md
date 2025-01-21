# Conversor de Moedas em Java 💱

Este é um projeto do Challenge da Alura/ONE de um **Conversor de Moedas** desenvolvido em **Java**. O conversor utiliza uma API externa para obter taxas de câmbio em tempo real,
permitindo a conversão entre várias moedas, como USD, ARS, BOB, BRL, CLP e COP.

## 📃 Funcionalidades

- **Conversão entre moedas**: O programa permite que você converta entre várias moedas.
- **API de câmbio em tempo real**: As taxas de câmbio são obtidas de uma API pública para garantir que as conversões sejam precisas e atualizadas.
- **Interface no console**: A interação é feita via console, onde o usuário escolhe as moedas de origem e destino e insere o valor a ser convertido.

## 💻 Tecnologias Utilizadas

- **Java**: A linguagem principal usada para desenvolver o conversor de moedas.
- **Gson**: Biblioteca para análise de JSON, usada para processar a resposta da API.
- **API de câmbio**: A API usada para obter as taxas de câmbio em tempo real é [Exchangerate-API](https://v6.exchangerate-api.com).


```
Selecione a conversão de moeda:
1. USD -> ARS
2. USD -> BOB
3. USD -> BRL
4. USD -> CLP
5. USD -> COP
6. ARS -> USD
7. BOB -> USD
8. BRL -> USD
9. CLP -> USD
10. COP -> USD
0. Sair
Escolha uma opção:
```
