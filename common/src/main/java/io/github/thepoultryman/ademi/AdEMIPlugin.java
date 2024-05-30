package io.github.thepoultryman.ademi;

import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiInitRegistry;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiStack;
import earth.terrarium.adastra.common.recipes.machines.OxygenLoadingRecipe;
import earth.terrarium.adastra.common.registry.ModBlocks;
import earth.terrarium.adastra.common.registry.ModRecipeTypes;
import io.github.thepoultryman.ademi.recipes.OxygenLoaderRecipe;
import net.minecraft.resources.ResourceLocation;

@EmiEntrypoint
public class AdEMIPlugin implements EmiPlugin {
    public static final ResourceLocation SPRITE_SHEET = new ResourceLocation(AdEMI.MOD_ID, "textures/gui/emi_sprite_sheet.png");
    public static final EmiStack OXYGEN_LOADER = EmiStack.of(ModBlocks.OXYGEN_LOADER.get());
    public static final EmiRecipeCategory OXYGEN_LOADER_CATEGORY =
            new EmiRecipeCategory(new ResourceLocation(AdEMI.MOD_ID, "oxygen_loader"), OXYGEN_LOADER, new EmiTexture(SPRITE_SHEET, 0, 0, 16, 16));

    @Override
    public void initialize(EmiInitRegistry registry) {
        EmiPlugin.super.initialize(registry);
    }

    @Override
    public void register(EmiRegistry registry) {
        var recipeManager = registry.getRecipeManager();

        registry.addCategory(OXYGEN_LOADER_CATEGORY);
        registry.addWorkstation(OXYGEN_LOADER_CATEGORY, OXYGEN_LOADER);
        for (OxygenLoadingRecipe recipe : recipeManager.getAllRecipesFor(ModRecipeTypes.OXYGEN_LOADING.get())) {
            registry.addRecipe(new OxygenLoaderRecipe(recipe));
        }
    }
}
