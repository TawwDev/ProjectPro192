
package QuanLyTuyenSinhDaiHoc;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Manage implements IManagement{
    private ArrayList<Person> person;
    private ArrayList<TrungTuyen> trungTuyen;
    public Manage(){
        person = new ArrayList();
    }
    
    //Them danh sach sinh vien, giam thi
    public void themDsNguoi(Person a) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong can them: ");   
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            System.out.println("Lan nhap thu " + (i+1) + ":");
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
    
    //Sua thong tin thi sinh, giam thi.
    public void menuSuaDoi() {
        System.out.println("-----------Moi ban lua chon-------------");
        System.out.println("|      1.Sua thong tin thi sinh        |");
        System.out.println("|      2.Xoa thi sinh                  |");
        System.out.println("|      3.Sua thong tin giam thi        |");
        System.out.println("|      4.Xoa giam thi                  |");
        System.out.println("----------Chon so 0 de thoat!-----------");
    }
    
    public void SuaDoi(){
        Scanner sc = new Scanner (System.in);
        int n;
        do{
            menuSuaDoi();
            System.out.print("Chon: ");
            n = sc.nextInt();
            
            switch(n){
                case 1:{
                    try {
                        String sbd;
                        System.out.println("Nhap SBD cua thi sinh can sua: ");
                        sc.nextLine();
                        sbd = sc.nextLine();
                        if(checkSBD(sbd)){
                            System.out.println("Khong tim thay sbd trong danh sach!");
                            break;
                        }
                        suaTS(sbd);
                    } catch(InputMismatchException ime){
                        System.out.println("Du lieu nhap khong hop le. Vui long thu lai!");
                    }
                    break;
                }
                case 2:{
                    try{
                        String sbd;
                        System.out.println("Nhap SBD cua thi sinh can xoa: ");
                        sc.nextLine();
                        sbd = sc.nextLine();
                        xoaThiSinh(sbd);
                    } catch(InputMismatchException ime){
                        System.out.println("Du lieu nhap khong hop le. Vui long thu lai!");
                    } catch(ConcurrentModificationException cme){
                        System.out.println("Du lieu nhap khong hop le. Vui long thu lai!");
                    }
                    
                    break;
                }
                case 3:{
                    try{
                        String maGT;
                        System.out.println("Nhap ma giam thi can sua thong tin: ");
                        sc.nextLine();
                        maGT = sc.nextLine();
                        if(checkMaGT(maGT)){
                            System.out.println("Khong tim thay ma giam thi trong danh sach!");
                            break;
                        }
                        suaGt(maGT);
                    } catch(InputMismatchException ime){
                        System.out.println("Du lieu nhap khong hop le. Vui long thu lai!");
                    }
                    break;
                }
                case 4:{
                    try{
                        String maGT;
                        System.out.println("Nhap ma giam thi can xoa thong tin: ");
                        sc.nextLine();
                        maGT = sc.nextLine();
                        xoaGiamThi(maGT);
                    }catch(InputMismatchException ime){
                        System.out.println("Du lieu nhap khong hop le. Vui long thu lai!");
                    }
                    break;
                }
                default : 
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
                    break;
            }
        } while (n !=0);
    }
    
    //Sua nguyen vong
    public void menuSuaNguyenVong(){
        System.out.println("------------Sua Nguyen Vong---------------");
        System.out.println("|      1.Them nguyen vong                |");
        System.out.println("|      2.Xoa nguyen vong                 |");
        System.out.println("|      3.Swap 2 nguyen vong              |");
        System.out.println("|      4.Chen nguyen vong                |");
        System.out.println("-----------Chon 0 de thoat!---------------");
    }
    
    public void suaNguyenVong(){
        Scanner sc = new Scanner (System.in);
        int n;
        do{
            menuSuaNguyenVong();
            System.out.print("Lua chon: ");
            n = Integer.parseInt(sc.nextLine());
            switch(n){
                case 1:{
                    try{
                        System.out.println("Nhap SBD cua thi sinh: ");
                        String sbd1 = sc.nextLine();
                        if(checkSBD(sbd1)){
                            System.out.println("So bao danh khong ton tai!");
                            break;
                        }
                        themNguyenVong(sbd1);
                    }catch(InputMismatchException ime){
                        System.out.println("Du lieu nhap khong hop le. Vui long thu lai!");
                    }
                    
                    break;   
                }
                case 2:{
                    try{
                        System.out.println("Nhap SBD cua thi sinh: ");
                        String sbd2 = sc.nextLine();
                        if(checkSBD(sbd2)){
                            System.out.println("So bao danh khong ton tai!");
                            break;
                        }
                        System.out.println("Nhap ma nguyen vong: ");
                        int maNv = sc.nextInt();
                        xoaNguyenVong(maNv,sbd2);
                    }catch(InputMismatchException ime){
                        System.out.println("Du lieu nhap khong hop le. Vui long thu lai!");
                    }
                    break;   
                }
                case 3:
                    System.out.println("Nhap sbd thi sinh muon doi vi tri nguyen vong:");
                    String sbd3 = sc.nextLine(); 
                    if(checkSBD(sbd3)){
                        System.out.println("So bao danh khong ton tai!");
                        break;
                    }
                    try{
                        System.out.print("Nhap ma nguyen vong muon swap: ");
                        int index1 = Integer.parseInt(sc.nextLine());
                        System.out.print("Nhap ma nguyen vong muon swap: ");
                        int index2 = Integer.parseInt(sc.nextLine()); 
                        swapNV(sbd3, index1, index2);
                    } catch (NumberFormatException e) {
                        System.out.println("Chi so phai la so nguyen.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Loi khac: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Nhap sbd thi sinh muon doi vi tri nguyen vong:");
                    String sbd4 = sc.nextLine(); 
                    if(checkSBD(sbd4)){
                        System.out.println("So bao danh khong ton tai!");
                        break;
                    }
                    try{
                        System.out.print("Nhap ma nguyen vong muon doi vi tri: ");
                        int index1 = Integer.parseInt(sc.nextLine());
                        System.out.print("Nhap ma nguyen vong muon chen: ");
                        int index2 = Integer.parseInt(sc.nextLine()); 
                        viTriNV(sbd4, index1, index2);
                    } catch (NumberFormatException e) {
                        System.out.println("Chi so phai la so nguyen.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Loi khac: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai!");
                    break;
            }
        } while (n!=0);
        
    }
    
    public static <T> void swapElements(ArrayList<T> list, int index1, int index2) {
        if (index1 < 0 || index1 >= list.size() || index2 < 0 || index2 >= list.size()) {
            throw new IndexOutOfBoundsException("Chi so khong hop le.");
        }
        Collections.swap(list, index1, index2);
    }
    
    public void swapNV(String sbd, int index1, int index2){
        boolean check = false;
        if(index1 == index2){
            System.out.println("Vi tri doi giu nguyen do 2 chi so bang nhau!");
            return;
        }
        for (Person x : person) {
            if (x instanceof Student && ((Student) x).getSBD().equalsIgnoreCase(sbd)) {
                ArrayList<Wish> nguyenVongList = ((Student) x).getNguyenVong();
                swapElements(nguyenVongList, index1-1, index2-1);
                check = true;
            }
        }
        
        if(check){
            System.out.println("Da doi vi tri thanh cong!");
        }
    }
    
    public void viTriNV(String sbd, int index1, int index2){
        boolean check = false;
        if(index1 == index2){
            System.out.println("Vi tri doi giu nguyen do 2 chi so bang nhau!");
            return;
        }
        for (Person x : person) {
            if (x instanceof Student && ((Student) x).getSBD().equalsIgnoreCase(sbd)) {
                ArrayList<Wish> nguyenVongList = ((Student) x).getNguyenVong();
                
                if(index1 < 1 || index1 > nguyenVongList.size() || index2 < 1 || index2 > nguyenVongList.size()) {
                    System.out.println("Index khong hop le!");
                    return;
                }
                
                Wish nguyenVong = nguyenVongList.get(index1-1);
                nguyenVongList.remove(index1-1);
                nguyenVongList.add(index2-1, nguyenVong);
                check = true;
            }
        } 
        if(check){
            System.out.println("Da doi vi tri thanh cong!");
        }
    }
    
    public void xoaNguyenVong(int maNV, String sbd) {
        if (maNV < 1) {
            System.out.println("Ma nguyen vong khong hop le!");
            return;
        }
        maNV -= 1;

        boolean deleted = false;

        for (Person x : person) {
            if (x instanceof Student && ((Student) x).getSBD().equalsIgnoreCase(sbd)) {
                ArrayList<Wish> nguyenVongList = ((Student) x).getNguyenVong();

                if (maNV < nguyenVongList.size() && maNV >= 0) {
                    Wish wishToRemove = nguyenVongList.get(maNV);
                    nguyenVongList.remove(wishToRemove);
                    deleted = true;
                    System.out.println("Xoa thanh cong nguyen vong co ma: " + (maNV + 1));
                    break;
                } else {
                    System.out.println("Ma nguyen vong khong hop le!");
                    return;
                }
            }
        }
        if (!deleted) {
            System.out.println("Xoa khong thanh cong, nguyen vong khong ton tai!");
        }
    }

    public void themNguyenVong(String sbd){
        boolean flag = true;
        for(Person x: person){
            if(x instanceof Student){
                if(((Student) x).getSBD().compareToIgnoreCase(sbd)==0){
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Nhap so nguyen vong van them: ");
                    int n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        Wish nguyenVongA = new Wish();
                        nguyenVongA.nhapNguyenVong();
                        ((Student) x).getNguyenVong().add(nguyenVongA);
                    }
                    flag = false; 
                }               
            }
        }
        if(!flag){
            System.out.println("Them nguyen vong thanh cong!");
        }
    }
    
    //Sua thi sinh
    public void menuSuaThiSinh(){
        System.out.println("----------Sua thong tin thi sinh---------");
        System.out.println("|           1.Sua ten                   |");
        System.out.println("|           2.Sua que quan              |");
        System.out.println("|           3.Sua nam sinh              |");
        System.out.println("|           4.Sua gioi tinh             |");
        System.out.println("|           5.Sua diem uu tien          |");
        System.out.println("|           6.Sua sbd                   |");
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
                    suaDiemUuTienThiSinh(sbd);
                    break;
                case 6:
                    suaSbdThiSinh(sbd);
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
                    break;
            }
        }while(n!=0);
    }
    
    public boolean checkSBD (String sbd){
        for(Person x: person){
            if(x instanceof Student){
                if(((Student)x).getSBD().compareToIgnoreCase(sbd)==0){
                   return false;
                }
            }
        }
        return true;
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
            System.out.println("Gioi tinh(nam: 1/nu: 0)");
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
    
    
    //Sua giam thi
    public void menuSuaGT(){
        System.out.println("------------Sua thong tin giam thi-----------");
        System.out.println("|        1.Sua ho ten giam thi               |"); 
        System.out.println("|        2.Sua que quan giam thi             |");
        System.out.println("|        3.Sua nam sinh giam thi             |");
        System.out.println("|        4.Sua gioi tinh giam thi            |");
        System.out.println("|        5.Sua don vi cong tac               |");
        System.out.println("|        6.Sua ma giam thi                   |");
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
                    suaDonViCongTac(maGt);
                    break;
                case 6:
                    suaMaGT(maGt);
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai!");
                    break;
            }
        } while (n!=0);
    }
    
    public boolean checkMaGT(String maGT){
        for(Person x: person){
            if(x instanceof Supervisor){
                if(((Supervisor)x).getMaGt().compareToIgnoreCase(maGT)==0){
                   return false;
                }
            }
        }
        return true;
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
            System.out.println("Nhap gioi tinh muon sua(nam: 1/nu: 0)");
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
    
    //Hien thong tin
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
    
    
    //Quan li file
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
            System.out.println("Ghi file thisinh.txt thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
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
            System.out.println("Ghi file giamthi.txt thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
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
            System.out.println("Doc file thanh cong!");
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }
    
    //Hien danh sach trung tuyen
    public void hienDSTrungTuyen(String maNganh, float diemChuan){
        trungTuyen = new ArrayList<>();
        boolean check = true;
        int index =1;
        for(Person x : person){
            if(x instanceof Student){
                for(int i=0; i<((Student)x).getNguyenVong().size(); i++){
                    float tongDiem = ((Student)x).getNguyenVong().get(i).getDiemThi() +((Student) x).getDiemUuTien();
                    if(((Student)x).getNguyenVong().get(i).getMaNganh().compareTo(maNganh) == 0 && tongDiem >= diemChuan){
                        System.out.print(index++ + ". ");
                        ((Student)x).hienThongTinTs();
                        ((Student)x).getNguyenVong().get(i).hienNguyenVong();
                        trungTuyen.add(new TrungTuyen((Student)x, ((Student)x).getNguyenVong().get(i)));
                        check = false;
                    }
                }
            }
        }
        if(check){
            System.out.println("Khong co thi sinh nao trung tuyen ma nganh: " + maNganh);
        }
    }
    
    //Sap xep theo diem
    public void hienDSTTNganh(){
        int index =1;
        for(TrungTuyen x : trungTuyen){
            System.out.println(index++ + ". ");
            x.getStudent().hienThongTinTs();
            x.getNguyenVong().hienNguyenVong();
        }
    }
    
    public void SapXepTheoDiem(){
        Scanner sc = new Scanner (System.in);
        Collections.sort(trungTuyen, new Comparator<TrungTuyen>(){
            @Override
            public int compare(TrungTuyen o1, TrungTuyen o2) {
               if(o1.getNguyenVong().getDiemThi()> o2.getNguyenVong().getDiemThi()){
                   return -1;
               } else if(o1.getNguyenVong().getDiemThi() < o2.getNguyenVong().getDiemThi()){
                   return 1;
               } else{
                   return 0;
               }
            }  
        });
        hienDSTTNganh();
    }
    
    //Hien thi noi cong tac cua giam thi
    public void hienGiamThiCongTac(String donViCt){
        int index =1;
        for(Person x : person){
            if(x instanceof Supervisor && ((Supervisor)x).getQueQuan().equalsIgnoreCase(donViCt)== true){
                System.out.print(index++ + ". ");
                x.hien();
            }
        }
    }
    
    
    public void menuChinh(){
        System.out.println("-------------CHUONG TRINH QUAN LI TUYEN SINH DAI HOC 2024----------------");
        System.out.println("|      1. Nhap danh sach thi sinh va nguyen vong cua thi sinh            |");
        System.out.println("|      2. Nhap danh sach giam thi coi thi                                |");
        System.out.println("|      3. Hien thi danh sach cac ho so du thi                            |");
        System.out.println("|      4. Hien thi danh sach cac giam thi                                |");
        System.out.println("|      5. Chinh sua thong tin (Thi Sinh, Giam Thi)                       |");
        System.out.println("|      6. Chinh sua Nguyen Vong (Them, Xoa, Doi vi tri)                  |");
        System.out.println("|      7. Luu file da nhap                                               |");
        System.out.println("|      8. Doc du lieu tu file (thisinh.txt or giamthi.txt)               |");
        System.out.println("|      9. Hien ra danh sach trung tuyen (input: ma nganh, diem chuan)    |");
        System.out.println("|      10. Sap xep danh sach trung tuyen theo diem thi giam dan          |");
        System.out.println("|      11. Thong ke cac giam thi cong tac                                |");
        System.out.println("--------------Nhan phim 0 de thoat chuong trinh, xin cam on!-------------");
    }
}
