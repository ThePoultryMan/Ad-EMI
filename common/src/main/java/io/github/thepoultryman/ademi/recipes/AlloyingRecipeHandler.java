package io.github.thepoultryman.ademi.recipes;

import dev.emi.emi.api.recipe.BasicEmiRecipe;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import earth.terrarium.adastra.common.recipes.machines.AlloyingRecipe;
import io.github.thepoultryman.ademi.AdEMIPlugin;
import io.github.thepoultryman.ademi.RecipeUtil;

import java.util.List;

public class AlloyingRecipeHandler extends BasicEmiRecipe {
    public AlloyingRecipeHandler(AlloyingRecipe recipe) {
        super(AdEMIPlugin.ETRIONIC_BLAST_FURNACE_CATEGORY, recipe.getId(), 60, 40);

        this.inputs = RecipeUtil.ingredientsToEmi(recipe.ingredients());
        this.outputs = List.of(EmiStack.of(recipe.result()));
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {

    }
}
