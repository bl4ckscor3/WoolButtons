package bl4ckscor3.mod.woolbuttons;

import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class BlockWoolButton extends AbstractButtonBlock
{
	public BlockWoolButton()
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
