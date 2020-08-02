package com.yu.yuplus.render;

import com.yu.yuplus.entity.LittleStoneEntity;
import com.yu.yuplus.item.ItemInitializer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class LittleStoneRender extends RenderSnowball<LittleStoneEntity>{

	public static IRenderFactory<LittleStoneEntity> FACTORY = LittleStoneRender::new;
	
	public LittleStoneRender(RenderManager renderManagerIn) {
		super(renderManagerIn, ItemInitializer.littlestone, Minecraft.getMinecraft().getRenderItem());

	}

}
