angular.module("carrinhoApp").controller("GeneralController", GeneralController);

GeneralController.inject = [ '$scope', 'Produto' ];

function GeneralController($scope, Produto) {
	
	$scope.listaProdutos = Produto.query();

	$scope.produto = {};
	
	$scope.buttonText="Submit";
	
	$scope.saveProduto = function() {
		if ($scope.produto.id !== undefined) {
			Produto.update($scope.produto, function() {
				$scope.listaProdutos = Produto.query();
				$scope.produto = {};
				$scope.buttonText="Submit";
			});
		} else {
			Produto.save($scope.produto, function() {
				$scope.listaProdutos = Produto.query();
				$scope.produto = {};
			});
		}
	}

	$scope.updateProdutoInit = function(produto) {
		$scope.buttonText="Atualizar";
		$scope.produto = produto;
	}

	$scope.deleteProduto = function(produto) {
		produto.$delete({id: produto.id}, function() {
			$scope.listaProdutos = Produto.query();
		});
	}
	
	

	
}