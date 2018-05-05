/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3enraya;

import java.util.ArrayList;
import java.util.Scanner;





/**
 *
 * @author usuario
 */
public class Game {
    private Cell[][] cells;
    private ArrayList<Player> players;

    public Game() {
        this.cells = createBoard();
        this.players = insertPlayers();
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Cell[][] createBoard() {
        int id = 1;
        Cell[][] cells = new Cell[3][3];

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(false, id);
                id++;
            }
        }

        return cells;
    }

    public void showBoard() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(cells[i][j].getForm() + " ");
            }

            System.out.println(" ");
        }
    }

    public ArrayList<Player> insertPlayers() {
        Scanner sc = new Scanner(System.in);
        Player player1;
        Player player2;
        String auxName;
        ArrayList<Player> players = new ArrayList<>();

        System.out.print("Nombre del primer jugador: ");
        auxName = sc.nextLine();
        player1 = new Player(auxName, "O");

        System.out.print("Nombre del segundo jugador: ");
        auxName = sc.nextLine();
        player2 = new Player(auxName, "X");

        players.add(player1);
        players.add(player2);

        return players;
    }

    
}