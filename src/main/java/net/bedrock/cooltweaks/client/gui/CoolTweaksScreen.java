package net.bedrock.cooltweaks.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class CoolTweaksScreen extends Screen {
    private final List<ButtonWidget> tabs = new ArrayList<>();

    public CoolTweaksScreen() {
        super(Text.literal("Cool Tweaks Settings"));
    }

    @Override
    protected void init() {
        int tabWidth = 100;
        int tabHeight = 20;

        // Clear existing tabs and create new ones
        tabs.clear();

        // Add "General" tab
        tabs.add(addDrawableChild(
                ButtonWidget.builder(Text.literal("General"), button -> switchToTab("General"))
                        .dimensions(10, 10, tabWidth, tabHeight)
                        .build()
        ));

        // Add "Advanced" tab
        tabs.add(addDrawableChild(
                ButtonWidget.builder(Text.literal("Advanced"), button -> switchToTab("Advanced"))
                        .dimensions(120, 10, tabWidth, tabHeight)
                        .build()
        ));

        // Add "Other" tab
        tabs.add(addDrawableChild(
                ButtonWidget.builder(Text.literal("Other"), button -> switchToTab("Other"))
                        .dimensions(230, 10, tabWidth, tabHeight)
                        .build()
        ));
    }

    private void switchToTab(String tabName) {
        if (client != null && client.player != null) {
            client.player.sendMessage(Text.literal("Switched to tab: " + tabName), false);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta); // Render the background
        super.render(context, mouseX, mouseY, delta); // Render buttons and widgets
        context.drawCenteredTextWithShadow(textRenderer, this.title, this.width / 2, 5, 0xFFFFFF); // Draw the title
    }
}
