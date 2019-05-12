package crypto.cryptoapp;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author jpssilve
 */
public class MenuView extends BorderPane {

    private VBox ciphersMenu;
    private Label ciphers;
    private Button vigCipher;
    private Button keyedVigCipher;
    private Button autokeyVigCipher;
    private Button singleTranspositionCipher;
    private Button doubleTranspositionCipher;

    private VBox cryptanalysisMenu;
    private Label cryptanalysis;
    private Button attackVigenere;
    private Button attackSingleTransposition;
    private Label welcome;

    public MenuView() {
        ciphersMenu = new VBox();
        ciphers = new Label("Ciphers:");
        ciphers.setFont(new Font("Comic Sans MS", 16));
        vigCipher = new Button("Vigenere cipher");
        keyedVigCipher = new Button("Keyed Vigenere cipher");
        autokeyVigCipher = new Button("Autokey Vigenere cipher");
        singleTranspositionCipher = new Button("Single columnar transposition cipher");
        doubleTranspositionCipher = new Button("Double columnar transposition cipher");
        ciphersMenu.getChildren().addAll(ciphers, vigCipher, keyedVigCipher, autokeyVigCipher, singleTranspositionCipher, doubleTranspositionCipher);
        ciphersMenu.setSpacing(20);
        setLeft(ciphersMenu);

        cryptanalysisMenu = new VBox();
        cryptanalysis = new Label("Cryptanalysis:");
        cryptanalysis.setFont(new Font("Comic Sans MS", 16));
        attackVigenere = new Button("Attack Vigenere encryption");
        attackSingleTransposition = new Button("Attack single transposition encryption");
        cryptanalysisMenu.getChildren().addAll(cryptanalysis, attackVigenere, attackSingleTransposition);
        cryptanalysisMenu.setSpacing(20);

        setRight(cryptanalysisMenu);

        welcome = new Label("Choose Ciphers for encryption/decryption or Cryptanalysis to analyze ciphertext");
        welcome.setFont(new Font("Comic Sans MS", 20));
        welcome.setPadding(new Insets(11));
        setTop(welcome);
    }

    public void setController(EventHandler listener) {
        vigCipher.setOnMouseClicked(listener);
        keyedVigCipher.setOnMouseClicked(listener);
        autokeyVigCipher.setOnMouseClicked(listener);
        singleTranspositionCipher.setOnMouseClicked(listener);
        doubleTranspositionCipher.setOnMouseClicked(listener);
        attackVigenere.setOnMouseClicked(listener);
        attackSingleTransposition.setOnMouseClicked(listener);
    }
}
