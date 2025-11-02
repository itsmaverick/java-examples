package com.cs180.concurrency.domaindecomposition;

/**
 * Demonstrates Domain Decomposition by dividing matrix multiplication work across multiple threads.
 * Each thread computes a portion of the result matrix, speeding up the overall computation.
 */
public class MatrixMultiplication {

    /**
     * Worker thread that computes a specific range of rows in the result matrix
     */
    static class MatrixWorker implements Runnable {
        private int[][] a;
        private int[][] b;
        private int[][] result;
        private int startRow;
        private int endRow;
        private String workerId;

        public MatrixWorker(int[][] a, int[][] b, int[][] result, int startRow, int endRow, String workerId) {
            this.a = a;
            this.b = b;
            this.result = result;
            this.startRow = startRow;
            this.endRow = endRow;
            this.workerId = workerId;
        }

        public void run() {
            System.out.printf("%s computing rows %d to %d\n", workerId, startRow, endRow - 1);

            for (int i = startRow; i < endRow; i++) {
                for (int j = 0; j < b[0].length; j++) {
                    int sum = 0;
                    for (int k = 0; k < b.length; k++) {
                        sum += a[i][k] * b[k][j];
                    }
                    result[i][j] = sum;
                }
            }

            System.out.printf("%s completed!\n", workerId);
        }
    }

    /**
     * Initialize a matrix with sample values
     */
    private static int[][] initializeMatrix(int rows, int cols, int offset) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (i + j + offset) % 10;
            }
        }
        return matrix;
    }

    /**
     * Print a matrix (only works well for small matrices)
     */
    private static void printMatrix(String name, int[][] matrix) {
        System.out.println(name + ":");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%4d ", val);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Domain Decomposition: Matrix Multiplication ===\n");

        // Create matrices
        int SIZE = 4;
        int[][] matrixA = initializeMatrix(SIZE, SIZE, 1);
        int[][] matrixB = initializeMatrix(SIZE, SIZE, 2);
        int[][] result = new int[SIZE][SIZE];

        printMatrix("Matrix A", matrixA);
        printMatrix("Matrix B", matrixB);

        // Divide work among 2 threads (could use more threads for larger matrices)
        int numThreads = 2;
        Thread[] threads = new Thread[numThreads];
        int rowsPerThread = SIZE / numThreads;

        System.out.println("Starting parallel computation with " + numThreads + " threads...\n");

        long startTime = System.currentTimeMillis();

        // Create and start threads
        for (int i = 0; i < numThreads; i++) {
            int startRow = i * rowsPerThread;
            int endRow = (i == numThreads - 1) ? SIZE : (i + 1) * rowsPerThread;
            threads[i] = new Thread(new MatrixWorker(matrixA, matrixB, result, startRow, endRow, "Worker-" + (i + 1)));
            threads[i].start();
        }

        // Wait for all threads to complete
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("\nAll workers completed!");
        printMatrix("Result Matrix (A x B)", result);
        System.out.printf("Computation time: %d ms\n", (endTime - startTime));
    }
}
