package echo;

import org.apache.thrift.TException;
 
public class EchoServiceHandler implements EchoService.Iface{
	@Override
	public String echo(String message) throws TException {
		return message;
	}
	
}