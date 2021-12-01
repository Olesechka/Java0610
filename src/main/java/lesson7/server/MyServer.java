package lesson7.server;

import lesson7.constants.Constants;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {
    /**
     * Сервис аутентификации
     */
    private AuthService authService;

    /**
     * Активные клиенты
     */
    private List<ClientHandler> clients;

    public MyServer(){
        try(ServerSocket server = new ServerSocket(Constants.SERVER_PORT)){
            authService =  new BaseAuthService();
            authService.start();

            clients = new ArrayList<>();

            while (true){
                System.out.println("Сервер ожидает подключения");
                Socket socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this, socket);
            }

        }catch (IOException ex){
            System.out.println("Ошибка в работе сервера");
            ex.printStackTrace();
        } finally {
            if (authService != null){
                authService.stop();
            }
        }
    }


}
