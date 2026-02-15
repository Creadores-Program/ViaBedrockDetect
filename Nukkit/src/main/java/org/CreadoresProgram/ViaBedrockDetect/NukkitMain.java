package org.CreadoresProgram.ViaBedrockDetect;
import cn.nukkit.Player;
import cn.nukkit.plugin.PluginBase;
import java.util.List;
import java.util.ArrayList;
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
    return player.getLoginChainData().getDeviceModel().equals("ViaProxyBedrock") && player.getLoginChainData().getDeviceOS() == 7;
  }
  public List<Player> getJavaPlayers(){
    List<Player> javaPlayers = new ArrayList<>();
    for(Player player : this.getServer().getOnlinePlayers().values()){
      if(this.isJavaPlayer(player)){
        javaPlayers.add(player);
      }
    }
    return javaPlayers;
  }
}
