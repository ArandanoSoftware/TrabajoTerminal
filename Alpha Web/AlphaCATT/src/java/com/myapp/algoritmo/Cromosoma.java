/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.algoritmo;

/**
 *
 * @author root
 */
public class Cromosoma {
    
    private GMDHS gen1;
    private GTT gen2;

    public Cromosoma() {
    }

    public Cromosoma(GMDHS gen1, GTT gen2) {
        this.gen1 = gen1;
        this.gen2 = gen2;
    }

    public GMDHS getGen1() {
        return gen1;
    }

    public void setGen1(GMDHS gen1) {
        this.gen1 = gen1;
    }

    public GTT getGen2() {
        return gen2;
    }

    public void setGen2(GTT gen2) {
        this.gen2 = gen2;
    }
    
    
    
}
