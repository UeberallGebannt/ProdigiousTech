package lykrast.prodigytech.common.gui;

import lykrast.prodigytech.client.gui.GuiAeroheaterEnergion;
import lykrast.prodigytech.client.gui.GuiAeroheaterSolid;
import lykrast.prodigytech.client.gui.GuiAtomicReshaper;
import lykrast.prodigytech.client.gui.GuiBlowerFurnace;
import lykrast.prodigytech.client.gui.GuiExplosionFurnace;
import lykrast.prodigytech.client.gui.GuiHeatSawmill;
import lykrast.prodigytech.client.gui.GuiIncinerator;
import lykrast.prodigytech.client.gui.GuiLinearExtractor;
import lykrast.prodigytech.client.gui.GuiMagneticReassembler;
import lykrast.prodigytech.client.gui.GuiRotaryGrinder;
import lykrast.prodigytech.client.gui.GuiSolderer;
import lykrast.prodigytech.common.tileentity.TileAeroheaterEnergion;
import lykrast.prodigytech.common.tileentity.TileAeroheaterSolid;
import lykrast.prodigytech.common.tileentity.TileAtomicReshaper;
import lykrast.prodigytech.common.tileentity.TileBlowerFurnace;
import lykrast.prodigytech.common.tileentity.TileExplosionFurnace;
import lykrast.prodigytech.common.tileentity.TileHeatSawmill;
import lykrast.prodigytech.common.tileentity.TileIncinerator;
import lykrast.prodigytech.common.tileentity.TileLinearExtractor;
import lykrast.prodigytech.common.tileentity.TileMagneticReassembler;
import lykrast.prodigytech.common.tileentity.TileRotaryGrinder;
import lykrast.prodigytech.common.tileentity.TileSolderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ProdigyTechGuiHandler implements IGuiHandler {
	public static final int EXPLOSION_FURNACE = 0, AEROHEATER_SOLID = 1, INCINERATOR = 2, BLOWER_FURNACE = 3,
			ROTARY_GRINDER = 4, SOLDERER = 5, MAGNETIC_REASSEMBLER = 6, AEROHEATER_ENERGION = 7, LINEAR_EXTRACTOR = 8,
			HEAT_SAWMILL = 9, ATOMIC_RESHAPER = 10;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case EXPLOSION_FURNACE:
				return new ContainerExplosionFurnace(player.inventory, (TileExplosionFurnace)world.getTileEntity(new BlockPos(x, y, z)));
			case AEROHEATER_SOLID:
				return new ContainerAeroheaterSolid(player.inventory, (TileAeroheaterSolid)world.getTileEntity(new BlockPos(x, y, z)));
			case INCINERATOR:
				return new ContainerIncinerator(player.inventory, (TileIncinerator)world.getTileEntity(new BlockPos(x, y, z)));
			case BLOWER_FURNACE:
				return new ContainerBlowerFurnace(player.inventory, (TileBlowerFurnace)world.getTileEntity(new BlockPos(x, y, z)));
			case ROTARY_GRINDER:
				return new ContainerRotaryGrinder(player.inventory, (TileRotaryGrinder)world.getTileEntity(new BlockPos(x, y, z)));
			case SOLDERER:
				return new ContainerSolderer(player.inventory, (TileSolderer)world.getTileEntity(new BlockPos(x, y, z)));
			case MAGNETIC_REASSEMBLER:
				return new ContainerMagneticReassembler(player.inventory, (TileMagneticReassembler)world.getTileEntity(new BlockPos(x, y, z)));
			case AEROHEATER_ENERGION:
				return new ContainerAeroheaterEnergion(player.inventory, (TileAeroheaterEnergion)world.getTileEntity(new BlockPos(x, y, z)));
			case LINEAR_EXTRACTOR:
				return new ContainerLinearExtractor(player.inventory, (TileLinearExtractor)world.getTileEntity(new BlockPos(x, y, z)));
			case HEAT_SAWMILL:
				return new ContainerHeatSawmill(player.inventory, (TileHeatSawmill)world.getTileEntity(new BlockPos(x, y, z)));
			case ATOMIC_RESHAPER:
				return new ContainerAtomicReshaper(player.inventory, (TileAtomicReshaper)world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case EXPLOSION_FURNACE:
				return new GuiExplosionFurnace(player.inventory, (TileExplosionFurnace)world.getTileEntity(new BlockPos(x, y, z)));
			case AEROHEATER_SOLID:
				return new GuiAeroheaterSolid(player.inventory, (TileAeroheaterSolid)world.getTileEntity(new BlockPos(x, y, z)));
			case INCINERATOR:
				return new GuiIncinerator(player.inventory, (TileIncinerator)world.getTileEntity(new BlockPos(x, y, z)));
			case BLOWER_FURNACE:
				return new GuiBlowerFurnace(player.inventory, (TileBlowerFurnace)world.getTileEntity(new BlockPos(x, y, z)));
			case ROTARY_GRINDER:
				return new GuiRotaryGrinder(player.inventory, (TileRotaryGrinder)world.getTileEntity(new BlockPos(x, y, z)));
			case SOLDERER:
				return new GuiSolderer(player.inventory, (TileSolderer)world.getTileEntity(new BlockPos(x, y, z)));
			case MAGNETIC_REASSEMBLER:
				return new GuiMagneticReassembler(player.inventory, (TileMagneticReassembler)world.getTileEntity(new BlockPos(x, y, z)));
			case AEROHEATER_ENERGION:
				return new GuiAeroheaterEnergion(player.inventory, (TileAeroheaterEnergion)world.getTileEntity(new BlockPos(x, y, z)));
			case LINEAR_EXTRACTOR:
				return new GuiLinearExtractor(player.inventory, (TileLinearExtractor)world.getTileEntity(new BlockPos(x, y, z)));
			case HEAT_SAWMILL:
				return new GuiHeatSawmill(player.inventory, (TileHeatSawmill)world.getTileEntity(new BlockPos(x, y, z)));
			case ATOMIC_RESHAPER:
				return new GuiAtomicReshaper(player.inventory, (TileAtomicReshaper)world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}

}
