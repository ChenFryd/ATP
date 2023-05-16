package Exercise2;

import java.util.LinkedList;
import java.util.Queue;

public class Invoker {
    private Queue<ICommand> commands;
    public Invoker(){
        commands = new LinkedList<>();
    }
    public void insertCommand(ICommand command){
        commands.add(command);
    }
    public void executeAll(){
        while (!commands.isEmpty()){
            commands.poll().execute();
        }
    }
}
