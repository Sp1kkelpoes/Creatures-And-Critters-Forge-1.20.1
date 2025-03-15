package net.sp1kkelpoes.creaturesandcritters.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class BoomEffect extends MobEffect {
    public BoomEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level().isClientSide()) {
            // Get the player's position
            double x = pLivingEntity.getX();
            double y = pLivingEntity.getY();
            double z = pLivingEntity.getZ();

            // Create a larger explosion at the player's position
            // Using Level.ExplosionInteraction.NONE to prevent block destruction
            // Set fire to false to prevent fire spread
            pLivingEntity.level().explode(pLivingEntity, x, y, z, 4.0F, false, Level.ExplosionInteraction.NONE);

            // Apply 1 heart of damage (2.0F) to the player and nearby entities
            pLivingEntity.hurt(pLivingEntity.damageSources().explosion(pLivingEntity, pLivingEntity), 2.0F);
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        // Make the effect tick every 10 ticks (0.5 seconds) for frequent explosions
        return pDuration % 10 == 0;
    }
}