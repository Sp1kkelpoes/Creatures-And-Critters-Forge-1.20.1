package net.sp1kkelpoes.creaturesandcritters.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sp1kkelpoes.creaturesandcritters.CreaturesAndCritters;
import net.sp1kkelpoes.creaturesandcritters.entity.ModEntities;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreaturesAndCritters.MOD_ID);

        public static final RegistryObject<Item> WEIRD_GEM = ITEMS.register("weird_gem",
                () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> GRASSLING_SPAWN_EGG = ITEMS.register("grassling_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.GRASSLING, 0x4FB626, 0x366F1E, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}