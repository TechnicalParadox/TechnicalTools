package tech.technicaltools;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class TechnicalOreGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case -1:
			generateNether();
			break;
		case 0:
			generateOverworld(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			generateEnd();
			break;
		}
		
		
	}
	
	// Used for generation in the Overworld
	public void generateOverworld(World world, Random random, int chunkX, int chunkZ) {
		for (int i = 0; i < 3; i++) {
			int oreX = chunkX + random.nextInt(16);
			int oreY = random.nextInt(16);
			int oreZ = chunkZ + random.nextInt(16);
			
			(new WorldGenMinable(Main.technicalOre.blockID, 8)).generate(world, random, oreX, oreY, oreZ);
		}
	}
	
	public void generateNether() {}
	public void generateEnd() {}

}
