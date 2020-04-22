package com.laorencel.learn.se.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

//        number();
//        data();
//        chart();
        chartThread();
    }

    private static void number() {
        try {
            //连接到本机的8888端口
            Socket s = new Socket("127.0.0.1", 8888);
            System.out.println("client:" + s);
            s.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void data() {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            outputStream.writeUTF(scanner.next());
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void chart() {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            while (true) {
                Scanner scanner = new Scanner(System.in);
                outputStream.writeUTF(scanner.next());
                System.out.println("收到server消息 = " + inputStream.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void chartThread() {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            new OutputThread(socket).start();
            new InputThread(socket).start();
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
                    System.out.println("收到server消息 = " + inputStream.readUTF());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
