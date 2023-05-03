package com.harrati.chess.pieces;

import com.harrati.chess.Init;
import com.harrati.chess.Afficher;

import java.net.URL;

public class Tour{
	static URL srcb = Tour.class.getResource("/images/pieces/tourb.gif");
	static URL srcn = Tour.class.getResource("/images/pieces/tourn.gif");
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
		if((src[0]!=dst[0]) && (src[1]!=dst[1]))
			return -2;
		int dx=dst[0]-src[0];
		int dy=dst[1]-src[1];
		if(dx<0){
			for(int i=dst[0]+1;i<src[0];i++){
				if(Afficher.Grille[i][src[1]]!=0)
					return -3;
			}
		}
		if(dx>0){
			for(int i=src[0]+1;i<dst[0];i++){
				if(Afficher.Grille[i][src[1]]!=0)
					return -3;
			}
		}
		if(dy<0){
			for(int i=dst[1]+1;i<src[1];i++){
				if(Afficher.Grille[src[0]][i]!=0)
					return -3;
			}
		}
		if(dy>0){
			for(int i=src[1]+1;i<dst[1];i++){
				if(Afficher.Grille[src[0]][i]!=0)
					return -3;
			}
		}
		return 0;
	}
	
}
