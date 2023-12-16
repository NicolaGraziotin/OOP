package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {
    
    @Override
    public Comparator<String> sortByDays() {
        return new SortByDays();
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new SortByMonthOrder();
    }
    
    private enum Month {

        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        private int days;

        Month(final int days) {
            this.days = days;
        }

        public static Month fromString(final String stringa) {
            Objects.requireNonNull(stringa);
            try {
                return valueOf(stringa);
            } catch (IllegalArgumentException e) {
                Month match = null;
                for (final Month month : values()) {
                    if (month.toString().toLowerCase(Locale.ROOT).startsWith(stringa.toLowerCase(Locale.ROOT))) {
                        if (match != null) {
                            throw new IllegalArgumentException(
                            stringa + " is ambiguous: both " + match + " and " + month + " would be valid matches", e
                            );
                        }
                        match = month;
                    }
                }
                if (match == null) {
                    throw new IllegalArgumentException("No matching months for " + stringa, e);
                }
                return match;
            }
        }
    }

    private static class SortByMonthOrder implements Comparator<String> {
        @Override
        public int compare(final String o1, final String o2) {
            return Month.fromString(o1).compareTo(Month.fromString(o2));
        }
    }

    private static class SortByDays implements Comparator<String> {

        @Override
        public int compare(final String o1, final String o2) {
            var m1 = Month.fromString(o1);
            var m2 = Month.fromString(o2);
            return Integer.compare(m1.days, m2.days);
        }
    }
}
