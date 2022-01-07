package domain;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

public class StringToClassConverter implements ArgumentConverter {

	@Override
	public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
		if (!(source instanceof String)) {
			throw new IllegalArgumentException("The argument should be a string: " + source);
		}

		try {

			String textClass = "domain.".concat((String) source);
			Class<?> clazz = Class.forName(textClass);
			return clazz;

		} catch (Exception e) {
			throw new IllegalArgumentException("Failed to convert", e);
		}

	}

}
