/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptoapp;

import crypto.ciphers.AutokeyVigenereCipher;
import crypto.ciphers.KeyedVigenereCipher;
import crypto.ciphers.TranspositionCipher;
import crypto.ciphers.VigenereCipher;
import crypto.cryptanalysis.HillClimber;
import crypto.cryptanalysis.Quadgrams;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author jpssilve
 */
public class CryptoUserInterface extends Application {

    private VigenereCipher vigenere;
    private KeyedVigenereCipher keyedVig;
    private AutokeyVigenereCipher autokeyVig;
    private TranspositionCipher transposition;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Quadgrams quad = new Quadgrams("english_quadgrams.txt");
        TranspositionCipher cipher = new TranspositionCipher();
        HillClimber climber = new HillClimber(quad);
        String ciphertext = "phinascpskrcepxtuctetustyrlllsireftaneiobeoistepnawyipohlileocmsctliarlaarrdletfoehrrlttiihhpttsruhlgdepyytaiaducnhinactotoeooetfnviefnepshtnbbtttessvihoafaknicaswiruiungoouueufesknksiboebhetoecamcotrlfeealyoihtpoaaakttcusnatiutneotcoavoihtnneeluekntestaheansdefkonsslkdoeneaeoawyfcacktwhoeebfoiimsaonehotrsoedegstuane";
//        System.out.println(text.length());
        String key = climber.runToTheHills(10, ciphertext.toUpperCase(), 20, 1000);
        System.out.println(key);
        System.out.println(cipher.decryptSingleTransposition(key, ciphertext));

        launch(CryptoUserInterface.class);
    }

    /**
     * Very crude outline of the graphical user interface. Cryptanalysis
     * functionality is missing
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        vigenere = new VigenereCipher();
        keyedVig = new KeyedVigenereCipher("");
        autokeyVig = new AutokeyVigenereCipher();
        transposition = new TranspositionCipher();

        int width = 1000;
        int height = 640;
        // Ciphers, general
        Label textLabel = new Label("Plaintex/Ciphertext:");
        TextArea text = new TextArea();
        text.setPromptText("Enter plaintext/ciphertext");
        text.setWrapText(true);
        Label resultLabel = new Label("Encryption/Decryption:");
        TextArea result = new TextArea();
        result.setPromptText("The encryption/decryption result appears here");
        result.setWrapText(true);
        Button clearText = new Button("Clear text");
        Button clearResult = new Button("Clear result");
        VBox ciphersLeft = createLeftBox(new Node[]{textLabel, text, resultLabel, result, clearResult});

        // Vigenere
        Label vigLabel = new Label("Vigenere cipher");
        styleLabels(vigLabel, 15);
        Label vigKeyLabel = new Label("Encryption/Decryption key:");
        styleKeyLabels(vigKeyLabel);
        TextField vigKey = new TextField();
        vigKey.setPromptText("Enter key");
        String vigInfo = "The key should be a word of any\n"
                + "length containing the characters\n"
                + "of the standard Latin alphabet\n"
                + "in lower case:\n"
                + "abcdefghijklmnopqrstuvwxyz\n"
                + "\n"
                + "Using other characters will\n"
                + "most likely produce incorrect\n"
                + "results. Letters can be repeated\n"
                + "in the key.\n"
                + "\n"
                + "The longer the key, the stronger\n"
                + "the encryption, since the key is\n"
                + "lengthened to match the plaintext\n"
                + "length.\n"
                + "If the key is longer than the plaintext\n"
                + "then cryptanalysis of the ciphertext is\n"
                + "much more difficult.";
        VBox vigR = createRightBox(new Node[]{vigKeyLabel, vigKey, new Text(vigInfo)});
        Button encrypt1 = new Button("Encrypt");
        Button decrypt1 = new Button("Decrypt");

        // Keyed Vigenere
        Label keyedVigLabel = new Label("Keyed Vigenere cipher");
        styleLabels(keyedVigLabel, 15);
        Label alphabetKeyLabel = new Label("Alphabet key:");
        styleKeyLabels(alphabetKeyLabel);
        TextField alphabetKey = new TextField();
        alphabetKey.setPromptText("Enter alphabet key");
        Label keyedVigKeyLabel = new Label("Encryption/Decryption key:");
        styleKeyLabels(keyedVigKeyLabel);
        TextField keyedVigKey = new TextField();
        keyedVigKey.setPromptText("Enter key");
        String alphabetKeyInfo = "For example, a suitable alphabet key\n"
                + "is the word kryptos, since it\n"
                + "contains only the standard 26\n"
                + "Latin alphabet characters,\n"
                + "letters are in lower case and\n"
                + "no characters are repeated.\n"
                + "The resulting alphabet order\n"
                + "would be:\n"
                + "\n"
                + "kryptosabcdefghijlmnquvwxz\n"
                + "\n"
                + "If the alphabet key contains\n"
                + "characters in upper case or\n"
                + "characters that do not belong\n"
                + "to the standard 26 character\n"
                + "Latin alphabet, then these\n"
                + "characters are simply ignored\n"
                + "and they are replaced with any\n"
                + "unused characters from the\n"
                + "standard order.\n"
                + "\n"
                + "Leaving the alphabet key empty\n"
                + "produces the standard alphabet\n"
                + "order:\n"
                + "\n"
                + "abcdefghijklmnopqrstuvwxyz";
        String keyInfo2 = "Instructions are the same\n"
                + "as for the Vigenere cipher.";
        VBox keyedR = createRightBox(new Node[]{alphabetKeyLabel, alphabetKey, new Text(alphabetKeyInfo), keyedVigKeyLabel, keyedVigKey, new Text(keyInfo2)});
        Button encrypt2 = new Button("Encrypt");
        Button decrypt2 = new Button("Decrypt");

        // Autokey Vigenere
        Label autokeyLabel = new Label("Autokey Vigenere cipher");
        styleLabels(autokeyLabel, 15);
        Label primerLabel = new Label("Primer key:");
        styleKeyLabels(primerLabel);
        TextField primer = new TextField();
        primer.setPromptText("Enter primer key");
        String primerInfo = "The primer key should not be\n"
                + "empty since it makes deterministic\n"
                + "decryption impossible.\n"
                + "\n"
                + "The primer key should contain\n"
                + "The standard 26 characters of\n"
                + "the Latin alphabet in lower case\n"
                + "and the characters can repeat as\n"
                + "many times as is desired.\n"
                + "\n"
                + "If other characters are used then\n"
                + "the results might be inconsistent";
        VBox autokeyR = createRightBox(new Node[]{primerLabel, primer, new Text(primerInfo)});
        Button encrypt3 = new Button("Encrypt");
        Button decrypt3 = new Button("Decrypt");

        // Single transposition
        Label singleTrLabel = new Label("Single columnar transposition cipher");
        styleLabels(singleTrLabel, 15);
        Label transpositionKeyLabel = new Label("Encryption/Decryption key:");
        styleKeyLabels(transpositionKeyLabel);
        TextField transpositionKey = new TextField();
        transpositionKey.setPromptText("Enter key");
        String info = "If text is pasted into the text areas,\n"
                + "care should be taken, that no extra\n"
                + "spaces are added automatically by\n"
                + "the paste operation to the end of\n"
                + "the text, because it might produce\n"
                + "incorrect results.\n"
                + "This is especially important,\n"
                + "if the text to be encrypted\n"
                + "or decrypted contains many\n"
                + "spaces.\n"
                + "The transposition operation\n"
                + "is very sensitive to even one\n"
                + "single additional space,\n"
                + "especially when decrypting\n"
                + "a ciphertext.";
        VBox transpR = createRightBox(new Node[]{new Text(info), transpositionKeyLabel, transpositionKey});
        Button encrypt4 = new Button("Encrypt");
        Button decrypt4 = new Button("Decrypt");

        // Double transposition
        Label doubleTrLabel = new Label("Double columnar transposition cipher");
        styleLabels(doubleTrLabel, 15);
        Label key1Label = new Label("First encryption/decryption key:");
        styleKeyLabels(key1Label);
        TextField transpositionKey1 = new TextField();
        transpositionKey1.setPromptText("Enter first key");
        Label key2Label = new Label("Second encryption/decryption key:");
        styleKeyLabels(key2Label);
        TextField transpositionKey2 = new TextField();
        transpositionKey2.setPromptText("Enter second key");
        String keyOrderInfo = "The key order is the same\n"
                + "in both encryption and decryption:\n"
                + "The plaintext is encrypted using\n"
                + "the first key, and then the second\n"
                + "one.\n"
                + "\n"
                + "When decrypting a message the keys\n"
                + "should be in the exact same order as\n"
                + "if one was trying to encrypt a message.\n"
                + "The program automatically applies the\n"
                + "second key first in decryption and the\n"
                + "first key last in decryption.";
        VBox dTranspR = createRightBox(new Node[]{new Text(info), key1Label, transpositionKey1, key2Label, transpositionKey2, new Text(keyOrderInfo)});
        Button encrypt5 = new Button("Encrypt");
        Button decrypt5 = new Button("Decrypt");

        // Cipher menu
        VBox ciphersMenu = new VBox();
        Label ciphers = new Label("Ciphers:");
        ciphers.setFont(new Font("Comic Sans MS", 16));
        Button vigCipher = new Button("Vigenere cipher");
        Button keyedVigCipher = new Button("Keyed Vigenere cipher");
        Button autokeyVigCipher = new Button("Autokey Vigenere cipher");
        Button singleTranspositionCipher = new Button("Single columnar transposition cipher");
        Button doubleTranspositionCipher = new Button("Double columnar transposition cipher");
        ciphersMenu.getChildren().addAll(ciphers, vigCipher, keyedVigCipher, autokeyVigCipher, singleTranspositionCipher, doubleTranspositionCipher);
        ciphersMenu.setSpacing(20);

        Button backToMenu1 = new Button("Main menu");

        // Cipher scene/window
        BorderPane cipherView = new BorderPane();
        Scene cipherScene = new Scene(cipherView, width, height);
        cipherView.setLeft(ciphersLeft);
        cipherView.setBottom(backToMenu1);

        // User chooses a cipher
        vigCipher.setOnMouseClicked((event) -> {
            ciphersLeft.getChildren().add(2, createButtonBox(new Node[]{encrypt1, decrypt1, clearText}));
            cipherView.setTop(vigLabel);
            cipherView.setRight(vigR);
            stage.setScene(cipherScene);
        });

        keyedVigCipher.setOnMouseClicked((event) -> {
            ciphersLeft.getChildren().add(2, createButtonBox(new Node[]{encrypt2, decrypt2, clearText}));
            cipherView.setTop(keyedVigLabel);
            cipherView.setRight(keyedR);
            stage.setScene(cipherScene);
        });

        autokeyVigCipher.setOnMouseClicked((event) -> {
            ciphersLeft.getChildren().add(2, createButtonBox(new Node[]{encrypt3, decrypt3, clearText}));
            cipherView.setTop(autokeyLabel);
            cipherView.setRight(autokeyR);
            stage.setScene(cipherScene);
        });

        singleTranspositionCipher.setOnMouseClicked((event) -> {
            ciphersLeft.getChildren().add(2, createButtonBox(new Node[]{encrypt4, decrypt4, clearText}));
            cipherView.setTop(singleTrLabel);
            cipherView.setRight(transpR);
            stage.setScene(cipherScene);
        });

        doubleTranspositionCipher.setOnMouseClicked((event) -> {
            ciphersLeft.getChildren().add(2, createButtonBox(new Node[]{encrypt5, decrypt5, clearText}));
            cipherView.setTop(doubleTrLabel);
            cipherView.setRight(dTranspR);
            stage.setScene(cipherScene);
        });

        // Encryption/decryption events for different ciphers
        encrypt1.setOnMouseClicked((event) -> {
            result.setText(vigenere.encrypt(vigKey.getText(), text.getText()));
        });

        decrypt1.setOnMouseClicked((event) -> {
            result.setText(vigenere.decrypt(vigKey.getText(), text.getText()));
        });

        encrypt2.setOnMouseClicked((event) -> {
            keyedVig.setAlphabet(alphabetKey.getText());
            result.setText(keyedVig.encrypt(keyedVigKey.getText(), text.getText()));
        });

        decrypt2.setOnMouseClicked((event) -> {
            keyedVig.setAlphabet(alphabetKey.getText());
            result.setText(keyedVig.decrypt(keyedVigKey.getText(), text.getText()));
        });

        encrypt3.setOnMouseClicked((event) -> {
            result.setText(autokeyVig.encrypt(primer.getText(), text.getText()));
        });

        decrypt3.setOnMouseClicked((event) -> {
            result.setText(autokeyVig.decrypt(primer.getText(), text.getText()));
        });

        encrypt4.setOnMouseClicked((event) -> {
            result.setText(transposition.encryptSingleTransposition(transpositionKey.getText(), text.getText()));
        });

        decrypt4.setOnMouseClicked((event) -> {
            result.setText(transposition.decryptSingleTransposition(transpositionKey.getText(), text.getText()));
        });

        encrypt5.setOnMouseClicked((event) -> {
            result.setText(transposition.encryptDoubleTransposition(transpositionKey1.getText(), transpositionKey2.getText(), text.getText()));
        });

        decrypt5.setOnMouseClicked((event) -> {
            result.setText(transposition.decryptDoubleTransposition(transpositionKey1.getText(), transpositionKey2.getText(), text.getText()));
        });

        // Clearing the text areas
        clearText.setOnMouseClicked((event) -> {
            text.clear();
        });

        clearResult.setOnMouseClicked((event) -> {
            result.clear();
        });

        // Cryptanalysis
        TextArea ciphertext = new TextArea();
        ciphertext.setPromptText("Enter ciphertext");
        ciphertext.setWrapText(true);
        Button crack = new Button("Crack");
        Button clearCracking = new Button("Clear");
        TextArea crackingResult = new TextArea();
        crackingResult.setPromptText("Ciphertext cracking result appears here");
        crackingResult.setWrapText(true);
        HBox hbox2 = createButtonBox(new Node[]{crack, clearCracking});
        VBox crackLeft = createLeftBox(new Node[]{ciphertext, hbox2, crackingResult});

        // Cryptanalysis menu
        VBox cryptanalysisMenu = new VBox();
        Label cryptanalysis = new Label("Cryptanalysis:");
        cryptanalysis.setFont(new Font("Comic Sans MS", 16));
        Button attackVigenere = new Button("Attack Vigenere cipher");
        Button attackSingleTransposition = new Button("Attack single transposition cipher");
        cryptanalysisMenu.getChildren().addAll(cryptanalysis, attackVigenere, attackSingleTransposition);
        cryptanalysisMenu.setSpacing(20);

        // Cryptanalysis scene/window
        BorderPane cryptanalysisView = new BorderPane();
        Scene cryptanalysisScene = new Scene(cryptanalysisView, width, height);
        Label cryptanalysisLabel = new Label("Cryptanalysis");
        styleLabels(cryptanalysisLabel, 15);
        cryptanalysisView.setTop(cryptanalysisLabel);
        cryptanalysisView.setLeft(crackLeft);
        Button backToMenu2 = new Button("Main menu");
        cryptanalysisView.setBottom(backToMenu2);

        attackVigenere.setOnMouseClicked((event) -> {
            stage.setScene(cryptanalysisScene);
        });

        attackSingleTransposition.setOnMouseClicked((event) -> {
            stage.setScene(cryptanalysisScene);
        });

        Label welcome = new Label("Choose Ciphers for encryption/decryption or Cryptanalysis to analyze ciphertext");
        welcome.setFont(new Font("Comic Sans MS", 20));
        welcome.setPadding(new Insets(11));
        BorderPane menu = new BorderPane();
        menu.setTop(welcome);
        menu.setLeft(ciphersMenu);
        menu.setRight(cryptanalysisMenu);

        Scene menuScene = new Scene(menu, width, height);
        backToMenu1.setOnMouseClicked((event) -> {
            ciphersLeft.getChildren().remove(2);
            text.clear();
            result.clear();
            stage.setScene(menuScene);
        });

        backToMenu2.setOnMouseClicked((event) -> {
            stage.setScene(menuScene);
        });

        stage.setTitle("CryptoApp");
        stage.setScene(menuScene);
        stage.show();
    }

    private void styleKeyLabels(Label label) {
        label.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        label.setTextFill(Color.GREEN);
    }

    private void styleLabels(Label label, int fontsize) {
        label.setFont(new Font("Comic Sans MS", fontsize));
        label.setPadding(new Insets(10));
    }

    private VBox createLeftBox(Node[] nodes) {
        VBox vboxLeft = new VBox();
        for (Node node : nodes) {
            vboxLeft.getChildren().add(node);

        }

        vboxLeft.setSpacing(5);
        return vboxLeft;
    }

    private VBox createRightBox(Node[] nodes) {
        VBox vboxRight = new VBox();
        for (Node node : nodes) {
            vboxRight.getChildren().add(node);
        }

        vboxRight.setSpacing(5);
        return vboxRight;
    }

    private HBox createButtonBox(Node[] nodes) {
        HBox hbox = new HBox();
        hbox.setSpacing(15);
        for (Node node : nodes) {
            hbox.getChildren().add(node);
        }

        return hbox;
    }

    @Override
    public void stop() {
        System.out.println("The application closes");
    }
}
