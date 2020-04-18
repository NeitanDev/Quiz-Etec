package Classes;

public class Metodos {

    public static String per[] = new String[9];
    public static String r1[] = new String[9];
    public static String r2[] = new String[9];
    public static String r3[] = new String[9];
    public static String r4[] = new String[9];
    public static int resp_certa[] = new int[9];
    public static String voltaS;
    public static int voltasI;
    public static String raking[]=new String[15];
    public static String voltaR;
    public static int acertos[]=new int [15];
    public static int voltaa[]=new int[4];

    public static void setRaking(int x,String raking) {
        Metodos.raking[x] = raking;
    }

    public static void setAcertos(int acertos, int x) {
        Metodos.acertos[x] = acertos;
    }

    public static String getRaking(int x) {
        return raking[x];
    }

    public static int getAcertos(int x) {
        return acertos[x];
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public static void setPer(int x,String perg){
    per[x]=perg;
    }
    public static void setR1(int x,String R1){
    r1[x]=R1;
    }
    public static void setR2(int x,String R2){
    r2[x]=R2;
    }
    public static void setR3(int x,String R3){
    r3[x]=R3;
    }
    public static void setR4(int x,String R4){
    r4[x]=R4;
    }
    public static void setResp_Certa(int x,int Resp){
    resp_certa[x]=Resp;
    }
    
    
    
    public String getPer(int x){
        voltaS=per[x];
        return voltaS;    
    }
    public String getR1(int x){
        voltaS=r1[x];
        return voltaS;    
    }
    public String getR2(int x){
        voltaS=r2[x];
        return voltaS;    
    }
    public String getR3(int x){
        voltaS=r3[x];
        return voltaS;    
    }
    public String getR4(int x){
        voltaS=r4[x];
        return voltaS;    
    }
    public int getResp(int x){
        voltasI=resp_certa[x];
        return voltasI;    
    }
}
