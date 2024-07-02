
package QuanLyTuyenSinhDaiHoc;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.InputMismatchException;
import java.util.List;
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
                    try {
                        String sbd;
                        System.out.println("Nhập SBD của thí sinh cần sửa: ");
                        sc.nextLine();
                        sbd = sc.nextLine();
                        suaTS(sbd);
                    } catch(InputMismatchException ime){
                        System.out.println("Dữ liệu nhập không hợp lệ. Vui lòng thử lại.");
                    }
                    break;
                }
                case 2:{
                    try{
                        String sbd;
                        System.out.println("Nhập SBD của thí sinh cần xóa: ");
                        sc.nextLine();
                        sbd = sc.nextLine();
                        xoaThiSinh(sbd);
                    } catch(InputMismatchException ime){
                        System.out.println("Dữ liệu nhập không hợp lệ. Vui lòng thử lại.");
                    } catch(ConcurrentModificationException cme){
                        System.out.println("Dữ liệu nhập không hợp lệ. Vui lòng thử lại.");
                    }
                    
                    break;
                }
                case 3:{
                    try{
                        String maGT;
                        System.out.println("Nhập mã giám thị cần sửa thông tin: ");
                        sc.nextLine();
                        maGT = sc.nextLine();
                        suaGt(maGT);
                    } catch(InputMismatchException ime){
                        System.out.println("Dữ liệu nhập không hợp lệ. Vui lòng thử lại.");
                    }
                    break;
                }
                case 4:{
                    try{
                        String maGT;
                        System.out.println("Nhập mã giám thị cần xóa thông tin: ");
                        sc.nextLine();
                        maGT = sc.nextLine();
                        xoaGiamThi(maGT);
                    }catch(InputMismatchException ime){
                        System.out.println("Dữ liệu nhập không hợp lệ. Vui lòng thử lại.");
                    }
                    
                    break;
                }
                case 5:{
                    try{
                        System.out.println("Nhập SBD của thí sinh: ");
                        sc.nextLine();
                        String sbd = sc.nextLine();
                        System.out.println("Nhập mã nguyện vọng: ");
                        int maNv = sc.nextInt();
                        suaNguyenVong(maNv,sbd); 
                    }catch(InputMismatchException ime){
                        System.out.println("Dữ liệu nhập không hợp lệ. Vui lòng thử lại.");
                    }
                    break;   
                }
                case 6:{
                    try{
                        System.out.println("Nhập SBD của thí sinh: ");
                        sc.nextLine();
                        String sbd = sc.nextLine();
                        themNguyenVong(sbd);
                    }catch(InputMismatchException ime){
                        System.out.println("Dữ liệu nhập không hợp lệ. Vui lòng thử lại.");
                    }
                    
                    break;   
                }
                case 7:{
                    try{
                        System.out.println("Nhập SBD của thí sinh: ");
                        sc.nextLine();
                        String sbd = sc.nextLine();
                        System.out.println("Nhập mã nguyện vọng: ");
                        int maNv = sc.nextInt();
                        xoaNguyenVong(maNv,sbd);
                    }catch(InputMismatchException ime){
                        System.out.println("Dữ liệu nhập không hợp lệ. Vui lòng thử lại.");
                    }
                    break;   
                }
                default : 
                    break;
            }
        } while (n !=0);
    }
    
//    public void suaNguyenVong(int maNV, String sbd){
//        boolean flag = true;
//        for(Person x: person){
//            if(((Student)x).getSBD().compareToIgnoreCase(sbd) ==0){
//                for(int i=0; i<((Student)x).getNguyenVong().size(); i++){
//                    if(((Student)x).getNguyenVong().get(i).getMaNv() == maNV-1){
//                        ((Student)x).getNguyenVong().get(i).nhapNguyenVong();
//                        flag = false;
//                    }
//                }
//            }
//        }
//        if(flag){
//            System.out.println("Khong tim thay ma nguyen vong hoac sbd, vui long kiem tra lai!");
//        }else {
//            System.out.println("Xoa thanh cong");
//        }
//    }
    
    public void menuSuaNguyenVong(){
        System.out.println("------------Sua Nguyen Vong-------------");
        System.out.println("1.Sua ma truong");
        System.out.println("2.Sua ma nganh");
        System.out.println("3.Sua ten nganh");
        System.out.println("4.Sua khoi xet tuyen");
        System.out.println("5.Sua diem thi");
        System.out.println("-----------Chon 0 de thoat!-------------");
    }
    
    public void suaNguyenVong(int maNV, String sbd){
        Scanner sc = new Scanner (System.in);
        int n;
        do{
            menuSuaNguyenVong();
            System.out.print("Lua chon: ");
            n = Integer.parseInt(sc.nextLine());
            switch(n){
                case 0:
                    System.out.println("Da thoat!");
                    break;
                case 1:
                    suaMatruong(maNV, sbd);
                    break;
                case 2:
                    suaMaNganh(maNV, sbd);
                    break;
                case 3:
                    suaTenNganh(maNV, sbd);
                    break;
                case 4:
                    suaKhoiXetTuyen(maNV, sbd);
                    break;
                case 5:
                    suaDiemThi(maNV, sbd);
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai!");
                    break;
            }
        } while (n!=0);
        
    }
    
    
    public void suaMatruong(int maNV, String sbd){
        Scanner sc = new Scanner (System.in);
        boolean flag = true;
        System.out.print("Nhap ma truong muon doi: ");
        String maTruong = sc.nextLine();
        for(Person x: person){
            if(((Student)x).getSBD().compareToIgnoreCase(sbd) ==0){
                for(int i=0; i<((Student)x).getNguyenVong().size(); i++){
                    if(((Student)x).getNguyenVong().get(i).getMaNv() == maNV-1){
                        ((Student)x).getNguyenVong().get(i).setMaTruong(maTruong);
                        flag = false;
                    }
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay ma nguyen vong hoac sbd, vui long kiem tra lai!");
        }else {
            System.out.println("Sua thanh cong!");
        }
    }
    public void suaMaNganh(int maNV, String sbd){
        Scanner sc = new Scanner (System.in);
        boolean flag = true;
        System.out.print("Nhap ma nganh muon doi: ");
        String maNganh = sc.nextLine();
        for(Person x: person){
            if(((Student)x).getSBD().compareToIgnoreCase(sbd) ==0){
                for(int i=0; i<((Student)x).getNguyenVong().size(); i++){
                    if(((Student)x).getNguyenVong().get(i).getMaNv() == maNV-1){
                        ((Student)x).getNguyenVong().get(i).setMaNganh(maNganh);
                        flag = false;
                    }
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay ma nguyen vong hoac sbd, vui long kiem tra lai!");
        }else {
            System.out.println("Sua thanh cong!");
        }
    }
    public void suaTenNganh(int maNV, String sbd){
        Scanner sc = new Scanner (System.in);
        boolean flag = true;
        System.out.print("Nhap ten nganh muon doi: ");
        String tenNganh = sc.nextLine();
        for(Person x: person){
            if(((Student)x).getSBD().compareToIgnoreCase(sbd) ==0){
                for(int i=0; i<((Student)x).getNguyenVong().size(); i++){
                    if(((Student)x).getNguyenVong().get(i).getMaNv() == maNV-1){
                        ((Student)x).getNguyenVong().get(i).setTenNganh(tenNganh);
                        flag = false;
                    }
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay ma nguyen vong hoac sbd, vui long kiem tra lai!");
        }else {
            System.out.println("Sua thanh cong!");
        }
    }
    public void suaKhoiXetTuyen(int maNV, String sbd){
        Scanner sc = new Scanner (System.in);
        boolean flag = true;
        System.out.print("Nhap khoi xet tuyen muon doi: ");
        String khoiXT = sc.nextLine();
        for(Person x: person){
            if(((Student)x).getSBD().compareToIgnoreCase(sbd) ==0){
                for(int i=0; i<((Student)x).getNguyenVong().size(); i++){
                    if(((Student)x).getNguyenVong().get(i).getMaNv() == maNV-1){
                        ((Student)x).getNguyenVong().get(i).setKhoiXt(khoiXT);
                        flag = false;
                    }
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay ma nguyen vong hoac sbd, vui long kiem tra lai!");
        }else {
            System.out.println("Sua thanh cong!");
        }
    }
    public void suaDiemThi(int maNV, String sbd){
        Scanner sc = new Scanner (System.in);
        boolean flag = true;
        System.out.print("Nhap diem thi muon doi: ");
        float diemThi = Float.parseFloat(sc.nextLine());
        for(Person x: person){
            if(((Student)x).getSBD().compareToIgnoreCase(sbd) ==0){
                for(int i=0; i<((Student)x).getNguyenVong().size(); i++){
                    if(((Student)x).getNguyenVong().get(i).getMaNv() == maNV-1){
                        ((Student)x).getNguyenVong().get(i).setDiemThi(diemThi);
                        flag = false;
                    }
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay ma nguyen vong hoac sbd, vui long kiem tra lai!");
        }else {
            System.out.println("Sua thanh cong!");
        }
    }
    
    public void xoaNguyenVong(int maNV, String sbd){
        boolean flag = true;
        for(Person x: person){
            if(((Student)x).getSBD().compareToIgnoreCase(sbd) ==0){
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
    
    //can sua
    public void themNguyenVong(String sbd){
        boolean flag = true;
        for(Person x: person){
            if(x instanceof Student){
                if(((Student) x).getSBD().compareToIgnoreCase(sbd)==0){
                   ((Student)x).nhapDsNguyenVong();
                    flag = false; 
                }               
            }
        }
        if(flag){
            System.out.println("Khong tim thay Sbd, vui long kiem tra lai!");
        } else{
            System.out.println("Them nguyen vong thanh cong!");
        }
    }
    
    public void menuSuaThiSinh(){
        System.out.println("----------Sua thong tin thi sinh---------");
        System.out.println("1.Sua ten");
        System.out.println("2.Sua que quan");
        System.out.println("3.Sua nam sinh");
        System.out.println("4.Sua gioi tinh");
        System.out.println("5.Sua sbd");
        System.out.println("6.Sua diem uu tien");
        System.out.println("-----------Chon 0 de thoat!--------------");
    }
    public void suaTS(String sbd){
        Scanner sc = new Scanner (System.in);
        int n;
        do{
            menuSuaThiSinh();
            System.out.print("Lua chon: ");
            n = Integer.parseInt(sc.nextLine());
            switch(n){
                case 0:
                    System.out.println("Da thoat!");
                    break;
                case 1: 
                    suaTenThiSinh(sbd);
                    break;
                case 2:
                    suaQQThiSinh(sbd);
                    break;
                case 3:
                    suaNamSinhThiSinh(sbd);
                    break;
                case 4: 
                    suaGioiTinhThiSinh(sbd);
                    break;
                case 5:
                    suaSbdThiSinh(sbd);
                    break;
                case 6:
                    suaDiemUuTienThiSinh(sbd);
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
                    break;
            }
        }while(n!=0);
    }
    public void suaTenThiSinh(String sbd){
        boolean flag = true;
        Scanner sc = new Scanner (System.in);
        System.out.print("Nhap ten muon doi: ");
        String name = sc.nextLine();
        for(Person x: person){
            if(x instanceof Student){
                if(((Student)x).getSBD().compareToIgnoreCase(sbd)==0){
                   x.setHoTen(name);
                   flag = false;
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay Sbd, vui long kiem tra lai!");
        } else{
            System.out.println("Sua ten thi sinh thanh cong!");
        }
    }
    
    public void suaQQThiSinh(String sbd){
        boolean flag = true;
        Scanner sc = new Scanner (System.in);
        System.out.print("Nhap que quan muon doi: ");
        String name = sc.nextLine();
        for(Person x: person){
            if(x instanceof Student){
                if(((Student)x).getSBD().compareToIgnoreCase(sbd)==0){
                   x.setQueQuan(name);
                   flag = false;
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay Sbd, vui long kiem tra lai!");
        } else{
            System.out.println("Sua que quan thi sinh thanh cong!");
        }
    }
   
    public void suaNamSinhThiSinh(String sbd){
        boolean flag = true;
        Scanner sc = new Scanner (System.in);
        System.out.print("Nhap nam sinh muon doi: ");
        int birth = Integer.parseInt(sc.nextLine());
        for(Person x: person){
            if(x instanceof Student){
                if(((Student)x).getSBD().compareToIgnoreCase(sbd)==0){
                   x.setNamSinh(birth);
                   flag = false;
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay Sbd, vui long kiem tra lai!");
        } else{
            System.out.println("Sua nam sinh thi sinh thanh cong!");
        }
    }
    
    public void suaSbdThiSinh(String sbd){
        boolean flag = true;
        Scanner sc = new Scanner (System.in);
        System.out.print("Nhap sbd muon doi: ");
        String Sbd = sc.nextLine();
        for(Person x: person){
            if(x instanceof Student){
                if(((Student)x).getSBD().compareToIgnoreCase(sbd)==0){
                   ((Student) x).setSBD(Sbd);
                   flag = false;
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay Sbd, vui long kiem tra lai!");
        } else{
            System.out.println("Sua sbd thi sinh thanh cong!");
        }
    }
    
    public void suaDiemUuTienThiSinh(String sbd){
        boolean flag = true;
        Scanner sc = new Scanner (System.in);
        System.out.print("Nhap sbd muon doi: ");
        float diemUT = Float.parseFloat(sc.nextLine());
        for(Person x: person){
            if(x instanceof Student){
                if(((Student)x).getSBD().compareToIgnoreCase(sbd)==0){
                   ((Student) x).setDiemUuTien(diemUT);
                   flag = false;
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay Sbd, vui long kiem tra lai!");
        } else{
            System.out.println("Sua diem uu tien thi sinh thanh cong!");
        }
    }
    
    public void suaGioiTinhThiSinh(String sbd){
        boolean flag = true;
        Scanner sc = new Scanner (System.in);
        int gioiTinh;
        do{
            System.out.println("Giới tính(nam: 1/nữ: 0)");
            gioiTinh = sc.nextInt();
        } while(gioiTinh !=1 && gioiTinh!=0);
        for(Person x: person){
            if(x instanceof Student){
                if(((Student)x).getSBD().compareToIgnoreCase(sbd)==0){
                   x.setGioiTinh(gioiTinh);
                   flag = false;
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay Sbd, vui long kiem tra lai!");
        } else{
            System.out.println("Sua gioi tinh thi sinh thanh cong!");
        }
    }
    
    public void xoaThiSinh(String sbd){
        List<Person> toRemove = new ArrayList<>();
        boolean flag= true;
        for(Person x: person){
            if(x instanceof Student){
                if(((Student)x).getSBD().compareToIgnoreCase(sbd)==0){
                   toRemove.add(x);
                   flag = false;
                }
            }
        }
        person.removeAll(toRemove);
        if(flag){
            System.out.println("Khong tim thay Sbd, vui long kiem tra lai!");
        } else{
            System.out.println("Xoa thi sinh thanh cong!");
        }
    }
    
    public void menuSuaGT(){
        System.out.println("------------Sua thong tin giam thi-----------");
        System.out.println("1.Sua ho ten giam thi");
        System.out.println("2.Sua que quan giam thi");
        System.out.println("3.Sua nam sinh giam thi");
        System.out.println("4.Sua gioi tinh giam thi");
        System.out.println("5.Sua ma giam thi");
        System.out.println("6.Sua don vi cong tac");
        System.out.println("--------------Chon 0 de thoat!----------------");
    }
    
    public void suaGt(String maGt){
        Scanner sc = new Scanner (System.in);
        int n;
        do{
            menuSuaGT();
            System.out.print("Lua Chon: ");
            n = Integer.parseInt(sc.nextLine());
            
            switch(n){
                case 0:
                    System.out.println("Da thoat!");
                    break;
                case 1:
                    suaTenGiamThi(maGt);
                    break;
                case 2:
                    suaQQGiamThi(maGt);
                    break;
                case 3:
                    suaNamSinhGiamThi(maGt);
                    break;
                case 4:
                    suaGioiTinhGiamThi(maGt);
                    break;
                case 5:
                    suaMaGT(maGt);
                    break;
                case 6:
                    suaDonViCongTac(maGt);
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai!");
                    break;
            }
        } while (n!=0);
    }
    public void suaTenGiamThi(String maGt){
        boolean flag = true;
        Scanner sc = new Scanner (System.in);
        System.out.print("Nhap ten muon doi: ");
        String name = sc.nextLine();
        for(Person x: person){
            if(x instanceof Supervisor){
                if(((Supervisor)x).getMaGt().compareToIgnoreCase(maGt)==0){
                   x.setHoTen(name);
                   flag = false;
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay Sbd, vui long kiem tra lai!");
        } else{
            System.out.println("Sua ten giam thi thanh cong!");
        }
    }
    public void suaQQGiamThi(String maGt){
        boolean flag = true;
        Scanner sc = new Scanner (System.in);
        System.out.print("Nhap que quan muon doi: ");
        String name = sc.nextLine();
        for(Person x: person){
            if(x instanceof Supervisor){
                if(((Supervisor)x).getMaGt().compareToIgnoreCase(maGt)==0){
                   x.setQueQuan(name);
                   flag = false;
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay Sbd, vui long kiem tra lai!");
        } else{
            System.out.println("Sua que quan giam thi thanh cong!");
        }
    }
    public void suaNamSinhGiamThi(String maGt){
        boolean flag = true;
        Scanner sc = new Scanner (System.in);
        System.out.print("Nhap nam sinh muon doi: ");
        int birth = Integer.parseInt(sc.nextLine());
        for(Person x: person){
            if(x instanceof Supervisor){
                if(((Supervisor)x).getMaGt().compareToIgnoreCase(maGt)==0){
                   x.setNamSinh(birth);
                   flag = false;
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay Sbd, vui long kiem tra lai!");
        } else{
            System.out.println("Sua nam sinh giam thi thanh cong!");
        }
    }
    public void suaGioiTinhGiamThi(String maGt){
        boolean flag = true;
        Scanner sc = new Scanner (System.in);
        int gioiTinh;
        do{
            System.out.println("Nhap gioi tinh muon sua(nam: 1/nữ: 0)");
            gioiTinh = sc.nextInt();
        } while(gioiTinh !=1 && gioiTinh!=0);
        for(Person x: person){
            if(x instanceof Supervisor){
                if(((Supervisor)x).getMaGt().compareToIgnoreCase(maGt)==0){
                   x.setGioiTinh(gioiTinh);
                   flag = false;
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay Sbd, vui long kiem tra lai!");
        } else{
            System.out.println("Sua gioi tinh giam thi thanh cong!");
        }
    }
    public void suaMaGT(String maGt){
        boolean flag = true;
        Scanner sc = new Scanner (System.in);
        System.out.print("Nhap ma giam thi muon doi: ");
        String Sbd = sc.nextLine();
        for(Person x: person){
            if(x instanceof Supervisor){
                if(((Supervisor)x).getMaGt().compareToIgnoreCase(maGt)==0){
                   ((Supervisor) x).setMaGt(Sbd);
                   flag = false;
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay Sbd, vui long kiem tra lai!");
        } else{
            System.out.println("Sua ma giam thi thanh cong!");
        }
    }
    public void suaDonViCongTac(String maGt){
        boolean flag = true;
        Scanner sc = new Scanner (System.in);
        System.out.print("Nhap don vi cong tac muon doi: ");
        String donViCt = sc.nextLine();
        for(Person x: person){
            if(x instanceof Supervisor){
                if(((Supervisor)x).getMaGt().compareToIgnoreCase(maGt)==0){
                   ((Supervisor) x).setDonViCT(donViCt);
                   flag = false;
                }
            }
        }
        if(flag){
            System.out.println("Khong tim thay Sbd, vui long kiem tra lai!");
        } else{
            System.out.println("Sua ma giam thi thanh cong!");
        }
    }
    
    public void xoaGiamThi(String maGT){
        List<Person> toRemove = new ArrayList<>();
        boolean flag= true;
        for(Person x: person){
            if(x instanceof Supervisor){
                if(((Supervisor)x).getMaGt().compareToIgnoreCase(maGT)==0){
                   toRemove.add(x);
                   flag = false;
                }
            }
        }
        person.removeAll(toRemove);
        if(flag){
            System.out.println("Khong tim thay ma giam thi, vui long kiem tra lai!");
        } else{
            System.out.println("Xoa giam thi thanh cong!");
        }
    }
    
    public void hienDSGiamThi(){
        System.out.println("--------------------------");
        int index=1;
        for(Person x : person){
            if(x instanceof Supervisor){
                System.out.print(index++ + ". ");
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
        int index =1;
        for(Person x : person){
            if(x instanceof Student){
                System.out.print(index++ +". ");
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
        int index =1;
        for(Person x : person){
            if(x instanceof Student){
                for(int i=0; i<((Student)x).getNguyenVong().size(); i++){
                    float tongDiem = ((Student)x).getNguyenVong().get(i).getDiemThi() +((Student) x).getDiemUuTien();
                    if(((Student)x).getNguyenVong().get(i).getMaNganh().compareTo(maNganh) == 0 && tongDiem >= diemChuan){
                        System.out.print(index++ + ". ");
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
        int index =1;
        for(Wish x : nvTrungTuyen){
            System.out.print(index++ +". ");
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
        Scanner sc = new Scanner (System.in);
        Collections.sort(nvTrungTuyen, new Comparator<Wish>(){
            @Override
            public int compare(Wish o1, Wish o2) {
               if(o1.getDiemThi() > o2.getDiemThi()){
                   return -1;
               } else if(o1.getDiemThi() < o2.getDiemThi()){
                   return 1;
               } else{
                   return 0;
               }
            }  
        });
        hienDSTTNganh();
    }
    
    public void hienGiamThioHaNoi(){
        int index =1;
        for(Person x : person){
            if(x instanceof Supervisor && ((Supervisor)x).getQueQuan().equalsIgnoreCase("Ha Noi")== true){
                System.out.print(index++ + ". ");
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
        System.out.println("| 6. Lưu file đã nhập                                                    |");
        System.out.println("| 7. Đọc dữ lệu từ file (thisinh.txt or giamthi.txt)                     |");
        System.out.println("| 8. Hiện ra danh sách trúng tuyền( input: mã ngành, điểm chuẩn)         |");
        System.out.println("| 9. Sắp xếp danh sách trúng tuyển theo điểm thi giảm dần                |");
        System.out.println("| 10. Thông kê các giám thị công tác ở Hà Nội                            |");
        System.out.println("-------------.Nhắn phím 0 để thoát chương trình, xin cảm ơn!-------------");
    }
}
