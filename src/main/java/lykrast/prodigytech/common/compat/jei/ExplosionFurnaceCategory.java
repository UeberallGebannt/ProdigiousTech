package lykrast.prodigytech.common.compat.jei;

import lykrast.prodigytech.client.gui.GuiExplosionFurnace;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.util.ResourceLocation;

public class ExplosionFurnaceCategory extends ProdigyCategory<ExplosionFurnaceWrapper> {
	public static final String UID = "ptexplosionfurnace";

	public ExplosionFurnaceCategory(IGuiHelper guiHelper) {
		super(guiHelper, guiHelper.createDrawable(ProdigyTechJEI.GUI, 0, 0, 90, 36, 0, 20, 0, 0), UID);
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, ExplosionFurnaceWrapper recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

		guiItemStacks.init(0, true, 0, 18);
		guiItemStacks.init(1, true, 36, 0);
		guiItemStacks.init(2, false, 72, 18);

		guiItemStacks.set(ingredients);
	}

}
