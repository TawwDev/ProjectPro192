
package QuanLyTuyenSinhDaiHoc;

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
                    b = new Student();
                    a.themDsNguoi(b);
                    break;
                case 2:
                    b = new Supervisor();
                    a.themDsNguoi(b);
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
                    sc.nextLine();
                    String maNganh = sc.nextLine();
                    System.out.println("Nhập điểm chuẩn: ");
                    float diemChuan = sc.nextFloat();
                    a.hienDSTrungTuyen(maNganh, diemChuan);
                    break;
                case 7: 
                    // Implement sorting logic here
                    break;
                case 8:
                    a.hienGiamThioHaNoi();
                    break;
                default:
                    break;
            }
        } while (choice != 0);
    }
}
