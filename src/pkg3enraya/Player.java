/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3enraya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author usuario
 */
public class Player {
    private String name;
    private String selection;
    private ArrayList<Cell> cellsSelected;
    private int victories;

    public Player(String name, String selection) {
        this.name = name;
        this.selection = selection;
        this.victories = 0;
        this.cellsSelected = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Cell> getCellsSelected() {
        return cellsSelected;
    }

    public String getSelection() {
        return selection;
    }
    
    public void makePlay(Game game) {
        Scanner sc = new Scanner(System.in);

        Cell[][] cells = game.getCells();
        Integer posX = 0;
        int posY = 0;
        
        boolean posOcupadas=false;
        while(posOcupadas==false){
  
        try{
             System.out.println("Inserta posicion vretical (" + this.name + ')');
             posX=getPosicion();
            
             System.out.println("Inserta posicion horizontal (" + this.name + ')');
            posY=getPosicion();
        }catch(IllegalArgumentException e){
            
        }
       
        if (cells[posY][posX].isInUse()) {
            System.out.println("Esta ocupada");
            
        } else {
            posOcupadas=true;
            cells[posY][posX].setInUse(this.getSelection());
            cellsSelected.add(cells[posY][posX]);
            game.showBoard();
        }
        }
        
    }

    public int getCellsQty() {
        return cellsSelected.size();
    }

    public void addVictory() {
        this.victories++;
    }

    public int getVictories() {
        return victories;
    }
    private int getPosicion(){
        int posX;
          Scanner sc = new Scanner(System.in);
          
       
        
        try{
        posX = sc.nextInt();
        
        }catch(Exception e){
            throw new IllegalArgumentException(e);
        }
        if(posX<0||posX>2){
            System.out.println("Posicion entre 0 y 2");
            throw new IllegalArgumentException();
            
        }
        return posX;
    }
}