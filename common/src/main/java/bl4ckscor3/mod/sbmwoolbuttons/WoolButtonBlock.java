package bl4ckscor3.mod.sbmwoolbuttons;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class WoolButtonBlock extends ButtonBlock {
	public WoolButtonBlock(Properties properties, BlockSetType blockSetType, int ticksToStayPressed) {
		super(blockSetType, ticksToStayPressed, properties);
	}

	@Override
	public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
		if (state.getValue(POWERED))
			return InteractionResult.CONSUME;
		else {
			press(state, level, pos, player);
			return InteractionResult.SUCCESS;
		}
	}

	@Override
	public void press(BlockState state, Level level, BlockPos pos, Player player) {
		level.setBlock(pos, state.setValue(POWERED, true), 3);
		updateNeighbours(state, level, pos);
		level.scheduleTick(pos, this, ticksToStayPressed);
		playSound(player, level, pos, true);

		if (Configuration.CONFIG.triggerSculkSensors.get())
			level.gameEvent(player, GameEvent.BLOCK_ACTIVATE, pos);
	}

	@Override
	protected void checkPressed(BlockState state, Level level, BlockPos pos) {
		AbstractArrow arrow = type.canButtonBeActivatedByArrows() ? level.getEntitiesOfClass(AbstractArrow.class, state.getShape(level, pos).bounds().move(pos)).stream().findFirst().orElse(null) : null;
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
	protected void playSound(Player player, LevelAccessor level, BlockPos pos, boolean pressed) {
		if (Configuration.CONFIG.makeSound.get())
			super.playSound(player, level, pos, pressed);
	}
}
