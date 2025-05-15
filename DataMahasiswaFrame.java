import javax.swing.*;
import java.awt.*;

public class DataMahasiswaFrame extends JFrame {
    private DataMahasiswa data;
    private JFrame parentFrame;
    
    public DataMahasiswaFrame(DataMahasiswa data, JFrame parentFrame) {
        this.data = data;
        this.parentFrame = parentFrame;
        
        // Set properti frame
        setTitle("Data Mahasiswa");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parentFrame);
        
        initComponents();
    }
    
    private void initComponents() {
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BorderLayout(10, 10));
        dataPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        dataPanel.setBackground(new Color(230, 230, 235));
        
        JLabel lblDataTitle = new JLabel("Data Mahasiswa", JLabel.CENTER);
        lblDataTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblDataTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        
        // Panel untuk display data
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(6, 1, 5, 10));
        infoPanel.setBackground(new Color(230, 230, 235));
        infoPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        
        // Membuat label untuk data
        JLabel lblNama = new JLabel("Nama             : " + data.getNamaLengkap());
        JLabel lblTanggal = new JLabel("Tanggal Lahir   : " + data.getTanggalLahir());
        JLabel lblNoPendaftaran = new JLabel("No.Pendaftaran : " + data.getNomorPendaftaran());
        JLabel lblTelp = new JLabel("No.Telp         : " + data.getNoTelp());
        JLabel lblAlamatInfo = new JLabel("Alamat          : " + data.getAlamat());
        JLabel lblEmailInfo = new JLabel("E-mail          : " + data.getEmail());
        
        // Menambahkan label ke info panel
        infoPanel.add(lblNama);
        infoPanel.add(lblTanggal);
        infoPanel.add(lblNoPendaftaran);
        infoPanel.add(lblTelp);
        infoPanel.add(lblAlamatInfo);
        infoPanel.add(lblEmailInfo);
        
        // Menambahkan komponen ke data panel
        dataPanel.add(lblDataTitle, BorderLayout.NORTH);
        dataPanel.add(infoPanel, BorderLayout.CENTER);
        
        // Menambahkan panel ke frame
        add(dataPanel);
    }
}