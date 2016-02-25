import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A server program which accepts requests from clients to
 * capitalize strings.  When clients connect, a new thread is
 * started to handle an interactive dialog in which the client
 * sends in a string and the server thread sends back the
 * capitalized version of the string.
 *
 * The program is runs in an infinite loop, so shutdown in platform
 * dependent.  If you ran it from a console window with the "java"
 * interpreter, Ctrl+C generally will shut it down.
 */
public class CapitalizeServer {

    /**
     * Application method to run the server runs in an infinite loop
     * listening on port 9898.  When a connection is requested, it
     * spawns a new thread to do the servicing and immediately returns
     * to listening.  The server keeps a unique client number for each
     * client that connects just to show interesting logging
     * messages.  It is certainly not necessary to do this.
     */
    public static void main(String[] args) throws Exception {
        System.out.println("The capitalization server is running.");
        int clientNumber = 0;
        Threshold serverRun = new Threshold();
        ServerSocket listener = new ServerSocket(9898);
        ThreadPool threadPool = new ThreadPool(3, 10, 20);
        Thread monitor = new Thread(threadPool);
        monitor.start();
        try {
            while (!serverRun.isThreshold()){
                Socket temp = listener.accept();
                if(!threadPool.add(new Capitalizer(temp, clientNumber++, serverRun, listener))){
                    (new Thread(new Denial(temp))).start();
                }
            }
        } catch(Exception e){
         System.exit(0);
        }finally{
            if (!listener.isClosed())
                listener.close();
        }
        threadPool.stopPool();
    }

    /**
     * A private thread to handle capitalization requests on a particular
     * socket.  The client terminates the dialogue by sending a single line
     * containing only a period.
     */
    private static class Capitalizer extends Thread {
        private Socket socket;
        private int clientNumber;
        private Threshold serverRun;
        private ServerSocket listener;

        public Capitalizer(Socket socket, int clientNumber, Threshold serverRunning, ServerSocket listener) {
            this.socket = socket;
            this.clientNumber = clientNumber;
            this.serverRun = serverRunning;
            this.listener = listener;
            //log("New connection with client# " + clientNumber + " at " + socket);
        }

        /**
         * Services this thread's client by first sending the
         * client a welcome message then repeatedly reading strings
         * and sending back the capitalized version of the string.
         */
        private String[] constructArray(String input){
            return input.split(",");
        }

        public void run() {
            try {
                // Decorate the streams so we can send characters
                // and not just bytes.  Ensure output is flushed
                // after every newline.
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Send a welcome message to the client.
                //out.println("Hello, you are client #" + clientNumber + ".");
                //out.println("Enter a line with only a period to quit\n");

                // Get messages from the client, line by line; return them
                // capitalized
                    String input = !serverRun.isThreshold() ? in.readLine() : null;
                    if (!(input == null || input.equals("."))) {
                        String subString[] = constructArray(input);
                        //System.out.println(subString[0]);
                        switch (subString[0]) {
                            case "ADD":
                                out.println(subString[1] + " + " + subString[2] + " = " + (Integer.parseInt(subString[1]) + Integer.parseInt(subString[2])));
                                break;
                            case "DIV":
                                out.println(subString[1] + " / " + subString[2] + " = " + (Integer.parseInt(subString[1]) / Integer.parseInt(subString[2])));
                                break;
                            case "MUL":
                                out.println(subString[1] + " * " + subString[2] + " = " + (Integer.parseInt(subString[1]) * Integer.parseInt(subString[2])));
                                break;
                            case "SUB":
                                out.println(subString[1] + " - " + subString[2] + " = " + (Integer.parseInt(subString[1]) - Integer.parseInt(subString[2])));
                                break;
                            case "KILL":
                                serverRun.setThreshold(true);
                                break;
                            default:
                                out.println(input.toUpperCase() + ": Bad argument");
                        }
                    }
            } catch (IOException e) {
                log("Error handling client# " + clientNumber + ": " + e);
            } finally {
                try {
                    socket.close();
                    if (serverRun.isThreshold() && !listener.isClosed())
                        listener.close();
                } catch (IOException e) {
                    log("Couldn't close a socket, what's going on?");
                }
               //log("Connection with client# " + clientNumber + " closed");
            }
        }

        /**
         * Logs a simple message.  In this case we just write the
         * message to the server applications standard output.
         */
        private void log(String message) {
            System.out.println(message);
        }
    }

    private static class Denial implements Runnable {
        private Socket input;
        public Denial(Socket accept) {
            input = accept;
        }

        @Override
        public void run() {
            try{
                (new BufferedReader(new InputStreamReader(input.getInputStream()))).readLine();
                (new PrintWriter(input.getOutputStream(), true)).println("Server is busy, try again later");

            }catch (Exception e){
                System.err.println("Error in Denial");
            }finally{
                try{input.close();}catch(IOException e){}
            }

        }
    }
}
