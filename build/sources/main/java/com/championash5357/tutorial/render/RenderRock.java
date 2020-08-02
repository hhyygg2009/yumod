package com.championash5357.tutorial.render;

import org.lwjgl.opengl.GL11;

import com.championash5357.tutorial.client.Reference;
import com.championash5357.tutorial.entity.EntityRock;
import com.championash5357.tutorial.model.ModelRock;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderRock extends Render<EntityRock>{
	
	private static final ResourceLocation ROCK = new ResourceLocation(Reference.MOD_ID + ":textures/entity/rock.png");
	private ModelRock model = new ModelRock();
	
	protected RenderRock(RenderManager renderManager) {
		super(renderManager);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityRock entity) {
		return ROCK;
	}
	
	@Override
	public void doRender(EntityRock entity, double x, double y, double z, float entityYaw, float partialTicks) {
		GL11.glPushMatrix();
		bindTexture(ROCK);
		GL11.glTranslated(x, y, z);
		model.render(entity, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
		GL11.glPopMatrix();
	}
}
