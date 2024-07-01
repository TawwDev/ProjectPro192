
package QuanLyTuyenSinhDaiHoc;

public class ModuleException {
    public static class InvalidGenderException extends Exception {
        public InvalidGenderException(String message) {
            super(message);
        }
    }
}
