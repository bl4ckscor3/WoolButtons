package com.builtbroken.sbmwoolbuttons;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(modid=WoolButtons.MODID, value=Side.CLIENT)
public class ClientReg
{
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event)
    {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(WoolButtons.white), 0, new ModelResourceLocation(WoolButtons.PREFIX + "wool_button_white", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(WoolButtons.orange), 0, new ModelResourceLocation(WoolButtons.PREFIX + "wool_button_orange", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(WoolButtons.magenta), 0, new ModelResourceLocation(WoolButtons.PREFIX + "wool_button_magenta", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(WoolButtons.light_blue), 0, new ModelResourceLocation(WoolButtons.PREFIX + "wool_button_light_blue", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(WoolButtons.yellow), 0, new ModelResourceLocation(WoolButtons.PREFIX + "wool_button_yellow", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(WoolButtons.lime), 0, new ModelResourceLocation(WoolButtons.PREFIX + "wool_button_lime", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(WoolButtons.pink), 0, new ModelResourceLocation(WoolButtons.PREFIX + "wool_button_pink", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(WoolButtons.gray), 0, new ModelResourceLocation(WoolButtons.PREFIX + "wool_button_gray", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(WoolButtons.silver), 0, new ModelResourceLocation(WoolButtons.PREFIX + "wool_button_silver", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(WoolButtons.cyan), 0, new ModelResourceLocation(WoolButtons.PREFIX + "wool_button_cyan", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(WoolButtons.purple), 0, new ModelResourceLocation(WoolButtons.PREFIX + "wool_button_purple", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(WoolButtons.blue), 0, new ModelResourceLocation(WoolButtons.PREFIX + "wool_button_blue", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(WoolButtons.brown), 0, new ModelResourceLocation(WoolButtons.PREFIX + "wool_button_brown", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(WoolButtons.green), 0, new ModelResourceLocation(WoolButtons.PREFIX + "wool_button_green", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(WoolButtons.red), 0, new ModelResourceLocation(WoolButtons.PREFIX + "wool_button_red", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(WoolButtons.black), 0, new ModelResourceLocation(WoolButtons.PREFIX + "wool_button_black", "inventory"));
    }
}
