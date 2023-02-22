package by.ivankov.web.command;

import by.ivankov.web.command.impl.AddUserCommand;
import by.ivankov.web.command.impl.DefaultCommand;
import by.ivankov.web.command.impl.LoginCommand;
import by.ivankov.web.command.impl.LogoutCommand;

public enum CommandType {
    ADD_USER(new AddUserCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    DEFAULT(new DefaultCommand());
    Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public static Command define(String commandStr){
       CommandType current = CommandType.valueOf(commandStr.toUpperCase());
       return current.command;
    }
}
