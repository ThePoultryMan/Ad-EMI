package io.github.thepoultryman.ademi;

import dev.emi.emi.api.stack.EmiIngredient;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class RecipeUtil {
    public static List<EmiIngredient> ingredientsToEmi(List<Ingredient> ingredients) {
        var emiIngredients = new ArrayList<EmiIngredient>();
        for (Ingredient ingredient : ingredients) {
            emiIngredients.add(EmiIngredient.of(ingredient));
        }
        return emiIngredients;
    }
}
