
import java.io.*;
import java.net.*;

public class EchoClient {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
		String line;
		line = br.readLine();
		while(!line.equals("")){
			Socket connect = new Socket("localhost", 2888);

			BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(connect.getOutputStream()));
			out.write(line, 0, line.length());

			BufferedReader in = new BufferedReader(
				new InputStreamReader(connect.getInputStream()));
			String res = in.readLine();

			System.out.println("Response from server: " + res);

			line = br.readLine();
		}
	}
}