angular.module("carrinhoApp").controller("GeneralController", GeneralController);

GeneralController.inject = [ '$scope', 'Produtos' ];

function GeneralController($scope, Produtos) {
	
	$scope.listaProdutos = Produtos.query();

	$scope.produtos = {};
	
	$scope.buttonText="Submit";
	
	$scope.saveProdutos = function() {
		if ($scope.produtos.id !== undefined) {
			Produtos.update($scope.produtos, function() {
				$scope.listaProdutos = Produtos.query();
				$scope.produtos = {};
				$scope.buttonText="Submit";
			});
		} else {
			Produtos.save($scope.produtos, function() {
				$scope.listaProdutos = Produtos.query();
				$scope.produtos = {};
			});
		}
	}

	$scope.updateProdutosInit = function(produtos) {
		$scope.buttonText="Atualizar";
		$scope.produtos = produtos;
	}

	$scope.deleteProdutos = function(produtos) {
		produtos.$delete({id: produtos.id}, function() {
			$scope.listaProdutos = Produtos.query();
		});
	}
	
	

	
}
