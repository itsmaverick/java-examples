package com.example.network;

import java.io.*;
import java.net.*;

/**
 * Basic client demonstrating object-based network communication.
 * This client:
 * 1. Connects to a server on localhost:4242
 * 2. Exchanges Message objects with the server using ObjectStreams
 *
 * Key concepts demonstrated:
 * - Socket for connecting to server
 * - ObjectInputStream/ObjectOutputStream for sending/receiving objects
 * - Proper stream initialization order (input first to get server's header, then output)
 */
public class BasicClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 4242;

    public static void main(String[] args) {
        System.out.println("=== Basic Object Client ===");
        System.out.println("Connecting to server for object-based communication");

        try {
            // Step 1: Create socket to connect to server
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            System.out.printf("Connected to server at %s:%d\n", SERVER_HOST, SERVER_PORT);

            // Step 2: Open input stream FIRST (gets header from server)
            // Then open output stream second, send header to server
            // This order is critical to match server's initialization!
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.flush(); // Ensure header is sent to the server

            System.out.println("Object streams established");

            // Step 3: Read object(s) from server
            Message incoming = (Message) ois.readObject();
            System.out.printf("Received from server: %s\n", incoming);

            // Step 4: Write object(s) to server
            String reply = incoming.getContent().toUpperCase();
            Message outgoing = new Message(reply, "Client");
            oos.writeObject(outgoing);
            oos.flush(); // Ensure data is sent to the server
            System.out.printf("Sent to server: %s\n", outgoing);

            // Step 5: Close streams and socket
            oos.close();
            ois.close();
            socket.close();

            System.out.println("Connection closed successfully");

        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
