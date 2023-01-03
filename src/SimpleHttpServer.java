import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.net.ServerSocket; 
import java.net.Socket;
import java.util.Date;



public class SimpleHttpServer {
    public static void main(String[] args) throws IOException {
        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080");
        while(true){
            // final Socket clientSocket = server.accept();
            // //1. Read Http Request from the client socket
            // //2. Prepare an Http Response
            // //3. Send Http response to the client 
            // //4. close the socket

            // //Code to read Http request in my server
            // InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            // BufferedReader reader = new BufferedReader(isr);
            // String line = reader.readLine();
            // while (!line.isEmpty()) {
            //     System.out.println(line);
            //     line = reader.readLine();
            // }

            try (Socket socket = server.accept()) { 
                Date today = new Date(); 
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today; socket.getOutputStream() 
                .write(httpResponse.getBytes("UTF-8")); 
            }

            // NB: The only limitation of this server is that it can serve one client at a time
            // The problem can be solved using threads or Java NIO non-blocking selectors and channels.
        }
    }
}
