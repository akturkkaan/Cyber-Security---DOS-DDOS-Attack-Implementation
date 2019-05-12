 #!/ usr/bin/python
# next two lines are used to remove warning of ipv6

import logging
logging.getLogger(”scapy.runtime”).setLevel(logging.ERROR)

from scapy.all import ∗
import sys
import os

interface = ’eth0 ’
filter bpf = ’udp and port 53’
THRESHOLD = 100
queryList = []
attackCount = 0
flag = 0

#Apply this function on each received packet
def select DNS(pkt):
	global queryList , attackCount , THRESHOLD, flag
	try :
		if DNSQR in pkt and pkt.dport == 53:
			queryList.append(pkt[DNSQR].qname)
			if (flag == 1):
				print ”Legitimate User tries to Query DNS Server , so Drop rule deleted .”
				flag=0
				os.system(”iptables −F INPUT”)
				elif DNSRR in pkt and pkt.sport == 53:
					if(pkt[DNSRR].rrname in queryList):
						queryList.remove(pkt[DNSRR].rrname)
					else:
						attackCount += 1
						if(attackCount==THRESHOLD):
							print ’Alert : DNS Attack’
							os.system(”iptables −A INPUT −p udp −−sport 53 −j DROP”)
							print ”iptables Rule to drop packet from port 53 is added.”
							flag=1
							attackCount = 0
							return
	except:
		pass


# Start Sniffing
THRESHOLD = input( ’Enter threshold value for false DNS Response: ’)
sniff ( iface=interface , filter=filter bpf , store=0, prn=select DNS)




