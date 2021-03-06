package net.minecraft.client.audio;

import net.minecraft.client.renderer.Vector3f;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.openal.AL10;

@OnlyIn(Dist.CLIENT)
public class Listener {
   private float gain = 1.0F;

   public void setPosition(Vec3d pos) {
      AL10.alListener3f(4100, (float)pos.x, (float)pos.y, (float)pos.z);
   }

   public void setOrientation(Vector3f p_227580_1_, Vector3f p_227580_2_) {
      AL10.alListenerfv(4111, new float[]{p_227580_1_.getX(), p_227580_1_.getY(), p_227580_1_.getZ(), p_227580_2_.getX(), p_227580_2_.getY(), p_227580_2_.getZ()});
   }

   public void setGain(float gainIn) {
      AL10.alListenerf(4106, gainIn);
      this.gain = gainIn;
   }

   public float getGain() {
      return this.gain;
   }

   public void init() {
      this.setPosition(Vec3d.ZERO);
      this.setOrientation(Vector3f.ZN, Vector3f.YP);
   }
}