package jellal.mohamed.taller.view;

import java.util.Scanner;

public class BaseConsoleView {

    public void mostrarMissatge(String missatge, boolean isError) {
        if (isError) {
            System.err.println(missatge);
        } else {
            System.out.println(missatge);
        }

    }

    public String getString(String missatge) {
        String resultat = "";
        System.out.println(missatge);
        Scanner scanner = new Scanner(System.in);
        resultat = scanner.nextLine();

        return resultat;
    }

}
