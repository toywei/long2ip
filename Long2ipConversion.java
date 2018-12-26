package com.test.long2ip;

public class Long2ipConversion {
    public Long getPow(int i) {
        return (long) Math.pow(256, i);
    }

    public String long2ip(long long_) {
        long i = long_;
        short part3 = (short) (long_ % getPow(1));
        i -= part3;
        short part2 = (short) (i % getPow(2) / getPow(1));
        i -= part2 * getPow(1);
        short part1 = (short) (i % getPow(3) / getPow(2));
        i -= part1 * getPow(2);
        short part0 = (short) (i / getPow(3));
        return part0 + "." + part1 + "." + part2 + "." + part3;
    }

    public String long2ip(String long_) {
        long intPointIp = Long.parseLong(long_.trim());
        return long2ip(intPointIp);
    }

    public long ip2long(String ip_) {
        String[] ip_s = ip_.trim().split("\\.");
        long res = 0;
        short ii = 3;
        for (String i : ip_s) {
            res += Long.parseLong(i) * getPow(ii);
            ii -= 1;
        }
        return res;
    }

}
