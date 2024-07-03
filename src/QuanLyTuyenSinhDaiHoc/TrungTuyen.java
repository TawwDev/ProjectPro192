
package QuanLyTuyenSinhDaiHoc;

public class TrungTuyen {
    private Student student;
    private Wish nguyenVong;

    public TrungTuyen(Student student, Wish nguyenVong) {
        this.student = student;
        this.nguyenVong = nguyenVong;
    }

    public Student getStudent() {
        return student;
    }

    public Wish getNguyenVong() {
        return nguyenVong;
    }
    
}
