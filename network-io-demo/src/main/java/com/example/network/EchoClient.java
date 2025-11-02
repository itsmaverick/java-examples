package com.example.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Echo Client that connects to the EchoServer.
 * This client:
 * 1. Connects to the echo server
 * 2. Sends text lines to the server
 * 3. Receives and displays echoed responses
 *
 * Key concepts demonstrated:
 * - Client-side socket connection
 * - Text-based network communication with Scanner/PrintWriter
 * - Interactive user input
 */
public class EchoClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 4343;

    public static void main(String[] args) {
        System.out.println("=== Echo Client ===");
        System.out.println("Connecting to Echo Server...");

        try {
            // Connect to server
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            System.out.printf("Connected to server at %s:%d\n", SERVER_HOST, SERVER_PORT);
            System.out.println("Type messages to send (or 'quit' to exit):\n");

            // Create streams for communication
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            Scanner serverInput = new Scanner(socket.getInputStream());
            Scanner userInput = new Scanner(System.in);

            // Interactive loop: read from user, send to server, display response
            while (true) {
                System.out.print("> ");
                String message = userInput.nextLine();

                // Check if user wants to quit
                if (message.equalsIgnoreCase("quit")) {
                    System.out.println("Closing connection...");
                    break;
                }

                // Send message to server
                pw.println(message);
                pw.flush();

                // Read and display server's echo response
                if (serverInput.hasNextLine()) {
                    String response = serverInput.nextLine();
                    System.out.println("  " + response);
                }
            }

            // Clean up
            userInput.close();
            pw.close();
            serverInput.close();
            socket.close();
            System.out.println("Connection closed");

        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
