package it.corsojava.insiemi;

import java.util.*;

public class Comuni {

    Map<String,Comune> comuniMap;
    Map<String,Comune> comuniByIstat;
    Map<String, List<Comune>> comuniByProvince = new HashMap<String, List<Comune>>();

    public Comuni(){
        comuniMap = new HashMap<String,Comune>();
        comuniByIstat = new HashMap<String,Comune>();
        comuniByProvince=new HashMap<String,List<Comune>>();
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
        comuniMap.put(c.getCodice(),c);
        comuniByIstat.put(c.getIstat(),c);
        if(comuniByProvince.containsKey(c.getProvincia())){
            comuniByProvince.get(c.getProvincia()).add(c);
        }else{
            List<Comune> comuniDellaProvincia=new ArrayList<Comune>();
            comuniDellaProvincia.add(c);
            comuniByProvince.put(c.getProvincia(),comuniDellaProvincia);
        }

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

    public Comune getComuneByCodice(String codice){
        return comuniMap.get(codice);
    }
    public Comune getComuneByIstat(String codIstat){
        return  comuniByIstat.get(codIstat);
    }

    public List<Comune> findComuniByNome(String nome){
        List<Comune> elenco=new ArrayList<Comune>();

        for(Comune c : comuniMap.values()) {
            if(c.getNome().toLowerCase().contains(nome.toLowerCase())){
                elenco.add(c);
            }
        }

        return elenco;
    }

    public List<Comune> getComuniByProvincia(String sigla){
        if(comuniByProvince.get(sigla)!=null)
            return comuniByProvince.get(sigla);
        else return  new ArrayList<Comune>();
    }

    public Set<String> getProvince(){
        return comuniByProvince.keySet();
    }
    public Collection<Comune> getAll(){
        return comuniMap.values();
    }
}
