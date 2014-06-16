import java.net.*;

public class URLEquality{
	public static void main(String[] args){
		try{
			final long start = System.currentTimeMillis();
			URL www = new URL(args[0]);
			URL baidu = new URL(args[1]);
			if(www.equals(baidu)){
				System.out.println("true");
			}else{
				System.out.println("false");
			}
			final long end = System.currentTimeMillis();
			System.out.println("used time: " + (end - start));
		}catch(MalformedURLException ex){
		
		}
	}
}
