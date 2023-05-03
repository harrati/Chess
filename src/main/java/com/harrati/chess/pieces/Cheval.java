package com.harrati.chess.pieces;

import com.harrati.chess.Afficher;
import com.harrati.chess.Init;

import java.net.URL;

public class Cheval{
	static URL srcb = Cheval.class.getResource("/images/pieces/cavalierb.gif");
	static URL srcn = Cheval.class.getResource("/images/pieces/cavaliern.gif");
	public static boolean deplacer(PieceOld element, int src[], int [] dst){
		if(testDepl(element, src, dst)==0 && 
				(PieceOld.notEchec(element, src, dst) ||
						PieceOld.testEchec(element))){
			if(element.Couleur == Init.f.role){
				element.coords=dst;
				if(Afficher.Grille[dst[0]][dst[1]]!=0 ){
					Afficher.element[Afficher.Grille[dst[0]][dst[1]]-1].etat = 0;
				}
				Afficher.Grille[dst[0]][dst[1]]=Afficher.Grille[src[0]][src[1]];
				Afficher.Grille[src[0]][src[1]]=0;
				PieceOld.isEchec(element,dst);
				
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
	public static int testDepl(PieceOld element, int src[], int [] dst){
		if(Afficher.Grille[dst[0]][dst[1]] != 0 && Afficher.element[Afficher.Grille[dst[0]][dst[1]]-1].Couleur==element.Couleur)
			return -1;
		int dx=dst[0]-src[0];
		int dy=dst[1]-src[1];
		if(Math.hypot(dx, dy)!=Math.sqrt(5))
			return -2;
		return 0;
	}
}
