package tech.technicaltools;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class TechnicalOre extends BlockOre {

	public TechnicalOre(int par1) {
		super(par1);
		
		// Variables for the Blocks
		this.setHardness(7.0F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setUnlocalizedName("technicalOre");
		this.setCreativeTab(CreativeTabs.tabBlock);
		
	}
	
	@Override
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon("technicaltools:technical_ore");
	}
	
}
