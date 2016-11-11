package firemerald.renderapi.api;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

/** Used to custom render blocks **/
public interface IBlockRenderer
{
	/** should the itemstack render in 3D in inventory? **/
	public boolean render3DInv(RenderItem renderItem, ItemStack stack, Block block);
	/** should the renderer handle this render mode? **/
	public boolean handeRenderType(ItemRenderType type);
	/** renders the block as an item **/
	public void renderItem(RenderItem renderItem, ItemStack stack, ItemRenderType type, Block block);
	/** render the block 
	 * @param rand **/
	public boolean renderBlock(Block block, BlockModelRenderer modelRenderer, IBlockAccess blockAccess, IBakedModel model, IBlockState state, BlockPos pos, VertexBuffer buffer, boolean checkSides, long rand, boolean useAO);
	/** use to get the icons (TextureAtlasSprite, formerly IIcon) needed by this renderer **/
	public void onTexturesRegister(TextureMap map);
	/** use to build any data needed **/
	public void onTexturesLoaded(TextureMap map);
}