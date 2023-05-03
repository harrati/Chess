package com.harrati.chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


@SuppressWarnings("serial")
public  class About extends  JFrame {
	class Panneau extends JPanel{
		public void paintComponent(Graphics g){
			Image img =Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/logo.gif"));
			g.drawImage(img,0,0,600,150,this);
		}
	}
	
	Panneau pan = new Panneau();
      
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JLabel jLabel6;
    private JLabel jLabel2;
    private JLabel jLabel1;

    About(){
    	this.setTitle("About...");
    	this.getContentPane().add(pan);
    	this.setSize(500,500);
    	this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    	this.setLocationRelativeTo(null);
    	this.setForeground(Color.RED);
    	this.setResizable(false);
    	this.setAlwaysOnTop(true);
    	{
    		getContentPane().add(pan, BorderLayout.CENTER);
    		pan.setLayout(null);
    		{
    			jLabel1 = new JLabel();
    			pan.add(jLabel1);
    			jLabel1.setText("  Projet Java  :  Jeu d'Echec");
    			jLabel1.setBounds(71, 162, 300, 30);
    			jLabel1.setBorder(BorderFactory.createCompoundBorder(null, null));
    			jLabel1.setFont(new java.awt.Font("Book Antiqua",3,24));
    			jLabel1.setForeground(new Color(0,0,128));
    		}
    		{
    			jLabel2 = new JLabel();
    			pan.add(jLabel2);
    			jLabel2.setText("L'équipe de travail :");
    			jLabel2.setBounds(32, 217, 258, 42);
    			jLabel2.setFont(new java.awt.Font("Book Antiqua",3,18));
    			jLabel2.setForeground(new Color(0,64,128));
    		}
    		{
    			jLabel3 = new JLabel();
    			pan.add(jLabel3);
    			jLabel3.setText("-Youssef HARRATI");
    			jLabel3.setBounds(44, 265, 171, 25);
    			jLabel3.setFont(new java.awt.Font("Bookman Old Style",2,16));
    		}
    		{
    			jLabel4 = new JLabel();
    			pan.add(jLabel4);
    			jLabel4.setText("-Fatima-Zahra KADDOURI");
    			jLabel4.setBounds(61, 290, 229, 26);
    			jLabel4.setFont(new java.awt.Font("Bookman Old Style",2,16));
    		}
    		{
    			jLabel5 = new JLabel();
    			pan.add(jLabel5);
    			jLabel5.setText("-Hassna CHOUKRI");
    			jLabel5.setBounds(89, 315, 181, 20);
    			jLabel5.setFont(new java.awt.Font("Bookman Old Style",2,16));
    		}
    		{
    			jLabel6 = new JLabel();
    			pan.add(jLabel6);
    			jLabel6.setText("Encadré par:");
    			jLabel6.setBounds(32, 352, 246, 38);
    			jLabel6.setFont(new java.awt.Font("Book Antiqua",3,18));
    			jLabel6.setForeground(new Color(0,64,128));
    		}
    		{
    			jLabel7 = new JLabel();
    			pan.add(jLabel7);
    			jLabel7.setText("Mr. A.NEJEOUI");
    			jLabel7.setBounds(56, 381, 189, 30);
    			jLabel7.setFont(new java.awt.Font("Bookman Old Style",2,16));
    		}
    		{
    			jLabel8 = new JLabel();
    			pan.add(jLabel8);
    			jLabel8.setText("2010/2011");
    			jLabel8.setBounds(301, 403, 130, 33);
    			jLabel8.setFont(new java.awt.Font("Bookman Old Style",3,18));
    			jLabel8.setForeground(new Color(0,0,128));
    		}
         }
	 }
}
	

