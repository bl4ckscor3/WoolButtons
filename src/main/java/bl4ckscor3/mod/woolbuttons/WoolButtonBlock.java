package bl4ckscor3.mod.woolbuttons;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class WoolButtonBlock extends ButtonBlock {
	public WoolButtonBlock(Properties properties, BlockSetType blockSetType, int ticksToStayPressed, boolean arrowsCanPress) {
		super(properties, blockSetType, ticksToStayPressed, arrowsCanPress);
	}

	@Override
	protected SoundEvent getSound(boolean isPressed) {
		if (Configuration.CONFIG.makeSound.get())
			return super.getSound(isPressed);

		return SoundEvents.EMPTY;
	}
}
