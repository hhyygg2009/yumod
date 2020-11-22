package com.yu.yuplus.sound;

import com.yu.yuplus.YuPlus;
import com.yu.yuplus.sound.config.Area;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LocationHandler implements Runnable{

    LocationHandler(){

    }

    @Override
    public void run() {

        while (true){
            EntityPlayerSP sp= Minecraft.getMinecraft().player;
            if(sp!=null){
                BlockPos pos = sp.getPosition();

                YuPlus.logger.info(sp.getEntityWorld().provider.getDimensionType().getName());

//                YuPlus.logger.info(sp.getEntityWorld().getSaveHandler().loadWorldInfo().getWorldName());
//                Minecraft.getMinecraft().world.getSaveHandler().loadWorldInfo().getWorldName()
                YuPlus.logger.info("x:"+pos.getX()+"y:"+pos.getY()+"z"+pos.getZ());


                String loc=(pos.getY()>=-417)?"R":"G";
                YuPlus.logger.info("loc:"+loc);
            }
            sleep(10);
        }

    }
    public void sleep( long seconds )
    {
        try
        {
            Thread.sleep( 1000 * seconds );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }
    }

    private boolean isInArea(BlockPos pos, Area area){
        int x,y,z;
        int topX,topY,topZ,bottomX,bottomY,bottomZ;
        x=pos.getX();
        y=pos.getY();
        z=pos.getZ();
        
        topX=area.getTopX();
        bottomX=area.getBottomX();

        topZ=area.getTopZ();
        bottomZ=area.getBottomZ();

        topY=area.getTopY();
        bottomY=area.getBottomY();

        if(bottomX<=y&&y<=topX){
            if(bottomZ<=x&&x<=topZ){
                if(bottomY<=z&&z<=topY){
                    return true;
                }
            }
        }
        return false;
    }
}
