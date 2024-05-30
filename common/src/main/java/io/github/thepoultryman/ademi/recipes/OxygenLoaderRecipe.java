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
        super(AdEMIPlugin.OXYGEN_LOADER_CATEGORY, recipe.getId(), 164, 82);
        this.inputFluid = recipe.input();
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addTexture(
                new EmiTexture(new ResourceLocation(AdEMI.AD_ASTRA_MOD_ID, "textures/gui/container/oxygen_loader.png"), 9, 3, 164, 82),
                0,
                0
        );
        var water = EmiStack.of(this.inputFluid.getFluids().get(0).getFluid(), 100);
        widgets.add(new CustomTankWidget(water, 151, 22, 10, 45, 1000));
    }
}
