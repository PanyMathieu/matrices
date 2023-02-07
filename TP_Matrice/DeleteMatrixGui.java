public class DeleteMatrixGui extends Gui {

    @Override
    public void Draw() {
        final String guiTitle = "Supprimer matrice:\n\n";

        if (Main.matrixList.size() == 0) {
            System.out.println(guiTitle + "Il n'y a aucune matrice a effacer.");
            return;
        }

        int userChoice;
        do {
            System.out.printf(
                guiTitle +
                "Il y a actuellement %d matrices définies.\n\n" +
                "Veuillez entrer l'index de la matrice a supprimer (%d -> %d): ", Main.matrixList.size(), 1, Main.matrixList.size()
            );
            userChoice = ConsoleManagement.GetSafeInteger();
        } while ((userChoice < 1) || (userChoice > Main.matrixList.size()));
        userChoice--;

        ConsoleManagement.ClearConsole();
        Main.matrixList.remove(userChoice);
        System.out.printf(guiTitle + "Matrice numéro %d supprimé avec succès.", userChoice);
    }

    @Override
    public Gui GetNextMenu() {
        ConsoleManagement.WaitForUserInput();
        return new ManagementGui();
    }
}
