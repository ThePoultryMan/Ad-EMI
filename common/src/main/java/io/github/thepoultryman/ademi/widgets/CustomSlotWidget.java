package io.github.thepoultryman.ademi.widgets;

import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.widget.SlotWidget;
import net.minecraft.client.gui.GuiGraphics;

import java.util.function.BooleanSupplier;

public class CustomSlotWidget extends SlotWidget {
    private final BooleanSupplier shouldRender;
    
    public CustomSlotWidget(EmiIngredient stack, int x, int y) {
        this(stack, x, y, () -> true);
        this.drawBack(false);
    }

    public CustomSlotWidget(EmiIngredient stack, int x, int y, BooleanSupplier shouldRender) {
        super(stack, x - 1, y - 1);
        this.drawBack(false);
        this.shouldRender = shouldRender;
    }

    @Override
    public void render(GuiGraphics draw, int mouseX, int mouseY, float delta) {
        if (shouldRender.getAsBoolean()) super.render(draw, mouseX, mouseY, delta);
    }
}
