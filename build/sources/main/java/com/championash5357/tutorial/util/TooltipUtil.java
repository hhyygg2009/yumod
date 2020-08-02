package com.championash5357.tutorial.util;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.util.text.TextFormatting;

public class TooltipUtil {
	
	public static List<String> addInfo(String name, String desc, String date) {
		List<String> list = Lists.<String>newArrayList();
		list.add("");
		list.add(TextFormatting.WHITE + "Creator: " + TextFormatting.GRAY + name);
		list.add(TextFormatting.WHITE + "Description: " + TextFormatting.GRAY + desc);
		list.add(TextFormatting.WHITE + "Date Added: " + TextFormatting.GRAY + date);
		return list;
	}
}
