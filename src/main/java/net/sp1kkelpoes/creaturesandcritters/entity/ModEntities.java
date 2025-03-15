package net.sp1kkelpoes.creaturesandcritters.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sp1kkelpoes.creaturesandcritters.CreaturesAndCritters;
import net.sp1kkelpoes.creaturesandcritters.entity.custom.GrasslingEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CreaturesAndCritters.MOD_ID);

    public static final RegistryObject<EntityType<GrasslingEntity>> GRASSLING =
            ENTITY_TYPES.register("grassling",
                    () -> EntityType.Builder.of(GrasslingEntity::new, MobCategory.CREATURE)
                            .sized(1f, 1f) // Hitbox size (width, height)
                            .build("grassling")); // Use a String for the registry name

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}