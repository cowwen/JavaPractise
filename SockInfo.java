import java.net.*;
import java.io.*;

public class SockInfo{
	public static void main(String[] args){
		String host = args[0];
		try{
			Socket theSocket = new Socket(host, 80);
			System.out.println("Connected to" + theSocket.getInetAddress() + "on port:" + theSocket.getPort() + "from port " + theSocket.getLocalPort() + " of " + theSocket.getLocalAddress());

		}catch(UnknownHostException ex){
			System.err.println("I can't find " + host);
		}catch(SocketException ex){
			System.err.println("Count not connect to " + host);
		}catch(IOException ex){
			System.err.println(ex);
		}
	}
}
