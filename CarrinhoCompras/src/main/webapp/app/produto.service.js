angular.module('carrinhoApp').factory('Produto', Produto);

Produto.$inject=['$resource'];

function Produto($resource){
	
	var resourceUrl = 'produto/:id';
	
	return $resource(resourceUrl, {},{
		'update':{
			method: 'PUT', params:	{id: '@id'}
		}
	});
}