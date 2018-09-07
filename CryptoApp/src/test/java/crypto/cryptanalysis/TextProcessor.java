/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import crypto.ciphers.TranspositionCipher;
import crypto.ciphers.VigenereCipher;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jpssilve
 */
public class TextProcessor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Character> map = new HashMap<>();
        hashAlphabet(set, map);
        VigenereCipher vig = new VigenereCipher();
        TranspositionCipher trans = new TranspositionCipher();

//        ArrayList<String> plaintexts = read("src/main/resources/unmanipulated_501_sample_plaintexts.txt", set, map);
//        write("src/main/resources/501_sample_plaintexts.txt", plaintexts, false);
        String key = "cab";
        ArrayList<String> ciphertexts = encryptTransposition("src/main/resources/501_sample_ciphertexts.txt", read("src/main/resources/501_sample_plaintexts.txt", set, map), false, trans, key);

//        FrequencyAnalysis freq = new FrequencyAnalysis();
//        IndexOfCoincidence ic = new IndexOfCoincidence(freq);
        int algoRuns = 10;
        int iterations = 500;
        System.out.println("Encryption done");
        Ngrams ngrams = new Ngrams(4, "src/main/resources/english_quadgrams.txt");
        HillClimber hill = new HillClimber(ngrams);
        ArrayList<String> foundKeys = cryptanalysisTransposition("src/main/resources/501_sample_ciphertexts.txt", key.length(), hill, algoRuns, iterations);

        int[] counts = new int[9];

        int[] lenSums = new int[9];
        int[] sizes = new int[9];

        for (int i = 0; i < foundKeys.size(); i++) {
            int len = ciphertexts.get(i).length();
            if (len <= 50) {
                lenSums[0] += len;
                sizes[0]++;
            } else if (len > 50 && len <= 100) {
                lenSums[1] += len;
                sizes[1]++;
            } else if (len > 100 && len <= 150) {
                lenSums[2] += len;
                sizes[2]++;
            } else if (len > 150 && len <= 200) {
                lenSums[3] += len;
                sizes[3]++;
            } else if (len > 200 && len <= 250) {
                lenSums[4] += len;
                sizes[4]++;
            } else if (len > 250 && len <= 300) {
                lenSums[5] += len;
                sizes[5]++;
            } else if (len > 300 && len <= 350) {
                lenSums[6] += len;
                sizes[6]++;
            } else if (len > 350 && len <= 400) {
                lenSums[7] += len;
                sizes[7]++;
            } else if (len > 400 && len <= 500) {
                lenSums[8] += len;
                sizes[8]++;
            }

            if (foundKeys.get(i).equals(key)) {
                if (len <= 50) {
                    counts[0]++;
                } else if (len > 50 && len <= 100) {
                    counts[1]++;
                } else if (len > 100 && len <= 150) {
                    counts[2]++;
                } else if (len > 150 && len <= 200) {
                    counts[3]++;
                } else if (len > 200 && len <= 250) {
                    counts[4]++;
                } else if (len > 250 && len <= 300) {
                    counts[5]++;
                } else if (len > 300 && len <= 350) {
                    counts[6]++;
                } else if (len > 350 && len <= 400) {
                    counts[7]++;
                } else if (len > 400 && len <= 500) {
                    counts[8]++;
                }
//                System.out.println("Correct | Length: " + plaintexts.get(i).length() + " | " + plaintexts.get(i));
            } else {
                System.out.println(foundKeys.get(i));
//                int sames = 0;
//                for (int j = 0; j < foundKeys.get(i).length(); j++) {
//                    if (foundKeys.get(i).charAt(j) == key.charAt(j)) {
//                        sames++;
//                    }
//                }
//
//                if (sames == foundKeys.get(i).length() - 1) {
////                    System.out.println("Almost correct | Length: " + plaintexts.get(i).length() + " | " + plaintexts.get(i));
//                    almostCount++;
//                } else {
//                    System.out.println(plaintexts.get(i));
//                }
            }
//            System.out.println(foundKeys.get(i));
        }

        double[] avgs = new double[9];
        for (int i = 0; i < avgs.length; i++) {
            avgs[i] = (double) lenSums[i] / sizes[i];
        }

        ArrayList<String>[] samples = new ArrayList[9];
        for (int i = 0; i < samples.length; i++) {
            samples[i] = new ArrayList<>();
        }

        readLengths("src/main/resources/unmanipulated_501_sample_plaintexts.txt", set, map, samples);
//        for (int i = 0; i< samples.length; i++) {
//            String filename = "plaintexts" + (i * 50 + 1) + "-" + ((i + 1) * 50)+ ".txt";
//            if (i == 8) { 
//                filename = "plaintexts" + (i * 50 + 1) + "-" + ((i + 2) * 50) + ".txt";
//            }
//            write(filename, samples[i], false);
//        }
//        for (int i = 0; i < samples.length; i++) {
//            if (i <= 7) {
//                System.out.println("Len " + (i * 50 + 1) + "-" + ((i + 1) * 50) + ": " + samples[i].size());
//            } else {
//                System.out.println("Len " + (i * 50 + 1) + "-" + ((i + 2) * 50) + ": " + samples[i].size());
//            }
//        }

        for (int i = 0; i < counts.length; i++) {
            if (i <= 7) {
//                System.out.println("Len " + (i * 50 + 1) + "-" + ((i + 1) * 50) + " Correct: " + counts[i] + "/" + samples[i].size());
            } else {
//                System.out.println("Len " + (i * 50 + 1) + "-" + ((i + 2) * 50) + " Correct: " + counts[i] + "/" + samples[i].size());
            }
            
//            System.out.println(counts[i] + " " + samples[i].size());
            System.out.println(counts[i]);
//            System.out.printf("%.1f", avgs[i]);
//            System.out.println("");
        }
        System.out.println("");
        System.out.println("Key: " + key);
        System.out.println("Algoruns: " + algoRuns);
        System.out.println("Iterations: " + iterations);
//        launch(TextProcessor.class);
    }

    private static void hashAlphabet(HashSet<Character> set, HashMap<Character, Character> map) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < lower.length(); i++) {
            set.add(lower.charAt(i));
            map.put(lower.charAt(i), lower.charAt(i));
            map.put(upper.charAt(i), lower.charAt(i));
        }
    }

    private static String process(String text, HashSet<Character> set, HashMap<Character, Character> map) {
        char[] lowerCaseChars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            lowerCaseChars[i] = map.getOrDefault(text.charAt(i), text.charAt(i));
        }

        String lowerCaseString = new String(lowerCaseChars);

        char[] processedChars = new char[lowerCaseString.length()];
        int index = 0;
        for (int i = 0; i < lowerCaseString.length(); i++) {
            if (set.contains(lowerCaseString.charAt(i))) {
                processedChars[index] = lowerCaseString.charAt(i);
                index++;
            }
        }

        return new String(processedChars, 0, index);
    }

    private static ArrayList<String> cryptanalysisTransposition(String filename, int keyLen, HillClimber hill, int algoRuns, int iterations) {
        ArrayList<String> foundKeys = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
//                System.out.println(scanner.nextLine());
                String line = scanner.nextLine();
                foundKeys.add(hill.runToTheHills(keyLen, line, algoRuns, iterations));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return foundKeys;
    }

    private static ArrayList<String> cryptanalysisTestVigenere(String filename, int keyLen, IndexOfCoincidence ic) {
        ArrayList<String> foundKeys = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
//                System.out.println(scanner.nextLine());
                String line = scanner.nextLine();
                ic.findKey(line, keyLen);
                foundKeys.add(ic.getKeyCandidate());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return foundKeys;
    }

    private static ArrayList<String> read(String filename, HashSet<Character> set, HashMap<Character, Character> map) {
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
//                System.out.println(scanner.nextLine());
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    lines.add(process(line, set, map));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return lines;
    }

    private static void readLengths(String filename, HashSet<Character> set, HashMap<Character, Character> map, ArrayList[] samples) {
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            int index = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    index++;
                    String processed = process(line, set, map);
                    if (processed.length() <= 50) {
                        samples[0].add(processed);
                    } else if (processed.length() > 50 && processed.length() <= 100) {
                        samples[1].add(processed);
                    } else if (processed.length() > 100 && processed.length() <= 150) {
                        samples[2].add(processed);
                    } else if (processed.length() > 150 && processed.length() <= 200) {
                        samples[3].add(processed);
                    } else if (processed.length() > 200 && processed.length() <= 250) {
                        samples[4].add(processed);
                    } else if (processed.length() > 250 && processed.length() <= 300) {
                        samples[5].add(processed);
                    } else if (processed.length() > 300 && processed.length() <= 350) {
                        samples[6].add(processed);
                    } else if (processed.length() > 350 && processed.length() <= 400) {
                        samples[7].add(processed);
                    } else if (processed.length() > 400 && processed.length() <= 500) {
                        samples[8].add(processed);
                    } else {
                        System.out.println(processed.length());
                        System.out.println(index);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    private static void write(String filename, ArrayList<String> lines, boolean append) {
        try (FileWriter fw = new FileWriter(new File(filename), append)) {
            for (int i = 0; i < lines.size(); i++) {
                fw.write(lines.get(i) + "\n");
            }
        } catch (IOException ioe) {
            System.out.println("File problem");
        }
    }

    private static ArrayList<String> encrypt(String filename, ArrayList<String> lines, boolean append, VigenereCipher vig, String key) {
        ArrayList<String> encryptions = new ArrayList<>();

        try (FileWriter fw = new FileWriter(new File(filename), append)) {
            for (int i = 0; i < lines.size(); i++) {
                String encrypt = vig.encrypt(key, lines.get(i));
                encryptions.add(encrypt);
                fw.write(encrypt + "\n");
            }
        } catch (IOException ioe) {
            System.out.println("File problem");
        }

        return encryptions;
    }

    private static ArrayList<String> encryptTransposition(String filename, ArrayList<String> lines, boolean append, TranspositionCipher trans, String key) {
        ArrayList<String> encryptions = new ArrayList<>();

        try (FileWriter fw = new FileWriter(new File(filename), append)) {
            for (int i = 0; i < lines.size(); i++) {
                String encrypt = trans.encryptSingleTransposition(key, lines.get(i));
                encryptions.add(encrypt);
                fw.write(encrypt + "\n");
            }
        } catch (IOException ioe) {
            System.out.println("File problem");
        }

        return encryptions;
    }

//    @Override
    public void start(Stage stage) throws Exception {
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Character> map = new HashMap<>();
        hashAlphabet(set, map);

        VBox box = new VBox();
        Label textLabel = new Label("Text:");
        TextArea text = new TextArea();
        text.setWrapText(true);
        Button processButton = new Button("Process text");
        Button clear = new Button("Clear");
        HBox hbox = new HBox();
        hbox.getChildren().addAll(processButton, clear);
        hbox.setSpacing(10);
        Label textLen = new Label("Processed text length:");
        Label resultLabel = new Label("Result:");
        TextArea result = new TextArea();
        result.setWrapText(true);
        result.setEditable(false);
        TextField length = new TextField();
        length.setEditable(false);

        box.getChildren().add(textLabel);
        box.getChildren().add(text);
        box.getChildren().add(hbox);
        box.getChildren().add(resultLabel);
        box.getChildren().add(result);
        box.getChildren().add(textLen);
        box.getChildren().add(length);

        processButton.setOnMouseClicked((event) -> {
            String processed = text.getText();
            result.setText(process(processed, set, map));
            length.setText("" + result.getText().length());
        });

        clear.setOnMouseClicked((event) -> {
            text.clear();
        });

        Scene scene = new Scene(box, 800, 480);
        stage.setScene(scene);
        stage.show();
    }
}
