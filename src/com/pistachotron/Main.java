package com.pistachotron;

import com.pistachotron.client.ClientGame;
import com.pistachotron.text.TranslationManager;

//import org.lwjgl.
public class Main {
    public static String RESOURCES_LOCATION="src/resources/";
    private static TranslationManager translationManager = TranslationManager.INSTANCE;

    public static void main(String[] args) {
        System.out.println("Initialisation du Pistachotron...");
        // TranslationManager E=new TranslationManager();
        //System.
        new ClientGame().run();
        System.out.println("Le Pistachotron n'a pas grand-chose à faire.");
    }
}
