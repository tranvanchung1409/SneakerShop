/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candproject1;

import Data.ClassData;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ADMIN
 */
public class Hoadon extends javax.swing.JFrame {

    /**
     * Creates new form Hoadon
     */
    public Hoadon() {
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

    public static Hoadon it;

    public void setRole(String Role) { // Set tên cho của sổ này
        role.setText(Role);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1200, 700));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 85, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(1200, 700));
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 600));
        jPanel1.setLayout(null);

        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 540));

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
        MaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaSPActionPerformed(evt);
            }
        });
        MaSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MaSPKeyPressed(evt);
            }
        });

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
                "Mã Hóa Đơn", "Tên Khách Hàng", "Ngày Lập", "Tình trạng", "Đơn Giá", "Ghi Chú"
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
                .addContainerGap())
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel16))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Timkiem5)
                                .addGap(23, 23, 23)
                                .addComponent(Timkiem4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(MaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(MaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(261, 261, 261)
                                                .addComponent(jLabel12))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel11))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(GiaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(SoSP, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(58, 58, 58)
                                                .addComponent(Thanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addGap(0, 2, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel13)
                        .addGap(6, 6, 6)
                        .addComponent(MaHoaDonTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(in_hoa_don)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBTTONGHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(diemtichluy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DiemTichLuy, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTongTien))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Huy, Sua, Them, Xoa});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel7, jLabel8});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTongTien, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(MaHoaDonTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13)
                                        .addComponent(jBTTONGHD)
                                        .addComponent(in_hoa_don)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(DiemTichLuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(diemtichluy, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addComponent(jLabel14)
                                .addGap(0, 0, 0)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Timkiem4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Timkiem5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(MaHD)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(MaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(GiaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(SoSP, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Thanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12))))
                    .addComponent(jLabel16))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Huy, Sua, Them, Xoa});

        jPanel1.add(jPanel2);
        jPanel2.setBounds(156, 46, 1000, 620);

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
        jPanel1.add(jLabel3);
        jLabel3.setBounds(26, 283, 100, 100);

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
        jPanel1.add(jLabel4);
        jLabel4.setBounds(26, 131, 100, 100);

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
        jPanel1.add(jLabel22);
        jLabel22.setBounds(26, 435, 100, 100);

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
        jPanel1.add(jLabel24);
        jLabel24.setBounds(26, 237, 100, 28);

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
        jPanel1.add(jLabel25);
        jLabel25.setBounds(26, 541, 100, 28);

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
        jPanel1.add(jLabel26);
        jLabel26.setBounds(26, 389, 100, 28);

        jLabel20.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Đăng Xuất");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.setMaximumSize(new java.awt.Dimension(87, 15));
        jLabel20.setMinimumSize(new java.awt.Dimension(87, 15));
        jLabel20.setPreferredSize(new java.awt.Dimension(87, 15));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel20);
        jLabel20.setBounds(26, 641, 100, 25);

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
        jPanel1.add(jLabel1);
        jLabel1.setBounds(1159, 1, 40, 27);

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
        jPanel1.add(jLabel2);
        jLabel2.setBounds(1118, 1, 40, 27);

        role.setBackground(new java.awt.Color(0, 0, 0));
        role.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        role.setForeground(new java.awt.Color(255, 204, 204));
        role.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        role.setText("ADMIN");
        role.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(role);
        role.setBounds(26, 91, 100, 22);

        jLabel21.setBackground(new java.awt.Color(0, 140, 0));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home-iconnn.png"))); // NOI18N
        jLabel21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 0), 2, true));
        jLabel21.setOpaque(true);
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel21);
        jLabel21.setBounds(0, 0, 49, 49);

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
//                        add.setInt(4, Integer.valueOf(GiaSP.getText()));
                        add.setInt(4, Integer.valueOf(Thanhtien.getText()));
                        int row = add.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Thêm Sản Phẩm Thành Công!");
                        Con.close();
                        ChonHD();

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Sản Phẩm Đã Được Thêm Vào Hóa Đơn\n" + "Bạn Có Thể Thay Đổi Số Lượng", "Đã Có Sản Phẩm", JOptionPane.OK_OPTION);
                        ex.printStackTrace();
                    }
                    capnhatSP();
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
        if (Mahoadon.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập Thiếu Thông Tin!");
        } else {
            try {
                Con = ClassData.ConnectDb();
                int ketqua = JOptionPane.showConfirmDialog(this, "Thêm Hóa Đơn Vào Danh Sách?", "Chú ý", JOptionPane.YES_NO_OPTION);
                if (ketqua == JOptionPane.YES_OPTION) {
                    PreparedStatement add = Con.prepareStatement("insert into Danhsachhoadon values(?,?,?,?,?,?)");
                    add.setInt(1, Integer.valueOf(Mahoadon.getText()));
                    add.setString(2, MaKhachHang.getText());
                    add.setString(3, ngaylap1);
                    add.setString(4, "Chưa Hoàn Thành");
                    add.setString(5, "");
                    add.setString(6, ghichu.getText());
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
                        AddDiem.executeUpdate("Update banhang.Khachhang set diemKH ='" + DiemTichLuy.getText() + "' where maKH = " + MaKhachHang.getText());
                        JOptionPane.showMessageDialog(this, "Đã Hoàn Thành Đơn Hàng!");
                        ChonDSHD();
                        huyHDActionPerformed(null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }//GEN-LAST:event_hoanthanhhoadonActionPerformed

    private void in_hoa_donActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in_hoa_donActionPerformed
//        inhoadon();
//        inhoadon.setSize(800, 800);
//
//        inhoadon.setLocationRelativeTo(null);
//        inhoadon.setVisible(true);

        //        String link = "D:\\New1\\QuanLyLapTop\\QuanLyLapTop\\src\\quanlylaptop\\report1.jrxml";
        //
        //        try {
        //            Class.forName("com.mysql.jdbc.Driver");
        //            Connection conn=DriverManager.getConnection("jdbc:mysql://Localhost/quanlysach", "root", "");
        //            JasperReport jr = JasperCompileManager.compileReport(link);
        //            JasperPrint jp = JasperFillManager.fillReport(jr, null,conn);
        //            JasperViewer.viewReport(jp);
        //
        //
        //        } catch (Exception e) {
        //            e.printStackTrace();
        //        }
    }//GEN-LAST:event_in_hoa_donActionPerformed

    private void jBTTONGHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTTONGHDActionPerformed
        String mahd = MaHoaDonTongTien.getText().toString();
        diemtichluy.setText("Điểm Tích Lũy");
        String sql = "SELECT SUM(`thanhtienHD`) FROM `Hoadon` WHERE `maHD`=" + mahd + "";
        try {
            St = Con.prepareStatement(sql);
            Rs = St.executeQuery(sql);

            while (Rs.next()) {

                double giatongtamthoi = Rs.getDouble("SUM(`thanhtienHD`)");
                int tonggiaInt = (int) giatongtamthoi;
//                NumberFormat fm = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
//                String trunggian = fm.format(giatongtamthoi);
                jTongTien.setText(String.valueOf(tonggiaInt));
                DiemTichLuy.setText(String.valueOf(tonggiaInt / 100000));
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
        // TODO add your handling code here:
        MaHD.setText(MaHoaDonTongTien.getText());
    }//GEN-LAST:event_MaHDActionPerformed

    private void MaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaSPActionPerformed

    private void DSHDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DSHDMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            MaHoaDonTongTien.setText(Mahoadon.getText());
            MaHD.setText(Mahoadon.getText());
            ChonHD();
        }
        DSHD.setDefaultEditor(Object.class, null);
    }//GEN-LAST:event_DSHDMousePressed

    private void SoSPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SoSPKeyPressed
        // TODO add your handling code here:
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
        // TODO add your handling code here:
        if (evt.getClickCount() == 1 && !evt.isConsumed()) {
            evt.consume();
            Chitiethoadon.setDefaultEditor(Object.class, null);
        }
    }//GEN-LAST:event_ChitiethoadonMousePressed

    private void jTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTongTienActionPerformed

    private void DSHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DSHDKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            DSHDMouseClicked(null);
        }
    }//GEN-LAST:event_DSHDKeyReleased

    private void ChitiethoadonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ChitiethoadonKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            ChitiethoadonMouseClicked(null);
        }

    }//GEN-LAST:event_ChitiethoadonKeyReleased

    private void XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaActionPerformed
        // TODO add your handling code here:
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
        // TODO add your handling code here:
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
        // TODO add your handling code here:
        if (evt.getClickCount() == 1 && !evt.isConsumed()) {
            evt.consume();
            BangSP.setDefaultEditor(Object.class, null);
        }
    }//GEN-LAST:event_BangSPMousePressed

    private void GiaSPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GiaSPKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_GiaSPKeyPressed

    private void MaSPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MaSPKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (MaSP.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nhap thong tin tim kiem");
            } else {
                try {
                    Con = ClassData.ConnectDb();
                    String tk = MaSP.getText();
                    St = Con.createStatement();
                    Rs = St.executeQuery("Select * from banhang.Sanpham where `Mã Sản Phẩm` like '" + tk + "'");
                    BangSP.setModel(DbUtils.resultSetToTableModel((Rs)));
//                    DefaultTableModel model = (DefaultTableModel) BangSP.getModel();
//                    int Myindex = BangSP.getSelectedRow();
//                    GiaSP.setText(model.getValueAt(Myindex,4).toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }//GEN-LAST:event_MaSPKeyPressed

    private void MaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaKhachHangActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        new Events().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setState(1);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void tinhtrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tinhtrangActionPerformed
        // TODO add your handling code here:
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
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tinhtrangActionPerformed(null);
            jButton1ActionPerformed(null);
        }
    }//GEN-LAST:event_Timkiem2KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
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
        // TODO add your handling code here:
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
        // TODO add your handling code here:
        new Events().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        new Product().setVisible(true);
        this.dispose();
        if (role.getText() == "EMPLOYEE") {
            Product.it.setRole("EMPLOYEE");
        } else {
            Product.it.setRole("ADMIN");
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
        new Product().setVisible(true);
        this.dispose();
        if (role.getText() == "EMPLOYEE") {
            Product.it.setRole("EMPLOYEE");
        } else {
            Product.it.setRole("ADMIN");
        }
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
        new Customer().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
        new Customer().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel20MouseClicked

    private void DiemTichLuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiemTichLuyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiemTichLuyActionPerformed

    private void huyHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huyHDActionPerformed
        // TODO add your handling code here:
        setMaHD();
        MaKhachHang.setText("");
        tinhtrang.setSelectedIndex(0);
        jCheckBox1.setSelected(false);
        ghichu.setText("");
        Timkiem2.setText("");

    }//GEN-LAST:event_huyHDActionPerformed

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        jLabel1.setBackground(Color.RED);
        jLabel1.setForeground(Color.WHITE);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        jLabel1.setBackground(Color.WHITE);
        jLabel1.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
        jLabel2.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        // TODO add your handling code here:
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
        // TODO add your handling code here:
        if (role.getText() == "ADMIN") {
            new WellcomeScreen().setVisible(true);
        } else {
            new WellcomeScreenNV().setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

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
            java.util.logging.Logger.getLogger(Hoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hoadon().setVisible(true);
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
    private javax.swing.JLabel diemtichluy;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
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
