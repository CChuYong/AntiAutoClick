package chuyong.cosmo.antiac;

import chuyong.cosmo.antiac.enums.ProcessType;

public class AntiACAPI {
    private static int maxPacket;
    private static ProcessType type;
    private static String message;
    public static int getMaxPackets(){return maxPacket;}
    public static ProcessType getProcessType(){return type;}
    public static String getMessage(){return message;}
    public static void setMaxPacket(int packet){maxPacket=packet;}
    public static void setProcessType(ProcessType typo){type = typo;}
    public static void setMessage(String s){message=s;}
    static{
        maxPacket = 30;
        type = ProcessType.KICK;
        message = "과도한 패킷 시도로 서버에서 추방되었습니다.";
    }
}
