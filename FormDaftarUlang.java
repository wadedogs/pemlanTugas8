import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormDaftarUlang extends JFrame {
    private JTextField txtNama, txtEmail, txtTelepon;
    private JComboBox<String> cbProdi;
    private JCheckBox cbSetuju;
    private JTextArea taAlamat;
    private JButton btnSubmit, btnReset;
    private Color primaryColor = new Color(0, 102, 204);

    public FormDaftarUlang() {
        setTitle("Formulir Daftar Ulang Mahasiswa Baru");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(primaryColor);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        JLabel lblTitle = new JLabel("FORMULIR DAFTAR ULANG");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setForeground(Color.WHITE);
        headerPanel.add(lblTitle);
        add(headerPanel, BorderLayout.NORTH);
        
        // Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(7, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Komponen Form
        formPanel.add(new JLabel("Nama Lengkap:"));
        txtNama = new JTextField();
        formPanel.add(txtNama);
        
        formPanel.add(new JLabel("Program Studi:"));
        String[] prodiList = {"-- Pilih Prodi --", "Teknik Informatika", "Sistem Informasi", 
                             "Manajemen", "Akuntansi"};
        cbProdi = new JComboBox<>(prodiList);
        formPanel.add(cbProdi);
        
        formPanel.add(new JLabel("Alamat:"));
        taAlamat = new JTextArea(3, 20);
        JScrollPane scrollPane = new JScrollPane(taAlamat);
        formPanel.add(scrollPane);
        
        formPanel.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        formPanel.add(txtEmail);
        
        formPanel.add(new JLabel("No. Telepon:"));
        txtTelepon = new JTextField();
        formPanel.add(txtTelepon);
        
        formPanel.add(new JLabel(""));
        cbSetuju = new JCheckBox("Data yang saya isi benar");
        formPanel.add(cbSetuju);
        
        add(formPanel, BorderLayout.CENTER);
        
        // Button Panel
        JPanel buttonPanel = new JPanel();
        btnReset = new JButton("Reset");
        btnReset.addActionListener(e -> resetForm());
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setBackground(primaryColor);
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.addActionListener(e -> submitForm());
        
        buttonPanel.add(btnReset);
        buttonPanel.add(btnSubmit);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void resetForm() {
        txtNama.setText("");
        txtEmail.setText("");
        txtTelepon.setText("");
        taAlamat.setText("");
        cbProdi.setSelectedIndex(0);
        cbSetuju.setSelected(false);
    }
    
    private void submitForm() {
        if (txtNama.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama lengkap harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (cbProdi.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Program studi harus dipilih!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (taAlamat.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Alamat harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (txtEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (txtTelepon.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nomor telepon harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!cbSetuju.isSelected()) {
            JOptionPane.showMessageDialog(this, "Anda harus menyetujui pernyataan!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Apakah anda yakin data yang Anda isi sudah benar?",
            "Konfirmasi Data",
            JOptionPane.OK_CANCEL_OPTION
        );
        
        if (confirm == JOptionPane.OK_OPTION) {
            showSummary();
        }
    }
    
    private void showSummary() {
        String summary = "=== DATA PENDAFTARAN ULANG ===\n\n" +
                        "Nama: " + txtNama.getText() + "\n" +
                        "Prodi: " + cbProdi.getSelectedItem() + "\n" +
                        "Alamat: " + taAlamat.getText() + "\n" +
                        "Email: " + txtEmail.getText() + "\n" +
                        "Telepon: " + txtTelepon.getText() + "\n\n" +
                        "Terima kasih telah mendaftar!";
        
        JOptionPane.showMessageDialog(
            this,
            summary,
            "Ringkasan Data",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormDaftarUlang form = new FormDaftarUlang();
            form.setVisible(true);
        });
    }
}
