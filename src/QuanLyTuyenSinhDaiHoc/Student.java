
package QuanLyTuyenSinhDaiHoc;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person{
    private String SBD;
    public float diemUuTien;
    private ArrayList <Wish> nguyenVong;
    Wish nguyenVongA;

    public Student() {
    }

    public Student(String SBD, float diemUuTien, ArrayList<Wish> nguyenVong, Wish nguyenVongA) {
        this.SBD = SBD;
        this.diemUuTien = diemUuTien;
        this.nguyenVong = nguyenVong;
        this.nguyenVongA = nguyenVongA;
    }

    public String getSBD() {
        return SBD;
    }

    public void setSBD(String SBD) {
        this.SBD = SBD;
    }

    public float getDiemUuTien() {
        return diemUuTien;
    }

    public void setDiemUuTien(float diemUuTien) {
        this.diemUuTien = diemUuTien;
    }

    public ArrayList<Wish> getNguyenVong() {
        return nguyenVong;
    }

    public void setNguyenVong(ArrayList<Wish> nguyenVong) {
        this.nguyenVong = nguyenVong;
    }

    public Wish getNguyenVongA() {
        return nguyenVongA;
    }

    public void setNguyenVongA(Wish nguyenVongA) {
        this.nguyenVongA = nguyenVongA;
    }
    
    @Override 
    public void nhap(){
        Scanner sc = new Scanner (System.in);
        super.nhap();
        System.out.print("SBD: ");
        SBD = sc.nextLine();
        System.out.print("Điểm ưu tiên: ");
        diemUuTien = sc.nextFloat();
        setDiemUuTien(diemUuTien);
        nhapDsNguyenVong();
    }
    
    public void nhapDsNguyenVong(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số nguyện vọng vần thêm: ");
        int n = sc.nextInt();
        nguyenVong = new ArrayList<>();
        for(int i=0; i<n; i++){
            nguyenVongA = new Wish();
            nguyenVongA.nhapNguyenVong();
            nguyenVong.add(nguyenVongA);
        }
    }
     
    public void hienDsNguyenVong(){
        int index =1;
        for(Wish x : nguyenVong){
            System.out.print("Ma nguyen vong "+index++ +": ");
            x.hienNguyenVong();
        }
    }
    
    @Override 
    public void hien(){
        super.hien();
        System.out.println("SBD: " + getSBD() + ", điểm ưu tiên: "+ getDiemUuTien());
        hienDsNguyenVong();
    }
    
    public void hienThongTinTs(){
        super.hien();
        System.out.println("SBD: " + getSBD() + ", điểm ưu tiên: "+ getDiemUuTien());
    }
}
