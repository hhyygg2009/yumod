package com.yu.yuplus.sound.command;

import com.yu.yuplus.sound.ExtSoundManager;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.server.command.CommandTreeBase;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author :hhyygg2009
 * @date :Created in  2021/3/17 17:27
 */


public class ExtSoundCommand extends CommandTreeBase {

    public ExtSoundCommand() {

        this.addSubcommand(new CommandBase() {
            @Override
            public int getRequiredPermissionLevel() {
                return 0;
            }

            @Override
            public String getName() {
                return "play";
            }

            @Override
            public String getUsage(ICommandSender sender) {
                return "/play";
            }

            @Override
            public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
//                ExtSoundManager.getInstance().playUrl("http://localhost/%e3%81%82%e3%82%88%20-%20%e5%8c%82%e3%82%8f%e3%81%9b%e6%8e%a2%e5%81%b5.mp3");
                ExtSoundManager.getInstance().playUrl(args[0]);
            }

        });
        this.addSubcommand(new CommandBase() {
            @Override
            public int getRequiredPermissionLevel() {
                return 0;
            }

            @Override
            public String getName() {
                return "pause";
            }

            @Override
            public String getUsage(ICommandSender sender) {
                return "/pause";
            }

            @Override
            public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
                ExtSoundManager.pauseSound();
            }

        });
        this.addSubcommand(new CommandBase() {
            @Override
            public int getRequiredPermissionLevel() {
                return 0;
            }

            @Override
            public String getName() {
                return "resume";
            }

            @Override
            public String getUsage(ICommandSender sender) {
                return "/resume";
            }

            @Override
            public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
                ExtSoundManager.playSound();
            }

        });
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public String getName() {
        return "yuplus";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/yuplus";
    }

    /**
     * Get a list of commands usable by the command sender, sorted in their natural order.
     *
     * @param sender The command sender
     * @param server The server
     * @return The possible commands
     */
    public List<ICommand> getSortedPossibleCommands(final ICommandSender sender, final MinecraftServer server) {
        return getSubCommands().stream()
                .filter(command -> command.checkPermission(server, sender))
                .sorted()
                .collect(Collectors.toList());
    }
}
