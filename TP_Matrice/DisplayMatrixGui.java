public class DisplayMatrixGui extends Gui {

    @Override
    public void Draw() {
        final String guiTitle = "Afficher matrice:\n\n"; 
        
        if (Main.matrixList.size() == 0) {
            System.out.println(guiTitle + "Il n'y a aucune matrice a afficher.");
            return;
        }

        int userChoice;
        do {
            System.out.printf(
                guiTitle +
                "Il y a actuellement %d matrices définies.\n\n" +
                "Veuillez entrer l'index de la matrice a afficher (%d -> %d): ", Main.matrixList.size(), 1, Main.matrixList.size()
            );
            userChoice = ConsoleManagement.GetSafeInteger();
        } while ((userChoice < 1) || (userChoice > Main.matrixList.size()));

        ConsoleManagement.ClearConsole();
        System.out.println(guiTitle + Main.matrixList.get(userChoice - 1));
    }

    @Override
    public Gui GetNextMenu() {
        ConsoleManagement.WaitForUserInput();
        return new ManagementGui();
    }
    
}
