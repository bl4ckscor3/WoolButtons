package com.builtbroken.sbmwoolbuttons;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = WoolButtons.MODID)
@EventBusSubscriber
public class ConfigMain
{
    @Config.Name("enable_sound")
    @Config.LangKey("config." + WoolButtons.MODID + ":sound.enable.title")
    @Config.Comment("Set to true to enable vanilla style button sounds, false to act as a silent button.")
    public static boolean enableSound = true;

    @Config.Name("enable_sound_sheep")
    @Config.LangKey("config." + WoolButtons.MODID + ":sound.enable.sheep.title")
    @Config.Comment("Enables a random chance for the button to play a sheep audio effect")
    public static boolean enableDemonSheep = true;

    @Config.Name("sound_sheep_chance")
    @Config.LangKey("config." + WoolButtons.MODID + ":sound.sheep.chance.title")
    @Config.Comment("Chance for the button to randomly play sheep audio")
    @Config.RangeDouble(max = 1, min = -1)
    public static double demonSheepChance = 0.8;

    @SubscribeEvent
    public static void onConfigChanged(final OnConfigChangedEvent event)
    {
        if (event.getModID().equals(WoolButtons.MODID))
        {
            ConfigManager.sync(WoolButtons.MODID, Config.Type.INSTANCE);
        }
    }
}
