package com.harrati.chess.pieces;

import com.harrati.chess.Afficher;
import com.harrati.chess.Init;

import java.net.URL;

public class Fou extends Piece{
	static URL srcn = Fou.class.getResource("/images/pieces/foun.gif");
	static URL srcb = Fou.class.getResource("/images/pieces/foub.gif");
	public static boolean deplacer(PieceOld element, int[] src, int [] dst){
		if(testDepl(element, src, dst)==0 && 
				(PieceOld.notEchec(element, src, dst) ||
						PieceOld.testEchec(element))){
			if(element.Couleur == Init.f.role){
				element.coords=dst;
				if(Afficher.Grille[dst[0]][dst[1]]!=0 ){
					Afficher.element[Afficher.Grille[dst[0]][dst[1]]-1].etat=0;
				}
				Afficher.Grille[dst[0]][dst[1]]=Afficher.Grille[src[0]][src[1]];
				Afficher.Grille[src[0]][src[1]]=0;
				PieceOld.isEchec(element,dst);
				/*if(Piece.isEchec(element,dst, Afficher.element)==true){
					if(Piece.isEchecEmate(element) == true){
						String Winner = "";
						String Lost = "";
						if(element.Couleur == Piece.BLANC){
							Winner = "Blanc";
							Lost = "Noir";
						}
						if(element.Couleur == Piece.NOIR){
							Winner = "Noir";
							Lost = "Blanc";
						}
						Helper.alert(Init.f, "Echec Emate \nLe joueur "+
								Winner+" a gagn�\n\nLe joueur "+
								Lost+" a perdu\n"
								);
						Helper.reset();
					}
				}*/
				return true;
			}
		}
		return false;
	}
	static URL setSrc(int couleur){
		if(couleur== PieceOld.NOIR)
			return srcn;
		if(couleur== PieceOld.BLANC)
			return srcb;
		return null;
	}
	public static int testDepl(PieceOld element, int[] src, int [] dst){
		if(Afficher.Grille[dst[0]][dst[1]]!=0 && Afficher.element[Afficher.Grille[dst[0]][dst[1]]-1].Couleur==element.Couleur)
			return -1;
		if((src[0]-src[1]!=dst[0]-dst[1]) && (src[0]+src[1]!=dst[0]+dst[1]))
			return -2;
		if((src[0]<dst[0]) && (src[1]<dst[1])){
			for(int i=src[0]+1, j=src[1]+1;i<dst[0] && j<dst[1];i++,j++){
				if(Afficher.Grille[i][j]!=0)
					return -3;
			}
		}
		if((src[0]>dst[0]) && (src[1]>dst[1])){
			for(int i=src[0]-1, j=src[1]-1;i>dst[0] && j>dst[1];i--,j--){
				if(Afficher.Grille[i][j]!=0)
					return -3;
			}
		}
		if((src[0]>dst[0]) && (src[1]<dst[1])){
			for(int i=src[0]-1, j=src[1]+1;i>dst[0] && j<dst[1];i--,j++){
				if(Afficher.Grille[i][j]!=0)
					return -3;
			}
		}
		if((src[0]<dst[0]) && (src[1]>dst[1])){
			for(int i=src[0]+1, j=src[1]-1;i<dst[0] && j>dst[1];i++,j--){
				if(Afficher.Grille[i][j]!=0)
					return -3;
			}
		}
		
		return 0;
	}
	
}
