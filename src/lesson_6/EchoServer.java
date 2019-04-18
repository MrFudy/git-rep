package lesson_6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class EchoServer {


    public static void main(String[] args) {
        EchoServer server = new EchoServer();
    }

    public EchoServer() {

        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(3443);
            System.out.println("Сервер ожидает подключения");
            socket = server.accept();
            System.out.println("Кто-то подключился");
            Scanner in =  new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println("Введите сообщение > ");
                        String msg = sc.nextLine();
                        out.println(msg);
                    }
                }
            }).start();
            while (true) {
                String msg = in.nextLine();
                if (msg.equals("/end")) break;
                System.out.println("Client: " + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                server.close();
                System.out.println("Сервер отключен");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
