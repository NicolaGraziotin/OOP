package it.unibo.design.robot.components.impl;

import java.util.Arrays;

import it.unibo.design.robot.components.api.RobotPart;

public class AdvancedArrayBasedPartCollection extends AbstractArrayBasedPartCollection {
    public static final int DEFAULT_SIZE = 10;
    private RobotPart[] parts;
    private int realSize;

    public AdvancedArrayBasedPartCollection(final int initialSize) {
        super();
        parts = new RobotPart[Math.max(initialSize, 1)];
    }

    public AdvancedArrayBasedPartCollection() {
        this(DEFAULT_SIZE);
    }

    @Override
    public final void add(final RobotPart rp) {
        if (realSize >= parts.length) {
            expand();
        }
        parts[realSize++] = rp;
    }

    private void expand() {
        parts = Arrays.copyOf(parts, parts.length * 2);
    }

    @Override
    protected final int getSize() {
        return realSize;
    }

    @Override
    protected final RobotPart getPart(final int i) {
        return parts[i];
    }

    @Override
    protected void removePartAt(final int index) {
        realSize--;
        for (int i = index; i < realSize; i++) {
            parts[i] = parts[i + 1];
        }
        parts[realSize] = null;
    }

}
