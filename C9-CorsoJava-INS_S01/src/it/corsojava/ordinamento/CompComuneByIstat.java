package it.corsojava.ordinamento;

import it.corsojava.insiemi.Comune;

import java.util.Comparator;

public class CompComuneByIstat implements Comparator<Comune> {

    @Override
    public int compare(Comune c0, Comune c1) {
        return c0.getIstat().compareTo(c1.getIstat());
    }

}
