package com.championash5357.tutorial.capability;

import net.minecraft.nbt.NBTTagCompound;

public class TutorialEnergyStorage implements ITutorialEnergy{
	
	protected int energy, capacity, maxInsert, maxExtract;
	
	public TutorialEnergyStorage(int capacity) {
		this(capacity, capacity, capacity);
	}
	
	public TutorialEnergyStorage(int capacity, int maxInsert, int maxExtract) {
		this.capacity = capacity;
		this.maxInsert = maxInsert;
		this.maxExtract = maxExtract;
	}
	
	@Override
	public int insertEnergy(int maxInsert, boolean simulate) {
		if(!canReceive()) return 0;
		int received = Math.min(capacity - energy, Math.min(this.maxInsert, maxInsert));
		if(!simulate) energy += received;
		return received;
	}

	@Override
	public int extractEnergy(int maxExtract, boolean simulate) {
		if(!canExtract()) return 0;
		int extracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));
		if(!simulate) energy -= extracted;
		return extracted;
	}

	@Override
	public int getEnergyStored() {
		return energy;
	}

	@Override
	public int getMaxEnergyStored() {
		return capacity;
	}

	@Override
	public boolean canExtract() {
		return this.maxExtract > 0;
	}

	@Override
	public boolean canReceive() {
		return this.maxInsert > 0;
	}
	
	public void readFromNBT(NBTTagCompound nbt) {
		this.energy = nbt.getInteger("Energy");
		this.capacity = nbt.getInteger("Capacity");
		this.maxInsert = nbt.getInteger("MaxInserted");
		this.maxExtract = nbt.getInteger("MaxExtracted");
	}
	
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("Energy", energy);
		nbt.setInteger("Capacity", capacity);
		nbt.setInteger("MaxInserted", maxInsert);
		nbt.setInteger("MaxExtracted", maxExtract);
	}
}
