package com.builtbroken.sbmwoolbuttons;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;

@Config(modid=WoolButtons.MODID)
public class WoolButtonsConfig
{
    @Name("make_sound")
    @Comment("True if the buttons should make a sound when pressed, false otherwhise")
    public static boolean makeSound = false;
}
