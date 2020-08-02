package com.yu.yuplus.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class YuTab extends CreativeTabs {

	public static YuTab yutab =null;

	public YuTab(String label) {
		super(label);
	}

	@Override
	public ItemStack createIcon() {

		return new ItemStack(Items.DIAMOND);
	}
	
	public static YuTab getInstance() {
		if (yutab==null) {
			yutab=new YuTab("yutab");
		}
		return yutab;
		
	}

}
