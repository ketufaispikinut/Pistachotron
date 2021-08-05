package com.pistachotron;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TranslationManager {
    public static TranslationManager INSTANCE=new TranslationManager();
    public String fileloc="translation/";
    private String en;
    private String fr;
    public TranslationManager(){
        readFile();
    }
    private void readFile(){
        try {
            File myObj = new File(fileloc+"en.json");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                en+=data;
                //System.out.println(data);
            }
            myReader.close();
            System.out.println("en: "+en);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void getTranslation(String language, String key){

    }
}
