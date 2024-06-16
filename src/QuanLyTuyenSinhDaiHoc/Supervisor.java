
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
        return donViCT;
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
        System.out.println("\nMã giám thị: "+ getMaGt()+ ", đơn vị công tác: "+ getDonViCT()+"}");
    }
}
