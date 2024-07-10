package QuanLyTuyenSinhDaiHoc;


import QuanLyTuyenSinhDaiHoc.Person;


public interface IManagement {
    public void themDsNguoi(Person a);
    
    public void SuaDoi();
    
    public void suaNguyenVong();
    
    public void swapNV(String sbd, int index1, int index2);
    
    public void xoaNguyenVong(int maNV, String sbd);
    
    public void themNguyenVong(String sbd);
    
    public void suaTS(String sbd);
    
    public boolean checkSBD(String sbd);
    
    public void suaTenThiSinh(String sbd);
    
    public void suaQQThiSinh(String sbd);
    
    public void suaNamSinhThiSinh(String sbd);
    
    public void suaSbdThiSinh(String sbd);
    
    public void suaDiemUuTienThiSinh(String sbd);
    
    public void suaGioiTinhThiSinh(String sbd);
    
    public void xoaThiSinh(String sbd);
    
    public void suaGt(String maGt);
    
    public boolean checkMaGT(String maGT);
    
    public void suaTenGiamThi(String maGt);
    
    public void suaQQGiamThi(String maGt);
    
    public void suaNamSinhGiamThi(String maGt);
    
    public void suaGioiTinhGiamThi(String maGt);
    
    public void suaDonViCongTac(String maGt);
    
    public void suaMaGT(String maGt);

    public void xoaGiamThi(String maGT);

    public void hienDSGiamThi();

    public void hienDS();

    public void hienDSHoSoThiSinh();

    public void hienDSThiSinh();

    public void menuFile();

    public void ghiFile();

    public void ghiFileStudent();

    public void ghiFileSupervisor();

    public void docFile(String fileName);

    public void hienDSTrungTuyen(String maNganh, float diemChuan);

    public void hienDSTTNganh();

    public void SapXepTheoDiem();

    public void hienGiamThiCongTac(String donViCt);

    public void menuChinh();
}
