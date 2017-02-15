package com.example.ryanblaser.tickettoride.Database;

import com.example.ryanblaser.tickettoride.ServerModel.GameModels.Game;
import com.example.ryanblaser.tickettoride.ServerModel.Models.GameModel;
import com.example.ryanblaser.tickettoride.ServerModel.UserModel.User;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by benjamin on 10/02/17.
 */
public interface iDAO {

    public User getUserFromId(int userId);

    public int getUserId(String userName);

    public Game getGameFromId(int gameId);

    public Boolean login(String userName, String password) throws SQLException;

    public Boolean authenticateUserWithToken(String token) throws SQLException;

    public User getUserByUserName(String username) throws SQLException;

    public User getUserByAccessToken(String token) throws SQLException;

    public Boolean registerUser(String userName, String password) throws SQLException;

    public void initializeDB();

    public List<GameModel> getGamesByUserName(String userName) throws SQLException;

    public List<GameModel> getAllGames()  throws SQLException;

}