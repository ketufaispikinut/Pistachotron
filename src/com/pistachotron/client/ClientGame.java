package com.pistachotron.client;
import com.pistachotron.client.render.Render;
import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import javax.swing.*;
import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;
import java.net.*;
import java.io.*;
public class ClientGame{
    private Render renderer=new Render();
    private Window window=new Window();
    public boolean running=true;

    public ClientGame(){

    }
    public void run() {
        try {
            init();
            gameLoop();
        } catch (Exception excp) {
            excp.printStackTrace();
        } finally {
            cleanup();
        }
    }

    private void cleanup() {
    }
    private void init(){
        //renderer.run();
        window.Init();

        try {
            renderer.init();
        }
        catch(Exception e){
            System.err.println(e.toString());
        }

    }
    private void gameLoop(){
        //renderer.run();w
        while(running){

        }
    }
}