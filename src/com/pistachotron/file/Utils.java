package com.pistachotron.file;


import com.pistachotron.Main;
import com.pistachotron.debug.Log;

import java.io.InputStream;
import java.util.Scanner;

public class Utils {

    /*
    * Utils.java
    * Mainly for loading files at [X] location
    *
    *
    *
    *
     */
    public static String loadResource(String fileName) throws Exception {
        Log.debug("Loading File: "+fileName);
        String result;
        try (InputStream in = Utils.class.getResourceAsStream(fileName);
             Scanner scanner = new Scanner(in, java.nio.charset.StandardCharsets.UTF_8.name())) {
            result = scanner.useDelimiter("\\A").next();
        }
        Log.debug("File Loaded: "+result);
        return result;

    }

    public static String getPath(String item){
        return Main.RESOURCES_LOCATION+item;
    }

}