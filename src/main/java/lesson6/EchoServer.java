package lesson6;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {


    public static void main(String[] args) {
        Socket socket = null;



            try (ServerSocket serverSocket = new ServerSocket(8089)) { //try with resources
                System.out.println("Сервер ожидает подключения...");
                socket = serverSocket.accept(); //ждем подключения (блокируемся)
                System.out.println("Клиент подключился!");
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    String message = dataInputStream.readUTF();
                    //poison pill
                    if (message.equals("/end")) {
                        break;
                    }
                    Thread t1 = new Thread(() -> {
                        Scanner in = new Scanner(System.in);
                        try {
                            dataOutputStream.writeUTF("Servers message: " + in.nextLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

                    Thread t2 = new Thread(() -> {
                        try {
                            dataOutputStream.writeUTF("Clients message: " + message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Clients message: " + message);
                    });

                    t1.start();
                    t2.start();
                    t1.join();
                    t2.join();
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        } //finally
    }
