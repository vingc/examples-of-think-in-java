package netprogram;

/**
 * Created by vingc on 2017/3/3.
 */
import java.io.*;
import java.net.*;

public class SimpleServer {
    // Choose a port outside of the range 1-1024:
    public static final String URL = "localhost";
    public static final int   PORT = 8080;

    public static void main(String[] args) throws IOException {

        ServerSocket s = new ServerSocket( PORT );
        try {
            System.out.println( "Started: " + s );
            // Blocks until a connection occurs:
            Socket socket = s.accept();
            try {
                System.out.println( "Connection accepted: "+ socket );
                BufferedReader in =
                        new BufferedReader(
                            new InputStreamReader(
                                socket.getInputStream()));
                // Output is automatically flushed
                // by PrintWriter:
                PrintWriter out =
                        new PrintWriter(
                            new BufferedWriter(
                                new OutputStreamWriter(
                                    socket.getOutputStream())),true );

                while ( true ) {
                    String str = in.readLine();
                    //if client close the connection directly before sending "END" string,
                    //str would be null.
                    if ( str == null )
                        break;
                    if ( str.equals( "END" ) ) {
                        System.out.println( str );
                        break;
                    }
                    System.out.println( "Echoing: " + str );
                    out.println( str );
                }

            // Always close the two sockets...
            } finally {
                System.out.println( "closing..." );
                socket.close();
            }
        } finally {
            s.close();
        }
    }
}
