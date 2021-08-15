package com.pistachotron.server;
import com.pistachotron.debug.Log;

import java.net.*;
import java.io.*;
import java.util.Date;
/*
public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start() {
        int port=1248;
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String greeting = in.readLine();
        if ("hello server".equals(greeting)) {
            out.println("hello client");
        }
        else {
            out.println("unrecognised greeting");
        }
    }

    public void stop() {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
    //public static void main(String[] args) {
    //    GreetServer server=new GreetServer();
    //    server.start(6666);
    //}
}
*/

public class Server implements Runnable {
    private ServerMetaData SMD;
    private Thread ServerThread;
    private int port;
    public Server(int port){
        ServerThread=new Thread(this);
        //start(port);
        this.port=port;
    }

    public void startServer(){
        ServerThread.start();
    }
    private void start(int port){//public=
        SMD=ServerMetaData.getServer(port, "Pistachotron-Server-["+new Date().toString().replace(' ','-')+"]");
        Log.debug("Starting Server ["+SMD.name+"] On Port [localhost:"+SMD.port+"]");
        int portNumber=SMD.port;
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            //throw new Exception("E");
        }
        catch(Exception e){
            Log.debug("Server Error: "+e);
        }
    }



    @Override
    public void run() {
        start(port);
        ServerThread.stop();
        Log.debug("Stopping The Server ["+SMD.name+"]");
    }
}