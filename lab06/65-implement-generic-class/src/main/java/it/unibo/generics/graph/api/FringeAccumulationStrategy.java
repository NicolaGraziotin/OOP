package it.unibo.generics.graph.api;

import java.util.Deque;

public interface FringeAccumulationStrategy<S> {
    
    void addToFringe(Deque<? super S> fringe, S step);
}
