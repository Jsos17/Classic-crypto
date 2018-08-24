/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptoapp;

import crypto.ciphers.TranspositionCipher;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author jpssilve
 */
public class CryptoUserInterface extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        FrequencyAnalysis freq = new FrequencyAnalysis();
//        double[] expFreq = freq.getExpectedLetterFrequencies();
//        double sum = 0;
//        for (int i = 0; i < expFreq.length; i++) {
//            sum += expFreq[i];
//        }
//
//        System.out.println(sum);
//
//        double sum_pow2 = 0;
//        for (int i = 0; i < expFreq.length; i++) {
//            sum_pow2 += expFreq[i] * expFreq[i];
//        }
//
//        double expectedIC = 26 * sum_pow2;
//        System.out.println(expectedIC);
//        IndexOfCoincidence ic = new IndexOfCoincidence(freq);
//        String ciphertext1 = "QPWKALVRXCQZIKGRBPFAEOMFLJMSDZVDHXCXJYEBIMTRQWNMEAIZRVKCVKVLXNEICFZPZCZZHKMLVZVZIZRRQWDKECHOSNYXXLSPMYKVQXJTDCIOMEEXDQVSRXLRLKZHOV".toLowerCase();
//        System.out.println(ciphertext1);
//        double[] deltas = ic.allAggregateDeltaBarICs(ciphertext1);
//        for (int i = 0; i < 20; i++) {
//            System.out.print((i + 1) + " | ");
//            System.out.printf("%.2f %n", deltas[i]);
//        }
//
//        ic.findKey(ciphertext1, 5);
//        ic.solve(ic.getKeyCandidate(), ciphertext1);
//        System.out.println(ic.getKeyCandidate());
//        String ciphertext2 = "vptnvffuntshtarptymjwzirappljmhhqvsubwlzzygvtyitarptyiougxiuydtgzhhvvmum"
//                + "shwkzgstfmekvmpkswdgbilvjljmglmjfqwioiivknulvvfemioiemojtywdsajtwmtcgluy"
//                + "sdsumfbieugmvalvxkjduetukatymvkqzhvqvgvptytjwwldyeevquhlulwpkt";
//        double[] deltas2 = ic.allAggregateDeltaBarICs(ciphertext2);
//        for (int i = 0; i < deltas2.length; i++) {
//            System.out.print((i + 1) + " | ");
//            System.out.printf("%.2f %n", deltas2[i]);
//        }
//
////        CharacterValue[][] charValues = ic.findKey(ciphertext2, 7);
////        for (int j = 0; j < charValues[0].length; j++) {
////            for (int i = 0; i < charValues.length; i++) {
////                System.out.print(charValues[i][j].getCharacter());
////            }
////            System.out.println();
////        }
//        System.out.println(ic.solve(ic.getKeyCandidate(), ciphertext2));
//        ic.findKey(ciphertext2, 14);
//        System.out.println(ic.solve(ic.getKeyCandidate(), ciphertext2));     
//        System.out.println(ic.solve("ciphers", ciphertext2));
//        int[] nums1 = new int[]{5, 4, 2, 1, 9, 8, 6};
//        PrimitiveTypeSort.iterativeMergeSort(nums1);
//        System.out.println(Arrays.toString(nums1));
//        long[] numbas = new long[10];
//        for (int i = 0; i< numbas.length; i++) {
//            numbas[i] = Long.MAX_VALUE;
//        }
//        PrimitiveTypeSort.iterativeMergeSort(numbas);
//        System.out.println(Arrays.toString(numbas));
//        
//        long[] numbas2 = new long[]{1l};
//        PrimitiveTypeSort.iterativeMergeSort(numbas2);
//        System.out.println(Arrays.toString(numbas2));
//        
//        Integer[] nums2 = new Integer[]{5, 4, 2, 1, 9, 8, 6};
//        GenericTypeSort.iterativeMergeSort(nums2);
//        System.out.println(Arrays.toString(nums2));
//        
//        System.out.println(3 ^ 2);
//        String text = "unczqztxeubjfxutwaqbroiromeimcjsmgxqrqmbuiblcpvgijtkzzrtxaelljmfhcuwglqrculnrkpcybvgglcytrxfetpvglqpnhqaxqxvdqypmlyhgffqtthvfjarollvrfovomfeyenlbgidipaprgupjlzgijthvzvretcukrmranswpggrtlvpieohaprpqtvlzrxgrppvgsfhgsmgxqrzhkvttetamkxyeuzitioopaivruniuczidowzqawfapjmfsrtjltrxfeteebyxdubotietvvipvkpvhvnpksvapnxjrgwzrwqnvzmglqbczqpyeeqmneicuguklezanfavwusvvnvvetevcaxfhgmzrugepjgbjoiromexqxvsmgxqruhvqxtephafsoicamtyqsullcpmipamkxxevamewiivobuiymqymkwunvompmbhgybrbftjhvnrktjpvtixsgzctkqsvzbuefxevzeiepqulfxaekubuiblcpvgijtdbbgluskzvbxoetaivrfapkinvqanzwiidyevuzsziplvtpusjzwkqugjajriutjlzbjfhgtiywaivpahrximltlxabghxyeunvlfgdarsdpvgtatltrwecqtubrfhwzbuiorawbnrmlazbzekngllgsfrazmiidanjwzfuncaqbreohtictunizjrxiegukvttetamkxmnfwtnmztgebyiftgya";
//        SubSequencePrinter.printSubSequences(text, 7);
//        String text = "bevqqfharxuhjcgszvulreljdfgywkpvtpgygnwtvqelnzkhzckhqthrfmhipgaytlgtzipvmnajncvkzjdhhyvnhhqbkmonxdpneanqpfncodkyasieyenznktepydxpduoncljbdxvqctcrrotbnwdaaydmixysfmizucskbykoaoksymscdzytnvaomqotoanswdjrmlwbfrxgabfgvufbrlrnkxhjccjctzbjbjqkjoogpsdonfkfftoiyrpfpuxztdpmeezoeqfrvxyafxgtkhcouehrjsvyfnfetvncdnnxjxsekxeodxupxyvioimpuxucsofmrdysixggpvimyrjfyofrtqdcarnxavmybahlixvnwilujfpmqyrmaytgedcocescdtznafpuagyfuqukefjxrzlzodqehyqsiyzrxpyazzaknkyjrmhfkiotpjbtkhhbzcxuxckkwbbnactcbubfhwvhqfkzrqiqoqlnecjhcpnnqlwwdbjswa"
//                + "qfkzrqiqoqlnecjhcpnnqlwwdbjswa";
//        ArrayList<Integer> indexes = new ArrayList<>();
//        double[] deltas3 = ic.allAggregateDeltaBarICs(text);
//        for (int i = 0; i < deltas3.length; i++) {
//            if (deltas3[i] > 1.40) {
//                System.out.print((i + 1) + " | ");
//                System.out.printf("%.2f %n", deltas3[i]);
//                indexes.add((i+1));
//            }
//            
//        }
//        
//        ArrayList<Integer> keyLens = new ArrayList<>();
//        ic.findKey(text, 2);
//        System.out.println(ic.getKeyCandidate());
//        GreatestCommonDivisor gcd = new GreatestCommonDivisor();
//        for (int i = 0; i < indexes.size(); i++) {
//            for (int j = i + 1; j < indexes.size(); j++) {
//                System.out.println(indexes.get(i) + " and " + indexes.get(j));
//                int common = gcd.euclidIterative(indexes.get(i), indexes.get(j));
//                System.out.println(common);
//                keyLens.add(common);
//            }
//        }
//        
//        for (int i = 0; i < keyLens.size(); i++) {
//            ic.findKey(text, keyLens.get(i));
//            System.out.println(ic.getKeyCandidate());
//        }
//        double[] vals = ic.allAggregateDeltaBarICs(text);
//        for (int i = 0; i < 10; i++) {
//            System.out.print((i + 1) + " | ");
//            System.out.println(vals[i]);
//        }
//        ic.findKey(text, 7);
//        System.out.println(ic.getKeyCandidate());
//        CharacterValue[][] charValues = ic.findKey(text, 7);
//        for (int j = 0; j < charValues[0].length; j++) {
//            for (int i = 0; i < charValues.length; i++) {
//                System.out.print(charValues[i][j].getCharacter() + " ");
//            }
//            System.out.println();
//        }
//        ArrayList<String> subs = new ArrayList<>();
//        subs.add("uxuomqbjxfqkgfqqmqafydujergeqgfqtyoudfrfxekkjqqeczuefgoqqtoqmxiyubfkxqfeabjuofqdzuuufaxauatefomkfdueuitmzf");
//        subs.add("neticrltahrplepxltroeipttarotrhreeonoatedtpsrnbeuastheixreisieimnhttssxpeltseaayisgthiibnrachrlnranoneentt");
//        subs.add("cuwrjqckecccctnvytovnpjhcnthvpgztupiwpjtuvvvgvcqgnvegprvupcupvvqvgjjgveqkcdktpnepjjjgvmgvstqwaaganchigtfgg");
//        subs.add("zbaosmpzluuyyphdhhlolalvuslalpshazauzjlebvhawzzmufvvmjoshhalaaoyoyhpzzvuupbzakzvlzaltplhldltzwzlzjatzuawey");
//        subs.add("qjqmmbvzlwlbtvqqgvlmbpzzkwvpzvmkmiicqmteoivpzmqnkanczgmmvamlmmbmmbvvcbzlbvbviiwuvwjziatxfptubbblmwqijkmtba");
//        subs.add("zfbegugrjgnvrgayffvfgrgvrpprrggvktvzafrbtpnnrgpelvvarbegqftckeukprnttuefuggbvniztkrbyhlygvrbunzgizbcrvkny");
//        subs.add("txrixiitmlrgxlxpfjreigirmgipxsxtxiriwsxyivpxwlyiewvxujxxxsypxwiwmbrikeixiilxrvispqijwrxedgwriresifrtxtxmi");
//        VigenereCipher vig = new VigenereCipher();
//        String abc = "abcdefghijklmnopqrstuvwxyz";
//        for (int i = 0; i < abc.length(); i++) {
//            long[] occurrences = freq.countOccurrences(vig.decrypt(abc.substring(i, i + 1), subT));
//            System.out.println(Arrays.toString(occurrences));
//        }
//        quad.
//        System.out.println(quad.getNgramCount("INGT"));
//        System.out.println(quad.getSampleSize());
//        System.out.println(quad.logProbability("INGT"));
//        System.out.println(6461147l / 4224127912l);
//        String text2 = "ATTACKTHEEASTWALLOFTHECASTLEATDAWN";
//        System.out.println(text2.length());
//        String ciphertext2 = "FYYFHPYMJJFXYBFQQTKYMJHFXYQJFYIFBS";
//        System.out.println(quad.fitness(text2));
//        System.out.println(quad.fitness(ciphertext2));
//        System.out.println(quad.getN());
//        
//        Quadgrams quad2 = new Quadgrams("test.txt");
//        System.out.println(quad2.getSampleSize());
//        System.out.println(quad2.getNgramCount("INGT"));
//        System.out.println(quad2.getNgramCount("MATT"));
//        System.out.println(quad2.fitness(text2));
//        System.out.println(quad.fitness(text2));
//        System.out.println(quad.fitness(ciphertext2));
//       
//        Combinatorics comib = new Combinatorics();
//        
//        int[] nums = new int[25];
//        nums[4] = 2;
//        System.out.println(nums.length);
//        System.out.println(nums[4]);
//        
//        nums = new int[0];
//        System.out.println(nums.length);
//        System.out.println(nums[4]);
//        TranspositionAttack attack = new TranspositionAttack();
//
//        String text1 = "evlnacdtesearofodeecwiree".toUpperCase();
//        String text2 = "evlnacdtesearofodeecwiree".toUpperCase();
//        String text3 = "evlnacdtesearofodeecwiree".toUpperCase();
//        String text4 = "evlnacdtesearofodeecwiree".toUpperCase();
//        String text5 = "evlnacdtesearofodeecwiree".toUpperCase();
//        String text6 = "evlnacdtesearofodeecwiree".toUpperCase();
//
//        long startTime = System.currentTimeMillis();
//        attack.attackShortKeyWordsPreGenerated(text1);
//        long endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//
//        startTime = System.currentTimeMillis();
//        attack.attackShortKeyWordsPreGenerated(text2);
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//
//        startTime = System.currentTimeMillis();
//        attack.attackShortKeyWordsPreGenerated(text3);
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//
//        startTime = System.currentTimeMillis();
//        attack.attackShortKeyWordsPreGenerated(text4);
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//
//        startTime = System.currentTimeMillis();
//        attack.attackShortKeyWordsPreGenerated(text5);
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//
//        startTime = System.currentTimeMillis();
//        attack.attackShortKeyWordsPreGenerated(text6);
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//        System.out.println(attack.crackWithKey(cand, text1));
//
//        startTime = System.currentTimeMillis();
//        String candi = attack.attackShortKeyWordsPreGenerated(text1);
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//
//        System.out.println(attack.crackWithKey(candi, text1));
//
//        String ciphertext = "QDBSSAGNTDOLLCSERUELAESTOSIOODDUYSANUFRISUIUHARRGAE"
//                + "MLULANORSARCROSMEPDVNUXVSTBCNAFNTIWUZUFIITEISDMOENSEYINUMDIAITACEEHECCC";
//        startTime = System.currentTimeMillis();
//        String cand2 = attack.attackShortKeyWordsPreGenerated(ciphertext);
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//        System.out.println(attack.crackWithKey(cand2, ciphertext));
//
//        String ciphertext1 = "NSTLEICYEMPMHELGOAAHVCOTBYAAAESEAWAMNERTATHOPFTMZDHAISAALITSUOOAZNSREMSEAVTLETYGUAEGREERNIUAKRNRPSMS";
//
//        startTime = System.currentTimeMillis();
//        String cand3 = attack.attackShortKeyWordsPreGenerated(ciphertext1);
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//        System.out.println(attack.crackWithKey(cand3, ciphertext1));
//        String text2 = "hmnrnvaicwhtsieiitoawguseint".toUpperCase();
//        String cand2 = attack.attackShortKeyWordsPreGenerated(text2);
//        System.out.println(attack.crackWithKey(cand2, text2));
//        int[] table = new int[]{0, 2, 1, 4};
//        byte x = 1;
//        System.out.println(table[x]);
//
//        int[] table2 = table;
//        System.out.println(table2.length);
//        
//        HashTable ht = new HashTable();
//        int n = 5;
//        long[] times = new long[n];
//
//        long startTime = System.currentTimeMillis();
//        Quadgrams quad1 = new Quadgrams("english_quadgrams.txt");
//        long endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//        times[0] = endTime - startTime;
//
//        long sum = 0;
//        int count = 0;
//        int longest = 0;
//        for (int i = 0; i < quad1.ngramStats.hashtable.length; i++) {
//            if (quad1.ngramStats.hashtable[i] != null) {
//                int l = quad1.ngramStats.hashtable[i].getSize();
//                if (l > longest) {
//                    longest = l;
//                }
//                sum += l;
//                count++;
//            }
//        }
//
//        System.out.println("Longest: " + longest);
//        System.out.println(sum);
//        System.out.println(count);
//        System.out.println((double) sum / count);
//        startTime = System.currentTimeMillis();
//        Quadgrams quad2 = new Quadgrams("english_quadgrams.txt");
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//        times[1] = endTime - startTime;
//
//        startTime = System.currentTimeMillis();
//        Quadgrams quad3 = new Quadgrams("english_quadgrams.txt");
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//        times[2] = endTime - startTime;
//
//        startTime = System.currentTimeMillis();
//        Quadgrams quad4 = new Quadgrams("english_quadgrams.txt");
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//        times[3] = endTime - startTime;
//
//        startTime = System.currentTimeMillis();
//        Quadgrams quad5 = new Quadgrams("english_quadgrams.txt");
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//        times[4] = endTime - startTime;
//
//        double avg = 0;
//        for (int i = 0; i < n; i++) {
//            avg += (double) times[i] / n;
//        }
//
//        System.out.println(avg + " ms");
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
     * Very crude code with very little refactoring that simply replicates all
     * elements even though some could be reused, and this most likely will be
     * done in the future.
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Vigenere
        Label vigLabel = new Label("Vigenere cipher");
        TextArea vigText = new TextArea();
        vigText.setPromptText("Enter plaintext/ciphertext");
        vigText.setWrapText(true);
        Label vigKeyLabel = new Label("Encryption/Decryption key");
        TextField vigKey = new TextField();
        vigKey.setPromptText("Enter key");

        Button encrypt1 = new Button("Encrypt");
        Button decrypt1 = new Button("Decrypt");
        Button clear1 = new Button("Clear");

        HBox hbox1 = createButtonBox(new Node[]{encrypt1, decrypt1, clear1});
        VBox vigL = createLeftBox(new Node[]{vigLabel, vigText, hbox1});
        VBox vigR = createRightBox(new Node[]{vigKeyLabel, vigKey});

        // Keyed Vigenere
        Label keyedVigLabel = new Label("Keyed Vigenere cipher");
        TextArea keyedVigText = new TextArea();
        keyedVigText.setPromptText("Enter plaintext/ciphertext");
        keyedVigText.setWrapText(true);
        Label alphabetKeyLabel = new Label("Alphabet key");
        TextField alphabetKey = new TextField();
        alphabetKey.setPromptText("Enter alphabet key");
        Label keyedVigKeyLabel = new Label("Encryption/Decryption key");
        TextField keyedVigKey = new TextField();
        keyedVigKey.setPromptText("Enter key");

        Button encrypt2 = new Button("Encrypt");
        Button decrypt2 = new Button("Decrypt");
        Button clear2 = new Button("Clear");

        HBox hbox2 = createButtonBox(new Node[]{encrypt2, decrypt2, clear2});
        VBox keyedL = createLeftBox(new Node[]{keyedVigLabel, keyedVigText, hbox2});
        VBox keyedR = createRightBox(new Node[]{alphabetKeyLabel, alphabetKey, keyedVigKeyLabel, keyedVigKey});

        // Autokey Vigenere
        Label autokeyLabel = new Label("Autokey Vigenere cipher");
        TextArea autokeyVigText = new TextArea();
        autokeyVigText.setPromptText("Enter plaintext/ciphertext");
        autokeyVigText.setWrapText(true);
        Label primerLabel = new Label("Primer key");
        TextField primer = new TextField();
        primer.setPromptText("Enter primer key");

        Button encrypt3 = new Button("Encrypt");
        Button decrypt3 = new Button("Decrypt");
        Button clear3 = new Button("Clear");

        HBox hbox3 = createButtonBox(new Node[]{encrypt3, decrypt3, clear3});
        VBox autokeyL = createLeftBox(new Node[]{autokeyLabel, autokeyVigText, hbox3});
        VBox autokeyR = createRightBox(new Node[]{primerLabel, primer});

        // Single transposition
        Label singleTrLabel = new Label("Single columnar transposition cipher");
        TextArea singleTranspositionText = new TextArea();
        singleTranspositionText.setPromptText("Enter plaintext/ciphertext");
        singleTranspositionText.setWrapText(true);
        Label transpositionKeyLabel = new Label("Encryption/Decryption key");
        TextField transpositionKey = new TextField();
        transpositionKey.setPromptText("Enter key");

        Button encrypt4 = new Button("Encrypt");
        Button decrypt4 = new Button("Decrypt");
        Button clear4 = new Button("Clear");

        HBox hbox4 = createButtonBox(new Node[]{encrypt4, decrypt4, clear4});
        VBox transpL = createLeftBox(new Node[]{singleTrLabel, singleTranspositionText, hbox4});
        VBox transpR = createRightBox(new Node[]{transpositionKeyLabel, transpositionKey});

        // Double transposition
        Label doubleTrLabel = new Label("Double columnar transposition cipher");
        TextArea doubleTranspositionText = new TextArea();
        doubleTranspositionText.setPromptText("Enter plaintext/ciphertext");
        doubleTranspositionText.setWrapText(true);
        Label key1Label = new Label("First encryption/decryption key");
        TextField transpositionKey1 = new TextField();
        transpositionKey1.setPromptText("Enter first key");
        Label key2Label = new Label("Second encryption/decryption key");
        TextField transpositionKey2 = new TextField();
        transpositionKey2.setPromptText("Enter second key");

        Button encrypt5 = new Button("Encrypt");
        Button decrypt5 = new Button("Decrypt");
        Button clear5 = new Button("Clear");

        HBox hbox5 = createButtonBox(new Node[]{encrypt5, decrypt5, clear5});
        VBox dTranspL = createLeftBox(new Node[]{doubleTrLabel, doubleTranspositionText, hbox5});
        VBox dTranspR = createRightBox(new Node[]{key1Label, transpositionKey1, key2Label, transpositionKey2});

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

        BorderPane cipherView = new BorderPane();
        Scene cipherScene = new Scene(cipherView, 800, 640);
        Button mainMenu = new Button("Main menu");
        cipherView.setBottom(mainMenu);

        vigCipher.setOnMouseClicked((event) -> {
            cipherView.setLeft(vigL);
            cipherView.setRight(vigR);
            stage.setScene(cipherScene);

        });

        keyedVigCipher.setOnMouseClicked((event) -> {
            cipherView.setLeft(keyedL);
            cipherView.setRight(keyedR);
            stage.setScene(cipherScene);
        });

        autokeyVigCipher.setOnMouseClicked((event) -> {
            cipherView.setLeft(autokeyL);
            cipherView.setRight(autokeyR);
            stage.setScene(cipherScene);
        });

        singleTranspositionCipher.setOnMouseClicked((event) -> {
            cipherView.setLeft(transpL);
            cipherView.setRight(transpR);
            stage.setScene(cipherScene);
        });

        doubleTranspositionCipher.setOnMouseClicked((event) -> {
            cipherView.setLeft(dTranspL);
            cipherView.setRight(dTranspR);
            stage.setScene(cipherScene);
        });

        // Cryptanalysis menu
        VBox cryptanalysisMenu = new VBox();
        Label cracking = new Label("Cryptanalysis:");
        cracking.setFont(new Font("Comic Sans MS", 16));
        Button attackVigenere = new Button("Attack Vigenere cipher");
        Button attackSingleTransposition = new Button("Attack single transposition cipher");
        cryptanalysisMenu.getChildren().addAll(cracking, attackVigenere, attackSingleTransposition);
        cryptanalysisMenu.setSpacing(20);

        attackVigenere.setOnMouseClicked((event) -> {

        });

        attackSingleTransposition.setOnMouseClicked((event) -> {

        });

        Label welcome = new Label("Choose Ciphers for encryption/decryption or Cryptanalysis to analyze ciphertext");
        welcome.setFont(new Font("Comic Sans MS", 20));
        welcome.setPadding(new Insets(11));

        BorderPane menu = new BorderPane();
        menu.setTop(welcome);
        menu.setLeft(ciphersMenu);
        menu.setRight(cryptanalysisMenu);

        Scene menuScene = new Scene(menu, 800, 640);

        mainMenu.setOnMouseClicked((event) -> {
            stage.setScene(menuScene);
        });

        stage.setTitle("CryptoApp");
        stage.setScene(menuScene);
        stage.show();
    }

    private VBox createLeftBox(Node[] nodes) {
        VBox vboxLeft = new VBox();
        for (Node node : nodes) {
            vboxLeft.getChildren().add(node);
        }

        return vboxLeft;
    }

    private VBox createRightBox(Node[] nodes) {
        VBox vboxRight = new VBox();
        for (Node node : nodes) {
            vboxRight.getChildren().add(node);
        }

        return vboxRight;
    }

    private HBox createButtonBox(Node[] nodes) {
        HBox hbox = new HBox();
        hbox.setSpacing(5);
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
