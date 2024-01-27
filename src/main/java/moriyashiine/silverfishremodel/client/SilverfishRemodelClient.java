/*
 * All Rights Reserved (c) MoriyaShiine
 */

package moriyashiine.silverfishremodel.client;

import moriyashiine.silverfishremodel.client.render.entity.living.RemodeledSilverfishEntityRenderer;
import moriyashiine.silverfishremodel.client.render.model.living.RemodeledSilverfishEntityModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;

public class SilverfishRemodelClient implements ClientModInitializer {
	public static final String MOD_ID = "silverfishremodel";

	@Override
	public void onInitializeClient() {
		EntityModelLayerRegistry.registerModelLayer(RemodeledSilverfishEntityModel.MODEL_LAYER, RemodeledSilverfishEntityModel::getTexturedModelData);
		EntityRendererRegistry.register(EntityType.SILVERFISH, RemodeledSilverfishEntityRenderer::new);
	}

	public static Identifier id(String value) {
		return new Identifier(MOD_ID, value);
	}
}
