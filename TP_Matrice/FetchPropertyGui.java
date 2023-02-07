public class FetchPropertyGui extends Gui {

    private MatrixProperty property;
    private String guiTitle;

    public FetchPropertyGui(MatrixProperty property) {
        this.property = property;
    }

    @Override
    public void Draw() {
        Init();
        System.out.print(guiTitle);

        DisplayProperty(GetMatrixFromUser());
    }

    private Matrice GetMatrixFromUser() {
        int matrixIndex;
        do {
            ConsoleManagement.ClearConsole();
            System.out.println(guiTitle + "Veuillez selectioner l'index d'une matrice: ");
            matrixIndex = ConsoleManagement.GetSafeInteger();
        } while (!Utils.IsIntBetween(matrixIndex, 1, Main.matrixList.size()));

        return Main.matrixList.get(matrixIndex - 1);
    }

    private void DisplayProperty(Matrice selectedMatrice){
        ConsoleManagement.ClearConsole();
        System.out.print(guiTitle);
        
        switch (property) {
            default:
            case Determinant:
                System.out.printf("Le déterminant de la matrice sélectionée est %f\n", selectedMatrice.getDeterminant());
                break;
            case Transposee:
                System.out.println("La transposé de la matrice séléctionée est:\n\n" + selectedMatrice.getTransposee() + "\n");
                break;
            case Comatrice:
                Matrice comatrice = selectedMatrice.getCoMatrice();
                if (comatrice != null)
                    System.out.println("La comatrice de la matrice sélectioné est:\n\n" + comatrice + "\n");
                else
                    System.out.println("Il n'existe pas de comatrice pour la matrice sélectionée\n");
                break;
            case Inverse:
                Matrice inverse = selectedMatrice.getMatriceInverse();
                if (inverse != null)
                    System.out.println("La matrice inverse de la matrice sélectionée est:\n\n" + inverse + "\n");
                else
                    System.out.println("Il n'existe pas de matrice inverse pour la matrice sélectionée\n");
                break;
        }
    }

    private void Init() {
        switch (property) {
            default:
            case Determinant:
                guiTitle = "Determinant:\n\n";
                break;
            case Transposee:
                guiTitle = "Transposée:\n\n";
                break;
            case Comatrice:
                guiTitle = "Comatrice:\n\n";
                break;
            case Inverse:
                guiTitle = "Matrice inverse:\n\n";
                break;
        }
    }

    @Override
    public Gui GetNextMenu() {
        ConsoleManagement.WaitForUserInput();
        return new PropertyGui();
    }
    
}
