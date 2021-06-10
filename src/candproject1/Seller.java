/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candproject1;

import Data.ClassData;
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
public class Seller extends javax.swing.JFrame {

    /**
     * Creates new form Seller
     */
    public Seller() {
        initComponents();
        ChonNV();
        setMaNV();
        BangNV.setDefaultEditor(Object.class, null);
    }
    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;

    public void ChonNV() {

        DefaultTableModel model = new DefaultTableModel(new String[]{"Mã Nhân Viên", "Tên Nhân Viên", "Giới Tính", "Ngày Sinh", "Số CMND/CCCD", "SĐT", "Địa Chỉ", "Email", "Mức Lương", "Ngày Vào Làm"}, 0);
        Con = ClassData.ConnectDb();
        try {
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from banhang.Nhanvien");
            while (Rs.next()) {
                String a = Rs.getString("maNV");
                String b = Rs.getString("tenNV");
                String c = Rs.getString("gioitinhNV");
                String d = Rs.getString("ngaysinhNV");
                String e = Rs.getString("cmndNV");
                String f = Rs.getString("sdtNV");
                String g = Rs.getString("diachiNV");
                String h = Rs.getString("emailNV");
                String i = Rs.getString("luongNV");
                String j = Rs.getString("ngayvaoNV");
                model.addRow(new Object[]{a, b, c, d, e, f, g, h, i, j});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        BangNV.setModel(model);
    }

    void setMaNV() {
        Con = ClassData.ConnectDb();
        try {
            St = Con.createStatement();
            Rs = St.executeQuery("Select MAX(maNV) from banhang.Nhanvien");
            while (Rs.next()) {
                int a = Rs.getInt("MAX(maNV)");
                String masp = String.valueOf(a + 1);
                MaNV.setText(masp);
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
        MaNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TenNV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        NgaysinhNV = new javax.swing.JTextField();
        SdtNV = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        GioitinhNV = new javax.swing.JComboBox<>();
        Xoa = new javax.swing.JButton();
        Them = new javax.swing.JButton();
        Huy = new javax.swing.JButton();
        Sua = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        BangNV = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        DiachiNV = new javax.swing.JTextField();
        Timkiem = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Tim = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        SoNV = new javax.swing.JTextField();
        LuongNV = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        NgayvaoNV = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        EmailNV = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("dsdfsds");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1200, 700));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 85, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 606));
        jPanel1.setLayout(null);

        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 540));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 85, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("QUẢN LÝ NHÂN VIÊN");

        MaNV.setEditable(false);
        MaNV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 85, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Mã Nhân Viên");
        jLabel3.setMaximumSize(new java.awt.Dimension(87, 15));
        jLabel3.setMinimumSize(new java.awt.Dimension(87, 15));
        jLabel3.setPreferredSize(new java.awt.Dimension(87, 15));

        TenNV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 85, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Tên Nhân Viên");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 85, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Ngày Sinh");

        NgaysinhNV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        SdtNV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 85, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("SĐT");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 85, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Giới Tính");
        jLabel7.setToolTipText("");

        GioitinhNV.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        GioitinhNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác", " ", " " }));

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

        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        BangNV.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BangNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Giới Tính", "Ngày Sinh", "Số CMND/CCCD", "SĐT", "Địa Chỉ", "Email", "Mức Lương", "Ngày Vào Làm"
            }
        ));
        BangNV.setRowHeight(25);
        BangNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BangNVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(BangNV);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 85, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Danh Sách Nhân Viên");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 85, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Địa Chỉ");

        DiachiNV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

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

        jLabel15.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 85, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Số CMND/CCCD");

        SoNV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        LuongNV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 85, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Mức Lương");

        NgayvaoNV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 85, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Ngày Vào Làm");

        EmailNV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MaNV)
                            .addComponent(TenNV)
                            .addComponent(GioitinhNV, 0, 220, Short.MAX_VALUE)
                            .addComponent(SoNV)
                            .addComponent(EmailNV, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(107, 107, 107)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LuongNV, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NgayvaoNV, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SdtNV, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DiachiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NgaysinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(78, Short.MAX_VALUE))))
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
                                .addGap(10, 10, 10)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Huy, Sua, Them, Xoa});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NgaysinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SdtNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DiachiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LuongNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NgayvaoNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GioitinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SoNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32)
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
                    .addComponent(Tim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(Timkiem, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Huy, Sua, Them, Xoa});

        jPanel1.add(jPanel2);
        jPanel2.setBounds(157, 39, 1000, 622);

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
        jLabel23.setBounds(24, 427, 104, 90);

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
        jLabel27.setBounds(24, 523, 104, 28);

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
        jLabel22.setBounds(24, 283, 104, 92);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 204, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Khách Hàng");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel25);
        jLabel25.setBounds(24, 381, 104, 28);

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
        jLabel26.setBounds(24, 237, 104, 28);

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
        jLabel12.setBounds(24, 127, 104, 104);

        jLabel14.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Đăng Xuất");
        jLabel14.setMaximumSize(new java.awt.Dimension(87, 15));
        jLabel14.setMinimumSize(new java.awt.Dimension(87, 15));
        jLabel14.setPreferredSize(new java.awt.Dimension(87, 15));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14);
        jLabel14.setBounds(24, 639, 104, 30);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("_");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel2.setMaximumSize(new java.awt.Dimension(12, 19));
        jLabel2.setMinimumSize(new java.awt.Dimension(12, 19));
        jLabel2.setPreferredSize(new java.awt.Dimension(12, 19));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(1118, 1, 40, 27);

        jLabel1.setBackground(new java.awt.Color(102, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(102, 0, 0), new java.awt.Color(102, 0, 0), new java.awt.Color(102, 0, 0), new java.awt.Color(102, 0, 0)));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(1159, 1, 40, 27);

        jLabel28.setBackground(new java.awt.Color(0, 0, 0));
        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 204, 204));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("ADMIN");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel28);
        jLabel28.setBounds(15, 81, 132, 28);

        jLabel18.setBackground(new java.awt.Color(0, 140, 0));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home-iconnn.png"))); // NOI18N
        jLabel18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 0), 2, true));
        jLabel18.setOpaque(true);
        jPanel1.add(jLabel18);
        jLabel18.setBounds(0, 0, 49, 49);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1200, 700);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThemMouseClicked
        // TODO add your handling code here:
        if (MaNV.getText().isEmpty() || TenNV.getText().isEmpty()
                || NgaysinhNV.getText().isEmpty() || SoNV.getText().isEmpty()
                || SdtNV.getText().isEmpty() || DiachiNV.getText().isEmpty()
                || EmailNV.getText().isEmpty() || LuongNV.getText().isEmpty()
                || NgayvaoNV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập Thiếu Thông Tin!");
        } else {
            try {
                Con = ClassData.ConnectDb();
                int ketqua = JOptionPane.showConfirmDialog(this, "Thêm Nhân Viên?", "Chú ý", JOptionPane.YES_NO_OPTION);
                if (ketqua == JOptionPane.YES_OPTION) {
                    PreparedStatement add = Con.prepareStatement("insert into Nhanvien values(?,?,?,?,?,?,?,?,?,?)");
                    add.setInt(1, Integer.valueOf(MaNV.getText()));
                    add.setString(2, TenNV.getText());
                    add.setString(3, GioitinhNV.getSelectedItem().toString());
                    add.setString(4, NgaysinhNV.getText());
                    add.setString(5, SoNV.getText());
                    add.setString(6, SdtNV.getText());
                    add.setString(7, DiachiNV.getText());
                    add.setString(8, EmailNV.getText());
                    add.setString(9, LuongNV.getText());
                    add.setString(10, NgayvaoNV.getText());
                    int row = add.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Thêm Nhân Viên Thành Công!");
                    HuyMouseClicked(evt);
                    Con.close();
                    ChonNV();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_ThemMouseClicked

    private void BangNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangNVMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) BangNV.getModel();
        int Myindex = BangNV.getSelectedRow();
        MaNV.setText(model.getValueAt(Myindex, 0).toString());
        TenNV.setText(model.getValueAt(Myindex, 1).toString());
        GioitinhNV.setSelectedItem(model.getValueAt(Myindex, 2).toString());
        NgaysinhNV.setText(model.getValueAt(Myindex, 3).toString());
        SoNV.setText(model.getValueAt(Myindex, 4).toString());
        SdtNV.setText(model.getValueAt(Myindex, 5).toString());
        DiachiNV.setText(model.getValueAt(Myindex, 6).toString());
        EmailNV.setText(model.getValueAt(Myindex, 7).toString());
        LuongNV.setText(model.getValueAt(Myindex, 8).toString());
        NgayvaoNV.setText(model.getValueAt(Myindex, 9).toString());
    }//GEN-LAST:event_BangNVMouseClicked

    private void HuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HuyMouseClicked
        // TODO add your handling code here:
        setMaNV();
        TenNV.setText("");
        NgaysinhNV.setText("");
        SoNV.setText("");
        SdtNV.setText("");
        DiachiNV.setText("");
        EmailNV.setText("");
        LuongNV.setText("");
        NgayvaoNV.setText("");
        ChonNV();
    }//GEN-LAST:event_HuyMouseClicked

    private void XoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XoaMouseClicked
        // TODO add your handling code here:
        if (MaNV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chon nhan vien can xoa");
        } else {
            try {
                Con = ClassData.ConnectDb();
                int ketqua = JOptionPane.showConfirmDialog(this, "Xóa Nhân Viên?", "Chú ý", JOptionPane.YES_NO_OPTION);
                if (ketqua == JOptionPane.YES_OPTION) {
                    String Manv = MaNV.getText();
                    String Query = "Delete from banhang.Nhanvien where maNV =" + Manv;
                    Statement Add = Con.createStatement();
                    Add.executeUpdate(Query);
                    ChonNV();
                    JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công!");
                    HuyMouseClicked(evt);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_XoaMouseClicked

    private void SuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuaMouseClicked
        // TODO add your handling code here:
        if (MaNV.getText().isEmpty() && TenNV.getText().isEmpty()
                && NgaysinhNV.getText().isEmpty() && SoNV.getText().isEmpty()
                && SdtNV.getText().isEmpty() && DiachiNV.getText().isEmpty()
                && EmailNV.getText().isEmpty() && LuongNV.getText().isEmpty()
                && NgayvaoNV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hay chọn nhân viên cần sửa!");
        } else {
            try {
                Con = ClassData.ConnectDb();
                int ketqua = JOptionPane.showConfirmDialog(this, "Sửa Thông Tin Nhân Viên?", "Chú ý", JOptionPane.YES_NO_OPTION);
                if (ketqua == JOptionPane.YES_OPTION) {
                    String Query = "Update banhang.Nhanvien set tenNV='" + TenNV.getText() + "',"
                            + "                 gioitinhNV ='" + GioitinhNV.getSelectedItem().toString() + "',"
                            + "                 ngaysinhNV ='" + NgaysinhNV.getText() + "',"
                            + "                 cmndNV ='" + SoNV.getText() + "',"
                            + "                  sdtNV ='" + SdtNV.getText() + "',"
                            + "                  diachiNV ='" + DiachiNV.getText() + "'"
                            + "                  'emailNV' ='" + EmailNV.getText() + "',"
                            + "                  luongNV ='" + LuongNV.getText() + "',"
                            + "                  ngayvaoNV ='" + NgayvaoNV.getText() + "'"
                            + "                 where  maNV =" + MaNV.getText();
                    Statement Add = Con.createStatement();
                    Add.executeUpdate(Query);
                    JOptionPane.showMessageDialog(this, "Sửa Thông Tin Nhân Viên Thành Công!");
                    ChonNV();
                    HuyMouseClicked(evt);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_SuaMouseClicked

    private void TimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimActionPerformed
        if (Timkiem.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhap thong tin tim kiem");
        } else {
            DefaultTableModel model = new DefaultTableModel(new String[]{"Mã Nhân Viên", "Tên Nhân Viên", "Giới Tính", "Ngày Sinh", "Số CMND/CCCD", "SĐT", "Địa Chỉ", "Email", "Mức Lương", "Ngày Vào Làm"}, 0);

            try {
                Con = ClassData.ConnectDb();
                String tk = Timkiem.getText();
                St = Con.createStatement();
                Rs = St.executeQuery("Select * from banhang.Nhanvien where `maNV` like '%" + tk + "%' "
                        + "or `tenNV` like '%" + tk + "%' or `gioitinhNV` like '%" + tk + "%' "
                        + "or `ngaysinhNV` like '%" + tk + "%' or `cmndNV` like '%" + tk + "%' "
                        + "or sdtNV like '%" + tk + "%' or `diachiNV` like '%" + tk + "%' "
                        + "or `emailNV` like '%" + tk + "%'or `luongNV` like '%" + tk + "%'"
                        + "or `ngayvaoNV` like '%" + tk + "%'");
                while (Rs.next()) {
                    String a = Rs.getString("maNV");
                    String b = Rs.getString("tenNV");
                    String c = Rs.getString("gioitinhNV");
                    String d = Rs.getString("ngaysinhNV");
                    String e = Rs.getString("cmndNV");
                    String f = Rs.getString("sdtNV");
                    String g = Rs.getString("diachiNV");
                    String h = Rs.getString("emailNV");
                    String i = Rs.getString("luongNV");
                    String j = Rs.getString("ngayvaoNV");
                    model.addRow(new Object[]{a, b, c, d, e, f, g, h, i, j});
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            BangNV.setModel(model);
        }
    }//GEN-LAST:event_TimActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setState(1);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        new WellcomeScreen().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

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
        new Customer().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
        new Customer().setVisible(true);
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
            java.util.logging.Logger.getLogger(Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Seller().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BangNV;
    private javax.swing.JTextField DiachiNV;
    private javax.swing.JTextField EmailNV;
    private javax.swing.JComboBox<String> GioitinhNV;
    private javax.swing.JButton Huy;
    private javax.swing.JTextField LuongNV;
    private javax.swing.JTextField MaNV;
    private javax.swing.JTextField NgaysinhNV;
    private javax.swing.JTextField NgayvaoNV;
    private javax.swing.JTextField SdtNV;
    private javax.swing.JTextField SoNV;
    private javax.swing.JButton Sua;
    private javax.swing.JTextField TenNV;
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
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}
