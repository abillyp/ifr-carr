angular.module("carrinhoApp").controller("ItemController", ItemController);

ItemController.inject = [ '$scope', 'Item' ];

function ItemController($scope, Item) {
	
	$scope.listaItem = Item.query();

	$scope.item = {};
	
	$scope.buttonText="Submit";
	
	$scope.saveItem = function() {
		if ($scope.item.id !== undefined) {
			Item.update($scope.item, function() {
				$scope.listaItem = Item.query();
				$scope.item = {};
				$scope.buttonText="Submit";
			});
		} else {
			Item.save($scope.item, function() {
				$scope.listaItem = Item.query();
				$scope.item = {};
			});
		}
	}

	$scope.updateItemInit = function(item) {
		$scope.buttonText="Atualizar";
		$scope.item = item;
	}

	$scope.deleteItem = function(item) {
		item.$delete({id: item.id}, function() {
			$scope.listaItem = Item.query();
		});
	}
	
	

	
}