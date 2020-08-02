package com.championash5357.tutorial.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFlyArmor extends ModelBiped {
	
    ModelRenderer Headset1;
    ModelRenderer Headset2;
    ModelRenderer Headset3;
    ModelRenderer Spaulder;
  
  public ModelFlyArmor(float scale) {
	  super(scale, 0, 64, 64);
	  
	  textureWidth = 64;
	  textureHeight = 64;
    
      Headset1 = new ModelRenderer(this, 0, 32);
      Headset1.addBox(4F, -4F, -3F, 1, 2, 2);
      Headset1.setRotationPoint(0F, 0F, 0F);
      Headset1.setTextureSize(64, 32);
      Headset1.mirror = true;
      setRotation(Headset1, 0F, 0F, 0F);
      
      Headset2 = new ModelRenderer(this, 6, 32);
      Headset2.addBox(4F, -2F, -4F, 1, 1, 1);
      Headset2.setRotationPoint(0F, 0F, 0F);
      Headset2.setTextureSize(64, 32);
      Headset2.mirror = true;
      setRotation(Headset2, 0F, 0F, 0F);
      
      Headset3 = new ModelRenderer(this, 10, 32);
      Headset3.addBox(1F, -1F, -5F, 3, 1, 1);
      Headset3.setRotationPoint(0F, 0F, 0F);
      Headset3.setTextureSize(64, 32);
      Headset3.mirror = true;
      setRotation(Headset3, 0F, 0F, 0F);
      
      Spaulder = new ModelRenderer(this, 0, 36);
      Spaulder.addBox(-0.8F, -3.5F, -2F, 5, 5, 5);
      Spaulder.setRotationPoint(0F, 0F, 0F);
      Spaulder.setTextureSize(64, 32);
      Spaulder.mirror = true;
      setRotation(Spaulder, 0F, 0F, 0.3490659F);
      
      bipedHead.addChild(Headset1);
      bipedHead.addChild(Headset2);
      bipedHead.addChild(Headset3);
      bipedLeftArm.addChild(Spaulder);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
}
