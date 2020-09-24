import java.awt.AWTException;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.SystemColor;

public class gui {

	private JFrame frame;
	private JPasswordField code;
	private JTextField user;
	private JFrame popupframe;
	private JTextField namefile;
	private JPanel panel1;
	private JTextField Usignup;
	private JPasswordField Psignup;

	private ArrayList<String> lines = new ArrayList<String>();
	private HashMap<String, String> users = new HashMap<String, String>();
	private JTextField entername;
	private JTextField outputuser;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public gui() {
		initialize();
	}

	public void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setOpacity(1f);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);

		panel1 = new JPanel();
		frame.getContentPane().add(panel1);
		panel1.setLayout(null);
		panel1.setVisible(true);
		panel1.setBackground(SystemColor.control);

		final JPanel panel2 = new JPanel();
		frame.getContentPane().add(panel2);
		panel2.setLayout(null);

		final JPanel panel3 = new JPanel();
		frame.getContentPane().add(panel3);
		panel3.setLayout(null);

		// YES OR NO
		final JPanel panel4 = new JPanel();
		frame.getContentPane().add(panel4);
		panel4.setLayout(null);
		panel4.setVisible(false);

		final JPanel panel5 = new JPanel();
		frame.getContentPane().add(panel5);
		panel5.setLayout(null);

		final JPanel contentPage = new JPanel();
		frame.getContentPane().add(contentPage);
		contentPage.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Notepad");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 33, 154, 14);
		contentPage.add(lblNewLabel_1);

		JButton gotonotepad = new JButton("REDIRECT");
		gotonotepad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPage.setVisible(false);
				panel2.setVisible(true);
			}
		});
		gotonotepad.setBounds(174, 29, 114, 23);
		contentPage.add(gotonotepad);

		JLabel lblNewLabel_2 = new JLabel("Username Generator");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 77, 154, 23);
		contentPage.add(lblNewLabel_2);

		JButton gottoug = new JButton("REDIRECT");
		gottoug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPage.setVisible(false);
				panel5.setVisible(true);

			}
		});
		gottoug.setBounds(174, 73, 114, 23);
		contentPage.add(gottoug);

		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setBounds(10, 120, 154, 14);
		contentPage.add(lblSignUp);

		JButton gotosignup = new JButton("REDIRECT");
		gotosignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPage.setVisible(false);
				panel3.setVisible(true);
			}
		});
		gotosignup.setBounds(174, 116, 114, 23);
		contentPage.add(gotosignup);

		JButton btnPrevPage = new JButton("Prev Page");
		btnPrevPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel5.setVisible(false);
				panel2.setVisible(true);

			}
		});
		btnPrevPage.setBounds(47, 227, 114, 23);
		panel5.add(btnPrevPage);

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel5.setVisible(false);
				panel1.setVisible(true);
			}
		});
		btnLogOut.setBounds(345, 11, 89, 23);
		panel5.add(btnLogOut);

		JLabel namegen = new JLabel("Username Generator");
		namegen.setHorizontalAlignment(SwingConstants.CENTER);
		namegen.setBounds(108, 45, 231, 14);
		panel5.add(namegen);

		entername = new JTextField();
		entername.setBounds(108, 70, 221, 20);
		panel5.add(entername);
		entername.setColumns(10);

		outputuser = new JTextField();
		outputuser.setBounds(108, 181, 221, 20);
		panel5.add(outputuser);
		outputuser.setColumns(10);

		JLabel displayyouruser = new JLabel("");
		displayyouruser.setHorizontalAlignment(SwingConstants.CENTER);
		displayyouruser.setBounds(98, 80, 46, 14);
		panel5.add(displayyouruser);

		JLabel labelname = new JLabel("Name");
		labelname.setHorizontalAlignment(SwingConstants.CENTER);
		labelname.setBounds(31, 73, 89, 14);
		panel5.add(labelname);
		panel5.setVisible(false);

		Random rand = new Random();

		JButton generateuser = new JButton("Generate");
		generateuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// String generatedname = entername.getText() + enterhobby.getText() +
				// enternum.getText();
				// outputuser.setText(generatedname);

				ArrayList<String> genUsername = new ArrayList<String>();
				try {
					Scanner fileReader = new Scanner(
							new FileReader("C://Users//BeepBloop//Desktop//program-essentials//generatednames.txt"));
					while (fileReader.hasNext()) {
						String line = fileReader.nextLine();
						genUsername.add(line);

					}
					// System.out.println(genUsername);
				} catch (FileNotFoundException e) {
				}

				ArrayList<String> genNumprefix = new ArrayList<String>();
				try {
					Scanner fileReader = new Scanner(
							new FileReader("C://Users//BeepBloop//Desktop//program-essentials//numberprefix.txt"));
					while (fileReader.hasNext()) {
						String line = fileReader.nextLine();
						genNumprefix.add(line);

					}
					// System.out.println(genUsername);
				} catch (FileNotFoundException e) {
				}

				// for (int i = 0; i < 10; i++) {
				// System.out.print(rand.nextInt());
				// }

				String word = genUsername.get(rand.nextInt(genUsername.size()));

				String numpre = genNumprefix.get(rand.nextInt(genNumprefix.size()));

				String generatedname = "";

				if (rand.nextInt(2) == 0) {
					generatedname = entername.getText() + word + numpre;

				} else {
					generatedname = word + entername.getText() + numpre;
				}

				System.out.println("Your user name has been generated:" + generatedname);

				outputuser.setText(generatedname);
			}

		});
		generateuser.setBounds(178, 99, 89, 23);
		panel5.add(generateuser);

		JLabel displayoutcome = new JLabel("");
		displayoutcome.setHorizontalAlignment(SwingConstants.CENTER);
		displayoutcome.setBounds(193, 166, 46, 14);
		panel5.add(displayoutcome);

		try {
			Scanner fileReader = new Scanner(new FileReader("C://Users//BeepBloop//Desktop//program-essentials//signupDB.txt"));
			while (fileReader.hasNext()) {
				String line = fileReader.nextLine();
				lines.add(line);
				String[] whole = line.split(" ");
				users.put(whole[0], whole[1]);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			try (PrintWriter signupDBsave = new PrintWriter("C://Users//BeepBloop//Desktop//program-essentials//signupDB.txt")) {
				for (String s : lines) {
					signupDBsave.println(s);
				}
			} catch (FileNotFoundException f) {
			}
			users.put("a", "1");
		}

		System.out.println(users);

		JButton nextpage2 = new JButton("Next Pg");
		nextpage2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (true) {
					nextpage2.setVisible(true);
					panel3.setVisible(false);
					// panel4.setVisible(true);
				}

			}
		});

		JRadioButton but1 = new JRadioButton("");

		JLabel lblRedirectingBackTo = new JLabel("");
		lblRedirectingBackTo.setFont(new Font("Vrinda", Font.PLAIN, 18));
		lblRedirectingBackTo.setForeground(Color.BLACK);
		lblRedirectingBackTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRedirectingBackTo.setBounds(32, 209, 380, 52);
		panel4.add(lblRedirectingBackTo);
		lblRedirectingBackTo.setVisible(false);

		JTextArea entertext = new JTextArea();
		entertext.setRows(8);
		entertext.setBounds(36, 38, 359, 172);
		panel2.add(entertext);
		entertext.setVisible(false);
		entertext.setLineWrap(true);

		JProgressBar prog = new JProgressBar();
		prog.setValue(100);
		prog.setForeground(Color.RED);
		prog.setBounds(26, 11, 19, 16);
		panel2.add(prog);
		// Scanner readtext = new Scanner(System.in);

		JButton savebutton = new JButton("Save");
		savebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (true) {

					int imgCount = 0;
					String ext3 = ".jpg";
					int num3 = 5;

					for (int t = 0; t < num3; t++) {
						// take screen shot
						Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
						BufferedImage capture = null;
						try {
							capture = new Robot().createScreenCapture(screenRect);
						} catch (AWTException e1) {
							e1.printStackTrace();
						}
						// save screen shot
						try {
							File file = new File("C://Users//BeepBloop//Desktop//program-essentials//textsc");
							if (!file.exists()) {
								file.mkdir();
							}
							File l = new File("C://Users//BeepBloop//Desktop//program-essentials//textsc//img" + imgCount + ext3);
							if (!l.exists()) {
								ImageIO.write(capture, "jpg", l);
							}
							if (l.exists()) {
								ImageIO.write(capture, "jpg", l);
							}

							imgCount++;
						} catch (IOException e) {
							e.printStackTrace();
						}

						try {
							Thread.sleep(1);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}

					lblRedirectingBackTo.setText("");

					panel4.setVisible(true);
					panel2.setVisible(false);

				}
			}
		});

		savebutton.setBounds(166, 221, 89, 23);
		panel2.add(savebutton);
		// defaults to invisible
		savebutton.setVisible(false);

		JLabel greet = DefaultComponentFactory.getInstance().createLabel("Disabled");
		greet.setBounds(53, 11, 229, 14);
		panel2.add(greet);

		JLabel lblSucce = new JLabel("");
		lblSucce.setHorizontalAlignment(SwingConstants.CENTER);
		lblSucce.setBounds(18, 166, 410, 14);
		panel1.add(lblSucce);

		JButton logout2 = new JButton("Sign In");
		logout2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (true) {
					panel3.setVisible(false);
					panel1.setVisible(true);
					lblSucce.setText("");
					user.setText("");
					code.setText("");
					Usignup.setText("");
					Psignup.setText("");
					entertext.setText("");
					greet.setText("Disabled");
					prog.setForeground(Color.RED);
				}
			}
		});
		logout2.setBounds(335, 7, 89, 23);
		panel3.add(logout2);

		JButton signoutcp = new JButton("SIGN OUT");
		signoutcp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPage.setVisible(false);
				panel1.setVisible(true);
				lblSucce.setText("");
				lblSucce.setForeground(null);

			}
		});

		Usignup = new JTextField();
		Usignup.setBounds(143, 80, 146, 20);
		panel3.add(Usignup);
		Usignup.setColumns(10);

		Psignup = new JPasswordField();
		Psignup.setBounds(143, 124, 146, 20);
		panel3.add(Psignup);

		JLabel lblNewLabel = new JLabel("SIGN UP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(143, 55, 146, 14);
		panel3.add(lblNewLabel);

		JLabel signuplabel = new JLabel("");
		signuplabel.setHorizontalAlignment(SwingConstants.CENTER);
		signuplabel.setBounds(10, 188, 424, 14);
		panel3.add(signuplabel);
		signuplabel.setForeground(null);

		JButton completeReg = new JButton("AUTHORIZE");
		completeReg.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				if (true) {

					Usignup.getText();
					Psignup.getText();

					String userInput = Usignup.getText();
					String passInput = Psignup.getText();

					userInput = userInput.replaceAll(" ", "");
					passInput = passInput.replaceAll(" ", "");

					if (userInput.equals("") || passInput.equals("")) {
						System.out.println("");
						System.out.println("Please try again");
						signuplabel.setForeground(Color.RED);
						signuplabel.setText("Please Try Again");

					} else {
						System.out.println("UserName : " + userInput);
						System.out.println("Password : " + passInput);
						signuplabel.setForeground(Color.BLACK);
						signuplabel.setText("Your login details are ready for use!");
					}

					String savedsignupDB = Usignup.getText() + " " + Psignup.getText();
					lines.add(savedsignupDB);

					users.put(userInput, passInput);

					try (PrintWriter signupDBsave = new PrintWriter("C://Users//BeepBloop//Desktop//program-essentials//signupDB.txt")) {
						for (String s : lines) {
							signupDBsave.println(s);
						}
					} catch (FileNotFoundException d) {
						d.printStackTrace();
					}
				}

			}
		});

		completeReg.setBounds(160, 154, 116, 23);
		panel3.add(completeReg);

		JButton nextpage = new JButton("Next Pg");
		nextpage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (true) {
					panel2.setVisible(false);
					panel5.setVisible(true);
					nextpage2.setVisible(true);
					logout2.setVisible(true);

				}

			}
		});
		nextpage.setBounds(265, 221, 89, 23);
		panel2.add(nextpage);
		nextpage.setVisible(false);

		// label which is present once u press the button to login

		JButton logout = new JButton("Log Out");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (true) {
					lblSucce.setText("");
					user.setText("");
					code.setText("");
					but1.setSelected(false);
					savebutton.setVisible(false);
					entertext.setVisible(false);
					nextpage.setVisible(false);
					logout.setVisible(false);
					panel2.setVisible(false);
					panel1.setVisible(true);
					entertext.setText("");
					greet.setText("Disabled");
					prog.setForeground(Color.RED);
				}
			}
		});
		logout.setBounds(335, 7, 89, 23);
		panel2.add(logout);
		logout.setVisible(false);

		// select button which determines the options below

		but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (but1.isSelected()) {

					// once clicked, colour changes to green and shows label (Enabled)
					prog.setForeground(Color.GREEN);
					greet.setText("Enabled");
					// sets the items below to visible
					entertext.setVisible(true);
					savebutton.setVisible(true);
					nextpage.setVisible(true);
					logout.setVisible(true);

				} else {
					// once clicked, colour changes to red and shows label (Disabled)
					prog.setForeground(Color.RED);
					greet.setText("Disabled");
					// sets items below to invisible
					savebutton.setVisible(false);
					entertext.setVisible(false);
					nextpage.setVisible(false);
					logout.setVisible(false);

				}
			}
		});
		but1.setBounds(6, 7, 19, 23);
		panel2.add(but1);

		// Login in button
		JButton log = new JButton("AUTHORIZE");
		log.setForeground(Color.BLACK);
		///

		log.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// If user input us correct, text label as login successful
				String username = user.getText();
				String pass = code.getText();
				username = username.replaceAll(" ", "");
				pass = pass.replaceAll(" ", "");

				if (users.containsKey(username)) {
					if (users.get(username).equals(pass)) {

						lblSucce.setText("Login Successful");
						lblSucce.setForeground(Color.GREEN);
						//
						int imgCount = 0;
						String ext1 = ".jpg";
						int num1 = 5;

						for (int h = 0; h < num1; h++) {
							// take screen shot
							Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
							BufferedImage capture = null;
							try {
								capture = new Robot().createScreenCapture(screenRect);
							} catch (AWTException e1) {
								e1.printStackTrace();
							}
							// save screen shot
							try {
								File file = new File("C://Users//BeepBloop//Desktop//program-essentials//login-image");
								if (!file.exists()) {
									file.mkdir();
								}
								File g = new File("C://Users//BeepBloop//Desktop//program-essentials//login-image//img" + imgCount + ext1);
								if (!g.exists()) {
									ImageIO.write(capture, "jpg", g);
								}
								if (g.exists()) {
									ImageIO.write(capture, "jpg", g);
								}
								imgCount++;
							} catch (IOException e) {
								e.printStackTrace();
							}

							try {
								Thread.sleep(0);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}

						///
						new java.util.Timer().schedule(new java.util.TimerTask() {
							// Opens panel2 and close panel 1
							public void run() {
								lblSucce.setText("Please click Authorize again");
								lblSucce.setForeground(Color.YELLOW);

							}
						}, 700);

						// timer before closing panel 1
						new java.util.Timer().schedule(new java.util.TimerTask() {
							// Opens panel2 and close panel 1
							public void run() {
								panel1.setVisible(false);
								contentPage.setVisible(true);

								user.setText("");
								code.setText("");

							}
						}, 650);

					}
				} else {
					// if login is incorrect, print this
					lblSucce.setText("UNAUTHORIZED!");
					lblSucce.setForeground(Color.RED);

				}
			}
		});
		log.setBounds(165, 125, 109, 30);
		panel1.add(log);

		// where you enter password
		code = new JPasswordField();
		code.setBounds(143, 94, 151, 20);
		panel1.add(code);
		// where you enter user-name
		user = new JTextField();
		user.setBounds(143, 63, 151, 20);
		panel1.add(user);
		user.setColumns(10);

		signoutcp.setBounds(339, 11, 95, 23);
		contentPage.add(signoutcp);

		JButton signupbtn = new JButton("Sign Up");
		signupbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel1.setVisible(false);
				panel3.setVisible(true);
			}
		});
		signupbtn.setBounds(339, 11, 89, 23);
		panel1.add(signupbtn);

		// cannot enlarge window

		namefile = new JTextField();
		namefile.setHorizontalAlignment(SwingConstants.CENTER);
		namefile.setBounds(67, 66, 308, 20);
		panel4.add(namefile);
		namefile.setColumns(10);

		JLabel lblPleaseChooseYour = new JLabel("Please choose your file name");
		lblPleaseChooseYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseChooseYour.setBounds(67, 28, 308, 14);
		panel4.add(lblPleaseChooseYour);

		JLabel saved = new JLabel("");
		saved.setHorizontalAlignment(SwingConstants.CENTER);
		saved.setBounds(67, 184, 308, 14);
		panel4.add(saved);

		JLabel displayrename = new JLabel("");
		displayrename.setForeground(Color.GRAY);
		displayrename.setFont(new Font("Tahoma", Font.PLAIN, 15));
		displayrename.setHorizontalAlignment(SwingConstants.CENTER);
		displayrename.setBounds(67, 200, 308, 14);
		panel4.add(displayrename);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int imgCount = 0;
				String ext4 = ".jpg";
				int num4 = 5;

				for (int i = 0; i < num4; i++) {
					// take screen shot
					Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
					BufferedImage capture = null;
					try {
						capture = new Robot().createScreenCapture(screenRect);
					} catch (AWTException e1) {
						e1.printStackTrace();
					}
					// save screen shot
					try {
						File file = new File("C://Users//BeepBloop//Desktop//program-essentials//savedtext");
						if (!file.exists()) {
							file.mkdir();
						}
						File f = new File("C://Users//BeepBloop//Desktop//program-essentials//savedtext//img" + imgCount + ext4);
						if (!f.exists()) {
							ImageIO.write(capture, "jpg", f);
						}
						if (f.exists()) {
							ImageIO.write(capture, "jpg", f);
						}

						imgCount++;
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					try {
						Thread.sleep(0);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}

				// save the input
				String savedtext = entertext.getText();

				String rename = namefile.getText();

				try (PrintWriter savetofile = new PrintWriter("C://Users//BeepBloop//Desktop//" + rename + ".txt")) {
					savetofile.println(savedtext);
				} catch (FileNotFoundException d) {

					d.printStackTrace();
				}

				System.out.println("File Saved!");
				System.out.println("-------------------");
				System.out.println("-----------------");
				System.out.println("---------------");
				System.out.println("-------------");

				saved.setText("Your File has been saved to the desktop with the name");
				displayrename.setText(rename);

				new java.util.Timer().schedule(new java.util.TimerTask() {

					public void run() {

						lblRedirectingBackTo.setVisible(true);

					}

				}, 120);

				lblRedirectingBackTo.setText("REDIRECTING BACK TO PREVIOUS PAGE");

				// timer before closing panel 4
				new java.util.Timer().schedule(new java.util.TimerTask() {
					// Opens panel2 and close panel 4
					public void run() {
						panel4.setVisible(false);
						panel2.setVisible(true);

					}

				}, 2220);

			}
		});
		btnNewButton.setBounds(176, 97, 89, 23);
		panel4.add(btnNewButton);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			panel4.setVisible(false);
			panel2.setVisible(true);
			
			}
		});
		btnGoBack.setBounds(176, 126, 89, 23);
		panel4.add(btnGoBack);

		// screen stuff

		int imgCount = 0;
		String ext = ".jpg";
		int num = 5;

		for (int i = 0; i < num; i++) {
			// take screen shot
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage capture = null;
			try {
				capture = new Robot().createScreenCapture(screenRect);
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
			// save screen shot
			try {
				File file = new File("Desktop//menuimage");
				if (!file.exists()) {
					file.mkdir();
				}
				File f = new File("C://Users//BeepBloop//Desktop//program-essentials//menuimage//menusc" + imgCount + ext);
				if (!f.exists()) {
					ImageIO.write(capture, "jpg", f);
				}
				if (f.exists()) {
					ImageIO.write(capture, "jpg", f);
				}
				imgCount++;
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			/// get image for icon
			Image icon = Toolkit.getDefaultToolkit().getImage("program-essentials//162332-200.png");
			frame.setIconImage(icon);
			///

		}
		// end of screen stuff

	}

	public static void p(Object ob) {
		System.out.println(ob);
		// MAKES LIFE A LOT EASIER.
	}
}
