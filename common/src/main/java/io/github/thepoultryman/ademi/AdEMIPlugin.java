package io.github.thepoultryman.ademi;

import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiInitRegistry;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiStack;
import earth.terrarium.adastra.common.recipes.machines.AlloyingRecipe;
import earth.terrarium.adastra.common.recipes.machines.OxygenLoadingRecipe;
import earth.terrarium.adastra.common.registry.ModBlocks;
import earth.terrarium.adastra.common.registry.ModRecipeTypes;
import io.github.thepoultryman.ademi.recipes.AlloyingRecipeHandler;
import io.github.thepoultryman.ademi.recipes.OxygenLoaderRecipe;
import net.minecraft.resources.ResourceLocation;

@EmiEntrypoint
public class AdEMIPlugin implements EmiPlugin {
    public static final EmiStack OXYGEN_LOADER = EmiStack.of(ModBlocks.OXYGEN_LOADER.get());
    public static final EmiRecipeCategory OXYGEN_LOADER_CATEGORY =
            new EmiRecipeCategory(new ResourceLocation(AdEMI.MOD_ID, "oxygen_loader"), OXYGEN_LOADER);
    public static final EmiStack ETRIONIC_BLAST_FURNACE = EmiStack.of(ModBlocks.ETRIONIC_BLAST_FURNACE.get());
    public static final EmiRecipeCategory ETRIONIC_BLAST_FURNACE_CATEGORY =
            new EmiRecipeCategory(new ResourceLocation(AdEMI.MOD_ID, "etrionic_blast_furnace"), ETRIONIC_BLAST_FURNACE);

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
        registry.addCategory(ETRIONIC_BLAST_FURNACE_CATEGORY);
        registry.addWorkstation(ETRIONIC_BLAST_FURNACE_CATEGORY, ETRIONIC_BLAST_FURNACE);
        for (AlloyingRecipe recipe : recipeManager.getAllRecipesFor(ModRecipeTypes.ALLOYING.get())) {
            registry.addRecipe(new AlloyingRecipeHandler(recipe));
        }
    }
}
