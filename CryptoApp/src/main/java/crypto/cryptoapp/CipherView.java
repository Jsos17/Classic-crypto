package crypto.cryptoapp;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author jpssilve
 */
public class CipherView extends Pane {

    private String encryptionMethod;
    private Button encrypt;
    private Button decrypt;
    private Button clearText;
    private Button clearResult;
    private Button back;

    private Label textLabel;
    private TextArea text;
    private Label resultLabel = new Label("Encryption/Decryption:");
    private TextArea result = new TextArea();

    private VBox ciphersLeft;

    public CipherView(String method) {
        super();
        encryptionMethod = method;
        textLabel = new Label("Plaintext/Ciphertext:");
        text = new TextArea();
        text.setPromptText("Enter plaintext/ciphertext");
        text.setWrapText(true);
        resultLabel = new Label("Encryption/Decryption:");
        result = new TextArea();
        result.setPromptText("The encryption/decryption result appears here");
        result.setWrapText(true);
        encrypt = new Button("Encrypt");
        decrypt = new Button("Decrypt");
        clearText = new Button("Clear text");
        clearResult = new Button("Clear result");
        back = new Button("Back");
        ciphersLeft = createVBox(new Node[]{textLabel, text, createButtonBox(new Node[]{encrypt, decrypt, clearText}), resultLabel, result, clearResult});
        getChildren().add(ciphersLeft);
    }

    private VBox createVBox(Node[] nodes) {
        VBox vbox = new VBox();
        for (Node node : nodes) {
            vbox.getChildren().add(node);
        }

        vbox.setSpacing(5);
        return vbox;
    }

    private HBox createButtonBox(Node[] nodes) {
        HBox hbox = new HBox();
        hbox.setSpacing(15);
        for (Node node : nodes) {
            hbox.getChildren().add(node);
        }

        return hbox;
    }

    public void updateResult(String content) {
        result.setText(content);
    }

    public void clearText() {
        text.clear();
    }

    public void clearResult() {
        result.clear();
    }

    public void setController(EventHandler listener) {
        encrypt.setOnMouseClicked(listener);
        decrypt.setOnMouseClicked(listener);
        clearText.setOnMouseClicked(listener);
        clearResult.setOnMouseClicked(listener);
        back.setOnMouseClicked(listener);
    }

    public String getEncryptionMethod() {
        return encryptionMethod;
    }

    public String getText() {
        return text.getText();
    }

    public String getResult() {
        return result.getText();
    }
}
