package it.unibo.mvc;

import java.util.Stack;

/**
 *
 */
public interface Controller {
    void setNextStringToPrint(String string);

    String getNextStringToPrint();

    Stack<String> getPrintedStringHistory();

    void printCurrentString();
}
