/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controller.Gestor;
import Controller.generatePDF;
import Styles.*;
import static Styles.Colors.*;
import TypeData.User;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author erick
 */
public class menu extends javax.swing.JFrame {
    User usuario = new User();
    Gestor gs = new Gestor();
    /**
     * Creates new form menu
     */
    public menu() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public menu(User user) {
        initComponents();
        setLocationRelativeTo(null);
        this.usuario = user;
        getData();
        
        title.setText("Bienvenido " + user.getUser());
        balance.setText("USD$ " + user.getPatrimonio());
    }
    
    public static boolean isValidDate(String inputDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(inputDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    public static double convertToDouble(String decimalStr) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.getDefault());
        double result = 0.0;
        
        try {
            result += numberFormat.parse(decimalStr).doubleValue();
        } catch (ParseException e) {
            System.out.println("Error al convertir la cadena a double.");
        }
        
        return result;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMovimientos = new javax.swing.JTable();
        title = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        txtDescBack = new Styles.PanelRound();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        txtMontoBack = new Styles.PanelRound();
        txtMonto = new javax.swing.JTextField();
        labelFecha = new javax.swing.JLabel();
        btnDateBack = new Styles.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        txtDay = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtMonth = new javax.swing.JTextField();
        txtYear = new javax.swing.JTextField();
        btnDeleteBack = new Styles.PanelRound();
        btnSaveEliminar = new javax.swing.JLabel();
        btnSaveIngresoBack = new Styles.PanelRound();
        btnSaveIngreso = new javax.swing.JLabel();
        btnSaveEgresoBack = new Styles.PanelRound();
        btnSaveEgreso = new javax.swing.JLabel();
        btnEditBack = new Styles.PanelRound();
        btnSaveEditar = new javax.swing.JLabel();
        btnPDFBack = new Styles.PanelRound();
        btnPDF = new javax.swing.JLabel();
        labelPDF = new javax.swing.JLabel();
        labelMonto = new javax.swing.JLabel();
        labelFecha1 = new javax.swing.JLabel();
        labelFecha2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(720, 420));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(c_white);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(c_white);
        jScrollPane1.setBorder(null);

        tblMovimientos.setBackground(c_white);
        tblMovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTableHeader header = tblMovimientos.getTableHeader();
        header.setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblMovimientos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 112, -1, 360));

        title.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 27)); // NOI18N
        title.setForeground(c_greenDark);
        title.setText("Bienvenido USUARIO");
        jPanel1.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        balance.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 1, 18)); // NOI18N
        balance.setForeground(c_greenLight);
        balance.setText("USD$9999999999");
        jPanel1.add(balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 190, 30));

        txtDescBack.setBackground(c_graylight);
        txtDescBack.setRoundBottomLeft(15);
        txtDescBack.setRoundBottomRight(15);
        txtDescBack.setRoundTopLeft(15);
        txtDescBack.setRoundTopRight(15);

        jScrollPane2.setBorder(null);

        txtDesc.setBackground(c_graylight);
        txtDesc.setColumns(15);
        txtDesc.setFont(new java.awt.Font("Plus Jakarta Sans", 0, 14)); // NOI18N
        txtDesc.setForeground(c_black);
        txtDesc.setRows(3);
        txtDesc.setBorder(null);
        jScrollPane2.setViewportView(txtDesc);

        javax.swing.GroupLayout txtDescBackLayout = new javax.swing.GroupLayout(txtDescBack);
        txtDescBack.setLayout(txtDescBackLayout);
        txtDescBackLayout.setHorizontalGroup(
            txtDescBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtDescBackLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        txtDescBackLayout.setVerticalGroup(
            txtDescBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtDescBackLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel1.add(txtDescBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 240, 100));

        txtMontoBack.setBackground(c_graylight);
        txtMontoBack.setRoundBottomLeft(15);
        txtMontoBack.setRoundBottomRight(15);
        txtMontoBack.setRoundTopLeft(15);
        txtMontoBack.setRoundTopRight(15);

        txtMonto.setBackground(c_graylight);
        txtMonto.setFont(new java.awt.Font("Plus Jakarta Sans", 1, 16)); // NOI18N
        txtMonto.setText("0.0");
        txtMonto.setBorder(null);

        labelFecha.setFont(new java.awt.Font("Plus Jakarta Sans", 1, 16)); // NOI18N
        labelFecha.setForeground(c_black);
        labelFecha.setText("USD$");

        javax.swing.GroupLayout txtMontoBackLayout = new javax.swing.GroupLayout(txtMontoBack);
        txtMontoBack.setLayout(txtMontoBackLayout);
        txtMontoBackLayout.setHorizontalGroup(
            txtMontoBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtMontoBackLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
        );
        txtMontoBackLayout.setVerticalGroup(
            txtMontoBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtMontoBackLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(txtMontoBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFecha))
                .addContainerGap())
        );

        jPanel1.add(txtMontoBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 230, 40));

        btnDateBack.setBackground(c_graylight);
        btnDateBack.setRoundBottomLeft(15);
        btnDateBack.setRoundBottomRight(15);
        btnDateBack.setRoundTopLeft(15);
        btnDateBack.setRoundTopRight(15);

        jLabel3.setFont(new java.awt.Font("Plus Jakarta Sans", 0, 24)); // NOI18N
        jLabel3.setForeground(c_black);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("/");

        txtDay.setBackground(c_graylight);
        txtDay.setFont(new java.awt.Font("Plus Jakarta Sans", 1, 16)); // NOI18N
        txtDay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDay.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Plus Jakarta Sans", 0, 24)); // NOI18N
        jLabel1.setForeground(c_black);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("/");

        txtMonth.setBackground(c_graylight);
        txtMonth.setFont(new java.awt.Font("Plus Jakarta Sans", 1, 16)); // NOI18N
        txtMonth.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMonth.setBorder(null);
        txtMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonthActionPerformed(evt);
            }
        });

        txtYear.setBackground(c_graylight);
        txtYear.setFont(new java.awt.Font("Plus Jakarta Sans", 1, 16)); // NOI18N
        txtYear.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtYear.setBorder(null);
        txtYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtYearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnDateBackLayout = new javax.swing.GroupLayout(btnDateBack);
        btnDateBack.setLayout(btnDateBackLayout);
        btnDateBackLayout.setHorizontalGroup(
            btnDateBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
            .addGroup(btnDateBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnDateBackLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(txtMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        btnDateBackLayout.setVerticalGroup(
            btnDateBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(btnDateBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnDateBackLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(btnDateBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(btnDateBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 230, 40));

        btnDeleteBack.setBackground(c_black);
        btnDeleteBack.setRoundBottomLeft(25);
        btnDeleteBack.setRoundBottomRight(25);
        btnDeleteBack.setRoundTopLeft(25);
        btnDeleteBack.setRoundTopRight(25);

        btnSaveEliminar.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 1, 18)); // NOI18N
        btnSaveEliminar.setForeground(c_white);
        btnSaveEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSaveEliminar.setText("ELIMINAR");
        btnSaveEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveEliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveEliminarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnDeleteBackLayout = new javax.swing.GroupLayout(btnDeleteBack);
        btnDeleteBack.setLayout(btnDeleteBackLayout);
        btnDeleteBackLayout.setHorizontalGroup(
            btnDeleteBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        btnDeleteBackLayout.setVerticalGroup(
            btnDeleteBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(btnDeleteBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 120, 40));

        btnSaveIngresoBack.setBackground(c_green);
        btnSaveIngresoBack.setRoundBottomLeft(25);
        btnSaveIngresoBack.setRoundBottomRight(25);
        btnSaveIngresoBack.setRoundTopLeft(25);
        btnSaveIngresoBack.setRoundTopRight(25);

        btnSaveIngreso.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 1, 18)); // NOI18N
        btnSaveIngreso.setForeground(c_white);
        btnSaveIngreso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSaveIngreso.setText("INGRESO");
        btnSaveIngreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveIngresoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveIngresoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveIngresoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnSaveIngresoBackLayout = new javax.swing.GroupLayout(btnSaveIngresoBack);
        btnSaveIngresoBack.setLayout(btnSaveIngresoBackLayout);
        btnSaveIngresoBackLayout.setHorizontalGroup(
            btnSaveIngresoBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveIngreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        btnSaveIngresoBackLayout.setVerticalGroup(
            btnSaveIngresoBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(btnSaveIngresoBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, -1, -1));

        btnSaveEgresoBack.setBackground(c_yellow);
        btnSaveEgresoBack.setRoundBottomLeft(25);
        btnSaveEgresoBack.setRoundBottomRight(25);
        btnSaveEgresoBack.setRoundTopLeft(25);
        btnSaveEgresoBack.setRoundTopRight(25);

        btnSaveEgreso.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 1, 18)); // NOI18N
        btnSaveEgreso.setForeground(c_black);
        btnSaveEgreso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSaveEgreso.setText("EGRESO");
        btnSaveEgreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveEgresoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveEgresoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveEgresoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnSaveEgresoBackLayout = new javax.swing.GroupLayout(btnSaveEgresoBack);
        btnSaveEgresoBack.setLayout(btnSaveEgresoBackLayout);
        btnSaveEgresoBackLayout.setHorizontalGroup(
            btnSaveEgresoBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveEgreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        btnSaveEgresoBackLayout.setVerticalGroup(
            btnSaveEgresoBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveEgreso, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(btnSaveEgresoBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 120, 40));

        btnEditBack.setBackground(c_greenLight);
        btnEditBack.setRoundBottomLeft(25);
        btnEditBack.setRoundBottomRight(25);
        btnEditBack.setRoundTopLeft(25);
        btnEditBack.setRoundTopRight(25);

        btnSaveEditar.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 1, 18)); // NOI18N
        btnSaveEditar.setForeground(c_white);
        btnSaveEditar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSaveEditar.setText("EDITAR");
        btnSaveEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveEditarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveEditarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnEditBackLayout = new javax.swing.GroupLayout(btnEditBack);
        btnEditBack.setLayout(btnEditBackLayout);
        btnEditBackLayout.setHorizontalGroup(
            btnEditBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        btnEditBackLayout.setVerticalGroup(
            btnEditBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(btnEditBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 120, -1));

        btnPDFBack.setBackground(c_greenLight);
        btnPDFBack.setRoundBottomLeft(25);
        btnPDFBack.setRoundBottomRight(25);
        btnPDFBack.setRoundTopLeft(25);
        btnPDFBack.setRoundTopRight(25);

        btnPDF.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 18)); // NOI18N
        btnPDF.setForeground(c_white);
        btnPDF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPDF.setText("PDF");
        btnPDF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPDFMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPDFMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPDFMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnPDFBackLayout = new javax.swing.GroupLayout(btnPDFBack);
        btnPDFBack.setLayout(btnPDFBackLayout);
        btnPDFBackLayout.setHorizontalGroup(
            btnPDFBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPDFBackLayout.createSequentialGroup()
                .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btnPDFBackLayout.setVerticalGroup(
            btnPDFBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPDF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(btnPDFBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 70, -1));

        labelPDF.setFont(new java.awt.Font("Plus Jakarta Sans", 0, 14)); // NOI18N
        labelPDF.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPDF.setText("Genera un Reporte");
        jPanel1.add(labelPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(569, 40, 140, -1));

        labelMonto.setFont(new java.awt.Font("Plus Jakarta Sans", 0, 12)); // NOI18N
        labelMonto.setForeground(c_black);
        labelMonto.setText("Monto:");
        jPanel1.add(labelMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 100, -1));

        labelFecha1.setFont(new java.awt.Font("Plus Jakarta Sans", 0, 12)); // NOI18N
        labelFecha1.setForeground(c_black);
        labelFecha1.setText("Descripcion:");
        jPanel1.add(labelFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 190, -1));

        labelFecha2.setFont(new java.awt.Font("Plus Jakarta Sans", 0, 12)); // NOI18N
        labelFecha2.setForeground(c_black);
        labelFecha2.setText("Fecha: DIA / MES / AÑO");
        jPanel1.add(labelFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 190, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, -5, 820, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPDFMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPDFMouseEntered
        btnPDFBack.setBackground(c_greenDark);
    }//GEN-LAST:event_btnPDFMouseEntered

    private void btnPDFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPDFMouseExited
        btnPDFBack.setBackground(c_greenLight);
    }//GEN-LAST:event_btnPDFMouseExited

    private void txtMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMonthActionPerformed

    private void txtYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtYearActionPerformed

    private void btnSaveEgresoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveEgresoMouseClicked
        String date = txtYear.getText()+"-"+txtMonth.getText()+"-"+txtDay.getText();
        if(!isValidDate(date)){
            JOptionPane.showMessageDialog(null, "La fecha ingresada : " + date + " no es valida.");
            return;
        }
        Double amount = convertToDouble(txtMonto.getText());
        try {
            Document movimiento = new Document("user_id", usuario.getId())
                    .append("type", 1)
                    .append("date", date)
                    .append("amount", amount)
                    .append("desc", txtDesc.getText());
            gs.setMovimiento(movimiento);
            getData();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error");
        }
        
    }//GEN-LAST:event_btnSaveEgresoMouseClicked

    private void btnSaveIngresoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveIngresoMouseClicked
        String date = txtYear.getText()+"-"+txtMonth.getText()+"-"+txtDay.getText();
        if(!isValidDate(date)){
            JOptionPane.showMessageDialog(null, "La fecha ingresada : " + date + " no es valida.");
            return;
        }
        Double amount = convertToDouble(txtMonto.getText());
        try {
            Document movimiento = new Document("user_id", usuario.getId())
                    .append("type", 0)
                    .append("date", date)
                    .append("amount", amount)
                    .append("desc", txtDesc.getText());
            gs.setMovimiento(movimiento);
            getData();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error");
        }
    }//GEN-LAST:event_btnSaveIngresoMouseClicked

    private void btnSaveEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveEliminarMouseEntered
        btnDeleteBack.setBackground(c_red);
    }//GEN-LAST:event_btnSaveEliminarMouseEntered

    private void btnSaveEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveEliminarMouseExited
        btnDeleteBack.setBackground(c_black);
    }//GEN-LAST:event_btnSaveEliminarMouseExited

    private void btnSaveEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveEditarMouseEntered
        btnEditBack.setBackground(c_green);
    }//GEN-LAST:event_btnSaveEditarMouseEntered

    private void btnSaveEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveEditarMouseExited
        btnEditBack.setBackground(c_greenLight);
    }//GEN-LAST:event_btnSaveEditarMouseExited

    private void btnSaveIngresoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveIngresoMouseEntered
        btnSaveIngresoBack.setBackground(c_greenDark);
    }//GEN-LAST:event_btnSaveIngresoMouseEntered

    private void btnSaveIngresoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveIngresoMouseExited
        btnSaveIngresoBack.setBackground(c_green);
    }//GEN-LAST:event_btnSaveIngresoMouseExited

    private void btnSaveEgresoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveEgresoMouseEntered
        btnSaveEgresoBack.setBackground(c_yellowDark);
    }//GEN-LAST:event_btnSaveEgresoMouseEntered

    private void btnSaveEgresoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveEgresoMouseExited
        btnSaveEgresoBack.setBackground(c_yellow);
    }//GEN-LAST:event_btnSaveEgresoMouseExited

    private void btnPDFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPDFMouseClicked
        try{
            generatePDF gPDF = new generatePDF();
            gPDF.pdfTable(tblMovimientos);
            
        } catch (Exception e){
            System.out.println("Hubo un error al generar el reporte.");
        }
    }//GEN-LAST:event_btnPDFMouseClicked

    private void btnSaveEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveEditarMouseClicked
        //OBTENER VALORES
        String day = txtDay.getText();
        String desc = txtDesc.getText();
        int state = 0;
        
        resetFields(); //Reseteamos los campos
        
        int fila = tblMovimientos.getSelectedRow();
        ObjectId id = new ObjectId((String) tblMovimientos.getValueAt(fila, 0));
        
        Document newDocument = new Document("title", title).append("description", desc).append("state", state);
        //Remplazamos el documento con el id igual
        getData();
        
        
    }//GEN-LAST:event_btnSaveEditarMouseClicked

    private void btnSaveEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveEliminarMouseClicked
       int fila = tblMovimientos.getSelectedRow();
        ObjectId id = new ObjectId((String) tblMovimientos.getValueAt(fila, 0));
        
        gs.delMovimiento(new Document("_id", id));
        
        getData();
    }//GEN-LAST:event_btnSaveEliminarMouseClicked

    private void resetFields(){
        txtDay.setText("");
        txtMonto.setText("");
        txtYear.setText("");
        txtMonth.setText("");
        txtDesc.setText("");
    }
    
    private void getData(){
        //OBTENEMOS LOS DATOS
        Document user_movimientos = new Document("user_id", usuario.getId());
        FindIterable<Document> documents = gs.getMovimiento(user_movimientos);
        double balance = 0.0;
        
        //TABLA
        String titulos[] = {"ID", "Fecha", "Descripcion", "Monto"};
        String registro[] = new String[4];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        try (MongoCursor<Document> cursor = documents.iterator()) {
            while(cursor.hasNext()){
                Document document = cursor.next();
                registro[0] = document.getObjectId("_id").toString();
                registro[1] = document.getString("date");
                registro[2] = document.getString("desc");
                registro[3] = "0";
                if (document.getDouble("amount") != null){
                    if(document.getInteger("type") != 1){
                        balance -= document.getDouble("amount");
                        registro[3] = "-" + document.getDouble("amount").toString();
                    } else{
                        balance += document.getDouble("amount");
                        registro[3] = document.getDouble("amount").toString();
                    }
                    
                }
                
                modelo.addRow(registro);
            }
            tblMovimientos.setModel(modelo);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos.");
            System.out.println("Hubo un error : " + e);
        }
    }
    
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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balance;
    private Styles.PanelRound btnDateBack;
    private Styles.PanelRound btnDeleteBack;
    private Styles.PanelRound btnEditBack;
    private javax.swing.JLabel btnPDF;
    private Styles.PanelRound btnPDFBack;
    private javax.swing.JLabel btnSaveEditar;
    private javax.swing.JLabel btnSaveEgreso;
    private Styles.PanelRound btnSaveEgresoBack;
    private javax.swing.JLabel btnSaveEliminar;
    private javax.swing.JLabel btnSaveIngreso;
    private Styles.PanelRound btnSaveIngresoBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelFecha1;
    private javax.swing.JLabel labelFecha2;
    private javax.swing.JLabel labelMonto;
    private javax.swing.JLabel labelPDF;
    private javax.swing.JTable tblMovimientos;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtDay;
    private javax.swing.JTextArea txtDesc;
    private Styles.PanelRound txtDescBack;
    private javax.swing.JTextField txtMonth;
    private javax.swing.JTextField txtMonto;
    private Styles.PanelRound txtMontoBack;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}