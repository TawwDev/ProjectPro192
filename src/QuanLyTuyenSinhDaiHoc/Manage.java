
package QuanLyTuyenSinhDaiHoc;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Manage {
    private ArrayList<Person> person;
    private ArrayList<Student> dsTrungTuyenNganh;
    private ArrayList<Wish> nvTrungTuyen;
    
    public Manage(){
        person = new ArrayList();
    }
    
    public void themDsNguoi(Person a) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng cần thêm: ");   
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            System.out.println("Lần nhập thứ " + (i+1) + ":");
            if(a instanceof Student){
                a = new Student();
                a.nhap();
            } else if (a instanceof Supervisor){
                a = new Supervisor();
                a.nhap();
            }
            a.setHoTen(chuanHoa(a.getHoTen()));
            a.setQueQuan(chuanHoa(a.getQueQuan()));
            person.add(a);
        }
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
    
    public void menuSuaDoi() {
        System.out.println("-----------Mời bạn lựa chọn-------------");
        System.out.println("| 1.Sửa thông tin thí sinh              |");
        System.out.println("| 2.Xóa thí sinh                        |");
        System.out.println("| 3.Sửa thông tin giám thị              |");
        System.out.println("| 4.Xóa giám thị                        |");
        System.out.println("| 5.Sửa nguyện vọng                     |");
        System.out.println("| 6.Thêm nguyện vọng                    |");
        System.out.println("| 7.Xóa nguyện vọng                     |");
        System.out.println("-----------Chọn số 0 đề thoát-----------");
    }
    
    public void SuaDoi(){
        Scanner sc = new Scanner (System.in);
        int n;
        do{
            menuSuaDoi();
            System.out.print("Chọn: ");
            n = sc.nextInt();
            
            switch(n){
                case 1:{
                    String sbd;
                    System.out.println("Nhập SBD của thí sinh cần sửa: ");
                    sc.nextLine();
                    sbd = sc.nextLine();
                    suaThiSinh(sbd);
                    break;
                }
                case 2:{
                    String sbd;
                    System.out.println("Nhập SBD của thí sinh cần xóa: ");
                    sc.nextLine();
                    sbd = sc.nextLine();
                    xoaThiSinh(sbd);
                    break;
                }
                case 3:{
                    String maGT;
                    System.out.println("Nhập mã giám thị cần sửa thông tin: ");
                    sc.nextLine();
                    maGT = sc.nextLine();
                    suaGiamThi(maGT);
                    break;
                }
                case 4:{
                    String maGT;
                    System.out.println("Nhập mã giám thị cần xóa thông tin: ");
                    sc.nextLine();
                    maGT = sc.nextLine();
                    xoaGiamThi(maGT);
                    break;
                }
                case 5:{
                    System.out.println("Nhập SBD của thí sinh: ");
                    sc.nextLine();
                    String sbd = sc.nextLine();
                    System.out.println("Nhập mã nguyện vọng: ");
                    int maNv = sc.nextInt();
                    suaNguyenVong(maNv,sbd);
                    break;   
                }
                case 6:{
                    System.out.println("Nhập SBD của thí sinh: ");
                    sc.nextLine();
                    String sbd = sc.nextLine();
                    themNguyenVong(sbd);
                    break;   
                }
                case 7:{
                    System.out.println("Nhập SBD của thí sinh: ");
                    sc.nextLine();
                    String sbd = sc.nextLine();
                    System.out.println("Nhập mã nguyện vọng: ");
                    int maNv = sc.nextInt();
                    xoaNguyenVong(maNv,sbd);
                    break;   
                }
                default : 
                    break;
            }
        } while (n !=0);
    }
    
    public void suaNguyenVong(int maNV, String sbd){
//        boolean flag = true;
//        boolean flag2 = true;
        for(Person x: person){
            if(((Student)x).getSBD().compareTo(sbd) ==0){
//                flag2 = false;
                for(int i=0; i<((Student)x).getNguyenVong().size(); i++){
                    if(((Student)x).getNguyenVong().get(i).getMaNv() == maNV-1){
                        ((Student)x).getNguyenVong().get(i).nhapNguyenVong();
//                        flag = false;
                    }
                }
            }
        }
//        if(flag2){
//            System.out.println("Khong tim thay Sbd, vui long kiem tra lai!");
//        }else {
//            System.out.println("Sua thanh cong!");
//        }
//        if(flag){
//            System.out.println("Khong tim thay ma nguyen vong, vui long kiem tra lai!");
//        }else {
//            System.out.println("Sua thanh cong");
//        }
    }
    
    public void xoaNguyenVong(int maNV, String sbd){
        boolean flag = true;
        for(Person x: person){
            if(((Student)x).getSBD().compareTo(sbd) ==0){
                for(int i=0; i<((Student)x).getNguyenVong().size(); i++){
                    if(((Student)x).getNguyenVong().get(i).getMaNv() == maNV-1){
                        ((Student)x).getNguyenVong().remove(i);
                        flag = false;
                    }
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay ma nguyen vong hoac sbd, vui long kiem tra lai!");
        }else {
            System.out.println("Xoa thanh cong");
        }
    }
    
    public void themNguyenVong(String sbd){
        boolean flag = true;
        for(Person x: person){
            if(x instanceof Student){
                ((Student)x).nhapDsNguyenVong();
                flag = false;
            }
        }
        if(flag){
            System.out.println("Khong tim thay Sbd, vui long kiem tra lai!");
        } else{
            System.out.println("Them nguyen vong thanh cong!");
        }
    }
    
    public void suaThiSinh(String sbd){
        boolean flag= true;
        for(Person x: person){
            if(x instanceof Student){
                if(((Student)x).getSBD().compareTo(sbd)==0){
                   x.nhap();
                   flag = false;
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay Sbd, vui long kiem tra lai!");
        } else{
            System.out.println("Sua thi sinh thanh cong!");
        }
    }
    
    public void xoaThiSinh(String sbd){
        boolean flag= true;
        for(Person x: person){
            if(x instanceof Student){
                if(((Student)x).getSBD().compareTo(sbd)==0){
                   person.remove(x);
                   flag = false;
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay Sbd, vui long kiem tra lai!");
        } else{
            System.out.println("Xoa thi sinh thanh cong!");
        }
    }
    
    public void suaGiamThi(String maGT){
        boolean flag= true;
        for(Person x: person){
            if(x instanceof Supervisor){
                if(((Supervisor)x).getMaGt().compareTo(maGT)==0){
                   x.nhap();
                   flag = false;
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay ma giam thi, vui long kiem tra lai!");
        } else{
            System.out.println("Sua giam thi thanh cong!");
        }
    }
    
    public void xoaGiamThi(String maGT){
        boolean flag= true;
        for(Person x: person){
            if(x instanceof Supervisor){
                if(((Supervisor)x).getMaGt().compareTo(maGT)==0){
                   person.remove(x);
                   flag = false;
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay ma giam thi, vui long kiem tra lai!");
        } else{
            System.out.println("Xoa giam thi thanh cong!");
        }
    }
    
    public void hienDSGiamThi(){
        System.out.println("--------------------------");
        for(Person x : person){
            if(x instanceof Supervisor){
                x.hien();
            }
        }
    }
    
    public void hienDS(){
        System.out.println("--------------------------");
        for(Person x : person){
            x.hien();
        }
    }
    
    public void hienDSHoSoThiSinh(){
        System.out.println("--------------------------");
        for(Person x : person){
            if(x instanceof Student){
                ((Student)x).hien();
            }
        }
    }
    public void hienDSThiSinh(){
        System.out.println("--------------------------");
        for(Person x : person){
            if(x instanceof Student){
                x.hien();
            }
        }
    }
    
    public void hienDSTrungTuyen(String maNganh, float diemChuan){
        dsTrungTuyenNganh = new ArrayList<>();
        nvTrungTuyen = new ArrayList<>();
        for(Person x : person){
            if(x instanceof Student){
                for(int i=0; i<((Student)x).getNguyenVong().size(); i++){
                    if(((Student)x).getNguyenVong().get(i).getMaNganh().compareTo(maNganh) == 0 && ((Student)x).getNguyenVong().get(i).getDiemThi() >= diemChuan){
                        ((Student)x).hienThongTinTs();
                        ((Student)x).getNguyenVong().get(i).hienNguyenVong();
                        dsTrungTuyenNganh.add((Student)x);
                        nvTrungTuyen.add(((Student)x).getNguyenVong().get(i));
                    }
                }
            }
        }
    }
    
    public void hienDSTTNganh(){
        for(Wish x : nvTrungTuyen){
            x.hienNguyenVong();
        }
    }
    
    public void menuFile(){
        System.out.println("-------------------------------");
        System.out.println("|  1. ghi thi sinh vao file.  |");
        System.out.println("|  2. ghi giam thi vao file.  |");
        System.out.println("--------Chon 0 de thoat!-------");
    }
    
    public void ghiFile(){
        Scanner sc = new Scanner (System.in);
        int n;
        do{
            menuFile();
            System.out.print("Chọn: ");
            n = Integer.parseInt(sc.nextLine());
            
            switch(n){
                case 0:
                    System.out.println("Da thoat!");
                    break;
                case 1:   
                    ghiFileStudent();
                    break;
                case 2:
                    ghiFileSupervisor();
                    break;
                default:
                    System.out.println("Lua chon khong hop le vui long nhap lai!!");
                    break;
            }
        } while(n!=0);
    }
    
    public void ghiFileStudent(){
        int index = 1;
        try {
            FileWriter fw = new FileWriter("thisinh.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Person p : person) {
                if (p instanceof Student) {
                    Student s = (Student) p;
                    bw.write(index +". Student," + "Ho ten: " + s.getHoTen() + ",Que quan: " + s.getQueQuan() + ",Nam sinh: " +
                            s.getNamSinh() + ",Gioi Tinh: " + s.getGioiTinh() + ",Sbd: " + s.getSBD() + ", Diem uu tien: " + s.getDiemUuTien());
                    for (Wish w : s.getNguyenVong()) {
                        bw.write(",Ma nguyen vong: " + w.getMaNv() + ",Ma truong: " + w.getMaTruong() + ",Ma nganh: " + w.getMaNganh() + ",Ten nganh: " + w.getTenNganh() + ",Khoi xet tuyen: " + w.getKhoiXt() + ",Diem thi: " + w.getDiemThi());
                    }
                    index++;
                    bw.newLine();
                } 
            }
            bw.close();
            fw.close();
            System.out.println("Ghi file thisinh.txt thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
    public void ghiFileSupervisor(){
        int index = 1;
        try {
            FileWriter fw = new FileWriter("giamthi.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Person p : person) {
                if (p instanceof Supervisor) {
                    Supervisor s = (Supervisor) p;
                    bw.write(index+ ". Supervisor," + s.getHoTen() + "," + s.getQueQuan() + "," +
                            s.getNamSinh() + "," + s.getGioiTinh() + "," + s.getMaGt() + "," + s.getDonViCT());
                    index++;
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();
            System.out.println("Ghi file giamthi.txt thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
    public void docFile(String fileName){
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                // Xử lý dữ liệu đọc được từ file
                System.out.println(line);
            }
            System.out.println("Đọc file thành công.");
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
    
    public void SapXepTheoDiem(){
        Collections.sort(nvTrungTuyen, new Comparator<Wish>(){
            @Override
            public int compare(Wish o1, Wish o2) {
               if(o1.getDiemThi() > o2.getDiemThi()){
                   return -1;
               } else {
                   return 1;
               }
            }  
        });
        System.out.println("Danh sách trúng tuyển sai khi sắp xếp");
        hienDSTTNganh();
    }
    
    public void hienGiamThioHaNoi(){
        for(Person x : person){
            if(x instanceof Supervisor && ((Supervisor)x).getQueQuan().equalsIgnoreCase("Ha Noi")== true){
                x.hien();
            }
        }
    }
    
    
    
    public void menuChinh(){
        System.out.println("-------------CHƯƠNG TRÌNH QUẢN LÍ TUYỂN SINH ĐẠI HỌC 2024----------------");
        System.out.println("| 1. Nhập danh sách thí sinh và nguyện vọng của thí sinh                 |");
        System.out.println("| 2. Nhập danh sách giám thị coi thi                                     |");
        System.out.println("| 3. Hiển thị danh sách các hỗ sơ dự thi                                 |");
        System.out.println("| 4. Hiển thị danh sách các giám thị                                     |");
        System.out.println("| 5. Chỉnh sửa thông tin (Thí Sinh, Nguyên Vọng,Giám Thị)                |");
        System.out.println("| 6. Hiện ra danh sách trúng tuyền( input: mã ngành, điểm chuẩn)         |");
        System.out.println("| 7. Lưu file đã nhập                                                    |");
        System.out.println("| 8. Đọc dữ lệu từ file                                                  |");
        System.out.println("| 9. Sắp xếp danh sách trúng tuyển theo điểm thi giảm dần                |");
        System.out.println("| 10. Thông kê các giám thị công tác ở Hà Nội                            |");
        System.out.println("-------------.Nhắn phím 0 để thoát chương trình, xin cảm ơn!-------------");
    }
}
