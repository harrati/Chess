package com.harrati.chess;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class Help{
	/**
	 * 
	 */
	JFrame f = new JFrame();

	/**
	 * Auto-generated main method to display this JFrame
	 */

	public Help() {
		super();
		initGUI();
		this.f.setVisible(true);
	}

	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout(f.getContentPane());
			f.getContentPane().setLayout(thisLayout);
			f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.f.setResizable(false);
			JPanel jPanel1;
			{
				jPanel1 = new JPanel();
				{
					JLabel jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("Les Régles des échecs");
					jLabel1.setFont(new java.awt.Font("Bodoni MT",2,36));
					jLabel1.setForeground(new java.awt.Color(0,0,255));
					jLabel1.setPreferredSize(new java.awt.Dimension(386, 44));
				}
				{
					JLabel jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("Les échecs se jouent à 2 joueurs. L'un des joueurs joue  avec les pièces blanches, et l'autre joueur avec les pièces noires.Chaque joueur");
					jLabel2.setPreferredSize(new java.awt.Dimension(687, 16));
					jLabel2.setFont(new java.awt.Font("Bell MT",2,14));
				}
				{
					JLabel jLabel3 = new JLabel();
					jPanel1.add(jLabel3);
					jLabel3.setPreferredSize(new java.awt.Dimension(687, 16));
					jLabel3.setFont(new java.awt.Font("Bell MT",2,14));
					jLabel3.setText(" a seize pièces au début du jeu: un Roi, une Dame,deux Tours, deux Fous, deux Cavaliers, et huit Pions.Le jeu se joue sur un ");
				}
				{
					JLabel jLabel4 = new JLabel();
					jPanel1.add(jLabel4);
					jLabel4.setText("échiquier, composé de 64 carrés: huit lignes et huit colonnes. Les carrés sont alternativement clairs (blancs) et de couleur sombre (noirs).");
					jLabel4.setPreferredSize(new java.awt.Dimension(691, 16));
					jLabel4.setFont(new java.awt.Font("Bell MT",2,14));
				}
				{
					JLabel jLabel22 = new JLabel();
					jPanel1.add(jLabel22);
					jLabel22.setText("La Tour");
					jLabel22.setBackground(new java.awt.Color(0,0,255));
					jLabel22.setFont(new java.awt.Font("Bell MT",2,22));
					jLabel22.setForeground(new java.awt.Color(0,0,255));
					jLabel22.setPreferredSize(new java.awt.Dimension(662, 23));
				}
				{
					JLabel jLabel23 = new JLabel();
					jPanel1.add(jLabel23);
					jLabel23.setText("La Tour se déplace en ligne droite, horizontalement ou verticalement d'autant de cases qu'elle le souhaite. La Tour ne peut sauter");
					jLabel23.setPreferredSize(new java.awt.Dimension(687, 16));
					jLabel23.setFont(new java.awt.Font("Bell MT",2,14));
				}
				{
					JLabel jLabel24 = new JLabel();
					jPanel1.add(jLabel24);
					jLabel24.setText(" par dessus d'autres pièces: toutes les cases entre la position de départ de la Tour et sa position d'arrivée doivent être libres.");
					jLabel24.setPreferredSize(new java.awt.Dimension(688, 16));
					jLabel24.setFont(new java.awt.Font("Bell MT",2,14));
				}
				{
					JLabel jLabel28 = new JLabel();
					jPanel1.add(jLabel28);
					jLabel28.setText("Le Fou");
					jLabel28.setPreferredSize(new java.awt.Dimension(662, 23));
					jLabel28.setFont(new java.awt.Font("Bell MT",2,22));
					jLabel28.setForeground(new java.awt.Color(0,0,255));
				}
				{
					JLabel jLabel29 = new JLabel();
					jPanel1.add(jLabel29);
					jLabel29.setText("Le Fou se déplace en diagonale d'autant de cases qu'il le souhaite. Toutefois, le Fou ne peut sauter par dessus d'autres pièces.");
					jLabel29.setPreferredSize(new java.awt.Dimension(688, 16));
					jLabel29.setFont(new java.awt.Font("Bell MT",2,14));
				}
				{
					JLabel jLabel31 = new JLabel();
					jPanel1.add(jLabel31);
					jLabel31.setText("La Dame");
					jLabel31.setPreferredSize(new java.awt.Dimension(662, 23));
					jLabel31.setFont(new java.awt.Font("Bell MT",2,22));
					jLabel31.setForeground(new java.awt.Color(0,0,255));
				}
				{
					JLabel jLabel32 = new JLabel();
					jPanel1.add(jLabel32);
					jLabel32.setText("La Dame est stratégiquement parlant, la pièce maîtresse du jeu. Elle peut aussi bien se déplacer comme une Tour, horizontalement ou");
					jLabel32.setPreferredSize(new java.awt.Dimension(690, 16));
					jLabel32.setFont(new java.awt.Font("Bell MT",2,14));
				}
				{
					JLabel jLabel33 = new JLabel();
					jPanel1.add(jLabel33);
					jLabel33.setText(" verticalement, que comme un Fou, en diagonale");
					jLabel33.setPreferredSize(new java.awt.Dimension(689, 16));
					jLabel33.setFont(new java.awt.Font("Bell MT",2,14));
				}
				{
					JLabel jLabel34 = new JLabel();
					jPanel1.add(jLabel34);
					jLabel34.setText("Le Cavalier");
					jLabel34.setPreferredSize(new java.awt.Dimension(664, 23));
					jLabel34.setFont(new java.awt.Font("Bell MT",2,22));
					jLabel34.setForeground(new java.awt.Color(0,0,255));
				}
				{
					JLabel jLabel35 = new JLabel();
					jPanel1.add(jLabel35);
					jLabel35.setText("Le déplacement du Cavalier se fait en deux temps: un déplacement d'une case dans un sens vertical  ou horizontal, suivi d'un déplacem");
					jLabel35.setPreferredSize(new java.awt.Dimension(690, 16));
					jLabel35.setFont(new java.awt.Font("Bell MT",2,14));
				}
				{
					JLabel jLabel36 = new JLabel();
					jPanel1.add(jLabel36);
					jLabel36.setText("ent d'une case selon une diagonale. ");
					jLabel36.setPreferredSize(new java.awt.Dimension(691, 16));
					jLabel36.setFont(new java.awt.Font("Bell MT",2,14));
				}
				{
					JLabel jLabel39 = new JLabel();
					jPanel1.add(jLabel39);
					jLabel39.setText("Les Pions");
					jLabel39.setPreferredSize(new java.awt.Dimension(664, 23));
					jLabel39.setFont(new java.awt.Font("Bell MT",2,22));
					jLabel39.setForeground(new java.awt.Color(0,0,255));
				}
				{
					JLabel jLabel40 = new JLabel();
					jPanel1.add(jLabel40);
					jLabel40.setText("Les Pions se déplacent différemment selon qu'ils vont sur une case libre ou qu'ils se déplacent  pour prendre une pièce adverse. ");
					jLabel40.setPreferredSize(new java.awt.Dimension(692, 16));
					jLabel40.setFont(new java.awt.Font("Bell MT",2,14));
				}
				{
					JLabel jLabel44 = new JLabel();
					jPanel1.add(jLabel44);
					jLabel44.setText("Le Roi");
					jLabel44.setPreferredSize(new java.awt.Dimension(664, 23));
					jLabel44.setFont(new java.awt.Font("Bell MT",2,22));
					jLabel44.setForeground(new java.awt.Color(0,0,255));
				}
				{
					JLabel jLabel45 = new JLabel();
					jPanel1.add(jLabel45);
					jLabel45.setText("Le Roi se déplace d'une case dans n'importe quelle direction, horizontalement, verticalement ou en diagonale. Il existe un déplacement");
					jLabel45.setPreferredSize(new java.awt.Dimension(693, 16));
					jLabel45.setFont(new java.awt.Font("Bell MT",2,14));
				}
				{
					JLabel jLabel46 = new JLabel();
					jPanel1.add(jLabel46);
					jLabel46.setText(" particulier effectué simultanément par le Roi et une Tour appelé roque: voir plus loin.");
					jLabel46.setPreferredSize(new java.awt.Dimension(693, 16));
					jLabel46.setFont(new java.awt.Font("Bell MT",2,14));
				}
				{
					JLabel jLabel48 = new JLabel();
					jPanel1.add(jLabel48);
					jLabel48.setText("Le Roque");
					jLabel48.setPreferredSize(new java.awt.Dimension(661, 23));
					jLabel48.setFont(new java.awt.Font("Bell MT",2,22));
					jLabel48.setForeground(new java.awt.Color(0,0,255));
				}
				{
					JLabel jLabel49 = new JLabel();
					jPanel1.add(jLabel49);
					jLabel49.setText("Sous certaines conditions, le Roi et l'une des Tours peuvent roquer en se déplaçant simultane.");
					jLabel49.setPreferredSize(new java.awt.Dimension(693, 16));
					jLabel49.setFont(new java.awt.Font("Bell MT",2,14));
				}
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 676, GroupLayout.PREFERRED_SIZE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 696, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE));
			f.pack();
			this.f.setSize(736, 601);
		} catch (Exception e) {
			//add your error handling code here
			e.printStackTrace();
		}
	}

}
