<?php
declare(strict_types=1);
namespace org\CreadoresProgram\ViaBedrockDetect;
use pocketmine\plugin\PluginBase;
use pocketmine\player\Player;
class PocketmineMain extends PluginBase{
  private static ?self $instance = null;
  private static string $deviceModelVP = "ViaProxyBedrock";
  private static string $deviceModelP = "DeviceModel";
  private static string $deviceOSP = "DeviceOS";
  private static string $defDeviceModel = "";
  public static function getInstance() : ?self{
    return self::$instance;
  }
  public function onEnable() : void{
    $this->getLogger()->info("§aDone!");
  }
  public function onDisable() : void{
    $this->getLogger()->info("§cBye!");
  }
  public function isJavaPlayer(Player $player) : bool{
    $extraData = $player->getNetworkSession()->getPlayerInfo()->getExtraData();
    $deviceModel = $extraData[self::$deviceModelP] ?? self::$defDeviceModel;
    return ($deviceModel == self::$deviceModelVP);
  }
  public function getJavaPlayers() : array{
    return array_filter($this->getServer()->getOnlinePlayers(), fn($player) => $this->isJavaPlayer($player));
  }
}
