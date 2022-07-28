package org.example;

import java.util.ArrayList;

public class Pyme {

    private ArrayList<Integer> ventas;


    public Pyme(ArrayList<Integer> ventas) {
        this.ventas = ventas;
    }

    public ArrayList<Integer> getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList<Integer> ventas) {
        this.ventas = ventas;
    }
}
