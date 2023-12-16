package it.unibo.generics.graph.impl;

import java.util.Deque;

import it.unibo.generics.graph.api.FringeAccumulationStrategy;

public final class BreadthFirst<S> implements FringeAccumulationStrategy<S> {

    private static final BreadthFirst<?> INSTANCE = new BreadthFirst<>();

    public BreadthFirst() {
    }

    @SuppressWarnings("unchecked")
    public static <S> BreadthFirst<S> getInstance() {
        return (BreadthFirst<S>) INSTANCE;
    }

    @Override
    public void addToFringe(Deque<? super S> fringe, S step) {
        fringe.addLast(step);
    }
    
}
