package me.mchiappinam.pdghlobbycmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class Main extends JavaPlugin implements Listener, CommandExecutor {

	  public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginCommand("lobby").setExecutor(this);
	    getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		getServer().getConsoleSender().sendMessage("§3[PDGHLobbyCMD] §2ativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHLobbyCMD] §2Acesse: http://pdgh.net/");
	  }

	  public void onDisable() {
		getServer().getConsoleSender().sendMessage("§3[PDGHLobbyCMD] §2desativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHLobbyCMD] §2Acesse: http://pdgh.net/");
	  }
		

	    @Override
	    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
	        Player p = (Player) cs;
	            if(cmd.getName().equalsIgnoreCase("lobby")) {
	            	        ByteArrayDataOutput out = ByteStreams.newDataOutput();
	            	        out.writeUTF("Connect");
	            	        out.writeUTF("lobby");
	            	        p.sendPluginMessage(this, "BungeeCord", out.toByteArray());
	            return true;
	    }
	            return false;
	    }
	  
}