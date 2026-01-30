package org.CreadoresProgram.ViaLegacyExt;
import net.raphimc.viaproxy.plugins.ViaProxyPlugin;
import net.raphimc.viaproxy.ViaProxy;
import net.lenni0451.lambdaevents.EventHandler;
import net.raphimc.viaproxy.plugins.events.PreConnectEvent;
import net.raphimc.viaproxy.protocoltranslator.ProtocolTranslator;
import net.raphimc.vialegacy.api.LegacyProtocolVersion;
import net.raphimc.viabedrock.api.BedrockProtocolVersion;
public class Main extends ViaProxyPlugin{
  @Override
  public void onEnable(){
    System.out.println("Loading ViaLegacyExt...");
    ViaProxy.EVENT_MANAGER.register(this);
  }
  @Override
  public void onDisable(){}
  @EventHandler
  public void onPreConnect(PreConnectEvent event){
    if(event.getClientVersion().olderThanOrEqualTo(LegacyProtocolVersion.c0_28toc0_30) || event.getClientVersion().equalTo(LegacyProtocolVersion.c0_30cpe)){
      if(ViaProxy.getConfig().targetVersion.trim().startsWith("Bedrock")){
        event.setServerVersion(BedrockProtocolVersion.bedrockLatest);
      }
    }
  }
}
