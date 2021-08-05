package com.pistachotron;

public class TranslationManager {
    public static TranslationManager INSTANCE = new TranslationManager();
    public String fileloc = "m.json";

    public TranslationManager() {

    }

    public String getTranslation(String language, String key) {
        if (language == "en") return "figure it out yourself";
        else return "traduisez-le vous-même";
    }
}
