/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
/*
 * All Rights Reserved (c) MoriyaShiine
 */
package moriyashiine.silverfishremodel.client.render.model.living;

import moriyashiine.silverfishremodel.client.SilverfishRemodelClient;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.math.MathHelper;

public class RemodeledSilverfishEntityModel extends EntityModel<LivingEntityRenderState> {
	public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(SilverfishRemodelClient.id("silverfish"), "main");

	private final ModelPart[] animatedParts;

	public RemodeledSilverfishEntityModel(ModelPart root) {
		super(root);
		ModelPart modelRoot = root.getChild("root");
		ModelPart head = modelRoot.getChild("head");
		ModelPart body = modelRoot.getChild("body");
		ModelPart body2 = body.getChild("body2");
		ModelPart tail = body2.getChild("tail");
		animatedParts = new ModelPart[]{head, body, body2, tail};
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 24.0F, 0.0F));
		ModelPartData head = root.addChild("head", ModelPartBuilder.create().uv(4, 0).cuboid(-1.5F, -2.0F, -2.0F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 0.0F, -2.0F));
		ModelPartData antenna_left = head.addChild("antenna_left", ModelPartBuilder.create(), ModelTransform.origin(1.5F, -2.0F, -1.0F));
		antenna_left.addChild("antenna_left_r1", ModelPartBuilder.create().uv(18, -7).cuboid(0.0F, -2.0F, -7.0F, 0.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, -0.2618F, 0.0F));
		ModelPartData antenna_right = head.addChild("antenna_right", ModelPartBuilder.create(), ModelTransform.origin(-1.5F, -2.0F, -1.0F));
		antenna_right.addChild("antenna_right_r1", ModelPartBuilder.create().uv(18, -4).cuboid(0.0F, -2.0F, -7.0F, 0.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 0.2618F, 0.0F));
		ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(0, 4).cuboid(-2.0F, -3.0F, 0.0F, 4.0F, 3.0F, 5.0F, new Dilation(0.0F))
				.uv(0, 27).cuboid(-4.0F, -5.0F, 3.0F, 8.0F, 5.0F, 0.0F, new Dilation(0.0F))
				.uv(16, 12).cuboid(-4.0F, -5.0F, 0.0F, 8.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 0.0F, -2.0F));
		ModelPartData body2 = body.addChild("body2", ModelPartBuilder.create().uv(3, 12).cuboid(-1.5F, -2.0F, 0.0F, 3.0F, 2.0F, 3.0F, new Dilation(0.0F))
				.uv(16, 27).cuboid(-4.0F, -5.0F, 1.0F, 8.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 0.0F, 5.0F));
		body2.addChild("tail", ModelPartBuilder.create().uv(-8, 17).cuboid(-6.5F, 0.0F, -2.0F, 13.0F, 0.0F, 8.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, -1.0F, 3.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(LivingEntityRenderState state) {
		super.setAngles(state);
		for (int i = 0; i < animatedParts.length; i++) {
			animatedParts[i].yaw = MathHelper.cos(state.age * 0.9F + i * 0.15F * (float) Math.PI) * (float) Math.PI * 0.05F * (1 + Math.abs(i - 2) / 2F);
		}
	}
}
