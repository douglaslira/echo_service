package echo;

import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.Assert;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.junit.BeforeClass;
import org.junit.Test;

public class EchoTest {
    private static final int PORT = 9000;

    @BeforeClass
    @SuppressWarnings({ "static-access" })
    public static void startServer() throws URISyntaxException, IOException {
            // Start thrift server in a seperate thread
            new Thread(new EchoServer()).start();
            try {
                    // wait for the server start up
                    Thread.sleep(100);
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
    }
    @Test
    public void testExample() throws TTransportException, TException {
            TTransport transport = new TSocket("localhost", PORT);
            TProtocol protocol = new TBinaryProtocol(transport);
            EchoService.Client client = new EchoService.Client(protocol);
            transport.open();
            String result = client.echo("Hello World!");
            transport.close();
            Assert.assertEquals("Hello World!", result);
    }
}