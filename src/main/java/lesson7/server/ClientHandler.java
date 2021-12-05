package lesson7.server;

import lesson7.constants.Constants;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Обработчик для конкретного клиента
 */
public class ClientHandler {

    private MyServer server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String name;

    public String getName() {
        return name;
    }


    public ClientHandler(MyServer server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    authentification();
                    readMessage();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    closeConnection();
                }
            }).start();

        } catch (IOException ex) {
            throw new RuntimeException("Проблемы при создании обработчика");
        }
    }

    // auth login pass
    private void authentification() throws IOException {
        while (true) {
            String str = in.readUTF();
            if (str.startsWith(Constants.AUTH_COMMAND)) {
                String tokens[] = str.split("\\s+"); //3
                String nick = server.getAuthService().getNickByLoginAndPass(tokens[1], tokens[2]);

                if (nick != null) {
                    if (!server.isNickBusy(nick)) {
                        name = nick;
                        //Авторизовались
                        sendMessage(Constants.AUTH_OK_COMMAND + " " + nick);
                        server.broadcastMessage(nick + " вошел в чат");
                        server.subscribe(this);
                        return;
                    }
                } else {
                    sendMessage("Неверные логин/пароль");
                }
            }

        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readMessage() throws IOException {
        while (true) {
            String messageFromClient = in.readUTF();
            //hint: здесь можем получать команду
            if (messageFromClient.startsWith((Constants.PRIVATE_MESSAGE))) {
                String[] parts = messageFromClient.split("\\s");
                String nickToMessage = parts[1];
                String message = parts[2];
                server.privateMessage(this, nickToMessage, message);
                System.out.println("Сообщение только для " + nickToMessage + ": " + message);
            } else {
                System.out.println("Сообщение от " + name + ": " + messageFromClient);
                server.broadcastMessage(name + ": " + messageFromClient);
            }

            if (messageFromClient.equals(Constants.END_COMMAND)) {
                break;
            }
        }
    }

    private void closeConnection() {
        server.unsubscribe(this);
        server.broadcastMessage(name + " вышел из чата");
        try {
            in.close();
        } catch (IOException e) {
            //ignore
        }
        try {
            out.close();
        } catch (IOException e) {
            //ignore
        }
        try {
            socket.close();
        } catch (IOException e) {
            //ignore
        }
    }
}
