
package menuutama;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;

/**
 *
 * @author furqon
 */
public class Seleksi extends javax.swing.JPanel {
    private Connection conn = new Koneksi().connect();
    private DefaultTableModel tabmode;
    protected KriteriaAhp pKriteria = new KriteriaAhp(); 
    protected  String noId;
    /**
     * Creates new form Seleksi
     */
    public Seleksi() {
        initComponents();
        dataTabel();
    }
    
    protected void dataTabel(){
        Object[] Baris = {"Ranking","ID Kue","Nama Kue","Pengemasan","Hasil Penilaian"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelRanking.setModel(tabmode);

        String sql = "SELECT * FROM seleksi ORDER BY hasil_penilaian DESC";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            int i = 1;
            while(hasil.next()){
                String a = Integer.toString(i);
                String b = hasil.getString("id_kue");
                String c = hasil.getString("nama");
                String d = hasil.getString("Pengemasan");
                String e = hasil.getString("hasil_penilaian");
                
                String[] data={a, b, c, d, e};
                tabmode.addRow(data);
                i++;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
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
        tabelRanking = new javax.swing.JTable();
        tombolUpdate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tombolHapus = new javax.swing.JButton();
        tombolLihatPerhitunganAHP = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        custom_JPanelGradient1 = new Custom.Custom_JPanelGradient();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 153));

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        tabelRanking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ranking", "Id Kue", "Nama Kue", "Pengemasan", "Hasil Penilaian"
            }
        ));
        tabelRanking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelRankingMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelRanking);

        tombolUpdate.setBackground(new java.awt.Color(0, 51, 102));
        tombolUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tombolUpdate.setForeground(new java.awt.Color(255, 255, 255));
        tombolUpdate.setText("Update Data");
        tombolUpdate.setBorder(null);
        tombolUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUpdateActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));

        jLabel1.setText("- Klik tombol Update untuk mengupdate data tabel");

        jLabel3.setText("Catatan : ");

        jLabel4.setText("- Hapus dengan mengklik data tabel yang ingin dihapus ");

        jLabel5.setText("- Ranking diurutkan berdasarkan hasil penilaian terbesar sampai terkecil Kue");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addGap(0, 54, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(0, 50, Short.MAX_VALUE))
        );

        tombolHapus.setBackground(new java.awt.Color(0, 51, 102));
        tombolHapus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tombolHapus.setForeground(new java.awt.Color(255, 255, 255));
        tombolHapus.setText("Hapus");
        tombolHapus.setBorder(null);
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });

        tombolLihatPerhitunganAHP.setBackground(new java.awt.Color(102, 0, 0));
        tombolLihatPerhitunganAHP.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tombolLihatPerhitunganAHP.setForeground(new java.awt.Color(255, 255, 255));
        tombolLihatPerhitunganAHP.setText("Mulai Penilaian Kue Metode AHP");
        tombolLihatPerhitunganAHP.setBorder(null);
        tombolLihatPerhitunganAHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolLihatPerhitunganAHPActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Dark analytics-pana.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tombolLihatPerhitunganAHP, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(tombolHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tombolUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tombolLihatPerhitunganAHP, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(tombolUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tombolHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );

        custom_JPanelGradient1.setColorEnd(new java.awt.Color(255, 255, 204));
        custom_JPanelGradient1.setColorStart(new java.awt.Color(255, 51, 0));

        jLabel2.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jLabel2.setText("Seleksi Kue");

        javax.swing.GroupLayout custom_JPanelGradient1Layout = new javax.swing.GroupLayout(custom_JPanelGradient1);
        custom_JPanelGradient1.setLayout(custom_JPanelGradient1Layout);
        custom_JPanelGradient1Layout.setHorizontalGroup(
            custom_JPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(custom_JPanelGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        custom_JPanelGradient1Layout.setVerticalGroup(
            custom_JPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, custom_JPanelGradient1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(custom_JPanelGradient1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(custom_JPanelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tombolLihatPerhitunganAHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolLihatPerhitunganAHPActionPerformed
        // TODO add your handling code here:
        DialogPerhitunganAHP dialog1 = new DialogPerhitunganAHP(null, true);
        dialog1.show();
    }//GEN-LAST:event_tombolLihatPerhitunganAHPActionPerformed

    private void tombolUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUpdateActionPerformed
        // TODO add your handling code here:
        dataTabel();
    }//GEN-LAST:event_tombolUpdateActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog",JOptionPane.YES_NO_CANCEL_OPTION);
        if(ok == 0){
            String sql = "DELETE FROM seleksi WHERE id_kue='"+noId+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);

                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil diHapus ");
                dataTabel();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Data Gagal diHapus " + e);
            }
        }
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void tabelRankingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelRankingMouseClicked
        // TODO add your handling code here:
        int bar = tabelRanking.getSelectedRow();
        String a = tabmode.getValueAt(bar, 1).toString();
        noId = a;
    }//GEN-LAST:event_tabelRankingMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.Custom_JPanelGradient custom_JPanelGradient1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelRanking;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolLihatPerhitunganAHP;
    private javax.swing.JButton tombolUpdate;
    // End of variables declaration//GEN-END:variables
}
