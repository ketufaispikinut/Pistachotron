package com.pistachotron.client;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.MemoryStack;

import java.nio.IntBuffer;

import static org.lwjgl.glfw.GLFW.glfwGetKey;
import static org.lwjgl.glfw.GLFW.glfwSetFramebufferSizeCallback;

public class Window {
    private long window;

    public Window(){

    }
    public void Init() {
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        } else {
            GLFW.glfwDefaultWindowHints();
            GLFW.glfwWindowHint(131076, 0);
            GLFW.glfwWindowHint(131075, 1);
            this.window = GLFW.glfwCreateWindow(600, 500, "Pistachotron", 0L, 0L);
            if (this.window == 0L) {
                throw new RuntimeException("Failed to create the GLFW window");
            } else {
                GLFW.glfwSetKeyCallback(this.window, (window, key, scancode, action, mods) -> {
                    if (key == 256 && action == 0) {
                        GLFW.glfwSetWindowShouldClose(window, true);
                    }

                });
                MemoryStack stack = MemoryStack.stackPush();

                try {
                    IntBuffer pWidth = stack.mallocInt(1);
                    IntBuffer pHeight = stack.mallocInt(1);
                    GLFW.glfwGetWindowSize(this.window, pWidth, pHeight);
                    GLFWVidMode vidmode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
                    GLFW.glfwSetWindowPos(this.window, (vidmode.width() - pWidth.get(0)) / 2, (vidmode.height() - pHeight.get(0)) / 2);
                } catch (Throwable var6) {
                    if (stack != null) {
                        try {
                            stack.close();
                        } catch (Throwable var5) {
                            var6.addSuppressed(var5);
                        }
                    }

                    throw var6;
                }

                if (stack != null) {
                    stack.close();
                }

                GLFW.glfwMakeContextCurrent(this.window);
                GLFW.glfwSwapInterval(1);
                GLFW.glfwShowWindow(this.window);
            }
        }

    }
    public boolean isKeyPressed(int keyCode) {
        //return glfwGetKey(windowHandle, keyCode) == GLFW_PRESS;
        return true;
    }
}
