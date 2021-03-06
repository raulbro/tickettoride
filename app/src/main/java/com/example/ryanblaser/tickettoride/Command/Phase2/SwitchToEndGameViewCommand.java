package com.example.ryanblaser.tickettoride.Command.Phase2;

import com.example.ryanblaser.tickettoride.Client.IClient;
import com.example.ryanblaser.tickettoride.Client.User;
import com.example.ryanblaser.tickettoride.Command.ICommand;
import com.example.ryanblaser.tickettoride.GUI.Presenters.GameBoardPresenter;
import com.example.ryanblaser.tickettoride.Server.IServer;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


public class SwitchToEndGameViewCommand implements ICommand {

	private String longestPathHolder;

	public SwitchToEndGameViewCommand(){}

	@Override
	public List<ICommand> execute() throws IServer.GameIsFullException, IClient.UserAlreadyLoggedIn {
		GameBoardPresenter._SINGLETON.switchToEndGameView(longestPathHolder);
		return null;
	}

	@JsonIgnore
	@Override
	public String getAuthenticationCode() {
		return null;
	}
	public String getLongestPathHolder() {
		return longestPathHolder;
	}
}
