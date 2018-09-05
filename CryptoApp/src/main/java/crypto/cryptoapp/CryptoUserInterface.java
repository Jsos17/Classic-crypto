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
import crypto.cryptanalysis.FrequencyAnalysis;
import crypto.cryptanalysis.HillClimber;
import crypto.cryptanalysis.IndexOfCoincidence;
import crypto.cryptanalysis.Ngrams;
import crypto.helpers.CharacterValue;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
    private Ngrams quadgrams;
    private HillClimber hillClimber;
    private FrequencyAnalysis freq;
    private IndexOfCoincidence ic;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Quadgrams quad = new Quadgrams("src/main/resources/english_quadgrams.txt");
//        TranspositionCipher cipher = new TranspositionCipher();
//        HillClimber climber = new HillClimber(quad);
//        String ciphertext = "phinascpskrcepxtuctetustyrlllsireftaneiobeoistepnawyipohlileocmsctliarlaarrdletfoehrrlttiihhpttsruhlgdepyytaiaducnhinactotoeooetfnviefnepshtnbbtttessvihoafaknicaswiruiungoouueufesknksiboebhetoecamcotrlfeealyoihtpoaaakttcusnatiutneotcoavoihtnneeluekntestaheansdefkonsslkdoeneaeoawyfcacktwhoeebfoiimsaonehotrsoedegstuane";
////        System.out.println(text.length());
//        String key = climber.runToTheHills(10, ciphertext.toUpperCase(), 20, 1000);
//        System.out.println(key);
//        System.out.println(cipher.decryptSingleTransposition(key, ciphertext));

//        FrequencyAnalysis freq1 = new FrequencyAnalysis();
//        IndexOfCoincidence ic1 = new IndexOfCoincidence(freq1);
//        String c = "vptnvffuntshtarptymjwzirappljmhhqvsubwlzzygvtyitarptyiougxiuydtgzhhvvmumshwkzgstfmekvmpkswdgbilvjljmglmjfqwioiivknulvvfemioiemojtywdsajtwmtcgluysdsumfbieugmvalvxkjduetukatymvkqzhvqvgvptytjwwldyeevquhlulwpkt";
//        double[] ics = ic1.allAggregateDeltaBarICs(c);
//        for (int i = 0; i < ics.length; i++) {
//            System.out.println((i+1) + " | " + ics[i]);
//        }
//        FrequencyAnalysis freq1 = new FrequencyAnalysis();
//        IndexOfCoincidence indexOfC = new IndexOfCoincidence(freq1);
//        AttackVigenereCipher attack = new AttackVigenereCipher();
//        String ctext1 = "krmdlcbtpyfjoqrrercskoxgwiqygaevqgmrrlgvpavmklmlqmqdlydsdktjkxckyyzpydiyemqorayyldipohurildlcciybgfctymigcjjkxmbwspjgmmcxxjijjkxrrerdlcfejeipoxsbrcnfwdlcdepqirpylmxgyrgcmlnmqdmlqygclylpcpvmwxfozyvycbirevlohdyvloeplcpokgyrqnycdsrrinbiaswgyrsciblcrrikkgfsrcdspotpowcxxgdwtkpsomlcyargyciqdlcrmjvgjsqzovkkclyxzoezviryhcdipwmlomlglgmlbsvcmxgyrgdwfyyjnwrotyxhkkcukrbovgxebsvcmxgyrrrerxitovjoebcxmsqnbstoqcxx";
//        String ctext2 = "vptnvffuntshtarptymjwzirappljmhhqvsubwlzzygvtyitarptyiougxiuydtgzhhvvmumshwkzgstfmekvmpkswdgbilvjljmglmjfqwioiivknulvvfemioiemojtywdsajtwmtcgluysdsumfbieugmvalvxkjduetukatymvkqzhvqvgvptytjwwldyeevquhlulwpkt";
//
//        double[] vals = indexOfC.allAggregateDeltaBarICs(ctext1);
//        int n = vals.length / 3;
//        double threshold = attack.calculateThreshold(vals, n);
//        System.out.println("Threshold: " + threshold);
//
//        for (int i = 0; i < n; i++) {
//            if (vals[i] > threshold) {
//                System.out.println("Key: " + (i + 1));
//            }
//        }
//
//        System.out.println("Key Length: " + attack.findKeyLengths(vals, threshold));
        launch(CryptoUserInterface.class);
    }

    /**
     * Very crude outline of the graphical user interface.
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
        quadgrams = new Ngrams(4, "src/main/resources/english_quadgrams.txt");
        hillClimber = new HillClimber(quadgrams);
        freq = new FrequencyAnalysis();
        ic = new IndexOfCoincidence(freq);

        int width = 1200;
        int height = 800;

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
        VBox ciphersLeft = createVBox(new Node[]{textLabel, text, resultLabel, result, clearResult});

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
        VBox vigR = createVBox(new Node[]{vigKeyLabel, vigKey, new Text(vigInfo)});
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
        VBox keyedR = createVBox(new Node[]{alphabetKeyLabel, alphabetKey, new Text(alphabetKeyInfo), keyedVigKeyLabel, keyedVigKey, new Text(keyInfo2)});
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
        VBox autokeyR = createVBox(new Node[]{primerLabel, primer, new Text(primerInfo)});
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
        VBox transpR = createVBox(new Node[]{new Text(info), transpositionKeyLabel, transpositionKey});
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
        VBox dTranspR = createVBox(new Node[]{new Text(info), key1Label, transpositionKey1, key2Label, transpositionKey2, new Text(keyOrderInfo)});
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
        Button clearCiphertext = new Button("Clear ciphertext");
        TextArea crackingResult = new TextArea();
        crackingResult.setPromptText("Ciphertext cracking result appears here");
        crackingResult.setWrapText(true);
        Button clearCrackingResult = new Button("Clear cracking result");
        VBox crackLeft = createVBox(new Node[]{ciphertext, clearCiphertext, crackingResult, clearCrackingResult});

        clearCiphertext.setOnMouseClicked((event) -> {
            ciphertext.clear();
        });

        clearCrackingResult.setOnMouseClicked((event) -> {
            crackingResult.clear();
        });

        // Attacking the transposition cipher with HillClimber
        Label keyLenLabel = new Label("Suspected key length:");
        ObservableList<Integer> keyLens
                = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        ComboBox lenBox = new ComboBox(keyLens);
        lenBox.getSelectionModel().selectFirst();
        Label algoRunsLabel = new Label("Times the algorithm is run:");
        ObservableList<Integer> algoRuns
                = FXCollections.observableArrayList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200);
        ComboBox algoRunBox = new ComboBox(algoRuns);
        algoRunBox.getSelectionModel().selectFirst();
        Label iterationsLabel = new Label("Number of iterations for each run of the algorithm:");
        ObservableList<Integer> iterations
                = FXCollections.observableArrayList(100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000);
        ComboBox iterationsBox = new ComboBox(iterations);
        iterationsBox.getSelectionModel().selectFirst();
        Button runAlgoButton = new Button("Run the algorithm");
        Label maybeKeyLabel = new Label("Possible key:");
        Text maybeKey = new Text();
        Button trialDecryption = new Button("Try decryption with this key");
        Button keyClear = new Button("Clear key");
        HBox keyButtons = createButtonBox(new Node[]{trialDecryption, keyClear});
        VBox crackTransposition = createVBox(new Node[]{keyLenLabel, lenBox, algoRunsLabel,
            algoRunBox, iterationsLabel, iterationsBox, runAlgoButton, maybeKeyLabel, maybeKey, keyButtons});

        runAlgoButton.setOnMouseClicked((event) -> {
            int keyLen = keyLens.get(lenBox.getSelectionModel().getSelectedIndex());
            int runs = algoRuns.get(algoRunBox.getSelectionModel().getSelectedIndex());
            int iters = iterations.get(iterationsBox.getSelectionModel().getSelectedIndex());
//            System.out.println("Key len: " + keyLen);
//            System.out.println("Runs: " + runs);
//            System.out.println("Iterations: " + iters);
            maybeKey.setText(hillClimber.runToTheHills(keyLen, ciphertext.getText(), runs, iters));
        });

        trialDecryption.setOnMouseClicked((event) -> {
            crackingResult.setText(transposition.decryptSingleTransposition(maybeKey.getText(), ciphertext.getText()));
        });

        keyClear.setOnMouseClicked((event) -> {
            maybeKey.setText("");
        });

        // Attacking the Vigenere cipher with frequency analysis and the index of coincidence
        Button findKeyLen = new Button("Find possible key length");
        ObservableList<Integer> keyVisuals = FXCollections.observableArrayList();
        for (int i = 1; i <= 200; i++) {
            keyVisuals.add(i);
        }
        Label useKeyLimit = new Label("Use limit in visualization");
        ComboBox keyVisualsBox = new ComboBox(keyVisuals);
        keyVisualsBox.getSelectionModel().select(70);
        HBox keyBox = createButtonBox(new Node[]{findKeyLen, useKeyLimit, keyVisualsBox});
        Label possibleKeyLenLabel = new Label("Possible key length"); // not currently in gui because might cause confusion
        Text possibleKeyLen = new Text(); // not currently in gui because might cause confusion
        Button showValuesForKeyLens = new Button("Show associated values for key lengths");
        Label keylensLabel = new Label("Key length to use in trial decryption");
        ObservableList<Integer> keyLengths = FXCollections.observableArrayList();
        for (int i = 1; i <= 100; i++) {
            keyLengths.add(i);
        }
        ComboBox keyLengthsBox = new ComboBox(keyLengths);
        keyLengthsBox.getSelectionModel().selectFirst();
        Button findKey = new Button("Find key");
        GridPane charValueGrid = new GridPane();
        Button vigTrialdecrypt = new Button("Try decryption with this key");
        VBox crackVigenere = createVBox(new Node[]{keyBox, showValuesForKeyLens,
            keylensLabel, keyLengthsBox, findKey, charValueGrid, vigTrialdecrypt});

        Stage graphics = new Stage();
        graphics.setTitle("Key data visualization");

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> chart = new BarChart<>(xAxis, yAxis);
        chart.setTitle("Average index of coincidence values of the ciphertext for different key lengths");
        Scene barChartScene = new Scene(chart);

        findKeyLen.setOnMouseClicked((event) -> {
            chart.getData().clear();
            XYChart.Series icsForKeyLens = new XYChart.Series<>();
            double[] aggregateDeltaBarICs = ic.allAggregateDeltaBarICs(ciphertext.getText());
            int limit = keyVisuals.get(keyVisualsBox.getSelectionModel().getSelectedIndex());
            if (limit > ciphertext.getText().length()) {
                limit = ciphertext.getText().length();
            }

            for (int i = 0; i < limit; i++) {
                String len = "" + (i + 1);
                icsForKeyLens.getData().add(new XYChart.Data(len, aggregateDeltaBarICs[i]));
            }

            chart.getData().add(icsForKeyLens);
        });

        showValuesForKeyLens.setOnMouseClicked((event) -> {
            graphics.setScene(barChartScene);
            graphics.show();
        });

        findKey.setOnMouseClicked((event) -> {
            charValueGrid.getChildren().clear();

            int keyLen = keyLengths.get(keyLengthsBox.getSelectionModel().getSelectedIndex());
            CharacterValue[][] cvals = this.ic.findKey(ciphertext.getText(), keyLen);

            for (int i = 0; i < cvals.length; i++) {
                ObservableList<Character> keyChars = FXCollections.observableArrayList();
                ObservableList<Integer> keyVals = FXCollections.observableArrayList();
                for (int j = 0; j < cvals[i].length; j++) {
                    keyChars.add(cvals[i][j].getCharacter());
                    keyVals.add((int) cvals[i][j].getValue());
                }

                ComboBox charBox = new ComboBox(keyChars);
                charBox.getSelectionModel().selectFirst();
                charValueGrid.add(charBox, i, 0);
                ComboBox valueBox = new ComboBox(keyVals);
                valueBox.getSelectionModel().selectFirst();
                charValueGrid.add(valueBox, i, 1);
            }
        });

        vigTrialdecrypt.setOnMouseClicked((event) -> {
            int size = charValueGrid.getChildren().size();
            String key = "";
            for (int i = 0; i < size; i++) {
                ComboBox box = (ComboBox) charValueGrid.getChildren().get(i);
                int row = GridPane.getRowIndex(box);
                if (row == 0) {
                    key += box.getSelectionModel().getSelectedItem();
                }
            }

            crackingResult.setText(vigenere.decrypt(key, ciphertext.getText()));
        });

        // Cryptanalysis menu
        VBox cryptanalysisMenu = new VBox();
        Label cryptanalysis = new Label("Cryptanalysis:");
        cryptanalysis.setFont(new Font("Comic Sans MS", 16));
        Button attackVigenere = new Button("Attack Vigenere encryption");
        Button attackSingleTransposition = new Button("Attack single transposition encryption");
        cryptanalysisMenu.getChildren().addAll(cryptanalysis, attackVigenere, attackSingleTransposition);
        cryptanalysisMenu.setSpacing(20);

        // Cryptanalysis scene/window
        BorderPane cryptanalysisView = new BorderPane();
        Scene cryptanalysisScene = new Scene(cryptanalysisView, width, height);
        Label cryptanalysisLabel = new Label();
        styleLabels(cryptanalysisLabel, 15);
        cryptanalysisView.setTop(cryptanalysisLabel);
        cryptanalysisView.setLeft(crackLeft);
        Button backToMenu2 = new Button("Main menu");
        cryptanalysisView.setBottom(backToMenu2);

        attackVigenere.setOnMouseClicked((event) -> {
            cryptanalysisLabel.setText("Attack Vigenere encryption");
            cryptanalysisView.setRight(crackVigenere);
            stage.setScene(cryptanalysisScene);
        });

        attackSingleTransposition.setOnMouseClicked((event) -> {
            cryptanalysisLabel.setText("Attack single columnar transposition encryption");
            cryptanalysisView.setRight(crackTransposition);
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

        // Back to menu functionality
        backToMenu1.setOnMouseClicked((event) -> {
            ciphersLeft.getChildren().remove(2);
            text.clear();
            result.clear();
            stage.setScene(menuScene);
        });

        backToMenu2.setOnMouseClicked((event) -> {
            ciphertext.clear();
            crackingResult.clear();
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

    @Override
    public void stop() {
        System.out.println("The application closes");
    }
}
