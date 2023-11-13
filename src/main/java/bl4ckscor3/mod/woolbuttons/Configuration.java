package bl4ckscor3.mod.woolbuttons;

import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.BooleanValue;
import org.apache.commons.lang3.tuple.Pair;

public class Configuration {
	public static final ModConfigSpec CONFIG_SPEC;
	public static final Configuration CONFIG;
	public final BooleanValue makeSound;

	static {
		Pair<Configuration, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(Configuration::new);

		CONFIG_SPEC = specPair.getRight();
		CONFIG = specPair.getLeft();
	}

	Configuration(ModConfigSpec.Builder builder) {
		//@formatter:off
		makeSound = builder
				.comment("True if the buttons should make a sound when pressed, false otherwise")
				.define("make_sound", false);
		//@formatter:on
	}
}
