package bl4ckscor3.mod.woolbuttons;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLLoader;
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
	public static final RegistryObject<SoundEvent> SILENCE = SOUND_EVENTS.register("silence", () -> new SoundEvent(new ResourceLocation(MODID, "silence")));

	public WoolButtons() {
		SOUND_EVENTS.register(FMLJavaModLoadingContext.get().getModEventBus());

		if (FMLLoader.getDist() == Dist.CLIENT)
			ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Configuration.CONFIG_SPEC);
	}

	@SubscribeEvent
	public static void onRegister(RegisterEvent event) {
		event.register(Keys.BLOCKS, helper -> {
			for (Color color : Color.values()) {
				helper.register(getName(color), new WoolButtonBlock(Block.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOL)));
			}
		});
		event.register(Keys.ITEMS, helper -> {
			for (Color color : Color.values()) {
				ResourceLocation name = getName(color);
				Block block = ForgeRegistries.BLOCKS.getValue(name);

				if (block != null)
					helper.register(name, new BlockItem(block, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
			}
		});
	}

	public static ResourceLocation getName(Color color) {
		return new ResourceLocation(MODID, "wool_button_" + color.name().toLowerCase());
	}

	private static enum Color {
		WHITE,
		ORANGE,
		MAGENTA,
		LIGHT_BLUE,
		YELLOW,
		LIME,
		PINK,
		GRAY,
		LIGHT_GRAY,
		CYAN,
		PURPLE,
		BLUE,
		BROWN,
		GREEN,
		RED,
		BLACK;
	}
}
