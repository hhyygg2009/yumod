package com.championash5357.tutorial.capability;

public interface ITutorialEnergy {
	
	int insertEnergy(int maxInsert, boolean simulate);
	
	int extractEnergy(int maxExtract, boolean simulate);
	
	int getEnergyStored();
	
	int getMaxEnergyStored();
	
	boolean canExtract();
	
	boolean canReceive();
}
