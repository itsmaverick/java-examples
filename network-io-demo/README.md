# Network I/O Demo

A comprehensive Java Maven project demonstrating network I/O concepts from CS18000 Module 11.

## Overview

This project demonstrates key concepts in Java network programming:
- **Client-Server Architecture**: Understanding servers (waiting for connections) and clients (connecting to servers)
- **Sockets**: Using IP addresses and TCP ports for network communication
- **Object Serialization**: Exchanging Java objects over network connections using ObjectStreams
- **Multi-threading**: Handling multiple clients simultaneously without blocking
- **Text-based Communication**: Using Scanner and PrintWriter for line-based protocols

## Project Structure

```
network-io-demo/
├── pom.xml
├── README.md
└── src/main/java/com/example/network/
    ├── Message.java          # Serializable message class
    ├── BasicServer.java      # Simple object-based server
    ├── BasicClient.java      # Simple object-based client
    ├── EchoServer.java       # Multi-threaded echo server
    └── EchoClient.java       # Interactive echo client
```

## Key Concepts Demonstrated

### 1. Sockets and Network Communication
- **Socket**: Represents an endpoint for network communication (IP address + TCP port)
- **ServerSocket**: Used by servers to wait for client connections
- **Two sockets make a connection**: One on the server, one on the client

### 2. ObjectStream Communication Timeline

The proper initialization order is critical to avoid blocking:

**Server Side:**
1. Open `ObjectOutputStream` first
2. Call `flush()` to send header
3. Then open `ObjectInputStream`

**Client Side:**
1. Open `ObjectInputStream` first (receives server's header)
2. Then open `ObjectOutputStream`
3. Call `flush()` to send header to server

### 3. Multi-threaded Server Architecture

The echo server demonstrates how to handle multiple clients simultaneously:
1. Main thread listens for connections in a loop
2. For each connection, spawn a new thread
3. Each thread independently handles one client
4. No blocking - server can accept new connections while serving existing ones

## Running the Examples

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher

### Compile the Project
```bash
cd network-io-demo
mvn clean compile
```

### Example 1: Basic Object-Based Communication

**Terminal 1 - Start the server:**
```bash
mvn exec:java -Dexec.mainClass="com.example.network.BasicServer"
```

**Terminal 2 - Run the client:**
```bash
mvn exec:java -Dexec.mainClass="com.example.network.BasicClient"
```

The server and client will exchange Message objects, demonstrating:
- Proper ObjectStream initialization order
- Sending and receiving serialized objects
- The importance of `flush()` to avoid blocking

### Example 2: Multi-threaded Echo Server

**Terminal 1 - Start the echo server:**
```bash
mvn exec:java -Dexec.mainClass="com.example.network.EchoServer"
```

**Terminal 2, 3, 4... - Run multiple clients:**
```bash
mvn exec:java -Dexec.mainClass="com.example.network.EchoClient"
```

Each client can:
- Send text messages to the server
- Receive echoed responses
- Type "quit" to disconnect

The server logs all activity and handles all clients simultaneously.

## Code Examples

### Creating a Server Socket
```java
// Server waits for connections on port 4242
ServerSocket serverSocket = new ServerSocket(4242);
Socket socket = serverSocket.accept(); // Blocks until client connects
```

### Creating a Client Socket
```java
// Client connects to server at localhost:4242
Socket socket = new Socket("localhost", 4242);
```

### Object-Based Communication (Server)
```java
// Server: Output stream FIRST, then flush, then input stream
ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
oos.flush(); // Critical!
ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

// Send object
Message msg = new Message("Hello", "Server");
oos.writeObject(msg);
oos.flush();

// Receive object
Message response = (Message) ois.readObject();
```

### Object-Based Communication (Client)
```java
// Client: Input stream FIRST, then output stream
ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
oos.flush();

// Receive object
Message msg = (Message) ois.readObject();

// Send object
Message response = new Message("Reply", "Client");
oos.writeObject(response);
oos.flush();
```

### Multi-threaded Server Pattern
```java
while (true) {
    Socket socket = serverSocket.accept();
    // Spawn new thread for each client
    EchoServer handler = new EchoServer(socket);
    new Thread(handler).start();
}
```

## Important Concepts

### Why Order Matters
- `ObjectOutputStream` writes a header when created
- `ObjectInputStream` tries to read this header when created
- If both sides create `ObjectOutputStream` first, both will block waiting for the header
- **Solution**: Server creates output first, client creates input first

### The Role of flush()
- Output streams buffer data for efficiency
- `flush()` forces buffered data to be sent immediately
- Critical after creating `ObjectOutputStream` and after `writeObject()`
- Without `flush()`, the receiving side may block indefinitely

### Why Use Threads?
- A single-threaded server can only handle one client at a time
- Other clients must wait (blocking)
- Threads allow concurrent handling of multiple clients
- Each client gets responsive service regardless of others

## Network Terminology

- **IP Address**: Identifies a computer on the network (e.g., 128.10.2.21)
- **DNS**: Maps domain names to IP addresses (e.g., localhost → 127.0.0.1)
- **TCP**: Transmission Control Protocol - reliable, ordered data delivery
- **Port**: 16-bit number (0-65535) identifying a specific service on a host
- **Socket**: IP address + port number (like street address + apartment number)
- **Blocking**: When code waits for an operation to complete (e.g., waiting for data)

## Learning Objectives

After studying this project, you should understand:
1. How client-server communication works in Java
2. The difference between ServerSocket and Socket
3. How to use ObjectStreams for network communication
4. Why initialization order matters for ObjectStreams
5. How to build a multi-threaded server
6. The importance of flush() in network programming
7. How threads prevent blocking in server applications

## References

- Module 11: Network I/O (CS18000)
- Java Documentation: java.net package
- Java Documentation: java.io package

## License

Educational use only - CS18000 demonstration project
