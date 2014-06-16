import java.net.NetworkInterface;
import java.util.Enumeration;

public class ShowInterface{
	public static void main(String[] args) throws Exception{
		Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		while(interfaces.hasMoreElements()){
			NetworkInterface ni = interfaces.nextElement();
			System.out.println(ni);
			Enumeration addresses = ni.getInetAddresses();
			while(addresses.hasMoreElements()){
				System.out.println(addresses.nextElement());
			}
		}
	}
}
