package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
           System.out.println("Сервер стартовал!");
            while (true) {
                try (Socket clientSocket = serverSocket.accept(); // ждем подключения
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ){
                    String infoFromClient = in.readLine();
                    System.out.println("Новое подключение принято. Информация:" + infoFromClient + "порт: " + clientSocket.getPort());
                    out.println(clientSocket.getPort());
                }
            }
        }catch(IOException e){
                throw new RuntimeException(e);
            }
        }
    }
