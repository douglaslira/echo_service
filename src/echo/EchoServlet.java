package echo;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.server.TServlet;

public class EchoServlet extends TServlet {
        public EchoServlet() {
                super(
                        new EchoService.Processor(
                                new EchoServiceHandler()),
                                new TJSONProtocol.Factory()
                );
        }
        
        
}