package com.championash5357.tutorial.gui;

import com.championash5357.tutorial.gui.container.ContainerDualFurnace;
import com.championash5357.tutorial.gui.gui.GuiDualFurnace;
import com.championash5357.tutorial.tileentity.TileEntityDualFurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class TutorialGuiHandler implements IGuiHandler{
	
	public static final int DUAL_FURNACE_GUI = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID) {
		case DUAL_FURNACE_GUI:
			return new ContainerDualFurnace(player.inventory, ((TileEntityDualFurnace)world.getTileEntity(new BlockPos(x, y, z))));
		default:
			return null;
		}
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID) {
		case DUAL_FURNACE_GUI:
			return new GuiDualFurnace(player.inventory, ((TileEntityDualFurnace)world.getTileEntity(new BlockPos(x, y, z))));
		default:
			return null;
		}
	}
}
