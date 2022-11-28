package br.edu.ifsuldeminas.mch.sd.sockets.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread{
	
	   private DataInputStream inputFlow;
	   private DataOutputStream outputFlow;
	   private Socket socket;

	   public ClientHandler(Socket socket) {
		   try {
			   this.socket = socket;
	           this.inputFlow = new DataInputStream(this.socket.getInputStream());
	           this.outputFlow = new DataOutputStream(this.socket.getOutputStream());
	        } catch (IOException ioException) {
	        	System.err.printf("Erro na coneção com o cliente: %s",ioException.getMessage());
	        }
	    }

	    public void run() {
	    	
	    	try {
	    		while (true) {
	    			String message = inputFlow.readUTF();
	    			System.out.printf("Mensagem > %s \n", message);
	    			outputFlow.writeUTF(message);
	    			this.socket.close();
	            }
	        } catch (IOException ioException) {
	        	
	        }
	    }
	    
}
