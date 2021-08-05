package com.pistachotron;

public class TranslationManager {
    public static TranslationManager INSTANCE=new TranslationManager();
    public String fileloc="m";
    public TranslationManager(){

    }

    public String getTranslation(String language, String key){
        return "something";
    }
}
