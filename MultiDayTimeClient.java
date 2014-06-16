import java.io.*;
import java.util.*;
import java.net.*;

public class MultiDayTimeClient{
	public static void main(String[] args) {
		int number = Integer.parseInt(args[0]);
		int counter = 0;
		for(int i = 0; i < number; i++){
			try(Socket connect = new Socket("localhost", 1888)){
				Reader reader = new InputStreamReader(connect.getInputStream());
				StringBuilder sb = new StringBuilder();
				for(int c = reader.read(); c != -1; c = reader.read()){
					sb.append((char)c);
				}
				System.out.println(sb.toString());
			}catch(IOException ex){
				System.out.println(ex);
			}
			counter++;
		}
		System.out.println("Counter: " + counter);
	}
}