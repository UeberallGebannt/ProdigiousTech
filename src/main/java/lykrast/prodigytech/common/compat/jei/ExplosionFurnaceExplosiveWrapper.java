package lykrast.prodigytech.common.compat.jei;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

import lykrast.prodigytech.common.recipe.ExplosionFurnaceManager;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

public class ExplosionFurnaceExplosiveWrapper implements IRecipeWrapper {
	private ItemStack explosive, reactant;
	private static final String POWER_DISPLAY = "container.prodigytech.jei.ptexplosionfurnace_exp.generated";
	private int power;
	
	public ExplosionFurnaceExplosiveWrapper(ExplosionFurnaceManager.ExplosionFurnaceExplosive recipe)
	{
		explosive = recipe.getExplosive();
		reactant = recipe.getReactant();
		power = recipe.getOptimalPower();
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		List<ItemStack> list = ImmutableList.of(explosive, reactant);
		ingredients.setInputs(ItemStack.class, list);
	}
	
	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
		String localized = I18n.format(POWER_DISPLAY) + power;
		int width = minecraft.fontRenderer.getStringWidth(localized);
		int x = (recipeWidth - 4 - width)/2;
		int y = 45;
		minecraft.fontRenderer.drawString(localized, x, y, Color.gray.getRGB());
	}

	public static void registerRecipes(IModRegistry registry)
	{
		List<ExplosionFurnaceExplosiveWrapper> list = new ArrayList<>();
		
		for (ExplosionFurnaceManager.ExplosionFurnaceExplosive recipe : ExplosionFurnaceManager.EXPLOSIVES)
		{
			list.add(new ExplosionFurnaceExplosiveWrapper(recipe));
		}
		
		registry.addRecipes(list, ExplosionFurnaceExplosiveCategory.UID);
	}

}
