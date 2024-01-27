/*
 * All Rights Reserved (c) MoriyaShiine
 */

package moriyashiine.silverfishremodel.client.render.entity.living;

import moriyashiine.silverfishremodel.client.SilverfishRemodelClient;
import moriyashiine.silverfishremodel.client.render.model.living.RemodeledSilverfishEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.util.Identifier;

public class RemodeledSilverfishEntityRenderer extends MobEntityRenderer<SilverfishEntity, RemodeledSilverfishEntityModel<SilverfishEntity>> {
	private static final Identifier TEXTURE = SilverfishRemodelClient.id("textures/entity/silverfish.png");

	public RemodeledSilverfishEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new RemodeledSilverfishEntityModel<>(context.getPart(RemodeledSilverfishEntityModel.MODEL_LAYER)), 0.3F);
	}

	@Override
	public Identifier getTexture(SilverfishEntity entity) {
		return TEXTURE;
	}
}
