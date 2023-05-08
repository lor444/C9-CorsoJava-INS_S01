
import it.corsojava.scontrino.Riga;
import it.corsojava.scontrino.Scontrino;
import it.corsojava.scontrino.tipidati.specifici.Iva;
import it.corsojava.scontrino.tipidati.specifici.Sconto;
import it.corsojava.ui.TerminalUI;

public class ScontrinoAgent {

    private TerminalUI ui;

    public ScontrinoAgent(TerminalUI ui){
        this.ui=ui;
    }

    public void run(){
        ui.writeln("==========================================");
        ui.writeln("                  CASSA                   ");
        ui.writeln("==========================================");

        runMainCycle();

        ui.writeln("==========================================");
        ui.writeln("              ARRIVEDERCI                 ");
        ui.writeln("==========================================");
    }

    private void runMainCycle(){
        boolean goAhead=true;
        while(goAhead){
            ui.write("Selezionare: [1]=Nuovo scontrino, [0]=Esci");
            String answer=ui.read();
            if(answer.equals("0")){
                goAhead=false;
            }else if(answer.equals("1")){
                runNewCheck();
            }
        }
    }

    private void runNewCheck(){
        ui.writeln("------------------------------------------");
        ui.writeln("            Scontrino                     ");
        ui.writeln("------------------------------------------");
        Scontrino s =new Scontrino();
        boolean goAhead=true;
        while(goAhead) {
            ui.write("Selezionare: [1]=Aggiungi riga, [2]=Mostra parziale, [3]=Termina scontrino");
            String cmd = ui.read();
            switch(cmd){
                case "1":
                    Riga r=recuperaRiga();
                    s.addRiga(r);
                    break;
                case "2":
                    ui.writeln("PARZIALE: " + s.getTotaleComplessivo());
                    break;
                case "3":
                    goAhead=false;
                    break;
                default:
                    ui.writeln("Comando non valido '"+cmd+"'");
                    break;
            }
        }
        ui.writeln("------------------------------------------");
        ui.writeln("TOTALE: " + s.getTotaleComplessivo());
        ui.writeln("------------------------------------------");
        ui.writeln("");
    }

    public Riga recuperaRiga(){
        Riga r=new Riga();
        r.setPrezzoUnitario(ui.askDouble("Importo unitario"));
        r.setQuantita(ui.askInt("Quantita"));
        try {
            r.setSconto(new Sconto(ui.askDouble("Sconto")));
        }catch (Exception ex){

        }
        ui.write("Selezionare l'aliquota: A = 22%, B = 10%, C=4%, D=nessuna >");
        String s=ui.read();
        switch (s){
            case "A":
                r.setIva(Iva.IVA_22);
                break;
            case "B":
                r.setIva(Iva.IVA_10);
                break;
            case "C":
                r.setIva(Iva.IVA_4);
                break;
            default:
                r.setIva(Iva.IVA_0);
        }
        return r;
    }

}