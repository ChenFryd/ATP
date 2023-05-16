package Exercise2;

public class TurnLampOnCommand implements ICommand{
    private Lamp _lamp;
    public TurnLampOnCommand(Lamp lamp){
        _lamp = lamp;
    }
    public void execute(){
        _lamp.turnLightOn();
    }
}
