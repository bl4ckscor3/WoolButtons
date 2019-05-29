package com.builtbroken.sbmwoolbuttons;

import net.minecraft.block.Block;
import net.minecraft.block.BlockButton;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;

public class BlockWoolButton extends BlockButton
{
    public BlockWoolButton(String name)
    {
        super(true, Block.Properties.create(Material.CIRCUITS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.CLOTH));

        setRegistryName(WoolButtons.PREFIX + name);
    }

    @Override
    protected SoundEvent getSoundEvent(boolean isPressed)
    {
        if(WoolButtonsConfig.CONFIG.makeSound.get())
            return isPressed ? SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON : SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF;
        return WoolButtons.silence; //can't be null, would crash
    }
}
