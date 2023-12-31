package it.unibo.design.robot.components.impl;

public class AtomicBattery extends AbstractPart {

    public AtomicBattery() {
        super("Atomic battery", 0);
    }
    
    public boolean doOperation() {
        if (isOn() && isPlugged()) {
            getRobot().recharge();
            System.out.println(this + " charged the battery to " + getRobot().getBatteryLevel());
            return true;
        }
        return false;
    }

    public String toString() {
        return "Atomic battery";
    }
}
