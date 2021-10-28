package com.organization.mvcproject.MGL_Task1.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import com.organization.mvcproject.config.MvcConfiguration;
import com.organization.mvcproject.model.Game;
import com.organization.mvcproject.service.GameService;

@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MvcConfiguration.class)
@WebAppConfiguration
@TestInstance(Lifecycle.PER_CLASS)
class GameServiceImplTest {
	
	
	@Autowired
	private GameService gameServiceUnderTest;
	
	private static Game testGame = createGame(1);
	
	private  static final String TEST_GENRE = "Test Genre";
	private static Game createGame(Integer number) {
		Game game = new Game();
		 game.setGame_name("Testing Game Name " + String.valueOf(number));
		 game.setGame_genre(TEST_GENRE);
		 return game;
	}
	
	private static List<Game> gamesToRemoveAfterTest = new ArrayList<>();
	
	@BeforeAll
	@Test
	void saveGameServiceSavesAndUpdatesGame() {
		if(gamesToRemoveAfterTest.isEmpty()) {
			Game game = gameServiceUnderTest.saveGame(testGame);
			assertNotNull(game.getGame_id());
			
			//updates 
			game.setGame_name("Testing Game Name Updated" );
			testGame = gameServiceUnderTest.saveGame(game);
			assertEquals(game, testGame);	
			gamesToRemoveAfterTest.add(testGame);
			//the saveGame works, save another game to setup list operation tests
			gamesToRemoveAfterTest.add(gameServiceUnderTest.saveGame(createGame(2)));
		}
	}
	

	
	@Test
  	void retrieveAllGamesServiceReturnsGames() {
		List<Game> games = gameServiceUnderTest.retrieveAllGames(); 
		assertNotNull(games);
		assertTrue(games.size() >= 2 );
	}
	
	
	


}
