package com.championash5357.tutorial.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockSpecialDrop extends Block{

	public BlockSpecialDrop() {
		super(Material.ROCK, MapColor.DIAMOND);
		setUnlocalizedName("special_drop");
		setRegistryName("blockspecialdrop");
		setHarvestLevel("pickaxe", 0);
		setCreativeTab(CreativeTabs.DECORATIONS);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(Blocks.BEDROCK);
	}
}
