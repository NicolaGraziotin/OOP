package it.unibo.design.robot.components.impl;

import java.util.Objects;

import it.unibo.design.robot.components.api.ComposableRobot;
import it.unibo.design.robot.components.api.RobotPart;
import it.unibo.design.robot.components.api.RobotPartCollection;
import it.unibo.design.robot.impl.BaseRobot;

public class SimpleComposableRobot extends BaseRobot implements ComposableRobot {
    
    private final RobotPartCollection parts = new AdvancedArrayBasedPartCollection(-5);

    public SimpleComposableRobot(final String robotName) {
        super(robotName);
    }

    public final void attachComponent(final RobotPart rp) {
        Objects.requireNonNull(rp);
        rp.plug(this);
        if (rp.isPluggedTo(this)) {
            parts.add(rp);
        }
    }

    public final void doCycle() {
        parts.resetIterator();
        while (parts.hasAnotherPart()) {
            final RobotPart p = parts.next();
            if (p.isOn()) {
                if (p.isPluggedTo(this)) {
                    if (p.getEnergyRequired() < getBatteryLevel() && p.doOperation()) {
                        consumeBattery(p.getEnergyRequired());
                        log(p + " operated successfully.");
                    } else {
                        log(p + " did not work properly.");
                    }
                } else {
                    log(p + " is not connected.");
                }
            } else {
                log(p + " is off.");
            }
        }
    }

    public final void detachComponent(final RobotPart rp) {
        Objects.requireNonNull(rp);
        parts.remove(rp);
    }
    
}
