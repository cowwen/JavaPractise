import java.net.*;
import java.io.*;
import java.util.Date;

public class DayTime{
	public final static int PORT = 13;

	public static void main(String[] args){
		ServerSocket server;
		try{
			server = new ServerSocket(PORT);
			while(true){
				Socket connection = server.accept();
				try{
					Writer out = new OutputStreamWriter(connection.getOutputStream());
					Date now = new Date();
					out.write(now.toString() + "\r\n");
					out.flush();
					connection.close();

				}catch(IOException ex){
					System.out.println(ex);	
				}
			}
		}catch(IOException ex){
			System.out.println(ex);
		}
	}
}
