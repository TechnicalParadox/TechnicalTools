package tech.technicaltools;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

// Info for Minecraft Forge
@Mod (modid="technicaltools", name="Technical Tool Pack", version="0.1 for MC 1.6.2 - FORGE 9.10.0.804")
@NetworkMod (clientSideRequired=true, serverSideRequired=false)

public class Main {
	
	// Item IDs
	int technicalOreID;
	int technicalBlockID;
	int technicalIngotID;
	int obsidianStickID;
	int technicalSwordID;
	int technicalPickaxeID;
	int technicalShovelID;
	int technicalAxeID;
	int technicalHelmetID;
	int technicalChestplateID;
	int technicalLeggingsID;
	int technicalBootsID;
	
	// Blocks
	public static TechnicalOre technicalOre;
	public static TechnicalBlock technicalBlock;
	
	// Materials
	public static TechnicalIngot technicalIngot;
	public static ObsidianStick obsidianStick;
	
	// Tools
	public static TechnicalSword technicalSword;
	public static TechnicalPickaxe technicalPickaxe;
	public static TechnicalShovel technicalShovel;
	public static TechnicalAxe technicalAxe;
	
	// Material Section
	public static EnumArmorMaterial technicalArmor =
			EnumHelper.addArmorMaterial("TechnicalArmor", 40, new int[] {14, 8, 10, 8}, 15);
	
	// Armor Section
	public static Item technicalHelmet;
	public static Item technicalChestplate;
	public static Item technicalLeggings;
	public static Item technicalBoots;
	
	// Instance of Mod
	public static Main instance;
	
	//PreInitialization Events
	@EventHandler
	public void preInit (FMLPreInitializationEvent event) {
		
		// Config Code
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		// Load config
		config.load();
		
		// Get IDs from config file
		technicalOreID = config.get("Block IDs", "Technical Ore ID", 1500).getInt();
		technicalBlockID = config.get("Block IDs", "Technical Block", 1501).getInt();
		
		technicalIngotID = config.get("Material IDs", "Technical Ingot ID", 1502).getInt();
		obsidianStickID = config.get("Material IDs", "Obsidian Stick ID", 1503).getInt();
		
		technicalSwordID =  config.get("Tool IDs", "Technical Sword ID", 1504).getInt();
		technicalPickaxeID = config.get("Tool IDs", "Technical Pickaxe ID", 1505).getInt();
		technicalShovelID = config.get("Tool IDs", "Technical Shovel ID", 1506).getInt();
		technicalAxeID = config.get("Tool IDs", "Technical Axe ID", 1507).getInt();
		
		technicalHelmetID = config.get("Armor IDs", "Technical Helmet ID", 1508).getInt();
		technicalChestplateID = config.get("Armor IDs", "Technical Chestplate ID", 1509).getInt();
		technicalLeggingsID = config.get("Armor IDs", "Technical Leggings ID", 1510).getInt();
		technicalBootsID = config.get("Armor IDs",  "Technical Boots ID", 1511).getInt();
		
		// Save config
		config.save();
		
		// Initialize Blocks/Items/Tools/Armor
		this.technicalOre = new TechnicalOre (technicalOreID);
		this.technicalBlock = new TechnicalBlock (technicalBlockID, Material.ground);
		
		this.technicalIngot = new TechnicalIngot (technicalIngotID);
		this.obsidianStick = new ObsidianStick (obsidianStickID);
		
		this.technicalSword = new TechnicalSword (technicalSwordID);
		this.technicalPickaxe = new TechnicalPickaxe (technicalPickaxeID);
		this.technicalShovel = new TechnicalShovel (technicalShovelID);
		this.technicalAxe = new TechnicalAxe (technicalAxeID);
		
		technicalHelmet = new TechnicalArmor (technicalHelmetID, technicalArmor, 0, 0, "Technical");
		technicalChestplate = new TechnicalArmor (technicalChestplateID, technicalArmor, 0, 1, "Technical");
		technicalLeggings = new TechnicalArmor (technicalLeggingsID, technicalArmor, 0, 2, "Technical");
		technicalBoots = new TechnicalArmor (technicalBootsID, technicalArmor, 0, 3, "Technical");
		
		// Info for Technical Ore
		LanguageRegistry.addName(technicalOre, "Technical Ore");
		MinecraftForge.setBlockHarvestLevel(technicalOre, "pickaxe", 3);
		GameRegistry.registerBlock(technicalOre, "technicalOre");
		
		// Info for Technical Block
		LanguageRegistry.addName(technicalBlock, "Technical Block");
		MinecraftForge.setBlockHarvestLevel(technicalBlock, "pickaxe", 2);
		GameRegistry.registerBlock(technicalBlock, "technicalBlock");
		
		// Info for Technical Ingot
		LanguageRegistry.addName(technicalIngot, "Technical Ingot");
		
		// Info for Obsidian Stick
		LanguageRegistry.addName(obsidianStick, "Obsidian Stick");
		
		// Info for Technical Sword
		LanguageRegistry.addName(technicalSword, "Technical Sword");
		
		// Info for Technical Pickaxe
		LanguageRegistry.addName(technicalPickaxe, "Technical Pickaxe");
		
		// Info for Technical Shovel
		LanguageRegistry.addName(technicalShovel, "Technical Shovel");
		
		// Info for Technical Axe
		LanguageRegistry.addName(technicalAxe, "Technical Axe");
		
		// Info for Technical Helmet
		LanguageRegistry.addName(technicalHelmet, "Technical Helmet");
		
		// Info for Technical Chestplate
		LanguageRegistry.addName(technicalChestplate, "Technical Chestplate");
		
		// Info for Technical Leggings
		LanguageRegistry.addName(technicalLeggings, "Technical Leggings");
		
		// Info for Technical Boots
		LanguageRegistry.addName(technicalBoots, "Technical Boots");
		
		// Crafting Recipes
			// Technical Block
			GameRegistry.addRecipe(new ItemStack(technicalBlock, 3),
					"oio",
					"ioi",
					"oio",
					'o', Block.obsidian, 'i', technicalIngot);
			// Obsidian Stick
			GameRegistry.addRecipe(new ItemStack(obsidianStick, 4),
					"o",
					"o",
					'o', Block.obsidian);
			// Technical Sword
			GameRegistry.addRecipe(new ItemStack(technicalSword, 1),
					"i",
					"i",
					"s",
					'i', technicalIngot, 'o', obsidianStick);
			// Technical Pickaxe
			GameRegistry.addRecipe(new ItemStack(technicalPickaxe, 1),
					"iii",
					" s ",
					" s ",
					'i', technicalIngot, 's', obsidianStick);
			// Technical Shovel
			GameRegistry.addRecipe(new ItemStack(technicalShovel, 1),
					"i",
					"s",
					"s",
					'i', technicalIngot, 's', obsidianStick);
			// Technical Axe Right
			GameRegistry.addRecipe(new ItemStack(technicalAxe, 1),
					"ii",
					"si",
					"s ",
					'i', technicalIngot, 's', obsidianStick);
			// Technical Axe Left
			GameRegistry.addRecipe(new ItemStack(technicalAxe, 1),
					"ii",
					"is",
					" s",
					'i', technicalIngot, 's', obsidianStick);
			// Technical Helmet
			GameRegistry.addRecipe(new ItemStack(technicalHelmet, 1),
					"ioi",
					"i i",
					'i', technicalIngot, 'o', Block.obsidian);
			// Technical Chestplate
			GameRegistry.addRecipe(new ItemStack(technicalChestplate, 1),
					"o o",
					"iii",
					"iii",
					'i', technicalIngot, 'o', Block.obsidian);
			// Technical Leggings
			GameRegistry.addRecipe(new ItemStack(technicalLeggings, 1),
					"iii",
					"o o",
					"i i",
					'i', technicalIngot, 'o', Block.obsidian);
			// Technical Boots
			GameRegistry.addRecipe(new ItemStack(technicalBoots, 1),
					"i i",
					"o o",
					'i', technicalIngot, 'o', Block.obsidian);
			
		
		// Smelting Recipes
			// Technical Ore -> Technical Ingot
			GameRegistry.addSmelting(technicalOreID, new ItemStack(technicalIngot),  0.9f);
		
		// Ore gen
		GameRegistry.registerWorldGenerator(new TechnicalOreGen());
	}
	
}
