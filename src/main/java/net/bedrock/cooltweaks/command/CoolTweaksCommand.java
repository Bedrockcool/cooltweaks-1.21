package net.bedrock.cooltweaks.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;

public class CoolTweaksCommand {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(
                literal("cooltweaks").executes(CoolTweaksCommand::execute)
        ));
    }

    private static int execute(CommandContext<ServerCommandSource> context) {
        ServerPlayerEntity player = context.getSource().getPlayer();
        if (player != null) {
            player.sendMessage(Text.literal("Opening Cool Tweaks GUI..."), false);
            // GUI opening logic will go here later
        }
        return Command.SINGLE_SUCCESS;
    }

    public static void registerCommands() {
    }
}
