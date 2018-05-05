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

    public void startGame() {
        Scanner sc = new Scanner(System.in);
        String restart = "";
        this.cells = createBoard();
        int counter = 0;
        boolean finish = false;

        for (Player player: players) {
            player.getCellsSelected().clear();
        }

        while (!finish) {
            for (Player current : this.getPlayers()) {
                System.out.println("Turno para " + current.getName());
                current.makePlay(this);
                if (this.checkFinish(current)) {
                    finish = true;
                    System.out.println("Quieres jugar otra vez? (s/n)");
                    restart = sc.nextLine();
                    break;
                }
                counter++;
                if (counter == 9) {
                    finish = true;
                    System.out.println("Empate");
                    System.out.println("Quieres jugar otra vez?(s/n)");
                    restart = sc.nextLine();
                    break;
                }
            }
        }

        if (restart.equalsIgnoreCase("s")) startGame();
        else {
            Player player1 = players.get(0);
            Player player2 = players.get(1);

            System.out.println(player1.getName()+" Tiene "+player1.getVictories()+" victorias\n"+player2.getName()+" Te "+player2.getVictories() + " victorias");

        }
    }
}