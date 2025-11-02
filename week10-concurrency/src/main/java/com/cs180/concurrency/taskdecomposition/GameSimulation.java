package com.cs180.concurrency.taskdecomposition;

/**
 * Demonstrates Task Decomposition where different tasks (Model and View) run on separate threads.
 * In a real game, the model would update game state while the view renders it.
 * This keeps the UI responsive even when complex calculations are happening.
 */
public class GameSimulation {

    /**
     * Model task - handles game logic and state updates
     */
    static class Model implements Runnable {
        private volatile int characterX = 0;
        private volatile int characterY = 0;
        private volatile boolean running = true;

        public void run() {
            System.out.println("Model thread starting...");
            int updates = 0;

            while (running && updates < 20) {
                // Simulate character movement
                characterX += (int)(Math.random() * 10) - 5;
                characterY += (int)(Math.random() * 10) - 5;

                // Keep character in bounds
                characterX = Math.max(0, Math.min(100, characterX));
                characterY = Math.max(0, Math.min(100, characterY));

                System.out.printf("Model: Updated position to (%d, %d)\n", characterX, characterY);

                try {
                    Thread.sleep(100); // Simulate update cycle
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                updates++;
            }
            running = false;
            System.out.println("Model thread ending...");
        }

        public int getX() { return characterX; }
        public int getY() { return characterY; }
        public boolean isRunning() { return running; }
    }

    /**
     * View task - handles rendering/display
     */
    static class View implements Runnable {
        private Model model;

        public View(Model model) {
            this.model = model;
        }

        public void run() {
            System.out.println("View thread starting...");

            while (model.isRunning()) {
                // Simulate rendering the current game state
                System.out.printf("View: Rendering character at (%d, %d)\n",
                    model.getX(), model.getY());

                try {
                    Thread.sleep(150); // Render at different rate than updates
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("View thread ending...");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Task Decomposition: Game Simulation ===\n");

        // Create shared model
        Model model = new Model();
        View view = new View(model);

        // Start both threads
        Thread modelThread = new Thread(model);
        Thread viewThread = new Thread(view);

        modelThread.start();
        viewThread.start();

        // Wait for both to complete
        try {
            modelThread.join();
            viewThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nGame simulation completed!");
    }
}
