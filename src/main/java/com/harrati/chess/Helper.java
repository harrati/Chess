package com.harrati.chess;

import com.harrati.chess.pieces.PieceOld;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Helper {
	static void alert(JFrame f,String message){
		JOptionPane.showMessageDialog(f, message);
	}
	
	static String prompt(String prompt){
		
		return JOptionPane.showInputDialog(prompt);
	}
	
	static int confirm(String msg, String titre){
		
		return JOptionPane.showConfirmDialog(Init.f, msg, titre, JOptionPane.YES_NO_OPTION);
	}
	
	static void about(){
		About x = new About();
		x.setVisible(true);
	}
	
	static void close(){
		if(confirm("voulez-vous vraiment quitter la partie?", "Fermeture:") == 0){
			System.out.println("Fermeture!!!");
			System.exit(0);
		}
	}
	
	static void Help(){
		@SuppressWarnings("unused")
		Help x = new Help();
		System.out.println("help..");
	}
	
	static void reset(){
		int Grille[][]=new int[8][8];
		Afficher.Grille=Grille;
		Init.f.role = PieceOld.BLANC;
		PieceOld element[]={
			new PieceOld(PieceOld.NOIR,"Tour",0,0,0),
			new PieceOld(PieceOld.NOIR,"Cheval",1,0,1),
			new PieceOld(PieceOld.NOIR,"Fou",2,0,2),
			new PieceOld(PieceOld.NOIR,"Reine",3,0,3),
			new PieceOld(PieceOld.NOIR,"Roi",4,0,4),
			new PieceOld(PieceOld.NOIR,"Fou",5,0,5),
			new PieceOld(PieceOld.NOIR,"Cheval",6,0,6),
			new PieceOld(PieceOld.NOIR,"Tour",7,0,7),
			new PieceOld(PieceOld.NOIR,"Pion",0,1,8),
			new PieceOld(PieceOld.NOIR,"Pion",1,1,9),
			new PieceOld(PieceOld.NOIR,"Pion",2,1,10),
			new PieceOld(PieceOld.NOIR,"Pion",3,1,11),
			new PieceOld(PieceOld.NOIR,"Pion",4,1,12),
			new PieceOld(PieceOld.NOIR,"Pion",5,1,13),
			new PieceOld(PieceOld.NOIR,"Pion",6,1,14),
			new PieceOld(PieceOld.NOIR,"Pion",7,1,15),
			
			new PieceOld(PieceOld.BLANC,"Pion",0,6,16),
			new PieceOld(PieceOld.BLANC,"Pion",1,6,17),
			new PieceOld(PieceOld.BLANC,"Pion",2,6,18),
			new PieceOld(PieceOld.BLANC,"Pion",3,6,19),
			new PieceOld(PieceOld.BLANC,"Pion",4,6,20),
			new PieceOld(PieceOld.BLANC,"Pion",5,6,21),
			new PieceOld(PieceOld.BLANC,"Pion",6,6,22),
			new PieceOld(PieceOld.BLANC,"Pion",7,6,23),
			new PieceOld(PieceOld.BLANC,"Tour",0,7,24),
			new PieceOld(PieceOld.BLANC,"Cheval",6,7,25),
			new PieceOld(PieceOld.BLANC,"Fou",2,7,26),
			new PieceOld(PieceOld.BLANC,"Reine",3,7,27),
			new PieceOld(PieceOld.BLANC,"Roi",4,7,28),
			new PieceOld(PieceOld.BLANC,"Fou",5,7,29),
			new PieceOld(PieceOld.BLANC,"Cheval",1,7,30),
			new PieceOld(PieceOld.BLANC,"Tour",7,7,31)
		};
		Afficher.element=element;
		Init.f.repaint();
	}
}
