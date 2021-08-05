package com.pistachotron;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TranslationManager {
    public static TranslationManager INSTANCE = new TranslationManager();
    public String fileloc = Main.RESOURCES_LOCATION+"translation/";
    private String en;
    private String fr;
    private JSONParser Parser=new JSONParser();

    public TranslationManager() {
        readFile();
    }

    private void readFile() {
        System.err.println("Popsicle au lagopède !");
        try {
            en="";
            File myObj = new File(fileloc + "en.json");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                en += data;
                // System.out.println(data);
            }
            myReader.close();
            System.out.println("en: " + en);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            fr="";
            File myObj = new File(fileloc + "fr.json");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                fr += data;
                // System.out.println(data);
            }
            myReader.close();
            System.out.println("fr: " +fr);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String test=getTranslation("en","block.default");
        System.out.println("Test: "+test);
    }

    public String getTranslation(String language, String key) {
        try {
            Object obj = null;
                    if(language=="en"){
                        obj=Parser.parse(en);
                    }
                    else{
                        Parser.parse(fr);
                    }
            JSONObject JsonObject=(JSONObject) obj;
            return (String) JsonObject.get(key);

        }
        catch(ParseException e){
            return key;//"Erreur!";
        }

    }
}
