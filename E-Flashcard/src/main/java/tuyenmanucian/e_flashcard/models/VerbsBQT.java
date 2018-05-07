package tuyenmanucian.e_flashcard.models;

/**
 * Created by Admin on 3/25/2018.
 */

public class VerbsBQT {
    private String STT;
    private String TuNguyenMau;
    private String QuaKhuDon;
    private String QuaKhuPhanTu;
    private String NghiaCuaTu;

    public VerbsBQT() {
    }

    public VerbsBQT(String STT, String tuNguyenMau, String quaKhuDon, String quaKhuPhanTu, String nghiaCuaTu) {
        this.STT = STT;
        TuNguyenMau = tuNguyenMau;
        QuaKhuDon = quaKhuDon;
        QuaKhuPhanTu = quaKhuPhanTu;
        NghiaCuaTu = nghiaCuaTu;
    }

    public String getSTT() {
        return STT;
    }

    public void setSTT(String STT) {
        this.STT = STT;
    }

    public String getTuNguyenMau() {
        return TuNguyenMau;
    }

    public void setTuNguyenMau(String tuNguyenMau) {
        TuNguyenMau = tuNguyenMau;
    }

    public String getQuaKhuDon() {
        return QuaKhuDon;
    }

    public void setQuaKhuDon(String quaKhuDon) {
        QuaKhuDon = quaKhuDon;
    }

    public String getQuaKhuPhanTu() {
        return QuaKhuPhanTu;
    }

    public void setQuaKhuPhanTu(String quaKhuPhanTu) {
        QuaKhuPhanTu = quaKhuPhanTu;
    }

    public String getNghiaCuaTu() {
        return NghiaCuaTu;
    }

    public void setNghiaCuaTu(String nghiaCuaTu) {
        NghiaCuaTu = nghiaCuaTu;
    }
}

