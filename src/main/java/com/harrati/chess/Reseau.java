package com.harrati.chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Reseau{
	final static int PORT = 6677;
	
	
	static Socket socket ;
	
	public static String text;
	
	static Send send = new Send(socket, text);
	
	static Read lire ;

	
	
	
	public static void servir(){
		ServerSocket sock;
		try {
			sock = new ServerSocket(PORT);
		}
		catch (IOException e){
			Init.f.lbl.setText("Listen failed: " + e.getMessage());
			return;
		}
		Init.f.lbl.setText("Attente d'une connection sur le port " + PORT + "...");
		try {
			Socket socket = sock.accept();
			Reseau.socket = socket;
		}
		catch (IOException e){
			System.out.println();
			Init.f.lbl.setText("Accept failed: " + e.getMessage());
			return;
		}
		Init.f.lbl.setText("Connection acceptee.");
		
		try { 
			sock.close();
		}
		catch (IOException e){ 
			System.out.println();
			Init.f.lbl.setText("Close failed: " + e.getMessage());
		}
		Init.f.net = true;
		Init.f.connected = true;
		Helper.reset();
		Helper.alert(Init.f, "Partie servie ^_^");
		return;
	}
	
	public static void rejoindre(String host){
		try {
			Socket socket = new Socket(host, PORT);
			Reseau.socket = socket;
		}
		catch (IOException e){
			Init.f.lbl.setText("Connect failed: " + e.getMessage());
			return;
		}
		Init.f.net = false;
		Init.f.connected = true;
		Helper.reset();
		Helper.alert(Init.f, "Rejoindre OK ^_^");
		Init.f.lbl.setText("Connection acceptee.");
		lire = new Read(Reseau.socket);
		lire.start();
	}
}

class Send{
	String text;
	Socket socket;
	
	Send(Socket sock, String txt){
		this.text = txt;
		this.socket = sock;
	}
	
	void send(Socket sock, String txt){
		try {
			PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
			out.println(txt);
			Init.f.net = false;
		}
		catch (IOException e){
			e.printStackTrace();
		}
		try{
			Reseau.lire = new Read(sock);
			Reseau.lire.start();
		}catch(IllegalThreadStateException e){
			System.out.println();
			Init.f.lbl.setText("IllegalThreadStateException: "+e.getMessage());
			return;
		}
	}
}

class Read extends Thread{
	Socket socket;
	
	Read(Socket sock){
		super("Read");
		this.socket = sock;
	}
	
	@SuppressWarnings({ "static-access" })
	void accept(){
		int elem;
		int []src = new int[2];
		int []dst = new int[2];
		try {
			BufferedReader in = 
				new BufferedReader(new InputStreamReader(Reseau.socket.getInputStream()));
			String input;
			input = in.readLine();
			
			String [] x = input.split("/");
			elem = Integer.parseInt(x[0]);
			src[0] = (int)x[1].charAt(0) - 48;
			src[1] = (int)x[1].charAt(1) - 48;
			dst[0] = (int)x[2].charAt(0) - 48;
			dst[1] = (int)x[2].charAt(1) - 48;
			Init.f.net = true;
			Init.f.element[elem-1].deplacer(src, dst);
			Init.f.repaint();
		}catch (IOException e) {
			return ;
		}
	}
	
	@SuppressWarnings("deprecation")
	public void run(){
		accept();
		Reseau.lire.stop();
		Reseau.lire = null;
	}
}