package com.championash5357.tutorial.util;

import com.championash5357.tutorial.registry.DyeType;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class DyeUtil {
	
	public static ItemStack createDye(ItemStack stack, DyeType dye) {
		NBTTagCompound tag = new NBTTagCompound();
		
		tag.setString("Dye", dye.getName());
		
		stack.setTagCompound(tag);
		
		return stack;
	}
	
	public static String getRegistryNameFromNBT(ItemStack stack) {
		if(stack.hasTagCompound()) {
			if(stack.getTagCompound().hasKey("Dye")) {
				return stack.getTagCompound().getString("Dye");
			}
		}
		return "white";
	}
}
