package bl4ckscor3.mod.woolbuttons;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid=WoolButtons.MODID)
@EventBusSubscriber
public class Configuration
{
	@Config.Name("enable_sound")
	@Config.LangKey("config." + WoolButtons.MODID + ":sound.enable.title")
	@Config.Comment("Set to true to enable vanilla style button sounds, false to act as a silent button.")
	public static boolean enableSound = false;

	@SubscribeEvent
	public static void onConfigChanged(OnConfigChangedEvent event)
	{
		if(event.getModID().equals(WoolButtons.MODID))
			ConfigManager.sync(WoolButtons.MODID, Config.Type.INSTANCE);
	}
}
