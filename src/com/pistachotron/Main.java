package com.pistachotron;

import com.pistachotron.client.ClientGame;
import com.pistachotron.debug.Log;
import com.pistachotron.server.Server;
import com.pistachotron.text.TranslationManager;

//import org.lwjgl.
public class Main {
    public static String RESOURCES_LOCATION="src/resources/";
    private static TranslationManager translationManager = TranslationManager.INSTANCE;

    public static void main(String[] args) {
        //System.out.println("Initialisation du Pistachotron...");
        Log.debug("Starting The Almighty Pistachotron");
        // TranslationManager E=new TranslationManager();
        //System.
        int portNum=4431;
        Server SERVER=new Server(portNum);
       // SERVER.start(portNum);
        SERVER.startServer();
        ClientGame CLIENT=new ClientGame();
        CLIENT.run();

        Log.debug("Thanks For Using The Pistachotron");
        //System.out.println("Le Pistachotron n'a pas grand-chose à faire.");
    }
}
