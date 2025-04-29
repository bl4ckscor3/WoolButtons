package bl4ckscor3.mod.woolbuttons.datagen;

import java.util.concurrent.CompletableFuture;

import bl4ckscor3.mod.woolbuttons.WoolButtons;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

public class BlockTagGenerator extends BlockTagsProvider {
	public BlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(output, lookupProvider, WoolButtons.MODID);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		WoolButtons.BLOCKS.values().forEach(block -> tag(BlockTags.DAMPENS_VIBRATIONS).add(block));
	}
}
