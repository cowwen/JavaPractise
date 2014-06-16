import java.io.*;
import java.net.*;

public class WebSourceTextViewer{
	public static void main(String[] args){
		InputStream in = null;
		try{
			URL u = new URL("http://www.baidu.com");
			in = u.openStream();
			int c;
			while((c = in.read()) != -1) System.out.write(c);
		}catch(IOException e){
			System.out.println(e);
		}finally{
			try{
				if(in != null){
					in.close();
				}
			}catch(IOException e){
				System.out.println(e);
			}
		}
	
	}
}
