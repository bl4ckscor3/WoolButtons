package com.builtbroken.sbmwoolbuttons;

import net.minecraft.block.Block;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.registries.ObjectHolder;

@Mod(WoolButtons.MODID)
@EventBusSubscriber(modid=WoolButtons.MODID, bus=Bus.MOD)
public class WoolButtons
{
    public static final String MODID = "sbmwoolbuttons";
    public static final String NAME = "[SBM] Wool Buttons";
    public static final String VERSION = ""; //TODO
    public static final String MC_VERSION = "1.12";
    public static final String PREFIX = MODID + ":";

    @ObjectHolder(PREFIX + "wool_button_white")
    public static Block white;
    @ObjectHolder(PREFIX + "wool_button_orange")
    public static Block orange;
    @ObjectHolder(PREFIX + "wool_button_magenta")
    public static Block magenta;
    @ObjectHolder(PREFIX + "wool_button_light_blue")
    public static Block light_blue;
    @ObjectHolder(PREFIX + "wool_button_yellow")
    public static Block yellow;
    @ObjectHolder(PREFIX + "wool_button_lime")
    public static Block lime;
    @ObjectHolder(PREFIX + "wool_button_pink")
    public static Block pink;
    @ObjectHolder(PREFIX + "wool_button_gray")
    public static Block gray;
    @ObjectHolder(PREFIX + "wool_button_light_gray")
    public static Block light_gray;
    @ObjectHolder(PREFIX + "wool_button_cyan")
    public static Block cyan;
    @ObjectHolder(PREFIX + "wool_button_purple")
    public static Block purple;
    @ObjectHolder(PREFIX + "wool_button_blue")
    public static Block blue;
    @ObjectHolder(PREFIX + "wool_button_brown")
    public static Block brown;
    @ObjectHolder(PREFIX + "wool_button_green")
    public static Block green;
    @ObjectHolder(PREFIX + "wool_button_red")
    public static Block red;
    @ObjectHolder(PREFIX + "wool_button_black")
    public static Block black;

    @ObjectHolder(PREFIX + "silence")
    public static SoundEvent silence;

    public WoolButtons()
    {
        if(FMLLoader.getDist() == Dist.CLIENT)
            ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, WoolButtonsConfig.CONFIG_SPEC);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        for(EnumDyeColor color : EnumDyeColor.values())
        {
            event.getRegistry().register(new BlockWoolButton("wool_button_" + color.name()));
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new ItemBlock(white, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(white.getRegistryName()));
        event.getRegistry().register(new ItemBlock(orange, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(orange.getRegistryName()));
        event.getRegistry().register(new ItemBlock(magenta, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(magenta.getRegistryName()));
        event.getRegistry().register(new ItemBlock(light_blue, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(light_blue.getRegistryName()));
        event.getRegistry().register(new ItemBlock(yellow, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(yellow.getRegistryName()));
        event.getRegistry().register(new ItemBlock(lime, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(lime.getRegistryName()));
        event.getRegistry().register(new ItemBlock(pink, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(pink.getRegistryName()));
        event.getRegistry().register(new ItemBlock(gray, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(gray.getRegistryName()));
        event.getRegistry().register(new ItemBlock(light_gray, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(light_gray.getRegistryName()));
        event.getRegistry().register(new ItemBlock(cyan, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(cyan.getRegistryName()));
        event.getRegistry().register(new ItemBlock(purple, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(purple.getRegistryName()));
        event.getRegistry().register(new ItemBlock(blue, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(blue.getRegistryName()));
        event.getRegistry().register(new ItemBlock(brown, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(brown.getRegistryName()));
        event.getRegistry().register(new ItemBlock(green, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(green.getRegistryName()));
        event.getRegistry().register(new ItemBlock(red, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(red.getRegistryName()));
        event.getRegistry().register(new ItemBlock(black, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(black.getRegistryName()));
    }

    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event)
    {
        ResourceLocation rl = new ResourceLocation(MODID, "silence");

        event.getRegistry().register(new SoundEvent(rl).setRegistryName(rl));
    }
}
