
package menuutama;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;

/**
 *
 * @author furqon
 */
public class PengaturanSubKriteria extends javax.swing.JPanel {
    private Connection conn = new Koneksi().connect();
    private DefaultTableModel tabmode;
    /**
     * Creates new form Pengaturan
     */
    public PengaturanSubKriteria() {
        initComponents();
        updateDataTabel();
    }
    
    protected void kosong(){
        cbSubTampilan1.setSelectedIndex(0);
        cbSubTampilan2.setSelectedIndex(0);
        cbSubTampilan3.setSelectedIndex(0);
        cbSubTampilan4.setSelectedIndex(0);
        cbSubHarga1.setSelectedIndex(0);
        cbSubHarga2.setSelectedIndex(0);
        cbSubHarga3.setSelectedIndex(0);
        cbSubKualitas1.setSelectedIndex(0);
        cbSubKualitas2.setSelectedIndex(0);
        cbSubKualitas3.setSelectedIndex(0);
        cbSubVarianRasa1.setSelectedIndex(0);
        cbSubVarianRasa2.setSelectedIndex(0);
        cbSubVarianRasa3.setSelectedIndex(0);
        cbSubVarianRasa4.setSelectedIndex(0);
    }
    
    protected void updateDataTabel(){
        Object[] Baris = {
            "Kode Kriteria",
            "Nama Kriteria",
            "Nama SubKriteria",
            "Kepentingan SubKriteria"
        };
        tabmode = new DefaultTableModel(null, Baris);
        tabelSubKriteria.setModel(tabmode);
        String sql = "SELECT * FROM sub_kriteria ORDER BY kd_kriteria, no_sub";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("kd_kriteria");
                String b = hasil.getString("nama_kriteria");
                String c = hasil.getString("nama_sub_kriteria");
                String d = hasil.getString("prioritas_kepentingan");
                
                String[] data={a, b, c, d};
                tabmode.addRow(data);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    protected void getDataTabel(){
        String sql = "SELECT nama_sub_kriteria FROM sub_kriteria ORDER BY kd_kriteria, no_sub";
        int n = 1;
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("nama_sub_kriteria");
                if(n==1){
                    cbSubTampilan1.setSelectedItem(a);
                }else if(n==2){
                    cbSubTampilan2.setSelectedItem(a);
                }else if(n==3){
                    cbSubTampilan3.setSelectedItem(a);
                }else if(n==4){
                    cbSubTampilan4.setSelectedItem(a);
                }else if(n==5){
                    cbSubHarga1.setSelectedItem(a);
                }else if(n==6){
                    cbSubHarga2.setSelectedItem(a);
                }else if(n==7){
                    cbSubHarga3.setSelectedItem(a);
                }else if(n==8){
                    cbSubKualitas1.setSelectedItem(a);
                }else if(n==9){
                    cbSubKualitas2.setSelectedItem(a);
                }else if(n==10){
                    cbSubKualitas3.setSelectedItem(a);
                }else if(n==11){
                    cbSubVarianRasa1.setSelectedItem(a);
                }else if(n==12){
                    cbSubVarianRasa2.setSelectedItem(a);
                }else if(n==13){
                    cbSubVarianRasa3.setSelectedItem(a);
                }else if(n==14){
                    cbSubVarianRasa4.setSelectedItem(a);
                } 
                n++;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    //masukan data subkriteria
    protected void insertDataSubKriteria(){
        try{
        int n=1, nTampilan=1, nHarga=1, nKualitas=1, nVarianRasa=1, i=1;
            do{
                String kepentingan;
                String sql = "INSERT INTO sub_kriteria VALUES (?,?,?,?,?)";
                PreparedStatement stat = conn.prepareStatement(sql);
                java.sql.Statement statCek = conn.createStatement();
                String sqlSub = "SELECT kd_kriteria, nama_kriteria FROM kriteria";
                String sqlTampilan = "SELECT kd_kriteria, nama_kriteria FROM kriteria WHERE nama_kriteria='Tampilan'";
                String sqlHarga = "SELECT kd_kriteria, nama_kriteria FROM kriteria WHERE nama_kriteria='Harga'";
                String sqlKualitas = "SELECT kd_kriteria, nama_kriteria FROM kriteria WHERE nama_kriteria='Kualitas'";
                String sqlVarianRasa = "SELECT kd_kriteria, nama_kriteria FROM kriteria WHERE nama_kriteria='Varian Rasa'";
                ResultSet hasil = statCek.executeQuery(sqlSub);
                if(n==1){
                    hasil = statCek.executeQuery(sqlTampilan);
                    stat.setString(1, Integer.toString(i));
                    i++;
                    while(hasil.next()){
                        String a = hasil.getString("kd_kriteria");
                        String b = hasil.getString("nama_kriteria");
                        stat.setString(2, a);
                        stat.setString(3, b);
                    }
                    if(nTampilan == 1){
                        stat.setString(4, cbSubTampilan1.getSelectedItem().toString());
                        kepentingan="Sangat Penting ke-1";
                    }else if(nTampilan == 2){
                        stat.setString(4, cbSubTampilan2.getSelectedItem().toString());
                        kepentingan="Penting ke-2";
                    }else if(nTampilan == 3){
                        stat.setString(4, cbSubTampilan3.getSelectedItem().toString());
                        kepentingan="Cukup Penting ke-3";
                    }else{
                        stat.setString(4, cbSubTampilan4.getSelectedItem().toString());
                        kepentingan="Biasa ke-4";
                        n++;
                    }
                    stat.setString(5, kepentingan);
                    stat.executeUpdate();
                    nTampilan++;
                }else if(n==2){
                    hasil = statCek.executeQuery(sqlHarga);
                    stat.setString(1, Integer.toString(i));
                    i++;
                    while(hasil.next()){    
                        String a = hasil.getString("kd_kriteria");
                        String b = hasil.getString("nama_kriteria");
                        stat.setString(2, a);
                        stat.setString(3, b);
                    }
                    if(nHarga == 1){
                        stat.setString(4, cbSubHarga1.getSelectedItem().toString());
                        kepentingan="Sangat Penting ke-1";
                    }else if(nHarga == 2){
                        stat.setString(4, cbSubHarga2.getSelectedItem().toString());
                        kepentingan="Cukup Penting ke-2";
                    }else{
                        stat.setString(4, cbSubHarga3.getSelectedItem().toString());
                        kepentingan="Biasa ke-3";
                        n++;
                    }
                    stat.setString(5, kepentingan);
                    stat.executeUpdate();
                    nHarga++;
                }else if(n==3){
                    hasil = statCek.executeQuery(sqlKualitas);
                    stat.setString(1, Integer.toString(i));
                    i++;
                    while(hasil.next()){    
                        String a = hasil.getString("kd_kriteria");
                        String b = hasil.getString("nama_kriteria");
                        stat.setString(2, a);
                        stat.setString(3, b);
                    }
                    if(nKualitas == 1){
                        stat.setString(4, cbSubKualitas1.getSelectedItem().toString());
                        kepentingan="Sangat Penting ke-1";
                    }else if(nKualitas == 2){
                        stat.setString(4, cbSubKualitas2.getSelectedItem().toString());
                        kepentingan="Cukup Penting ke-2";
                    }else{
                        stat.setString(4, cbSubKualitas3.getSelectedItem().toString());
                        kepentingan="Biasa ke-3";
                        n++;
                    }
                    stat.setString(5, kepentingan);
                    stat.executeUpdate();
                    nKualitas++;
                }else{    
                    hasil = statCek.executeQuery(sqlVarianRasa);
                    stat.setString(1, Integer.toString(i));
                    i++;
                    while(hasil.next()){
                        String a = hasil.getString("kd_kriteria");
                        String b = hasil.getString("nama_kriteria");
                        stat.setString(2, a);
                        stat.setString(3, b);
                    }
                    if(nVarianRasa == 1){
                        stat.setString(4, cbSubVarianRasa1.getSelectedItem().toString());
                        kepentingan="Sangat Penting ke-1";
                    }else if(nVarianRasa == 2){
                        stat.setString(4, cbSubVarianRasa2.getSelectedItem().toString());
                        kepentingan="Penting ke-2";
                    }else if(nVarianRasa == 3){
                        stat.setString(4, cbSubVarianRasa3.getSelectedItem().toString());
                        kepentingan="Cukup Penting ke-3";
                    }else{
                        stat.setString(4, cbSubVarianRasa4.getSelectedItem().toString());
                        kepentingan="Biasa ke-4";
                        n++;
                    }
                    stat.setString(5, kepentingan);
                    stat.executeUpdate();
                    nVarianRasa++;
                }
            }while(n<=4);   
            JOptionPane.showMessageDialog(null, "DATA Berhasil Disimpan");
            kosong();
            updateDataTabel();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan "+e);
        }
    }
    
    protected void hapusDataSubKriteria(){
        int ok = JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog",JOptionPane.YES_NO_OPTION);
        if(ok == 0){
            String sql = "DELETE FROM sub_kriteria";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);

                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil diHapus ");
                kosong();
                updateDataTabel();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Data Gagal diHapus " + e);
            }
        }
    }
    
    protected void editDataSubKriteria(){
        try{
        int n=1, nTampilan=1, nHarga=1, nKualitas=1, nVarian=1, i=1;
            do{
                String kepentingan;
                String sql = "UPDATE sub_kriteria set kd_kriteria=?, nama_kriteria=?, nama_sub_kriteria=?, prioritas_kepentingan=? WHERE no_sub=?";
                PreparedStatement stat = conn.prepareStatement(sql);
                java.sql.Statement statCek = conn.createStatement();
                String sqlSub = "SELECT kd_kriteria, nama_kriteria FROM kriteria";
                String sqlTampilan = "SELECT kd_kriteria, nama_kriteria FROM kriteria WHERE nama_kriteria='Tampilan'";
                String sqlHarga = "SELECT kd_kriteria, nama_kriteria FROM kriteria WHERE nama_kriteria='Harga'";
                String sqlKualitas = "SELECT kd_kriteria, nama_kriteria FROM kriteria WHERE nama_kriteria='Kualitas'";
                String sqlVarian = "SELECT kd_kriteria, nama_kriteria FROM kriteria WHERE nama_kriteria='Varian Rasa'";
                ResultSet hasil = statCek.executeQuery(sqlSub);
                if(n==1){
                    hasil = statCek.executeQuery(sqlTampilan);
                    stat.setString(5, Integer.toString(i));
                    i++;
                    while(hasil.next()){
                        String a = hasil.getString("kd_kriteria");
                        String b = hasil.getString("nama_kriteria");
                        stat.setString(1, a);
                        stat.setString(2, b);
                    }
                    if(nTampilan == 1){
                        stat.setString(3, cbSubTampilan1.getSelectedItem().toString());
                        kepentingan="Sangat Penting ke-1";
                    }else if(nTampilan == 2){
                        stat.setString(3, cbSubTampilan2.getSelectedItem().toString());
                        kepentingan="Penting ke-2";
                    }else if(nTampilan == 3){
                        stat.setString(3, cbSubTampilan3.getSelectedItem().toString());
                        kepentingan="Cukup Penting ke-3";
                    }else{
                        stat.setString(3, cbSubTampilan4.getSelectedItem().toString());
                        kepentingan="Biasa ke-4";
                        n++;
                    }
                    stat.setString(4, kepentingan);
                    stat.executeUpdate();
                    nTampilan++;
                }else if(n==2){
                    hasil = statCek.executeQuery(sqlHarga);
                    stat.setString(5, Integer.toString(i));
                    i++;
                    while(hasil.next()){    
                        String a = hasil.getString("kd_kriteria");
                        String b = hasil.getString("nama_kriteria");
                        stat.setString(1, a);
                        stat.setString(2, b);
                    }
                    if(nHarga == 1){
                        stat.setString(3, cbSubHarga1.getSelectedItem().toString());
                        kepentingan="Sangat Penting ke-1";
                    }else if(nHarga == 2){
                        stat.setString(3, cbSubHarga2.getSelectedItem().toString());
                        kepentingan="Cukup Penting ke-2";
                    }else{
                        stat.setString(3, cbSubHarga3.getSelectedItem().toString());
                        kepentingan="Biasa ke-3";
                        n++;
                    }
                    stat.setString(4, kepentingan);
                    stat.executeUpdate();
                    nHarga++;
                }else if(n==3){
                    hasil = statCek.executeQuery(sqlKualitas);
                    stat.setString(5, Integer.toString(i));
                    i++;
                    while(hasil.next()){    
                        String a = hasil.getString("kd_kriteria");
                        String b = hasil.getString("nama_kriteria");
                        stat.setString(1, a);
                        stat.setString(2, b);
                    }
                    if(nKualitas == 1){
                        stat.setString(3, cbSubKualitas1.getSelectedItem().toString());
                        kepentingan="Sangat Penting ke-1";
                    }else if(nKualitas == 2){
                        stat.setString(3, cbSubKualitas2.getSelectedItem().toString());
                        kepentingan="Cukup Penting ke-2";
                    }else{
                        stat.setString(3, cbSubKualitas3.getSelectedItem().toString());
                        kepentingan="Biasa ke-3";
                        n++;
                    }
                    stat.setString(4, kepentingan);
                    stat.executeUpdate();
                    nKualitas++;
                }else{    
                    hasil = statCek.executeQuery(sqlVarian);
                    stat.setString(5, Integer.toString(i));
                    i++;
                    while(hasil.next()){
                        String a = hasil.getString("kd_kriteria");
                        String b = hasil.getString("nama_kriteria");
                        stat.setString(1, a);
                        stat.setString(2, b);
                    }
                    if(nVarian == 1){
                        stat.setString(3, cbSubVarianRasa1.getSelectedItem().toString());
                        kepentingan="Sangat Penting ke-1";
                    }else if(nVarian == 2){
                        stat.setString(3, cbSubVarianRasa2.getSelectedItem().toString());
                        kepentingan="Penting ke-2";
                    }else if(nVarian == 3){
                        stat.setString(3, cbSubVarianRasa3.getSelectedItem().toString());
                        kepentingan="Cukup Penting ke-3";
                    }else{
                        stat.setString(3, cbSubVarianRasa4.getSelectedItem().toString());
                        kepentingan="Biasa ke-4";
                        n++;
                    }
                    stat.setString(4, kepentingan);
                    stat.executeUpdate();
                    nVarian++;
                }
            }while(n<=4);   
            JOptionPane.showMessageDialog(null, "DATA Berhasil DiUbah");
            kosong();
            updateDataTabel();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal DiUbah "+e);
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
        tabelSubKriteria = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        tombolSimpan = new javax.swing.JButton();
        tombolEdit = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbSubHarga3 = new javax.swing.JComboBox<>();
        cbSubHarga2 = new javax.swing.JComboBox<>();
        cbSubHarga1 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cbSubVarianRasa4 = new javax.swing.JComboBox<>();
        cbSubVarianRasa3 = new javax.swing.JComboBox<>();
        cbSubVarianRasa2 = new javax.swing.JComboBox<>();
        cbSubVarianRasa1 = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        cbSubKualitas3 = new javax.swing.JComboBox<>();
        cbSubKualitas2 = new javax.swing.JComboBox<>();
        cbSubKualitas1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cbSubTampilan4 = new javax.swing.JComboBox<>();
        cbSubTampilan3 = new javax.swing.JComboBox<>();
        cbSubTampilan2 = new javax.swing.JComboBox<>();
        cbSubTampilan1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 204, 102));

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));

        tabelSubKriteria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Kriteria", "Nama Kriteria", "Nama SubKriteria", "Kepentingan SubKriteria"
            }
        ));
        tabelSubKriteria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelSubKriteriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelSubKriteria);

        jLabel1.setText("Catatan : Edit data, klik data pada tabel terlebih dahulu");

        jScrollPane2.setBorder(null);

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));

        tombolSimpan.setBackground(new java.awt.Color(0, 51, 102));
        tombolSimpan.setForeground(new java.awt.Color(255, 255, 255));
        tombolSimpan.setText("Simpan");
        tombolSimpan.setBorder(null);
        tombolSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSimpanActionPerformed(evt);
            }
        });

        tombolEdit.setBackground(new java.awt.Color(0, 51, 102));
        tombolEdit.setForeground(new java.awt.Color(255, 255, 255));
        tombolEdit.setText("Edit");
        tombolEdit.setBorder(null);
        tombolEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolEditActionPerformed(evt);
            }
        });

        tombolHapus.setBackground(new java.awt.Color(102, 0, 0));
        tombolHapus.setForeground(new java.awt.Color(255, 255, 255));
        tombolHapus.setText("Hapus");
        tombolHapus.setBorder(null);
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 204, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true), "Kepentingan Harga"));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Harga Yang Sangat Penting ke-1");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Harga Cukup Penting ke-3");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Harga biasa ke-3");

        cbSubHarga3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih SubKriteria harga -", "Lebih dari 100000", "Lebih dari 80000", "Kurang atau Sama Dengan 80000" }));

        cbSubHarga2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih SubKriteria harga -", "Lebih dari 100000", "Lebih dari 80000", "Kurang atau Sama Dengan 80000" }));

        cbSubHarga1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih SubKriteria harga -", "Lebih dari 100000", "Lebih dari 80000", "Kurang atau Sama Dengan 80000" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbSubHarga1, 0, 192, Short.MAX_VALUE)
                    .addComponent(cbSubHarga2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbSubHarga3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbSubHarga1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(cbSubHarga2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(cbSubHarga3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel5.setBackground(new java.awt.Color(255, 204, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true), "Kepentingan Varian Rasa"));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Varian Rasa Sangat Penting ke-1");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Varian Rasa Penting ke-2");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Varian Rasa Cukup Penting ke-3");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Varian Rasa biasa ke-4");

        cbSubVarianRasa4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih SubKriteriaVarian Rasa - ", "Sweety", "Creamy", "Milky", "Savory" }));

        cbSubVarianRasa3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih SubKriteriaVarian Rasa - ", "Sweety", "Creamy", "Milky", "Savory" }));

        cbSubVarianRasa2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih SubKriteriaVarian Rasa - ", "Sweety", "Creamy", "Milky", "Savory" }));

        cbSubVarianRasa1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih SubKriteriaVarian Rasa - ", "Sweety", "Creamy", "Milky", "Savory" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addGap(69, 69, 69)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbSubVarianRasa1, javax.swing.GroupLayout.Alignment.LEADING, 0, 257, Short.MAX_VALUE)
                    .addComponent(cbSubVarianRasa4, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbSubVarianRasa3, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbSubVarianRasa2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cbSubVarianRasa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(cbSubVarianRasa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(cbSubVarianRasa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cbSubVarianRasa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 204, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true), "Kepentingan Kualitas"));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Kualitas Yang Sangat Penting ke-1");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Kualitas Cukup Penting ke-3");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Kualitas biasa ke-3");

        cbSubKualitas3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih SubKriteria Kualitas -", "Sangat Baik", "Baik", "Biasa Saja" }));

        cbSubKualitas2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih SubKriteria Kualitas -", "Sangat Baik", "Baik", "Biasa Saja" }));

        cbSubKualitas1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih SubKriteria Kualitas -", "Sangat Baik", "Baik", "Biasa Saja" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbSubKualitas2, javax.swing.GroupLayout.Alignment.TRAILING, 0, 259, Short.MAX_VALUE)
                    .addComponent(cbSubKualitas1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbSubKualitas3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbSubKualitas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSubKualitas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSubKualitas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)))
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true), "Kepentingan Tampilan"));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Tampilan Sangat Penting ke-1");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Tampilan Penting ke-2");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Tampilan Cukup Penting ke-3");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Tampilan biasa ke-4");

        cbSubTampilan4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih SubKriteria Tampilan -", "Toping", "Dekorasi", "Bentuk", "Warna" }));

        cbSubTampilan3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih SubKriteria Tampilan -", "Toping", "Dekorasi", "Bentuk", "Warna" }));

        cbSubTampilan2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih SubKriteria Tampilan -", "Toping", "Dekorasi", "Bentuk", "Warna" }));

        cbSubTampilan1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih SubKriteria Tampilan -", "Toping", "Dekorasi", "Bentuk", "Warna" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbSubTampilan3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbSubTampilan4, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbSubTampilan2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbSubTampilan1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cbSubTampilan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cbSubTampilan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cbSubTampilan3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(cbSubTampilan4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(tombolSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tombolEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tombolHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tombolSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tombolEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tombolHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(572, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1101, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1101, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("SansSerif", 3, 24)); // NOI18N
        jLabel2.setText("Pengaturan Sub Kriteria");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
        // TODO add your handling code here:
        insertDataSubKriteria();
    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void tombolEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolEditActionPerformed
        // TODO add your handling code here:
        editDataSubKriteria();
    }//GEN-LAST:event_tombolEditActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        // TODO add your handling code here:
        hapusDataSubKriteria();
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void tabelSubKriteriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelSubKriteriaMouseClicked
        // TODO add your handling code here:
        getDataTabel();
    }//GEN-LAST:event_tabelSubKriteriaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbSubHarga1;
    private javax.swing.JComboBox<String> cbSubHarga2;
    private javax.swing.JComboBox<String> cbSubHarga3;
    private javax.swing.JComboBox<String> cbSubKualitas1;
    private javax.swing.JComboBox<String> cbSubKualitas2;
    private javax.swing.JComboBox<String> cbSubKualitas3;
    private javax.swing.JComboBox<String> cbSubTampilan1;
    private javax.swing.JComboBox<String> cbSubTampilan2;
    private javax.swing.JComboBox<String> cbSubTampilan3;
    private javax.swing.JComboBox<String> cbSubTampilan4;
    private javax.swing.JComboBox<String> cbSubVarianRasa1;
    private javax.swing.JComboBox<String> cbSubVarianRasa2;
    private javax.swing.JComboBox<String> cbSubVarianRasa3;
    private javax.swing.JComboBox<String> cbSubVarianRasa4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabelSubKriteria;
    private javax.swing.JButton tombolEdit;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolSimpan;
    // End of variables declaration//GEN-END:variables
}
