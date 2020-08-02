package com.championash5357.tutorial.item;

import net.minecraft.item.ItemRecord;
import net.minecraft.util.SoundEvent;

public class ItemTutorialRecord extends ItemRecord {

	public ItemTutorialRecord(String name, SoundEvent soundIn, String u, String r) {
		super(name, soundIn);
		this.setUnlocalizedName(u);
		this.setRegistryName(r);
	}
}
