public class SolverGui extends Gui {

    @Override
    public void Draw() {
        System.out.println(
            "Resolution de matrices:\n\n" +
            "1) Résolution par la méthode Cramer\n" +
            "2) Résolution par inversion matricielle\n" +
            "3) Résolution par la méthode de Jacobi\n" +
            "\n" +
            "4) Retour au Menu principal\n" +
            "\n"
        );
    }

    @Override
    public Gui GetNextMenu() {
        return UserSelectedGui(
            new SolveComputeGui(SolveMethods.CramerMethod),
            new SolveComputeGui(SolveMethods.InvMatMethod),
            new SolveComputeGui(SolveMethods.JacobiMethod),
            new MainGui()
        );
    }
    
}
