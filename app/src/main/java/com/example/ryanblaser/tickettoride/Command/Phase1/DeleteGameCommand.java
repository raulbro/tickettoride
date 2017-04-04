package com.example.ryanblaser.tickettoride.Command.Phase1;

import com.example.ryanblaser.tickettoride.Client.ClientFacade;
import com.example.ryanblaser.tickettoride.Client.User;
import com.example.ryanblaser.tickettoride.Command.ICommand;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class DeleteGameCommand implements ICommand {
  private int int_game_id;
  private DeleteGameCommand(){}
  public DeleteGameCommand(int gameId){
	  int_game_id = gameId;}

  @JsonIgnore
  @Override
  public String getAuthenticationCode() {
    return null;
  }
  
  @Override
  public List<ICommand> execute(){
    ClientFacade.SINGLETON.removeGame(int_game_id);
    return null; //TODO: stub
  }


}
