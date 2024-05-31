package io.github.thepoultryman.ademi;

import dev.emi.emi.api.widget.ButtonWidget;

public class BucketRecipeToggle implements ButtonWidget.ClickAction {
    private boolean bucketRecipe = false;
    private Runnable onClick = () -> {};

    @Override
    public void click(double mouseX, double mouseY, int button) {
        this.bucketRecipe = !this.bucketRecipe;
        this.onClick.run();
    }

    public boolean useBucketRecipe() {
        return this.bucketRecipe;
    }

    public void onClick(Runnable onClick) {
        this.onClick = onClick;
    }
}
