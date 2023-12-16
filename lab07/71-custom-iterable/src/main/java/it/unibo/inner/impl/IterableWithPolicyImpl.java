package it.unibo.inner.impl;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T>{

    private final List<T> elements;
    private Predicate<T> predicate;

    public IterableWithPolicyImpl(final T[] elements, final Predicate<T> predicate) {
        this.elements = List.of(elements);
        this.predicate = predicate;
    }

    public IterableWithPolicyImpl(final T[] elements) {
        this(elements, new Predicate<T>() {

            @Override
            public boolean test(T elem) {
                return true;
            }
            
        });
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorImpl();
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        this.predicate = filter;
    }
    
    private class IteratorImpl implements Iterator<T> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            while (index < elements.size()) {
                T elem = elements.get(index);
                if (predicate.test(elem)) {
                    return true;
                }
                index++;
            }
            return false;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return elements.get(index++);
            }
            throw new NoSuchElementException();
        }

    }
}
