package netprogram;
//: NameCollector.java
// Extracts email names from datagrams and stores
// them inside a file, using Java 1.02.
import java.net.*;
import java.io.*;
import java.util.*;

/**
 * Created by vingc on 2017/3/3.
 */
public class NameCollector {
    final static int COLLECTOR_PORT = 8080;
    final static int BUFFER_SIZE = 1000;
    byte[] recvDpBuf  = new byte[BUFFER_SIZE];
    DatagramPacket dp = new DatagramPacket( recvDpBuf, recvDpBuf.length );
    // Can listen & send on the same socket:
    DatagramSocket   socket;
    Process          listmgr;
    PrintStream      nameList;
    DataInputStream  addResult;

    public NameCollector() {
        try {
            listmgr  = Runtime.getRuntime().exec( "listmgr.exe" );
            nameList = new PrintStream(
                           new BufferedOutputStream(
                               listmgr.getOutputStream() ) );
            addResult = new DataInputStream(
                            new BufferedInputStream(
                                listmgr.getInputStream() ) );
        } catch( IOException e ) {
            System.err.println( "Cannot start listmgr.exe" );
            System.exit( 1 );
        }

        try {
            socket = new DatagramSocket( COLLECTOR_PORT );
            System.out.println( "NameCollector Server started" );
            while( true ) {
                // Block until a datagram appears:
                socket.receive(dp);
                String rcvd = dp.getData().toString();
                // Send to listmgr.exe standard input:
                nameList.println(rcvd.trim());
                nameList.flush();

                byte[] resultBuf = new byte[BUFFER_SIZE];
                int byteCount = addResult.read(resultBuf);
                if (byteCount != -1) {
                    String result = resultBuf.toString().trim();

                    // Extract the address and port from
                    // the received datagram to find out
                    // where to send the reply:
                    InetAddress senderAddress = dp.getAddress();
                    int senderPort = dp.getPort();
                    byte[] echoBuf = result.getBytes();

                    DatagramPacket echo = new DatagramPacket(echoBuf, echoBuf.length, senderAddress, senderPort);
                    socket.send(echo);
                } else {
                    System.out.println( "Unexpected lack of result from " + "listmgr.exe" );
                }
            }
        } catch( SocketException e ) {
                System.err.println( "Can't open socket" );
                System.exit( 1 );
        } catch(IOException e) {
            System.err.println( "Communication error" );
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new NameCollector();
    }
} ///:~