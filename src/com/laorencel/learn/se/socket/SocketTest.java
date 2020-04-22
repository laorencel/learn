package com.laorencel.learn.se.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SocketTest {

    public static void main(String[] args) {

//        getAddress();
        boolean isReachable = isReachable(getAddress());
        System.out.println("isReachable = " + isReachable);
    }

    private static String getAddress() {
        try {
            InetAddress host = InetAddress.getLocalHost();
            System.out.println("host = " + host);
            System.out.println("getCanonicalHostName = " + host.getCanonicalHostName());
            System.out.println("getHostAddress = " + host.getHostAddress());
            System.out.println("getHostName = " + host.getHostName());
            System.out.println("getAddress = " + host.getAddress());
            System.out.println("getAddress = " + host.getAddress().toString());
            return host.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static boolean isReachable(String addr) {
        try {
            boolean reachable = false;
            Process process = Runtime.getRuntime().exec("ping " + addr);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    builder.append(line);
                    builder.append("\r\n");
                }
            }
            reachable = builder.toString().contains("ttl");
            System.out.println("本次指令返回的消息是：");
            System.out.println("builder = " + builder.toString());
            return reachable;
        } catch (IOException e) {
            e.printStackTrace();
            return  false;
        }
    }
}
