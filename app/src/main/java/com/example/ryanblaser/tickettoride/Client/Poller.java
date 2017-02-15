package com.example.ryanblaser.tickettoride.Client;

import com.example.ryanblaser.tickettoride.Command.AddJoinableToClientCommand;
import com.example.ryanblaser.tickettoride.Command.AddPlayerToClientCommand;
import com.example.ryanblaser.tickettoride.Command.AddResumableToClientCommand;
import com.example.ryanblaser.tickettoride.Command.CommandContainer;
import com.example.ryanblaser.tickettoride.Command.DeleteGameCommand;
import com.example.ryanblaser.tickettoride.Command.GetCommandsCommand;
import com.example.ryanblaser.tickettoride.Command.ICommand;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by RyanBlaser on 2/12/17.
 */

public class Poller {
    private final Timer timer = new Timer();
    public Poller()
    {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                checkForCommands();
            }
        };

        long delay = 60000; //counts in milisecs so 1min.

        timer.schedule(timerTask, delay);
    }

    public CommandContainer checkForCommands()
    {
        CommandContainer result = ServerProxy.SINGLETON.checkForCommands();
        ICommand command;
        for (int i = 0; i < result.str_type.size(); i++)
        {
            switch (result.str_type.get(i)) {
                case "AddJoinableToClientCommand" :
                    command = (AddJoinableToClientCommand) result.icommand.get(i);
                    break;
                case "DeleteGameCommand" :
                    command = (DeleteGameCommand) result.icommand.get(i);
                    break;
                case "AddResumableToClientCommand" :
                    command = (AddResumableToClientCommand) result.icommand.get(i);
                    break;
                case "AddPlayerToClientCommand" :
                    command = (AddPlayerToClientCommand) result.icommand.get(i);
                    break;
                default:
                    command = null;
                    break;
            }
            command.execute();
        }
        return result;
    }
}