package lykrast.prodigytech.core;

import java.util.logging.Logger;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ProdigyTech.MODID, name = ProdigyTech.NAME, version = ProdigyTech.VERSION)
public class ProdigyTech
{
    public static final String MODID = "prodigytech";
    public static final String NAME = "Prodigy Tech";
    public static final String VERSION = "0.0.1";
    
	@Instance
	public static ProdigyTech instance;
	
	public static Logger logger;
    
    @SidedProxy(clientSide = "lykrast.prodigytech.core.ClientProxy", serverSide = "lykrast.prodigytech.core.CommonProxy")
	public static CommonProxy proxy;
    
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}
}