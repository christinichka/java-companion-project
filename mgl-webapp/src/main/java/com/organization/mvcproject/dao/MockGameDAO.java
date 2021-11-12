/**
 * 
 */
package com.organization.mvcproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.model.Game;

/**
 * @author christina.varghese
 *
 */

@Repository
public class MockGameDAO {
	@SuppressWarnings("deprecation")
	private static Long gameId = new Long(0);
//	private static Long companyId = new Long(0);
	private static List<Game> games = new ArrayList<>();

	static {
		games = populateGames();
	}

	private static List<Game> populateGames() {

		Game game1 = new Game();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		Game game2 = new Game();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		Game game3 = new Game();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}

	public List<Game> getAllGames() {
		return games;
	}
	
	

	public Game saveGame(Game game) {
		if (game.getId() != null) {
			Game foundGame = findGameById(game.getId());
			if (foundGame != null) {
				// Update the game list
				for (int i = 0; i < games.size(); i++) {
					if (game.getId().equals(games.get(i).getId())) {
						return games.set(i, game);					}
				}
			}
		}
		// you might want logic to see if an id exists, but isn't on the database?
		// if so, you might want to throw an exception?
		
		game.setId(++gameId); // ++ to increment is our mock logic for creating an ID.
		games.add(game);
		return game;
	}

	public Game findGameById(Long id) {
		for (Game game : games) {
			if (id.equals(game.getId())) {
				return game;
			}
		}
		return null;
	}
	
//	// delete game
	public boolean deleteGame(Long id) {
		for(int i = 0; i < games.size(); i++) {
			if (id == (games.get(i).getId())) {
				games.remove(games.get(i));
				return true;
			}
		}
		return false;
	}
	
	// update game
	public Game updateGame(Game game) {
		
		// updates game
		for (int i = 0; i < games.size(); i++) {
			if (game.getId().equals(games.get(i).getId())) {
				return games.set(i, game);					}
		}
		return game;
		
	}

}
