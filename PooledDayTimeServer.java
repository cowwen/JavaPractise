import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class PooledDayTimeServer{
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(50);

		try(ServerSocket server = new ServerSocket(1888)){
			while(true){
				try{
					Socket connection = server.accept();
					Callable<Void> task = new DayTimeTask(connection);
					pool.submit(task);
				}catch(IOException ex){
					System.out.println(ex);
				}
			}
		}catch(IOException ex){
			System.out.println(ex);
		}	
	}

	public static class DayTimeTask implements Callable<Void>{

		private Socket connection;

		public DayTimeTask(Socket con){
			connection = con;
		}

		public Void call(){
			try{
				Writer out = new OutputStreamWriter(connection.getOutputStream());
				Date now = new Date();
				out.write(now.toString() + " Power by Cowwen!\r\n");
				out.flush();
			}catch(IOException ex){
				System.out.println(ex);
			}finally{
				try{
					connection.close();
				}catch(IOException ex){
					System.out.println(ex);
				}
			}
			return null;
		}
	}
}
