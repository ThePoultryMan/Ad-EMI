package io.github.thepoultryman.ademi.recipes;

import dev.emi.emi.api.recipe.BasicEmiRecipe;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import earth.terrarium.adastra.common.recipes.machines.OxygenLoadingRecipe;
import earth.terrarium.botarium.common.fluid.FluidConstants;
import earth.terrarium.botarium.common.fluid.base.FluidHolder;
import io.github.thepoultryman.ademi.AdEMI;
import io.github.thepoultryman.ademi.AdEMIPlugin;
import io.github.thepoultryman.ademi.widgets.CustomTankWidget;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;

public class OxygenLoaderRecipe extends BasicEmiRecipe {
    private final EmiIngredient inputFluid;
    private final EmiStack outputFluid;

    public OxygenLoaderRecipe(OxygenLoadingRecipe recipe) {
        super(AdEMIPlugin.OXYGEN_LOADER_CATEGORY, recipe.getId(), 127, 58);

        var fluids = new ArrayList<EmiStack>(1);
        for (FluidHolder fluidHolder : recipe.input().getFluids()) {
            fluids.add(EmiStack.of(fluidHolder.getFluid(), FluidConstants.toMillibuckets(recipe.input().getFluidAmount())));
        }
        this.inputFluid = EmiIngredient.of(fluids);

        this.outputFluid = EmiStack.of(recipe.result().getFluid(), FluidConstants.toMillibuckets(recipe.result().getFluidAmount()));
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

        widgets.add(new CustomTankWidget(this.outputFluid, 65, 2, 16, 54, 3000));
    }
}
