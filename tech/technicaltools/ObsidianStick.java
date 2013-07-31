package tech.technicaltools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ObsidianStick extends Item {

	public ObsidianStick(int par1) {
		super(par1);
		
		this.setMaxStackSize(64);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setUnlocalizedName("obsidianStick");
	}
	
	@Override
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon("technicaltools:techobsidian_stick");
	}

}
