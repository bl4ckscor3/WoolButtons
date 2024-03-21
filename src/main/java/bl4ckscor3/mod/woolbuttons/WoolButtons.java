package bl4ckscor3.mod.woolbuttons;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistries.Keys;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod(WoolButtons.MODID)
@EventBusSubscriber(modid = WoolButtons.MODID, bus = Bus.MOD)
public class WoolButtons {
	public static final String MODID = "sbmwoolbuttons";
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);
	public static final RegistryObject<SoundEvent> SILENCE = SOUND_EVENTS.register("silence", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MODID, "silence")));
	private static final List<ItemStack> STACKS_FOR_CREATIVE_TABS = new ArrayList<>();
	public static final BlockSetType WOOL_BUTTON_BLOCK_SET_TYPE = new BlockSetType(MODID + ":wool", SoundType.WOOL, SoundEvents.EMPTY, SoundEvents.EMPTY, SoundEvents.EMPTY, SoundEvents.EMPTY, SoundEvents.EMPTY, SoundEvents.EMPTY, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON);

	public WoolButtons() {
		SOUND_EVENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Configuration.CONFIG_SPEC);
	}

	@SubscribeEvent
	public static void onRegister(RegisterEvent event) {
		event.register(Keys.BLOCKS, helper -> {
			for (Color color : Color.values()) {
				helper.register(getName(color), new WoolButtonBlock(Block.Properties.of(Material.DECORATION).noCollission().strength(0.5F), WOOL_BUTTON_BLOCK_SET_TYPE, 30, true));
			}
		});
		event.register(Keys.ITEMS, helper -> {
			for (Color color : Color.values()) {
				ResourceLocation name = getName(color);
				Block block = ForgeRegistries.BLOCKS.getValue(name);

				if (block != null) {
					BlockItem blockItem = new BlockItem(block, new Item.Properties());

					helper.register(name, blockItem);
					STACKS_FOR_CREATIVE_TABS.add(new ItemStack(blockItem));
				}
			}
		});
	}

	@SubscribeEvent
	public static void onCreativeModeTabBuildContents(CreativeModeTabEvent.BuildContents event) {
		if (event.getTab() == CreativeModeTabs.REDSTONE_BLOCKS)
			event.getEntries().putAfter(new ItemStack(Items.STONE_BUTTON), STACKS_FOR_CREATIVE_TABS.get(0), TabVisibility.PARENT_AND_SEARCH_TABS); //white only
		else if (event.getTab() == CreativeModeTabs.COLORED_BLOCKS)
			event.acceptAll(STACKS_FOR_CREATIVE_TABS);
	}

	public static ResourceLocation getName(Color color) {
		return new ResourceLocation(MODID, "wool_button_" + color.name().toLowerCase());
	}

	public enum Color {
		WHITE,
		LIGHT_GRAY,
		GRAY,
		BLACK,
		BROWN,
		RED,
		ORANGE,
		YELLOW,
		LIME,
		GREEN,
		CYAN,
		LIGHT_BLUE,
		BLUE,
		PURPLE,
		MAGENTA,
		PINK;
	}
}
