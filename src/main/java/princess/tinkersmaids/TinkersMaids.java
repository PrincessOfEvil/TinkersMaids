package princess.tinkersmaids;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sistr.littlemaidrebirth.api.mode.ModeManager;
import net.sistr.littlemaidrebirth.entity.mode.FencerMode;
import slimeknights.tconstruct.library.tools.item.ToolCore;

@Mod("tinkersmaids")
public class TinkersMaids
	{
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LogManager.getLogger();
	
	public TinkersMaids()
		{
		FMLJavaModLoadingContext.get()
				.getModEventBus()
				.addListener(this::setup);
		MinecraftForge.EVENT_BUS.register(this);
		}
		
	private void setup(final FMLCommonSetupEvent event)
		{
		try
			{
			Class.forName("net.sistr.littlemaidrebirth.entity.mode.FencerMode");
			ModeManager.ModeItems items = ModeManager.INSTANCE.getModeItems(FencerMode.class).get();
			items.add(ToolCore.class);
			ModeManager.INSTANCE.register(FencerMode.class, items);
			}
		catch (ClassNotFoundException e)
			{
			//...If the class doesn't exist, yet the mod is loaded, that's not really our issue, is it?
			//Unless they moved it.
			//Then it kind of is.
			}
		}
	}
