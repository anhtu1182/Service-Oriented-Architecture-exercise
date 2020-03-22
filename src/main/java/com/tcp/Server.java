package com.tcp;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public final static int SERVER_PORT = 1234;
    public final static int student_number = 10;

    public static void main(String[] args) throws IOException {

        Student[] student = new Student[student_number];

        for (int number = 0; number < student_number; number++) {
            student[number] = new Student("Clone0" + number,
                    "1602029" + number,
                    "K61_CA_CLC_2", "0376700173",
                    "clone0"+ number +"@gmail.com",
                    Integer.toString(number) + "00 Street, City");
        }

        //Binding Socket
        System.out.println("Binding socket, port " + SERVER_PORT);
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Listening for a client");
        try{
            Socket socket = serverSocket.accept();
            System.out.println("Connection from " + socket);

            //This stream is created to receive data from client
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            //Receive student ID from client
            String studentID = dataInputStream.readUTF();
            System.out.println("Student ID is: " + studentID);

            //This stream is created to sent data from client
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            //Search student ID
            //If exist, return student information
            //If not, notice that no student has that ID
            boolean exist = false;
            for(int number = 0; number < student_number; number++){
                if(student[number].getStudent_ID().equals(studentID)){
                    dataOutputStream.writeUTF(student[number].toString());
                    exist = true;
                    break;
                }
            }
            if (exist == false){
                dataOutputStream.writeUTF("This ID does not belong to any student");
            }
            dataOutputStream.flush();
            dataOutputStream.close();

            System.out.println("Closing sockets.");
            serverSocket.close();
            socket.close();
        } catch (IOException IOe){
            System.err.println("Error: " + IOe);
        }

    }
}
