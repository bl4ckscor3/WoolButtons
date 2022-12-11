package bl4ckscor3.mod.woolbuttons;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.ButtonBlock;

public class WoolButtonBlock extends ButtonBlock {
	public WoolButtonBlock(Properties properties, int ticksToStayPressed, boolean arrowsCanPress, SoundEvent soundOff, SoundEvent soundOn) {
		super(properties, ticksToStayPressed, arrowsCanPress, soundOff, soundOn);
	}

	@Override
	protected SoundEvent getSound(boolean isPressed) {
		if (Configuration.CONFIG.makeSound.get())
			return super.getSound(isPressed);

		return WoolButtons.SILENCE.get(); //can't be null, would crash
	}
}
