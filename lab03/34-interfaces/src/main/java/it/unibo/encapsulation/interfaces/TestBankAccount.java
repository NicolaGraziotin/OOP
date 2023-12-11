package it.unibo.encapsulation.interfaces;

public class TestBankAccount {

    private TestBankAccount() {
    }

    public static void main(final String[] args) {
        /*
         * 1) Creare l' AccountHolder relativo a Andrea Rossi con id 1
         */
        /*
         * 2) Creare l' AccountHolder relativo a Alex Bianchi con id 2
         */
        /*
         * 3) Dichiarare due variabili di tipo BankAccount ed inizializzarle,
         * rispettivamente, con oggetti di tipo SimpleBankAccount per il conto di
         * Rossi (ammontare iniziale = 0), e di tipo StrictBankAccount per il conto di
         * Bianchi (ammontare iniziale = 0)
         */
        /*
         * 4) Prima riflessione: perché è stato possibile fare la new di due classi
         * diverse in variabili dello stesso tipo?
         */
        /*
         * 5) Depositare €10000 in entrambi i conti
         */
        /*
         * 6) Prelevare €15000$ da entrambi i conti
         */
        /*
         * 7) Stampare in stdout l'ammontare corrente
         */
        /*
         * 8) Qual è il risultato e perché?
         */
        /*
         * 9) Depositare nuovamente €10000 in entrambi i conti
         */
        /*
         * 10) Invocare il metodo computeManagementFees su entrambi i conti
         */
        /*
         * 11) Stampare a video l'ammontare corrente
         */
        /*
         * 12) Qual è il risultato e perché?
         */

        AccountHolder andrea = new AccountHolder("Andrea", "Rossi", 1);

        AccountHolder alex = new AccountHolder("Alex", "Bianchi", 2);

        BankAccount account1 = new SimpleBankAccount(andrea.getUserID(), 0);
        BankAccount account2 = new StrictBankAccount(alex.getUserID(), 0);

        account1.deposit(andrea.getUserID(), 10000);
        account2.deposit(alex.getUserID(), 10000);

        account1.withdraw(andrea.getUserID(), 15000);
        account2.withdraw(alex.getUserID(), 15000);

        System.out.println(account1.getBalance() + " " + account2.getBalance());

        account1.deposit(andrea.getUserID(), 10000);
        account2.deposit(alex.getUserID(), 10000);

        account1.chargeManagementFees(andrea.getUserID());
        account2.chargeManagementFees(alex.getUserID());

        System.out.println(account1.getBalance() + " " + account2.getBalance());
    }
}
