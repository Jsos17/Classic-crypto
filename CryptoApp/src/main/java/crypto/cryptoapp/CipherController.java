package crypto.cryptoapp;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 *
 * @author jpssilve
 */
public class CipherController implements EventHandler {

    private Model model;
    private CipherView view;
    private SuperController superC;

    public CipherController(CipherView v, Model m, SuperController s) {
        view = v;
        model = m;
        view.setController(this);
        superC = s;
    }

    @Override
    public void handle(Event event) {
        String type = ((Button) event.getSource()).getText();
        if (type.equals("Encrypt")) {
            String e = model.encrypt(view.getEncryptionMethod(), new String[]{""}, view.getText());
            view.updateResult(e);
        } else if (type.equals("Decrypt")) {
            String d = model.decrypt(view.getEncryptionMethod(), new String[]{""}, view.getText());
            view.updateResult(d);
        } else if (type.equals("Clear text")) {
            view.clearText();
        } else if (type.equals("Clear result")) {
            view.clearResult();
        } else if (type.equals("Back")) {
            superC.backToMenu();
        }
    }

}
