package sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerLoop implements Runnable {
    private  ServerSocket serverSocket;
    private Clients clients;
    public ServerLoop(ServerSocket serverSocket)
    {
        this.serverSocket=serverSocket;

    }
    public void broadcast(String message)
    {
        System.out.println("in broadcast");
        clients.message=message;
        Thread t=new Thread(clients);
        t.start();
    }

    @Override
    public void run() {
        clients=new Clients();
        System.out.println("accept activated");
        Socket socket;
        PrintWriter printWriter;

        while (true)
        {   printWriter=null;
            socket=null;
            try {
                socket=serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (socket!=null)
         {
             try {
                 printWriter= new PrintWriter(socket.getOutputStream());

             } catch (IOException e) {
                 System.out.println("printwriter error" );
                 continue;
             }
             clients.add(printWriter);

         }

        }



    }
}
