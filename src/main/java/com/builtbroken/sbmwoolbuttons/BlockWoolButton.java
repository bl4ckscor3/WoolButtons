package com.builtbroken.sbmwoolbuttons;

import net.minecraft.block.BlockButton;
import net.minecraft.block.SoundType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockWoolButton extends BlockButton
{
    public BlockWoolButton(String name)
    {
        super(true);

        setRegistryName(WoolButtons.PREFIX + name);
        setTranslationKey(WoolButtons.PREFIX + name);
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
