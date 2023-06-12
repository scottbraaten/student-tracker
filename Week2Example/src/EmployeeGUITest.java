import javax.swing.JFrame;

public class EmployeeGUITest 
{
	public static void main(String[] args) 
    	{
		EmployeeGUI frame = new EmployeeGUI();
		frame.setSize(400, 200);  //these numbers are in pixels
                frame.setLocationRelativeTo(null);  // center frame on monitor
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
