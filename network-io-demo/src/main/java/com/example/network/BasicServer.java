package com.example.network;

import java.io.*;
import java.net.*;

/**
 * Basic server demonstrating object-based network communication.
 * This server:
 * 1. Opens a ServerSocket on port 4242
 * 2. Waits for a client to connect
 * 3. Exchanges Message objects with the client using ObjectStreams
 *
 * Key concepts demonstrated:
 * - ServerSocket for accepting connections
 * - Socket for communication
 * - ObjectOutputStream/ObjectInputStream for sending/receiving objects
 * - Proper stream initialization order (output first, then flush, then input)
 */
public class BasicServer {
    private static final int PORT = 4242;

    public static void main(String[] args) {
        System.out.println("=== Basic Object Server ===");
        System.out.println("Demonstrating object-based client-server communication");

        try {
            // Step 1: Create ServerSocket on agreed-upon port
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.printf("Server listening on port %d...\n", PORT);

            // Step 2: Wait for client to connect, get socket connection
            Socket socket = serverSocket.accept();
            System.out.printf("Client connected from %s\n", socket.getRemoteSocketAddress());

            // Step 3: Open output stream FIRST, flush to send header, then input stream
            // This order is critical to avoid blocking!
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.flush(); // Ensure header is sent to the client
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            System.out.println("Object streams established");

            // Step 4: Send object(s) to client
            Message outgoing = new Message("Hello from server!", "Server");
            oos.writeObject(outgoing);
            oos.flush(); // Ensure data is sent to the client
            System.out.printf("Sent to client: %s\n", outgoing);

            // Step 5: Read object(s) from client
            Message incoming = (Message) ois.readObject();
            System.out.printf("Received from client: %s\n", incoming);

            // Step 6: Close streams and sockets
            oos.close();
            ois.close();
            socket.close();
            serverSocket.close();

            System.out.println("Connection closed successfully");

        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
