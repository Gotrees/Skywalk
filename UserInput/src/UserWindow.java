import javax.swing.JFrame;


public class UserWindow {

	public static void main(String[] args) {
		JFrame j1 = new JFrame();
		j1.setSize(1000, 700);
		j1.setTitle("Skywalker");
		j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UserComp u1 = new UserComp();
		j1.add(u1);
		j1.setVisible(true);
	}

}
