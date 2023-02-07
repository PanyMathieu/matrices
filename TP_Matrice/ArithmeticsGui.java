public class ArithmeticsGui extends Gui {

    @Override
    public void Draw() {
        System.out.println(
            "Opérations arithmétiques:\n\n" +
            "1) Addition (Matrice + Matrice)\n" +
            "2) Produit (Matrice * Matrice)\n" +
            "3) Produit (Scalaire * Matrice)\n" +
            "\n" +
            "4) Retour au Menu principal\n" +
            "\n"
        );
    }

    @Override
    public Gui GetNextMenu() {
        return UserSelectedGui(
            new ComputeGui(MatrixOperations.MatrixAddition),
            new ComputeGui(MatrixOperations.MatrixByMatrixProduct),
            new ComputeGui(MatrixOperations.MatrixByScalarProduct),
            new MainGui()
        );
    }
    
}
