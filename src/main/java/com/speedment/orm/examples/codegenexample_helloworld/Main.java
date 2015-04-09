package com.speedment.orm.examples.codegenexample_helloworld;

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(new JavaGenerator().on(
            File.of("org/example/BasicExample.java")
                .add(Class.of("BasicExample")
                    .add(GENERATED)
                    .public_()
                    .add(
                        Field.of("BASIC_MESSAGE", STRING)
                        .public_().final_().static_()
                        .set(new TextValue("Hello, world!"))
                    )
                    .add(
                        Method.of("main", VOID)
                        .set(Javadoc.of(
                            "This is a vary basic example of ",
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