package firemerald.renderapi;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPowerBeam extends ModelBase {

	ModelRenderer CannonComplete;
	ModelRenderer Muzzle;
	ModelRenderer LargeT;
	ModelRenderer LargeR;
	ModelRenderer LargeBR;
	ModelRenderer SmallBR;
	ModelRenderer SmallR;
	ModelRenderer RingC;
	ModelRenderer RingCBL;
	ModelRenderer RingCB;
	ModelRenderer RingCTR;
	ModelRenderer RingCR;
	ModelRenderer RingB;
	ModelRenderer RingBBL;
	ModelRenderer RingBT;
	ModelRenderer RingBTR;
	ModelRenderer RingBB;
	ModelRenderer RingBR;
	ModelRenderer RingA;
	ModelRenderer RingAB;
	ModelRenderer RingABT;
	ModelRenderer RingABL;
	ModelRenderer RingAR;
	ModelRenderer RingATR;
	ModelRenderer SidePanelR;
	ModelRenderer BottomExtendR1;
	ModelRenderer SidePanelL;
	ModelRenderer SideFlatL3;
	ModelRenderer SideExtendL1;
	ModelRenderer CorePanelR;
	ModelRenderer SideFlatR2;
	ModelRenderer CorePanelL;
	ModelRenderer SideFlatL1;
	ModelRenderer SideFlatL2;
	ModelRenderer StockPanelR;
	ModelRenderer StockPanelL;
	ModelRenderer FlatBackL;
	ModelRenderer CenterPanelR;
	ModelRenderer CenterPanelL;
	ModelRenderer TopMidOverlayL;
	ModelRenderer TopMidExtendL;
	ModelRenderer ConfigCube;
	ModelRenderer SideCircR;
	ModelRenderer SideRCirc;
	ModelRenderer SideROverlay;
	ModelRenderer CannonCore;
	ModelRenderer SideCircL;
	ModelRenderer PlasmaBarrel;
	ModelRenderer PlasmaCore;
	ModelRenderer Arm_Cannon;

	public ModelPowerBeam() {
		textureWidth = 64;
		textureHeight = 64;

		CannonComplete = new ModelRenderer(this, "CannonComplete");
		CannonComplete.setRotationPoint(0F, 0F, 0F);
		setRotation(CannonComplete, 0F, 0F, 0F);
		CannonComplete.mirror = true;

		Muzzle = new ModelRenderer(this, "Muzzle");

		Muzzle.setRotationPoint(0F, 0F, -11.5F);
		setRotation(Muzzle, 0F, 0F, 0F);
		Muzzle.mirror = true;

		this.setTextureOffset("Muzzle.LargeB", 0, 60);
		Muzzle.addBox("LargeB", -1.5F, 0.8F, -2.2F, 3, 1, 3);

		this.setTextureOffset("Muzzle.LargeBL", 0, 56);
		Muzzle.addBox("LargeBL", 1.1F, 0.4F, -2.2F, 1, 1, 3);

		this.setTextureOffset("Muzzle.LargeL", 0, 51);
		Muzzle.addBox("LargeL", 1.5F, -1.2F, -2.2F, 1, 2, 3);

		this.setTextureOffset("Muzzle.LargeTL", 8, 56);
		Muzzle.addBox("LargeTL", 1.1F, -1.8F, -2.2F, 1, 1, 3);

		this.setTextureOffset("Muzzle.LargeT", 0, 47);
		Muzzle.addBox("LargeT", -1.5F, -2.3F, -2.2F, 3, 1, 3);

		this.setTextureOffset("Muzzle.LargeTR", 8, 56);
		Muzzle.addBox("LargeTR", -2.1F, -1.8F, -2.2F, 1, 1, 3);

		this.setTextureOffset("Muzzle.LargeR", 0, 51);
		Muzzle.addBox("LargeR", -2.5F, -1.2F, -2.2F, 1, 2, 3);

		this.setTextureOffset("Muzzle.LargeBR", 0, 56);
		Muzzle.addBox("LargeBR", -2.1F, 0.4F, -2.2F, 1, 1, 3);

		this.setTextureOffset("Muzzle.MedT", 0, 44);
		Muzzle.addBox("MedT", -1.5F, -2F, -3.1F, 3, 1, 1);
		this.setTextureOffset("Muzzle.MedTL", 0, 42);
		Muzzle.addBox("MedTL", 0.9F, -1.6F, -3.1F, 1, 1, 1);
		this.setTextureOffset("Muzzle.MedL", 4, 41);
		Muzzle.addBox("MedL", 1.3F, -1.2F, -3.1F, 1, 2, 1);
		this.setTextureOffset("Muzzle.MedBL", 0, 42);
		Muzzle.addBox("MedBL", 0.9F, 0.2F, -3.1F, 1, 1, 1);
		this.setTextureOffset("Muzzle.MedB", 0, 44);
		Muzzle.addBox("MedB", -1.5F, 0.6F, -3.1F, 3, 1, 1);
		this.setTextureOffset("Muzzle.MedBR", 0, 42);
		Muzzle.addBox("MedBR", -1.9F, 0.2F, -3.1F, 1, 1, 1);
		this.setTextureOffset("Muzzle.MedR", 4, 41);
		Muzzle.addBox("MedR", -2.3F, -1.2F, -3.1F, 1, 2, 1);
		this.setTextureOffset("Muzzle.MedTR", 0, 42);
		Muzzle.addBox("MedTR", -1.9F, -1.6F, -3.1F, 1, 1, 1);
		this.setTextureOffset("Muzzle.SmallT", 0, 37);
		Muzzle.addBox("SmallT", -1F, -1.8F, -5.1F, 2, 1, 2);
		this.setTextureOffset("Muzzle.SmallTL", 0, 34);
		Muzzle.addBox("SmallTL", 0.7F, -1.4F, -5.1F, 1, 1, 2);
		this.setTextureOffset("Muzzle.SmallL", 0, 30);
		Muzzle.addBox("SmallL", 1.1F, -1.2F, -5.1F, 1, 2, 2);
		this.setTextureOffset("Muzzle.SmallBL", 0, 34);
		Muzzle.addBox("SmallBL", 0.7F, 0F, -5.1F, 1, 1, 2);
		this.setTextureOffset("Muzzle.SmallB", 0, 37);
		Muzzle.addBox("SmallB", -1F, 0.4F, -5.1F, 2, 1, 2);
		this.setTextureOffset("Muzzle.SmallBR", 0, 34);
		Muzzle.addBox("SmallBR", -1.7F, 0F, -5.1F, 1, 1, 2);
		this.setTextureOffset("Muzzle.SmallR", 0, 30);
		Muzzle.addBox("SmallR", -2.1F, -1.2F, -5.1F, 1, 2, 2);
		this.setTextureOffset("Muzzle.SmallTR", 0, 34);
		Muzzle.addBox("SmallTR", -1.7F, -1.4F, -5.1F, 1, 1, 2);
		this.setTextureOffset("Muzzle.Black", 12, 61);
		Muzzle.addBox("Black", -1F, -1F, -5F, 2, 2, 1);
		CannonComplete.addChild(Muzzle);
		RingC = new ModelRenderer(this, "RingC");
		RingC.setRotationPoint(0F, 0F, -10F);
		setRotation(RingC, 0F, 0F, 0F);
		RingC.mirror = true;
		this.setTextureOffset("RingC.RingCT", 0, 27);
		RingC.addBox("RingCT", -1.5F, -2.3F, -0.5F, 3, 1, 1);
		this.setTextureOffset("RingC.RingCTL", 0, 25);
		RingC.addBox("RingCTL", 1.1F, -1.8F, -0.5F, 1, 1, 1);
		this.setTextureOffset("RingC.RingCL", 5, 24);
		RingC.addBox("RingCL", 1.5F, -1.2F, -0.5F, 1, 2, 1);
		this.setTextureOffset("RingC.RingCBL", 0, 25);
		RingC.addBox("RingCBL", 1.1F, 0.4F, -0.5F, 1, 1, 1);
		this.setTextureOffset("RingC.RingCB", 0, 27);
		RingC.addBox("RingCB", -1.5F, 0.8F, -0.5F, 3, 1, 1);
		this.setTextureOffset("RingC.RingCBR", 0, 23);
		RingC.addBox("RingCBR", -2.1F, 0.4F, -0.5F, 1, 1, 1);
		this.setTextureOffset("RingC.RingCR", 5, 23);
		RingC.addBox("RingCR", -2.5F, -1.2F, -0.5F, 1, 2, 1);
		this.setTextureOffset("RingC.RingCTR", 0, 23);
		RingC.addBox("RingCTR", -2.1F, -1.8F, -0.5F, 1, 1, 1);
		CannonComplete.addChild(RingC);
		RingB = new ModelRenderer(this, "RingB");
		RingB.setRotationPoint(0F, 0F, -8.8F);
		setRotation(RingB, 0F, 0F, 0F);
		RingB.mirror = true;
		this.setTextureOffset("RingB.RingBT", 0, 27);
		RingB.addBox("RingBT", -1.5F, -2.3F, -0.5F, 3, 1, 1);
		this.setTextureOffset("RingB.RingBTL", 0, 25);
		RingB.addBox("RingBTL", 1.1F, -1.8F, -0.5F, 1, 1, 1);
		this.setTextureOffset("RingB.RingBL", 5, 23);
		RingB.addBox("RingBL", 1.5F, -1.2F, -0.5F, 1, 2, 1);
		this.setTextureOffset("RingB.RingBBL", 0, 25);
		RingB.addBox("RingBBL", 1.1F, 0.4F, -0.5F, 1, 1, 1);
		this.setTextureOffset("RingB.RingBB", 0, 27);
		RingB.addBox("RingBB", -1.5F, 0.8F, -0.5F, 3, 1, 1);
		this.setTextureOffset("RingB.RingBBR", 0, 23);
		RingB.addBox("RingBBR", -2.1F, 0.4F, -0.5F, 1, 1, 1);
		this.setTextureOffset("RingB.RingBR", 5, 23);
		RingB.addBox("RingBR", -2.5F, -1.2F, -0.5F, 1, 2, 1);
		this.setTextureOffset("RingB.RingBTR", 0, 23);
		RingB.addBox("RingBTR", -2.1F, -1.8F, -0.5F, 1, 1, 1);
		CannonComplete.addChild(RingB);
		RingA = new ModelRenderer(this, "RingA");
		RingA.setRotationPoint(0F, 0F, -7.6F);
		setRotation(RingA, 0F, 0F, 0F);
		RingA.mirror = true;
		this.setTextureOffset("RingA.RingAT", 0, 27);
		RingA.addBox("RingAT", -1.5F, -2.3F, -0.5F, 3, 1, 1);
		this.setTextureOffset("RingA.RingATL", 0, 25);
		RingA.addBox("RingATL", 1.1F, -1.8F, -0.5F, 1, 1, 1);
		this.setTextureOffset("RingA.RingAL", 5, 23);
		RingA.addBox("RingAL", 1.5F, -1.2F, -0.5F, 1, 2, 1);
		this.setTextureOffset("RingA.RingABL", 0, 25);
		RingA.addBox("RingABL", 1.1F, 0.4F, -0.5F, 1, 1, 1);
		this.setTextureOffset("RingA.RingAB", 0, 27);
		RingA.addBox("RingAB", -1.5F, 0.8F, -0.5F, 3, 1, 1);
		this.setTextureOffset("RingA.RingABR", 0, 23);
		RingA.addBox("RingABR", -2.1F, 0.4F, -0.5F, 1, 1, 1);
		this.setTextureOffset("RingA.RingAR", 5, 23);
		RingA.addBox("RingAR", -2.5F, -1.2F, -0.5F, 1, 2, 1);
		this.setTextureOffset("RingA.RingATR", 0, 23);
		RingA.addBox("RingATR", -2.1F, -1.8F, -0.5F, 1, 1, 1);
		CannonComplete.addChild(RingA);
		SidePanelR = new ModelRenderer(this, "SidePanelR");
		SidePanelR.setRotationPoint(-2F, -2F, -3.9F);
		setRotation(SidePanelR, 0F, 0F, 0F);
		SidePanelR.mirror = true;
		this.setTextureOffset("SidePanelR.SideFlatR3", 19, 60);
		SidePanelR.addBox("SideFlatR3", -0.5F, -0.3F, -3F, 1, 1, 3);
		this.setTextureOffset("SidePanelR.SideExtendR1", 27, 56);
		SidePanelR.addBox("SideExtendR1", -0.9F, 0.2F, -3F, 1, 3, 5);
		this.setTextureOffset("SidePanelR.BottomExtendR1", 17, 55);
		SidePanelR.addBox("BottomExtendR1", -0.5F, 2.8F, -3F, 1, 1, 4);
		CannonComplete.addChild(SidePanelR);
		SidePanelL = new ModelRenderer(this, "SidePanelL");
		SidePanelL.setRotationPoint(2F, -2F, -3.9F);
		setRotation(SidePanelL, 0F, 0F, 0F);
		SidePanelL.mirror = true;
		this.setTextureOffset("SidePanelL.SideFlatL3", 19, 60);
		SidePanelL.addBox("SideFlatL3", -0.5F, -0.3F, -3F, 1, 1, 3);
		this.setTextureOffset("SidePanelL.SideExtendL1", 27, 56);
		SidePanelL.addBox("SideExtendL1", -0.1F, 0.2F, -3F, 1, 3, 5);
		this.setTextureOffset("SidePanelL.BottomExtendL1", 17, 55);
		SidePanelL.addBox("BottomExtendL1", -0.5F, 2.8F, -3F, 1, 1, 4);
		CannonComplete.addChild(SidePanelL);
		CorePanelR = new ModelRenderer(this, "CorePanelR");
		CorePanelR.setRotationPoint(-1F, -1.8F, -4F);
		setRotation(CorePanelR, 0F, 0F, 0F);
		CorePanelR.mirror = true;
		this.setTextureOffset("CorePanelR.SideFlatR1", 13, 50);
		CorePanelR.addBox("SideFlatR1", -0.8F, -0.7F, -2.9F, 1, 1, 3);
		this.setTextureOffset("CorePanelR.SideFlatR2", 19, 50);
		CorePanelR.addBox("SideFlatR2", -0.1F, -0.7F, -2.9F, 1, 1, 1);
		CannonComplete.addChild(CorePanelR);
		CorePanelL = new ModelRenderer(this, "CorePanelL");
		CorePanelL.setRotationPoint(1F, -1.8F, -4F);
		setRotation(CorePanelL, 0F, 0F, 0F);
		CorePanelL.mirror = true;
		this.setTextureOffset("CorePanelL.SideFlatL1", 13, 50);
		CorePanelL.addBox("SideFlatL1", -0.2F, -0.7F, -2.9F, 1, 1, 3);
		this.setTextureOffset("CorePanelL.SideFlatL2", 19, 50);
		CorePanelL.addBox("SideFlatL2", -1.1F, -0.7F, -2.9F, 1, 1, 1);
		CannonComplete.addChild(CorePanelL);
		StockPanelR = new ModelRenderer(this, "StockPanelR");
		StockPanelR.setRotationPoint(-2F, -2F, 0F);
		setRotation(StockPanelR, 0F, 0F, 0F);
		StockPanelR.mirror = true;
		this.setTextureOffset("StockPanelR.FlatBackR", 11, 42);
		StockPanelR.addBox("FlatBackR", -0.7F, -0.7F, -3.9F, 2, 2, 5);
		CannonComplete.addChild(StockPanelR);
		StockPanelL = new ModelRenderer(this, "StockPanelL");
		StockPanelL.setRotationPoint(2F, -2F, 0F);
		setRotation(StockPanelL, 0F, 0F, 0F);
		StockPanelL.mirror = true;
		this.setTextureOffset("StockPanelL.FlatBackL", 11, 42);
		StockPanelL.addBox("FlatBackL", -1.4F, -0.7F, -3.9F, 2, 2, 5);
		CannonComplete.addChild(StockPanelL);
		CenterPanelR = new ModelRenderer(this, "CenterPanelR");
		CenterPanelR.setRotationPoint(-1F, -2.5F, 0F);
		setRotation(CenterPanelR, 0F, 0F, 0F);
		CenterPanelR.mirror = true;
		this.setTextureOffset("CenterPanelR.TopMidOverlayR", 10, 36);
		CenterPanelR.addBox("TopMidOverlayR", -1F, -0.5F, -3.2F, 1, 1, 4);
		this.setTextureOffset("CenterPanelR.TopMidExtendR", 10, 36);
		CenterPanelR.addBox("TopMidExtendR", -0.1F, -0.5F, -6F, 1, 1, 4);
		CannonComplete.addChild(CenterPanelR);
		CenterPanelL = new ModelRenderer(this, "CenterPanelL");
		CenterPanelL.setRotationPoint(1F, -2.5F, 0F);
		setRotation(CenterPanelL, 0F, 0F, 0F);
		CenterPanelL.mirror = true;
		this.setTextureOffset("CenterPanelL.TopMidOverlayL", 10, 36);
		CenterPanelL.addBox("TopMidOverlayL", -0.1F, -0.5F, -3.2F, 1, 1, 4);
		this.setTextureOffset("CenterPanelL.TopMidExtendL", 10, 36);
		CenterPanelL.addBox("TopMidExtendL", -1.1F, -0.5F, -6F, 1, 1, 4);
		CannonComplete.addChild(CenterPanelL);
		ConfigCube = new ModelRenderer(this, "ConfigCube");
		ConfigCube.setRotationPoint(0F, -2.5F, 0F);
		setRotation(ConfigCube, 0F, 0F, 0F);
		ConfigCube.mirror = true;
		this.setTextureOffset("ConfigCube.CubeMain", 9, 29);
		ConfigCube.addBox("CubeMain", -1F, -1F, -2.1F, 2, 3, 3);
		CannonComplete.addChild(ConfigCube);
		SideCircR = new ModelRenderer(this, "SideCircR");
		SideCircR.setRotationPoint(-2.5F, 0F, -2.1F);
		setRotation(SideCircR, 0F, 0F, 0F);
		SideCircR.mirror = true;
		this.setTextureOffset("SideCircR.SideRCirc", 10, 22);
		SideCircR.addBox("SideRCirc", -1F, -1.5F, -0.5F, 1, 3, 3);
		this.setTextureOffset("SideCircR.SideROverlay", 10, 14);
		SideCircR.addBox("SideROverlay", -0.5F, -2.3F, -1F, 3, 4, 4);
		CannonComplete.addChild(SideCircR);
		SideCircL = new ModelRenderer(this, "SideCircL");
		SideCircL.setRotationPoint(2.5F, 0F, -2.1F);
		setRotation(SideCircL, 0F, 0F, 0F);
		SideCircL.mirror = true;
		this.setTextureOffset("SideCircL.SideLCirc", 10, 22);
		SideCircL.addBox("SideLCirc", 0F, -1.5F, -0.5F, 1, 3, 3);
		this.setTextureOffset("SideCircL.SideLOverlay", 10, 14);
		SideCircL.addBox("SideLOverlay", -2.5F, -2.3F, -1F, 3, 4, 4);
		CannonComplete.addChild(SideCircL);
		CannonCore = new ModelRenderer(this, "CannonCore");
		CannonCore.setRotationPoint(0F, 0F, 0F);
		setRotation(CannonCore, 0F, 0F, 0F);
		CannonCore.mirror = true;
		this.setTextureOffset("CannonCore.CannonCoreMain", 27, 44);
		CannonCore.addBox("CannonCoreMain", -2F, -2F, -6F, 4, 4, 7);
		this.setTextureOffset("CannonCore.CannonStock", 27, 39);
		CannonCore.addBox("CannonStock", -2F, -2.5F, 0.4F, 4, 4, 1);
		this.setTextureOffset("CannonCore.BottomExtend1", 37, 42);
		CannonCore.addBox("BottomExtend1", -2F, 1F, -6.9F, 4, 1, 1);
		CannonComplete.addChild(CannonCore);
		PlasmaBarrel = new ModelRenderer(this, "PlasmaBarrel");
		PlasmaBarrel.setRotationPoint(0F, 0F, -10.5F);
		setRotation(PlasmaBarrel, 0F, 0F, 0F);
		PlasmaBarrel.mirror = true;
		this.setTextureOffset("PlasmaBarrel.Plasma1T", 48, 0);
		PlasmaBarrel.addBox("Plasma1T", -1.5F, -1.8F, -0.5F, 3, 1, 5);
		this.setTextureOffset("PlasmaBarrel.Plasma1TL", 36, 0);
		PlasmaBarrel.addBox("Plasma1TL", 0.8F, -1.5F, -0.5F, 1, 1, 5);
		this.setTextureOffset("PlasmaBarrel.Plasma1AL", 52, 6);
		PlasmaBarrel.addBox("Plasma1AL", 1F, -1.2F, -0.5F, 1, 2, 5);
		this.setTextureOffset("PlasmaBarrel.Plasma1ABL", 36, 0);
		PlasmaBarrel.addBox("Plasma1ABL", 0.8F, 0.1F, -0.5F, 1, 1, 5);
		this.setTextureOffset("PlasmaBarrel.Plasma1AB", 48, 0);
		PlasmaBarrel.addBox("Plasma1AB", -1.5F, 0.4F, -0.5F, 3, 1, 5);
		this.setTextureOffset("PlasmaBarrel.Plasma1ABR", 36, 0);
		PlasmaBarrel.addBox("Plasma1ABR", -1.8F, 0.1F, -0.5F, 1, 1, 5);
		this.setTextureOffset("PlasmaBarrel.Plasma1AR", 52, 6);
		PlasmaBarrel.addBox("Plasma1AR", -2F, -1.2F, -0.5F, 1, 2, 5);
		this.setTextureOffset("PlasmaBarrel.PlasmaATR", 36, 0);
		PlasmaBarrel.addBox("PlasmaATR", -1.8F, -1.5F, -0.5F, 1, 1, 5);
		CannonComplete.addChild(PlasmaBarrel);
		PlasmaCore = new ModelRenderer(this, "PlasmaCore");
		PlasmaCore.setRotationPoint(0F, -2F, -3F);
		setRotation(PlasmaCore, 0F, 0F, 0F);
		PlasmaCore.mirror = true;
		this.setTextureOffset("PlasmaCore.Center1", 0, 0);
		PlasmaCore.addBox("Center1", -1F, -0.4F, -3.1F, 2, 1, 5);
		this.setTextureOffset("PlasmaCore.CenterL1", 0, 6);
		PlasmaCore.addBox("CenterL1", 0.8F, -0.2F, -3F, 1, 1, 3);
		this.setTextureOffset("PlasmaCore.CenterR1", 0, 6);
		PlasmaCore.addBox("CenterR1", -1.9F, -0.2F, -3F, 1, 1, 3);
		this.setTextureOffset("PlasmaCore.Bridge", 8, 6);
		PlasmaCore.addBox("Bridge", -1F, -0.1F, -3.5F, 2, 1, 1);
		this.setTextureOffset("PlasmaCore.Bridge2", 51, 2);
		PlasmaCore.addBox("Bridge2", -1F, -0.9F, -0.2F, 2, 1, 3);
		CannonComplete.addChild(PlasmaCore);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		CannonComplete.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float ct, float f3,
			float f4, float f5, Entity ent) {
		super.setRotationAngles(f, f1, ct, f3, f4, f5, ent);
		if (f == 1)
		{
			zeroout();

			this.ConfigCube.offsetY = 0 + (-.3F*ct/.9F/16F);
			this.SideCircL.offsetX = 0 + (1F*ct/.9F/16F);
			this.SideCircR.offsetX = 0 + (-1F*ct/.9F/16F);
			this.StockPanelL.offsetX = 0 + (1F*ct/.9F/16F);
			this.StockPanelR.offsetX = 0 + (-1F*ct/.9F/16F);
			this.CenterPanelL.offsetX = 0 + (.5F*ct/.9F/16F);
			this.CenterPanelR.offsetX = 0 + (-.5F*ct/.9F/16F);
			this.CorePanelL.offsetX = 0 + (1F*ct/.9F/16F);
			this.CorePanelR.offsetX = 0 + (-1F*ct/.9F/16F);
			this.SidePanelL.offsetX = 0 + (.5F*ct/.9F/16F);
			this.SidePanelR.offsetX = 0 + (-.5F*ct/.9F/16F);

			this.CenterPanelL.offsetY = 0 + (-.2F*ct/.9F/16F);
			this.CenterPanelR.offsetY = 0 + (-.2F*ct/.9F/16F);
			this.StockPanelL.offsetY = 0;
			this.StockPanelR.offsetY = 0;
			this.CorePanelL.offsetY = 0;
			this.CorePanelR.offsetY = 0;
			
			this.CenterPanelL.offsetZ = 0;
			this.CenterPanelR.offsetZ = 0;
			this.SidePanelL.offsetZ = 0;
			this.SidePanelR.offsetZ = 0;
			this.CorePanelL.offsetZ = 0;
			this.CorePanelR.offsetZ = 0;
			this.RingA.offsetZ = 0 + (-1F*ct/.9F/16F);
			this.RingB.offsetZ = 0 + (-1F*ct/.9F/16F);
			this.RingC.offsetZ = 0 + (-1F*ct/.9F/16F);
			this.Muzzle.offsetZ = 0 + (-1F*ct/.9F/16F);
			this.PlasmaBarrel.offsetZ = 0;
			this.ConfigCube.offsetZ = 0;
		}
		if (f == 2)
		{
			zeroout();

			this.ConfigCube.offsetY = -1F/.9F/16F + (.7F*ct/.9F/16F);
			this.CenterPanelL.offsetY = -.5F/.9F/16F + (.3F*ct/.9F/16F);
			this.CenterPanelL.offsetY = -.5F/.9F/16F + (.3F*ct/.9F/16F);
			this.StockPanelL.offsetY = -.3F/.9F/16F + (.1F*ct/.9F/16F);
			this.StockPanelR.offsetY = -.3F/.9F/16F + (.1F*ct/.9F/16F);
			this.SidePanelL.offsetX = -.3F/.9F/16F;
			this.SidePanelR.offsetX = .3F/.9F/16F;
			this.CorePanelL.offsetY = -.3F/.9F/16F + (.1F*ct/.9F/16F);
			this.CorePanelL.offsetY = -.3F/.9F/16F + (.1F*ct/.9F/16F);
			this.RingA.offsetZ = 0 + (-1F*ct/.9F/16F);
			this.RingB.offsetZ = 0 + (-1F*ct/.9F/16F);
			this.RingC.offsetZ = 0 + (-1F*ct/.9F/16F);
			this.Muzzle.offsetZ = 0 + (-1F*ct/.9F/16F);
		}

		if (f == 3)
		{
			zeroout();

			this.SideCircL.offsetX = .5F/.9F/16F + (-.2F*ct/.9F/16F);
			this.SideCircR.offsetX = -.5F/.9F/16F + (.2F*ct/.9F/16F);
			this.StockPanelL.offsetX = .5F/.9F/16F + (-.2F*ct/.9F/16F);
			this.StockPanelR.offsetX = -.5F/.9F/16F + (.2F*ct/.9F/16F);
			this.CorePanelL.offsetX = .5F/.9F/16F + (-.2F*ct/.9F/16F);
			this.CorePanelR.offsetX = -.5F/.9F/16F + (.2F*ct/.9F/16F);
			this.CenterPanelL.offsetX = .1F/.9F/16F;
			this.CenterPanelR.offsetX = -.1F/.9F/16F;
			this.RingA.offsetZ = 0 + (-1F*ct/.9F/16F);
			this.RingB.offsetZ = 0 + (-1F*ct/.9F/16F);
			this.RingC.offsetZ = 0 + (-1F*ct/.9F/16F);
			this.Muzzle.offsetZ = 0 + (-1F*ct/.9F/16F);
			
		}

		if (f == 4)
		{
			zeroout();
			
			this.CenterPanelL.offsetZ = -1.5F/.9F/16F + (1.2F*ct/.9F/16F);
			this.CenterPanelR.offsetZ = -1.5F/.9F/16F + (1.2F*ct/.9F/16F);
			this.SidePanelL.offsetZ = -.4F/.9F/16F + (.1F*ct/.9F/16F);
			this.SidePanelR.offsetZ = -.4F/.9F/16F + (.1F*ct/.9F/16F);
			this.CorePanelL.offsetZ = -1F/.9F/16F + (-.7F*ct/.9F/16F);
			this.CorePanelL.offsetZ = -1F/.9F/16F + (.7F*ct/.9F/16F);
			this.RingA.offsetZ = -1F/.9F/16F + (-.7F*ct/.9F/16F);
			this.RingB.offsetZ = -1F/.9F/16F + (-.7F*ct/.9F/16F);
			this.RingC.offsetZ = -1F/.9F/16F + (-.7F*ct/.9F/16F);
			this.Muzzle.offsetZ = -1F/.9F/16F + (-.7F*ct/.9F/16F);
			this.PlasmaBarrel.offsetZ = -1F/.9F/16F + (.7F*ct/.9F/16F);
			this.ConfigCube.offsetZ = -1F/.9F/16F;
			this.ConfigCube.offsetY = 3F/.9F/16F;
		}
		
		if (f == 5)
		{
			zeroout();

			this.ConfigCube.offsetY = 0 + (-.3F/.9F/16F);
			this.SideCircL.offsetX = 0 + (1F/.9F/16F);
			this.SideCircR.offsetX = 0 + (-1F/.9F/16F);
			this.StockPanelL.offsetX = 0 + (1F/.9F/16F);
			this.StockPanelR.offsetX = 0 + (-1F/.9F/16F);
			this.CenterPanelL.offsetX = 0 + (.5F/.9F/16F);
			this.CenterPanelR.offsetX = 0 + (-.5F/.9F/16F);
			this.CorePanelL.offsetX = 0 + (1F/.9F/16F);
			this.CorePanelR.offsetX = 0 + (-1F/.9F/16F);
			this.SidePanelL.offsetX = 0 + (.5F/.9F/16F);
			this.SidePanelR.offsetX = 0 + (-.5F/.9F/16F);

			this.CenterPanelL.offsetY = 0 + (-.2F/.9F/16F);
			this.CenterPanelR.offsetY = 0 + (-.2F/.9F/16F);
			this.StockPanelL.offsetY = 0;
			this.StockPanelR.offsetY = 0;
			this.CorePanelL.offsetY = 0;
			this.CorePanelR.offsetY = 0;
			
			this.CenterPanelL.offsetZ = 0;
			this.CenterPanelR.offsetZ = 0;
			this.SidePanelL.offsetZ = 0;
			this.SidePanelR.offsetZ = 0;
			this.CorePanelL.offsetZ = 0;
			this.CorePanelR.offsetZ = 0;
			this.RingA.offsetZ = 0 + (-1F/.9F/16F);
			this.RingB.offsetZ = 0 + (-1F/.9F/16F);
			this.RingC.offsetZ = 0 + (-1F/.9F/16F);
			this.Muzzle.offsetZ = 0 + (-1F/.9F/16F);
			this.PlasmaBarrel.offsetZ = 0;
			this.ConfigCube.offsetZ = 0;
		}
	}
	public void zeroout()
	{
		this.ConfigCube.offsetX = 0;
		this.SideCircL.offsetX = 0;
		this.SideCircR.offsetX = 0;
		this.StockPanelL.offsetX = 0;
		this.StockPanelR.offsetX = 0;
		this.CenterPanelL.offsetX = 0;
		this.CenterPanelR.offsetX = 0;
		this.CorePanelL.offsetX = 0;
		this.CorePanelR.offsetX = 0;
		this.SidePanelL.offsetX = 0;
		this.SidePanelR.offsetX = 0;
		
		this.ConfigCube.offsetY = 0;
		this.SideCircL.offsetY = 0;
		this.SideCircR.offsetY = 0;
		this.StockPanelL.offsetY = 0;
		this.StockPanelR.offsetY = 0;
		this.CenterPanelL.offsetY = 0;
		this.CenterPanelR.offsetY = 0;
		this.CorePanelL.offsetY = 0;
		this.CorePanelR.offsetY = 0;
		this.SidePanelL.offsetY = 0;
		this.SidePanelR.offsetY = 0;
		
		this.ConfigCube.offsetZ = 0;
		this.SideCircL.offsetZ = 0;
		this.SideCircR.offsetZ = 0;
		this.StockPanelL.offsetZ = 0;
		this.StockPanelR.offsetZ = 0;
		this.CenterPanelL.offsetZ = 0;
		this.CenterPanelR.offsetZ = 0;
		this.CorePanelL.offsetZ = 0;
		this.CorePanelR.offsetZ = 0;
		this.SidePanelL.offsetZ = 0;
		this.SidePanelR.offsetZ = 0;
		this.RingA.offsetZ = 0;
		this.RingB.offsetZ = 0;
		this.RingC.offsetZ = 0;
		this.Muzzle.offsetZ = 0;
		this.PlasmaBarrel.offsetZ = 0;
		this.ConfigCube.offsetZ = 0;
		
	}

}
