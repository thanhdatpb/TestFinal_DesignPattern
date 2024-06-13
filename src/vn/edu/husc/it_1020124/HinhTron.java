package vn.edu.husc.it_1020124;

public class HinhTron implements Shape{
    double banKinh;

    public HinhTron(double banKinh) {
        this.banKinh = banKinh;
    }

    @Override
    public String getThongTin() {
        return "Hình tron có bán kính là : " + banKinh;
    }

    @Override
    public Shape taoBanSao() {
        return new HinhTron(this.banKinh);
    }

    @Override
    public double getDienTich() {
        return Math.PI * banKinh * banKinh;
    }


    public void tangBanKinh(double giaTri) {
        this.banKinh += giaTri;
    }
}
