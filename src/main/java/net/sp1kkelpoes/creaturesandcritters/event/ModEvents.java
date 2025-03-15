package net.sp1kkelpoes.creaturesandcritters.event;

import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sp1kkelpoes.creaturesandcritters.CreaturesAndCritters;
import net.sp1kkelpoes.creaturesandcritters.entity.ModEntities;
import net.sp1kkelpoes.creaturesandcritters.entity.custom.GrasslingEntity;

@Mod.EventBusSubscriber(modid = CreaturesAndCritters.MOD_ID, bus =  Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GRASSLING.get(), GrasslingEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void entitySpawnRestriction(SpawnPlacementRegisterEvent event) {
        event.register(ModEntities.GRASSLING.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
