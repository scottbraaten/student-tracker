import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EmployeeGUI extends JFrame 
{
    // GUI components
    private JTextField txtName, txtHours, txtRate, txtPay;
    private JButton btnCalc, btnClear;
    private Employee emp;

    // constructor builds the GUI
    public EmployeeGUI() 
    {
        // call the superclass constructor to put title on frame
        super("Calculate Employee Pay");
        
        // instantiate components
        txtName = new JTextField(20);
        txtHours = new JTextField(10);
        txtRate = new JTextField(10);
        txtPay = new JTextField(10);
        btnCalc = new JButton("Calculate Pay");
        btnClear = new JButton("Clear");
        
        // create labels and center the text
        JLabel lblName = new JLabel("Name");
        lblName.setHorizontalAlignment(JLabel.CENTER);
        JLabel lblHours = new JLabel("Hours");
        lblHours.setHorizontalAlignment(JLabel.CENTER);
        JLabel lblRate = new JLabel("Rate");
        lblRate.setHorizontalAlignment(JLabel.CENTER);
        JLabel lblPay = new JLabel("Pay");
        lblPay.setHorizontalAlignment(JLabel.CENTER);

        // set layout and add components to frame
        setLayout(new GridLayout(0, 2));
        add(lblName);
        add(txtName);
        add(lblHours);
        add(txtHours);
        add(lblRate);
        add(txtRate);
        add(btnCalc);
        add(btnClear);
        add(lblPay);
        add(txtPay);

        //set up event handlers
        //create an object
        ButtonHandler handler = new ButtonHandler();
        //connect the buttons to the ActionListener using this object
        btnCalc.addActionListener(handler);
        btnClear.addActionListener(handler);

        // create Employee object
        emp = new Employee();
    }

    // inner class to implement ActionListener
    private class ButtonHandler implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            //code to process the button events goes here
            if (e.getSource() == btnCalc) {
                //get input from GUI and pass to object
                if (txtName.getText().isEmpty()
                        || txtHours.getText().isEmpty()
                        || txtRate.getText().isEmpty()) //missing input
                {
                    JOptionPane.showMessageDialog(null, "Please provide all input");
                    return;
                }
                emp.setName(txtName.getText());

                try 
                {
                    emp.setHours(Double.parseDouble(txtHours.getText()));
                    emp.setRate(Double.parseDouble(txtRate.getText()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Hours, rate must be numeric");
                }

                //display result on GUI
                double pay = emp.getPay();
                DecimalFormat fmt = new DecimalFormat("$#,##0.00");  // currency format
                txtPay.setText(fmt.format(pay));

            } 
            else if (e.getSource() == btnClear) 
            {
                // JOptionPane.showMessageDialog(null, "Clear clicked");
                txtName.setText("");
                txtHours.setText("");
                txtRate.setText("");
                txtPay.setText("");
                txtName.requestFocus();  // move insertion to txtName
            }
        }

    }

}
