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
import io.github.thepoultryman.ademi.BucketRecipeToggle;
import io.github.thepoultryman.ademi.widgets.ConditionalTextWidget;
import io.github.thepoultryman.ademi.widgets.ConditionalTextureWidget;
import io.github.thepoultryman.ademi.widgets.CustomSlotWidget;
import io.github.thepoultryman.ademi.widgets.CustomTankWidget;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

public class OxygenLoaderRecipe extends BasicEmiRecipe {
    private final EmiIngredient inputFluid;
    private final EmiIngredient inputBucket;
    private final int energy;
    private final int bucketAmountEnergy;
    private final EmiStack outputFluid;
    private final BucketRecipeToggle bucketRecipe = new BucketRecipeToggle();

    public OxygenLoaderRecipe(OxygenLoadingRecipe recipe) {
        super(AdEMIPlugin.OXYGEN_LOADER_CATEGORY, recipe.getId(), 121, 58);

        var fluids = new ArrayList<EmiStack>(1);
        var buckets = new ArrayList<EmiStack>(1);
        for (FluidHolder fluidHolder : recipe.input().getFluids()) {
            EmiStack fluid = EmiStack.of(fluidHolder.getFluid(), FluidConstants.toMillibuckets(recipe.input().getFluidAmount()));
            if (fluids.contains(fluid)) continue;
            Item bucket = fluidHolder.getFluid().getBucket();
            if (bucket.getCraftingRemainingItem() != null) {
                buckets.add(EmiStack.of(bucket).setRemainder(EmiStack.of(bucket.getCraftingRemainingItem())));
            } else {
                buckets.add(EmiStack.of(bucket));
            }
            fluids.add(fluid);
        }


        this.inputFluid = EmiIngredient.of(fluids);
        long recipeMultiplier = 1000 / this.inputFluid.getAmount();
        this.inputBucket = EmiIngredient.of(buckets);
        this.energy = recipe.energy();
        this.bucketAmountEnergy = (int) (recipe.energy() * recipeMultiplier);

        this.outputFluid = EmiStack.of(recipe.result().getFluid(), FluidConstants.toMillibuckets(recipe.result().getFluidAmount()));

        this.bucketRecipe.onClick(() -> {
            if (this.bucketRecipe.useBucketRecipe()) {
                this.inputFluid.setAmount(this.inputFluid.getAmount() * recipeMultiplier);
                this.outputFluid.setAmount(this.outputFluid.getAmount() * recipeMultiplier);
            } else {
                this.inputFluid.setAmount(FluidConstants.toMillibuckets(recipe.input().getFluidAmount()));
                this.outputFluid.setAmount(FluidConstants.toMillibuckets(recipe.result().getFluidAmount()));
            }
        });

        // EMI
        this.inputs = List.of(this.inputBucket, this.inputFluid);
        this.outputs = List.of(this.outputFluid);
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addTexture(
                new EmiTexture(new ResourceLocation(AdEMI.MOD_ID, "textures/gui/oxygen_loader.png"),
                        0, 0, 121, 58, 121, 58, 122, 58),
                0, 0
        );
        widgets.add(new CustomTankWidget(this.inputFluid, 27, 3, 14, 52, 3000));

        widgets.add(new CustomTankWidget(this.outputFluid, 65, 3, 14, 52, 3000));

        EmiTexture bucketOutlineTexture = new EmiTexture(new ResourceLocation(AdEMI.MOD_ID, "textures/gui/widgets.png"),
                12, 0, 12, 14, 12, 14, 256, 256);
        widgets.add(new ConditionalTextureWidget(
                bucketOutlineTexture, 4, 11,
                () -> !this.bucketRecipe.useBucketRecipe()));
        widgets.add(new CustomSlotWidget(this.inputBucket, 2, 10, this.bucketRecipe::useBucketRecipe));
        widgets.addTexture(bucketOutlineTexture, 90, 11);

        widgets.add(new ConditionalTextWidget(Component.literal("⚡" + this.energy),
                120 - Minecraft.getInstance().font.width("⚡" + this.energy),
                45, 0xFFFFFF, true, () -> !this.bucketRecipe.useBucketRecipe()));
        widgets.add(new ConditionalTextWidget(Component.literal("⚡" + this.bucketAmountEnergy),
                120 - Minecraft.getInstance().font.width("⚡" + this.bucketAmountEnergy),
                45, 0xFFFFFF, true, this.bucketRecipe::useBucketRecipe));

        widgets.addButton(47, 39, 12, 12, 0, 0, new ResourceLocation(AdEMI.MOD_ID, "textures/gui/widgets.png"), () -> true, this.bucketRecipe);
    }
}
