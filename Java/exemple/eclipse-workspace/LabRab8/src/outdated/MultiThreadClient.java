package outdated;

import java.net.*;
import java.io.*;

public class MultiThreadClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket clientSocket = new Socket("127.0.0.1", 8000);
		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
		
		System.out.println("Hi");
		
		
		Socket clientSocket1 = new Socket("127.0.0.1", 8000);
		
		BufferedWriter writer1 = new BufferedWriter(new OutputStreamWriter(clientSocket1.getOutputStream()));
		
		
		
		writer.write("127.0.0.0 Niko");
		writer.flush();
		
		writer1.write("127.45.24.115 Dany");
		writer1.flush();
		
		writer.close();
		writer1.close();
		clientSocket.close();
	}
	
}
