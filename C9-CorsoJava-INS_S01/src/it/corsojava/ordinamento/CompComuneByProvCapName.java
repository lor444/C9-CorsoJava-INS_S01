package it.corsojava.ordinamento;

import it.corsojava.insiemi.Comune;

import java.util.Comparator;

public class CompComuneByProvCapName implements Comparator<Comune> {

    @Override
    public int compare(Comune c0, Comune c1) {
        int esito=0;
        esito = c0.getProvincia().compareTo(c1.getProvincia());
        if(esito!=0) return  esito;
        else{
            esito=c0.getCap().compareTo(c1.getCap());
            if(esito!=0) return  esito;
            else {
                return c0.getNome().compareTo(c1.getNome());
            }
        }
    }

}