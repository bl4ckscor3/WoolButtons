package com.builtbroken.sbmwoolbuttons;

import net.minecraft.block.Block;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

@Mod(modid = WoolButtons.MODID, name = "[SBM] Wool Buttons", version = WoolButtons.VERSION)
@EventBusSubscriber
public class WoolButtons
{
    public static final String MODID = "sbmwoolbuttons";
    public static final String MAJOR_VERSION = "@MAJOR@";
    public static final String MINOR_VERSION = "@MINOR@";
    public static final String REVISION_VERSION = "@REVIS@";
    public static final String BUILD_VERSION = "@BUILD@";
    public static final String MC_VERSION = "@MC@";
    public static final String VERSION = MC_VERSION + "-" + MAJOR_VERSION + "." + MINOR_VERSION + "." + REVISION_VERSION + "." + BUILD_VERSION;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        for (EnumDyeColor color : EnumDyeColor.values())
        {
            event.getRegistry().register(new BlockWoolButton()
                    .setRegistryName(getName(color))
                    .setTranslationKey(MODID + ":wool.button." + color.name().toLowerCase())
            );
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        for (EnumDyeColor color : EnumDyeColor.values())
        {
            final Block block = ForgeRegistries.BLOCKS.getValue(getName(color));
            if (block != null)
            {
                event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
            }
        }
    }

    public static ResourceLocation getName(EnumDyeColor color)
    {
        return new ResourceLocation(MODID, "wool_button_" + color.name().toLowerCase());
    }
}
