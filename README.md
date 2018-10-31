# infracommerce-carrinho

EndPoints : 

Produtos: (Os produtos podem ser cadastrados pela página principal - index.html

GET /produtos: Listagem de produtos;
POST /produtos: Adição de um produto;
GET /produtos/{id}: Detalhes de um produto;
PUT /produtos/{id}: Atualização de um produto;
DELETE /produtos/{id}: Remoção de um produto.


Movimentação do Carrinho

GET /carrinhos: Listagem de itens no carrinho;
POST /carrinhos: Adição de itens no carrinho;
GET /carrinhos/{id}: Detalhes de itens no carrinho;
PUT /carrinhos/{id}: Atualização de itens no carrinho;
DELETE /carrinhos/{id}: Remoção de itens no carrinho;

Script para criação do BD, estão na pasta CarrinhoCompras/src/main/resources/

Produtos disponiveis para teste: 
id  nome
1   tenis
2   oculos
3   calça
4   meia
5   bone
