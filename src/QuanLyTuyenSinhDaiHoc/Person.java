
package QuanLyTuyenSinhDaiHoc;

import java.util.Scanner;

public class Person {
    private String hoTen;
    private String queQuan;
    private int namSinh;
    private int gioiTinh;

    public Person() {
    }

    public Person(String hoTen, String queQuan, int namSinh, int gioiTinh) {
        this.hoTen = hoTen;
        this.queQuan = queQuan;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
    }

    public String getHoTen() {
        return hoTen;
    }
    
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }
    
    public String getGioiTinh() {
        if(gioiTinh == 1){
            return "Nam";
        } else if(gioiTinh ==0){
            return "Nu";
        } else {
            return null;
        }
    }
    
    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    public void nhap(){
        Scanner sc = new Scanner (System.in);
        System.out.print("Ho Ten: ");
        this.hoTen = sc.nextLine();
        System.out.print("Que Quan: ");
        this.queQuan = sc.nextLine();
        System.out.print("Nam Sinh: ");
        this.namSinh = sc.nextInt();
        do{
            System.out.println("Gioi tinh (nam: 1/nu: 0)");
            this.gioiTinh = sc.nextInt();
        } while(gioiTinh !=1 && gioiTinh!=0);
    }
    
    public void hien(){
        System.out.print("Ho va ten: " + getHoTen() + ", gioi tinh: "+ getGioiTinh() + ", nam sinh: " + getNamSinh()+", que quan: "+ getQueQuan() + "\n");
    }
}
