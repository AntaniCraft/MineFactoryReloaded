package powercrystals.minefactoryreloaded.modhelpers.bigreactors;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import powercrystals.minefactoryreloaded.MFRRegistry;
import powercrystals.minefactoryreloaded.MineFactoryReloadedCore;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "MineFactoryReloaded|CompatBigReactors", name = "MFR Compat: Big Reactors", version = MineFactoryReloadedCore.version, dependencies = "after:MineFactoryReloaded;after:AppliedEnergistics")
@NetworkMod(clientSideRequired = false, serverSideRequired = false)
public class BigReactors
{
	private static final String lastUpdated = "BigReactors 0.1.14A, current release as of Aug 30 2013";
	
	@Init
	public static void load(FMLInitializationEvent e)
	{
		if(!Loader.isModLoaded("BigReactors"))
		{
			FMLLog.warning("Big Reactors missing - MFR Big Reactors Compat not loading");
			return;
		}
		try
		{
			Block yelloriteOre = (Block) Class.forName("erogenousbeef.bigreactors.common.BigReactors").getField("blockYelloriteOre").get(null);
			MFRRegistry.registerLaserOre(80, new ItemStack(yelloriteOre));
			MFRRegistry.addLaserPreferredOre(4, new ItemStack(yelloriteOre));
		}
		catch (Exception x)
		{
			System.out.println("Last updated for " + lastUpdated);
			x.printStackTrace();
		}
	}
}