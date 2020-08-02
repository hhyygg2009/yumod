package com.championash5357.tutorial.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class ItemModAxe extends ItemAxe{

	public ItemModAxe(ToolMaterial material, String unlocalizedName, String registryName) {
		super(material, 8.0f, 2.0f);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.setMaxStackSize(1);
	}

}
