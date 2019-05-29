package com.builtbroken.sbmwoolbuttons;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class WoolButtonsConfig
{
    public static final ForgeConfigSpec CONFIG_SPEC;
    public static final WoolButtonsConfig CONFIG;

    public final BooleanValue makeSound;

    static
    {
        Pair<WoolButtonsConfig,ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(WoolButtonsConfig::new);

        CONFIG_SPEC = specPair.getRight();
        CONFIG = specPair.getLeft();
    }

    WoolButtonsConfig(ForgeConfigSpec.Builder builder)
    {
        makeSound = builder
                .comment("True if the buttons should make a sound when pressed, false otherwhise")
                .define("make_sound", false);
    }
}
