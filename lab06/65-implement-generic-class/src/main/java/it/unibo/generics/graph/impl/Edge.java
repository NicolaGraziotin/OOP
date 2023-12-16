package it.unibo.generics.graph.impl;

public class Edge<N> {
    
    private final N source;
    private final N target;

    public Edge(final N source, final N target) {
        this.source = source;
        this.target = target;
    }

    public N getSource() {
        return source;
    }

    public N getTarget() {
        return target;
    }
}
