angular.module('carrinhoApp').factory('Carrinho', CarrinhoItem);

Produto.$inject=['$resource'];

function Carrinho($resource){
	
	var resourceUrl = 'carrinho/:id';
	
	return $resource(resourceUrl, {},{
		'update':{
			method: 'PUT', params:	{id: '@id'}
		}
	});
}