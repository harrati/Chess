package com.harrati.chess;

import com.harrati.chess.pieces.Piece;
import com.harrati.chess.pieces.PieceOld;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Afficher extends JFrame{
	public static int[][] Grille =new int[8][8];
	private int[] caseSel =new int[] {-1, -1};
	public int role= Piece.WHITE;
	boolean net=true;
	boolean connected = false;
	public static PieceOld[] element ={
			new PieceOld(PieceOld.NOIR,"Tour",	0,0,0),
			new PieceOld(PieceOld.NOIR,"Cheval",	1,0,1),
			new PieceOld(PieceOld.NOIR,"Fou",		2,0,2),
			new PieceOld(PieceOld.NOIR,"Reine",	3,0,3),
			new PieceOld(PieceOld.NOIR,"Roi",		4,0,4),
			new PieceOld(PieceOld.NOIR,"Fou",		5,0,5),
			new PieceOld(PieceOld.NOIR,"Cheval",	6,0,6),
			new PieceOld(PieceOld.NOIR,"Tour",	7,0,7),
			new PieceOld(PieceOld.NOIR,"Pion",	0,1,8),
			new PieceOld(PieceOld.NOIR,"Pion",	1,1,9),
			new PieceOld(PieceOld.NOIR,"Pion",	2,1,10),
			new PieceOld(PieceOld.NOIR,"Pion",	3,1,11),
			new PieceOld(PieceOld.NOIR,"Pion",	4,1,12),
			new PieceOld(PieceOld.NOIR,"Pion",	5,1,13),
			new PieceOld(PieceOld.NOIR,"Pion",	6,1,14),
			new PieceOld(PieceOld.NOIR,"Pion",	7,1,15),
			
			new PieceOld(PieceOld.BLANC,"Pion",	0,6,16),
			new PieceOld(PieceOld.BLANC,"Pion",	1,6,17),
			new PieceOld(PieceOld.BLANC,"Pion",	2,6,18),
			new PieceOld(PieceOld.BLANC,"Pion",	3,6,19),
			new PieceOld(PieceOld.BLANC,"Pion",	4,6,20),
			new PieceOld(PieceOld.BLANC,"Pion",	5,6,21),
			new PieceOld(PieceOld.BLANC,"Pion",	6,6,22),
			new PieceOld(PieceOld.BLANC,"Pion",	7,6,23),
			new PieceOld(PieceOld.BLANC,"Tour",	0,7,24),
			new PieceOld(PieceOld.BLANC,"Cheval",	6,7,25),
			new PieceOld(PieceOld.BLANC,"Fou",	2,7,26),
			new PieceOld(PieceOld.BLANC,"Reine",	3,7,27),
			new PieceOld(PieceOld.BLANC,"Roi",	4,7,28),
			new PieceOld(PieceOld.BLANC,"Fou",	5,7,29),
			new PieceOld(PieceOld.BLANC,"Cheval",	1,7,30),
			new PieceOld(PieceOld.BLANC,"Tour",	7,7,31)
		};

	public class ChessPanel extends JPanel {
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			createEchiquier (g);
			placerPieces(g);
			if (caseSel[0] != -1) {
				g.setColor(Color.red);
				g.drawRect(caseSel[0] * 100, caseSel[1] * 80, 100, 80);
			}
			
		}
		
		public void createEchiquier (Graphics g) {

		    Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/back.gif")) ;
		    g.drawImage(img,0,0,this);
		  }
		
		public void placerPieces(Graphics g){
			for (PieceOld pieceOld : element) {
				if (pieceOld.etat == 1) {
					Image img = Toolkit.getDefaultToolkit().getImage(pieceOld.src);
					g.drawImage(img, pieceOld.coords[0] * 100, pieceOld.coords[1] * 80, 100, 80, this);
				}
			}
		}
	}
	
	public JLabel lbl = new JLabel();
	public ChessPanel pan = new ChessPanel();
	JPanel pan2 = new JPanel();
	
	Afficher(){
	    createMenuBar();
	    lbl.setText("BienVenu ^_^");
		this.setTitle("ChessJava");
		pan.setSize(800, 640);
		this.setSize(800, 710);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setBackground(Color.white);
	    pan.addMouseListener(new Mouse());
	    pan2.add(lbl);
	    pan2.setBackground(new Color(189, 186, 172));
	    this.getContentPane().add(pan, BorderLayout.CENTER);
	    this.getContentPane().add(pan2, BorderLayout.SOUTH);
	}

	public void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		menuBar.setBackground(new Color(189, 186, 172));
		
		MenuListener mL = new MenuListener();
		
		JMenu menu1 = new JMenu("Fichier");
	  	menuBar.add(menu1);
	  	JMenuItem menuItem11 = new JMenuItem("Nouvelle partie");
	    menuItem11.addActionListener(mL);
	    menu1.add(menuItem11);
	    menu1.addSeparator();
	    JMenuItem menuItem12 = new JMenuItem("Quitter");
	    menuItem12.addActionListener(mL);
	    menu1.add(menuItem12);
	  	
	    JMenu menu2 = new JMenu("Réseau");
	  	menuBar.add(menu2);
	    JMenuItem menuItem21 = new JMenuItem("Servir partie");
	    menuItem21.addActionListener(mL);
	    menu2.add(menuItem21);
	    JMenuItem menuItem22 = new JMenuItem("Rejoindre partie");
	    menuItem22.addActionListener(mL);
	    menu2.add(menuItem22);
	    
	  	JMenu menu3 = new JMenu("Outils!");
	  	JMenuItem menuItem31=new JMenuItem("A Propos ...");
	  	menuItem31.addActionListener(mL);
	    menu3.add(menuItem31);
	    JMenuItem menuItem32=new JMenuItem("Aide...");
	  	menuItem32.addActionListener(mL);
	    menu3.add(menuItem32);
	  	menuBar.add(menu3);
	  	menuItem11.setBackground(new Color(189, 186, 172));
	  	menuItem12.setBackground(new Color(189, 186, 172));
	  	menuItem21.setBackground(new Color(189, 186, 172));
	  	menuItem22.setBackground(new Color(189, 186, 172));
	  	menuItem31.setBackground(new Color(189, 186, 172));
	  	menuItem32.setBackground(new Color(189, 186, 172));
	}
	
	JFrame w=this;
	public class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if (cmd.equals("Quitter")){
				Init.f.lbl.setText("Fermeture !");
				Helper.close();
			}
			if (Objects.equals(cmd, "Nouvelle partie")){
				lbl.setText("Nouvelle partie");
				Helper.reset();
			}
			if (Objects.equals(cmd, "Servir partie")){
				lbl.setText("Attente d'une connection sur le port " + Reseau.PORT + "...");
				Reseau.servir();
			}
			if (cmd == "Rejoindre partie"){
				String host = Helper.prompt("donnez l'adresse du serveur:");
				Reseau.rejoindre(host);
			}
			if (cmd == "A Propos ..."){
				Helper.about();
			}
			if (cmd == "Aide..."){
				Helper.Help();
			}
		}
	}
	
	class Mouse extends MouseAdapter {
		public void mouseClicked(MouseEvent m) {
			super.mouseClicked(m);
			if (m.getClickCount() == 1 && m.getButton() == MouseEvent.BUTTON1 && net) {
				int[] coord = new int[] { m.getX() / 100 , m.getY() / 80 };
				if (caseSel[0] == -1) {
					if (Grille[coord[0]][coord[1]] != 0) {
						caseSel = coord;
						repaint();
					}
				}
				else {
					if(element[(Grille[caseSel[0]][caseSel[1]]) - 1].deplacer(caseSel, coord)){
						int y1 = caseSel[1];
						char x1 = (char)('A' + caseSel[0]);
						int y = coord[1];
						char x = (char)('A' + coord[0]);
						lbl.setText("deplacement de: " + x1 +y1+" vers: " + x +y);
						if(connected){
							String text = Grille[coord[0]][coord[1]]
								                   +"/"+caseSel[0]+caseSel[1]
								                                       +"/"+coord[0]+coord[1];
							Reseau.text = text;
							Reseau.send.send(Reseau.socket,text);
						}
					}
					repaint();
					caseSel = new int[] {-1, -1};
				}
			}
		}
	}
}
