package bl4ckscor3.mod.sbmwoolbuttons.datagen;

import bl4ckscor3.mod.sbmwoolbuttons.WoolButtons;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ColorCollection;

public class RecipeGenerator extends RecipeProvider {
	private final HolderGetter<Item> items;

	public RecipeGenerator(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
		super(recipeOutput, advancementOutput);
		items = recipeOutput.lookup(Registries.ITEM);
	}

	@Override
	public final void buildRecipes() {
		ColorCollection.VALUES.forEach(color -> {
			Item dye = Items.DYE.pick(color);
			ItemLike button = WoolButtons.ITEMS.pick(color);

			ShapelessRecipeBuilder.shapeless(items, RecipeCategory.MISC, button)
				.group("wool_buttons")
				.requires(Items.WOOL.pick(color))
				.unlockedBy("has_wool", has(ItemTags.WOOL))
				.save(output);
			ShapelessRecipeBuilder.shapeless(items, RecipeCategory.BUILDING_BLOCKS, button)
				.group("wool_buttons")
				.requires(dye)
				.requires(Ingredient.of(WoolButtons.ITEMS.asList().stream().filter(check -> !check.equals(button))))
				.unlockedBy("has_needed_dye", has(dye))
				.save(output, WoolButtons.MODID + ":dye_" + getItemName(button));
		});
	}
}
