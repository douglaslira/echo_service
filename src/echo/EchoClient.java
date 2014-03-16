package echo;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class EchoClient {
    private static final int PORT = 9000;

    public static void main(String[] args) {
            try {
                    TTransport transport = new TSocket("localhost", PORT);
                    TProtocol protocol = new TBinaryProtocol(transport);
					EchoService.Client client = new EchoService.Client(protocol);
                    transport.open();
                    transport.close(); 
            } catch (TTransportException e) {
                    e.printStackTrace();
            } catch (TException e) {
                    e.printStackTrace();
            }
    }
}