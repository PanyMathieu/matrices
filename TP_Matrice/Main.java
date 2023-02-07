import java.util.LinkedList;
import java.util.List;

public class Main {

	public static List<Matrice> matrixList = new LinkedList<Matrice>();

	public static void main(String[] args) {
		Gui currentGui = new MainGui();

		while (currentGui != null) {
			ConsoleManagement.ClearConsole();
			currentGui.Draw();
			currentGui = currentGui.GetNextMenu();
		}
	}
}
