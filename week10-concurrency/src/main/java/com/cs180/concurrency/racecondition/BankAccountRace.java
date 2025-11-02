package com.cs180.concurrency.racecondition;

/**
 * Real-world example: Demonstrates race condition in a banking scenario.
 * Shows what can go wrong when multiple threads modify shared data without synchronization.
 */
public class BankAccountRace {

    static class BankAccount {
        private double balance;
        private Object lock = new Object();

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        // UNSAFE method - no synchronization
        public void depositUnsafe(double amount) {
            double temp = balance;
            // Simulate some processing time where thread could be interrupted
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {}
            balance = temp + amount;
        }

        // SAFE method - with synchronization
        public void depositSafe(double amount) {
            synchronized (lock) {
                double temp = balance;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {}
                balance = temp + amount;
            }
        }

        public double getBalance() {
            return balance;
        }

        public void resetBalance(double amount) {
            balance = amount;
        }
    }

    static class Customer implements Runnable {
        private BankAccount account;
        private double depositAmount;
        private boolean useSafeDeposit;

        public Customer(BankAccount account, double depositAmount, boolean useSafeDeposit) {
            this.account = account;
            this.depositAmount = depositAmount;
            this.useSafeDeposit = useSafeDeposit;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                if (useSafeDeposit) {
                    account.depositSafe(depositAmount);
                } else {
                    account.depositUnsafe(depositAmount);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Banking Race Condition Example ===\n");

        BankAccount account = new BankAccount(1000.0);
        double depositAmount = 50.0;
        int numCustomers = 5;

        // Demonstrate UNSAFE version
        System.out.println("Test 1: WITHOUT Synchronization (UNSAFE)");
        System.out.printf("Initial balance: $%.2f\n", account.getBalance());
        System.out.printf("Each of %d customers will deposit $%.2f ten times\n", numCustomers, depositAmount);
        System.out.printf("Expected final balance: $%.2f\n\n",
            account.getBalance() + (numCustomers * 10 * depositAmount));

        Thread[] customers = new Thread[numCustomers];
        for (int i = 0; i < numCustomers; i++) {
            customers[i] = new Thread(new Customer(account, depositAmount, false));
            customers[i].start();
        }

        for (Thread customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Actual final balance: $%.2f\n", account.getBalance());
        System.out.println("Money lost due to race condition: $" +
            String.format("%.2f", (3500.0 - account.getBalance())));

        // Demonstrate SAFE version
        System.out.println("\n==========================================");
        System.out.println("Test 2: WITH Synchronization (SAFE)");
        account.resetBalance(1000.0);
        System.out.printf("Initial balance: $%.2f\n", account.getBalance());
        System.out.printf("Each of %d customers will deposit $%.2f ten times\n", numCustomers, depositAmount);
        System.out.printf("Expected final balance: $%.2f\n\n",
            account.getBalance() + (numCustomers * 10 * depositAmount));

        for (int i = 0; i < numCustomers; i++) {
            customers[i] = new Thread(new Customer(account, depositAmount, true));
            customers[i].start();
        }

        for (Thread customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Actual final balance: $%.2f\n", account.getBalance());
        System.out.println("Money lost due to race condition: $0.00");
        System.out.println("\nWith synchronization, the balance is always correct!");
    }
}
