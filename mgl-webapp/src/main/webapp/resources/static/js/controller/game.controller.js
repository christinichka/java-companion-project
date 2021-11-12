'use strict';

angular.module('GameApp').controller('GameController',
		[ 'GameService', '$log', function(GameService) {
			var self = this;
			self.game = {
				id : '',
				name : '',
				genre : '',
				//deleteGame : deleteGame
			};
			self.games = [];

			self.fetchAllGames = function(){
				GameService.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function(){
				return GameService.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}
			
			// Adding in delete game functionality
			self.deleteGame = function(game) {
				return GameService.deleteGame(game.id).then(function() {
				/*if (data === false) {
					$log.debug("Game with id: " + game.id + " was deleted.");				
				}*/
				self.fetchAllGames();
				});
			}
			
			// Select a game to update


			self.fetchAllGames();
		} ]);
