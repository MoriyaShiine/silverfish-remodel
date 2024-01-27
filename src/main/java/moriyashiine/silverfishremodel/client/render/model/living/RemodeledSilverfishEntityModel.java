/*
 * All Rights Reserved (c) MoriyaShiine
 */

package moriyashiine.silverfishremodel.client.render.model.living;

import moriyashiine.silverfishremodel.client.SilverfishRemodelClient;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.util.math.MathHelper;

public class RemodeledSilverfishEntityModel<T extends SilverfishEntity> extends EntityModel<T> {
	public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(SilverfishRemodelClient.id("silverfish"), "main");

	private final ModelPart[] animatedParts;

	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart mushroom;

	public RemodeledSilverfishEntityModel(ModelPart root) {
		head = root.getChild("head");
		body = root.getChild("body");
		mushroom = body.getChild("mushroom");
		animatedParts = new ModelPart[]{head.getChild("antenna"), head, body, body.getChild("tail")};
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData ModelPartData = modelData.getRoot();

		ModelPartData head = ModelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -2, -2, 3, 2, 2, Dilation.NONE), ModelTransform.pivot(0, 24, -3));
		head.addChild("antenna", ModelPartBuilder.create().uv(11, -4).cuboid(1.5F, -3, -5, 0, 3, 5, Dilation.NONE)
				.uv(11, -4).cuboid(-1.5F, -3, -5, 0, 3, 5, Dilation.NONE), ModelTransform.pivot(0, -2, 0));
		ModelPartData body = ModelPartData.addChild("body", ModelPartBuilder.create().uv(0, 5).cuboid(-2, -3, 0, 4, 3, 5, Dilation.NONE), ModelTransform.pivot(0, 24, -3));
		body.addChild("tail", ModelPartBuilder.create().uv(0, 14).cuboid(-1.5F, -2, 0, 3, 2, 4, Dilation.NONE)
				.uv(-8, 24).cuboid(-4.5F, -1, 2, 9, 0, 8, Dilation.NONE), ModelTransform.pivot(0, 0, 5));
		ModelPartData mushroom = body.addChild("mushroom", ModelPartBuilder.create(), ModelTransform.pivot(0, -8, 3));
		mushroom.addChild("mushroom_2_r1", ModelPartBuilder.create().uv(16, 14).cuboid(-4, -8, 0, 8, 8, 0, Dilation.NONE), ModelTransform.of(0, 5, -0.5F, 0, -0.7854F, 0));
		mushroom.addChild("mushroom_1_r1", ModelPartBuilder.create().uv(16, 14).cuboid(-4, -8, 0, 8, 8, 0, Dilation.NONE), ModelTransform.of(0, 5, -0.5F, 0, 0.7854F, 0));

		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(SilverfishEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		for (int i = 0; i < animatedParts.length; i++) {
			animatedParts[i].yaw = MathHelper.cos(animationProgress * 0.9F + i * 0.15F * (float) Math.PI) * (float) Math.PI * 0.05F * (1 + Math.abs(i - 2) / 2F);
		}
		mushroom.visible = hasMushroom(entity);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		head.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		body.render(matrices, vertices, light, overlay, red, green, blue, alpha);
	}

	private static boolean hasMushroom(Entity entity) {
		return entity.getUuid().hashCode() % 8 == 0;
	}
}
