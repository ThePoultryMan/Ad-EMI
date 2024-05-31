package io.github.thepoultryman.ademi.widgets;

import dev.emi.emi.api.widget.TextureWidget;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

import java.util.function.BooleanSupplier;

public class ConditionalTextureWidget extends TextureWidget {
    private final BooleanSupplier condition;

    public ConditionalTextureWidget(ResourceLocation texture, int x, int y, int width, int height, int u, int v, int regionWidth, int regionHeight, int textureWidth, int textureHeight, BooleanSupplier condition) {
        super(texture, x, y, width, height, u, v, regionWidth, regionHeight, textureWidth, textureHeight);
        this.condition = condition;
    }

    @Override
    public void render(GuiGraphics draw, int mouseX, int mouseY, float delta) {
        if (this.condition.getAsBoolean()) super.render(draw, mouseX, mouseY, delta);
    }
}
