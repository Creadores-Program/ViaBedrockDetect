package org.CreadoresProgram.ViaBedrockDetect;
import cn.nukkit.Player;
import cn.nukkit.plugin.PluginBase;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
public class NukkitMain extends PluginBase{
  private static NukkitMain instance;
  public static NukkitMain getInstance(){
    return instance;
  }
  public void onEnable(){
    instance = this;
    this.getLogger().info("§aDone!");
  }
  public void onDisable(){
    this.getLogger().info("§cBye!");
  }
  public boolean isJavaPlayer(Player player){
    return player.isJavaClient() || (player.getLoginChainData().getDeviceModel().equals("ViaProxyBedrock") && player.getLoginChainData().getDeviceOS() == 7);
  }
  public List<Player> getJavaPlayers(){
    return this.getServer().getOnlinePlayers().values().stream().filter(player -> isJavaPlayer(player)).collect(Collectors.toList());
  }
}
