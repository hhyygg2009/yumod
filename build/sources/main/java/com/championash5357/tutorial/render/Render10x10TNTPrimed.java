package com.championash5357.tutorial.render;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderTNTPrimed;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Render10x10TNTPrimed extends RenderTNTPrimed {

	public Render10x10TNTPrimed(RenderManager renderManagerIn) {
		super(renderManagerIn);
	}
}
