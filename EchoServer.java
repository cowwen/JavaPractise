import java.io.*;
import java.net.*;

public class EchoServer{
	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(2888);

		while(true){
			Socket con = server.accept();
			BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
			String lineStr = in.readLine();

			BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(con.getOutputStream()));
			while(true){
				if(lineStr == null || "".equals(lineStr)
					|| "bye".equals(lineStr)){
					con.close();
					break;
				} else{
					out.write(lineStr, 0, lineStr.length());
					out.newLine();
					out.flush();
				}
				lineStr = in.readLine();
			}
			
		}
	}
}