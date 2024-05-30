package io.github.thepoultryman.ademi.widgets;

import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.widget.SlotWidget;

public class CustomSlotWidget extends SlotWidget {
    public CustomSlotWidget(EmiIngredient stack, int x, int y) {
        super(stack, x - 1, y - 1);
        this.drawBack(false);
    }
}
