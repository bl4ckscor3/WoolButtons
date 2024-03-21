package bl4ckscor3.mod.woolbuttons;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class WoolButtonBlock extends ButtonBlock {
	public WoolButtonBlock(BlockBehaviour.Properties properties, BlockSetType blockSetType, int ticksToStayPressed, boolean arrowsCanPress) {
		super(properties, blockSetType, ticksToStayPressed, arrowsCanPress);
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (state.getValue(POWERED))
			return InteractionResult.CONSUME;
		else {
			press(state, level, pos);
			playSound(player, level, pos, true);

			if (Configuration.CONFIG.triggerSculkSensors.get())
				level.gameEvent(player, GameEvent.BLOCK_ACTIVATE, pos);

			return InteractionResult.sidedSuccess(level.isClientSide);
		}
	}

	@Override
	protected void checkPressed(BlockState state, Level level, BlockPos pos) {
		AbstractArrow arrow = arrowsCanPress ? level.getEntitiesOfClass(AbstractArrow.class, state.getShape(level, pos).bounds().move(pos)).stream().findFirst().orElse(null) : null;
		boolean isArrowNotNull = arrow != null;
		boolean isButtonPowered = state.getValue(POWERED);

		if (isArrowNotNull != isButtonPowered) {
			level.setBlockAndUpdate(pos, state.setValue(POWERED, isArrowNotNull));
			updateNeighbours(state, level, pos);
			playSound(null, level, pos, isArrowNotNull);

			if (Configuration.CONFIG.triggerSculkSensors.get())
				level.gameEvent(arrow, isArrowNotNull ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE, pos);
		}

		if (isArrowNotNull)
			level.scheduleTick(new BlockPos(pos), this, ticksToStayPressed);
	}

	@Override
	protected SoundEvent getSound(boolean isPressed) {
		if (Configuration.CONFIG.makeSound.get())
			return super.getSound(isPressed);

		return SoundEvents.EMPTY;
	}
}
