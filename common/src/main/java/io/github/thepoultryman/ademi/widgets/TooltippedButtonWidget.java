package io.github.thepoultryman.ademi.widgets;

import dev.emi.emi.api.widget.ButtonWidget;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.function.BooleanSupplier;

public class TooltippedButtonWidget extends ButtonWidget {
    private final ClientTooltipComponent tooltip;

    public TooltippedButtonWidget(int x, int y, int width, int height, int u, int v, ResourceLocation texture, BooleanSupplier isActive, ClickAction action, ClientTooltipComponent tooltip) {
        super(x, y, width, height, u, v, texture, isActive, action);
        this.tooltip = tooltip;
    }

    @Override
    public List<ClientTooltipComponent> getTooltip(int mouseX, int mouseY) {
        return List.of(this.tooltip);
    }
}
