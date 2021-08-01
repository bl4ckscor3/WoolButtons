package bl4ckscor3.mod.woolbuttons;

import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

public class WoolButtonBlock extends ButtonBlock
{
	public WoolButtonBlock()
	{
		super(true, Block.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOL));
	}

	@Override
	protected SoundEvent getSound(boolean isPressed)
	{
		if(Configuration.CONFIG.makeSound.get())
			return isPressed ? SoundEvents.WOODEN_BUTTON_CLICK_ON : SoundEvents.WOODEN_BUTTON_CLICK_OFF;
		return WoolButtons.silence; //can't be null, would crash
	}
}
