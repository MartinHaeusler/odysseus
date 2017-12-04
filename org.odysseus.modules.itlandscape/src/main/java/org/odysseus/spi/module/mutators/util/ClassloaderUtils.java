package org.odysseus.spi.module.mutators.util;

import static com.google.common.base.Preconditions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class ClassloaderUtils {

	public static List<String> resourceFileToLines(final String resourceFilePath) {
		checkNotNull(resourceFilePath, "Precondition violation - argument 'resourceFilePath' must not be NULL!");
		InputStream stream = ClassloaderUtils.class.getClassLoader().getResourceAsStream(resourceFilePath);
		if (stream == null) {
			throw new IllegalStateException("Could not find classpath resource '" + resourceFilePath + "'!");
		}
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
			List<String> lines = reader.lines().collect(Collectors.toList());
			return lines;
		} catch (IOException e) {
			throw new IllegalStateException(
					"Failed to read from classpath resource '" + resourceFilePath + "'! See root cause for details.",
					e);
		}
	}
}
