package com.championash5357.tutorial.init;

import com.championash5357.tutorial.client.Reference;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TutorialFluids {

	private static ModelResourceLocation acid_location = new ModelResourceLocation(Reference.MOD_ID + ":" + BlockAcid.name, "fluid");
	
	public static void register() {
		FluidRegistry.registerFluid(FluidAcid.instance);
		ForgeRegistries.BLOCKS.register(BlockAcid.instance);
		Item acid = Item.getItemFromBlock(BlockAcid.instance);
		ModelLoader.setCustomMeshDefinition(acid, new ItemMeshDefinition() {
			
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return acid_location;
			}
		});
		ModelLoader.setCustomStateMapper(BlockAcid.instance, new StateMapperBase() {
			
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return acid_location;
			}
		});
		FluidRegistry.addBucketForFluid(FluidAcid.instance);
	}
	
	public static final class FluidAcid extends Fluid {
		
		public static final String name = "acid";
		public static final FluidAcid instance = new FluidAcid();
		
		public FluidAcid() {
			super(name, new ResourceLocation(Reference.MOD_ID + ":" + "blocks/" + name  + "_still"), new ResourceLocation(Reference.MOD_ID + ":" + "blocks/" + name  + "_flow"));
			this.setViscosity(10000);
		}
	}
	
	public static final class BlockAcid extends BlockFluidClassic {
		
		public static final BlockAcid instance = new BlockAcid();
		public static final String name = "acid";
		
		public BlockAcid() {
			super(FluidAcid.instance, Material.WATER);
			setUnlocalizedName("blockacid");
			setRegistryName(acid_location);
		}
		
		@Override
		public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
			if(entityIn instanceof EntityLivingBase) {
				((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(19), 100, 10, false, false));
				((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(20), 1, 10, false, false));
			}
		}
		
		@Override
		public EnumBlockRenderType getRenderType(IBlockState state) {
			return EnumBlockRenderType.MODEL;
		}
	}
}