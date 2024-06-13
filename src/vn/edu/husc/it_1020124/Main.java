package vn.edu.husc.it_1020124;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> lst = new ArrayList<>();
        List<Shape> lst2 = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("hinh.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts[0].equals("0")) {
                    double banKinh = Double.parseDouble(parts[1]);
                    lst.add(new HinhTron(banKinh));
                } else if (parts[0].equals("1")) {
                    double chieuDai = Double.parseDouble(parts[1]);
                    double chieuRong = Double.parseDouble(parts[2]);
                    lst.add(new HinhChuNhat(chieuDai, chieuRong));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Shape shape : lst) {
            lst2.add(shape.taoBanSao());
        }

        for (Shape shape : lst2) {
            if (shape instanceof HinhTron) {
                ((HinhTron) shape).tangBanKinh(1.0);
            } else if (shape instanceof HinhChuNhat) {
                ((HinhChuNhat) shape).tangChieuDai(2.0);
                ((HinhChuNhat) shape).tangChieuRong(2.0);
            }
        }
        //In danh sách lst1
        System.out.println("Danh sach lst:");
        int stt = 1;
        for (Shape shape : lst) {
            String acreage = String.format("%.1f", shape.getDienTich());
            System.out.println("STT " + stt++);
            System.out.println("Thong tin: " + shape.getThongTin());
            System.out.println("Dien tich: " + acreage);
            System.out.println();
        }

        // In danh sách lst2
        System.out.println("Danh sach lst2:");
        stt = 1;
        for (Shape shape : lst2) {
            String acreage = String.format("%.1f", shape.getDienTich());
            System.out.println("STT " + stt++);
            System.out.println("Thong tin: " + shape.getThongTin());
            System.out.println("Dien tich: " + acreage);
            System.out.println();
        }
    }
}