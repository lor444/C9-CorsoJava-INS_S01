package it.corsojava.ordinamento;

import it.corsojava.insiemi.Comune;

import java.util.ArrayList;
import java.util.List;

public class Archivio {

    private List<Comune> comuni=new ArrayList<>();

    public List<Comune> getComuni() {
        return comuni;
    }

    public void load(String source){
        if(source!=null) {
            String[] lines = source.split("\n");
            for (String line : lines) {
                Comune c=loadComuneByString(line);
                importComune(c);
            }
        }
    }

    private void importComune(Comune c){
        comuni.add(c);
    }

    private Comune loadComuneByString(String line){
        if(line!=null){
            String[] fields = line.split("\t");
            if (fields.length == 5) {
                Comune c = new Comune();
                c.setCodice(fields[0]);
                c.setCap(fields[1]);
                c.setNome(fields[2]);
                c.setProvincia(fields[3]);
                c.setIstat(fields[4]);
                return c;
            } else {
                throw new IllegalArgumentException("Invalid line: " + line);
            }
        }else {
            throw new IllegalArgumentException("Null line");
        }
    }
}
