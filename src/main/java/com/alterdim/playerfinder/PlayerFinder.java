package com.alterdim.playerfinder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alterdim.playerfinder.init.ItemInitNew;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


// The value here should match an entry in the META-INF/mods.toml file
@Mod("playerfinder")
@Mod.EventBusSubscriber(modid = "playerfinder", bus = Mod.EventBusSubscriber.Bus.MOD) 
public class PlayerFinder
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "playerfinder";
    public static PlayerFinder instance;

    public PlayerFinder() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        
        ItemInitNew.ITEMS.register(modEventBus);
        instance = this;

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    


    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("PlayerFinder initializing.");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {}
    
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {}
    
    public static class PlayerFinderItemGroup extends ItemGroup
    {
    	public static final PlayerFinderItemGroup instance = new PlayerFinderItemGroup(ItemGroup.GROUPS.length, "playerfindertab");
    	private PlayerFinderItemGroup(int index, String label)
    	{
    		super(index, label);
    	}

		@Override
		public ItemStack createIcon() 
		{
			return new ItemStack(ItemInitNew.PLAYER_FINDER.get());
		}
    }

}
