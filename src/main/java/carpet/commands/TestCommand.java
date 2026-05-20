package carpet.commands;

import carpet.CarpetServer;
import carpet.utils.Messenger;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.exception.CommandException;
import net.minecraft.server.command.source.CommandSource;

public class TestCommand extends CarpetAbstractCommand{
    @Override
    public String getName() {
        return "testcarpet";
    }

    @Override
    public String getUsage(CommandSource source) {
        return "testcarpet <dump>";
    }

    @Override
    public void run(MinecraftServer server, CommandSource source, String[] args) throws CommandException {
        if (args.length == 0) {
            return;
        }

        if ("dump".equalsIgnoreCase(args[0])) {
            Messenger.m(source, "Dumping carpet settings");
            if (args.length == 1) {
                CarpetServer.settingsManager.dumpAllRulesToStream(System.out, null);
                return;
            }
            if (args.length == 2) {
                CarpetServer.settingsManager.dumpAllRulesToStream(System.out, args[1]);
                return;
            }
        }

        //maybe some other test thing
    }
}
