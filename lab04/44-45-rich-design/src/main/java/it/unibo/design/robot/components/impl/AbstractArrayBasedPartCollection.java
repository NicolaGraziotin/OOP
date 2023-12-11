package it.unibo.design.robot.components.impl;

import it.unibo.design.robot.components.api.RobotPart;
import it.unibo.design.robot.components.api.RobotPartCollection;

public abstract class AbstractArrayBasedPartCollection implements RobotPartCollection {
    
    private int iteratorIndex;

    protected abstract int getSize();

    protected abstract RobotPart getPart(int i);

    protected abstract void removePartAt(int i);

    @Override
    public final void resetIterator() {
        iteratorIndex = 0;
    }

    @Override
    public final boolean hasAnotherPart() {
        return iteratorIndex < getSize();
    }

    @Override
    public final RobotPart next() {
        if (hasAnotherPart()) {
            return getPart(iteratorIndex++);
        }
        return null;
    }

    private int indexOf(final RobotPart rp) {
        for (int i = 0; i < getSize(); i++) {
            if (getPart(i).equals(rp)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public final void remove(final RobotPart rp) {
        final int index = indexOf(rp);
        if (index >= 0) {
            removePartAt(index);
        }
    }

}
