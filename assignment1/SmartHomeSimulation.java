package assignment1;
abstract class SmartDevice {
    String name;

    SmartDevice(String name) {
        this.name = name;
        System.out.println(name + " device created.");
    }

    abstract void turnOn();
    abstract void turnOff();

    @Override
    protected void finalize() throws Throwable {
        System.out.println(name + " device cleaned up.");
    }
}

class SmartLight extends SmartDevice {
    SmartLight(String name) {
        super(name);
    }
    void turnOn() {
        System.out.println(name + " light is ON.");
    }
    void turnOff() {
        System.out.println(name + " light is OFF.");
    }
}

class SmartFan extends SmartDevice {
    SmartFan(String name) {
        super(name);
    }
    void turnOn() {
        System.out.println(name + " fan is ON.");
    }
    void turnOff() {
        System.out.println(name + " fan is OFF.");
    }
}

public class SmartHomeSimulation {
    public static void main(String[] args) {
        SmartDevice light = new SmartLight("Living Room");
        SmartDevice fan = new SmartFan("Bedroom");

        light.turnOn();
        fan.turnOn();

        light.turnOff();
        fan.turnOff();

        light = null;
        fan = null;

        System.gc(); // Request garbage collection
    }
}
