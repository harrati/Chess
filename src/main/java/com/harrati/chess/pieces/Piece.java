package com.harrati.chess.pieces;

import com.harrati.chess.Init;

import java.net.URL;

public abstract class Piece {

  public static final int BLACK = 0;
  public static final int WHITE = 1;

  int color;
  int [] coords = new int[2];
  String type;
  URL src;
  int depl=0;
  int index;
  int state=1;
  int onEchec=0;


  void changeRole(){
    if(Init.f.role==WHITE)
      Init.f.role=BLACK;
    else
      Init.f.role=WHITE;
  }
}
