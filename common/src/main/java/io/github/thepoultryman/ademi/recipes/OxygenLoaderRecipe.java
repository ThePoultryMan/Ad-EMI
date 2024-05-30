package io.github.thepoultryman.ademi.recipes;

import dev.emi.emi.api.recipe.BasicEmiRecipe;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import earth.terrarium.adastra.common.recipes.machines.OxygenLoadingRecipe;
import earth.terrarium.botarium.common.fluid.FluidConstants;
import io.github.thepoultryman.ademi.AdEMI;
import io.github.thepoultryman.ademi.AdEMIPlugin;
import io.github.thepoultryman.ademi.widgets.CustomTankWidget;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;

public class OxygenLoaderRecipe extends BasicEmiRecipe {
    private final EmiStack inputFluid;
    private final EmiIngredient inputFluid;

    public OxygenLoaderRecipe(OxygenLoadingRecipe recipe) {
        super(AdEMIPlugin.OXYGEN_LOADER_CATEGORY, recipe.getId(), 127, 58);
        this.inputFluid = EmiStack.of(recipe.input().getFluids().get(0).getFluid(), FluidConstants.toMillibuckets(recipe.input().getFluidAmount()));

        var fluids = new ArrayList<EmiStack>(1);
        for (FluidHolder fluidHolder : recipe.input().getFluids()) {
            fluids.add(EmiStack.of(fluidHolder.getFluid(), FluidConstants.toMillibuckets(recipe.input().getFluidAmount())));
        }
        this.inputFluid = EmiIngredient.of(fluids);
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addTexture(
                new EmiTexture(new ResourceLocation(AdEMI.MOD_ID, "textures/gui/oxygen_loader.png"), 0, 0, 127, 58, 127, 58, 156, 58),
                0,
                0
        );
        widgets.add(new CustomTankWidget(this.inputFluid, 25, 2, 16, 54, 3000));
        widgets.addText(Component.literal(String.valueOf(this.inputFluid.getAmount())), 42, 2, 0x000000, false);
    }
}
