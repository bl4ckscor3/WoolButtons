package bl4ckscor3.mod.woolbuttons;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

@Mod(WoolButtons.MODID)
@EventBusSubscriber(modid=WoolButtons.MODID, bus=Bus.MOD)
public class WoolButtons
{
	public static final String MODID = "sbmwoolbuttons";
	@ObjectHolder(MODID + ":silence")
	public static SoundEvent silence;

	public WoolButtons()
	{
		if(FMLLoader.getDist() == Dist.CLIENT)
			ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Configuration.CONFIG_SPEC);
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		for(Color color : Color.values())
		{
			event.getRegistry().register(new BlockWoolButton().setRegistryName(getName(color)));
		}
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		for(Color color : Color.values())
		{
			Block block = ForgeRegistries.BLOCKS.getValue(getName(color));

			if(block != null)
				event.getRegistry().register(new BlockItem(block, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(block.getRegistryName()));
		}
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event)
	{
		ResourceLocation rl = new ResourceLocation(MODID, "silence");

		event.getRegistry().register(new SoundEvent(rl).setRegistryName(rl));
	}

	public static ResourceLocation getName(Color color)
	{
		return new ResourceLocation(MODID, "wool_button_" + color.name().toLowerCase());
	}

	private static enum Color
	{
		WHITE, ORANGE, MAGENTA, LIGHT_BLUE, YELLOW, LIME, PINK, GRAY, LIGHT_GRAY, CYAN, PURPLE, BLUE, BROWN, GREEN, RED, BLACK;
	}
}
