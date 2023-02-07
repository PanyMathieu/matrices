public class SolveComputeGui extends Gui {

    private SolveMethods method;
    private String guiTitle;
    private Systeme systeme;
    private int epsilon = 0;

    public SolveComputeGui(SolveMethods method) {
        this.method = method;
    }

    @Override
    public void Draw() {
        Init();
        
        if (Main.matrixList.size() < 2) {
            System.out.println(guiTitle + "Il faut au moins 2 matrices pour effectuer cette opération.");
            return;
        }

        GetValuesFromUser();
        DisplayResult(Solve());
    }

    private void DisplayResult(Matrice result) {
        ConsoleManagement.ClearConsole();
        System.out.println(guiTitle + "Solution:\n" + result);
    }

    private Matrice Solve() {
        Matrice resultMatrice;
        switch (method) {
            default:
            case CramerMethod:
                resultMatrice = systeme.TrouverXParCramer();
                break;
            case InvMatMethod:
                resultMatrice = systeme.TrouverXParInversionMatricielle();
                break;
            case JacobiMethod:
                resultMatrice = systeme.TrouverXParJacobi(epsilon);
                break;
        }

        return resultMatrice;
    }

    private void GetValuesFromUser() {
        int indexFirstMatrix;
        int indexSecondMatrix;
        do {
            ConsoleManagement.ClearConsole();
            System.out.println(guiTitle + "Veuillez selectioner 2 matrices: ");
            indexFirstMatrix = ConsoleManagement.GetSafeInteger();
            indexSecondMatrix = ConsoleManagement.GetSafeInteger();
        } while (!Utils.IsIntBetween(indexFirstMatrix, 1, Main.matrixList.size()) || !Utils.IsIntBetween(indexSecondMatrix, 1, Main.matrixList.size()));

        systeme = new Systeme(
            Main.matrixList.get(indexFirstMatrix - 1),
            Main.matrixList.get(indexSecondMatrix - 1)
        );

        if (method == SolveMethods.JacobiMethod) {
            do {
                ConsoleManagement.ClearConsole();
                System.out.println(guiTitle + "Veuillez entrer ne nombre d'itérations a effectuer > 0 (epsilon): ");
                epsilon = ConsoleManagement.GetSafeInteger();
            } while (epsilon <= 0);
        }
    }

    private void Init() {
        switch (method) {
            default:
            case CramerMethod:
                guiTitle = "Résolution par la méthode Cramer:\n\n";
                break;
            case InvMatMethod:
                guiTitle = "Résolution par inversion matricielle:\n\n";
                break;
            case JacobiMethod:
                guiTitle = "Résolution par la méthode de Jacobi:\n\n";
                break;
        }
    }

    @Override
    public Gui GetNextMenu() {
        ConsoleManagement.WaitForUserInput();
        return new SolverGui();
    }
    
}
