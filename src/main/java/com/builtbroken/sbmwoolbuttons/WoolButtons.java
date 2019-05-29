package com.builtbroken.sbmwoolbuttons;

import net.minecraft.block.Block;
import net.minecraft.block.BlockButton;
import net.minecraft.block.SoundType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@Mod(modid=WoolButtons.MODID, name=WoolButtons.NAME, version=WoolButtons.VERSION, acceptedMinecraftVersions=WoolButtons.MC_VERSION)
@EventBusSubscriber
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
    @ObjectHolder(PREFIX + "wool_button_silver")
    public static Block silver;
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

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(new BlockWoolButton("wool_button_white"));
        event.getRegistry().register(new BlockWoolButton("wool_button_orange"));
        event.getRegistry().register(new BlockWoolButton("wool_button_magenta"));
        event.getRegistry().register(new BlockWoolButton("wool_button_light_blue"));
        event.getRegistry().register(new BlockWoolButton("wool_button_yellow"));
        event.getRegistry().register(new BlockWoolButton("wool_button_lime"));
        event.getRegistry().register(new BlockWoolButton("wool_button_pink"));
        event.getRegistry().register(new BlockWoolButton("wool_button_gray"));
        event.getRegistry().register(new BlockWoolButton("wool_button_silver"));
        event.getRegistry().register(new BlockWoolButton("wool_button_cyan"));
        event.getRegistry().register(new BlockWoolButton("wool_button_purple"));
        event.getRegistry().register(new BlockWoolButton("wool_button_blue"));
        event.getRegistry().register(new BlockWoolButton("wool_button_brown"));
        event.getRegistry().register(new BlockWoolButton("wool_button_green"));
        event.getRegistry().register(new BlockWoolButton("wool_button_red"));
        event.getRegistry().register(new BlockWoolButton("wool_button_black"));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new ItemBlock(white).setRegistryName(white.getRegistryName()));
        event.getRegistry().register(new ItemBlock(orange).setRegistryName(orange.getRegistryName()));
        event.getRegistry().register(new ItemBlock(magenta).setRegistryName(magenta.getRegistryName()));
        event.getRegistry().register(new ItemBlock(light_blue).setRegistryName(light_blue.getRegistryName()));
        event.getRegistry().register(new ItemBlock(yellow).setRegistryName(yellow.getRegistryName()));
        event.getRegistry().register(new ItemBlock(lime).setRegistryName(lime.getRegistryName()));
        event.getRegistry().register(new ItemBlock(pink).setRegistryName(pink.getRegistryName()));
        event.getRegistry().register(new ItemBlock(gray).setRegistryName(gray.getRegistryName()));
        event.getRegistry().register(new ItemBlock(silver).setRegistryName(silver.getRegistryName()));
        event.getRegistry().register(new ItemBlock(cyan).setRegistryName(cyan.getRegistryName()));
        event.getRegistry().register(new ItemBlock(purple).setRegistryName(purple.getRegistryName()));
        event.getRegistry().register(new ItemBlock(blue).setRegistryName(blue.getRegistryName()));
        event.getRegistry().register(new ItemBlock(brown).setRegistryName(brown.getRegistryName()));
        event.getRegistry().register(new ItemBlock(green).setRegistryName(green.getRegistryName()));
        event.getRegistry().register(new ItemBlock(red).setRegistryName(red.getRegistryName()));
        event.getRegistry().register(new ItemBlock(black).setRegistryName(black.getRegistryName()));
    }

    @SubscribeEvent
    public static void onConfigChanged(final OnConfigChangedEvent event)
    {
        if(event.getModID().equals(MODID))
            ConfigManager.sync(MODID, Config.Type.INSTANCE);
    }

    private static class BlockWoolButton extends BlockButton
    {
        public BlockWoolButton(String name)
        {
            super(true);

            setRegistryName(PREFIX + name);
            setTranslationKey(PREFIX + name);
            setSoundType(SoundType.CLOTH);
        }

        @Override
        protected void playClickSound(EntityPlayer player, World world, BlockPos pos)
        {
            if(WoolButtonsConfig.makeSound)
                world.playSound(player, pos, SoundEvents.BLOCK_WOOD_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.3F, 0.6F);
        }

        @Override
        protected void playReleaseSound(World world, BlockPos pos)
        {
            if(WoolButtonsConfig.makeSound)
                world.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_WOOD_BUTTON_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.5F);
        }
    }
}
