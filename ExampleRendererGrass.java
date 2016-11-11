package firemerald.renderapi;

import org.lwjgl.opengl.GL11;

import firemerald.renderapi.api.IBlockRenderer;
import firemerald.renderapi.api.ItemRenderType;
import firemerald.renderapi.api.RenderUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class ExampleRendererGrass implements IBlockRenderer
{
	public static TextureAtlasSprite dirt;
	public static TextureAtlasSprite grass_side_overlay;
	public static TextureAtlasSprite grass_side_snowed;
	public static TextureAtlasSprite grass_side;
	public static TextureAtlasSprite grass_top;
	public static int[] down;
	public static int[] up;
	public static int[] westGrass;
	public static int[] westOverlay;
	public static int[] westSnowy;
	public static int[] eastGrass;
	public static int[] eastOverlay;
	public static int[] eastSnowy;
	public static int[] northGrass;
	public static int[] northOverlay;
	public static int[] northSnowy;
	public static int[] southGrass;
	public static int[] southOverlay;
	public static int[] southSnowy;
	
	@Override
	public boolean render3DInv(RenderItem renderItem, ItemStack stack, Block block)
	{
		return true;
	}

	@Override
	public boolean handeRenderType(ItemRenderType type)
	{
		return true;
	}

	@Override
	public void renderItem(RenderItem renderItem, ItemStack stack, ItemRenderType type, Block block)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef(-.5f, -.5f, -.5f);
		GL11.glColor4f(1, 1, 1, 1);
		renderItem();
		if (stack.hasEffect())
		{
			GL11.glColor4f(.5f, .25f, .8f, 1);
	        GlStateManager.depthMask(false);
	        GlStateManager.depthFunc(514);
	        GlStateManager.disableLighting();
	        GlStateManager.blendFunc(768, 1);
	        Minecraft.getMinecraft().getTextureManager().bindTexture(RenderUtils.RES_ITEM_GLINT);
	        GlStateManager.matrixMode(5890);
	        GlStateManager.pushMatrix();
	        GlStateManager.scale(8.0F, 8.0F, 8.0F);
	        float f = Minecraft.getSystemTime() % 3000L / 3000.0F / 8.0F;
	        GlStateManager.translate(f, 0.0F, 0.0F);
	        GlStateManager.rotate(-50.0F, 0.0F, 0.0F, 1.0F);
	    	renderItem();
	        GlStateManager.popMatrix();
	        GlStateManager.pushMatrix();
	        GlStateManager.scale(8.0F, 8.0F, 8.0F);
	        float f1 = Minecraft.getSystemTime() % 4873L / 4873.0F / 8.0F;
	        GlStateManager.translate(-f1, 0.0F, 0.0F);
	        GlStateManager.rotate(10.0F, 0.0F, 0.0F, 1.0F);
	    	renderItem();
	        GlStateManager.popMatrix();
	        GlStateManager.matrixMode(5888);
	        GlStateManager.blendFunc(770, 771);
	        GlStateManager.enableLighting();
	        GlStateManager.depthFunc(515);
	        GlStateManager.depthMask(true);
	        Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
		}
		GL11.glColor4f(1, 1, 1, 1);
		GL11.glPopMatrix();
	}
	
	private void renderItem()
	{
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor4f(.5f, .5f, .5f, 1);
		RenderUtils.renderIconYNegative(0, 0, 0, 1, 1, dirt);
		GL11.glColor4f(1, 1, 1, 1);
		RenderUtils.renderIconYPositive(1, 0, 0, 1, 1, grass_top);
		GL11.glColor4f(.6f, .6f, .6f, 1);
		RenderUtils.renderIconXNegative(0, 0, 0, 1, 1, grass_side);
		RenderUtils.renderIconXNegative(0, 0, 0, 1, 1, grass_side_overlay);
		RenderUtils.renderIconXPositive(1, 0, 0, 1, 1, grass_side);
		RenderUtils.renderIconXPositive(1, 0, 0, 1, 1, grass_side_overlay);
		GL11.glColor4f(.8f, .8f, .8f, 1);
		RenderUtils.renderIconZNegative(0, 0, 0, 1, 1, grass_side);
		RenderUtils.renderIconZNegative(0, 0, 0, 1, 1, grass_side_overlay);
		RenderUtils.renderIconZPositive(1, 0, 0, 1, 1, grass_side);
		RenderUtils.renderIconZPositive(1, 0, 0, 1, 1, grass_side_overlay);
		GL11.glEnd();
	}
	
	@Override
	public boolean renderBlock(Block block, BlockModelRenderer modelRenderer, IBlockAccess blockAccess, IBakedModel model, IBlockState state, BlockPos pos, VertexBuffer renderer, boolean checkSides, long rand, boolean useAO)
	{
		boolean flag = state.getValue(BlockGrass.SNOWY);
		BlockColors colors = RenderUtils.getBlockColors(modelRenderer);
		if (state.shouldSideBeRendered(blockAccess, pos, EnumFacing.DOWN))
		{
			RenderUtils.renderSideYNegative(block, state, pos, down, blockAccess, renderer, false, colors);
		}
		if (state.shouldSideBeRendered(blockAccess, pos, EnumFacing.UP))
		{
			RenderUtils.renderSideYPositive(block, state, pos, up, blockAccess, renderer, !flag, colors);
		}
		if (state.shouldSideBeRendered(blockAccess, pos, EnumFacing.WEST))
		{
			if (flag)
			{
				RenderUtils.renderSideXNegative(block, state, pos, westSnowy, blockAccess, renderer, false, colors);
			}
			else
			{
				RenderUtils.renderSideXNegative(block, state, pos, westGrass, blockAccess, renderer, false, colors);
				RenderUtils.renderSideXNegative(block, state, pos, westOverlay, blockAccess, renderer, true, colors);
			}
		}
		if (state.shouldSideBeRendered(blockAccess, pos, EnumFacing.EAST))
		{
			if (flag)
			{
				RenderUtils.renderSideXPositive(block, state, pos, eastSnowy, blockAccess, renderer, false, colors);
			}
			else
			{
				RenderUtils.renderSideXPositive(block, state, pos, eastGrass, blockAccess, renderer, false, colors);
				RenderUtils.renderSideXPositive(block, state, pos, eastOverlay, blockAccess, renderer, true, colors);
			}
		}
		if (state.shouldSideBeRendered(blockAccess, pos, EnumFacing.NORTH))
		{
			if (flag)
			{
				RenderUtils.renderSideZNegative(block, state, pos, northSnowy, blockAccess, renderer, false, colors);
			}
			else
			{
				RenderUtils.renderSideZNegative(block, state, pos, northGrass, blockAccess, renderer, false, colors);
				RenderUtils.renderSideZNegative(block, state, pos, northOverlay, blockAccess, renderer, true, colors);
			}
		}
		if (state.shouldSideBeRendered(blockAccess, pos, EnumFacing.SOUTH))
		{
			if (flag)
			{
				RenderUtils.renderSideZPositive(block, state, pos, southSnowy, blockAccess, renderer, false, colors);
			}
			else
			{
				RenderUtils.renderSideZPositive(block, state, pos, southGrass, blockAccess, renderer, false, colors);
				RenderUtils.renderSideZPositive(block, state, pos, southOverlay, blockAccess, renderer, true, colors);
			}
		}
		return true;
	}
	@Override
	public void onTexturesRegister(TextureMap map)
	{
		dirt = map.registerSprite(new ResourceLocation("minecraft", "blocks/dirt"));
		grass_side_overlay = map.registerSprite(new ResourceLocation("minecraft", "blocks/grass_side_overlay"));
		grass_side_snowed = map.registerSprite(new ResourceLocation("minecraft", "blocks/grass_side_snowed"));
		grass_side = map.registerSprite(new ResourceLocation("minecraft", "blocks/grass_side"));
		grass_top = map.registerSprite(new ResourceLocation("minecraft", "blocks/grass_top"));
	}
	
	@Override
	public void onTexturesLoaded(TextureMap map)
	{
		down = RenderUtils.getSideYNegative(0, 0, 0, 1, 1, 0xFF7F7F7F, dirt);
		up = RenderUtils.getSideYPositive(1, 0, 0, 1, 1, 0xFFFFFFFF, grass_top);
		westGrass = RenderUtils.getSideXNegative(0, 0, 0, 1, 1, 0xFF999999, grass_side);
		westOverlay = RenderUtils.getSideXNegative(0, 0, 0, 1, 1, 0xFF999999, grass_side_overlay);
		westSnowy = RenderUtils.getSideXNegative(0, 0, 0, 1, 1, 0xFF999999, grass_side_snowed);
		eastGrass = RenderUtils.getSideXPositive(1, 0, 0, 1, 1, 0xFF999999, grass_side);
		eastOverlay = RenderUtils.getSideXPositive(1, 0, 0, 1, 1, 0xFF999999, grass_side_overlay);
		eastSnowy = RenderUtils.getSideXPositive(1, 0, 0, 1, 1, 0xFF999999, grass_side_snowed);
		northGrass = RenderUtils.getSideZNegative(0, 0, 0, 1, 1, 0xFFCCCCCC, grass_side);
		northOverlay = RenderUtils.getSideZNegative(0, 0, 0, 1, 1, 0xFFCCCCCC, grass_side_overlay);
		northSnowy = RenderUtils.getSideZNegative(0, 0, 0, 1, 1, 0xFFCCCCCC, grass_side_snowed);
		southGrass = RenderUtils.getSideZPositive(1, 0, 0, 1, 1, 0xFFCCCCCC, grass_side);
		southOverlay = RenderUtils.getSideZPositive(1, 0, 0, 1, 1, 0xFFCCCCCC, grass_side_overlay);
		southSnowy = RenderUtils.getSideZPositive(1, 0, 0, 1, 1, 0xFFCCCCCC, grass_side_snowed);
	}
}