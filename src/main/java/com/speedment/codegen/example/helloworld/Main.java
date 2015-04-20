package com.speedment.codegen.example.helloworld;

import com.speedment.codegen.java.JavaGenerator;
import com.speedment.codegen.lang.controller.AutoJavadoc;
import com.speedment.codegen.lang.models.Class;
import com.speedment.codegen.lang.models.Field;
import com.speedment.codegen.lang.models.File;
import com.speedment.codegen.lang.models.Javadoc;
import com.speedment.codegen.lang.models.Method;
import static com.speedment.codegen.lang.models.constants.DefaultAnnotationUsage.GENERATED;
import static com.speedment.codegen.lang.models.constants.DefaultType.STRING;
import static com.speedment.codegen.lang.models.constants.DefaultType.VOID;
import com.speedment.codegen.lang.models.values.TextValue;

/**
 *
 * @author Emil Forslund
 */
public class Main {
    
    private final static String FILENAME  = "org/example/BasicExample.java";
    private final static TxtWriter OUTPUT = new TxtWriter("src/main/java/" + FILENAME);

    /**
     * @param args the command line arguments
     */
    public static void main(String... args) {
        OUTPUT.write(new JavaGenerator().on(
            File.of(FILENAME)
                .add(Class.of("BasicExample")
                    .add(GENERATED.set(new TextValue("CodeGen 1.0")))
                    .public_()
                    .add(
                        Field.of("BASIC_MESSAGE", STRING)
                        .public_().final_().static_()
                        .set(new TextValue("Hello, world!"))
                    )
                    .add(
                        Method.of("main", VOID)
                        .set(Javadoc.of(
                            "This is a very basic example of ",
                            "the capabilities of the Code Generator."
                        ))
                        .public_().static_()
                        .add(Field.of("params", 
                            STRING.setArrayDimension(1)))
                        .add(
                            "System.out.println(BASIC_MESSAGE);"
                        )
                    )
                ).call(new AutoJavadoc<>())
            ).get()
        );
    }
}