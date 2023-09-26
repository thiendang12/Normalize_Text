package Controller;

import java.util.ArrayList;
import service.NormalizeTextService;
import view.Menu;

public class NormalizeTextController extends Menu<String> {

    static String[] menuChoice = {"Format Normalize Text ", "Exit"};

    protected NormalizeTextService service;

    public NormalizeTextController() {
        super("Student Manager", menuChoice);
        service = new NormalizeTextService();
    }

    @Override
    public boolean execute(int n) {
        switch (n) {
            case 1:
                formatText();
                break;
            case 2:
                return false;
            default:
                return false;
        }
        return true;
    }

    public void formatText() {
        boolean check = service.formatText();
        if (check) {
            System.out.println("Format Success");
        } else {
            System.out.println("System has error!!!");
        }

    }

}
