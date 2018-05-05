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

    public boolean checkFinish(Player player) {
        boolean finish = false;
        ArrayList<Integer> cellIdList = new ArrayList<>();

        if (player.getCellsQty() >= 3) {
            for (Cell cell : player.getCellsSelected()) {
                cellIdList.add(cell.getId());
            }
            if ((cellIdList.contains(1) && cellIdList.contains(2) && cellIdList.contains(3)) || (cellIdList.contains(4) && cellIdList.contains(5) && cellIdList.contains(6)) || (cellIdList.contains(7) && cellIdList.contains(8) && cellIdList.contains(9))) {
                finish = true;
                player.addVictory();
                System.out.println("Felicidades " + player.getName() + " has ganado!!!");
            } else if ((cellIdList.contains(1) && cellIdList.contains(4) && cellIdList.contains(7)) || (cellIdList.contains(2) && cellIdList.contains(5) && cellIdList.contains(8)) || (cellIdList.contains(3) && cellIdList.contains(6) && cellIdList.contains(9))) {
                finish = true;
                player.addVictory();
                System.out.println("Felicidades " + player.getName() + " has ganado!!");
            } else if ((cellIdList.contains(1) && cellIdList.contains(5) && cellIdList.contains(9)) || (cellIdList.contains(3) && cellIdList.contains(5) && cellIdList.contains(7))) {
                finish = true;
                player.addVictory();
                System.out.println("Felicidades " + player.getName() + " has ganado!!!");
            }

        }

        return finish;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

   
}