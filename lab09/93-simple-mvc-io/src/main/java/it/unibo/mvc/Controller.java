package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private final String PATH = System.getProperty("user.home")
            + File.separator
            + "Hitler.txt";

    private File dest = new File(PATH);
    
    public void setCurrentFile(File newDest) {
        final File parent = newDest.getParentFile();
        if (parent.exists()) {
            dest = newDest;
        } else {
            throw new IllegalArgumentException("Cannot save in a non-existing folder.");
        }
    }

    public File getCurrentFile() {
        return dest;
    }

    public String getPATH() {
        return dest.getPath();
    }

    public void saveOnCurrentFile(final String input) throws IOException {
        try (PrintStream ps = new PrintStream(PATH, StandardCharsets.UTF_8)) {
            ps.print(input);
        }
    }
}
