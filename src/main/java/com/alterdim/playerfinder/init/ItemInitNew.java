package com.alterdim.playerfinder.init;

import com.alterdim.playerfinder.PlayerFinder;
import com.alterdim.playerfinder.PlayerFinder.PlayerFinderItemGroup;
import com.alterdim.playerfinder.objects.items.PlayerFinderItem;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInitNew 
{
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, PlayerFinder.MOD_ID);
	public static final RegistryObject<Item> PLAYER_FINDER = ITEMS.register("player_finder", () -> 
	new PlayerFinderItem(new Item.Properties().group(PlayerFinderItemGroup.instance).maxDamage(20)));
	
}
