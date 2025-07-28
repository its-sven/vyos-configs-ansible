interfaces {
    ethernet eth0 {
        address "172.31.31.101/24"
        hw-id "fa:16:3e:90:ec:0e"
        mtu "1500"
    }
    ethernet eth1 {
        address "172.31.11.25/24"
    }
    loopback lo {
    }
}
protocols {
    static {
        route 0.0.0.0/0 {
            next-hop 172.31.31.1 {
            }
        }
    }
}
service {
    ntp {
        allow-client {
            address "127.0.0.0/8"
            address "169.254.0.0/16"
            address "10.0.0.0/8"
            address "172.16.0.0/12"
            address "192.168.0.0/16"
            address "::1/128"
            address "fe80::/10"
            address "fc00::/7"
        }
        server time1.vyos.net {
        }
        server time2.vyos.net {
        }
        server time3.vyos.net {
        }
    }
    ssh {
        client-keepalive-interval "180"
        port "22"
        port "9999"
    }
}
system {
    config-management {
        commit-revisions "100"
    }
    console {
        device ttyS0 {
            speed "115200"
        }
    }
    domain-name "novalocal"
    host-name "a000000-1-r-sw"
    login {
        user vyos {
            authentication {
                encrypted-password "$6$rounds=656000$oSvBwBp0a6g8utkd$XjgdsQbfgYoiZ3PfcnWvwl9BK5VBUr3QsP5ChgAlA2sGDS06DGGs4pW4AKAhBwyVKawNopOquZHN2vMRtb4c8."
            }
        }
    }
    name-server "172.31.22.2"
    name-server "172.31.22.3"
    option {
        reboot-on-upgrade-failure "5"
    }
    syslog {
        local {
            facility all {
                level "info"
            }
            facility local7 {
                level "debug"
            }
        }
    }
}


// Warning: Do not remove the following line.
// vyos-config-version: "bgp@6:broadcast-relay@1:cluster@2:config-management@1:conntrack@6:conntrack-sync@2:container@2:dhcp-relay@2:dhcp-server@11:dhcpv6-server@6:dns-dynamic@4:dns-forwarding@4:firewall@18:flow-accounting@2:https@7:ids@2:interfaces@33:ipoe-server@4:ipsec@13:isis@3:l2tp@9:lldp@3:mdns@1:monitoring@2:nat@8:nat66@3:nhrp@1:ntp@3:openconnect@3:openvpn@4:ospf@2:pim@1:policy@9:pppoe-server@11:pptp@5:qos@3:quagga@12:reverse-proxy@3:rip@1:rpki@2:salt@1:snmp@3:ssh@2:sstp@6:system@29:vpp@1:vrf@3:vrrp@4:vyos-accel-ppp@2:wanloadbalance@4:webproxy@2"
// Release version: 1.5-rolling-202506111430
