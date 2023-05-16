package Exercise2;

public class Lamp {
    private boolean lightOn;
    public Lamp(){
        lightOn = false;
        System.out.println("The lamp is now inialized and now is off");
    }
    public void turnLightOn(){
        lightOn = true;
        System.out.println("The lamp is now on");
    }
    public void turnLightOff(){
        lightOn = false;
        System.out.println("The lamp is now off");
    }
}
