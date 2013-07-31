package tech.technicaltools;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class TechnicalBlock extends Block {

	public TechnicalBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		
		// Variables for the Blocks
		this.setHardness(10.0F);
		this.setStepSound(Block.soundMetalFootstep);
		this.setUnlocalizedName("technicalBlock");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setResistance(-1.0F);
	}
	
	@Override
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon("technicaltools:technical_block");
	}

}
