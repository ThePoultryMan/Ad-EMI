package io.github.thepoultryman.ademi.widgets;

import dev.emi.emi.api.widget.TextWidget;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

import java.util.function.BooleanSupplier;

public class ConditionalTextWidget extends TextWidget {
    private final BooleanSupplier condition;

    public ConditionalTextWidget(Component text, int x, int y, int color, boolean shadow, BooleanSupplier condition) {
        super(text.getVisualOrderText(), x, y, color, shadow);
        this.condition = condition;
    }

    @Override
    public void render(GuiGraphics draw, int mouseX, int mouseY, float delta) {
        if (this.condition.getAsBoolean()) super.render(draw, mouseX, mouseY, delta);
    }
}
