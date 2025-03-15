package net.sp1kkelpoes.creaturesandcritters.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sp1kkelpoes.creaturesandcritters.CreaturesAndCritters;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CreaturesAndCritters.MOD_ID);

    public static final RegistryObject<MobEffect> BOOM = MOB_EFFECTS.register("boom",
            () -> new BoomEffect(MobEffectCategory.HARMFUL, 26758680));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
