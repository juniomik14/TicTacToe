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