package bsi.socket;

import java.net.*;
import java.io.*;

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
 * @see UnknownHostException
 * Class creates basic Client that connects to Server where he can
 * send messages to the server and the server shows them using a socket connection.
 */

public class ClientB {

    private Socket socket            = null;
    private DataInputStream  input   = null;
    private DataOutputStream out     = null;

    /**
     * Constructor creating client B with ip address and port to local Server.
     * Establishes connection with server and sends output to the socket.
     * Keeps reading until "End" is input, then closes the connection.
     *
     * @param address - ip adress of client
     * @param port - local port number
     * @throws UnknownHostException
     * @throws IOException
     */

    public ClientB(String address, int port)
    {
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");

            input  = new DataInputStream(System.in);

            out    = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

        String line = "";

        while (!line.equals("End"))
        {
            try
            {
                line = input.readLine();
                out.writeUTF(line);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }

        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        ClientB clientB = new ClientB("127.0.0.2", 5000);
    }
}