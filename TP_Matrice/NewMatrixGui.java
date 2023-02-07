public class NewMatrixGui extends Gui {

    @Override
    public void Draw() {
        final String guiTitle = "Definir nouvelle matrice:\n\n";
        Matrice newMatrice;

        do {
            int x, y;
            do {
                ConsoleManagement.ClearConsole();
                System.out.println( guiTitle + "Veuillez entrer les dimentions de la matrice [X, Y]: ");

                x = ConsoleManagement.GetSafeInteger();
                y = ConsoleManagement.GetSafeInteger();
            } while ((x <= 0) || (y <= 0));
                

            double[][] inputMatrix = new double[y][x]; 

            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    ConsoleManagement.ClearConsole();
                    newMatrice = new Matrice(inputMatrix);
                    System.out.printf(guiTitle + newMatrice.toString() + "\nVeuillez entrer le nombre en position (%d, %d): ", j + 1, i + 1);
                    inputMatrix[i][j] = ConsoleManagement.GetSafeDouble();
                }
            }

            newMatrice = new Matrice(inputMatrix);
            ConsoleManagement.ClearConsole();
            System.out.print(guiTitle + newMatrice.toString() + "\nCette matrice vous covient-elle ?: ");
        } while (!ConsoleManagement.YesNo());

        Main.matrixList.add(newMatrice);
    }

    @Override
    public Gui GetNextMenu() {
        return new ManagementGui();
    }
}
