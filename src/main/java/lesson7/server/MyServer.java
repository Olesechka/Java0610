package lesson7.server;

import lesson7.constants.Constants;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {

    public AuthService getAuthService() {
        return authService;
    }

    /**
     * Сервис аутентификации
     */
    private AuthService authService;

    /**
     * Активные клиенты
     */
    private List<ClientHandler> clients;


    public MyServer() {
        try (ServerSocket server = new ServerSocket(Constants.SERVER_PORT)) {
            authService = new BaseAuthService();
            authService.start();

            clients = new ArrayList<>();

            while (true) {
                System.out.println("Сервер ожидает подключения");
                Socket socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this, socket);
            }

        } catch (IOException ex) {
            System.out.println("Ошибка в работе сервера");
            ex.printStackTrace();
        } finally {
            if (authService != null) {
                authService.stop();
            }
        }
    }

    public synchronized boolean isNickBusy(String nick) {
        for (ClientHandler clientHandler : clients) {
            if (clientHandler.getName().equals(nick)) {
                return true;
            }
        }
        return false;
    }

    public void privateMessage(ClientHandler nickFromMessage, String nickToMessage, String message) {
        for (ClientHandler client : clients) {
            if (client.getName().equals(nickToMessage)) {
                client.sendMessage("Message from: " + nickFromMessage.getName() + " - " + message);
                break;
            }
            nickFromMessage.sendMessage("Message to: " + nickToMessage + " - " + message);
        }
    }

    public synchronized void broadcastMessage(String message) {
        clients.forEach(client -> client.sendMessage(message));

//        for(ClientHandler client: clients){
//            client.sendMessage(message);
//        }
    }

    public synchronized void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public synchronized void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

}
