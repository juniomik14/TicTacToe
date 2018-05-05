/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3enraya;

/**
 *
 * @author usuario
 */
public class Cell {
    private boolean inUse;
    private String form;
    private int id;

    public Cell(boolean inUse, int id) {
        this.inUse = inUse;
        this.form = "*";
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(String form) {
        this.inUse = true;
        this.form = form;
    }

    public String getForm() {
        return form;
    }
}