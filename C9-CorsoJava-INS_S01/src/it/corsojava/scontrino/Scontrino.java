package it.corsojava.scontrino;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Scontrino {

    private String intestazione;
    private String pieDiPagina;
    private LocalDateTime dataOra;
    List<Riga> righe;

    public Scontrino(){
        intestazione="";
        pieDiPagina="";
        dataOra=LocalDateTime.now();
        righe = new ArrayList<Riga>();
    }

    public void addRiga(Riga r){
        righe.add(r);
    }

    public double getTotaleComplessivo(){
        double temp=0;
        for(Riga r : righe){
            temp += r.getPrezzoTotale();
        }
        return temp;
    }

    public String getIntestazione() {
        return intestazione;
    }

    public void setIntestazione(String intestazione) {
        this.intestazione = intestazione;
    }

    public String getPieDiPagina() {
        return pieDiPagina;
    }

    public void setPieDiPagina(String pieDiPagina) {
        this.pieDiPagina = pieDiPagina;
    }

    public LocalDateTime getDataOra() {
        return dataOra;
    }

    public void setDataOra(LocalDateTime dataOra) {
        this.dataOra = dataOra;
    }

    public List getRighe() {
        return righe;
    }

    public void setRighe(List righe) {
        this.righe = righe;
    }
}
