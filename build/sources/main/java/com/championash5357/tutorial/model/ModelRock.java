package com.championash5357.tutorial.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRock extends ModelBase
{
    ModelRenderer Rock;
  
  public ModelRock()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      Rock = new ModelRenderer(this, 0, 0);
      Rock.addBox(-1F, 22F, -1F, 2, 2, 2);
      Rock.setRotationPoint(0F, 0F, 0F);
      Rock.setTextureSize(32, 32);
      Rock.mirror = true;
      setRotation(Rock, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Rock.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
}
