package org.CreadoresProgram.ViaBedrockDetect;
import net.raphimc.viaproxy.plugins.ViaProxyPlugin;
import net.raphimc.viaproxy.ViaProxy;
import net.raphimc.viaproxy.plugins.events.ViaLoadingEvent;
import net.raphimc.viabedrock.protocol.provider.SkinProvider;
import net.raphimc.viabedrock.protocol.data.enums.bedrock.generated.BuildPlatform;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import net.lenni0451.lambdaevents.EventHandler;
import java.util.Map;
public class ViaProxyMain extends ViaProxyPlugin{
  private String prefix = "[ViaBedrockDetect] ";
  @Override
  public void onEnable(){
    System.out.println(prefix + "Loading ViaBedrockDetect...");
    ViaProxy.EVENT_MANAGER.register(this);
    System.out.println(prefix + "Done!");
  }
  @Override
  public void onDisable(){
    System.out.println(prefix + "Bye!");
  }
  @EventHandler
  public void onViaLoading(ViaLoadingEvent event){
    Via.getManager().getProviders().use(SkinProvider.class, new SkinProvider(){
      @Override
      public Map<String, Object> getClientPlayerSkin(final UserConnection user){
        final Map<String, Object> claims = super.getClientPlayerSkin(user);
        claims.put("DeviceOS", BuildPlatform.UWP.getValue());
        claims.put("DeviceModel", "ViaProxyBedrock");
        return claims;
      }
    });
  }
}
