package com.championash5357.tutorial.capability;

import java.util.concurrent.Callable;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class TutorialCapability {
	
	@CapabilityInject(ITutorialEnergy.class)
	public static Capability<ITutorialEnergy> TUTORIAL_ENERGY = null;
	
	public static void register() {
		CapabilityManager.INSTANCE.register(ITutorialEnergy.class, new IStorage<ITutorialEnergy>() {

			@Override
			public NBTBase writeNBT(Capability<ITutorialEnergy> capability, ITutorialEnergy instance, EnumFacing side) {
				return new NBTTagInt(instance.getEnergyStored());
			}

			@Override
			public void readNBT(Capability<ITutorialEnergy> capability, ITutorialEnergy instance, EnumFacing side, NBTBase nbt) {
				if(!(instance instanceof TutorialEnergyStorage)) throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");
				((TutorialEnergyStorage)instance).energy = ((NBTTagInt)nbt).getInt();
			}
			
		}, new Callable<ITutorialEnergy>() {

			@Override
			public ITutorialEnergy call() throws Exception {
				return new TutorialEnergyStorage(1000000);
			}
			
		});
	}
}
