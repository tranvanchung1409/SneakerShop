/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candproject1;

import Data.ClassData;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class Customer extends javax.swing.JFrame {

    /**
     * Creates new form Seller
     */
    public Customer() {
        initComponents();
        ChonKH();
        setMaKH();
        BangKH.setDefaultEditor(Object.class, null);
        it = this;
    }

    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;

    int mousepX;
    int mousepY;

    public static Customer it;

    public void setRole(String Role) { // Set tên cho của sổ này
        role.setText(Role);
    }

//show bảng
    public void ChonKH() {

        DefaultTableModel model = new DefaultTableModel(new String[]{"Mã Khách Hàng", "Tên Khách Hàng", "Địa Chỉ", "SĐT", "Email", "Điểm Tích Lũy", "Phản Hồi"}, 0);
        Con = ClassData.ConnectDb();
        try {
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from banhang.Khachhang");
            while (Rs.next()) {
                String a = Rs.getString("maKH");
                String b = Rs.getString("tenKH");
                String c = Rs.getString("diachiKH");
                String d = Rs.getString("sdtKH");
                String e = Rs.getString("emailKH");
                String f = Rs.getString("diemKH");
                String g = Rs.getString("phanhoiKH");
                model.addRow(new Object[]{a, b, c, d, e, f, g});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        BangKH.setModel(model);
    }

    void setMaKH() {
        Con = ClassData.ConnectDb();
        try {
            St = Con.createStatement();
            Rs = St.executeQuery("Select MAX(maKH) from banhang.Khachhang");
            while (Rs.next()) {
                int a = Rs.getInt("MAX(maKH)");
                String masp = String.valueOf(a + 1);
                MaKH.setText(masp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        MaKH = new javax.swing.JTextField();
        maKH = new javax.swing.JLabel();
        TenKH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PhanhoiKH = new javax.swing.JTextField();
        SdtKH = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Xoa = new javax.swing.JButton();
        Them = new javax.swing.JButton();
        Huy = new javax.swing.JButton();
        Sua = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        BangKH = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        DiachiKH = new javax.swing.JTextField();
        Timkiem = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Tim = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        DiemKH = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        EmailKH = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLoguot = new javax.swing.JLabel();
        role = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1200, 700));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 85, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 606));

        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 540));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 85, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("QUẢN LÝ KHÁCH HÀNG");

        MaKH.setEditable(false);
        MaKH.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        maKH.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        maKH.setForeground(new java.awt.Color(0, 85, 0));
        maKH.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        maKH.setText("Mã Khách Hàng");
        maKH.setMaximumSize(new java.awt.Dimension(87, 15));
        maKH.setMinimumSize(new java.awt.Dimension(87, 15));
        maKH.setPreferredSize(new java.awt.Dimension(87, 15));

        TenKH.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 85, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Tên Khách Hàng");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 85, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Phản Hồi");

        PhanhoiKH.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        SdtKH.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 85, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Địa Chỉ");

        Xoa.setBackground(new java.awt.Color(110, 0, 0));
        Xoa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Xoa.setForeground(new java.awt.Color(255, 255, 255));
        Xoa.setText("Xóa");
        Xoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XoaMouseClicked(evt);
            }
        });

        Them.setBackground(new java.awt.Color(0, 85, 0));
        Them.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Them.setForeground(new java.awt.Color(255, 255, 255));
        Them.setText("Thêm");
        Them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThemMouseClicked(evt);
            }
        });

        Huy.setBackground(new java.awt.Color(0, 85, 0));
        Huy.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Huy.setForeground(new java.awt.Color(255, 255, 255));
        Huy.setText("Hủy");
        Huy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HuyMouseClicked(evt);
            }
        });

        Sua.setBackground(new java.awt.Color(0, 85, 0));
        Sua.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Sua.setForeground(new java.awt.Color(255, 255, 255));
        Sua.setText("Sửa");
        Sua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SuaMouseClicked(evt);
            }
        });
        Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaActionPerformed(evt);
            }
        });

        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        BangKH.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BangKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Khách Hàng", "Tên Khách Hàng", "Địa Chỉ", "SĐT", "Email", "Điểm Tích Lũy", "Phản Hồi"
            }
        ));
        BangKH.setRowHeight(25);
        BangKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BangKHMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BangKHMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(BangKH);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 85, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Danh Sách Khách Hàng");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 85, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("SĐT");

        DiachiKH.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        Timkiem.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Timkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TimkiemKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N

        Tim.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Tim.setForeground(new java.awt.Color(0, 85, 0));
        Tim.setText("Tìm Kiếm");
        Tim.setPreferredSize(new java.awt.Dimension(85, 24));
        Tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 85, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Email");
        jLabel13.setToolTipText("");

        DiemKH.setEditable(false);
        DiemKH.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        DiemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiemKHActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 85, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Điểm Tích Lũy");

        EmailKH.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(546, 546, 546)
                        .addComponent(Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(324, 324, 324))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(375, 375, 375)
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(maKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MaKH)
                            .addComponent(EmailKH)
                            .addComponent(DiemKH)
                            .addComponent(TenKH))
                        .addGap(95, 95, 95)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SdtKH, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(PhanhoiKH)
                            .addComponent(DiachiKH))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Huy, Sua, Them, Xoa});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {DiachiKH, DiemKH, EmailKH, MaKH, PhanhoiKH, SdtKH});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DiachiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EmailKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addComponent(PhanhoiKH))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Timkiem, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Huy, Sua, Them, Xoa});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {DiachiKH, DiemKH, EmailKH, MaKH, SdtKH, TenKH});

        jLabel23.setBackground(new java.awt.Color(0, 60, 0));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hd-icon.png"))); // NOI18N
        jLabel23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(155, 155, 0), 2, true));
        jLabel23.setOpaque(true);
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 204, 0));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Hóa Đơn");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(0, 60, 0));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/events-icon.png"))); // NOI18N
        jLabel22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(155, 155, 0), 2, true));
        jLabel22.setOpaque(true);
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 204, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Sự Kiện");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 204, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Sản Phẩm");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(0, 60, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sp-icon.png"))); // NOI18N
        jLabel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(155, 155, 0), 2, true));
        jLabel12.setOpaque(true);
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLoguot.setBackground(new java.awt.Color(102, 102, 102));
        jLoguot.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLoguot.setForeground(new java.awt.Color(255, 255, 255));
        jLoguot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLoguot.setText("Đăng Xuất");
        jLoguot.setToolTipText("");
        jLoguot.setMaximumSize(new java.awt.Dimension(87, 15));
        jLoguot.setMinimumSize(new java.awt.Dimension(87, 15));
        jLoguot.setOpaque(true);
        jLoguot.setPreferredSize(new java.awt.Dimension(87, 15));
        jLoguot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLoguotMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLoguotMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLoguotMouseExited(evt);
            }
        });

        role.setBackground(new java.awt.Color(0, 51, 51));
        role.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        role.setForeground(new java.awt.Color(255, 204, 204));
        role.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        role.setText("ADMIN");
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

        jLabel14.setBackground(new java.awt.Color(0, 140, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home-iconnn.png"))); // NOI18N
        jLabel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 0), 2, true));
        jLabel14.setOpaque(true);
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(0, 60, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/NCC-icon.png"))); // NOI18N
        jLabel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(155, 155, 0), 2, true));
        jLabel15.setOpaque(true);
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(204, 204, 0));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Nhà Cung Cấp");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLoguot, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(role, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel12, jLabel15, jLabel22, jLabel23});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLoguot, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(role, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel12, jLabel15, jLabel22, jLabel23});

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1200, 700);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThemMouseClicked
        if (MaKH.getText().isEmpty() || TenKH.getText().isEmpty()
                || PhanhoiKH.getText().isEmpty()
                || SdtKH.getText().isEmpty() || DiachiKH.getText().isEmpty()
                || EmailKH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập Thiếu Thông Tin!");
        } else {
            try {
                Con = ClassData.ConnectDb();
                int ketqua = JOptionPane.showConfirmDialog(this, "Thêm Khách Hàng?", "Chú ý", JOptionPane.YES_NO_OPTION);
                if (ketqua == JOptionPane.YES_OPTION) {
                    PreparedStatement add = Con.prepareStatement("insert into Khachhang values(?,?,?,?,?,?,?)");
                    add.setInt(1, Integer.valueOf(MaKH.getText()));
                    add.setString(2, TenKH.getText());
                    add.setString(3, DiachiKH.getText());
                    add.setString(4, SdtKH.getText());
                    add.setString(5, EmailKH.getText());
                    add.setString(6, "0");
                    add.setString(7, PhanhoiKH.getText());
                    int row = add.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Thêm Khách Hàng Thành Công!");
                    HuyMouseClicked(evt);
                    Con.close();
                    ChonKH();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_ThemMouseClicked

    private void BangKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangKHMouseClicked
        DefaultTableModel model = (DefaultTableModel) BangKH.getModel();
        int Myindex = BangKH.getSelectedRow();
        try {
            Con = ClassData.ConnectDb();
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from banhang.Khachhang where `maKH` like '" + model.getValueAt(Myindex, 0).toString() + "' ");
            while (Rs.next()) {
                MaKH.setText(Rs.getString("maKH"));
                TenKH.setText(Rs.getString("tenKH"));
                DiachiKH.setText(Rs.getString("diachiKH"));
                SdtKH.setText(Rs.getString("sdtKH"));
                EmailKH.setText(Rs.getString("emailKH"));
                DiemKH.setText(Rs.getString("diemKH"));
                PhanhoiKH.setText(Rs.getString("phanhoiKH"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BangKHMouseClicked

    private void HuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HuyMouseClicked
        setMaKH();
        TenKH.setText("");
        DiachiKH.setText("");
        SdtKH.setText("");
        EmailKH.setText("");
        DiemKH.setText("");
        PhanhoiKH.setText("");
        ChonKH();
    }//GEN-LAST:event_HuyMouseClicked

    private void XoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XoaMouseClicked
        if (MaKH.getText().isEmpty() || TenKH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chọn Khách Hàng Cần Xóa!");
        } else {
            try {
                Con = ClassData.ConnectDb();
                int ketqua = JOptionPane.showConfirmDialog(this, "Xóa Khách Hàng?", "Chú ý", JOptionPane.YES_NO_OPTION);
                if (ketqua == JOptionPane.YES_OPTION) {
                    String Makh = MaKH.getText();
                    String Query = "Delete from banhang.Khachhang Where maKH =" + Makh;
                    Statement Add = Con.createStatement();
                    Add.executeUpdate(Query);
                    ChonKH();
                    JOptionPane.showMessageDialog(this, "Xóa Khách Hàng Thành Công!");
                    HuyMouseClicked(evt);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_XoaMouseClicked

    private void SuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SuaMouseClicked

    private void TimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimActionPerformed
        if (Timkiem.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập Thông Tin Tìm Kiếm");
        } else {
            DefaultTableModel model = new DefaultTableModel(new String[]{"Mã Khách Hàng", "Tên Khách Hàng", "Địa Chỉ", "SĐT", "Email", "Điểm Tích Lũy", "Phản Hồi"}, 0);

            try {
                Con = ClassData.ConnectDb();
                String tk = Timkiem.getText();
                St = Con.createStatement();
                Rs = St.executeQuery("Select * from banhang.Khachhang where `maKH` like '%" + tk + "%' "
                        + "or `tenKH` like '%" + tk + "%' or `diachiKH` like '%" + tk + "%' "
                        + "or `sdtKH` like '%" + tk + "%' or `emailKH` like '%" + tk + "%' "
                        + "or diemKH like '%" + tk + "%' or `phanhoiKH` like '%" + tk + "%' ");
                while (Rs.next()) {
                    String a = Rs.getString("maKH");
                    String b = Rs.getString("tenKH");
                    String c = Rs.getString("diachiKH");
                    String d = Rs.getString("sdtKH");
                    String e = Rs.getString("emailKH");
                    String f = Rs.getString("diemKH");
                    String g = Rs.getString("phanhoiKH");
                    model.addRow(new Object[]{a, b, c, d, e, f, g});
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            BangKH.setModel(model);
        }
    }//GEN-LAST:event_TimActionPerformed

    private void jLoguotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLoguotMouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLoguotMouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        new Product().setVisible(true);
        this.dispose();
        if (role.getText() == "EMPLOYEE") {
            Product.it.setRole("EMPLOYEE");
        } else {
            Product.it.setRole("ADMIN");
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        new Product().setVisible(true);
        this.dispose();
        if (role.getText() == "EMPLOYEE") {
            Product.it.setRole("EMPLOYEE");
        } else {
            Product.it.setRole("ADMIN");
        }
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        new Event().setVisible(true);
        if (role.getText() == "EMPLOYEE") {
            Event.it.setRole("EMPLOYEE");
        } else {
            Event.it.setRole("ADMIN");
        }
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        new Event().setVisible(true);
        if (role.getText() == "EMPLOYEE") {
            Event.it.setRole("EMPLOYEE");
        } else {
            Event.it.setRole("ADMIN");
        }
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        new Bill().setVisible(true);
        if (role.getText() == "EMPLOYEE") {
            Bill.it.setRole("EMPLOYEE");
        } else {
            Bill.it.setRole("ADMIN");
        }
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        // TODO add your handling code here:
        new Bill().setVisible(true);
        if (role.getText() == "EMPLOYEE") {
            Bill.it.setRole("EMPLOYEE");
        } else {
            Bill.it.setRole("ADMIN");
        }
    }//GEN-LAST:event_jLabel27MouseClicked

    private void TimkiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TimkiemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            TimActionPerformed(null);
        }
    }//GEN-LAST:event_TimkiemKeyPressed

    private void jLoguotMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLoguotMouseEntered
        jLoguot.setText("<html><u>Đăng Xuất</u>");
    }//GEN-LAST:event_jLoguotMouseEntered

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setState(1);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setBackground(Color.WHITE);
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        jLabel1.setBackground(Color.RED);
        jLabel1.setForeground(Color.WHITE);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        jLabel1.setBackground(Color.WHITE);
        jLabel1.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel1MouseExited

    private void BangKHMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangKHMousePressed
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            new Supplier().setVisible(true);
        }
    }//GEN-LAST:event_BangKHMousePressed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        if (role.getText() == "ADMIN") {
            new WellcomeScreen().setVisible(true);
        } else {
            new WellcomeScreenNV().setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaActionPerformed
        if (TenKH.getText().isEmpty()
                && PhanhoiKH.getText().isEmpty()
                && SdtKH.getText().isEmpty() && DiachiKH.getText().isEmpty()
                && EmailKH.getText().isEmpty() && DiemKH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hay Chọn Khách Hàng Cần Sửa!");
        } else {
            try {
                Con = ClassData.ConnectDb();
                int ketqua = JOptionPane.showConfirmDialog(this, "Sửa Thông Tin Khách Hàng?", "Chú ý", JOptionPane.YES_NO_OPTION);
                if (ketqua == JOptionPane.YES_OPTION) {
                    String Query = "Update banhang.Khachhang set tenKH='" + TenKH.getText() + "',"
                            + "                 phanhoiKH ='" + PhanhoiKH.getText() + "',"
                            + "                  sdtKH ='" + SdtKH.getText() + "',"
                            + "                 diachiKH ='" + DiachiKH.getText() + "',"
                            + "                 emailKH ='" + EmailKH.getText() + "',"
                            + "                  diemKH ='" + DiemKH.getText() + "'where  maKH =" + MaKH.getText();

                    Statement Add = Con.createStatement();
                    Add.executeUpdate(Query);
                    JOptionPane.showMessageDialog(this, "Sửa Thông Tin Khách Hàng Thành Công!");
                    ChonKH();
                    HuyMouseClicked(null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_SuaActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        new Supplier().setVisible(true);
        this.dispose();
        if (role.getText() == "EMPLOYEE") {
            Supplier.it.setRole("EMPLOYEE");
        } else {
            Supplier.it.setRole("ADMIN");
        }
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        new Supplier().setVisible(true);
        this.dispose();
        if (role.getText() == "EMPLOYEE") {
            Supplier.it.setRole("EMPLOYEE");
        } else {
            Supplier.it.setRole("ADMIN");
        }
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLoguotMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLoguotMouseExited
        jLoguot.setText("Đăng Xuất");
    }//GEN-LAST:event_jLoguotMouseExited

    private void roleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roleMousePressed
        mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_roleMousePressed

    private void roleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roleMouseDragged
        int kordinatX = evt.getXOnScreen();
        int kordinatY = evt.getYOnScreen();

        this.setLocation(kordinatX - mousepX, kordinatY - mousepY);
    }//GEN-LAST:event_roleMouseDragged

    private void DiemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiemKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiemKHActionPerformed

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
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BangKH;
    private javax.swing.JTextField DiachiKH;
    private javax.swing.JTextField DiemKH;
    private javax.swing.JTextField EmailKH;
    private javax.swing.JButton Huy;
    private javax.swing.JTextField MaKH;
    private javax.swing.JTextField PhanhoiKH;
    private javax.swing.JTextField SdtKH;
    private javax.swing.JButton Sua;
    private javax.swing.JTextField TenKH;
    private javax.swing.JButton Them;
    private javax.swing.JButton Tim;
    private javax.swing.JTextField Timkiem;
    private javax.swing.JButton Xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLoguot;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel maKH;
    private javax.swing.JLabel role;
    // End of variables declaration//GEN-END:variables

}
