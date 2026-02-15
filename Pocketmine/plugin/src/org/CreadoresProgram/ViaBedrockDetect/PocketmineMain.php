<?php
declare(strict_types=1);
namespace org\CreadoresProgram\ViaBedrockDetect;
use pocketmine\plugin\PluginBase;
use pocketmine\Player;
class PocketmineMain extends PluginBase{
  public function onLoad() : void{
    $this->getLogger()->info("§aDone!");
  }
  public function isJavaPlayer(Player $player) : bool{
    $extraData = $player->getNetworkSession()->getPlayerInfo()->getExtraData();
    $deviceModel = $extraData["DeviceModel"] ?? "";
    $osId = $extraData["DeviceOS"] ?? -1;
    return ($deviceModel == "ViaProxyBedrock") && ($osId == 7);
  }
  public function getJavaPlayers() : array{
    $javaPlayers = [];
    foreach ($this->getServer()->getOnlinePlayers() as $player) {
      if($this->isJavaPlayer($player)){
        $javaPlayers[] = $player;
      }
    }
    return $javaPlayers;
  }
}
