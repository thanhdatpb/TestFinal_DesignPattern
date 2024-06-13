package vn.edu.husc.it_1020124;

public class HinhChuNhat implements Shape{
    double chieuDai;
    double chieuRong;

    public HinhChuNhat(double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    @Override
    public Shape taoBanSao() {
        return new HinhChuNhat(this.chieuDai, this.chieuRong);
    }

    @Override
    public double getDienTich() {
        return chieuDai * chieuRong;
    }

    @Override
    public String getThongTin() {
        return "Hinh Chu Nhat [chieu dai=" + chieuDai + ", chieu rong=" + chieuRong + "]";
    }

    public void tangChieuDai(double giaTri) {
        this.chieuDai += giaTri;
    }

    public void tangChieuRong(double giaTri) {
        this.chieuRong += giaTri;
    }
}
