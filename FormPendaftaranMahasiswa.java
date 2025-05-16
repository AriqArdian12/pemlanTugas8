import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormPendaftaranMahasiswa extends JFrame {
    private JTextField txtNamaLengkap, txtTanggalLahir, txtNomorPendaftaran, txtNoTelp, txtEmail;
    private JTextArea txtAlamat;
    private JButton btnSubmit;
    
    public FormPendaftaranMahasiswa() {
        // Set properti frame
        setTitle("Form Pendaftaran Mahasiswa Baru");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initComponents();
    }
    
    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(240, 240, 245));
        
        JLabel lblTitle = new JLabel("Form Pendaftaran Mahasiswa Baru", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2, 10, 15));
        formPanel.setBackground(new Color(240, 240, 245));
        
        JLabel lblNamaLengkap = new JLabel("Nama Lengkap:");
        txtNamaLengkap = new JTextField(20);
        
        JLabel lblTanggalLahir = new JLabel("Tanggal Lahir (DD-MM-YYYY):");
        txtTanggalLahir = new JTextField(20);
        
        JLabel lblNomorPendaftaran = new JLabel("Nomor Pendaftaran:");
        txtNomorPendaftaran = new JTextField(20);
        
        JLabel lblNoTelp = new JLabel("No. Telp:");
        txtNoTelp = new JTextField(20);
        
        JLabel lblAlamat = new JLabel("Alamat:");
        txtAlamat = new JTextArea(3, 20);
        txtAlamat.setLineWrap(true);
        txtAlamat.setWrapStyleWord(true);
        JScrollPane scrollAlamat = new JScrollPane(txtAlamat);
        
        JLabel lblEmail = new JLabel("E-mail:");
        txtEmail = new JTextField(20);
        
        // Menambahkan komponen ke form panel
        formPanel.add(lblNamaLengkap);
        formPanel.add(txtNamaLengkap);
        formPanel.add(lblTanggalLahir);
        formPanel.add(txtTanggalLahir);
        formPanel.add(lblNomorPendaftaran);
        formPanel.add(txtNomorPendaftaran);
        formPanel.add(lblNoTelp);
        formPanel.add(txtNoTelp);
        formPanel.add(lblAlamat);
        formPanel.add(scrollAlamat);
        formPanel.add(lblEmail);
        formPanel.add(txtEmail);
        
        // Panel untuk button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 240, 245));
        btnSubmit = new JButton("Submit");
        buttonPanel.add(btnSubmit);
        
        // Menambahkan action listener untuk button submit
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateForm()) {
                    showConfirmationDialog();
                }
            }
        });
        
        // Menambahkan semua panel ke main panel
        mainPanel.add(lblTitle, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Menambahkan main panel ke frame
        add(mainPanel);
    }
    
    // Validasi form untuk memastikan semua field terisi
    private boolean validateForm() {
        StringBuilder errorMessage = new StringBuilder("Mohon lengkapi kolom berikut:\n");
        boolean isValid = true;
        
        if (txtNamaLengkap.getText().trim().isEmpty()) {
            errorMessage.append("- Nama Lengkap\n");
            isValid = false;
        }
        
        if (txtTanggalLahir.getText().trim().isEmpty()) {
            errorMessage.append("- Tanggal Lahir\n");
            isValid = false;
        }
        
        if (txtNomorPendaftaran.getText().trim().isEmpty()) {
            errorMessage.append("- Nomor Pendaftaran\n");
            isValid = false;
        }
        
        if (txtNoTelp.getText().trim().isEmpty()) {
            errorMessage.append("- No. Telp\n");
            isValid = false;
        }
        
        if (txtAlamat.getText().trim().isEmpty()) {
            errorMessage.append("- Alamat\n");
            isValid = false;
        }
        
        if (txtEmail.getText().trim().isEmpty()) {
            errorMessage.append("- E-mail\n");
            isValid = false;
        }
        
        if (!isValid) {
            JOptionPane.showMessageDialog(this, errorMessage.toString(), "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
        
        return isValid;
    }
    
    // Menampilkan teks konfirmasi
    private void showConfirmationDialog() {
        int option = JOptionPane.showConfirmDialog(this, 
                "Apakah Anda yakin data yang Anda isi sudah benar?", 
                "Konfirmasi Data", 
                JOptionPane.OK_CANCEL_OPTION, 
                JOptionPane.QUESTION_MESSAGE);
        
        if (option == JOptionPane.OK_OPTION) {
            // Jika memilih OK, buat objek data mahasiswa dan kirim ke tampilan data
            DataMahasiswa data = new DataMahasiswa(
                txtNamaLengkap.getText(),
                txtTanggalLahir.getText(),
                txtNomorPendaftaran.getText(),
                txtNoTelp.getText(),
                txtAlamat.getText(),
                txtEmail.getText()
            );
            
            // Tampilkan frame data mahasiswa
            new DataMahasiswaFrame(data, this).setVisible(true);
        }
        // Jika memilih CANCEL, kembali ke form tanpa melakukan apa-apa
    }
}
