package bl4ckscor3.mod.woolbuttons;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.ButtonBlock;

public class WoolButtonBlock extends ButtonBlock
{
	public WoolButtonBlock(Properties properties)
	{
		super(true, properties);
	}

	@Override
	protected SoundEvent getSound(boolean isPressed)
	{
		if(Configuration.CONFIG.makeSound.get())
			return isPressed ? SoundEvents.WOODEN_BUTTON_CLICK_ON : SoundEvents.WOODEN_BUTTON_CLICK_OFF;

		return WoolButtons.SILENCE.get(); //can't be null, would crash
	}
}
