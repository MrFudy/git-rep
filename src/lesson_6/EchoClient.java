package lesson_6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) {

        Socket socket = null;

        try {
            socket = new Socket("localhost", 3443);
            Scanner in =  new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String msg = in.nextLine();
                        System.out.println("Server: " + msg);
                    }
                }
            }).start();

            while (true) {
                System.out.println("Введите сообщение");
                String msg = sc.nextLine();
                out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
