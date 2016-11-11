package firemerald.renderapi.api;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockFluidRenderer;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class RenderUtils
{
	/** the texture used on enchanted items and other misc things **/
	public static final ResourceLocation RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
	
	/** self-explanatory. BlockColors are used to get the correct color for a block at a position. **/
	public static BlockColors getBlockColors(Minecraft minecraft)
	{
		return ObfuscationReflectionHelper.getPrivateValue(Minecraft.class, minecraft, "blockColors", "field_184127_aH");
	}

	/** self-explanatory. BlockColors are used to get the correct color for a block at a position. **/
	public static BlockColors getBlockColors(BlockModelRenderer renderer)
	{
		return ObfuscationReflectionHelper.getPrivateValue(BlockModelRenderer.class, renderer, "blockColors", "field_187499_a");
	}

	/** self-explanatory. BlockColors are used to get the correct color for a block at a position. **/
	public static BlockColors getBlockColors(BlockFluidRenderer renderer)
	{
		return ObfuscationReflectionHelper.getPrivateValue(BlockFluidRenderer.class, renderer, "blockColors", "field_187500_a");
	}
	
	/** packs some vertex data for use with VertexBuffer **/
	public static int[] packVertex(float x, float y, float z, int color, float u, float v)
	{
		return new int[] {Float.floatToRawIntBits(x), Float.floatToRawIntBits(y), Float.floatToRawIntBits(z), color, Float.floatToRawIntBits(u), Float.floatToRawIntBits(v), 0};
	}
	
	/** gets the vertex data for an arbitrary quad. triangles, lines, and points can be made by using the same vertex more than once. **/
	public static int[] getQuadData(float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3, float x4, float y4, float z4, int color1, int color2, int color3, int color4, float u1, float v1, float u2, float v2, float u3, float v3, float u4, float v4)
	{
		int[] vData = new int[28];
		System.arraycopy(packVertex(x1, y1, z1, color1, u1, v1), 0, vData, 0, 7);
		System.arraycopy(packVertex(x2, y2, z2, color2, u2, v2), 0, vData, 7, 7);
		System.arraycopy(packVertex(x3, y3, z3, color3, u3, v3), 0, vData, 14, 7);
		System.arraycopy(packVertex(x4, y4, z4, color4, u4, v4), 0, vData, 21, 7);
		return vData;
	}
	
	/** gets the vertex data for a side facing negative Y. it picks the UV's from the icon interpolated along the quad **/
	public static int[] getSideYNegative(float y, float x1, float z1, float x2, float z2, int color, TextureAtlasSprite icon)
	{
		int[] vData = new int[28];
		System.arraycopy(packVertex(x1, y, z1, color, icon.getInterpolatedU(x1 * 16), icon.getInterpolatedV(z1 * 16)), 0, vData, 0, 7);
		System.arraycopy(packVertex(x2, y, z1, color, icon.getInterpolatedU(x2 * 16), icon.getInterpolatedV(z1 * 16)), 0, vData, 7, 7);
		System.arraycopy(packVertex(x2, y, z2, color, icon.getInterpolatedU(x2 * 16), icon.getInterpolatedV(z2 * 16)), 0, vData, 14, 7);
		System.arraycopy(packVertex(x1, y, z2, color, icon.getInterpolatedU(x1 * 16), icon.getInterpolatedV(z2 * 16)), 0, vData, 21, 7);
		return vData;
	}

	/** renders the vertex data for a side facing negative Y. withColor is used for blocks like leaves to colorize by biome, ect. BlockColors can be null if withColor is false.**/
	public static void renderSideYNegative(Block block, IBlockState state, BlockPos pos, int[] data, IBlockAccess blockAccess, VertexBuffer worldRendererIn, boolean withColor, BlockColors colors)
	{
		worldRendererIn.addVertexData(data);
		int brightnessIn = state.getPackedLightmapCoords(blockAccess, pos.down());
        worldRendererIn.putBrightness4(brightnessIn, brightnessIn, brightnessIn, brightnessIn);
        if (withColor)
        {
        	int l = colors.colorMultiplier(state, blockAccess, pos, EntityRenderer.anaglyphField);
            if (EntityRenderer.anaglyphEnable) l = TextureUtil.anaglyphColor(l);
            float f = (l >> 16 & 255) / 255.0F;
            float f1 = (l >> 8 & 255) / 255.0F;
            float f2 = (l & 255) / 255.0F;
            worldRendererIn.putColorMultiplier(f, f1, f2, 4);
            worldRendererIn.putColorMultiplier(f, f1, f2, 3);
            worldRendererIn.putColorMultiplier(f, f1, f2, 2);
            worldRendererIn.putColorMultiplier(f, f1, f2, 1);
        }
        worldRendererIn.putPosition(pos.getX(), pos.getY(), pos.getZ());
	}

	/** renders an icon facing negative Y. it picks the UV's from the icon interpolated along the quad **/
	public static void renderIconYNegative(float y, float x1, float z1, float x2, float z2, TextureAtlasSprite icon)
	{
		GL11.glNormal3f(0, -1, 0);
		GL11.glTexCoord2f(icon.getInterpolatedU(x1 * 16), icon.getInterpolatedV(z1 * 16));
		GL11.glVertex3f(x1, y, z1);
		GL11.glTexCoord2f(icon.getInterpolatedU(x2 * 16), icon.getInterpolatedV(z1 * 16));
		GL11.glVertex3f(x2, y, z1);
		GL11.glTexCoord2f(icon.getInterpolatedU(x2 * 16), icon.getInterpolatedV(z2 * 16));
		GL11.glVertex3f(x2, y, z2);
		GL11.glTexCoord2f(icon.getInterpolatedU(x1 * 16), icon.getInterpolatedV(z2 * 16));
		GL11.glVertex3f(x1, y, z2);
	}

	/** gets the vertex data for a side facing positive Y. it picks the UV's from the icon interpolated along the quad **/
	public static int[] getSideYPositive(float y, float x1, float z1, float x2, float z2, int color, TextureAtlasSprite icon)
	{
		int[] vData = new int[28];
		System.arraycopy(packVertex(x1, y, z1, color, icon.getInterpolatedU(x1 * 16), icon.getInterpolatedV((1 - z1) * 16)), 0, vData, 0, 7);
		System.arraycopy(packVertex(x1, y, z2, color, icon.getInterpolatedU(x1 * 16), icon.getInterpolatedV((1 - z2) * 16)), 0, vData, 7, 7);
		System.arraycopy(packVertex(x2, y, z2, color, icon.getInterpolatedU(x2 * 16), icon.getInterpolatedV((1 - z2) * 16)), 0, vData, 14, 7);
		System.arraycopy(packVertex(x2, y, z1, color, icon.getInterpolatedU(x2 * 16), icon.getInterpolatedV((1 - z1) * 16)), 0, vData, 21, 7);
		return vData;
	}

	/** renders the vertex data for a side facing positive Y. withColor is used for blocks like leaves to colorize by biome, ect. BlockColors can be null if withColor is false.**/
	public static void renderSideYPositive(Block block, IBlockState state, BlockPos pos, int[] data, IBlockAccess blockAccess, VertexBuffer worldRendererIn, boolean withColor, BlockColors colors)
	{
		worldRendererIn.addVertexData(data);
		int brightnessIn = state.getPackedLightmapCoords(blockAccess, pos.up());
        worldRendererIn.putBrightness4(brightnessIn, brightnessIn, brightnessIn, brightnessIn);
        if (withColor)
        {
        	int l = colors.colorMultiplier(state, blockAccess, pos, EntityRenderer.anaglyphField);
            if (EntityRenderer.anaglyphEnable) l = TextureUtil.anaglyphColor(l);
            float f = (l >> 16 & 255) / 255.0F;
            float f1 = (l >> 8 & 255) / 255.0F;
            float f2 = (l & 255) / 255.0F;
            worldRendererIn.putColorMultiplier(f, f1, f2, 4);
            worldRendererIn.putColorMultiplier(f, f1, f2, 3);
            worldRendererIn.putColorMultiplier(f, f1, f2, 2);
            worldRendererIn.putColorMultiplier(f, f1, f2, 1);
        }
        worldRendererIn.putPosition(pos.getX(), pos.getY(), pos.getZ());
	}

	/** renders an icon facing positive Y. it picks the UV's from the icon interpolated along the quad **/
	public static void renderIconYPositive(float y, float x1, float z1, float x2, float z2, TextureAtlasSprite icon)
	{
		GL11.glNormal3f(0, -1, 0);
		GL11.glTexCoord2f(icon.getInterpolatedU(x1 * 16), icon.getInterpolatedV((1 - z1) * 16));
		GL11.glVertex3f(x1, y, z1);
		GL11.glTexCoord2f(icon.getInterpolatedU(x1 * 16), icon.getInterpolatedV((1 - z2) * 16));
		GL11.glVertex3f(x1, y, z2);
		GL11.glTexCoord2f(icon.getInterpolatedU(x2 * 16), icon.getInterpolatedV((1 - z2) * 16));
		GL11.glVertex3f(x2, y, z2);
		GL11.glTexCoord2f(icon.getInterpolatedU(x2 * 16), icon.getInterpolatedV((1 - z1) * 16));
		GL11.glVertex3f(x2, y, z1);
	}

	/** gets the vertex data for a side facing negative X. it picks the UV's from the icon interpolated along the quad **/
	public static int[] getSideXNegative(float x, float y1, float z1, float y2, float z2, int color, TextureAtlasSprite icon)
	{
		int[] vData = new int[28];
		System.arraycopy(packVertex(x, y1, z1, color, icon.getInterpolatedU(z1 * 16), icon.getInterpolatedV(y2 * 16)), 0, vData, 0, 7);
		System.arraycopy(packVertex(x, y1, z2, color, icon.getInterpolatedU(z2 * 16), icon.getInterpolatedV(y2 * 16)), 0, vData, 7, 7);
		System.arraycopy(packVertex(x, y2, z2, color, icon.getInterpolatedU(z2 * 16), icon.getInterpolatedV(y1 * 16)), 0, vData, 14, 7);
		System.arraycopy(packVertex(x, y2, z1, color, icon.getInterpolatedU(z1 * 16), icon.getInterpolatedV(y1 * 16)), 0, vData, 21, 7);
		return vData;
	}

	/** renders the vertex data for a side facing negative X. withColor is used for blocks like leaves to colorize by biome, ect. BlockColors can be null if withColor is false.**/
	public static void renderSideXNegative(Block block, IBlockState state, BlockPos pos, int[] data, IBlockAccess blockAccess, VertexBuffer worldRendererIn, boolean withColor, BlockColors colors)
	{
		worldRendererIn.addVertexData(data);
		int brightnessIn = state.getPackedLightmapCoords(blockAccess, pos.west());
        worldRendererIn.putBrightness4(brightnessIn, brightnessIn, brightnessIn, brightnessIn);
        if (withColor)
        {
        	int l = colors.colorMultiplier(state, blockAccess, pos, EntityRenderer.anaglyphField);
            if (EntityRenderer.anaglyphEnable) l = TextureUtil.anaglyphColor(l);
            float f = (l >> 16 & 255) / 255.0F;
            float f1 = (l >> 8 & 255) / 255.0F;
            float f2 = (l & 255) / 255.0F;
            worldRendererIn.putColorMultiplier(f, f1, f2, 4);
            worldRendererIn.putColorMultiplier(f, f1, f2, 3);
            worldRendererIn.putColorMultiplier(f, f1, f2, 2);
            worldRendererIn.putColorMultiplier(f, f1, f2, 1);
        }
        worldRendererIn.putPosition(pos.getX(), pos.getY(), pos.getZ());
	}

	/** renders an icon facing negative X. it picks the UV's from the icon interpolated along the quad **/
	public static void renderIconXNegative(float x, float y1, float z1, float y2, float z2, TextureAtlasSprite icon)
	{
		GL11.glNormal3f(0, -1, 0);
		GL11.glTexCoord2f(icon.getInterpolatedU(z1 * 16), icon.getInterpolatedV(y2 * 16));
		GL11.glVertex3f(x, y1, z1);
		GL11.glTexCoord2f(icon.getInterpolatedU(z2 * 16), icon.getInterpolatedV(y2 * 16));
		GL11.glVertex3f(x, y1, z2);
		GL11.glTexCoord2f(icon.getInterpolatedU(z2 * 16), icon.getInterpolatedV(y1 * 16));
		GL11.glVertex3f(x, y2, z2);
		GL11.glTexCoord2f(icon.getInterpolatedU(z1 * 16), icon.getInterpolatedV(y1 * 16));
		GL11.glVertex3f(x, y2, z1);
	}

	/** gets the vertex data for a side facing positive X. it picks the UV's from the icon interpolated along the quad **/
	public static int[] getSideXPositive(float x, float y1, float z1, float y2, float z2, int color, TextureAtlasSprite icon)
	{
		int[] vData = new int[28];
		System.arraycopy(packVertex(x, y1, z1, color, icon.getInterpolatedU(z2 * 16), icon.getInterpolatedV(y2 * 16)), 0, vData, 0, 7);
		System.arraycopy(packVertex(x, y2, z1, color, icon.getInterpolatedU(z2 * 16), icon.getInterpolatedV(y1 * 16)), 0, vData, 7, 7);
		System.arraycopy(packVertex(x, y2, z2, color, icon.getInterpolatedU(z1 * 16), icon.getInterpolatedV(y1 * 16)), 0, vData, 14, 7);
		System.arraycopy(packVertex(x, y1, z2, color, icon.getInterpolatedU(z1 * 16), icon.getInterpolatedV(y2 * 16)), 0, vData, 21, 7);
		return vData;
	}

	/** renders the vertex data for a side facing positive X. withColor is used for blocks like leaves to colorize by biome, ect. BlockColors can be null if withColor is false.**/
	public static void renderSideXPositive(Block block, IBlockState state, BlockPos pos, int[] data, IBlockAccess blockAccess, VertexBuffer worldRendererIn, boolean withColor, BlockColors colors)
	{
		worldRendererIn.addVertexData(data);
		int brightnessIn = state.getPackedLightmapCoords(blockAccess, pos.east());
        worldRendererIn.putBrightness4(brightnessIn, brightnessIn, brightnessIn, brightnessIn);
        if (withColor)
        {
        	int l = colors.colorMultiplier(state, blockAccess, pos, EntityRenderer.anaglyphField);
            if (EntityRenderer.anaglyphEnable) l = TextureUtil.anaglyphColor(l);
            float f = (l >> 16 & 255) / 255.0F;
            float f1 = (l >> 8 & 255) / 255.0F;
            float f2 = (l & 255) / 255.0F;
            worldRendererIn.putColorMultiplier(f, f1, f2, 4);
            worldRendererIn.putColorMultiplier(f, f1, f2, 3);
            worldRendererIn.putColorMultiplier(f, f1, f2, 2);
            worldRendererIn.putColorMultiplier(f, f1, f2, 1);
        }
        worldRendererIn.putPosition(pos.getX(), pos.getY(), pos.getZ());
	}

	/** renders an icon facing positive X. it picks the UV's from the icon interpolated along the quad **/
	public static void renderIconXPositive(float x, float y1, float z1, float y2, float z2, TextureAtlasSprite icon)
	{
		GL11.glNormal3f(0, -1, 0);
		GL11.glTexCoord2f(icon.getInterpolatedU(z2 * 16), icon.getInterpolatedV(y2 * 16));
		GL11.glVertex3f(x, y1, z1);
		GL11.glTexCoord2f(icon.getInterpolatedU(z2 * 16), icon.getInterpolatedV(y1 * 16));
		GL11.glVertex3f(x, y2, z1);
		GL11.glTexCoord2f(icon.getInterpolatedU(z1 * 16), icon.getInterpolatedV(y1 * 16));
		GL11.glVertex3f(x, y2, z2);
		GL11.glTexCoord2f(icon.getInterpolatedU(z1 * 16), icon.getInterpolatedV(y2 * 16));
		GL11.glVertex3f(x, y1, z2);
	}

	/** gets the vertex data for a side facing negative Z. it picks the UV's from the icon interpolated along the quad **/
	public static int[] getSideZNegative(float z, float x1, float y1, float x2, float y2, int color, TextureAtlasSprite icon)
	{
		int[] vData = new int[28];
		System.arraycopy(packVertex(x1, y1, z, color, icon.getInterpolatedU(x2 * 16), icon.getInterpolatedV(y2 * 16)), 0, vData, 0, 7);
		System.arraycopy(packVertex(x1, y2, z, color, icon.getInterpolatedU(x2 * 16), icon.getInterpolatedV(y1 * 16)), 0, vData, 7, 7);
		System.arraycopy(packVertex(x2, y2, z, color, icon.getInterpolatedU(x1 * 16), icon.getInterpolatedV(y1 * 16)), 0, vData, 14, 7);
		System.arraycopy(packVertex(x2, y1, z, color, icon.getInterpolatedU(x1 * 16), icon.getInterpolatedV(y2 * 16)), 0, vData, 21, 7);
		return vData;
	}

	/** renders the vertex data for a side facing negative Z. withColor is used for blocks like leaves to colorize by biome, ect. BlockColors can be null if withColor is false.**/
	public static void renderSideZNegative(Block block, IBlockState state, BlockPos pos, int[] data, IBlockAccess blockAccess, VertexBuffer worldRendererIn, boolean withColor, BlockColors colors)
	{
		worldRendererIn.addVertexData(data);
		int brightnessIn = state.getPackedLightmapCoords(blockAccess, pos.north());
        worldRendererIn.putBrightness4(brightnessIn, brightnessIn, brightnessIn, brightnessIn);
        if (withColor)
        {
        	int l = colors.colorMultiplier(state, blockAccess, pos, EntityRenderer.anaglyphField);
            if (EntityRenderer.anaglyphEnable) l = TextureUtil.anaglyphColor(l);
            float f = (l >> 16 & 255) / 255.0F;
            float f1 = (l >> 8 & 255) / 255.0F;
            float f2 = (l & 255) / 255.0F;
            worldRendererIn.putColorMultiplier(f, f1, f2, 4);
            worldRendererIn.putColorMultiplier(f, f1, f2, 3);
            worldRendererIn.putColorMultiplier(f, f1, f2, 2);
            worldRendererIn.putColorMultiplier(f, f1, f2, 1);
        }
        worldRendererIn.putPosition(pos.getX(), pos.getY(), pos.getZ());
	}

	/** renders an icon facing negative Z. it picks the UV's from the icon interpolated along the quad **/
	public static void renderIconZNegative(float z, float x1, float y1, float x2, float y2, TextureAtlasSprite icon)
	{
		GL11.glNormal3f(0, -1, 0);
		GL11.glTexCoord2f(icon.getInterpolatedU(x2 * 16), icon.getInterpolatedV(y2 * 16));
		GL11.glVertex3f(x1, y1, z);
		GL11.glTexCoord2f(icon.getInterpolatedU(x2 * 16), icon.getInterpolatedV(y1 * 16));
		GL11.glVertex3f(x1, y2, z);
		GL11.glTexCoord2f(icon.getInterpolatedU(x1 * 16), icon.getInterpolatedV(y1 * 16));
		GL11.glVertex3f(x2, y2, z);
		GL11.glTexCoord2f(icon.getInterpolatedU(x1 * 16), icon.getInterpolatedV(y2 * 16));
		GL11.glVertex3f(x2, y1, z);
	}

	/** gets the vertex data for a side facing positive Z. it picks the UV's from the icon interpolated along the quad **/
	public static int[] getSideZPositive(float z, float x1, float y1, float x2, float y2, int color, TextureAtlasSprite icon)
	{
		int[] vData = new int[28];
		System.arraycopy(packVertex(x1, y1, z, color, icon.getInterpolatedU(x1 * 16), icon.getInterpolatedV(y2 * 16)), 0, vData, 0, 7);
		System.arraycopy(packVertex(x2, y1, z, color, icon.getInterpolatedU(x2 * 16), icon.getInterpolatedV(y2 * 16)), 0, vData, 7, 7);
		System.arraycopy(packVertex(x2, y2, z, color, icon.getInterpolatedU(x2 * 16), icon.getInterpolatedV(y1 * 16)), 0, vData, 14, 7);
		System.arraycopy(packVertex(x1, y2, z, color, icon.getInterpolatedU(x1 * 16), icon.getInterpolatedV(y1 * 16)), 0, vData, 21, 7);
		return vData;
	}

	/** renders the vertex data for a side facing positive Z. withColor is used for blocks like leaves to colorize by biome, ect. BlockColors can be null if withColor is false.**/
	public static void renderSideZPositive(Block block, IBlockState state, BlockPos pos, int[] data, IBlockAccess blockAccess, VertexBuffer worldRendererIn, boolean withColor, BlockColors colors)
	{
		worldRendererIn.addVertexData(data);
		int brightnessIn = state.getPackedLightmapCoords(blockAccess, pos.south());
        worldRendererIn.putBrightness4(brightnessIn, brightnessIn, brightnessIn, brightnessIn);
        if (withColor)
        {
        	int l = colors.colorMultiplier(state, blockAccess, pos, EntityRenderer.anaglyphField);
            if (EntityRenderer.anaglyphEnable) l = TextureUtil.anaglyphColor(l);
            float f = (l >> 16 & 255) / 255.0F;
            float f1 = (l >> 8 & 255) / 255.0F;
            float f2 = (l & 255) / 255.0F;
            worldRendererIn.putColorMultiplier(f, f1, f2, 4);
            worldRendererIn.putColorMultiplier(f, f1, f2, 3);
            worldRendererIn.putColorMultiplier(f, f1, f2, 2);
            worldRendererIn.putColorMultiplier(f, f1, f2, 1);
        }
        worldRendererIn.putPosition(pos.getX(), pos.getY(), pos.getZ());
	}

	/** renders an icon facing positive Z. it picks the UV's from the icon interpolated along the quad **/
	public static void renderIconZPositive(float z, float x1, float y1, float x2, float y2, TextureAtlasSprite icon)
	{
		GL11.glNormal3f(0, -1, 0);
		GL11.glTexCoord2f(icon.getInterpolatedU(x1 * 16), icon.getInterpolatedV(y2 * 16));
		GL11.glVertex3f(x1, y1, z);
		GL11.glTexCoord2f(icon.getInterpolatedU(x2 * 16), icon.getInterpolatedV(y2 * 16));
		GL11.glVertex3f(x2, y1, z);
		GL11.glTexCoord2f(icon.getInterpolatedU(x2 * 16), icon.getInterpolatedV(y1 * 16));
		GL11.glVertex3f(x2, y2, z);
		GL11.glTexCoord2f(icon.getInterpolatedU(x1 * 16), icon.getInterpolatedV(y1 * 16));
		GL11.glVertex3f(x1, y2, z);
	}
}