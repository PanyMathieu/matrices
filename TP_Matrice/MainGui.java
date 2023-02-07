public class MainGui extends Gui {
    
    @Override
    public void Draw() {
        System.out.println(
            "Menu Principal:\n\n" +
            "1) Gestion de matrices\n" +
            "2) Opérations arithmétiques\n" +
            "3) Resolution de matrices\n" +
            "\n" +
            "4) Quitter\n" +
            "\n"
        );
    }

    @Override
    public Gui GetNextMenu() {
        return UserSelectedGui(new ManagementGui(), new ArithmeticsGui(), new SolverGui(), null);
    }
}