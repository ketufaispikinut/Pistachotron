package com.pistachotron.client.render;

import com.pistachotron.Main;
import com.pistachotron.client.Window;
import com.pistachotron.debug.Log;
import com.pistachotron.file.Utils;
import com.pistachotron.shader.Shaders;
import org.joml.Matrix4f;
import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.io.File;
import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;
import com.pistachotron.client.render.util.Transformation;
//import com.pistachotron.client.render.Transformation;

//import java.net.*;
//import java.io.*;

public class Render {

    /**
     * Field of View in Radians
     */
    private static final float FOV = (float) Math.toRadians(60.0f);

    private static final float Z_NEAR = 0.01f;

    private static final float Z_FAR = 1000.f;

    private final Transformation transformation;

    private ShaderProgram shaderProgram;

    public Render() {
        transformation = new Transformation();
    }

    public void init(Window window) throws Exception {
        // Create shader
        //glfwInit();
        shaderProgram = new ShaderProgram();
        Log.debug("Loading Shader Files");
        //Log.debug(Utils.loadResource(Utils.getPath("shader/vertex.vs")));
        shaderProgram.createVertexShader(Shaders.vertex);//Utils.loadResource("/shader/vertex.vs"));
        shaderProgram.createFragmentShader(Shaders.frag);//Utils.loadResource("/shader/frag.fs"));
        //shaderProgram.createVertexShader(Utils.loadResource(Utils.getPath("shader/vertex.vs")));//new File(Main.RESOURCES_LOCATION+"/shader/vertex.vs").toString()
        //shaderProgram.createFragmentShader(Utils.loadResource(Utils.getPath("shader/frag.vs")));//new File(Main.RESOURCES_LOCATION+"/shader/frag.vs").toString());
        shaderProgram.link();
        Log.debug("Shader Files Loaded");

        // Create uniforms for world and projection matrices
        shaderProgram.createUniform("projectionMatrix");
        shaderProgram.createUniform("worldMatrix");


        window.setClearColor(0.0f, 0.0f, 0.0f, 0.0f);

    }

    public void clear() {

        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        //glClear()
    }

    public void render(Window window, Renderable[] gameItems) {
        //glfwMakeContextCurrent(window.windowHandle);
        //GL.createCapabilities();
        clear();

        if (window.isResized()) {
            glViewport(0, 0, window.getWidth(), window.getHeight());
            window.setResized(false);
        }

        shaderProgram.bind();

        // Update projection Matrix
        Matrix4f projectionMatrix = transformation.getProjectionMatrix(FOV, window.getWidth(), window.getHeight(), Z_NEAR, Z_FAR);
        shaderProgram.setUniform("projectionMatrix", projectionMatrix);

        // Render each gameItem
        for (Renderable gameItem : gameItems) {
            // Set world matrix for this item
            Matrix4f worldMatrix = transformation.getWorldMatrix(
                    gameItem.getPosition(),
                    gameItem.getRotation(),
                    gameItem.getScale());
            shaderProgram.setUniform("worldMatrix", worldMatrix);
            // Render the mes for this game item
            gameItem.getMesh().render();
        }

        shaderProgram.unbind();
    }

    public void cleanup() {
        if (shaderProgram != null) {
            shaderProgram.cleanup();
        }
    }
}