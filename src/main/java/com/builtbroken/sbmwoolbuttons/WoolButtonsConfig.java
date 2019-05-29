package com.builtbroken.sbmwoolbuttons;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid=WoolButtons.MODID)
@EventBusSubscriber
public class WoolButtonsConfig
{
    @Name("make_sound")
    @Comment("True if the buttons should make a sound when pressed, false otherwhise")
    public static boolean makeSound = false;

    @SubscribeEvent
    public static void onConfigChanged(final OnConfigChangedEvent event)
    {
        if(event.getModID().equals(WoolButtons.MODID))
            ConfigManager.sync(WoolButtons.MODID, Config.Type.INSTANCE);
    }
}
