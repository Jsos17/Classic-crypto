package crypto.cryptoapp;

import java.util.HashMap;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author jpssilve
 */
public class SuperController implements EventHandler {

    private Stage stage;
    private MenuView menuView;
    private HashMap<String, CipherView> cipherViews;

    public SuperController(Stage s, MenuView m, HashMap<String, CipherView> views) {
        stage = s;
        menuView = m;
        cipherViews = views;
    }

    @Override
    public void handle(Event event) {
        String type = ((Button) event.getSource()).getText();
        stage.setScene(new Scene(cipherViews.get(type)));
    }

    public void backToMenu() {
        stage.setScene(new Scene(menuView));
    }

}
