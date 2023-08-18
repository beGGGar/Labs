package outdated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import javax.swing.JFrame;

public class MultiThreadServer {

	public static void main(String[] args) throws IOException {
		System.out.println("Start");
		ServerSocket serverSocket = new ServerSocket(8000);
		
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            PanelCommon pc = new PanelCommon();
            frame.add(pc);
            frame.setSize(500, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);


		while (true) {
			Socket clientSocket = serverSocket.accept();

			BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			String request = reader.readLine();
			System.out.println(request);
			pc.AddSmth(request);
			
            reader.close();
            clientSocket.close();
		}

	}
}
