package firemerald.renderapi;

import org.lwjgl.opengl.GL11;

import firemerald.renderapi.api.IItemRenderer;
import firemerald.renderapi.api.ItemRenderType;
import firemerald.renderapi.api.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ExampleRendererBow implements IItemRenderer
{
	float amnt = .01f;
	float chargepercent = 0;
	ModelPowerBeam powerbeam = new ModelPowerBeam();
	ResourceLocation[] beams = new ResourceLocation[] {
			new ResourceLocation("mc3", "item3d/powerbeam.png"), 
			new ResourceLocation("mc3", "item3d/wavebeam.png"), 
			new ResourceLocation("mc3", "item3d/icebeam.png"), 
			new ResourceLocation("mc3", "item3d/plasmabeam.png"), 
			new ResourceLocation("mc3", "item3d/darkbeam.png"), 
			new ResourceLocation("mc3", "item3d/lightbeam.png"), 
			new ResourceLocation("mc3", "item3d/annihilatorbeam.png")
	};
	
	@Override
	public boolean render3DInv(RenderItem renderItem, ItemStack stack)
	{
		return false;
	}

	@Override
	public boolean handeRenderType(ItemRenderType type)
	{
		return type == ItemRenderType.EQUIPPED_RIGHT || type == ItemRenderType.EQUIPPED_LEFT || type == ItemRenderType.EQUIPPED_FIRST_PERSON_RIGHT || type == ItemRenderType.EQUIPPED_FIRST_PERSON_LEFT;
	}

	@Override
	public void renderItem(RenderItem renderItem, ItemStack stack, ItemRenderType type)
	{
		GL11.glPushMatrix();
		if (type == ItemRenderType.EQUIPPED_RIGHT)
		{
			GL11.glRotatef(-86.25f, 1, 0, 0);
			GL11.glRotatef(129.5f, 0, 1, 0);
			GL11.glRotatef(-101.75f, 0, 0, 1);
			GL11.glTranslatef(-.0703125f, .0234375f, .203125f);
		}
		else if (type == ItemRenderType.EQUIPPED_LEFT)
		{
			GL11.glRotatef(86.25f, 1, 0, 0);
			GL11.glRotatef(50.5f, 0, 1, 0);
			GL11.glRotatef(101.75f, 0, 0, 1);
			GL11.glTranslatef(.0703125f, .0234375f, .203125f);
		}
		else if (type == ItemRenderType.EQUIPPED_FIRST_PERSON_RIGHT)
		{
			GL11.glRotatef(67.5f, 1, 0, 0);
			GL11.glRotatef(55.5f, 0, 1, 0);
			GL11.glRotatef(114.5f, 0, 0, 1);
			GL11.glTranslatef(0.046875f, -0.015625f, 0.1875f);
		}
		else if (type == ItemRenderType.EQUIPPED_FIRST_PERSON_LEFT)
		{
			GL11.glRotatef(-67.5f, 1, 0, 0);
			GL11.glRotatef(124.5f, 0, 1, 0);
			GL11.glRotatef(-114.5f, 0, 0, 1);
			GL11.glTranslatef(0.046875f, -0.015625f, 0.1875f);
		}
		GL11.glScalef(.9f, 1.2f, 1f);
		GL11.glEnable(GL11.GL_CULL_FACE);
		int texIndex = stack.getItemDamage() % beams.length;
		float chargepercent = 0;
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		if (player.getHeldItemMainhand() == stack || player.getHeldItemOffhand() == stack)
		{
			chargepercent =  (stack.getMaxItemUseDuration() - player.getItemInUseCount()) * 2400f / stack.getMaxItemUseDuration();
			if (chargepercent > 1) chargepercent = 1;
		}
		Minecraft.getMinecraft().getTextureManager().bindTexture(beams[texIndex]);
		powerbeam.render(null, 4, 0.0F, chargepercent, 0.0F, 0.0F, 0.0625F);
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
			powerbeam.render(null, 4, 0.0F, chargepercent, 0.0F, 0.0F, 0.0625F);
	        GlStateManager.popMatrix();
	        GlStateManager.pushMatrix();
	        GlStateManager.scale(8.0F, 8.0F, 8.0F);
	        float f1 = Minecraft.getSystemTime() % 4873L / 4873.0F / 8.0F;
	        GlStateManager.translate(-f1, 0.0F, 0.0F);
	        GlStateManager.rotate(10.0F, 0.0F, 0.0F, 1.0F);
			powerbeam.render(null, 4, 0.0F, chargepercent, 0.0F, 0.0F, 0.0625F);
	        GlStateManager.popMatrix();
	        GlStateManager.matrixMode(5888);
	        GlStateManager.blendFunc(770, 771);
	        GlStateManager.enableLighting();
	        GlStateManager.depthFunc(515);
	        GlStateManager.depthMask(true);
		}
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glPopMatrix();
        Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
	}

	@Override
	public void onTexturesRegister(TextureMap map) {}

	@Override
	public void onTexturesLoaded(TextureMap map) {}
}
