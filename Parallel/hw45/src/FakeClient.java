import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

/**
 * Created by moth on 2/19/16.
 */
public class FakeClient implements Runnable{

    private BufferedReader in;
    private PrintWriter out;

    /**
     * Constructs the client by laying out the GUI and registering a
     * listener with the textfield so that pressing Enter in the
     * listener sends the textfield contents to the server.
     */
    public FakeClient() {

        
    }

    /**
     * Implements the connection logic by prompting the end user for
     * the server's IP address, connecting, setting up streams, and
     * consuming the welcome messages from the server.   The Capitalizer
     * protocol says that the server sends three lines of text to the
     * client immediately after establishing a connection.
     */
    public void connectToServer() throws IOException {

        // Get the server address from a dialog box.
        String serverAddress = "127.0.0.1";

        // Make connection and initialize streams
        Socket socket = new Socket(serverAddress, 9898);
        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        // Consume the initial welcoming messages from the server
        /*for (int i = 0; i < 3; i++) {
            System.out.print(in.readLine());
        }*/
        System.out.println();
    }

    /**
     * Runs the client application.
     */
    public static void main(String[] args) throws Exception {
        Thread clients[] = new Thread[75];
        for (int i = 0; i < 75; i++){
            clients[i] = new Thread(new FakeClient());
            clients[i].start();
            
        }
        for (int i = 0; i < 75; i++){
            clients[i].join();
        }
        FakeClient fake = new FakeClient();
        fake.connectToServer();
        fake.out.println("KILL");
    }

    @Override
    public void run() {
       try{
           connectToServer();
           Random rn = new Random();
           int check = rn.nextInt(20) % 4;
           if(check == 0)
               out.println("ADD," + rn.nextInt(20) + "," + rn.nextInt(20));
           else if (check == 1)
               out.println("SUB," + rn.nextInt(20) + "," + rn.nextInt(20));
           else if (check == 2)
               out.println("DIV," + rn.nextInt(20) + "," + (rn.nextInt(20) + 1));
           else if (check == 3)
               out.println("MUL," + rn.nextInt(20) + "," + rn.nextInt(20));
           System.out.println(in.readLine());
       }catch(Exception e){}
    }
}
