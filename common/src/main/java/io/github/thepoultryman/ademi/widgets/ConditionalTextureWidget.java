package io.github.thepoultryman.ademi.widgets;

import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.widget.TextureWidget;
import net.minecraft.client.gui.GuiGraphics;

import java.util.function.BooleanSupplier;

public class ConditionalTextureWidget extends TextureWidget {
    private final BooleanSupplier condition;

    public ConditionalTextureWidget(EmiTexture texture, int x, int y, BooleanSupplier condition) {
        super(texture.texture, x, y, texture.width, texture.height, texture.u, texture.v, texture.regionWidth, texture.regionHeight, texture.textureWidth, texture.textureHeight);
        this.condition = condition;
    }

    @Override
    public void render(GuiGraphics draw, int mouseX, int mouseY, float delta) {
        if (this.condition.getAsBoolean()) super.render(draw, mouseX, mouseY, delta);
    }
}
