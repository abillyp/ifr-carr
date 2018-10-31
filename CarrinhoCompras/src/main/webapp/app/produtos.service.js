angular.module('carrinhoApp').factory('Produtos', Produtos);

Produtos.$inject=['$resource'];

function Produtos($resource){
	
	var resourceUrl = 'produtos/:id';
	
	return $resource(resourceUrl, {},{
		'update':{
			method: 'PUT', params:	{id: '@id'}
		}
	});
}
