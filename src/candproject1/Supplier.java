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
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ADMIN
 */
public class Supplier extends javax.swing.JFrame {

    /**
     * Creates new form Seller
     */
    public Supplier() {
        initComponents();
        ChonKH();
        setMaKH();
        BangKH.setDefaultEditor(Object.class, null);
        it = this;
//        getData();
    }
    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
    public static Supplier it;
    
    public void setRole(String Role) { // Set tên cho của sổ này
        role.setText(Role);
    }

//Lấy Mail
    public String getData() {
        String r = null;
        ResultSet result = null;
        Con = ClassData.ConnectDb();
        try {
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from banhang.Khachhang");
            while (Rs.next()) {
                String e = Rs.getString("emailKH");
                r = e + ",";
                
              //  System.out.println(r);
             
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
       
        

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
                MaNCC.setText(masp);
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
        MaNCC = new javax.swing.JTextField();
        maKH = new javax.swing.JLabel();
        TenNCC = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        SdtNCC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Xoa = new javax.swing.JButton();
        Them = new javax.swing.JButton();
        Huy = new javax.swing.JButton();
        Sua = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        BangKH = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        DiachiNCC = new javax.swing.JTextField();
        Timkiem = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Tim = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        EmailNCC = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 85, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 606));
        jPanel1.setLayout(null);

        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 540));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 85, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("QUẢN LÝ NHÀ CUNG CẤP");

        MaNCC.setEditable(false);
        MaNCC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        maKH.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        maKH.setForeground(new java.awt.Color(0, 85, 0));
        maKH.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        maKH.setText("Mã Nhà Cung Cấp");
        maKH.setMaximumSize(new java.awt.Dimension(87, 15));
        maKH.setMinimumSize(new java.awt.Dimension(87, 15));
        maKH.setPreferredSize(new java.awt.Dimension(87, 15));

        TenNCC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 85, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Tên Nhà Cung Cấp");

        SdtNCC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

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
        jLabel11.setText("Danh Sách Nhà Cung Cấp");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 85, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("SĐT");

        DiachiNCC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

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

        EmailNCC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jButton1.setText("Lấy Maiil");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(546, 546, 546)
                        .addComponent(Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addComponent(jButton1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel11)))))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
                        .addComponent(Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EmailNCC)
                            .addComponent(TenNCC)
                            .addComponent(MaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SdtNCC, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(DiachiNCC))
                        .addGap(84, 84, 84))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Huy, Sua, Them, Xoa});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {DiachiNCC, EmailNCC, SdtNCC});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EmailNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DiachiNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SdtNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(63, 63, 63)
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1))
                    .addComponent(Timkiem, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Huy, Sua, Them, Xoa});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {DiachiNCC, EmailNCC, MaNCC, SdtNCC, TenNCC});

        jPanel1.add(jPanel2);
        jPanel2.setBounds(157, 46, 1000, 630);

        jLabel23.setBackground(new java.awt.Color(0, 60, 0));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hd-icon.png"))); // NOI18N
        jLabel23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(155, 155, 0), 2, true));
        jLabel23.setOpaque(true);
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel23);
        jLabel23.setBounds(24, 434, 104, 90);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 204, 0));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Hóa Đơn");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel27);
        jLabel27.setBounds(24, 530, 104, 28);

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
        jPanel1.add(jLabel22);
        jLabel22.setBounds(24, 282, 104, 100);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 204, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Sự Kiện");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel25);
        jLabel25.setBounds(24, 388, 104, 28);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 204, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Sản Phẩm");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel26);
        jLabel26.setBounds(24, 244, 104, 28);

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
        jPanel1.add(jLabel12);
        jLabel12.setBounds(24, 134, 104, 104);

        jLoguot.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLoguot.setForeground(new java.awt.Color(255, 255, 255));
        jLoguot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLoguot.setText("Đăng Xuất");
        jLoguot.setToolTipText("");
        jLoguot.setMaximumSize(new java.awt.Dimension(87, 15));
        jLoguot.setMinimumSize(new java.awt.Dimension(87, 15));
        jLoguot.setPreferredSize(new java.awt.Dimension(87, 15));
        jLoguot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLoguotMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLoguotMouseEntered(evt);
            }
        });
        jPanel1.add(jLoguot);
        jLoguot.setBounds(24, 646, 104, 30);

        role.setBackground(new java.awt.Color(0, 0, 0));
        role.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        role.setForeground(new java.awt.Color(255, 204, 204));
        role.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        role.setText("ADMIN");
        role.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roleMouseClicked(evt);
            }
        });
        jPanel1.add(role);
        role.setBounds(15, 88, 132, 28);

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

        jLabel14.setBackground(new java.awt.Color(0, 140, 0));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home-iconnn.png"))); // NOI18N
        jLabel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 0), 2, true));
        jLabel14.setOpaque(true);
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14);
        jLabel14.setBounds(0, 0, 49, 49);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1200, 700);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThemMouseClicked
        // TODO add your handling code here:
        if (MaNCC.getText().isEmpty() || TenNCC.getText().isEmpty()
                || SdtNCC.getText().isEmpty() || DiachiNCC.getText().isEmpty()
                || EmailNCC.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Nhập Thiếu Thông Tin!");
        } else {
            try {
                Con = ClassData.ConnectDb();
                int ketqua = JOptionPane.showConfirmDialog(this, "Thêm Khách Hàng?", "Chú ý", JOptionPane.YES_NO_OPTION);
                if (ketqua == JOptionPane.YES_OPTION) {
                    PreparedStatement add = Con.prepareStatement("insert into Khachhang values(?,?,?,?,?)");
                    add.setInt(1, Integer.valueOf(MaNCC.getText()));
                    add.setString(2, TenNCC.getText());
                    add.setString(3, DiachiNCC.getText());
                    add.setString(4, SdtNCC.getText());
                    add.setString(5, EmailNCC.getText());
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
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) BangKH.getModel();
        int Myindex = BangKH.getSelectedRow();
//        MaNCC.setText(model.getValueAt(Myindex, 0).toString());
//        TenNCC.setText(model.getValueAt(Myindex, 1).toString());
//        DiachiNCC.setText(model.getValueAt(Myindex, 2).toString());
//        SdtNCC.setText(model.getValueAt(Myindex, 3).toString());
//        EmailKH.setText(model.getValueAt(Myindex, 4).toString());
//        DiemKH.setText(model.getValueAt(Myindex, 5).toString());
        try {
            Con = ClassData.ConnectDb();
            String tk = Timkiem.getText();
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from banhang.Nhacungcap where `maKH` like '" + model.getValueAt(Myindex, 0).toString() + "' ");
            while (Rs.next()) {
                MaNCC.setText(Rs.getString("maNCC"));
                TenNCC.setText(Rs.getString("tenNCC"));
                DiachiNCC.setText(Rs.getString("diachiNCC"));
                SdtNCC.setText(Rs.getString("sdtNCC"));
                EmailNCC.setText(Rs.getString("emailNCC"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BangKHMouseClicked

    private void HuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HuyMouseClicked
        // TODO add your handling code here:
        setMaKH();
        TenNCC.setText("");
        DiachiNCC.setText("");
        SdtNCC.setText("");
        EmailNCC.setText("");

//        ChonNCC();
    }//GEN-LAST:event_HuyMouseClicked

    private void XoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XoaMouseClicked
        // TODO add your handling code here:
        if (MaNCC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chọn Nhà Cung Cấp Cần Xóa!");
        } else {
            try {
                Con = ClassData.ConnectDb();
                int ketqua = JOptionPane.showConfirmDialog(this, "Xóa Nhà Cung Cấp?", "Chú ý", JOptionPane.YES_NO_OPTION);
                if (ketqua == JOptionPane.YES_OPTION) {
                    String Mancc = MaNCC.getText();
                    String Query = "Delete from banhang.Nhacungcap where maNCC =" + Mancc;
                    Statement Add = Con.createStatement();
                    Add.executeUpdate(Query);
                    ChonKH();
                    JOptionPane.showMessageDialog(this, "Xóa Nhà Cung Cấp Thành Công!");
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
            DefaultTableModel model = new DefaultTableModel(new String[]{"Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Địa Chỉ", "SĐT", "Email"}, 0);

            try {
                Con = ClassData.ConnectDb();
                String tk = Timkiem.getText();
                St = Con.createStatement();
                Rs = St.executeQuery("Select * from banhang.Nhacungcap where `maNcc` like '%" + tk + "%' "
                        + "or `tenNCC` like '%" + tk + "%' or `diachiNCC` like '%" + tk + "%' "
                        + "or `sdtNCC` like '%" + tk + "%' or `emailNCC` like '%" + tk + "%' ");         
                while (Rs.next()) {
                    String a = Rs.getString("maNCC");
                    String b = Rs.getString("tenNCC");
                    String c = Rs.getString("diachiNCC");
                    String d = Rs.getString("sdtNCC");
                    String e = Rs.getString("emailNCC");
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

    private void roleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roleMouseClicked
        new WellcomeScreen().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_roleMouseClicked

    private void jLoguotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLoguotMouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLoguotMouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        new Product().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        new Product().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
        new Events().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
        new Events().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
        new Hoadon().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        // TODO add your handling code here:
        new Hoadon().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel27MouseClicked

    private void TimkiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TimkiemKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            TimActionPerformed(null);
        }
    }//GEN-LAST:event_TimkiemKeyPressed

    private void jLoguotMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLoguotMouseEntered
        // TODO add your handling code here:
        // jLoguot.setText("<html><u>Đăng Xuất</u>");
    }//GEN-LAST:event_jLoguotMouseEntered

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setState(1);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
        jLabel2.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        // TODO add your handling code here:
        jLabel2.setBackground(Color.WHITE);
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

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

    private void BangKHMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangKHMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            new HoaDonKH().setVisible(true);
        }
    }//GEN-LAST:event_BangKHMousePressed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        if (role.getText() == "ADMIN") {
            new WellcomeScreen().setVisible(true);
        } else {
            new WellcomeScreenNV().setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.out.println(getData());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaActionPerformed
//        if (MaNCC.getText().isEmpty() && TenNCC.getText().isEmpty()
//                && PhanhoiKH.getText().isEmpty()
//                && SdtNCC.getText().isEmpty() && DiachiNCC.getText().isEmpty()
//                && EmailNCC.getText().isEmpty() && DiemKH.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Hay Chọn Khách Hàng Cần Sửa!");
//        } else {
//            try {
//                Con = ClassData.ConnectDb();
//                int ketqua = JOptionPane.showConfirmDialog(this, "Sửa Thông Tin Khách Hàng?", "Chú ý", JOptionPane.YES_NO_OPTION);
//                if (ketqua == JOptionPane.YES_OPTION) {
//                    String Query = "Update banhang.Khachhang set tenKH='" + TenNCC.getText() + "',"
//                            + "                 phanhoiKH ='" + PhanhoiKH.getText() + "',"
//                            + "                  sdtKH ='" + SdtNCC.getText() + "',"
//                            + "                  diachiKH ='" + DiachiNCC.getText() + "'"
//                            + "                  'emailKH' = '" + EmailNCC.getText() + "',"
//                            + "                  diemKH ='" + DiemKH.getText() + "'where  maKH =" + MaNCC.getText();
//
//                    Statement Add = Con.createStatement();
//                    Add.executeUpdate(Query);
//                    JOptionPane.showMessageDialog(this, "Sửa Thông Tin Khách Hàng Thành Công!");
//                    ChonKH();
//                    HuyMouseClicked(null);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }//GEN-LAST:event_SuaActionPerformed

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
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BangKH;
    private javax.swing.JTextField DiachiNCC;
    private javax.swing.JTextField EmailNCC;
    private javax.swing.JButton Huy;
    private javax.swing.JTextField MaNCC;
    private javax.swing.JTextField SdtNCC;
    private javax.swing.JButton Sua;
    private javax.swing.JTextField TenNCC;
    private javax.swing.JButton Them;
    private javax.swing.JButton Tim;
    private javax.swing.JTextField Timkiem;
    private javax.swing.JButton Xoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel4;
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
