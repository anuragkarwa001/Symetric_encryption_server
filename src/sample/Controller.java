package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Controller {
    @FXML
    private TextArea sendToUser;
    @FXML
    private Button connect;
    @FXML
    private Button disconnect;
    @FXML
    private Button send;
     Thread t;
    ServerSocket serverSocket;
    ServerLoop serverLoop;
    Socket socket;
    public static Clients clients;
    static boolean b=false;
    public void connect() {
        try {

             serverSocket = new ServerSocket(4242);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        serverLoop=new ServerLoop(serverSocket);
        t= new Thread(serverLoop);
        t.start();
        connect.setDisable(true);
        send.setDisable(false);
        disconnect.setDisable(false);

    }
    public void disconnect()
    {t.stop();
    serverLoop.broadcast("exit");
        try {
            serverSocket.close();
        }catch (Exception ex) {
        ex.printStackTrace();
        }

        connect.setDisable(false);
        send.setDisable(true);
         disconnect.setDisable(true);


    }

    public void send()
    {   String s=sendToUser.getText();
    serverLoop.broadcast(s);




        }




    }






