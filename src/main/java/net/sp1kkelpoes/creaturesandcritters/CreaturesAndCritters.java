package net.sp1kkelpoes.creaturesandcritters;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sp1kkelpoes.creaturesandcritters.effect.ModEffects;
import net.sp1kkelpoes.creaturesandcritters.entity.ModEntities;
import net.sp1kkelpoes.creaturesandcritters.entity.client.GrasslingRenderer;
import net.sp1kkelpoes.creaturesandcritters.item.ModCreativeModeTabs;
import net.sp1kkelpoes.creaturesandcritters.item.ModItems;
import net.sp1kkelpoes.creaturesandcritters.potion.ModPotions;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CreaturesAndCritters.MOD_ID)
public class CreaturesAndCritters {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "creaturesandcritters";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // Correct constructor for Forge
    public CreaturesAndCritters(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        // Register creative mode tabs
        ModCreativeModeTabs.register(modEventBus);

        // Register items
        ModItems.register(modEventBus);

        // Register entities
        ModEntities.register(modEventBus);

        // Register effects
        ModEffects.register(modEventBus);

        // Register potions
        ModPotions.register(modEventBus);

        // Register common setup event
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events
        MinecraftForge.EVENT_BUS.register(this);

        // Register creative tab event
        modEventBus.addListener(this::addCreative);

        // Initialize GeckoLib
        GeckoLib.initialize();

        // Register mod config
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Common setup code here
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.WEIRD_GEM);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Server starting code here
    }

    // Automatically register client-side events
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Register entity renderers
            EntityRenderers.register(ModEntities.GRASSLING.get(), GrasslingRenderer::new);
        }
    }
}