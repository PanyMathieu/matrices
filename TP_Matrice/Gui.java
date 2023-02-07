public abstract class Gui {
    public abstract void Draw();
    public abstract Gui GetNextMenu();
    
    protected Gui UserSelectedGui(Gui... Options) {
        int userChoice = UserChoice();

        if ((userChoice < 1) || (userChoice > Options.length))
            return this;
        return Options[userChoice - 1];
    }

    private int UserChoice() {
        System.out.print("Veuillez choisir une option: ");
        return ConsoleManagement.GetSafeInteger();
    }
}