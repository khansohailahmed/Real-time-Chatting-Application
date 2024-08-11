# Real-time-Chatting-Application
This project is a chat application that facilitates real-time communication between a server and multiple clients using Java. The core functionality is built around socket programming, enabling users to send and receive messages seamlessly.
Key Points-
1. Server-Client Communication- The application uses `ServerSocket` for the server and `Socket` for the client to establish a connection. The server listens for incoming connections and manages message broadcasting to all connected clients.
   
2. Socket Connectivity- First, compile and run the `Server` class to initialize the server socket. It listens on a specified port (6001 in this case) for client connections. Upon receiving a connection, it sets up input and output streams for communication. The server handles incoming messages from clients and updates the chat interface.

3. Client Interaction- After the server is up and running, compile and run the `Client` class. The client connects to the server using its IP address and port number. It allows users to send messages to the server, which then broadcasts them to all clients.

4. User Interface- Both the server and client have graphical user interfaces designed using Swing, providing an intuitive chat experience. Messages are displayed in a styled format with timestamps.

Overall, the project demonstrates effective use of Java’s networking capabilities to create a functional chat system.
