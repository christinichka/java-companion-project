package com.organization.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.organization.mvcproject.model.Game;
import com.organization.mvcproject.service.GameService;
import com.organization.mvcproject.service.GameServiceImpl;

@RequestMapping(value ="/game")
@RestController
public class GameController {

	@Autowired
	private GameService gameService;

	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Game>> fetchAllGames() {
		return new ResponseEntity<List<Game>>(gameService.retrieveAllGames(), HttpStatus.OK);
	}
	
	// creates and adds to list of games I had "/" previously for create and update
	@PostMapping(value = "/createGame", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody Game game) {
		gameService.saveGame(game);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	// updates a game 
	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateGame(@RequestBody Game game) {
		gameService.saveGame(game);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	// deletes game with specified id
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteGame(@PathVariable Long id) {
		boolean didGameDelete = gameService.deleteGame(id);
		return new ResponseEntity<>(didGameDelete, HttpStatus.OK);
	}
	
	// gets game of specified id
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getGameById(@PathVariable Long id) {
		Game gameOfId = gameService.findGameById(id);
		return new ResponseEntity<>(gameOfId, HttpStatus.OK);
	}
	
	// Make a find by genre using List<>
	
}