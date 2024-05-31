package io.github.thepoultryman.ademi;

import dev.emi.emi.api.widget.ButtonWidget;

public class BucketRecipeToggle implements ButtonWidget.ClickAction {
    private boolean bucketRecipe = false;

    @Override
    public void click(double mouseX, double mouseY, int button) {
        this.bucketRecipe = !this.bucketRecipe;
    }

    public boolean useBucketRecipe() {
        return bucketRecipe;
    }

    public void setBucketRecipe(boolean bucketRecipe) {
        this.bucketRecipe = bucketRecipe;
    }
}
