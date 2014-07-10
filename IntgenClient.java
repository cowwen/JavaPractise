import java.nio.*;
import java.nio.channels.*;
import java.net.*;
import java.io.IOException;

public class IntgenClient{
	public static void main(String[] args) {
		final int port = 1919;

		if(args.length == 0){
			System.out.println("give a server ip address.");
			return ;
		}

		try{
			InetSocketAddress addr = new InetSocketAddress(args[0], port);
			SocketChannel client = SocketChannel.open(addr);
			ByteBuffer buffer = ByteBuffer.allocate(4);
			IntBuffer view = buffer.asIntBuffer();

			for(int expected = 0; ; expected++){
				client.read(buffer);
				int actual = view.get();
				buffer.clear();
				view.rewind();

				if(actual != expected){
					System.err.println("Expected: " + expected +
							" Actual: " + actual);
					break;
				}
				System.out.println(actual);
			}
		}catch(IOException ex){
			ex.printStackTrace();
		}
		

	}
}