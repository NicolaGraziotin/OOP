package it.unibo.design.robot.components.api;

public interface RobotPartCollection {

    void add(RobotPart robotPart);

    void resetIterator();

    boolean hasAnotherPart();

    RobotPart next();

    void remove(RobotPart robotPart);
}
