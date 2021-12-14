package bsi.socket;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Norbert Leśniak
 * @author Artur Piszczatowski
 * Source: https://www.geeksforgeeks.org/socket-programming-in-java/
 * Source: https://www.geeksforgeeks.org/java-implementation-of-diffie-hellman-algorithm-between-client-and-server/
 * @see Socket
 * @see Server
 * @see DataInputStream
 * @see BufferedInputStream
 * @see IOException
 * Class creates basic Client and Server setup where two Clients connect,
 * send messages to the server and the server shows them using a socket connection.
 */

public class Server {

    private Socket          socketA   = null;
    private Socket          socketB = null;
    private ServerSocket    server   = null;
    private DataInputStream inA =  null;
    private DataInputStream inB = null;

    /**
     * Constructor with port starting local server and waits for connection from Clients.
     * Takes input from Client socket and reads messages from Clients until "End" is sent.
     *
     * @param port - local port number
     * @throws IOException
     */

    public Server(int port)
    {

        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socketA = server.accept();
            System.out.println("Client A accepted");

            inA = new DataInputStream(new BufferedInputStream(socketA.getInputStream()));

            String lineA = "";

            socketB = server.accept();
            System.out.println("Client B accepted");

            inB = new DataInputStream(new BufferedInputStream(socketB.getInputStream()));

            String lineB = "";

            while (!lineA.equals("End") && !lineB.equals("End"))
            {
                try
                {
                    lineA = inA.readUTF();
                    System.out.println("ClientA: " + lineA);
                    lineB = inB.readUTF();
                    System.out.println("ClientB: " + lineB);

                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");

            socketA.close();
            socketB.close();
            inA.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        Server server = new Server(5000);
    }
}