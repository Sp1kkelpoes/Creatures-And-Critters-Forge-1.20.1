package net.sp1kkelpoes.creaturesandcritters.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.sp1kkelpoes.creaturesandcritters.effect.ModEffects;

public class ModFoods {
    public static final FoodProperties RAW_GRASSLING_MEAT = new FoodProperties.Builder()
            .alwaysEat()
            .meat()
            .nutrition(4)
            .saturationMod(0.35f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 200, 2), 0.1f)
            .effect(() -> new MobEffectInstance(ModEffects.BOOM.get(), 200, 2),0.01f)
            .build();

    public static final FoodProperties COOKED_GRASSLING_MEAT = new FoodProperties.Builder()
            .alwaysEat()
            .meat()
            .nutrition(8)
            .saturationMod(13f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 500, 4), 0.4f)
            .effect(() -> new MobEffectInstance(ModEffects.BOOM.get(), 200, 5),0.001f)
            .build();
}
