# API de produtos
## Descrição do projeto

Uma API em java que realiza um CRUD de produtos, ele faz a busca de produtos
por ID, nome e categoria.

Como essa aplicação é somente o Backend, ela não renderisa os dados em página html.

# Tecnologias utilizadas
* **Git** : Controle de versionamento do sistema.
* **Spring Boot** : Framework mais usado e mais completo hoje em dia para desenvolvimento Web Java.
* **Spring Tool Suite**: IDE para desenvolvimento Java feito para usar o Spring Boot.
* **Maven 4** : Disponibiliza várias bibliotecas e Api que facilitam o desenvolvimento.
* **Postman**: É uma API client que facilita criar, compartilhar, testar e documentar APIs, permitindo aos usuários criar e salvar solicitações HTTP e HTTPs simples e complexas.
* **PostgreSQL** : Sistema gerenciador de banco de dados objeto relacional (SGBD), fácil de usar com a sua interface gráfica.


# Instruções para Executar o sistema

## Pré-requisito

* Git
* Spring Tool Suite
* PgAdmin
* Postman

## Passos

- Abrir um terminal ou linha de comando(Botão Windows + R, digitar cmd e apertar Enter (no Windows))
- Navegar até onde quiser baixar o repositório
- No terminal, colar essa linha e apertar Enter
  
  ```
  https://github.com/Alison-silva/apiprodutos.git
  ```
  
- Abrir O PgAdmin e criar um banco de dados com o nome produtodb
- Abrir o Spring Tool Suite e clicar em File e depois em Import
- Na nova janela que aparece, escrever no campo do pesquisa maven
- Uma pasta com o nome Maven aparece. Dentro dessa pasta, clicar em Existing Maven Projects e clicar em Next
- Na próxima página, clicar em Browse... e navegar até a pasta apiprodutos e clicar abrir.
- Clicar em Finish
- Esperar o download das dependências do Maven
- Clique com o botão direito no projeto e escolhe a opção 'Run as' e depois escolher 'Spring Boot App'
- O projeto está agora rodando.

Se ele apresentar um erro, abra o pacote src/main/resources e depois abra o arquivo application.properties.
Coloque o usuário e a senha que você atribuiu ao postgres
 ```
spring.datasource.username= <coloque seu username>
spring.datasource.password= <coloque sua senha>
```

## Usando a aplicação

Abra o POSTMAN na aba Workspaces, selecione uma requisição POST e coloque END-POINT
http://localhost:8080/category e insira a categoria. Ex: leitura, eletronico ou vestuário...
```
{
  "category":"eletronico"
}
```
Após isso você poderá listar as categorias com uma requisição GET utilizando o mesmo
END-POINT http://localhost:8080/category , resultado:
```
{
   {
        "id": 1,
        "category": "vestuário"
    },
    {
        "id": 2,
        "category": "eletronico"
    }
}
```
Agora vamos cadastrar um produto, usando uma requisição POST com o END-POINT 
**localhost:8080/products** , informando o nome do produto, preço, quantidade
e o id da categoria:
```
{
   "name": "Monitor Gamer",
   "price": 594.90,
   "amount": 1,
   "category": {
       "id": 2
   }
}
```
Para listar os produtos cadastrados, deve-se usar uma requisição GET no END-POINT
**localhost:8080/products** para obter um resultado semelhante a esse:
```
[
   {
        "id": 1,
        "name": "Camiseta Nike Sportwear Icon Futura Masculina",
        "price": 85.49,
        "amount": 3,
        "category": {
            "id": 1,
            "category": "vestuário"
        }
    },
    {
        "id": 2,
        "name": "Monitor Gamer",
        "price": 594.90,
        "amount": 1,
        "category": {
            "id": 2,
            "category": "eletronico"
        }
    }
]
```
Para atualizar um produto usar a requisição PUT no END-POINT **localhost:8080/products** ,
informando os dados do produto junto com ID:
```
{
   "id": 2,
   "name": "Monitor Gamer 2024",
   "price": 500.90,
   "amount": 2,
   "category": {
       "id": 2
   }
}
```
Para deletar o produto, usar uma requisição DELETE com o END-POINT
**localhost:8080/products/{id}** , no lugar do {id} colocar o ID do produto, EX:
**localhost:8080/products/2** , e vai exibir a seguinte mensagem:
```
Deletado com sucesso!
```
Nessa API conseguimos realizar buscas específicas, uma delas é por nome usando a requisição
GET com o END-POINT **/productforname/{name}** , que vai realizar a busca pelo nome do produto,
no lugar de {name} irforme o nome do produto.
A outra busca é por categoria usando o END-POINT **/productforname/{category}**
no lugar de {category} informe uma categoria.

