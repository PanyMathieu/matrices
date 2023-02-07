public class ComputeGui extends Gui {

    private MatrixOperations operator;
    private String guiTitle;
    private int minMatrices;
    private Matrice[] matricesToCompute;
    private double[] scalars;
    private int nbOfMatrices, nbOfScalar;

    public ComputeGui(MatrixOperations operator) {
        this.operator = operator;
    }

    @Override
    public void Draw() {
        Init();

        if (Main.matrixList.size() < minMatrices) {
            System.out.printf(guiTitle + "Il faut au moins %d matrices pour effectuer cette opération.\n", minMatrices);
            return;
        }

        GetValuesFromUser();

        DisplayResult(Compute());
    }

    private void DisplayResult(Matrice result) {
        ConsoleManagement.ClearConsole();
        System.out.println(guiTitle + "Resultat:\n" + result);
    }

    private void GetValuesFromUser() {
        do {
            ConsoleManagement.ClearConsole();
            System.out.printf(guiTitle + "Sur combien de termes effectuer l'opération (%d -> %d): ", 2, Main.matrixList.size());
            nbOfMatrices = ConsoleManagement.GetSafeInteger();
        } while (!Utils.IsIntBetween(nbOfMatrices, 2, Main.matrixList.size()));

        int[] matricesIndexes = new int[nbOfMatrices];
        
        if (operator == MatrixOperations.MatrixByScalarProduct)  {
            nbOfScalar = nbOfMatrices - 1;
            nbOfMatrices = 1;
            scalars = new double[nbOfScalar];
            for (int i = 0; i < nbOfScalar; i++) {
                ConsoleManagement.ClearConsole();
                System.out.print(guiTitle + "Veuillez entrer un scalaire: ");
                scalars[i] = ConsoleManagement.GetSafeDouble();
            }
        }

        matricesToCompute = new Matrice[nbOfMatrices];
        for (int i = 0; i < nbOfMatrices; i++) {
            do {
                ConsoleManagement.ClearConsole();
                System.out.printf(guiTitle + "Veuillez selectioner la matrice %d/%d: ", i, nbOfMatrices);
                matricesIndexes[i] = ConsoleManagement.GetSafeInteger();
            } while (!Utils.IsIntBetween(matricesIndexes[i], 1, Main.matrixList.size()));
            matricesToCompute[i] = Main.matrixList.get(matricesIndexes[i] - 1);
        }
    }

    private void Init() {
        switch (operator) {
            default:
            case MatrixAddition:
                guiTitle = "Addition (Matrice + Matrice):\n\n";
                minMatrices = 2;
                break;
            case MatrixByMatrixProduct:
                guiTitle = "Produit (Matrice * Matrice):\n\n";
                minMatrices = 2;
                break;
            case MatrixByScalarProduct:
                guiTitle = "Produit (Scalaire * Matrice):\n\n";
                minMatrices = 1;
                break;
        }
    }

    private Matrice Compute() {
        Matrice resultMatrice;
        resultMatrice = matricesToCompute[0];
        switch (operator) {
            default:
            case MatrixAddition:
                for (int i = 1; i < nbOfMatrices; i++)
                    resultMatrice = resultMatrice.Additionner(matricesToCompute[i]);
                break;
            case MatrixByMatrixProduct:
                for (int i = 1; i < nbOfMatrices; i++)
                    resultMatrice = resultMatrice.multiply(matricesToCompute[i]);
                break;
            case MatrixByScalarProduct:
                for (int i = 0; i < nbOfScalar; i++)
                    resultMatrice = resultMatrice.multiply(scalars[i]);
                break;
        }
        
        return resultMatrice;
    }

    @Override
    public Gui GetNextMenu() {
        ConsoleManagement.WaitForUserInput();
        return new ArithmeticsGui();
    }
    
}
