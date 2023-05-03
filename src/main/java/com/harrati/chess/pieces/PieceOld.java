package com.harrati.chess.pieces;


import com.harrati.chess.Init;
import com.harrati.chess.Afficher;

import java.net.URL;
import java.util.Objects;

public class PieceOld {
	
	public final static int NOIR=0;
	public final static int BLANC=1;
	int Couleur;
	public int [] coords=new int[2];
	String type;
	public URL src;
	int depl=0;
	int index;
	public int etat=1;
	int enEchec=0;
	public PieceOld(int couleur, String type, int X, int Y, int indice){
		Couleur=couleur;
		this.type=type;
		this.coords[0]=X;
		this.coords[1]=Y;
		Afficher.Grille[X][Y]=indice+1;
		this.index=indice;
		setSrc();
	}
	
	public void setSrc(){
		if(Objects.equals(type, "Tour")){
			if(this.Couleur==NOIR){
				src= Tour.setSrc(NOIR);
			}
			if(this.Couleur==BLANC){
				src= Tour.setSrc(BLANC);
			}
		}
		if(Objects.equals(type, "Fou")){
			if(this.Couleur==NOIR){
				src= Fou.setSrc(NOIR);
			}
			if(this.Couleur==BLANC){
				src=Fou.setSrc(BLANC);
			}
		}
		if(Objects.equals(type, "Cheval")){
			if(this.Couleur==NOIR){
				src= Cheval.setSrc(NOIR);
			}
			if(this.Couleur==BLANC){
				src=Cheval.setSrc(BLANC);
			}
		}
		if(Objects.equals(type, "Roi")){
			if(this.Couleur==NOIR){
				src= Roi.setSrc(NOIR);
			}
			if(this.Couleur==BLANC){
				src= Roi.setSrc(BLANC);
			}
		}
		if(Objects.equals(type, "Reine")){
			if(this.Couleur==NOIR){
				src= Reine.setSrc(NOIR);
			}
			if(this.Couleur==BLANC){
				src= Reine.setSrc(BLANC);
			}
		}
		if(Objects.equals(type, "Pion")){
			if(this.Couleur==NOIR){
				src= Pion.setSrc(NOIR);
			}
			if(this.Couleur==BLANC){
				src= Pion.setSrc(BLANC);
			}
		}
		
	}
	
	public int testDeplacer(int [] src,int [] dst){
		if(Objects.equals(type, "Tour")){
			return Tour.testDepl(this, src,dst);
		}
		if(Objects.equals(type, "Fou")){
			return Fou.testDepl(this, src,dst);
		}
		if(Objects.equals(type, "Cheval")){
			return Cheval.testDepl(this, src,dst);
		}
		if(Objects.equals(type, "Roi")){
			return Roi.testDepl(this, src,dst);
		}
		if(Objects.equals(type, "Reine")){
			return Reine.testDepl(this, src,dst);
		}
		if(Objects.equals(type, "Pion")){
			return Pion.testDepl(this, src,dst);
		}
		return 0;
	}
	
	public boolean deplacer(int [] src,int [] dst){
		if(Objects.equals(type, "Tour")){
			if(Tour.deplacer(this, src,dst)){
				changeRole();
				return true;
			}
		}
		if(Objects.equals(type, "Fou")){
			if(Fou.deplacer(this, src,dst)){
				changeRole();
				return true;
			}
		}
		if(Objects.equals(type, "Cheval")){
			if(Cheval.deplacer(this, src,dst)){
				changeRole();
				return true;
			}
		}
		if(Objects.equals(type, "Roi")){
			if(Roi.deplacer(this, src,dst)){
				changeRole();
				return true;
			}
		}
		if(Objects.equals(type, "Reine")){
			if(Reine.deplacer(this, src,dst)){
				changeRole();
				return true;
			}
		}
		if(Objects.equals(type, "Pion")){
			if(Pion.deplacer(this, src,dst)){
				changeRole();
				return true;
			}
		}
		return false;
	}
	
	void changeRole(){
		if(Init.f.role==BLANC)
			Init.f.role=NOIR;
		else
			Init.f.role=BLANC;
	}
	
	static boolean testEchec(PieceOld element){
		if(element.Couleur== PieceOld.BLANC){
			return Afficher.element[28].enEchec != 1;
		}
		else if(element.Couleur== PieceOld.NOIR){
			return Afficher.element[4].enEchec != 1;
		}
		return true;
	}

	
	static boolean isEchec(PieceOld element, int[] src){
		String type = element.type;
		if(element.Couleur == PieceOld.BLANC){
			if(element.testDeplacer(src, Afficher.element[4].coords) == 0){
				Afficher.element[4].enEchec = 1;
				Init.f.lbl.setText("Echec au Roi NOIR!");
				element.type = type;
				element.setSrc();
				return true;
			}
		}
		else if(element.Couleur== PieceOld.NOIR){
			if(element.testDeplacer(src, Afficher.element[28].coords)==0){
				Afficher.element[28].enEchec = 1;
				Init.f.lbl.setText("Echec au Roi BLANC!");
				element.type = type;
				element.setSrc();
				return true;
			}
		}
		return false;
	}
	
	static boolean notEchec(PieceOld element, int[] src, int [] dst){
		if(element.Couleur== PieceOld.BLANC){
			int test=0;
			element.coords=dst;
			int etat=1;
			String type = "";
			if(Afficher.Grille[dst[0]][dst[1]]!=0 ){
				etat=Afficher.element[Afficher.Grille[dst[0]][dst[1]]-1].etat;
				Afficher.element[Afficher.Grille[dst[0]][dst[1]]-1].etat=0;
			}
			int grillesrc=Afficher.Grille[src[0]][src[1]];
			int grilledst=Afficher.Grille[dst[0]][dst[1]];
			Afficher.Grille[dst[0]][dst[1]]=Afficher.Grille[src[0]][src[1]];
			Afficher.Grille[src[0]][src[1]]=0;
			
			for(int i=0;i<=15;i++){
				type = Afficher.element[i].type;
				if(Afficher.element[i].testDeplacer(Afficher.element[i].coords, Afficher.element[28].coords)==0 && Afficher.element[i].etat==1){
					element.coords=src;
					Afficher.element[Afficher.Grille[dst[0]][dst[1]]-1].etat=etat;
					Afficher.element[i].type = type;
					Afficher.element[i].setSrc();
					Afficher.Grille[src[0]][src[1]]=grillesrc;
					Afficher.Grille[dst[0]][dst[1]]=grilledst;
					Afficher.element[28].enEchec=1;
					Init.f.lbl.setText("Echec au Roi BLANC!");
					test=1;
					return false;
				}
			}
			if(test==0){
				element.coords=src;
				Afficher.element[Afficher.Grille[dst[0]][dst[1]]-1].etat=etat;
				Afficher.element[Afficher.Grille[dst[0]][dst[1]]-1].setSrc();
				Afficher.Grille[src[0]][src[1]]=grillesrc;
				Afficher.Grille[dst[0]][dst[1]]=grilledst;
				Afficher.element[28].enEchec=0;
			}
			else{
				element.coords=src;
				Afficher.element[Afficher.Grille[dst[0]][dst[1]]-1].etat=etat;
				Afficher.element[Afficher.Grille[dst[0]][dst[1]]-1].setSrc();
				Afficher.Grille[src[0]][src[1]]=grillesrc;
				Afficher.Grille[dst[0]][dst[1]]=grilledst;
				return false;
			}
			return true;
		}
		if(element.Couleur== PieceOld.NOIR){
			int test=0;
			String type = "";
			element.coords=dst;
			int etat=1;
			if(Afficher.Grille[dst[0]][dst[1]] != 0 ){
				etat=Afficher.element[Afficher.Grille[dst[0]][dst[1]]-1].etat;
				Afficher.element[Afficher.Grille[dst[0]][dst[1]]-1].etat=0;
			}
			int grillesrc=Afficher.Grille[src[0]][src[1]];
			int grilledst=Afficher.Grille[dst[0]][dst[1]];
			Afficher.Grille[dst[0]][dst[1]]=Afficher.Grille[src[0]][src[1]];
			Afficher.Grille[src[0]][src[1]]=0;
			
			for(int i = 16; i <= 31;i++){
				type = Afficher.element[i].type;
				if(Afficher.element[i].testDeplacer(Afficher.element[i].coords, Afficher.element[4].coords)==0 && Afficher.element[i].etat==1){
					element.coords = src;
					Afficher.element[Afficher.Grille[dst[0]][dst[1]]-1].etat=etat;
					Afficher.element[i].type = type;
					Afficher.element[i].setSrc();
					Afficher.Grille[src[0]][src[1]]=grillesrc;
					Afficher.Grille[dst[0]][dst[1]]=grilledst;
					Afficher.element[4].enEchec=1;
					Init.f.lbl.setText("Echec au Roi NOIR!");
					test=1;
					return false;
				}
			}
			if(test==0){
				element.coords=src;
				Afficher.element[Afficher.Grille[dst[0]][dst[1]]-1].etat=etat;
				Afficher.element[Afficher.Grille[dst[0]][dst[1]]-1].setSrc();
				Afficher.Grille[src[0]][src[1]] = grillesrc;
				Afficher.Grille[dst[0]][dst[1]] = grilledst;
				Afficher.element[4].enEchec = 0;
			}
			else{
				element.coords=src;
				Afficher.element[Afficher.Grille[dst[0]][dst[1]]-1].etat=etat;
				Afficher.element[Afficher.Grille[dst[0]][dst[1]]-1].setSrc();
				Afficher.Grille[src[0]][src[1]]=grillesrc;
				Afficher.Grille[dst[0]][dst[1]]=grilledst;
				return false;
			}
			return true;
		}
		return true;
	}
	
	static boolean isEchecEmate(PieceOld element, PieceOld[] elem, int[][] Grille){
		int []dst = new int[2];
		int test, src1, src2, src3;
		int[] coords1;
		int[] coords2 = new int[2];
		int etat1, etat2 = 0 ,etat3, depl1,depl2 = 0;
		if(element.Couleur == PieceOld.BLANC){
			for(int i=0;i<16;i++){
				coords1 = elem[i].coords;
				etat1 = elem[i].etat;
				depl1 = elem[i].depl;
				src2 = Grille[coords1[0]][coords1[1]];
				for(int j=0;j<8;j++){
					for(int k=0; k<8;k++){
						test = 0;
						src1 = Grille[j][k];
						if(Grille[j][k] != 0){
							coords2 = elem[Grille[j][k]-1].coords;
							etat2 = elem[Grille[j][k]-1].etat;
							depl2 = elem[Grille[j][k]-1].depl;
							dst = coords2;
							test = 1;
						}
						else{
							dst[0] = j;
							dst[1] = k;
						}
						if((elem[i].etat ==1) && elem[i].testDeplacer(coords1, dst) == 0){
							elem[i].coords = dst;
							etat3 = elem[Grille[dst[0]][dst[1]]].etat;
							elem[Grille[dst[0]][dst[1]]].etat = 0;
							src3 = Grille[coords1[0]][coords1[1]];
							Grille[coords1[0]][coords1[1]] = 0;
							if(PieceOld.notEchec(elem[i], coords1, dst)){
								return false;
							}
							elem[Grille[dst[0]][dst[1]]].etat = etat3;
							Grille[coords1[0]][coords1[1]] = src3;
							
						}
						if(test == 1){
							elem[Grille[j][k]-1].coords = coords2;
							elem[Grille[j][k]-1].etat = etat2;
							elem[Grille[j][k]-1].depl = depl2;
						}
						elem[i].coords = coords1;
						elem[i].etat = etat1;
						elem[i].depl = depl1;
						Grille[coords1[0]][coords1[1]] = src2;
						Grille[j][k] = src1;
					}	
				}
			}
			return true;
		}
		else if(element.Couleur == PieceOld.NOIR){
			for(int i=16;i<32;i++){
				coords1 = elem[i].coords;
				etat1 = elem[i].etat;
				depl1 = elem[i].depl;
				src2 = Grille[coords1[0]][coords1[1]];
				for(int j=0;j<8;j++){
					for(int k=0; k<8;k++){
						test = 0;
						src1 = Grille[j][k];
						if(Grille[j][k] != 0){
							coords2 = elem[Grille[j][k]-1].coords;
							etat2 = elem[Grille[j][k]-1].etat;
							depl2 = elem[Grille[j][k]-1].depl;
							dst = coords2;
							test = 1;
						}
						else{
							dst[0] = j;
							dst[1] = k;
						}
						if((elem[i].etat ==1) && elem[i].testDeplacer(coords1, dst) == 0){
							elem[i].coords = dst;
							etat3 = elem[Grille[dst[0]][dst[1]]].etat;
							elem[Grille[dst[0]][dst[1]]].etat = 0;
							src3 = Grille[coords1[0]][coords1[1]];
							Grille[coords1[0]][coords1[1]] = 0;
							if(PieceOld.notEchec(elem[i], coords1, dst)){
								Init.f.add(Init.f.pan);
								Init.f.repaint();
								Init.f.setVisible(true);
								return false;
							}
							elem[Grille[dst[0]][dst[1]]].etat = etat3;
							Grille[coords1[0]][coords1[1]] = src3;
							
						}
						if(test == 1){
							elem[Grille[j][k]-1].coords = coords2;
							elem[Grille[j][k]-1].etat = etat2;
							elem[Grille[j][k]-1].depl = depl2;
						}
						elem[i].coords = coords1;
						elem[i].etat = etat1;
						elem[i].depl = depl1;
						Grille[coords1[0]][coords1[1]] = src2;
						Grille[j][k] = src1;
					}	
				}
			}
			return true;
		}
		return false;
	}
}
