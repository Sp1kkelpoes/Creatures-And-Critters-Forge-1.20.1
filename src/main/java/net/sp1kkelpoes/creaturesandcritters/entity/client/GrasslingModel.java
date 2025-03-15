package net.sp1kkelpoes.creaturesandcritters.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.sp1kkelpoes.creaturesandcritters.CreaturesAndCritters;
import net.sp1kkelpoes.creaturesandcritters.entity.custom.GrasslingEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class GrasslingModel extends GeoModel<GrasslingEntity> {
    @Override
    public ResourceLocation getModelResource(GrasslingEntity grasslingEntity) {
        return new ResourceLocation(CreaturesAndCritters.MOD_ID, "geo/grassling.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GrasslingEntity grasslingEntity) {
        return new ResourceLocation(CreaturesAndCritters.MOD_ID, "textures/entity/grassling_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GrasslingEntity grasslingEntity) {
        return new ResourceLocation(CreaturesAndCritters.MOD_ID, "animations/animation.grassling.json");
    }

    @Override
    public void setCustomAnimations(GrasslingEntity animatable, long instanceId, AnimationState<GrasslingEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}