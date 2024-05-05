package Exercise2;

public class TurnLampOffCommand implements ICommand{
    private Lamp _lamp;

    public TurnLampOffCommand(Lamp lamp){
        _lamp = lamp;
    }
    public void execute(){
        _lamp.turnLightOff();
    }
}
