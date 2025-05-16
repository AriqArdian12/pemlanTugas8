import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Agar tampilan terlihat lebih baik
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Menjalankan file
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormPendaftaranMahasiswa().setVisible(true);
            }
        });
    }
}
