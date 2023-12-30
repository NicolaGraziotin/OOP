package it.unibo.mvc;

import java.util.Stack;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private Stack<String> history = new Stack<>();

    @Override
    public String getNextStringToPrint() {
        return this.history.lastElement();
    }

    @Override
    public Stack<String> getPrintedStringHistory() {
        return this.history;
    }

    @Override
    public void printCurrentString() {
        System.out.println(history.peek());
    }

    @Override
    public void setNextStringToPrint(final String string) {
        if (string.isBlank()) {
            throw new IllegalStateException("String unset");
        } else {
            history.add(string);
        }
    }

}
