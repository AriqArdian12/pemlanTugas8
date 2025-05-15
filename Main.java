import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Set look and feel untuk tampilan yang lebih baik
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Jalankan aplikasi
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormPendaftaranMahasiswa().setVisible(true);
            }
        });
    }
}