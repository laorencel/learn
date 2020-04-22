package com.laorencel.learn.se.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
//       number();
//       data();
//        chart();
        chartThread();
    }

    private static void number() {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            System.out.println("server:" + socket);
            InputStream inputStream = socket.getInputStream();
            int msg = inputStream.read();
            System.out.println("msg = " + msg);
            inputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void data() {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            System.out.println("server:" + socket);
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            String msg = inputStream.readUTF();
            System.out.println("msg = " + msg);
            inputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void chart() {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            while (true) {
                System.out.println("收到client消息 = " + inputStream.readUTF());
                Scanner scanner = new Scanner(System.in);
                outputStream.writeUTF(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void chartThread() {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            new Client.OutputThread(socket).start();
            new Client.InputThread(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static class OutputThread extends Thread {
        Socket socket;

        public OutputThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            super.run();
            try {
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                while (true){
                    Scanner scanner = new Scanner(System.in);
                    outputStream.writeUTF(scanner.next());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    static class InputThread extends Thread {
        Socket socket;

        public InputThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            super.run();
            try {
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                while (true){
                    System.out.println("收到client消息 = " + inputStream.readUTF());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
