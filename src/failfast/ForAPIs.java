package failfast;

import java.util.Objects;

//──▒▒▒▒▒──
//─▒─▄▒─▄▒─
//─▒▒▒▒▒▒▒─
//─▒▒▒▒▒▒▒─
//─▒─▒─▒─▒─
public interface ForAPIs {
	//http://stackoverflow.com/questions/29864642/is-objects-requirenonnull-less-efficient-than-the-old-way
	default void someMethod(String input) {
		Objects.requireNonNull(input);
	}

}
