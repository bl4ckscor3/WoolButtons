package bl4ckscor3.mod.woolbuttons;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class Configuration
{
	public static final ForgeConfigSpec CONFIG_SPEC;
	public static final Configuration CONFIG;

	public final BooleanValue makeSound;

	static {
		Pair<Configuration,ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Configuration::new);

		CONFIG_SPEC = specPair.getRight();
		CONFIG = specPair.getLeft();
	}

	Configuration(ForgeConfigSpec.Builder builder)
	{
		makeSound = builder
				.comment("True if the buttons should make a sound when pressed, false otherwhise")
				.define("make_sound", false);
	}
}
