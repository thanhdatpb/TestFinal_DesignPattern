package vn.edu.husc.it_1020124;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Shape> lst = loadShapeFromFile();
        List<Shape> lst2 = lst.stream().map(Shape::taoBanSao).toList();

        increaseShape(lst2);

        printShape("Danh sach lst:", lst);
        printShape("Danh sach lst2:", lst2);
    }

    private static void increaseShape(List<Shape> lst2) {
        for (Shape shape : lst2) {
            if (shape instanceof HinhTron) {
                ((HinhTron) shape).tangBanKinh(1.0);
            } else if (shape instanceof HinhChuNhat) {
                ((HinhChuNhat) shape).tangChieuDai(2.0);
                ((HinhChuNhat) shape).tangChieuRong(2.0);
            }
        }
    }

    private static List<Shape> loadShapeFromFile() {
        List<Shape> lst = new ArrayList<>();

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

        return lst;
    }

    private static void printShape(String msg, List<Shape> list) {
        int stt = 1;
        System.out.println(msg);
        for (Shape shape : list) {
            String acreage = String.format("%.1f", shape.getDienTich());
            System.out.println("STT " + stt++);
            System.out.println("Thong tin: " + shape.getThongTin());
            System.out.println("Dien tich: " + acreage);
            System.out.println();
        }
    }
}