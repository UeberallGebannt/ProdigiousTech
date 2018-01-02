package lykrast.prodigytech.common.compat.jei;

import java.awt.Color;

import lykrast.prodigytech.common.item.ItemEnergionBattery;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

public class EnergionBatteryWrapper implements IRecipeWrapper {
	private ItemStack out;
	private ItemStack in;
	private final String duration;
	
	public EnergionBatteryWrapper(ItemEnergionBattery battery, IGuiHelper guiHelper)
	{
		in = new ItemStack(battery);
		out = battery.getEmptyStack();
		
		duration = I18n.format("container.prodigytech.jei.ptbattery.lifetime", in.getMaxDamage());
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInput(ItemStack.class, in);
		ingredients.setOutput(ItemStack.class, out);
	}
	
	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
		minecraft.fontRenderer.drawString(duration, -10, 30, Color.GRAY.getRGB());
	}

}