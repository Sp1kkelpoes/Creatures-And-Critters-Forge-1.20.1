package net.sp1kkelpoes.creaturesandcritters.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sp1kkelpoes.creaturesandcritters.CreaturesAndCritters;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreaturesAndCritters.MOD_ID);


    public static final RegistryObject<CreativeModeTab> Creatures_And_Critters_Items_Tab = CREATIVE_MODE_TABS.register("creatures_and_critters_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.WEIRD_GEM.get()))
                    .title(Component.translatable("creativetab.creatures_and_critters_items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.GRASSLING_SPAWN_EGG.get());
                        output.accept(ModItems.WEIRD_GEM.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
