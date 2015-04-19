package com.speedment.orm.examples.codegenexample_helloworld;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Emil Forslund
 */
public class TxtWriter {
	private final File file;
	
	public final static boolean OVERWRITE = false, APPEND = true;
	
	public TxtWriter(String filename) {
		this (new File(filename));
	}
	
	public TxtWriter(File file) {
		this.file = file;
        
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
	}
	
	public void write(String... rows) {
		write(OVERWRITE, rows);
	}
	
	public void write(boolean overwrite, String... rows) {
		try (final Writer writer = new FileWriter(file, overwrite)) {
			writer.write(Stream.of(rows).collect(Collectors.joining("\n")));
			writer.close();
		} catch (IOException ex) {
			Logger.getLogger(TxtWriter.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}