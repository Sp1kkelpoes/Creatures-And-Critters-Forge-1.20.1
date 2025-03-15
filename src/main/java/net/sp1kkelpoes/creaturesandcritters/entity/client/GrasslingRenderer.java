package net.sp1kkelpoes.creaturesandcritters.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.sp1kkelpoes.creaturesandcritters.CreaturesAndCritters;
import net.sp1kkelpoes.creaturesandcritters.entity.custom.GrasslingEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GrasslingRenderer extends GeoEntityRenderer<GrasslingEntity> {
    public GrasslingRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GrasslingModel());
    }
    @Override
    public ResourceLocation getTextureLocation(GrasslingEntity animatable) {
        return new ResourceLocation(CreaturesAndCritters.MOD_ID, "textures/entity/grassling_texture.png");
    }

    @Override
    public void render(GrasslingEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()){
            poseStack.scale(2f, 2f, 2f);
        }

        if(!entity.isBaby()) {
            poseStack.scale(4f, 4f, 4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
