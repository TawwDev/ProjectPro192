
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
            System.out.print("Lưa chọn: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    try{
                        b = new Student();
                        a.themDsNguoi(b);
                    } catch(InputMismatchException ime){
                        System.out.println("Dữ liệu nhập không hợp lệ. Vui lòng thử lại.");
                    }
                    break;
                case 2:
                    try{
                        b = new Supervisor();
                        a.themDsNguoi(b);
                    }catch(InputMismatchException ime){
                        System.out.println("Dữ liệu nhập không hợp lệ. Vui lòng thử lại.");
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
                    System.out.println("Nhập mã ngành: ");
                    String maNganh = sc.nextLine();
                    System.out.println("Nhập điểm chuẩn: ");
                    float diemChuan = sc.nextFloat();
                    a.hienDSTrungTuyen(maNganh, diemChuan);
                    break;
                case 7:
                    String tenFile;
                    System.out.println("Nhập tên file muốn lưu:");
                    sc.nextLine();
                    tenFile = sc.nextLine();
                    a.ghiFile(tenFile);
                    break;
                case 8: 
                    String tenfile;
                    System.out.println("Nhập tên file muốn đọc:");
                    sc.nextLine();
                    tenfile = sc.nextLine();
                    a.docFile(tenfile);
                    break;
                case 9: 
                    a.SapXepTheoDiem();
                    break;
                case 10:
                    a.hienGiamThioHaNoi();
                    break;
                default:
                    break;
            }
        } while (choice != 0);
    }
}
