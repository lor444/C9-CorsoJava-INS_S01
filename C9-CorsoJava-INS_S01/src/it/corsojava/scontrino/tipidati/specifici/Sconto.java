package it.corsojava.scontrino.tipidati.specifici;

import it.corsojava.scontrino.tipidati.base.PercOutOfRangeException;
import it.corsojava.scontrino.tipidati.base.Percentuale;

public class Sconto extends Percentuale{

    public static  final double MIN_VALUE=0;

    public Sconto(double percentualeSconto) throws PercOutOfRangeException{
        super(percentualeSconto);
    }

    @Override
    public void setValue(double value) throws PercOutOfRangeException {
        super.setValue(value);
        if(this.getValue()<MIN_VALUE){
            throw new ScontoOutOfRangeException();
        }
    }
}

