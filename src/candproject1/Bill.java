/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candproject1;

import Data.ClassData;
import Data.exportExcel;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Hashtable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ADMIN
 */
public class Bill extends javax.swing.JFrame {

    /**
     * Creates new form Hoadon
     */
    public Bill() {
        initComponents();
        ChonSP();
        setMaHD();
        ChonDSHD();
        it = this;
    }
    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
    ResultSet Rss = null;

    int mousepX;
    int mousepY;

    public static Bill it;

    public void setRole(String Role) { // Set tên cho của sổ này
        role.setText(Role);
    }

    public void XuatHoaDon(int idhd) {
        try {
            Con = ClassData.ConnectDb();
            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\CANDProject1\\src\\candproject1\\In.jrxml");

            map.put("maHD", idhd);

            JasperPrint p = JasperFillManager.fillReport(report, map, Con);
            JasperViewer.viewReport(p, false);
            JasperExportManager.exportReportToPdfFile(p, "Hoadon.pdf");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    void capnhatSP() {
        //Cập nhật số lượng sản phẩm
        Con = ClassData.ConnectDb();
        try {
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from banhang.Sanpham where maSP =" + MaSP.getText());
            while (Rs.next()) {
                String a = Rs.getString("soSP");
                int b = Integer.parseInt(a) - Integer.parseInt(SoSP.getText());

                Statement Add = Con.createStatement();
                Add.executeUpdate("Update banhang.Sanpham set soSP ='" + b + "' where `maSP` =" + MaSP.getText());

            }
            ChonSP();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void setMaHD() {
        Con = ClassData.ConnectDb();
        try {
            St = Con.createStatement();
            Rs = St.executeQuery("Select MAX(maHD) from banhang.Danhsachhoadon");
            while (Rs.next()) {
                int a = Rs.getInt("MAX(maHD)");
                String masp = String.valueOf(a + 1);
                Mahoadon.setText(masp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void tinhtonghoadon() {
        String mahd = MaHoaDonTongTien.getText().toString();

        String sql = "SELECT SUM(`thanhtienHD`) FROM `Hoadon` WHERE `maHD`=" + mahd + "";
        try {
            St = Con.prepareStatement(sql);
            Rs = St.executeQuery(sql);
            while (Rs.next()) {
                double giatongtamthoi = Rs.getDouble("SUM(`thanhtienHD`)");
                int tonggiaInt = (int) giatongtamthoi;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ChonSP() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Mã Sản Phẩm", "Tên Sản Phẩm", "Loại Sản Phẩm", "Số Lượng", "Giá Tiền", "Ghi Chú"}, 0);
        Con = ClassData.ConnectDb();
        try {
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from banhang.Sanpham");
            while (Rs.next()) {
                String d = Rs.getString("maSP");
                String e = Rs.getString("tenSP");
                String f = Rs.getString("loaiSP");
                String g = Rs.getString("soSP");
                String h = Rs.getString("giaSP");
                String i = Rs.getString("ghichuSP");
                model.addRow(new Object[]{d, e, f, g, h, i});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        BangSP.setModel(model);

    }

    public void ChonDSHD() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Mã Hóa Đơn", "Mã Khách Hàng", "Ngày Lập", "Tình Trạng", "Giá Tiền", "Ghi Chú"}, 0);
        Con = ClassData.ConnectDb();
        try {
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from banhang.Danhsachhoadon");
            while (Rs.next()) {
                String a = Rs.getString("maHD");
                String b = Rs.getString("maKH");
                String c = Rs.getString("ngaylapHD");
                String d = Rs.getString("tinhtrangHD");
                String e = Rs.getString("giaHD");
                String f = Rs.getString("ghichuHD");
                model.addRow(new Object[]{a, b, c, d, e, f});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DSHD.setModel(model);
    }

    public void ChonHD() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"STT", "Mã Hóa Đơn", "Mã Sản Phẩm", "Tên Sản Phẩm", "Đơn Giá", "Số Lượng", "Thành Tiền"}, 0);
        Con = ClassData.ConnectDb();
        int a = 1;
        try {
            String tk = MaHoaDonTongTien.getText();
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT sanpham.maSP , sanpham.tenSP , sanpham.giaSP, hoadon.maHD, hoadon.soluongHD, hoadon.thanhtienHD FROM sanpham , hoadon  WHERE (sanpham.maSP = hoadon.maSP) AND hoadon.maHD like '" + tk + "'");
            while (Rs.next()) {
                int c = a++;
                String d = Rs.getString("maHD");
                String e = Rs.getString("maSP");
                String f = Rs.getString("tenSP");
                String g = Rs.getString("giaSP");
                String h = Rs.getString("soluongHD");
                String i = Rs.getString("thanhtienHD");
                model.addRow(new Object[]{c, d, e, f, g, h, i});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Chitiethoadon.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        Xoa = new javax.swing.JButton();
        Them = new javax.swing.JButton();
        Huy = new javax.swing.JButton();
        Sua = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        BangSP = new javax.swing.JTable();
        SoSP = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        GiaSP = new javax.swing.JTextField();
        Thanhtien = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        MaHD = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        MaSP = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DSHD = new javax.swing.JTable();
        themhoadon = new javax.swing.JButton();
        hoanthanhhoadon = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Mahoadon = new javax.swing.JTextField();
        jDateNL = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tinhtrang = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        ghichu = new javax.swing.JTextField();
        xuathoadon = new javax.swing.JButton();
        xoahoadon = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        MaKhachHang = new javax.swing.JTextField();
        Timkiem2 = new javax.swing.JTextField();
        huyHD = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        MaHoaDonTongTien = new javax.swing.JTextField();
        in_hoa_don = new javax.swing.JButton();
        jBTTONGHD = new javax.swing.JButton();
        jTongTien = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Chitiethoadon = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        Timkiem4 = new javax.swing.JTextField();
        Timkiem5 = new javax.swing.JTextField();
        DiemTichLuy = new javax.swing.JTextField();
        diemtichluy = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        MaNV = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        diemdaco = new javax.swing.JLabel();
        dungdiem = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        role = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1200, 700));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 85, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(1200, 700));
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 700));

        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 620));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 85, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("QUẢN LÝ HÓA ĐƠN");

        Xoa.setBackground(new java.awt.Color(110, 0, 0));
        Xoa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Xoa.setForeground(new java.awt.Color(255, 255, 255));
        Xoa.setText("Xóa");
        Xoa.setMaximumSize(new java.awt.Dimension(90, 25));
        Xoa.setMinimumSize(new java.awt.Dimension(90, 25));
        Xoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XoaMouseClicked(evt);
            }
        });
        Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaActionPerformed(evt);
            }
        });

        Them.setBackground(new java.awt.Color(0, 80, 0));
        Them.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Them.setForeground(new java.awt.Color(255, 255, 255));
        Them.setText("Thêm");
        Them.setMaximumSize(new java.awt.Dimension(90, 25));
        Them.setMinimumSize(new java.awt.Dimension(90, 25));
        Them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThemMouseClicked(evt);
            }
        });
        Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemActionPerformed(evt);
            }
        });

        Huy.setBackground(new java.awt.Color(0, 80, 0));
        Huy.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Huy.setForeground(new java.awt.Color(255, 255, 255));
        Huy.setText("Hủy");
        Huy.setMaximumSize(new java.awt.Dimension(90, 25));
        Huy.setMinimumSize(new java.awt.Dimension(90, 25));
        Huy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HuyMouseClicked(evt);
            }
        });

        Sua.setBackground(new java.awt.Color(0, 80, 0));
        Sua.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Sua.setForeground(new java.awt.Color(255, 255, 255));
        Sua.setText("Sửa");
        Sua.setMaximumSize(new java.awt.Dimension(90, 25));
        Sua.setMinimumSize(new java.awt.Dimension(90, 25));
        Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaActionPerformed(evt);
            }
        });

        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        BangSP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BangSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Loại", "Số Lượng", "Giá Tiền", "Ghi Chú"
            }
        ));
        BangSP.setRowHeight(25);
        BangSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BangSPMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BangSPMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(BangSP);
        if (BangSP.getColumnModel().getColumnCount() > 0) {
            BangSP.getColumnModel().getColumn(0).setMaxWidth(80);
            BangSP.getColumnModel().getColumn(3).setMaxWidth(60);
        }

        SoSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SoSPActionPerformed(evt);
            }
        });
        SoSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SoSPKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 85, 0));
        jLabel8.setText("Số lượng");

        GiaSP.setEditable(false);
        GiaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GiaSPActionPerformed(evt);
            }
        });
        GiaSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GiaSPKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 85, 0));
        jLabel12.setText("Thành Tiền");

        MaHD.setEditable(false);
        MaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaHDActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 85, 0));
        jLabel9.setText("Mã Hóa Đơn");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 85, 0));
        jLabel7.setText("Mã Sản Phẩm");

        MaSP.setEditable(false);

        DSHD.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        DSHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Mã Khách Hàng", "Ngày Lập", "Tình trạng", "Đơn Giá", "Ghi Chú"
            }
        ));
        DSHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DSHDMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DSHDMousePressed(evt);
            }
        });
        DSHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DSHDKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(DSHD);

        themhoadon.setBackground(new java.awt.Color(0, 80, 0));
        themhoadon.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        themhoadon.setForeground(new java.awt.Color(255, 255, 255));
        themhoadon.setText("Thêm Hóa Đơn");
        themhoadon.setPreferredSize(new java.awt.Dimension(110, 25));
        themhoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themhoadonActionPerformed(evt);
            }
        });

        hoanthanhhoadon.setBackground(new java.awt.Color(0, 80, 0));
        hoanthanhhoadon.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        hoanthanhhoadon.setForeground(new java.awt.Color(255, 255, 255));
        hoanthanhhoadon.setText("Hoàn Thành");
        hoanthanhhoadon.setPreferredSize(new java.awt.Dimension(110, 25));
        hoanthanhhoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hoanthanhhoadonMouseClicked(evt);
            }
        });
        hoanthanhhoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoanthanhhoadonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 85, 0));
        jLabel5.setText("Mã Khách Hàng");

        Mahoadon.setEditable(false);
        Mahoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MahoadonActionPerformed(evt);
            }
        });

        jDateNL.setDateFormatString("dd/MM/yyyy");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 85, 0));
        jLabel17.setText("Ngày Lập");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 85, 0));
        jLabel6.setText("Tình Trạng");

        tinhtrang.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tinhtrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lọc Tình Trạng", "Đã Hoàn Thành", "Chưa Hoàn Thành" }));
        tinhtrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinhtrangActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 85, 0));
        jLabel18.setText("Ghi Chú");

        xuathoadon.setBackground(new java.awt.Color(0, 80, 0));
        xuathoadon.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        xuathoadon.setForeground(new java.awt.Color(255, 255, 255));
        xuathoadon.setText("Xuất Danh Sách");
        xuathoadon.setPreferredSize(new java.awt.Dimension(110, 25));
        xuathoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xuathoadonActionPerformed(evt);
            }
        });

        xoahoadon.setBackground(new java.awt.Color(110, 0, 0));
        xoahoadon.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        xoahoadon.setForeground(new java.awt.Color(255, 255, 255));
        xoahoadon.setText("Xóa Hóa Đơn");
        xoahoadon.setMaximumSize(new java.awt.Dimension(110, 25));
        xoahoadon.setMinimumSize(new java.awt.Dimension(110, 25));
        xoahoadon.setPreferredSize(new java.awt.Dimension(110, 25));
        xoahoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xoahoadonMouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 85, 0));
        jLabel19.setText("Mã Hóa Đơn ");

        MaKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaKhachHangActionPerformed(evt);
            }
        });
        MaKhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MaKhachHangKeyPressed(evt);
            }
        });

        Timkiem2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Timkiem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Timkiem2ActionPerformed(evt);
            }
        });
        Timkiem2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Timkiem2KeyPressed(evt);
            }
        });

        huyHD.setBackground(new java.awt.Color(0, 80, 0));
        huyHD.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        huyHD.setForeground(new java.awt.Color(255, 255, 255));
        huyHD.setText("Hủy");
        huyHD.setPreferredSize(new java.awt.Dimension(110, 25));
        huyHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huyHDActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox1.setText("Đã Hoàn Thành");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(xuathoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(themhoadon, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hoanthanhhoadon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xoahoadon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ghichu)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Mahoadon, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                    .addComponent(MaKhachHang))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(huyHD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Timkiem2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateNL, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tinhtrang, javax.swing.GroupLayout.Alignment.LEADING, 0, 140, Short.MAX_VALUE)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(1, 1, 1))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {hoanthanhhoadon, themhoadon, xoahoadon, xuathoadon});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateNL, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Mahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jCheckBox1)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ghichu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Timkiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(themhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(hoanthanhhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(39, 39, 39))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(xoahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xuathoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(huyHD, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {MaKhachHang, Mahoadon, jDateNL, jLabel17, jLabel19, jLabel5, jLabel6});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {hoanthanhhoadon, themhoadon, xoahoadon, xuathoadon});

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 85, 0));
        jLabel11.setText("Giá Sản Phẩm");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 85, 0));
        jLabel13.setText("Mã Hóa Đơn");

        MaHoaDonTongTien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MaHoaDonTongTienKeyPressed(evt);
            }
        });

        in_hoa_don.setBackground(new java.awt.Color(0, 80, 0));
        in_hoa_don.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        in_hoa_don.setForeground(new java.awt.Color(255, 255, 255));
        in_hoa_don.setText("In Hóa Đơn");
        in_hoa_don.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in_hoa_donActionPerformed(evt);
            }
        });

        jBTTONGHD.setBackground(new java.awt.Color(0, 80, 0));
        jBTTONGHD.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jBTTONGHD.setForeground(new java.awt.Color(255, 255, 255));
        jBTTONGHD.setText("Tổng Hóa Đơn");
        jBTTONGHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTTONGHDActionPerformed(evt);
            }
        });

        jTongTien.setEditable(false);
        jTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTongTienActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Danh Sách Sản Phẩm");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Chi Tiết Hóa Đơn");

        Chitiethoadon.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Chitiethoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Hóa Đơn", "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ));
        Chitiethoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChitiethoadonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ChitiethoadonMousePressed(evt);
            }
        });
        Chitiethoadon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ChitiethoadonKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(Chitiethoadon);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Danh Sách Hóa Đơn");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Timkiem4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        Timkiem5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        DiemTichLuy.setEditable(false);
        DiemTichLuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiemTichLuyActionPerformed(evt);
            }
        });

        diemtichluy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        diemtichluy.setForeground(new java.awt.Color(0, 85, 0));
        diemtichluy.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        diemtichluy.setText("Điểm Tích Lũy");

        jLabel28.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 85, 0));
        jLabel28.setText("Mã Nhân Viên");

        MaNV.setToolTipText("");
        MaNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MaNVKeyPressed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 85, 0));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Có");

        diemdaco.setBackground(new java.awt.Color(204, 204, 204));
        diemdaco.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        diemdaco.setForeground(new java.awt.Color(204, 0, 0));
        diemdaco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diemdaco.setOpaque(true);

        dungdiem.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        dungdiem.setText("Dùng Điểm");
        dungdiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dungdiemActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 85, 0));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Điểm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Timkiem5, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(Timkiem4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(MaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel11)
                        .addGap(4, 4, 4)
                        .addComponent(GiaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(10, 10, 10)
                        .addComponent(MaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(SoSP, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(Thanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(diemdaco, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MaHoaDonTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(dungdiem, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(diemtichluy, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(DiemTichLuy))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(in_hoa_don)
                                .addGap(37, 37, 37)
                                .addComponent(jBTTONGHD)
                                .addGap(10, 10, 10)
                                .addComponent(jTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(jLabel15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel13))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(MaHoaDonTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(in_hoa_don)
                            .addComponent(jBTTONGHD)
                            .addComponent(jTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(DiemTichLuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(diemtichluy, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dungdiem)
                                        .addComponent(jLabel31)))
                                .addGap(7, 7, 7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(diemdaco, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jLabel14)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Timkiem5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Timkiem4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel11))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(GiaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel7))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(MaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SoSP, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(Thanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jLabel3.setBackground(new java.awt.Color(0, 60, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sp-icon.png"))); // NOI18N
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(155, 155, 0), 2, true));
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 60, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/events-icon.png"))); // NOI18N
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(155, 155, 0), 2, true));
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(0, 60, 0));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/kh-icon.png"))); // NOI18N
        jLabel22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(155, 155, 0), 2, true));
        jLabel22.setOpaque(true);
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(200, 200, 0));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Sự Kiện");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(200, 200, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Khách Hàng");
        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(200, 200, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Sản Phẩm");
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(102, 102, 102));
        jLabel20.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Đăng Xuất");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.setMaximumSize(new java.awt.Dimension(87, 15));
        jLabel20.setMinimumSize(new java.awt.Dimension(87, 15));
        jLabel20.setOpaque(true);
        jLabel20.setPreferredSize(new java.awt.Dimension(87, 15));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("_");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.setMaximumSize(new java.awt.Dimension(12, 19));
        jLabel2.setMinimumSize(new java.awt.Dimension(12, 19));
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new java.awt.Dimension(12, 19));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });

        role.setBackground(new java.awt.Color(0, 51, 51));
        role.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        role.setForeground(new java.awt.Color(255, 204, 204));
        role.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        role.setText("ADMIN");
        role.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        role.setOpaque(true);
        role.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                roleMouseDragged(evt);
            }
        });
        role.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                roleMousePressed(evt);
            }
        });

        jLabel21.setBackground(new java.awt.Color(0, 140, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home-iconnn.png"))); // NOI18N
        jLabel21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 0), 2, true));
        jLabel21.setOpaque(true);
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        jLabel23.setBackground(new java.awt.Color(0, 60, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/NCC-icon.png"))); // NOI18N
        jLabel23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(155, 155, 0), 2, true));
        jLabel23.setOpaque(true);
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(200, 200, 0));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Nhà Cung Cấp");
        jLabel27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(role, javax.swing.GroupLayout.PREFERRED_SIZE, 956, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(role, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1200, 700);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void XoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XoaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_XoaMouseClicked

    private void ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemActionPerformed
        // TODO add your handling code here:
        if (MaHD.getText().isEmpty() || MaSP.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập Thiếu Thông Tin!", "Chú Ý", JOptionPane.YES_NO_OPTION);
        } else {
            if (jCheckBox1.isSelected()) {
                JOptionPane.showMessageDialog(this, "Không Thể Thay Đổi Hóa Đơn Đã Hoàn Thành", "Không Thể Thêm", JOptionPane.ERROR_MESSAGE);
            } else {
                Con = ClassData.ConnectDb();
                int ketqua = JOptionPane.showConfirmDialog(this, "Thêm Sản Phẩm Vào Hóa Đơn?", "Chú ý", JOptionPane.YES_NO_OPTION);
                if (ketqua == JOptionPane.YES_OPTION) {
                    try {

                        PreparedStatement add = Con.prepareStatement("insert into Hoadon(`maHD`,`maSP`,`soluongHD`,`thanhtienHD`) values(?,?,?,?)");
                        add.setInt(1, Integer.valueOf(MaHD.getText()));
                        add.setInt(2, Integer.valueOf(MaSP.getText()));
                        add.setInt(3, Integer.valueOf(SoSP.getText()));
                        add.setInt(4, Integer.valueOf(Thanhtien.getText()));
                        int row = add.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Thêm Sản Phẩm Thành Công!");
                        Con.close();
                        ChonHD();
                        capnhatSP();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Sản Phẩm Đã Được Thêm Vào Hóa Đơn\n" + "Bạn Có Thể Thay Đổi Số Lượng", "Đã Có Sản Phẩm", JOptionPane.OK_OPTION);
                        ex.printStackTrace();
                    }

                }
            }
        }
    }//GEN-LAST:event_ThemActionPerformed

    private void HuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HuyMouseClicked
        // TODO add your handling code here:
        MaSP.setText("");
        SoSP.setText("");
        GiaSP.setText("");
        ChonSP();
    }//GEN-LAST:event_HuyMouseClicked

    private void SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaActionPerformed
        // TODO add your handling code here:
        if (MaHD.getText().isEmpty() || MaSP.getText().isEmpty() || SoSP.getText().isEmpty() || GiaSP.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy chọn sản phẩm cần sửa!");
        } else {
            if (jCheckBox1.isSelected()) {
                JOptionPane.showMessageDialog(this, "Không Thể Thay Đổi Hóa Đơn Đã Hoàn Thành", "Không Thể Sửa", JOptionPane.ERROR_MESSAGE);
            } else {
                int ketqua = JOptionPane.showConfirmDialog(this, "Sửa thông tin sản phẩm?", "Chú ý", JOptionPane.YES_NO_OPTION);
                if (ketqua == JOptionPane.YES_OPTION) {
                    Con = ClassData.ConnectDb();
                    try {
                        String Query = "Update banhang.Hoadon set `soluongHD`='" + SoSP.getText() + "', "
                                + "thanhtienHD = '" + Thanhtien.getText() + "' where `maSP`=" + MaSP.getText();
                        Statement Add = Con.createStatement();
                        Add.executeUpdate(Query);
                        JOptionPane.showMessageDialog(this, "Sửa thông tin sản phẩm thành công!");
                        ChonHD();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    capnhatSP();
                }
            }
        }
    }//GEN-LAST:event_SuaActionPerformed

    private void BangSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangSPMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) BangSP.getModel();
        int Myindex = BangSP.getSelectedRow();
        MaSP.setText(model.getValueAt(Myindex, 0).toString());
        Timkiem5.setText(model.getValueAt(Myindex, 1).toString());
        GiaSP.setText(model.getValueAt(Myindex, 4).toString());
    }//GEN-LAST:event_BangSPMouseClicked

    private void ChitiethoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChitiethoadonMouseClicked

        DefaultTableModel model = (DefaultTableModel) Chitiethoadon.getModel();
        int Myindex = Chitiethoadon.getSelectedRow();
        MaHD.setText(model.getValueAt(Myindex, 1).toString());
        MaSP.setText(model.getValueAt(Myindex, 2).toString());
        GiaSP.setText(model.getValueAt(Myindex, 4).toString());
        SoSP.setText(model.getValueAt(Myindex, 5).toString());
//        Thanhtien.setText(model.getValueAt(Myindex, 6).toString());


    }//GEN-LAST:event_ChitiethoadonMouseClicked

    private void themhoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themhoadonActionPerformed
        Date ngaylap = jDateNL.getDate();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String ngaylap1 = format.format(ngaylap.getTime());
        if (MaNV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập Tên Nhân Viên!");
        } else {
            if (Mahoadon.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nhập Thiếu Thông Tin!");
            } else {
                try {
                    Con = ClassData.ConnectDb();
                    int ketqua = JOptionPane.showConfirmDialog(this, "Thêm Hóa Đơn Vào Danh Sách?", "Chú ý", JOptionPane.YES_NO_OPTION);
                    if (ketqua == JOptionPane.YES_OPTION) {
                        PreparedStatement add = Con.prepareStatement("insert into Danhsachhoadon values(?,?,?,?,?,?,?)");
                        add.setInt(1, Integer.valueOf(Mahoadon.getText()));
                        add.setString(2, MaKhachHang.getText());
                        add.setString(3, ngaylap1);
                        add.setString(4, "Chưa Hoàn Thành");
                        add.setString(5, "0");
                        add.setString(6, ghichu.getText());
                        add.setString(7, MaNV.getText());
                        int row = add.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Thêm Hóa Đơn Thành Công!");
                        Con.close();
                        ChonDSHD();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                huyHDActionPerformed(evt);
            }
        }
    }//GEN-LAST:event_themhoadonActionPerformed

    private void hoanthanhhoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoanthanhhoadonActionPerformed
        if (Mahoadon.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chọn Hóa Đơn!");
        } else {
            if (jCheckBox1.isSelected()) {
                JOptionPane.showMessageDialog(this, "Hóa Đơn Đã Được Hoàn Thành", "Chú Ý", JOptionPane.ERROR_MESSAGE);
            } else {
                Con = ClassData.ConnectDb();
                try {
                    int ketqua = JOptionPane.showConfirmDialog(this, "Hoàn Thành Đơn Hàng?", "Chú ý", JOptionPane.YES_NO_OPTION);
                    if (ketqua == JOptionPane.YES_OPTION) {
                        String Query = "Update banhang.Danhsachhoadon set `tinhtrangHD`='" + jCheckBox1.getText() + "',"
                                + " giaHD ='" + jTongTien.getText() + "' where maHD = " + MaHoaDonTongTien.getText();
                        Statement Add = Con.createStatement();
                        Add.executeUpdate(Query);
                        Statement AddDiem = Con.createStatement();
                        AddDiem.executeUpdate("Update banhang.Khachhang set diemKH = diemKH+ '" + DiemTichLuy.getText() + "' where maKH = " + MaKhachHang.getText());
                        JOptionPane.showMessageDialog(this, "Đã Hoàn Thành Đơn Hàng!");
                        ChonDSHD();
                        huyHDActionPerformed(null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

//Tính điểm 
        String mahd = MaHoaDonTongTien.getText().toString();
        String sql = "SELECT SUM(`thanhtienHD`) FROM `Hoadon` WHERE `maHD`=" + mahd + "";
        try {
            St = Con.prepareStatement(sql);
            Rs = St.executeQuery(sql);
            while (Rs.next()) {
                int giatongtamthoi = Rs.getInt("SUM(`thanhtienHD`)");
                //update diem
                Con = ClassData.ConnectDb();
                String Query = "Update banhang.Khachhang set diemKH ='" + diemdaco.getText() + "' where  maKH =" + MaKhachHang.getText();
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_hoanthanhhoadonActionPerformed

    private void in_hoa_donActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in_hoa_donActionPerformed

//       inhoadon();
//        inhoadon.setSize(800, 800);
//
//        inhoadon.setLocationRelativeTo(null);
//        inhoadon.setVisible(true);
//gọi hàm xuất hóa đơn   Integer.parseInt(MaHoaDonTongTien.getText().toString())
        XuatHoaDon(Integer.parseInt(MaHD.getText()));
//                String link = "C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\CANDProject1\\src\\candproject1\\In.jrxml";
//          Con = ClassData.ConnectDb();
//                try {
//                   JasperReport jr = JasperCompileManager.compileReport(link);
//                    JasperPrint jp = JasperFillManager.fillReport(jr, null,Con);
//                    JasperViewer.viewReport(jp);
//
//        
//        
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
    }//GEN-LAST:event_in_hoa_donActionPerformed

    private void jBTTONGHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTTONGHDActionPerformed
        String mahd = MaHoaDonTongTien.getText().toString();
        String sql = "SELECT SUM(`thanhtienHD`) FROM `Hoadon` WHERE `maHD`=" + mahd + "";
        try {
            St = Con.prepareStatement(sql);
            Rs = St.executeQuery(sql);
            while (Rs.next()) {
                int giatongtamthoi = Rs.getInt("SUM(`thanhtienHD`)");
                int tonggiaInt = (int) giatongtamthoi;
//                NumberFormat fm = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
//                String trunggian = fm.format(giatongtamthoi);
                jTongTien.setText(String.valueOf(tonggiaInt));
                DiemTichLuy.setText(String.valueOf(tonggiaInt / 10000));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBTTONGHDActionPerformed

    private void DSHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DSHDMouseClicked

        DefaultTableModel model = (DefaultTableModel) DSHD.getModel();
        int Myindex = DSHD.getSelectedRow();
        Mahoadon.setText(model.getValueAt(Myindex, 0).toString());
        MaKhachHang.setText(model.getValueAt(Myindex, 1).toString());
        try {
            Date dt = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").parse((String) model.getValueAt(Myindex, 2));
            jDateNL.setDate(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").parse((String) model.getValueAt(Myindex, 2)));
            System.out.println(dt);

            Con = ClassData.ConnectDb();
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from banhang.danhsachhoadon where `maHD` like '" + model.getValueAt(Myindex, 0).toString() + "' ");
            while (Rs.next()) {
                String b = Rs.getString("tinhtrangHD");
                if (b.equals("Đã Hoàn Thành")) {
                    jCheckBox1.setSelected(true);
                } else {
                    jCheckBox1.setSelected(false);
                }
                jTongTien.setText(Rs.getString("giaHD"));
                ghichu.setText(Rs.getString("ghichuHD"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_DSHDMouseClicked

    private void xoahoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xoahoadonMouseClicked
        // TODO add your handling code here:
        if (Mahoadon.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chọn hóa đơn cần xóa!");
        } else {
            if (jCheckBox1.isSelected()) {
                JOptionPane.showMessageDialog(this, "Không Thể Xóa Hóa Đơn Đã Hoàn Thành", "Không Thể Xóa", JOptionPane.ERROR_MESSAGE);

            } else {
                try {
                    Con = ClassData.ConnectDb();
                    int ketqua = JOptionPane.showConfirmDialog(this, "Xóa Hóa Đơn Khỏi Danh Sách?", "Chú ý", JOptionPane.YES_NO_OPTION);
                    if (ketqua == JOptionPane.YES_OPTION) {
                        String Mahd = Mahoadon.getText();
                        String Query = "Delete from banhang.Danhsachhoadon where `maHD`=" + Mahd;
                        Statement Add = Con.createStatement();
                        Add.executeUpdate(Query);
                        ChonDSHD();
                        JOptionPane.showMessageDialog(this, "Xóa Hóa Đơn Thành Công!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                huyHDActionPerformed(null);

            }
        }

    }//GEN-LAST:event_xoahoadonMouseClicked

    private void hoanthanhhoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hoanthanhhoadonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_hoanthanhhoadonMouseClicked

    private void MaHoaDonTongTienKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MaHoaDonTongTienKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (MaHoaDonTongTien.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chưa Nhập Mã Hóa Đơn");
            } else {
                ChonHD();
            }
        }
    }//GEN-LAST:event_MaHoaDonTongTienKeyPressed

    private void MaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaHDActionPerformed
        MaHD.setText(MaHoaDonTongTien.getText());
    }//GEN-LAST:event_MaHDActionPerformed

    private void DSHDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DSHDMousePressed
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            MaHoaDonTongTien.setText(Mahoadon.getText());
            MaHD.setText(Mahoadon.getText());
            Con = ClassData.ConnectDb();
            try {
                St = Con.createStatement();
                Rs = St.executeQuery("Select * from banhang.Khachhang where `maKH` like '" + MaKhachHang.getText().toString() + "' ");
                while (Rs.next()) {
                    diemdaco.setText(Rs.getString("diemKH"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            ChonHD();
        }
        DSHD.setDefaultEditor(Object.class, null);
    }//GEN-LAST:event_DSHDMousePressed

    private void SoSPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SoSPKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Con = ClassData.ConnectDb();

            try {
                String tk = MaSP.getText();
                St = Con.createStatement();
                Rs = St.executeQuery("Select * from banhang.Sanpham where `maSP` like '" + tk + "'");
                Rs.next();
                if (Integer.parseInt(Rs.getString("soSP")) < Integer.parseInt(SoSP.getText().toString())) {
                    JOptionPane.showMessageDialog(this, "Không Đủ Số Lượng Hàng");
                } else {
                    String gia = GiaSP.getText().toString();
                    String so = SoSP.getText().toString();
                    int a = Integer.parseInt(gia);
                    int b = Integer.parseInt(so);
//            NumberFormat fm = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
//            String trunggian = fm.format(a * b);
                    Thanhtien.setText((String.valueOf(a * b)));//String.valueOf(trunggian)); 
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_SoSPKeyPressed

    private void SoSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SoSPActionPerformed

    private void GiaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GiaSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GiaSPActionPerformed

    private void ChitiethoadonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChitiethoadonMousePressed
        if (evt.getClickCount() == 1 && !evt.isConsumed()) {
            evt.consume();
            Chitiethoadon.setDefaultEditor(Object.class, null);
        }
    }//GEN-LAST:event_ChitiethoadonMousePressed

    private void jTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTongTienActionPerformed

    private void DSHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DSHDKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            DSHDMouseClicked(null);
        }
    }//GEN-LAST:event_DSHDKeyReleased

    private void ChitiethoadonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ChitiethoadonKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            ChitiethoadonMouseClicked(null);
        }

    }//GEN-LAST:event_ChitiethoadonKeyReleased

    private void XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaActionPerformed
        if (jCheckBox1.isSelected()) {
            JOptionPane.showMessageDialog(this, "Không Thể Thay Đổi Hóa Đơn Đã Hoàn Thành", "Không Thể Xóa", JOptionPane.ERROR_MESSAGE);
        } else {
            if (MaSP.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chọn sản phẩm cần xóa!");
            } else {
                try {

                    int ketqua = JOptionPane.showConfirmDialog(this, "Xóa sản phẩm?", "Chú ý", JOptionPane.YES_NO_OPTION);
                    if (ketqua == JOptionPane.YES_OPTION) {
                        String Masp = MaSP.getText();
                        String Query = "Delete from banhang.Hoadon where `maSP`=" + Masp;
                        Statement Add = Con.createStatement();
                        Add.executeUpdate(Query);
                        ChonHD();
                        JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_XoaActionPerformed

    private void MahoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MahoadonActionPerformed
        try {
            Con = ClassData.ConnectDb();
            St = Con.createStatement();
            Rs = St.executeQuery("Select * MAX(`Mã Hóa Đơn`) from banhang.Danhsachhoadon");
            Mahoadon.setText(Rs.getString(0));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_MahoadonActionPerformed

    private void BangSPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangSPMousePressed
        if (evt.getClickCount() == 1 && !evt.isConsumed()) {
            evt.consume();
            BangSP.setDefaultEditor(Object.class, null);
        }
    }//GEN-LAST:event_BangSPMousePressed

    private void GiaSPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GiaSPKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_GiaSPKeyPressed

    private void MaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaKhachHangActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        new Event().setVisible(true);
        this.dispose();
        if (role.getText() == "EMPLOYEE") {
            Event.it.setRole("EMPLOYEE");
        } else {
            Event.it.setRole("ADMIN");
        }

    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setState(1);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void tinhtrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tinhtrangActionPerformed
        String a = tinhtrang.getSelectedItem().toString();
        if (a == "Lọc Tình Trạng") {
            ChonDSHD();
        } else {
            try {
                Con = ClassData.ConnectDb();
                St = Con.createStatement();
                Rs = St.executeQuery("Select * from banhang.Danhsachhoadon where `tinhtrangHD` like '" + a + "'");
                DSHD.setModel(DbUtils.resultSetToTableModel((Rs)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_tinhtrangActionPerformed

    private void Timkiem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Timkiem2ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_Timkiem2ActionPerformed

    private void Timkiem2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Timkiem2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tinhtrangActionPerformed(null);
            jButton1ActionPerformed(null);
        }
    }//GEN-LAST:event_Timkiem2KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tinhtrangActionPerformed(null);
        if (Timkiem2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập Thông Tin Tìm Kiếm");
        } else {
            DefaultTableModel model = new DefaultTableModel(new String[]{"Mã Hóa Đơn", "Mã Khách Hàng", "Ngày Lập", "Tình Trạng", "Giá Tiền", "Ghi Chú"}, 0);
            try {
                Con = ClassData.ConnectDb();
                String tk = Timkiem2.getText();
                St = Con.createStatement();
                Rs = St.executeQuery("Select * from banhang.Danhsachhoadon where `maHD` like '%" + tk + "%' "
                        + "or `maKH` like '%" + tk + "%' or `ngaylapHD` like '%" + tk + "%' "
                        + "or `tinhtrangHD` like '%" + tk + "%' or `giaHD` like '%" + tk + "%' "
                        + "or ghichuHD like '%" + tk + "%'");
                while (Rs.next()) {
                    String a = Rs.getString("maHD");
                    String b = Rs.getString("maKH");
                    String c = Rs.getString("ngaylapHD");
                    String d = Rs.getString("tinhtrangHD");
                    String e = Rs.getString("giaHD");
                    String f = Rs.getString("ghichuHD");
                    model.addRow(new Object[]{a, b, c, d, e, f});
                }
//                DSHD.setModel(DbUtils.resultSetToTableModel((Rs)));
            } catch (Exception e) {
                e.printStackTrace();
            }
            DSHD.setModel(model);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (Timkiem4.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhap thong tin tim kiem");
        } else {

            DefaultTableModel model = new DefaultTableModel(new String[]{"Mã Sản Phẩm", "Tên Sản Phẩm", "Loại Sản Phẩm", "Số Lượng", "Giá Tiền", "Ghi Chú"}, 0);

            try {
                Con = ClassData.ConnectDb();
                String tk = Timkiem4.getText();
                St = Con.createStatement();
                Rs = St.executeQuery("Select * from banhang.Sanpham where maSP like '%" + tk + "%' or tenSP like '%" + tk + "%' or loaiSP like '%" + tk + "%' or soSP like '%" + tk + "%' or giaSP like '%" + tk + "%' or ghichuSP like '%" + tk + "%'");
                while (Rs.next()) {
                    String d = Rs.getString("maSP");
                    String e = Rs.getString("tenSP");
                    String f = Rs.getString("loaiSP");
                    String g = Rs.getString("soSP");
                    String h = Rs.getString("giaSP");
                    String i = Rs.getString("ghichuSP");
                    model.addRow(new Object[]{d, e, f, g, h, i});
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            BangSP.setModel(model);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        new Event().setVisible(true);
        this.dispose();
        if (role.getText() == "EMPLOYEE") {
            Event.it.setRole("EMPLOYEE");
        } else {
            Event.it.setRole("ADMIN");
        }
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        new Product().setVisible(true);
        this.dispose();
        if ("EMPLOYEE".equals(role.getText())) {
            Product.it.setRole("EMPLOYEE");
        } else {
            Product.it.setRole("ADMIN");
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        new Product().setVisible(true);
        this.dispose();
        if ("EMPLOYEE".equals(role.getText())) {
            Product.it.setRole("EMPLOYEE");
        } else {
            Product.it.setRole("ADMIN");
        }
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        new Customer().setVisible(true);
        if ("EMPLOYEE".equals(role.getText())) {
            Customer.it.setRole("EMPLOYEE");
        } else {
            Customer.it.setRole("ADMIN");
        }
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        new Customer().setVisible(true);

        if ("EMPLOYEE".equals(role.getText())) {
            Customer.it.setRole("EMPLOYEE");
        } else {
            Customer.it.setRole("ADMIN");
        }
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel20MouseClicked

    private void DiemTichLuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiemTichLuyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiemTichLuyActionPerformed

    private void huyHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huyHDActionPerformed
        setMaHD();
        MaKhachHang.setText("");
        tinhtrang.setSelectedIndex(0);
        jCheckBox1.setSelected(false);
        ghichu.setText("");
        Timkiem2.setText("");

    }//GEN-LAST:event_huyHDActionPerformed

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        jLabel1.setBackground(Color.RED);
        jLabel1.setForeground(Color.WHITE);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        jLabel1.setBackground(Color.WHITE);
        jLabel1.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setBackground(Color.WHITE);
    }//GEN-LAST:event_jLabel2MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tinhtrangActionPerformed(null);
        if (MaKhachHang.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập Thông Tin Tìm Kiếm");
        } else {
            DefaultTableModel model = new DefaultTableModel(new String[]{"Mã Hóa Đơn", "Mã Khách Hàng", "Ngày Lập", "Tình Trạng", "Giá Tiền", "Ghi Chú"}, 0);
            try {
                Con = ClassData.ConnectDb();
                String tk = MaKhachHang.getText();
                St = Con.createStatement();
                Rs = St.executeQuery("Select * from banhang.Danhsachhoadon where `maKH` like '%" + tk + "%' ");
                while (Rs.next()) {
                    String a = Rs.getString("maHD");
                    String b = Rs.getString("maKH");
                    String c = Rs.getString("ngaylapHD");
                    String d = Rs.getString("tinhtrangHD");
                    String e = Rs.getString("giaHD");
                    String f = Rs.getString("ghichuHD");
                    model.addRow(new Object[]{a, b, c, d, e, f});
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            DSHD.setModel(model);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ThemMouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        if (role.getText() == "ADMIN") {
            new WellcomeScreen().setVisible(true);
        } else {
            new WellcomeScreenNV().setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        new Supplier().setVisible(true);
        this.dispose();
        if (role.getText() == "EMPLOYEE") {
            Supplier.it.setRole("EMPLOYEE");
        } else {
            Supplier.it.setRole("ADMIN");
        }
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        new Supplier().setVisible(true);
        this.dispose();
        if (role.getText() == "EMPLOYEE") {
            Supplier.it.setRole("EMPLOYEE");
        } else {
            Supplier.it.setRole("ADMIN");
        }
    }//GEN-LAST:event_jLabel27MouseClicked

    private void MaKhachHangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MaKhachHangKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButton2ActionPerformed(null);
        }
    }//GEN-LAST:event_MaKhachHangKeyPressed

    private void roleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roleMouseDragged
        int kordinatX = evt.getXOnScreen();
        int kordinatY = evt.getYOnScreen();

        this.setLocation(kordinatX - mousepX, kordinatY - mousepY);
    }//GEN-LAST:event_roleMouseDragged

    private void roleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roleMousePressed
        mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_roleMousePressed

    private void xuathoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xuathoadonActionPerformed
        // xuất hóa đơn
        exportExcel export = new exportExcel();
        export.exportExcel(DSHD);
    }//GEN-LAST:event_xuathoadonActionPerformed

    private void MaNVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MaNVKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaNVKeyPressed

    private void dungdiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dungdiemActionPerformed
        String mahd = MaHoaDonTongTien.getText().toString();
        String sql = "SELECT SUM(`thanhtienHD`) FROM `Hoadon` WHERE `maHD`=" + mahd + "";
        try {
            St = Con.prepareStatement(sql);
            Rs = St.executeQuery(sql);
            while (Rs.next()) {
                int giatongtamthoi = Rs.getInt("SUM(`thanhtienHD`)");
                int tonggiaInt = (int) (giatongtamthoi - (Integer.parseInt(diemdaco.getText().toString()) * 200));
                jTongTien.setText(String.valueOf(tonggiaInt));
                DiemTichLuy.setText(String.valueOf(tonggiaInt / 10000));
                //update diem
                Con = ClassData.ConnectDb();
                String Query = "Update banhang.Khachhang set diemKH ='0' where  maKH =" + MaKhachHang.getText();
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                diemdaco.setText("0");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_dungdiemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BangSP;
    private javax.swing.JTable Chitiethoadon;
    private javax.swing.JTable DSHD;
    private javax.swing.JTextField DiemTichLuy;
    private javax.swing.JTextField GiaSP;
    private javax.swing.JButton Huy;
    private javax.swing.JTextField MaHD;
    private javax.swing.JTextField MaHoaDonTongTien;
    private javax.swing.JTextField MaKhachHang;
    private javax.swing.JTextField MaNV;
    private javax.swing.JTextField MaSP;
    private javax.swing.JTextField Mahoadon;
    private javax.swing.JTextField SoSP;
    private javax.swing.JButton Sua;
    private javax.swing.JTextField Thanhtien;
    private javax.swing.JButton Them;
    private javax.swing.JTextField Timkiem2;
    private javax.swing.JTextField Timkiem4;
    private javax.swing.JTextField Timkiem5;
    private javax.swing.JButton Xoa;
    private javax.swing.JLabel diemdaco;
    private javax.swing.JLabel diemtichluy;
    private javax.swing.JButton dungdiem;
    private javax.swing.JTextField ghichu;
    private javax.swing.JButton hoanthanhhoadon;
    private javax.swing.JButton huyHD;
    private javax.swing.JButton in_hoa_don;
    private javax.swing.JButton jBTTONGHD;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateNL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTongTien;
    private javax.swing.JLabel role;
    private javax.swing.JButton themhoadon;
    private javax.swing.JComboBox<String> tinhtrang;
    private javax.swing.JButton xoahoadon;
    private javax.swing.JButton xuathoadon;
    // End of variables declaration//GEN-END:variables

}
