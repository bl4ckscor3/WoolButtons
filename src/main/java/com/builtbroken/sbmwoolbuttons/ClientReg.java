package com.builtbroken.sbmwoolbuttons;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(modid = WoolButtons.MODID, value = Side.CLIENT)
public class ClientReg
{
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event)
    {
        for (EnumDyeColor color : EnumDyeColor.values())
        {
            final Item item = ForgeRegistries.ITEMS.getValue(WoolButtons.getName(color));
            if (item != null)
            {
                ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
            }
        }
    }
}
