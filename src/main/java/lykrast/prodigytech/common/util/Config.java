package lykrast.prodigytech.common.util;

import java.util.logging.Level;

import lykrast.prodigytech.core.CommonProxy;
import lykrast.prodigytech.core.ProdigyTech;
import net.minecraftforge.common.config.Configuration;

public class Config {
	private static final String CATEGORY_GENERAL = "General";
	private static final String CATEGORY_MACHINES = "Machines";
	private static final String CATEGORY_ENERGION = "Energion";
	private static final String CATEGORY_AUTOMATION = "Automation";
	
	//General
	
	//Machines
	public static int incineratorProcessTime, blowerFurnaceProcessTime, rotaryGrinderProcessTime, heatSawmillProcessTime,
		soldererProcessTime, 
		magneticReassemblerProcessTime;
	public static float incineratorChance;
	public static int rotaryGrinderOreMultiplier;
	public static float heatSawmillPlankMultiplier, heatSawmillStickMultiplier;
	public static int soldererMaxGold;
	public static int atomicReshaperMaxPrimordium;
	
	//Energion
	public static int energionBatteryDuration;
	
	//Automation
	public static int linearExtractorDelay, linearExtractorMaxStack;
	
	public static void readConfig() {
		Configuration cfg = CommonProxy.config;
		try {
			cfg.load();
			initGeneralConfig(cfg);
		} catch (Exception e) {
			ProdigyTech.logger.log(Level.WARNING, "Problem loading config file!", e);
		} finally {
			if (cfg.hasChanged()) {
				cfg.save();
			}
		}
	}
	
	private static void initGeneralConfig(Configuration cfg) {
		cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
		cfg.addCustomCategoryComment(CATEGORY_MACHINES, "Machines configuration");
		cfg.addCustomCategoryComment(CATEGORY_ENERGION, "Energion configuration");
		cfg.addCustomCategoryComment(CATEGORY_AUTOMATION, "Automation configuration");

		//-----------
		// General
		//-----------
		//test = cfg.getBoolean("test", CATEGORY_GENERAL, true, "Testing that stuff out");
		
		//-----------
		//Machines
		//-----------
		//Incinerator
		incineratorProcessTime = cfg.getInt("incineratorProcessTime", CATEGORY_MACHINES, 200, 1, 3000, 
				"The base amount of time (in ticks) that the Incinerator takes to process 1 item");
		incineratorChance = cfg.getFloat("incineratorChance", CATEGORY_MACHINES, 1.0F, 0, 1.0F, 
				"The chance that an item burned in the Incinerator gives Ash");
		//Blower Furnace
		blowerFurnaceProcessTime = cfg.getInt("blowerFurnaceProcessTime", CATEGORY_MACHINES, 300, 1, 3000, 
				"The base amount of time (in ticks) that the Blower Furnace takes to process 1 item");
		//Rotary Grinder
		rotaryGrinderProcessTime = cfg.getInt("rotaryGrinderProcessTime", CATEGORY_MACHINES, 300, 1, 3000, 
				"The base amount of time (in ticks) that the Rotary Grinder takes to process 1 item\n"
				+ "Several recipes have shorter or longer processing time, which are all derived from this value");
		rotaryGrinderOreMultiplier = cfg.getInt("rotaryGrinderOreMultiplier", CATEGORY_MACHINES, 2, 1, 10, 
				"By how much ore outputs are multiplied by when passing them through the Rotary Grinder");
		//HeatSawmill
		heatSawmillProcessTime = cfg.getInt("heatSawmillProcessTime", CATEGORY_MACHINES, 200, 1, 3000, 
				"The base amount of time (in ticks) that the Heat Sawmill takes to process 1 item\n");
		heatSawmillPlankMultiplier = cfg.getFloat("heatSawmillPlankMultiplier", CATEGORY_MACHINES, 1.5F, 1.0F, 10.0F, 
				"Multiplier to the amount of planks the Heat Sawmil can extract from a single log (compared to manual crafting)");
		heatSawmillStickMultiplier = cfg.getFloat("heatSawmillStickMultiplier", CATEGORY_MACHINES, 2.0F, 1.0F, 10.0F, 
				"Multiplier to the amount of planks the Heat Sawmil can extract from a single log (compared to manual crafting)");
		//Solderer
		soldererProcessTime = cfg.getInt("soldererProcessTime", CATEGORY_MACHINES, 400, 1, 3000, 
				"The base amount of time (in ticks) that the Solderer takes to make 1 Crude Circuit\n"
				+ "The time of all other recipes are derived from this value");
		soldererMaxGold = cfg.getInt("soldererMaxGold", CATEGORY_MACHINES, 81, 9, 20736, 
				"How much gold (in nuggets) can the Solderer hold in its internal buffer");
		//Magnetic Reassembler
		magneticReassemblerProcessTime = cfg.getInt("magneticReassemblerProcessTime", CATEGORY_MACHINES, 300, 1, 3000, 
				"The base amount of time (in ticks) that the Magnetic Reassembler takes to process 1 item\n"
				+ "Several recipes have shorter or longer processing time, which are all derived from this value");
		//Atomic Reshaper
		atomicReshaperMaxPrimordium = cfg.getInt("atomicReshaperMaxPrimordium", CATEGORY_MACHINES, 4, 1, 64, 
				"How many Primordium items can the Atomic Reshaper hold in its internal buffer");
		
		//-----------
		//Energion
		//-----------
		energionBatteryDuration = cfg.getInt("energionBatteryDuration", CATEGORY_ENERGION, 12000, 20, 1728000, 
				"The time (in ticks) a simple Energion Battery will last, other values are derived from this one");
		
		//-----------
		//Automation
		//-----------
		linearExtractorDelay = cfg.getInt("linearExtractorDelay", CATEGORY_AUTOMATION, 10, 1, 200, 
				"The time (in ticks) between 2 push/pulls of a Linear Extractor\n"
				+ "1 means every tick, 20 means once every second and so on");
		linearExtractorMaxStack = cfg.getInt("linearExtractorMaxStack", CATEGORY_AUTOMATION, 64, 1, 64, 
				"How many items from a stack a Linear Extractor can push/pull at once");
	}

}
