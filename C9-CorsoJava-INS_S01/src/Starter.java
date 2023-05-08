import it.corsojava.ui.TerminalUI;

public class Starter {

    public static void main(String[] args) {

        TerminalUI ui = new TerminalUI();
        ScontrinoAgent agent=new ScontrinoAgent(ui);
        agent.run();

    }

}
