public class DNSAmplification {

    class ps_hdr{
        int saddr;          //32 bits
        int daadr;          //32 bits
        short filler;       //8 bits
        short protocol;     //8 bits
        short len;          //16 bits
    }

    class dns_hdr{
        short id;
        short flags;
        short qcount;
        short ans;
        short auth;
        short add;
    }

    class dquery{
        short qtype;
        short qclass;
    }

    public static void main(String args[]){
        System.out.println("hello the");
    }

}
