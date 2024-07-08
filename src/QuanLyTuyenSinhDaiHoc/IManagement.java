package QuanLyTuyenSinhDaiHoc;


import QuanLyTuyenSinhDaiHoc.Person;


public interface IManagement {
    void themDsNguoi(Person a);
    
    void SuaDoi();
    
    void suaNguyenVong();
    
    void swapNV(String sbd, int index1, int index2);
    
    void xoaNguyenVong(int maNV, String sbd);
    
    void themNguyenVong(String sbd);
    
    void suaTS(String sbd);
    
    boolean checkSBD(String sbd);
    
    void suaTenThiSinh(String sbd);
    
    void suaQQThiSinh(String sbd);
    
    void suaNamSinhThiSinh(String sbd);
    
    void suaSbdThiSinh(String sbd);
    
    void suaDiemUuTienThiSinh(String sbd);
    
    void suaGioiTinhThiSinh(String sbd);
    
    void xoaThiSinh(String sbd);
    
    void suaGt(String maGt);
    
    boolean checkMaGT(String maGT);
    
    void suaTenGiamThi(String maGt);
    
    void suaQQGiamThi(String maGt);
    
    void suaNamSinhGiamThi(String maGt);
    
    void suaGioiTinhGiamThi(String maGt);
    
    void suaDonViCongTac(String maGt);
    
    void suaMaGT(String maGt);

    void xoaGiamThi(String maGT);

    void hienDSGiamThi();

    void hienDS();

    void hienDSHoSoThiSinh();

    void hienDSThiSinh();

    void menuFile();

    void ghiFile();

    void ghiFileStudent();

    void ghiFileSupervisor();

    void docFile(String fileName);

    void hienDSTrungTuyen(String maNganh, float diemChuan);

    void hienDSTTNganh();

    void SapXepTheoDiem();

    void hienGiamThiCongTac(String donViCt);

    void menuChinh();
}
