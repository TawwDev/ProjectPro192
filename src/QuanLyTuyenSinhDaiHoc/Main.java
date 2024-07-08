
package QuanLyTuyenSinhDaiHoc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Manage a = new Manage();
    Scanner sc = new Scanner(System.in);
    Person b;
    int choice;
    
    do {
            a.menuChinh();
            System.out.print("Lua chon: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 0:
                    System.out.println("Da thoat chuong trinh!");
                    break;
                case 1:
                    try{
                        b = new Student();
                        a.themDsNguoi(b);
                    } catch(InputMismatchException ime){
                        System.out.println("Du lieu nhap khong hop le. Vui long thu lai!");
                    }
                    break;
                case 2:
                    try{
                        b = new Supervisor();
                        a.themDsNguoi(b);
                    }catch(InputMismatchException ime){
                        System.out.println("Du lieu nhap khong hop le. Vui long thu lai!");
                    }
                    break;
                case 3:
                    a.hienDSHoSoThiSinh();
                    break;
                case 4:
                    a.hienDSGiamThi();
                    break;
                case 5:
                    a.SuaDoi();
                    break;
                case 6:
                    a.suaNguyenVong();
                    break;
                case 7:
                    a.ghiFile();
                    break;
                case 8: 
                    String tenfile;
                    System.out.println("Nhap ten file muon doc:");
                    tenfile = sc.nextLine();
                    a.docFile(tenfile);
                    break;
                case 9:
                    System.out.println("Nhap ma nganh: ");
                    String maNganh = sc.nextLine();
                    System.out.println("Nhap diem chuan: ");
                    float diemChuan = sc.nextFloat();
                    if(diemChuan <0){
                        System.out.println("Diem phai lon hon 0, vui long nhap lai!");
                        break;
                    }
                    a.hienDSTrungTuyen(maNganh, diemChuan);
                    break;
                    
                case 10: 
                    a.SapXepTheoDiem();
                    break;
                case 11:
                    System.out.println("Nhap ten don vi cong tac cua Giam thi can tim: ");
                    String donVi = sc.nextLine();
                    a.hienGiamThiCongTac(donVi);
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
                    break;
            }
        } while (choice != 0);
    }
}
