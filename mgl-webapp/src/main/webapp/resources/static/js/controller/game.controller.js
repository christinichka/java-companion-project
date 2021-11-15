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
				}).finally( function() {
					self.game = {};
				});
			}
			
			self.deleteGame = function(game) {
				return GameService.deleteGame(game.id).then(function() {
				self.fetchAllGames();
				});
			}
			
			// Select a game to update
			self.selectGame = function(game) {
				self.game = game;
				self.fetchAllGames();
			}
			
			// Update a game
			self.updateGame = function() {
				return GameService.updateGame(self.game).then( function() {
				self.fetchAllGames();
				}).finally( function() {
					self.game = {};
				});
			}
			
			self.selectGame = function(game) {
				self.game = angular.copy(game);
				self.fetchAllGames();
			}


			self.fetchAllGames();
		} ]);
