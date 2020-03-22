package com.tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public final static int SERVER_PORT = 1234;
    public static void main(String[] args) throws IOException {
        try{
            Socket socket = new Socket("localhost", SERVER_PORT);
            System.out.println("Connected to server successfully");

            //This stream is create to sent data to server
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            System.out.print("Student ID: ");
            Scanner scanner = new Scanner(System.in);
            String studentID = scanner.nextLine();

            //Sent student ID to server
            dataOutputStream.writeUTF(studentID);
            dataOutputStream.flush();

            //This stream is create to recive data to server
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            //Read data which is recieved from server
            String studentInformation = dataInputStream.readUTF();
            System.out.println("The information of student has ID " + studentID + " is: " + studentInformation);

            System.out.println("Close client socket");
            socket.close();
        } catch (IOException IOe){
            System.out.println("Connect to server failed");
        }

    }
}