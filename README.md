## MSA_09_wlanParser

Little script for a WLAN signal strengh positioning system in the course "mobile systems and applications" in fourth semester. The script has to filter the strenghs and Macs. Example data:

Example file of Mesurement Point 1
```
"eduroam",40:f4:ec:12:2d:d2,[WPA-EAP-CCMP+TKIP][WPA2-EAP-CCMP+TKIP][ESS],2412 MHz,Channel 1,-73 dBm
"HFU Open",10:8c:cf:b5:91:40,[WPA-EAP-CCMP+TKIP][WPA2-EAP-CCMP+TKIP][ESS],2412 MHz,Channel 1,-83 dBm
"eduroam",10:8c:cf:b5:91:42,[WPA-EAP-CCMP+TKIP][WPA2-EAP-CCMP+TKIP][ESS],2412 MHz,Channel 1,-74 dBm
"HFU Guest",10:8c:cf:b5:91:43,[ESS],2412 MHz,Channel 1,-78 dBm
"HFU Open",c4:7d:4f:4b:ed:90,[WPA-EAP-CCMP+TKIP][WPA2-EAP-CCMP+TKIP][ESS],2462 MHz,Channel 11,-86 dBm
"eduroam",c4:7d:4f:4b:ed:92,[WPA-EAP-CCMP+TKIP][WPA2-EAP-CCMP+TKIP][ESS],2462 MHz,Channel 11,-88 dBm
"AP_KN_24",00:27:22:82:29:6e,[WPA2-PSK-CCMP][ESS],2452 MHz,Channel 9,-86 dBm
"HFU Guest",c4:7d:4f:4b:ed:94,[ESS],2462 MHz,Channel 11,-88 dBm
```

Example file of Mesurement Point 2
```
"eduroam",40:f4:ec:12:2d:d2,[WPA-EAP-CCMP+TKIP][WPA2-EAP-CCMP+TKIP][ESS],2412 MHz,Channel 1,-73 dBm
"HFU Open",40:f4:ec:12:2d:d0,[WPA-EAP-CCMP+TKIP][WPA2-EAP-CCMP+TKIP][ESS],2412 MHz,Channel 1,-72 dBm
"HFU Guest",40:f4:ec:12:2d:d3,[ESS],2412 MHz,Channel 1,-71 dBm
"eduroam",c4:7d:4f:4b:ed:92,[WPA-EAP-CCMP+TKIP][WPA2-EAP-CCMP+TKIP][ESS],2462 MHz,Channel 11,-70 dBm
"HFU Open",c4:7d:4f:4b:ed:90,[WPA-EAP-CCMP+TKIP][WPA2-EAP-CCMP+TKIP][ESS],2462 MHz,Channel 11,-81 dBm
"HFU Guest",c4:7d:4f:4b:ed:94,[ESS],2462 MHz,Channel 11,-81 dBm
"eduroam",10:8c:cf:b5:91:42,[WPA-EAP-CCMP+TKIP][WPA2-EAP-CCMP+TKIP][ESS],2412 MHz,Channel 1,-64 dBm
"HFU Open",10:8c:cf:b5:91:40,[WPA-EAP-CCMP+TKIP][WPA2-EAP-CCMP+TKIP][ESS],2412 MHz,Channel 1,-65 dBm
"HFU Guest",10:8c:cf:b5:91:43,[ESS],2412 MHz,Channel 1,-64 dBm
"eduroam",a8:b1:d4:6d:b3:32,[WPA-EAP-CCMP+TKIP][WPA2-EAP-CCMP+TKIP][ESS],2462 MHz,Channel 11,-89 dBm
"HFU Guest",a8:b1:d4:6d:b3:34,[ESS],2462 MHz,Channel 11,-90 dBm
```
