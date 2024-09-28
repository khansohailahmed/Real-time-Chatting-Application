# ChatApp

This project is a simple peer-to-peer chat application built using Java Swing for the user interface and socket programming for communication between the client and the server. It enables real-time messaging between a server and a client through a graphical user interface (GUI).

## Features

- **Real-Time Messaging**: Users can send and receive messages instantly between a client and a server.
- **Graphical User Interface**: The chat application features a GUI built with Java Swing.
- **Timestamped Messages**: Each message is timestamped to indicate when it was sent.
- **Active Status Display**: Displays whether the client or server is currently active.
- **Socket Programming**: Utilizes sockets to handle the communication between the client and server.
- **Basic UI Controls**: Icons for actions like phone call, video call, and more (non-functional placeholders).
  
## Technologies Used

- **Java**: Programming language used for the entire application.
- **Swing**: For building the graphical user interface (GUI).
- **Sockets**: To enable communication between the server and client.

## How to Run the Project

### Prerequisites

- Java Development Kit (JDK) installed (version 8 or higher).
- A Java IDE or a text editor to edit and run the code.
- Basic knowledge of Java, Swing, and socket programming.

### Steps

1. **Clone the Repository**
   ```bash
   git clone https://github.com/khansohailahmed/ChatApp.git
   cd ChatApp
   ```

2. **Compile the Code**
   You can use a Java IDE like IntelliJ IDEA, Eclipse, or simply use `javac` to compile the project.

   ```bash
   javac chatapp/Client.java
   javac chatapp/Server.java
   ```

3. **Run the Server**
   Start the server first, as it will wait for a client to connect.
   ```bash
   java chatapp.Server
   ```

4. **Run the Client**
   After the server is running, start the client to connect to the server.
   ```bash
   java chatapp.Client
   ```

5. **Send Messages**
   - You can type a message in the client window and press the **Send** button to send it to the server.
   - The server will display the message, and the user can respond similarly.
   
## Code Structure

- **Client.java**: Handles the client's user interface and communication with the server.
- **Server.java**: Handles the server's user interface and communication with the client.
- **ReceiveMessage**: A separate thread in both client and server that listens for incoming messages.

## Screenshots

1. **Client Interface**
   ![Client GUI](screenshots/client.png)

2. **Server Interface**
   ![Server GUI](screenshots/server.png)

## Contributing

Feel free to fork this repository and contribute by submitting a pull request. For major changes, please open an issue to discuss what you would like to change.

## License

This project is licensed under the MIT License.

---

Feel free to improve this application or extend its functionality, such as adding more features like image sharing, file transfers, or user authentication.

