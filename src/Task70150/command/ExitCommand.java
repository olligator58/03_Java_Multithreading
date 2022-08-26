package Task70150.command;

import Task70150.ConsoleHelper;

public class ExitCommand implements Command {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("До встречи!");
    }
}
