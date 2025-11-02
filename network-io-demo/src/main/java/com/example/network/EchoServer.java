package com.example.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Multi-threaded Echo Server demonstrating concurrent client handling.
 * This server:
 * 1. Accepts connections from multiple clients simultaneously
 * 2. Spawns a separate thread for each client connection
 * 3. Echoes back any text lines received from clients
 *
 * Key concepts demonstrated:
 * - Multi-threaded server architecture
 * - Runnable interface for thread handling
 * - Text-based (Scanner/PrintWriter) network communication
 * - Avoiding blocking by using separate threads
 */
public class EchoServer implements Runnable {
    private static final int PORT = 4343;
    private Socket socket;

    /**
     * Constructor that takes a client socket connection.
     * Each instance handles one client in its own thread.
     */
    public EchoServer(Socket socket) {
        this.socket = socket;
    }

    /**
     * Thread's run method - handles communication with one client.
     * Reads lines from the client and echoes them back.
     */
    @Override
    public void run() {
        System.out.printf("Connection received from %s\n", socket.getRemoteSocketAddress());

        try {
            // Create PrintWriter and Scanner from socket streams
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            Scanner scanner = new Scanner(socket.getInputStream());

            // Read from input, log client request, echo client input
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.printf("%s says: %s\n", socket.getRemoteSocketAddress(), line);

                // Echo the line back to the client
                pw.printf("echo: %s\n", line);
                pw.flush(); // Ensure data is sent immediately
            }

            // Client closed connection, clean up
            System.out.printf("Client %s disconnected\n", socket.getRemoteSocketAddress());
            pw.close();
            scanner.close();
            socket.close();

        } catch (IOException e) {
            System.err.printf("Error handling client %s: %s\n",
                    socket.getRemoteSocketAddress(), e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Main method - runs the server in an infinite loop.
     * Accepts connections and spawns a thread for each client.
     */
    public static void main(String[] args) {
        System.out.println("=== Multi-threaded Echo Server ===");
        System.out.println("Demonstrating concurrent client handling with threads");

        try {
            // Allocate server socket at given port
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.printf("Server listening on port %d\n", PORT);
            System.out.println("Waiting for client connections...\n");

            // Infinite server loop: accept connection, spawn thread to handle
            while (true) {
                Socket socket = serverSocket.accept();
                EchoServer handler = new EchoServer(socket);
                Thread thread = new Thread(handler);
                thread.start();
            }

        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
