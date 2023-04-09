
/**
 * Langauge Analyzer is a program that preforms basic
 * algorithmic analysis of an English texual passage.
 * @author C. Culbertson & the U-High APCS class of 2022
 * @version 1.5
 * 
 * new in v1.5:
 *     fixed uncommonWords bug that always returned 1.0
 *     fixed pronoun methods to not count pronouns buried in other words
 *     updated menu
 *     fixed passive voice score      
 * known bugs:
 *     countSyllables("the") returns 0
 *     countSentences returns one higher than it should
 *     inefficiencies in repeatedly counting words 
 *  
 * new in v1.4:
 *     fixed countSingularProcouns and countPluralPronouns
 * known bugs: 
 *     emotionWordScore output does not use newline correctly
 * 
 * new in v1.3: 
 *     updates to runMenu, emotionWordScore, countSyllables, and getNthWord
 *     changed uncommonWordScore to return percentage of words that are "uncommon" to better match with emotionWordScore
 * known bugs: 
 *     passiveVoiceScore always returns -1
 *     countSingularProcouns and countPluralPronouns always return -1
 * 
 * new in v1.2: 
 *     many now-completed methods
 * 
 * new in v1.1: 
 *     readFileIntoArray method
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
// import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("resource")
public class LanguageAnalyzer {
    // static String[] wordArray;

    public static void main(String[] args) {
        runMenu();
    }
    
    /**
     * Creates a menu system using Scanner
     * that allows a user to type in a filename with
     * text to be analyzed and then select from multiple
     * analysis tools. It runs the chosen tool and displays
     * any results.
     * 
     * authors: Ella & Seth
     * 
     */
    public static void runMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello user! Please select the file you want to analyze.");
        String filename = getFilePath();
        System.out.println("Opening: " + filename + "\n");
        String words = readFileIntoString(filename);
        // String[] wordArray = toWordArray(words);
        // System.out.println(Arrays.toString(wordArray));
        String response = "";
        while (response.equals("") || response.charAt(0) < 'd') {
            System.out.println("What would you like to analyze? Please type the number.");
            System.out.println("1. Flesh-Kincad reading difficulty");
            System.out.println("2. Flesch-Kincaid grade level");
            System.out.println("3. Number of words");
            System.out.println("4. Passive voice score");
            System.out.println("5. Number of singular pronouns");
            System.out.println("6. Number of plural pronouns");
            System.out.println("7. Emotion word score");
            System.out.println("8. Uncommon word score");
            System.out.println("If you no longer wish to analyze the text, please type done.\n");
            response = in.nextLine();
            if (response.equals("1")) {
                System.out.println("Reading difficulty: " + calcReadingDifficulty(words) + "\n");
            } else if (response.equals("2")) {
                System.out.println("Grade Level: " + calcGradeLevel(words) + "\n");
            } else if (response.equals("3")) {
                System.out.println("Word count: " + countWords(words) + "\n");
            } else if (response.equals("4")) {
                System.out.println("Passive word score: " + passiveVoiceScore(words) + "\n");
            } else if (response.equals("5")) {
                System.out.println("Number of singular pronouns: " + countSingluarPronouns(words) + "\n");
            } else if (response.equals("6")) {
                System.out.println("Number of plural pronouns: " + countPluralPronouns(words) + "\n");
            } else if (response.equals("7")) {
                System.out.println(emotionWordScore(words) + "\n");
            } else if (response.equals("8")) {
                System.out.println("Uncommon word score: " + uncommonWordScore(words) + "\n");
            } else if (response.equals("done")) {
                System.out.println("Thank you!");
                break;
            } else {
                System.out.println("Incorrect entry. Please retype.");
                // response = in.nextLine();
            }
        }
    }

    public static String[] toWordArray(String str){
        str = expandAbbreviations(str);
        str = removeSpecialChars(str);
        str = str.toLowerCase();
        str = str.replace(".","");
        int len = countWords(str);
        String[] arr = new String[len+10];
        int wordStart = 0;
        int index = 0;
        for(int i = 0; i < str.length()-1; i++){ 
            if( str.charAt(i) == ' '){
                arr[index] = str.substring(wordStart, i);
                wordStart = i+1;
                index++;
            }   
        }
        arr[index] = str.substring(wordStart, str.length());
        return arr;
    }

    /**
     * Removes special characters froma a string.
     * Characters that are letters, numbers, or periods are
     * left unchanged. Any sequence of spaces is converted
     * to one single spaces. All other characters are removed.
     * 
     * @param str the string to be processes
     * @return the same string without the indicated special characters
     * 
     *         authors: Claire & NayNay
     */
    public static String removeSpecialChars(String str) {
        String noSpecialCharsStr = "";
        int numOfSpaces = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char charOfStr = str.charAt(i);
            if (charOfStr == '.' || charOfStr == '?' || charOfStr == '!') {
                noSpecialCharsStr += '.';
            } else if (charOfStr >= '0' && charOfStr <= '9') {
                noSpecialCharsStr += charOfStr;
            } else if (charOfStr >= 'A' && charOfStr <= 'Z') {
                noSpecialCharsStr += charOfStr;
            } else if (charOfStr >= 'a' && charOfStr <= 'z') {
                noSpecialCharsStr += charOfStr;
            } else if (charOfStr == ' ') {
                numOfSpaces++;
            }

            if (charOfStr == ' ' && numOfSpaces == 1 && i != 0) {
                noSpecialCharsStr += str.charAt(i);
            } else if (charOfStr != ' ' && numOfSpaces >= 1) {
                numOfSpaces = 0;
            }
        }
        return noSpecialCharsStr;
    }

    /**
     * Converts common abbreviations into their
     * expanded form. For example, "a.m." is replaced with "am"
     * The abbreviations "Mrs." and "Ms." are replaced with the
     * same text without a period.
     * All other characters remain unchanged.
     * 
     * @param str the string to be processes
     * @return the same string with common abbreviations expanded
     * 
     */
    public static String expandAbbreviations(String str) {
        str.replace("a.m.", "am");
        str.replace("p.m.", "pm");
        str.replace("Mr.", "Mister");
        str.replace("Ms.", "Ms");
        str.replace("Mrs.", "Mrs");
        str.replace("Dr.", "Doctor");
        str.replace("Gov.", "Governor");
        str.replace("Sen.", "Senator");
        str.replace("Rep.", "Representative");
        str.replace("Lt.", "Lieutenant");
        str.replace("Cpt.", "Captain");
        str.replace("Sr.", "Senior");
        str.replace("Jr.", "Junior");
        str.replace("St.", "Saint");
        str.replace("etc.", "et cetera");
        str.replace("i.e.", "ie");
        str.replace("e.g.", "eg");
        str.replace("re:", "regarding");
        str.replace("...", ".");
        str.replace("Jan.", "January");
        str.replace("Feb.", "February");
        str.replace("Mar.", "March");
        str.replace("Apr.", "April");
        str.replace("Jun.", "June");
        str.replace("Jul.", "July");
        str.replace("Aug.", "August");
        str.replace("Sep.", "September");
        str.replace("Sept.", "September");
        str.replace("Oct.", "October");
        str.replace("Nov.", "November");
        str.replace("Dec.", "December");
        str.replace("Rd.", "Road");
        str.replace("Ave.", "Avenue");
        str.replace("U.S.", "United States");
        str.replace("U.N.", "United Nations");
        return str;
    }

    /**
     * Returns the nth word from a string, where
     * the 0th word is defined as all characters before the
     * first space, the 1st word is all characters between
     * the first and second spaces, etc.
     * Duplicate spaces may cause this method to return an
     * empty string.
     * If there are not n words in the string, the method will
     * return null.
     * 
     * @param str the string to be processes
     * @param n   the index of the word to return, starting from 0
     * @return the nth word of the string, or null if there are not n words
     * 
     *         authors: Mason & Mitchell
     */
    public static String getNthWord(String str, int n) {
    //     return wordArray[n];
    // }
        str = expandAbbreviations(str);
        str = removeSpecialChars(str);
        str = str.replace(".", "");
        str = " " + str;
        int spaceCount = -2;
        int index = 0;
        int startingPoint = 0;
        int prevStartingPoint = 0;
        while (index != -1) {
            index = str.indexOf(' ', startingPoint);
            spaceCount++;
            if(spaceCount == n){
                return str.substring(prevStartingPoint, startingPoint-1);
            }
            prevStartingPoint = startingPoint;
            startingPoint = index + 1;
        }
        return null;
    }

    /**
     * Returns the number of sentences in a string, defined
     * as the number of periods. Abbreviations and decimals
     * may cuase this method to return an incorrect value.
     * 
     * @param str the string to be processed
     * @return the number of sentences in the string
     * 
     *         authors: Pierce & Zach
     */
    public static int countSentences(String str) {
        str = removeSpecialChars(str);
        str = expandAbbreviations(str);
        int period = 0;
        int index = 0;
        int startingPoint = 0;
        while (index != -1) {
            index = str.indexOf('.', startingPoint);
            startingPoint = index + 1;
            if (index == str.length() - 1) {
                period++;
                index = -1;
            } else if (str.charAt(index + 1) < '0' || str.charAt(index + 1) > '9') {
                period++;
            }
        }
        return period;
    }

    /**
     * Returns the number of words in a string, defined
     * as the number of spaces + 1. Duplicate spaces may
     * cause this method to return an incorrect value.
     * 
     * @param str the string to be processed
     * @return the number of words in the string
     * 
     *         authors: Brandt & Michael
     */
    public static int countWords(String str) {
        str = removeSpecialChars(str);
        int spaceCount = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                spaceCount++;
            }
        }
        return spaceCount + 1;
    }
    // public static int countWords(String str) {
    //     str = removeSpecialChars(str);
    //     int spaceCount = 0;
    //     int index = 0;
    //     int startingPoint = 0;
    //     while (index != -1 && index < str.length() - 1) {
    //         index = str.indexOf(' ', startingPoint);
    //         startingPoint = index + 1;
    //         spaceCount++;
    //     }
    //     return spaceCount;
    // }

    /**
     * Returns an estimate of the number of syllables in a string
     * according to published syllable estimation algorithms.
     * Precondition: the string represents a single English word without
     * spaces or punctutaion.
     * 
     * @param str the word to be processed
     * @return the number of syllables in the word
     * 
     *         authors: Max & Henry S.
     */
    public static int countSyllables(String word) {
        // http://english.glendale.cc.ca.us/phonics.rules.html

        word = word.toLowerCase();

        // initialize vars to hold the total count of vowels and whether the last letter
        // checked was a vowel
        int vowels = 0;
        boolean isLastVowel = false;

        // Count Vowels | loop though all of the chars in the string
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            // if it is a vowel and the last letter wasn't a vowel, then add 1;
            // This is so that 2 vowels in succession don't count, as per the rules
            if (isVowel(c) && !isLastVowel) {
                isLastVowel = true;
                vowels++;
            } else if (!isVowel(c)) {
                // This means that this isn't a vowel
                isLastVowel = false;
            }
        }

        final int EXCEPTION_CHECK_LENGTH = 3;
        // If it's shorter than all of the exceptions below require
        if (word.length() < EXCEPTION_CHECK_LENGTH) {
            // There aren't any significant words that need to be check for exceptions if
            // it's 1 or 2 chars long
            return vowels;
        }

        int end = word.length() - 1;
        char lastLetter = word.charAt(end);
        char secondToLastLetter = word.charAt(end - 1);
        char thirdToLastLetter = word.charAt(end - 2);

        // EXCEPTION HANDLING!

        // if the last letter is 'e', but the 2nd to last letter ISN'T 'l'
        if (lastLetter == 'e' && secondToLastLetter != 'l') {
            vowels--;
        }

        // if the the last 3 letters are a vowel + le.
        else if (lastLetter == 'e' && secondToLastLetter == 'l' && isVowel(thirdToLastLetter)) {
            vowels--;
        }

        // Otherwise don't modify
        return vowels;
    }

    /**
     * Helper method to find if a char is a vowel; used by the countSyllables method
     */
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y';
    }

    /**
     * Calculates the Flesch-Kincaid reading difficulty
     * of a string passage.
     * Precondition: the string contains an English text passage of
     * at least four complete sentences.
     * 
     * @param str the passage
     * @return the Flesh-Kincaid Reading Difficulty score
     * 
     *         authors: Erin & Abhay
     */
    public static double calcReadingDifficulty(String str) {
        str = expandAbbreviations(str);
        str = removeSpecialChars(str);

        final double CONSTANT1 = 206.835;
        final double CONSTANT2 = 1.015;
        final double CONSTANT3 = 84.6;
        double totalSyllables = 0;
        
        double totalWords = countWords(str);
        System.out.println("Total words:" + totalWords);
        double totalSentences = countSentences(str);
        System.out.println("Total sentences:" + totalSentences);

        for (int i = 0; i < totalWords; i++) {
            String x = getNthWord(str, i);
            totalSyllables += countSyllables(x);
            System.out.println(countSyllables(x) + " syllables in " + x);
        }

        double difficultyFormulaP1 = (CONSTANT1 - CONSTANT2 *(totalWords / totalSentences));
        double difficultyFormulaP2 = (CONSTANT3 * (totalSyllables / totalWords));

        return difficultyFormulaP1 - difficultyFormulaP2;
    }

    /**
     * Calculates the Flesch-Kincaid grade level estimate
     * of a string passage.
     * Precondition: the string contains an English text passage of
     * at least four complete sentences.
     * 
     * @param str the passage
     * @return the Flesh-Kincaid grade level estimate
     * 
     *         authors: Elise & Vivaan
     **/
    public static double calcGradeLevel(String str) {
        str = expandAbbreviations(str);
        str = removeSpecialChars(str);

        double totalWords = countWords(str);
        double totalSentences = countSentences(str);
        int totalSyllables = 0;

        for (int i = 0; i < totalWords; i++) {
            totalSyllables += countSyllables(getNthWord(str, i));
        }

        double sOne = totalWords / totalSentences;
        double sTwo = totalSyllables / totalWords;
        double last = (.39 * sOne) + (11.8 * sTwo) - 15.59;
        return last;

    }

    /**
     * Calculates the number of passive verbs in
     * a string, divided by the number of sentences.
     * This value can give an indication of the frequency
     * of passive voice in a text passage.
     * Passive verbs are defined as any word ending in "ed" or
     * "en" that is preceded by "is", "are", "was", "were", "has",
     * "have", "had", "be", "been", or "not".
     * 
     * @param str the string to be processed
     * @return the number of passive verbs divided by the number of sentences
     * 
     *         = D. & Shivang
     */
    public static double passiveVoiceScore(String str) {
        int passiveVerbCount = 0;
        str = str.replace(".", " ");
        str = removeSpecialChars(str);
        int numWords = countWords(str);
        for (int i = 0; i < numWords; i++) {
            boolean helperVerbFound = false;
            String curWord = getNthWord(str, i);
            String nextWord = getNthWord(str, i + 1);
            if (curWord.equals("is")) {
                helperVerbFound = true;
            } else if (curWord.equals("are")) {
                helperVerbFound = true;
            } else if (curWord.equals("was")) {
                helperVerbFound = true;
            } else if (curWord.equals("were")) {
                helperVerbFound = true;
            } else if (curWord.equals("has")) {
                helperVerbFound = true;
            } else if (curWord.equals("have")) {
                helperVerbFound = true;
            } else if (curWord.equals("had")) {
                helperVerbFound = true;
            } else if (curWord.equals("be")) {
                helperVerbFound = true;
            } else if (curWord.equals("been")) {
                helperVerbFound = true;
            } else if (curWord.equals("not")) {
                helperVerbFound = true;
            }
            if (helperVerbFound && nextWord.length() >= 2) {
                String suffixStr = nextWord.substring(nextWord.length() - 2);
                if (suffixStr.equals("ed") || suffixStr.equals("en")) {
                    // next word is a participle
                    passiveVerbCount++;
                }
            }
        }
        return ((double) passiveVerbCount / countSentences(str));
    }

    /**
     * Calculates the number of uncommon words in
     * a string, divided by the number of words.
     * This value gives an indication of the frequency
     * of uncommon words in a text passage.
     * Uncommon words are defined as any word not appearing in
     * Google's list of 1000 most common words.
     * 
     * @param str the string to be processed
     * @return the number of uncommon words divided by the number of words
     * 
     *         authors: Pearl & Isaiah
     */
    public static double uncommonWordScore(String str) {
        str = str.toLowerCase();
        double uncommon = 0;
        String commonWords = readFileIntoString("common1000Words.txt");

        for (int i = 0; i < countWords(str); i++) {
            String sWord = getNthWord(str, i);
            if (commonWords.indexOf(sWord) == -1) {
                uncommon++;
            }
        }
        double avg = uncommon / countWords(str);
        return avg;

    }

    /**
     * Calculates and displays the number of strong positive
     * and strong negative emotion words in a string, divided by
     * the total number of words. Each emotion word is counted
     * only once, even if it appears multiple times in the string.
     * 
     * Strong emotion words are those included in the NRC Emotion
     * Lexicon. Strong positive emotion words are those labeled as
     * "anticipation", "joy", or "trust"
     * Strong negative emotion words are those labeled as
     * "anger", "disgust", "fear" or "sadness"
     * 
     * @param str the string to be processed
     * @return a string containing a summary of the results
     * 
     *         authors: Emma & Angeline
     */
    public static String emotionWordScore(String str) {
        int anticipationScore = 0;
        int joyScore = 0;
        int trustScore = 0;
        int angerScore = 0;
        int disgustScore = 0;
        int fearScore = 0;
        int sadnessScore = 0;

        anticipationScore = individualScore("NRCanticipation.txt", anticipationScore, str);
        joyScore = individualScore("NRCjoy.txt", joyScore, str);
        trustScore = individualScore("NRCtrust.txt", trustScore, str);
        angerScore = individualScore("NRCanger.txt", angerScore, str);
        disgustScore = individualScore("NRCdisgust.txt", disgustScore, str);
        fearScore = individualScore("NRCfear.txt", fearScore, str);
        sadnessScore = individualScore("NRCsadness.txt", sadnessScore, str);

        double positiveScore = joyScore + trustScore + anticipationScore;
        double negativeScore = angerScore + disgustScore + fearScore + sadnessScore;

        int totalWords = countWords(str);

        double positiveWordPercent = (positiveScore / totalWords) * 100;
        double negativeWordPercent = (negativeScore / totalWords) * 100;

        String summary = "percentage of positive emotion words: " + positiveWordPercent
                + "\n percentage of negative emotion words: " + negativeWordPercent;

        return summary;
    }

    /**
     * Helper method for emotionWordScore: counts occurences of words from one file
     * 
     * @param emotionFile
     * @param scoreCount
     * @param str
     * @return
     */
    public static int individualScore(String emotionFile, int scoreCount, String str) {
        String[] array = readFileIntoArray(emotionFile);
        for (int word = 0; word < array.length; word++) {
            if (str.indexOf(array[word]) != -1) {
                scoreCount++;
            }
        }
        return scoreCount;
    }

    /**
     * Counts the number of singular personal pronouns in a string,
     * specifically "I", "you", "he", "she", "me", "him",
     * "her", "my", "your", "his", "hers", "mine", "yours"
     * 
     * @param text the string to be processed
     * @return the number of singular personal pronouns in the string
     * 
     *         authors: Bryce & Shawn
     */
    public static int countSingluarPronouns(String text) {
        text = removeSpecialChars(text.toLowerCase());
        text = text.replace(".", " ");
        text = " " + text;
        int totalPro = countOccurrences(text, " i ");
        totalPro += countOccurrences(text, " you ");
        totalPro += countOccurrences(text, " he ");
        totalPro += countOccurrences(text, " she ");
        totalPro += countOccurrences(text, " me ");
        totalPro += countOccurrences(text, " him ");
        totalPro += countOccurrences(text, " her ");
        totalPro += countOccurrences(text, " my ");
        totalPro += countOccurrences(text, " your ");
        totalPro += countOccurrences(text, " his ");
        totalPro += countOccurrences(text, " hers ");
        totalPro += countOccurrences(text, " mine ");
        totalPro += countOccurrences(text, " yours ");
        return totalPro;
    }

    public static int countOccurrences(String str, String target) {
        int searchLoc = 0;
        int count = 0;
        while (str.indexOf(target, searchLoc) != -1) {
            count++;
            searchLoc = str.indexOf(target, searchLoc) + 1;
        }
        return count;
    }

    /**
     * Counts the number of plural personal pronouns in a string,
     * specifically "we", "they", "us", "them", "our",
     * "their", "ours", "theirs"
     * 
     * @param text the string to be processed
     * @return the number of plural personal pronouns in the string
     * 
     *         authors: Bryce & Shawn
     */
    public static int countPluralPronouns(String text) {
        text = removeSpecialChars(text.toLowerCase());
        text = text.replace(".", " ");
        text = " " + text;
        int totalPro = countOccurrences(text, " we ");
        totalPro += countOccurrences(text, " they ");
        totalPro += countOccurrences(text, " us ");
        totalPro += countOccurrences(text, " them ");
        totalPro += countOccurrences(text, " our ");
        totalPro += countOccurrences(text, " their ");
        totalPro += countOccurrences(text, "ours");
        totalPro += countOccurrences(text, " theirs ");
        return totalPro;
    }

    /**
     * Reads the specified file into a string. Any newline characters
     * in the original file are copied into the string.
     * 
     * @param filename the file to be read including extension
     * @return a string containing the complete contents of the file.
     * @throws FileNotFoundException
     */
    public static String readFileIntoString(String filename) {
        String contents = "";
        try (Scanner fileIn = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (fileIn.hasNext()) {
                String line = fileIn.nextLine();
                contents += line;
                contents += "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return contents;
    }

    /**
     * Reads the specified file into an array. Each line of the file
     * becomes a new element in the array.
     * 
     * @param filename the file to be read including extension
     * @return a string containing an array of file lines.
     * @throws FileNotFoundException
     */
    public static String[] readFileIntoArray(String filename) {
        ArrayList<String> contents = new ArrayList<String>();
        try (Scanner fileIn = new Scanner(new File(filename))) {
            while (fileIn.hasNext()) {
                String line = fileIn.nextLine();
                contents.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return contents.toArray(new String[0]);
    }

    public static String getFilePath() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        // crete file chooser dialog
        JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fc.setDialogTitle("Select a text file to open");

        // allow only .txt files to be chosen
        fc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("text files", "txt");
        fc.addChoosableFileFilter(filter);

        // read and return user selection
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
}