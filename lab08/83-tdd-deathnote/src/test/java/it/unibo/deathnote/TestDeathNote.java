package it.unibo.deathnote;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.DeathNoteImpl;

class TestDeathNote {

    private static final String FEDERICO = "Federico Graziotin";
    private static final String NICOLA = "Nicola Graziotin";
    DeathNote deathNote;

    @BeforeEach
    void init() {
        deathNote = new DeathNoteImpl();
    }

    @Test
    void testGetRule() {
        assertThrows(IllegalArgumentException.class, () -> deathNote.getRule(0));
        assertThrows(IllegalArgumentException.class, () -> deathNote.getRule(-1));
        for (var elem : DeathNote.RULES) {
            assertFalse(elem.isEmpty());
            assertFalse(elem.isBlank());
            assertFalse(elem.equals(null));
        }
    }

    @Test
    void testWriteName() {
        assertFalse(deathNote.isNameWritten(FEDERICO));
        deathNote.writeName(FEDERICO);
        assertTrue(deathNote.isNameWritten(FEDERICO));
        assertFalse(deathNote.isNameWritten(NICOLA));
        assertFalse(deathNote.isNameWritten(""));
    }

    @Test
    void testWriteDeathCause() throws InterruptedException {
        assertThrows(IllegalStateException.class, () -> deathNote.writeDeathCause(""));
        deathNote.writeName(FEDERICO);
        assertEquals("heart attack", deathNote.getDeathCause(FEDERICO));
        deathNote.writeName(NICOLA);
        assertTrue(deathNote.writeDeathCause("karting accident"));
        assertEquals("karting accident", deathNote.getDeathCause(NICOLA));
        Thread.sleep(100);
        assertFalse(deathNote.writeDeathCause("suicide"));
        assertEquals("karting accident", deathNote.getDeathCause(NICOLA));
    }

    @Test
    void testWriteDetails() throws InterruptedException {
        assertThrows(IllegalStateException.class, () -> deathNote.writeDetails(""));
        deathNote.writeName(FEDERICO);
        assertEquals("", deathNote.getDeathDetails(FEDERICO));
        assertTrue(deathNote.writeDetails("ran for too long"));
        assertEquals("ran for too long", deathNote.getDeathDetails(FEDERICO));
        deathNote.writeName(NICOLA);
        Thread.sleep(6100);
        assertFalse(deathNote.writeDetails("jumped off a building"));
        assertEquals("", deathNote.getDeathDetails(NICOLA));
    }
}