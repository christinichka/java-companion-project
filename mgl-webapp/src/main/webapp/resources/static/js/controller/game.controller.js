'use strict';

angular.module('GameApp').controller('GameController',
		[ 'GameService', '$log', function(GameService) {
			var self = this;
			self.game = {
				id : '',
				name : '',
				genre : '',

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
				self.fetchAllGames();
				});
			}
			
			// Select a game to update
			self.updateGame = function(game) {
				self.game = game;
				return GameService.updateGame(game.id).then(function() {
				self.fetchAllGames();
				});
			}


			self.fetchAllGames();
		} ]);
