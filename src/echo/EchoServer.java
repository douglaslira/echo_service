package echo;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class EchoServer implements Runnable {
     private static final int PORT = 9000;

     @Override
     public void run() {
             try {
                     TServerSocket serverTransport = new TServerSocket(PORT);
					EchoService.Processor processor = new EchoService.Processor(new EchoServiceHandler());
                     TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
                     System.out.println("Starting server on port " + PORT);
                     server.serve();
             } catch (TTransportException e) {
                     e.printStackTrace();
             }
     }

     public static void main(String[] args) {
             new Thread(new EchoServer()).run();
     }
}	