package com.championash5357.tutorial.recipe;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DualFurnaceRecipes {
	
	private static final DualFurnaceRecipes SMELTING = new DualFurnaceRecipes();
	private final Table<ItemStack, ItemStack, ItemStack> dualSmeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	
	public static DualFurnaceRecipes instance() {
		return SMELTING;
	}
	
	private DualFurnaceRecipes() {
		this.addDualSmeltingRecipeForBlock(Blocks.GOLD_ORE, Blocks.DIAMOND_ORE, new ItemStack(Items.EMERALD), 20.0F);
		this.addDualSmelting(Items.STRING, Items.BLAZE_ROD, new ItemStack(Items.FISHING_ROD), 10.0F);
		this.addDualSmeltingRecipeForBlock(Items.DIAMOND, Blocks.SAND, new ItemStack(Items.DIAMOND_HELMET), 10000000000.0F);
	}
	
	public void addDualSmeltingRecipeForBlock(Block input1, Block input2, ItemStack result, float experience) {
		this.addDualSmelting(Item.getItemFromBlock(input1), Item.getItemFromBlock(input2), result, experience);
	}
	
	public void addDualSmeltingRecipeForBlock(Item input1, Block input2, ItemStack result, float experience) {
		this.addDualSmelting(input1, Item.getItemFromBlock(input2), result, experience);
	}
	
	public void addDualSmeltingRecipeForBlock(Block input1, Item input2, ItemStack result, float experience) {
		this.addDualSmelting(Item.getItemFromBlock(input1), input2, result, experience);
	}
	
	public void addDualSmelting(Item input1, Item input2, ItemStack result, float experience) {
		this.addDualSmeltingRecipe(new ItemStack(input1, 1, 32767), new ItemStack(input2, 1, 32767), result, experience);
	}
	
	public void addDualSmelting(ItemStack input1, Item input2, ItemStack result, float experience) {
		this.addDualSmeltingRecipe(input1, new ItemStack(input2, 1, 32767), result, experience);
	}
	
	public void addDualSmelting(Item input1, ItemStack input2, ItemStack result, float experience) {
		this.addDualSmeltingRecipe(new ItemStack(input1, 1, 32767), input2, result, experience);
	}
	
	public void addDualSmeltingRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience) {
		if(getDualSmeltingResult(input1, input2) != ItemStack.EMPTY) { net.minecraftforge.fml.common.FMLLog.info("Ignored dual smelting recipe with conflicting input: " + input1 + " and " + input2 + " = " + result); return; }
		this.dualSmeltingList.put(input1, input2, result);
		this.experienceList.put(result, Float.valueOf(experience));
	}
	
	public ItemStack getDualSmeltingResult(ItemStack input1, ItemStack input2) {
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.dualSmeltingList.columnMap().entrySet()) {
			if(this.compareItemStacks(input1, (ItemStack)entry.getKey())) {
				for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) {
					if(this.compareItemStacks(input2, (ItemStack)ent.getKey())) {
						return (ItemStack)ent.getValue();
					}
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList() {
		return this.dualSmeltingList;
	}
	
	public float getDualSmeltingExperience(ItemStack stack) {
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) {
			if(this.compareItemStacks(stack, (ItemStack)entry.getKey())) {
				return ((Float)entry.getValue()).floatValue();
			}
		}
		return 0.0F;
	}
}
