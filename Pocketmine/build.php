<?php
echo "Packing ViaBedrockDetect...\n";
$pharFile = "ViaBedrockDetect.phar";
$phar = new Phar($pharFile);
$phar->setAlias("ViaBedrockDetect.phar");
$phar->buildFromDirectory(dirname(__FILE__) . '/plugin');
if(Phar::canCompress(Phar::GZ)){
    $phar->compressFiles(Phar::GZ);
} elseif (Phar::canCompress(Phar::BZ2)){
    $phar->compressFiles(Phar::BZ2);
}
$phar->setStub("<?php __HALT_COMPILER(); ?>");
echo "Done!\n";
?>
