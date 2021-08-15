package com.pistachotron.shader;

public class Shaders {
    public static String frag= """
            #version 330
                        
            in  vec3 exColour;
            out vec4 fragColor;
                        
            void main()
            {
            	fragColor = vec4(exColour, 1.0);
            }
            """;
            /*"#version 330\n" +
            "\n" +
            "out vec4 fragColor;\n" +
            "\n" +
            "void main()\n" +
            "{\n" +
            "    fragColor = vec4(0.0, 0.5, 0.5, 1.0);\n" +
            "}";*/
    public static String vertex= """
                    #version 330
                                        
                    layout (location=0) in vec3 position;
                    layout (location=1) in vec3 inColour;
                                        
                    out vec3 exColour;
                                        
                    uniform mat4 worldMatrix;
                    uniform mat4 projectionMatrix;
                                        
                    void main()
                    {
                        gl_Position = projectionMatrix * worldMatrix * vec4(position, 1.0);
                        exColour = inColour;
                    }""";
                    /*"#version 330\n" +
            "\n" +
            "layout (location=0) in vec3 position;\n" +
            "\n" +
            "void main()\n" +
            "{\n" +
            "    gl_Position = vec4(position, 1.0);\n" +
            "}";*/

}
