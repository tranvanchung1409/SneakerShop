package candproject1;

import Data.ClassData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Customer extends javax.swing.JFrame {

    /**
     * Creates new form Customer
     */
    public Customer() {
        initComponents();
        ChonKH();
    }
  Connection Con = null;
  Statement St = null;
  ResultSet Rs = null;

        public void ChonKH() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Tên Khách Hàng", "Địa Chỉ", "SĐT", "Email", "Đơn Hàng", "Điểm Tích Lũy"}, 0);
        Con = ClassData.ConnectDb();
        try {
            String tk = TenKH.getText();
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from banhang.khachhang where `Tên Khách Hàng` like '" + tk + "'");
            while (Rs.next()) {
                String d = Rs.getString("Tên Khách Hàng");
                String e = Rs.getString("Địa Chỉ");              
                String f = Rs.getString("SĐT");
                String g = Rs.getString("Email");
                String h = Rs.getString("Đơn Hàng");
                String i = Rs.getString("Điểm Tích Lũy");
                model.addRow(new Object[]{d, e, f, g, h, i});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        BangKH.setModel(model);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        TenKH = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        DiachiKH = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        SdtKH = new javax.swing.JTextField();
        EmailKH = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        XoaKH = new javax.swing.JButton();
        ThemKH = new javax.swing.JButton();
        HuyKH = new javax.swing.JButton();
        SuaKH = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        BangKH = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        DiemKH = new javax.swing.JTextField();
        TimkiemKH = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        TimKH = new javax.swing.JButton();
        DonKH = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1200, 611));

        jPanel5.setBackground(new java.awt.Color(0, 85, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(1200, 606));

        jPanel6.setPreferredSize(new java.awt.Dimension(1000, 540));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 85, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("QUẢN LÝ KHÁCH HÀNG");

        TenKH.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 85, 0));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Tên Khách Hàng");
        jLabel22.setMaximumSize(new java.awt.Dimension(87, 15));
        jLabel22.setMinimumSize(new java.awt.Dimension(87, 15));
        jLabel22.setPreferredSize(new java.awt.Dimension(87, 15));

        DiachiKH.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 85, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Địa Chỉ");

        jLabel24.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 85, 0));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("SĐT");

        SdtKH.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        EmailKH.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 85, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Email");

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 85, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Đơn Hàng");
        jLabel26.setToolTipText("");

        XoaKH.setBackground(new java.awt.Color(110, 0, 0));
        XoaKH.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        XoaKH.setForeground(new java.awt.Color(255, 255, 255));
        XoaKH.setText("Xóa");
        XoaKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XoaKHMouseClicked(evt);
            }
        });

        ThemKH.setBackground(new java.awt.Color(0, 85, 0));
        ThemKH.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ThemKH.setForeground(new java.awt.Color(255, 255, 255));
        ThemKH.setText("Thêm");
        ThemKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThemKHMouseClicked(evt);
            }
        });
        ThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemKHActionPerformed(evt);
            }
        });

        HuyKH.setBackground(new java.awt.Color(0, 85, 0));
        HuyKH.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        HuyKH.setForeground(new java.awt.Color(255, 255, 255));
        HuyKH.setText("Hủy");
        HuyKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HuyKHMouseClicked(evt);
            }
        });

        SuaKH.setBackground(new java.awt.Color(0, 85, 0));
        SuaKH.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        SuaKH.setForeground(new java.awt.Color(255, 255, 255));
        SuaKH.setText("Sửa");
        SuaKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SuaKHMouseClicked(evt);
            }
        });

        jScrollPane4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        BangKH.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BangKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tên Khách Hàng", "Địa Chỉ", "Đơn Hàng", "SĐT", "Email", "Điểm Tích Lũy"
            }
        ));
        BangKH.setRowHeight(25);
        BangKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BangKHMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(BangKH);

        jLabel27.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 85, 0));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Danh Sách Khách Hàng");

        jLabel28.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 85, 0));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("Điểm Tích");

        DiemKH.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        TimkiemKH.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 153, 0));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N

        TimKH.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TimKH.setForeground(new java.awt.Color(0, 85, 0));
        TimKH.setText("Tìm Kiếm");
        TimKH.setPreferredSize(new java.awt.Dimension(85, 24));
        TimKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TimKHMouseClicked(evt);
            }
        });
        TimKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKHActionPerformed(evt);
            }
        });

        DonKH.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(ThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(SuaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
                        .addComponent(HuyKH, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(DiachiKH)
                            .addComponent(DonKH))
                        .addGap(110, 110, 110)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(EmailKH, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(546, 546, 546)
                        .addComponent(XoaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(TimkiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TimKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(381, 381, 381)
                .addComponent(jLabel21)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DonKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(DiachiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(EmailKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(DiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(HuyKH, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(XoaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SuaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TimKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(TimkiemKH, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("_");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Gabriola", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("CAND SNEAKER");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nv-icon.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 204, 204));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Nhân Viên");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sp-icon.png"))); // NOI18N

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 204, 204));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Sản Phẩm");

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hd-icon.png"))); // NOI18N

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 204, 204));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Hóa Đơn");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(350, 350, 350)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 50, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 6, Short.MAX_VALUE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void XoaKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XoaKHMouseClicked
        // TODO add your handling code here:
        if(TenKH.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Chon nhan vien can xoa");
        }
        else{
            try {
                Con = ClassData.ConnectDb();
                int ketqua = JOptionPane.showConfirmDialog(this, "Xóa Khách Hàng?","Chú ý",JOptionPane.YES_NO_OPTION);
                if(ketqua == JOptionPane.YES_OPTION){
                    String Tenkh = TenKH.getText();
                    String Query = "Delete from banhang.khachhang where `Tên Khách Hàng`="+Tenkh;
                    Statement Add = Con.createStatement();
                    Add.executeUpdate(Query);
                    ChonKH();
                    JOptionPane.showMessageDialog(this,"Xóa khách hàng thành công!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_XoaKHMouseClicked

    private void ThemKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThemKHMouseClicked
        // TODO add your handling code here:
        if(TenKH.getText().isEmpty()||DiachiKH.getText().isEmpty()||SdtKH.getText().isEmpty()||EmailKH.getText().isEmpty()||DonKH.getText().isEmpty()||DiemKH.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Nhập Thiếu Thông Tin!");
        }
        else{
            try {
                Con=ClassData.ConnectDb();
                int ketqua = JOptionPane.showConfirmDialog(this, "Thêm Khách Hàng?","Chú ý",JOptionPane.YES_NO_OPTION);
                if(ketqua == JOptionPane.YES_OPTION){
                    PreparedStatement add = Con.prepareStatement("insert into khachhang values(?,?,?,?,?,?)");
                    add.setString(1, TenKH.getText());
                    add.setString(2, DiachiKH.getText());
                    add.setString(3, SdtKH.getText());
                    add.setString(4, EmailKH.getText());
                    add.setString(5, DonKH.getText());
                    add.setInt(6, Integer.valueOf(DiemKH.getText()));
                    int row = add.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Thêm Khách Hàng Thành Công!");
                    Con.close();
                    ChonKH();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_ThemKHMouseClicked

    private void ThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThemKHActionPerformed

    private void HuyKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HuyKHMouseClicked
        // TODO add your handling code here:
        TenKH.setText("");
        DiachiKH.setText("");
        SdtKH.setText("");
        EmailKH.setText("");
        DonKH.setText("");
        DiemKH.setText("");
        ChonKH();
    }//GEN-LAST:event_HuyKHMouseClicked

    private void SuaKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuaKHMouseClicked
        // TODO add your handling code here:
        if(TenKH.getText().isEmpty()||DiachiKH.getText().isEmpty()||SdtKH.getText().isEmpty()||EmailKH.getText().isEmpty()||DonKH.getText().isEmpty()||DiemKH.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Hãy chọn khách hàng cần sửa!");
        }
        else{
            try {
                Con=ClassData.ConnectDb();
                int ketqua = JOptionPane.showConfirmDialog(this, "Sửa Thông Tin Khách Hàng?","Chú ý",JOptionPane.YES_NO_OPTION);
                if(ketqua == JOptionPane.YES_OPTION){
                    String Query="Update banhang.Khachhang set `Tên Khách Hàng`='"+TenKH.getText()+"',"
                    + "                 `Địa Chỉ`='"+DiachiKH.getText()+"',"
                    + "                 `SĐT`='"+SdtKH.getText()+"',"
                    + "                 `Địa Chỉ`='"+EmailKH.getText()+"'"
                    + "                 where `Tên Khách Hàng`="+TenKH.getText();
                    Statement Add = Con.createStatement();
                    Add.executeUpdate(Query);
                    JOptionPane.showMessageDialog(this,"Sửa Thông Tin Khách Hàng Thành Công!");
                    ChonKH();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_SuaKHMouseClicked

    private void BangKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangKHMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)BangKH.getModel();
        int Myindex = BangKH.getSelectedRow();
        TenKH.setText(model.getValueAt(Myindex,0).toString());
        DiachiKH.setText(model.getValueAt(Myindex,1).toString());
        SdtKH.setText(model.getValueAt(Myindex, 2).toString());
        EmailKH.setText(model.getValueAt(Myindex,3).toString());
        DonKH.setText(model.getValueAt(Myindex,4).toString());
        DiemKH.setText(model.getValueAt(Myindex,5).toString());
    }//GEN-LAST:event_BangKHMouseClicked

    private void TimKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimKHMouseClicked
        // TODO add your handling code here:
        if(TimkiemKH.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Nhap thong tin tim kiem");
        }
        else
        {
            try {
                Con=ClassData.ConnectDb();
                String tk = TimkiemKH.getText();
                St= Con.createStatement();
                Rs =St.executeQuery("Select * from banhang.Khachhang where `Tên Khách Hàng` like '%"+tk+"%' or `Địa Chỉ` like '%"+tk+"%' or `SĐT` like '%"+tk+"%' or `Email` like '%"+tk+"%' or `Đơn Hàng` like '%"+tk+"%' or `Điểm Tích Lũy` like '%"+tk+"%'");
                BangKH.setModel(DbUtils.resultSetToTableModel((Rs)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_TimKHMouseClicked

    private void TimKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimKHActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        this.setState(1);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        new Seller().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
    private javax.swing.JTextField DonKH;
    private javax.swing.JTextField EmailKH;
    private javax.swing.JButton HuyKH;
    private javax.swing.JTextField SdtKH;
    private javax.swing.JButton SuaKH;
    private javax.swing.JTextField TenKH;
    private javax.swing.JButton ThemKH;
    private javax.swing.JButton TimKH;
    private javax.swing.JTextField TimkiemKH;
    private javax.swing.JButton XoaKH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
