package com.organization.mvcproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.organization.mvcproject.dao.MockGameDAO;
import com.organization.mvcproject.model.Game;

@Service()
public class GameServiceImpl implements GameService {

	@Autowired
	private MockGameDAO mockGameDAO;
	

	@Override
	public List<Game> retrieveAllGames() {
		return mockGameDAO.getAllGames();
	}

	@Override
	public Game saveGame(Game game) {
		return mockGameDAO.saveGame(game);
	}
	
	
	public Game updateGame(Game game) {
		return mockGameDAO.saveGame(game);
	}
	
	public boolean deleteGame(Long id) {
		return mockGameDAO.deleteGame(id);
	}

	@Override
	public Game findGameById(Long id) {
		return mockGameDAO.findGameById(id);
	}

	@Override
	public List<Game> findGameByGenre(Game game) {
		// TODO Auto-generated method stub
		return null;
	}
}