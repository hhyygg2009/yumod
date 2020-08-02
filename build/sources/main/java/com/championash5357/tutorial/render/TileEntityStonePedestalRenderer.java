package com.championash5357.tutorial.render;

import com.championash5357.tutorial.tileentity.TileEntityStonePedestal;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;

@SideOnly(Side.CLIENT)
public class TileEntityStonePedestalRenderer extends TileEntitySpecialRenderer<TileEntityStonePedestal> {

	@Override
	public void render(TileEntityStonePedestal te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		ItemStack stack = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).getStackInSlot(0);
		if(!stack.isEmpty()) {
			super.render(te, x, y, z, partialTicks, destroyStage, alpha);
			
			EntityItem item = new EntityItem(Minecraft.getMinecraft().world, 0, 0, 0, stack);
			item.hoverStart = 0f;
			
			GlStateManager.pushMatrix();
			GlStateManager.translate(x + .5, y + 1.4, z + .5);
			for(int i = 8; i > te.getDirection(); i--)
				GlStateManager.rotate(45f, 0f, 1f, 0f);
			GlStateManager.scale(2, 2, 2);
			GlStateManager.translate(-.337, 0, 0);
			GlStateManager.rotate(225f, 0f, 0f, 1f);
			
			Minecraft.getMinecraft().getRenderManager().doRenderEntity(item, 0, 0, 0, 0f, 0f, false);
			
			GlStateManager.popMatrix();
		}
	}
}
