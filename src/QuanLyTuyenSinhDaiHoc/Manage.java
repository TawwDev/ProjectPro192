
package QuanLyTuyenSinhDaiHoc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
            person.add(a);
        }
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
        for(Person x: person){
            if(((Student)x).getSBD().compareTo(sbd) ==0){
                for(int i=0; i<((Student)x).getNguyenVong().size(); i++){
                    if(((Student)x).getNguyenVong().get(i).getMaNv() == maNV){
                        ((Student)x).getNguyenVong().get(i).nhapNguyenVong();
                    }
                }
            }
        }
    }
    
    public void xoaNguyenVong(int maNV, String sbd){
        for(Person x: person){
            if(((Student)x).getSBD().compareTo(sbd) ==0){
                for(int i=0; i<((Student)x).getNguyenVong().size(); i++){
                    if(((Student)x).getNguyenVong().get(i).getMaNv() == maNV){
                        ((Student)x).getNguyenVong().remove(i);
                    }
                }
            }
        }
    }
    
    public void themNguyenVong(String sbd){
        for(Person x: person){
            if(x instanceof Student){
                ((Student)x).nhapDsNguyenVong();
            }
        }
    }
    
    public void suaThiSinh(String sbd){
        for(Person x: person){
            if(x instanceof Student){
                if(((Student)x).getSBD().compareTo(sbd)==0){
                   x.nhap();
                }
            }
        }
    }
    
    public void xoaThiSinh(String sbd){
        for(Person x: person){
            if(x instanceof Student){
                if(((Student)x).getSBD().compareTo(sbd)==0){
                   person.remove(x);
                }
            }
        }
    }
    
    public void suaGiamThi(String maGT){
        for(Person x: person){
            if(x instanceof Supervisor){
                if(((Supervisor)x).getMaGt().compareTo(maGT)==0){
                   x.nhap();
                }
            }
        }
    }
    
    public void xoaGiamThi(String maGT){
        for(Person x: person){
            if(x instanceof Supervisor){
                if(((Supervisor)x).getMaGt().compareTo(maGT)==0){
                   person.remove(x);
                }
            }
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
    
    
    public void ghiFile(String fileName){
        try{
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.flush();
            objOut.writeObject(person);
            objOut.close();
            fileOut.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void docFile(String fileName){
        try{
            person = new ArrayList<>();
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream fout = new ObjectInputStream(fin);
            person = (ArrayList) fout.readObject();
            hienDS();
            fin.close();
            fout.close();
        } catch(FileNotFoundException e){
            System.out.println("\nKhong thay file\n");
        } catch(Exception ex){
            ex.printStackTrace();
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
