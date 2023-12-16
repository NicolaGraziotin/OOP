package it.unibo.generics.graph.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {

    private final Map<N, Set<Edge<N>>> edges = new LinkedHashMap<>();

    @Override
    public void addNode(N node) {
        edges.putIfAbsent(node, new HashSet<>());
    }

    @Override
    public void addEdge(N source, N target) {
        for ( var key : edges.keySet()) {
            if (key.equals(source)) {
                edges.get(source).add(new Edge<>(source, target));
            }
        }
    }

    @Override
    public Set<N> nodeSet() {
        return new HashSet<>(edges.keySet());
    }

    @Override
    public Set<N> linkedNodes(N node) {
        Set<N> link = new HashSet<>();
        for (var elem : edges.entrySet()) {
            for (var el : elem.getValue()) {
                if (el.getSource().equals(node)) {
                    link.add(el.getTarget());
                }
            }
        }
        return link;
    }

    @Override
    public List<N> getPath(N source, N target) {
        Queue<N> coda = new LinkedList<>();
        Set<N> visitato = new HashSet<>();
        Map<N, N> predecessore = new HashMap<>();
        List<N> percorso = new ArrayList<>();

        coda.add(source);
        visitato.add(source);
        predecessore.put(source, null);

        while (!coda.isEmpty()) {
            N nodoCorrente = coda.poll();

            if (nodoCorrente.equals(target)) {
                N nodo = target;
                while (nodo != null) {
                    percorso.add(nodo);
                    nodo = predecessore.get(nodo);
                }
                Collections.reverse(percorso);
                return percorso;
            }

            for (Edge<N> edge : edges.getOrDefault(nodoCorrente, Collections.emptySet())) {
                N nodoAdiacente = edge.getTarget();
                if (!visitato.contains(nodoAdiacente)) {
                    coda.add(nodoAdiacente);
                    visitato.add(nodoAdiacente);
                    predecessore.put(nodoAdiacente, nodoCorrente);
                }
            }
        }

        return Collections.emptyList();
    }
    
}
