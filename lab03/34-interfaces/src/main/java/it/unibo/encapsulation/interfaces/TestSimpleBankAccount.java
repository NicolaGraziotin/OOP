package it.unibo.encapsulation.interfaces;

public class TestSimpleBankAccount {

    private TestSimpleBankAccount() {
        /*
         * Prevents object creation from the outside.
         */
    }

    public static void main(final String[] args) {
        // 1) Creare l' AccountHolder relativo a Andrea Rossi con id 1

        // 2) Creare l' AccountHolder relativo a Alex Bianchi con id 2

        // 3) Creare i due SimpleBankAccount corrispondenti

        // 4) Effettuare una serie di depositi e prelievi

        /*
         * 5) Stampare a video l'ammontare dei due conti e verificare la
         * correttezza del risultato
         */

        // 6) Provare a prelevare fornendo un id utente sbagliato

        // 7) Controllare nuovamente l'ammontare

        AccountHolder andrea = new AccountHolder("Andrea", "Rossi", 1);

        AccountHolder alex = new AccountHolder("Alex", "Bianchi", 2);

        SimpleBankAccount account1 = new SimpleBankAccount(andrea.getUserID(), 0);
        SimpleBankAccount account2 = new SimpleBankAccount(alex.getUserID(), 0);

        account1.deposit(andrea.getUserID(), 100);
        System.out.println(account1.getBalance() + " " + account2.getBalance());
        account1.withdraw(andrea.getUserID(), 10);
        System.out.println(account1.getBalance() + " " + account2.getBalance());
        account2.deposit(alex.getUserID(), 20);
        System.out.println(account1.getBalance() + " " + account2.getBalance());
        account2.withdraw(alex.getUserID(), 10);
        System.out.println(account1.getBalance() + " " + account2.getBalance());
        account2.deposit(andrea.getUserID(), 1000);
        System.out.println(account1.getBalance() + " " + account2.getBalance());
    }
}
