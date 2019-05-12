sudo tcpdump -i wlan0 udp port 53 | gawk '$3 ~ /192.168.2.36/ {print $5}'

