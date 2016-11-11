API for the Block/Item model render API, MC 1.10.2

The purpose of the Block/Item model render mod, and this API, is to allow modders to use coded block and item models, removing most of the restrictions caused by the addition of blockmodels to the resources.

Item models can be almost immediately ported with just a few tweaks.
Block models cannot be ported and must be re-written using VertexBuffer functions. There are several methods inside RenderUtils that you can use, and learn from.

Included seperately from the API are 2 example files, ExampleRendererGrass.java and ExampleRendererBow.java.
ExampleRendererGrass.java is a block renderer that reconstructs almost every aspect of the default grass model, but in code.
ExampleRendererBow.java is an item renderer that shows you can still use your old techne/tabula models for items, as well as animate them and use different textures instead of icons. It uses the model for the PowerBeam from Metroid Cubed 3, another mod I own. the model is included - ModelPowerBeam.java