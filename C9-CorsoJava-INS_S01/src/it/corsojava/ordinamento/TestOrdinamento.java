package it.corsojava.ordinamento;

import it.corsojava.insiemi.Comune;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class TestOrdinamento {

    public static void main(String[] args) {
        Archivio a =new Archivio();
        a.load(it.corsojava.datasources.StringDataSources.getComuni());
        List<Comune> elenco = a.getComuni();
        // ---------------------------------

        Comparator<Comune> criterioNome = new CompComuneByProvCapName();

        elenco.sort(criterioNome);

        printOutList(elenco);
    }

    public static void printOutList(List<?> elenco){
        for(Object element : elenco){
            System.out.println(element);
        }
    }

}
