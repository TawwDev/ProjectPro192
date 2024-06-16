
package QuanLyTuyenSinhDaiHoc;

import java.util.Scanner;

public class Wish {
    private String maNganh, maTruong, tenNganh, khoiXt;
    private float diemThi;
    private int maNv;

    public Wish() {
    }

    public Wish(int maNv, String maNganh, String maTruong, String tenNganh, String khoiXt, float diemThi) {
        this.maNganh = maNganh;
        this.maTruong = maTruong;
        this.tenNganh = tenNganh;
        this.khoiXt = khoiXt;
        this.diemThi = diemThi;
        this.maNv = maNv;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getMaTruong() {
        return maTruong;
    }

    public void setMaTruong(String maTruong) {
        this.maTruong = maTruong;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public String getKhoiXt() {
        return khoiXt;
    }

    public void setKhoiXt(String khoiXt) {
        this.khoiXt = khoiXt;
    }

    public float getDiemThi() {
        return diemThi;
    }

    public void setDiemThi(float diemThi) {
        this.diemThi = diemThi;
    }

    public int getMaNv() {
        return maNv;
    }

    public void setMaNv(int maNv) {
        this.maNv = maNv;
    }
    
    public void nhapNguyenVong(){
        Scanner sc = new Scanner (System.in);
        System.out.println("Mã nguyện vọng: từ 1 tăng dần: ");
        System.out.print("Mã trường: ");
        this.maTruong = sc.nextLine();
        System.out.print("Mã ngành: ");
        this.maNganh = sc.nextLine();
        System.out.print("Tên ngành: ");
        this.tenNganh = sc.nextLine();
        System.out.print("Khối xét tuyển: ");
        this.khoiXt = sc.nextLine();
        System.out.print("Điểm thi: ");
        this.diemThi = sc.nextFloat();
    }
    
    public void hienNguyenVong(){
        System.out.println("Mã trường: " + getMaTruong() + ", mã ngành: "+ getMaNganh()+", tên ngành: " + getTenNganh() + "\nKhối xét tuyển: "+getKhoiXt()+", điểm xét tuyển: "+ getDiemThi());
    }
    
}
