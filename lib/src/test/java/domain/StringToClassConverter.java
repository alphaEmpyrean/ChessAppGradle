package domain;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

/**
 * Creates a {@link StringToClassConverter} instance. It concatenates 
 * 'domain.' with the string passed and then returns a 
 * Class<? extends GamePiece> instance based on the String.
 * 
 * -This class was created because I use a @CsvFileSource 
 * to import a csv mapping file to check initial game piece placement on 
 * gameBoard in the junit test {@link GameTest}. This converter adds the 
 * package name '.domain' to the name of the piece (e.g. 'queen' > 'domain.queen') 
 * Means I only have to use the 'queen' in the csv file. 
 * 
 * https://www.baeldung.com/parameterized-tests-junit-5#conversion
 * https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests-argument-conversion-implicit
 * https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests-argument-conversion-explicit
 * 
 * @author JoshuaKnippel
 *
 */
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
