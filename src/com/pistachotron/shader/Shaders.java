package com.pistachotron.shader;

public class Shaders {
    public static String frag="#version 330\n" +
            "\n" +
            "out vec4 fragColor;\n" +
            "\n" +
            "void main()\n" +
            "{\n" +
            "    fragColor = vec4(0.0, 0.5, 0.5, 1.0);\n" +
            "}";
    public static String vertex="#version 330\n" +
            "\n" +
            "layout (location=0) in vec3 position;\n" +
            "\n" +
            "void main()\n" +
            "{\n" +
            "    gl_Position = vec4(position, 1.0);\n" +
            "}";
}
