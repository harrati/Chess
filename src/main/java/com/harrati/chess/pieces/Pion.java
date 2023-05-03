package com.harrati.chess.pieces;

import com.harrati.chess.Init;
import com.harrati.chess.Afficher;

import java.net.URL;

public class Pion{
	static URL srcb = Pion.class.getResource("/images/pieces/pionb.gif");
	static URL srcn = Pion.class.getResource("/images/pieces/pionn.gif");
	public static boolean deplacer(PieceOld element, int src[], int [] dst){
		int depl = element.depl;
		if(testDepl(element, src, dst)==0 && 
				(PieceOld.notEchec(element, src, dst) ||
						PieceOld.testEchec(element))){
			if(element.Couleur == Init.f.role){
				element.coords=dst;
				if(Afficher.Grille[dst[0]][dst[1]]!=0 ){
					Afficher.element[Afficher.Grille[dst[0]][dst[1]]-1].etat=0;
				}
				Afficher.Grille[dst[0]][dst[1]] = Afficher.Grille[src[0]][src[1]];
				Afficher.Grille[src[0]][src[1]] = 0;
				PieceOld.isEchec(element,dst);
				
				return true;
			}
			else
				element.depl = depl;
		}
		else
			element.depl = depl;
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
		if(Afficher.Grille[dst[0]][dst[1]]!=0 && Afficher.element[Afficher.Grille[dst[0]][dst[1]]-1].Couleur==element.Couleur)
			return -1;
		int dx=src[0]-dst[0];
		int dy=src[1]-dst[1];
		if(element.Couleur== PieceOld.BLANC){
			if(element.depl==0){
				if(((dy==1) || (dy==2)) && (dx==0)){
					if((Afficher.Grille[dst[0]][dst[1]]==0) && (Afficher.Grille[dst[0]][src[1]-1]==0)){
						element.depl=1;
						if(dst[1]==0){
							element.type="Reine";
							element.setSrc();
						}
						return 0;
					}
					else
						return -2;
				}//
				else{
					if((dx==1 || dx==-1) && (dy==1)){
						if(Afficher.Grille[dst[0]][dst[1]]!=0){
							element.depl=1;
							if(dst[1]==0){
								element.type="Reine";
								element.setSrc();
							}
							return 0;
						}
						else
							return -2;
					}
					else
							return -2;
				}
			}//
			else{
				if((dy==1) && (dx==0)){
					if(Afficher.Grille[dst[0]][dst[1]]==0){
						element.depl=1;
						if(dst[1]==0){
							element.type="Reine";
							element.setSrc();
						}
						return 0;
					}
					else
						return -2;
				}
				else{
					if((dx==1 || dx==-1) && (dy==1)){
						if(Afficher.Grille[dst[0]][dst[1]]!=0){
							element.depl=1;
							if(dst[1]==0){
								element.type="Reine";
								element.setSrc();
							}
							return 0;
						}
						else
							return -2;
					}
					else
							return -2;
				}
			}
		}//
		if(element.Couleur== PieceOld.NOIR){
			if(element.depl==0){
				if(((dy==-1) || (dy==-2)) && (dx==0) && (Afficher.Grille[dst[0]][src[1]+1]==0)){
					if(Afficher.Grille[dst[0]][dst[1]]==0){
						element.depl=1;
						if(dst[1]==7){
							element.type="Reine";
							element.setSrc();
						}
						return 0;
					}
					else
						return -2;
				}
				else{
					if((dx==1 || dx==-1) && (dy==-1)){
						if(Afficher.Grille[dst[0]][dst[1]]!=0){
							element.depl=1;
							if(dst[1]==7){
								element.type="Reine";
								element.setSrc();
							}
							return 0;
						}
						else
							return -2;
					}
					else
							return -2;
				}
			}
			else{
				if((dy==-1) && (dx==0)){
					if(Afficher.Grille[dst[0]][dst[1]]==0){
						element.depl=1;
						if(dst[1]==7){
							element.type="Reine";
							element.setSrc();
						}
						return 0;
					}
					else
						return -2;
				}
				else{
					if((dx==1 || dx==-1) && (dy==-1)){
						if(Afficher.Grille[dst[0]][dst[1]]!=0){
							element.depl=1;
							if(dst[1]==7){
								element.type="Reine";
								element.setSrc();
							}
							return 0;
						}
						else
							return -2;
					}
					else
							return -2;
				}
			}
		}
		return 0;
	}
	
}