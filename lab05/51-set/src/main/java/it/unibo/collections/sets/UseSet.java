package it.unibo.collections.sets;

import java.util.Collection;
import java.util.TreeSet;

/**
 * Example class using {@link java.util.Set}.
 *
 */
public final class UseSet {

    private static final int ELEMS = 20;

    private UseSet() {
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String[] args) {
        /*
         * Considering the content of "UseCollection, write a program which, in
         * order:
         *
         * 1) Builds a TreeSet containing Strings
         */
        final Collection<String> treeSet = new TreeSet<>();

        /*
         * 2) Populates such Collection with all the Strings representing numbers ranging from "1" to
         * "20" (both included)
         */
        for (int i = 0; i < ELEMS; i++) {
            treeSet.add(String.valueOf(i+1));
        }

        /*
         * 3) Prints its content
         */
        System.out.println(treeSet);

        /*
         * 4) Removes all those strings whose represented number is divisible by three.
         * Note: the method removeIf(Predicate) is not allowed.
         */
        final var iter = treeSet.iterator();
        while (iter.hasNext()) {
            if (Integer.parseInt(iter.next()) % 3 == 0) {
                iter.remove();
            }
        }

        /*
         * 5) Prints the content of the Set using a for-each construct
         */
        for (String string : treeSet) {
            System.out.println(string + " ");
        }

        /*
         * 6) Verifies whether all the numbers left in the set are even
         */
        for (var string : treeSet) {
            System.out.println(Integer.parseInt(string) % 2 != 0 ? "even" : "odd");
        }
    }
}
