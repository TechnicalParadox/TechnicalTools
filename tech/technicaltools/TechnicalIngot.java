package tech.technicaltools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TechnicalIngot extends Item {

	public TechnicalIngot(int par1) {
		super(par1);
		
		this.setMaxStackSize(64);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setUnlocalizedName("technicalIngot");
	}
	
	@Override
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon("technicaltools:technical_ingot");
	}

}
