package com.championash5357.tutorial.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityStonePedestal extends TileEntity {

	private ItemStackHandler inventory;
	private int direction;
	
	public TileEntityStonePedestal() {
		inventory = new ItemStackHandler(1);
		direction = 0;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		inventory.deserializeNBT(compound.getCompoundTag("inventory"));
		direction = compound.getInteger("direction");
		super.readFromNBT(compound);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setTag("inventory", inventory.serializeNBT());
		compound.setInteger("direction", direction);
		return super.writeToNBT(compound);
	}
	
	@Override
	public NBTTagCompound getUpdateTag() {
		return this.writeToNBT(new NBTTagCompound());
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.getNbtCompound());
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(pos, 0, getUpdateTag());
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
		return super.hasCapability(capability, facing);
	}
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T) this.inventory;
		return super.getCapability(capability, facing);
	}
	
	public boolean setItemStack(ItemStack stack, int direction) {
		if(getInventory().isEmpty()) {
			ItemStack inv = stack.copy();
			stack.shrink(1);
			inv.setCount(1);
			inventory.setStackInSlot(0, inv);
			this.direction = direction;
			markDirty();
			return true;
		}
		return false;
	}
	
	public ItemStack removeItemStack() {
		if(!getInventory().isEmpty()) {
			ItemStack stack = getInventory().copy();
			inventory.setStackInSlot(0, ItemStack.EMPTY);
			markDirty();
			return stack;
		}
		return ItemStack.EMPTY;
	}
	
	private ItemStack getInventory() {
		return inventory.getStackInSlot(0);
	}
	
	public int getDirection() {
		return direction;
	}
}
