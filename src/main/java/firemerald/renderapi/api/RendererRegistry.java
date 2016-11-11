package firemerald.renderapi.api;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;

public class RendererRegistry
{
	private static final HashMap<Block, IBlockRenderer> blockRenderers = new HashMap<Block, IBlockRenderer>();
	private static final HashMap<Item, IItemRenderer> itemRenderers = new HashMap<Item, IItemRenderer>();
	public static final Logger logger = LogManager.getLogger("FirEmerald's Renderer API");
	
	/** Registers a block renderer
	 * @param block
	 * @param renderer
	 * @return whether the renderer was registered.
	 */
	public static boolean registerBlockRenderer(Block block, IBlockRenderer renderer)
	{
		if (blockRenderers.containsKey(block))
		{
			logger.warn("Tried to register a new renderer to a block with an existing renderer: " + block.getUnlocalizedName());
			return false;
		}
		blockRenderers.put(block, renderer);
		return true;
	}
	
	/** gets the BlockRenderer for a block
	 * @param block
	 * @return the renderer, or null if there is none
	 */
	public static IBlockRenderer getRendererForBlock(Block block)
	{
		return blockRenderers.get(block);
	}
	
	/** Registers an item renderer
	 * @param item
	 * @param renderer
	 * @return whether the renderer was registered.
	 */
	public static boolean registerItemRenderer(Item item, IItemRenderer renderer)
	{
		if (itemRenderers.containsKey(item))
		{
			logger.warn("Tried to register a new renderer to a item with an existing renderer: " + item.getUnlocalizedName());
			return false;
		}
		itemRenderers.put(item, renderer);
		return true;
	}
	
	/** gets the ItemRenderer for an Item
	 * @param item
	 * @return the renderer, or null if there is none
	 */
	public static IItemRenderer getRendererForItem(Item item)
	{
		return itemRenderers.get(item);
	}
	
	/** used to get TextureAtlasSprite (formerly IIcon) instances needed for renderers<br>
	 * DO NOT CALL! **/ 
	public static void reloadIcons(TextureMap map)
	{
		for (Map.Entry<Block, IBlockRenderer> entry : blockRenderers.entrySet()) entry.getValue().onTexturesRegister(map);
		for (Map.Entry<Item, IItemRenderer> entry : itemRenderers.entrySet()) entry.getValue().onTexturesRegister(map);
	}
	
	/** used to generate model data for renderers the same way the current model format uses<br>
	 * DO NOT CALL! **/
	public static void reloadData(TextureMap map)
	{
		for (Map.Entry<Block, IBlockRenderer> entry : blockRenderers.entrySet()) entry.getValue().onTexturesLoaded(map);
		for (Map.Entry<Item, IItemRenderer> entry : itemRenderers.entrySet()) entry.getValue().onTexturesLoaded(map);
	}
}