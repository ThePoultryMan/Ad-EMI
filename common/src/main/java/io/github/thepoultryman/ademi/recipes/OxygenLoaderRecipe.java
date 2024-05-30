package io.github.thepoultryman.ademi.recipes;

import dev.emi.emi.api.recipe.BasicEmiRecipe;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import earth.terrarium.adastra.common.recipes.machines.OxygenLoadingRecipe;
import earth.terrarium.botarium.common.fluid.utils.QuantifiedFluidIngredient;
import io.github.thepoultryman.ademi.AdEMI;
import io.github.thepoultryman.ademi.AdEMIPlugin;
import io.github.thepoultryman.ademi.widgets.CustomTankWidget;
import net.minecraft.resources.ResourceLocation;

public class OxygenLoaderRecipe extends BasicEmiRecipe {
    private final QuantifiedFluidIngredient inputFluid;

    public OxygenLoaderRecipe(OxygenLoadingRecipe recipe) {
        super(AdEMIPlugin.OXYGEN_LOADER_CATEGORY, recipe.getId(), 127, 58);
        this.inputFluid = EmiStack.of(recipe.input().getFluids().get(0).getFluid(), FluidConstants.toMillibuckets(recipe.input().getFluidAmount()));
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addTexture(
                new EmiTexture(new ResourceLocation(AdEMI.MOD_ID, "textures/gui/oxygen_loader.png"), 0, 0, 127, 58, 127, 58, 156, 58),
                0,
                0
        );
        var water = EmiStack.of(this.inputFluid.getFluids().get(0).getFluid(), 100);
        widgets.add(new CustomTankWidget(water, 151, 22, 10, 45, 1000));
    }
}
