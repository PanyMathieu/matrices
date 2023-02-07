public class PropertyGui extends Gui {

    @Override
    public void Draw() {
        System.out.println(
            "Afficher propriétés:\n\n" +
            "1) Determinant\n" +
            "2) Transposée\n" +
            "3) Comatrice\n" +
            "4) Matrice inverse\n" +
            "\n" +
            "5) Précédent\n" +
            "\n"
        );
        
    }

    @Override
    public Gui GetNextMenu() {
        return UserSelectedGui(
            new FetchPropertyGui(MatrixProperty.Determinant),
            new FetchPropertyGui(MatrixProperty.Transposee),
            new FetchPropertyGui(MatrixProperty.Comatrice),
            new FetchPropertyGui(MatrixProperty.Inverse),
            new ManagementGui()
        );
    }
    
}
