package com.championash5357.tutorial.init;

import com.championash5357.tutorial.block.BlockDualFurnace;
import com.championash5357.tutorial.block.BlockEasel;
import com.championash5357.tutorial.block.BlockModdedFence;
import com.championash5357.tutorial.block.BlockSpecialDrop;
import com.championash5357.tutorial.block.BlockStonePedestal;
import com.championash5357.tutorial.block.BlockStrawberry;
import com.championash5357.tutorial.block.BlockTutorialPortal;
import com.championash5357.tutorial.block.BlockWeirdCobblestone;
import com.championash5357.tutorial.client.Reference;
import com.championash5357.tutorial.tileentity.TileEntityDualFurnace;
import com.championash5357.tutorial.tileentity.TileEntityStonePedestal;
import com.google.common.base.Preconditions;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.oredict.OreDictionary;

@ObjectHolder(Reference.MOD_ID)
public class TutorialBlocks {
	
	public static final Block PURPLE_GLOWSTONE_FENCE = new BlockModdedFence(Material.GLASS, MapColor.PURPLE).setUnlocalizedName("purple_glowstone_fence").setRegistryName("blockpurpleglowstonefence");
	public static final Block DUAL_FURNACE = new BlockDualFurnace();
	public static final Block STRAWBERRY_CROP = new BlockStrawberry();
	public static final Block WEIRD_COBBLESTONE = new BlockWeirdCobblestone();
	public static final Block SPECIAL_DROP = new BlockSpecialDrop();
	public static final Block EASEL = new BlockEasel();
	public static final Block CANVAS = null;
	public static final BlockTutorialPortal PORTAL = new BlockTutorialPortal();
	public static final BlockStonePedestal STONE_PEDESTAL = null;
	
	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	public static class BlockRegistration {
		public static final NonNullList<Item> ITEM_BLOCKS = NonNullList.<Item>create();
		
		@SubscribeEvent
		public static void registerBlock(final RegistryEvent.Register<Block> event) {
			final Block[] blocks = {
					DUAL_FURNACE,
					EASEL,
					PURPLE_GLOWSTONE_FENCE,
					SPECIAL_DROP,
					STRAWBERRY_CROP,
					WEIRD_COBBLESTONE,
					PORTAL,
					new BlockStonePedestal()
			};
			
			event.getRegistry().registerAll(blocks);
		}
		
		@SubscribeEvent
		public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
			final ItemBlock[] items = {
				new ItemBlock(DUAL_FURNACE),
				new ItemBlock(EASEL),
				new ItemBlock(PURPLE_GLOWSTONE_FENCE),
				new ItemBlock(SPECIAL_DROP),
				new ItemBlock(STRAWBERRY_CROP),
				new ItemBlock(WEIRD_COBBLESTONE),
				new ItemBlock(STONE_PEDESTAL)
			};
			
			for(final ItemBlock item : items) {
				final Block block = item.getBlock();
				final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has a null registry name.", block);
				event.getRegistry().register(item.setRegistryName(registryName));
				ITEM_BLOCKS.add(item);
			}
			
			registerTileEntities();
			registerOreDictionary();
		}
		
		private static void registerTileEntities() {
			GameRegistry.registerTileEntity(TileEntityDualFurnace.class, "dual_furnace");
			GameRegistry.registerTileEntity(TileEntityStonePedestal.class, "stone_pedestal");
		}
		
		private static void registerOreDictionary() {
			OreDictionary.registerOre("furnace", Blocks.FURNACE);
			OreDictionary.registerOre("furnace", TutorialBlocks.DUAL_FURNACE);
		}
	}
}
