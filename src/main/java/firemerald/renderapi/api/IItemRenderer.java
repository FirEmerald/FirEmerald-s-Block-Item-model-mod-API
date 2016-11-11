package firemerald.renderapi.api;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;

/** Used to custom render items **/
public interface IItemRenderer
{
	/** should the itemstack render 3D in inventory? **/
	public boolean render3DInv(RenderItem renderItem, ItemStack stack);
	/** should the renderer handle this render mode? **/
	public boolean handeRenderType(ItemRenderType type);
	/** render the itemstack **/
	public void renderItem(RenderItem renderItem, ItemStack stack, ItemRenderType type);
	/** use to get the icons (TextureAtlasSprite, formerly IIcon) needed by this renderer **/
	public void onTexturesRegister(TextureMap map);
	/** use to build any data needed **/
	public void onTexturesLoaded(TextureMap map);
}