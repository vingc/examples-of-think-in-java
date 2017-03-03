package netprogram;

/**
 * Created by vingc on 2017/3/3.
 */
import java.io.*;
import java.net.*;

public class SimpleClient {
    //simple client will create a socket to connect to simpleServer,and sends several lines to it,
    //meanwhile receives the messages from simpleServer, then dumps it to console.
    //"END" string will end the connection between each other.

    public static void main( String[] args ) throws  IOException {
        InetAddress addr = InetAddress.getByName( SimpleServer.URL );

        Socket socket = new Socket( addr, SimpleServer.PORT );
        /* guard the resource used by socket would be recycled after the connection is ended or error occurs.
        * */
        try {
            System.out.println( "client: " + socket );

            BufferedReader in = new BufferedReader(
                                    new InputStreamReader(
                                        socket.getInputStream() ) );
            PrintWriter   out = new PrintWriter(
                                    new BufferedWriter(
                                        new OutputStreamWriter(
                                            socket.getOutputStream() ) ), true );

            for( int i = 0; i < 10; i++ ) {
                out.println( "test from simple client: line " + i );
                String recv = in.readLine();
                System.out.println( "Recv: " + recv );
            }

            out.println( "END" ); // end the connection with simpleServer
        } finally {
            socket.close();
        }
    }
}
