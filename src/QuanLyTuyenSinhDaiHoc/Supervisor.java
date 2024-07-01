
package QuanLyTuyenSinhDaiHoc;

import java.util.Scanner;

public class Supervisor extends Person{
    private String maGt, donViCT;

    public Supervisor() {
    }

    public Supervisor(String maGt, String donViCT) {
        this.maGt = maGt;
        this.donViCT = donViCT;
    }

    public String getMaGt() {
        return maGt;
    }

    public void setMaGt(String maGt) {
        this.maGt = maGt;
    }

    public String getDonViCT() {
        return chuanHoa(this.donViCT);
    }

    public void setDonViCT(String donViCT) {
        this.donViCT = donViCT;
    }
    
    @Override
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner (System.in);
        System.out.print("Mã giám thị: ");
        maGt = sc.nextLine();
        System.out.print("Đơn vị công tác: ");
        donViCT = sc.nextLine();
    }
    
    @Override
    public void hien(){
        super.hien();
        System.out.print("Mã giám thị: "+ getMaGt()+ ", Đơn vị công tác: "+ getDonViCT()+"\n");
    }
    
    public String chuanHoa(String s){
        String newName = "";
        String []a = s.split("\\s+");
        for(String x :a){
            newName += Character.toUpperCase(x.charAt(0));
            for(int j=1; j<x.length(); j++){
                newName += Character.toLowerCase(x.charAt(j));
            }
            newName+= " ";
        }
        return newName.trim();
    }
}
