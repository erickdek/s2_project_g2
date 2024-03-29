package Vista;

import Controller.Gestor;
import Styles.*;
import static Styles.Colors.*;
import TypeData.User;
import java.awt.Font;
import javax.swing.JOptionPane;
import org.bson.types.ObjectId;
/**
 *
 * @author erick
 */
public class login extends javax.swing.JFrame {
    User usuario = new User();
    Gestor gs = new Gestor();
    /**
     * Creates new form login
     */
    public login() {
        initComponents();
        setLocationRelativeTo(null);
        placeHolders();
    }
    
    public login(User usuario) {
        initComponents();
        setLocationRelativeTo(null);
        placeHolders();
        this.usuario = usuario;
    }
    
    public void placeHolders(){
        TextPrompt UserHolder = new TextPrompt("Nombre de Usuario o Email", txtUser);
        UserHolder.changeAlpha(0.75f);
        UserHolder.changeStyle(Font.ITALIC);
        
        TextPrompt PassHolder = new TextPrompt("******", txtPass);
        PassHolder.changeAlpha(0.75f);
        PassHolder.changeStyle(Font.ITALIC);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new Styles.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        btnLogin = new Styles.PanelRound();
        btnLoginText = new javax.swing.JLabel();
        btnRegister = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUserBack = new Styles.PanelRound();
        txtUser = new javax.swing.JTextField();
        txtPassBack = new Styles.PanelRound();
        txtPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnClose = new Styles.PanelRound();
        btnCloseIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(19, 7, 45));
        setMinimumSize(new java.awt.Dimension(736, 451));
        setUndecorated(true);
        setSize(new java.awt.Dimension(736, 451));
        getContentPane().setLayout(null);

        panelRound1.setBackground(c_greenDark);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MANAGE MONEY");
        panelRound1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 160, -1));

        btnLogin.setBackground(c_white);
        btnLogin.setRoundBottomLeft(15);
        btnLogin.setRoundBottomRight(15);
        btnLogin.setRoundTopLeft(15);
        btnLogin.setRoundTopRight(15);

        btnLoginText.setBackground(c_white);
        btnLoginText.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 14)); // NOI18N
        btnLoginText.setForeground(c_greenDark);
        btnLoginText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLoginText.setText("Iniciar Sesion");
        btnLoginText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginTextMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnLoginLayout = new javax.swing.GroupLayout(btnLogin);
        btnLogin.setLayout(btnLoginLayout);
        btnLoginLayout.setHorizontalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
            .addGroup(btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnLoginText, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
        );
        btnLoginLayout.setVerticalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
            .addGroup(btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnLoginText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
        );

        panelRound1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, -1, -1));

        btnRegister.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(204, 204, 204));
        btnRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegister.setText("¿No tienes una cuena? Registrate Aquí");
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegisterMouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnRegisterMouseReleased(evt);
            }
        });
        panelRound1.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 220, 30));

        jLabel2.setFont(new java.awt.Font("Plus Jakarta Sans", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NEW VERSION");
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 100, -1));

        txtUserBack.setBackground(c_white);
        txtUserBack.setRoundBottomLeft(15);
        txtUserBack.setRoundBottomRight(15);
        txtUserBack.setRoundTopLeft(15);
        txtUserBack.setRoundTopRight(15);

        txtUser.setBackground(c_white);
        txtUser.setForeground(c_black);
        txtUser.setToolTipText("");
        txtUser.setBorder(null);
        txtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserFocusLost(evt);
            }
        });
        txtUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserMouseClicked(evt);
            }
        });
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txtUserBackLayout = new javax.swing.GroupLayout(txtUserBack);
        txtUserBack.setLayout(txtUserBackLayout);
        txtUserBackLayout.setHorizontalGroup(
            txtUserBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
            .addGroup(txtUserBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtUserBackLayout.createSequentialGroup()
                    .addContainerGap(14, Short.MAX_VALUE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        txtUserBackLayout.setVerticalGroup(
            txtUserBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(txtUserBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtUserBackLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panelRound1.add(txtUserBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, 40));

        txtPassBack.setBackground(c_white);
        txtPassBack.setRoundBottomLeft(15);
        txtPassBack.setRoundBottomRight(15);
        txtPassBack.setRoundTopLeft(15);
        txtPassBack.setRoundTopRight(15);

        txtPass.setBackground(c_white);
        txtPass.setForeground(c_black);
        txtPass.setBorder(null);
        txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassFocusLost(evt);
            }
        });
        txtPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPassMouseClicked(evt);
            }
        });
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txtPassBackLayout = new javax.swing.GroupLayout(txtPassBack);
        txtPassBack.setLayout(txtPassBackLayout);
        txtPassBackLayout.setHorizontalGroup(
            txtPassBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
            .addGroup(txtPassBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtPassBackLayout.createSequentialGroup()
                    .addContainerGap(14, Short.MAX_VALUE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        txtPassBackLayout.setVerticalGroup(
            txtPassBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(txtPassBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(txtPassBackLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panelRound1.add(txtPassBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, -1, 40));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña:");
        panelRound1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 100, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Usuario:");
        panelRound1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 100, -1));

        btnClose.setBackground(c_white);
        btnClose.setPreferredSize(new java.awt.Dimension(40, 40));
        btnClose.setRoundBottomLeft(20);
        btnClose.setRoundBottomRight(20);
        btnClose.setRoundTopLeft(20);
        btnClose.setRoundTopRight(20);

        btnCloseIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCloseIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        btnCloseIcon.setMaximumSize(new java.awt.Dimension(35, 35));
        btnCloseIcon.setMinimumSize(new java.awt.Dimension(35, 35));
        btnCloseIcon.setPreferredSize(new java.awt.Dimension(35, 35));
        btnCloseIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnCloseLayout = new javax.swing.GroupLayout(btnClose);
        btnClose.setLayout(btnCloseLayout);
        btnCloseLayout.setHorizontalGroup(
            btnCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(btnCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnCloseLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnCloseIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        btnCloseLayout.setVerticalGroup(
            btnCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(btnCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnCloseLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnCloseIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panelRound1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, -1, -1));

        getContentPane().add(panelRound1);
        panelRound1.setBounds(0, 0, 740, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void btnRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseClicked
        register registro = new register();
        registro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegisterMouseClicked

    private void txtUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserMouseClicked
        
    }//GEN-LAST:event_txtUserMouseClicked

    private void btnRegisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseEntered
        //.
    }//GEN-LAST:event_btnRegisterMouseEntered

    private void btnRegisterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseReleased
        //.
    }//GEN-LAST:event_btnRegisterMouseReleased

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        
    }//GEN-LAST:event_txtPassActionPerformed

    private void txtPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassMouseClicked
        
    }//GEN-LAST:event_txtPassMouseClicked

    private void txtUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusLost

    }//GEN-LAST:event_txtUserFocusLost

    private void txtUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusGained

    }//GEN-LAST:event_txtUserFocusGained

    private void txtPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusGained

    }//GEN-LAST:event_txtPassFocusGained

    private void txtPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusLost

    }//GEN-LAST:event_txtPassFocusLost

    private void btnCloseIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseIconMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCloseIconMouseClicked

    private void btnLoginTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginTextMouseClicked
        btnLogin.setBackground(c_greenLight);
        usuario.setUser(txtUser.getText());
        usuario.setPass(new String(txtPass.getPassword()));
        
        //Guardamos temporalmente el ID
        ObjectId user_id = gs.Login(usuario);
        
        if ( user_id != null){
            usuario.setId(user_id);
            menu vmenu = new menu(usuario);
            vmenu.setVisible(true);
            this.dispose();
        }
        btnLogin.setBackground(c_white);
    }//GEN-LAST:event_btnLoginTextMouseClicked

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Styles.PanelRound btnClose;
    private javax.swing.JLabel btnCloseIcon;
    private Styles.PanelRound btnLogin;
    private javax.swing.JLabel btnLoginText;
    private javax.swing.JLabel btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private Styles.PanelRound panelRound1;
    private javax.swing.JPasswordField txtPass;
    private Styles.PanelRound txtPassBack;
    private javax.swing.JTextField txtUser;
    private Styles.PanelRound txtUserBack;
    // End of variables declaration//GEN-END:variables
}
