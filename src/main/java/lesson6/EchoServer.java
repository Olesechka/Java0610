package lesson6;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {
        Socket socket = null;

        try (ServerSocket serverSocket = new ServerSocket(8089)){ //try with resources
            System.out.println("Сервер ожидает подключения...");
            socket = serverSocket.accept(); //ждем подключения (блокируемся)
            System.out.println("Клиент подключился!");
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String message = dataInputStream.readUTF();
                //poison pill
                if(message.equals("/end")){
                    break;
                }
                dataOutputStream.writeUTF(message);
            }
        } catch (IOException e){
            e.printStackTrace();
        } //finally
    }
}
