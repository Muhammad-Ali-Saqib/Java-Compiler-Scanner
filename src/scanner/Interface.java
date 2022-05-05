package scanner;

import java.util.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.io.*;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import java.awt.Label;
import javax.swing.border.TitledBorder;



public class Interface {

	private JFrame frame;
	private static JFileChooser fileopen;
	StringBuilder sb;
	StringTokenizer stk;
	DefaultTableModel model;
	int returnValue = -1;
	boolean check=false;
	private JTable tokentable;
	private JTable literaltable;
	static int count=1;
	static int sr=1;
	static int slr=1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
		fileopen =new JFileChooser();
		sb = new StringBuilder();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBounds(0, 0, 986, 751);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 0, 970, 81);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Java Scanner");
		lblNewLabel.setBounds(341, 11, 288, 58);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(0, 76, 970, 636);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setAutoscrolls(true);
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		panel_2.setLayout(null);
		
		Label label_2 = new Label("Literal Table");
		label_2.setBounds(738, 163, 125, 22);
		panel_2.add(label_2);
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setAutoscrolls(true);
		scrollPane_1.setBounds(658, 187, 261, 430);
		panel_2.add(scrollPane_1);
		
		//String[] columns_header= {"Sr no.","Token","Discription","Line no."};
		literaltable = new JTable();
		scrollPane_1.setViewportView(literaltable);
		literaltable.setBackground(SystemColor.controlHighlight);
		literaltable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Sr no.", "Literal", "Line no."
			}
		));
		
		literaltable.getColumnModel().getColumn(0).setResizable(false);
		literaltable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setAutoscrolls(true);
		scrollPane_2.setBounds(347, 191, 261, 426);
		panel_2.add(scrollPane_2);
		
		//String [][] data= {{"","","","",""}};
		tokentable = new JTable();
		scrollPane_2.setViewportView(tokentable);
		tokentable.setBackground(SystemColor.control);
		tokentable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Sr no.", "Token", "Discription", "Line no."
			}
		));
		
		tokentable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		Label label_1 = new Label("Token Table");
		label_1.setBounds(413, 163, 140, 22);
		panel_2.add(label_1);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(50, 192, 247, 425);
		panel_2.add(scrollPane_3);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_3.setViewportView(textArea_1);
		textArea_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textArea_1.setBackground(SystemColor.controlHighlight);
		
		Label label_3 = new Label("Preprocessed file");
		label_3.setBounds(57, 157, 180, 28);
		panel_2.add(label_3);
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1, 6, 968, 107);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel lblfilename = new JLabel("File Name");
		lblfilename.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblfilename.setBounds(174, 31, 257, 40);
		panel_1.add(lblfilename);
		lblfilename.setAutoscrolls(true);
		lblfilename.setHorizontalAlignment(SwingConstants.LEFT);
		lblfilename.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		
		
		
		//***************************************************************************************************************************************************
		
		
		JButton btnNewButton_1 = new JButton("Scan File");
		btnNewButton_1.setBounds(490, 31, 134, 40);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (returnValue == -1)
				{
					 JOptionPane.showMessageDialog(null, "First choose the file ", "InfoBox: File not choosed", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					preprocessing();				
					Display();
					textArea_1.setText(sb.toString());		
					filltables();
					
				}
			}
		});
		
		//****************************************************************************************************************************************************

		
		//*****************************************************************************************************************************************
		JButton btnNewButton = new JButton("Open File...");
		btnNewButton.setBounds(22, 31, 134, 40);
		panel_1.add(btnNewButton);
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				returnValue = fileopen.showOpenDialog(null);
				
				lblfilename.setText(fileopen.getName(fileopen.getSelectedFile()));
			}
		});
	}
	
	//*****************************************************************************************************************************************
	
	/**
	 * Pre-processing
	 */
	public static boolean preprocessing() 
	{
		        
				File file1 = fileopen.getSelectedFile();//input file
				try {
					FileWriter writer = new FileWriter("C://Users/Saqib/Desktop/prog.txt");// writing file
					
					FileReader reader = new FileReader(file1);
					int c;
					int next;					
					
					while((c=reader.read())!=-1)
					{
						
						if((char)c=='/')
							
						{
							if((next=reader.read())=='*')
							{
								c = reader.read();
								while((char)(next=reader.read())!='/' || (char)c!='*')
								{
									c =next;
								}
							}
							else if(next == '/')
							{
								while((char)(  next=reader.read())!='\n')
								{
									
								}
							}
							else
							{
								writer.write((char)c);
								writer.write((char)next);
							}
						}
						else
						{
							writer.write((char)c);
						}
						//writer.write((char)c);
						if((char)c == '\n')
						{
							//counter++;
						}
						//System.out.println((char)c);
					}
					reader.close();
					writer.close();
					//System.out.print("no of lines:");
					//System.out.println(counter);
				}
					catch (Exception e) {
					System.out.print(e);
					}
				return true;
	}
	
	String checkkeyword(String s)
	{
		switch(s)
		{
		case "int":
			return s;
		case "abstract":
			return s;
		case "boolean":
			return s;
		case "break":
			return s;
		case "byte":
			return s;
		case "case":
			return s;
		case "catch":
			return s;
		case "char":
			return s;
		case "class":
			return s;
		case "continue":
			return s;
		case "default":
			return s;
		case "do":
			return s;
		case "double":
			return s;
		case "else":
			return s;
		case "enum":
			return s;
		case "extends":
			return s;
		case "final":
			return s;
		case "float":
			return s;
		case "for":
			return s;
		case "if":
			return s;
		case "implements":
			return s;
		case "import":
			return s;
		case "instanceof":
			return s;
		case "interface":
			return s;
		case "long":
			return s;
		case "native":
			return s;
		case "new":
			return s;
		case "null":
			return s;
		case "main":
			return s;
		case "pakage":
			return s;
		case "private":
			return s;
		case "protected":
			return s;
		case "public":
			return s;
		case "return":
			return s;
		case "short":
			return s;
		case "String":
			return s;
		case "static":
			return s;
		case "strictfp":
			return s;
		case "super":
			return s;
		case "switch":
			return s;
		case "snchonized":
			return s;
		case "this":
			return s;
		case "throw":
			return s;
		case "throws":
			return s;
		case "transient":
			return s;
		case "try":
			return s;
		case "void":
			return s;
		case "volatile":
			return s;
		case "while":
			return s;
		default:
				return "-1";
		}
	}
	
	String checkspecialsymbol(String s)
	{
		switch(s)
		{
		case "=":
			return s;
		case "++":
			return s;
		case "--":
			return s;
		case "!":
			return s;
		case "!=":
			return s;
		case "==":
			return s;
		case ">=":
			return s;
		case ">":
			return s;
		case "<=":
			return s;
		case "<":
			return s;
		case "&&":
			return s;
		case "||":
			return s;
		case "(":
			return s;
		case ")":
			return s;
		case "{":
			return s;
		case "}":
			return s;
		case "[":
			return s;
		case "]":
			return s;
		case ".":
			return s;
		case ",":
			return s;
		case ";":
			return s;
		case "'":
			return s;
		case "\"":
			return s;
		case "+":
			return s;
		case "-":
			return s;
		case "*":
			return s;
		case "/":
			return s;
		case "\\":
			return s;
		case "|":
			return s;
		case "%":
			return s;
			default:
				return "-1";
		}
	}
	String checknumber(String s)
	{
		switch(s)
		{
		case "0":
			return s;
		case "1":
			return s;
		case "2":
			return s;
		case "3":
			return s;
		case "4":
			return s;
		case "5":
			return s;
		case "6":
			return s;
		case "7":
			return s;
		case "8":
			return s;
		case "9":
			return s;
			default:
				return "-1";
		}
	}

	void Display()
	{
		File file=new File("C://Users/Saqib/Desktop/prog.txt");
		sb.delete(0, sb.length());
		try {
			Scanner input= new Scanner(file);
			while(input.hasNext())
			{
				sb.append(input.nextLine());
				sb.append("\n");
			}	
			input.close();
		} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * Table filling
	 */
	void filltables()
	{
		File file=new File("C://Users/Saqib/Desktop/prog.txt");
		
		try {
			Scanner input= new Scanner(file);
			String s;
			StringTokenizer stk;
			String o;
			while(input.hasNext())
			{
				s = input.nextLine();
				if(s.startsWith("\"")&& s.endsWith("\""))
				{
					model=(DefaultTableModel) tokentable.getModel();
					model.insertRow(model.getRowCount(), new String[] {String.valueOf(sr),s,"String",String.valueOf(count)});
					model=(DefaultTableModel) literaltable.getModel();
					model.insertRow(model.getRowCount(), new String[] {String.valueOf(slr) , s , String.valueOf(count)});
					sr++;
					slr++;
					count++;
					continue;
				}
				stk = new StringTokenizer(s , " \n\t");
				while(stk.hasMoreTokens())
				{
					o=stk.nextToken();
					if (checkkeyword(o) == o)
					{
						model=(DefaultTableModel) tokentable.getModel();
						model.insertRow(model.getRowCount(), new String[] {String.valueOf(sr),o,"Keyword",String.valueOf(count)});
						//model=(DefaultTableModel) literaltable.getModel();
						//model.insertRow(model.getRowCount(), new String[] {String.valueOf(sr) , o , String.valueOf(count)});
						sr++;
					}
					else if(checkspecialsymbol(o)==o)
					{
						model=(DefaultTableModel) tokentable.getModel();
						model.insertRow(model.getRowCount(), new String[] {String.valueOf(sr),o,"Symbol",String.valueOf(count)});
						//model=(DefaultTableModel) literaltable.getModel();
						//model.insertRow(model.getRowCount(), new String[] {String.valueOf(sr) , o , String.valueOf(count)});
						sr++;
					}
					else if(checknumber(o)==o)
					{
						model=(DefaultTableModel) tokentable.getModel();
						model.insertRow(model.getRowCount(), new String[] {String.valueOf(sr),o,"Number",String.valueOf(count)});
						//model=(DefaultTableModel) literaltable.getModel();
						//model.insertRow(model.getRowCount(), new String[] {String.valueOf(sr) , o , String.valueOf(count)});
						sr++;
					}
					else if((o.startsWith("0")||o.startsWith("1")||o.startsWith("2")||o.startsWith("3")||o.startsWith("4")||o.startsWith("5")||o.startsWith("6")||o.startsWith("5")||o.startsWith("6")||o.startsWith("7")||o.startsWith("8")||o.startsWith("9")) && (o.endsWith("0")||o.endsWith("1")||o.endsWith("2")||o.endsWith("3")||o.endsWith("4")||o.endsWith("5")||o.endsWith("6")||o.endsWith("7")||o.endsWith("8")||o.endsWith("9")))
					{
						model=(DefaultTableModel) tokentable.getModel();
						model.insertRow(model.getRowCount(), new String[] {String.valueOf(sr),o,"Number",String.valueOf(count)});
						//model=(DefaultTableModel) literaltable.getModel();
						//model.insertRow(model.getRowCount(), new String[] {String.valueOf(sr) , o , String.valueOf(count)});
						sr++;
					}
					else if(o.startsWith("\"")&& o.endsWith("\""))
					{
						model=(DefaultTableModel) tokentable.getModel();
						model.insertRow(model.getRowCount(), new String[] {String.valueOf(sr),o,"String",String.valueOf(count)});
						model=(DefaultTableModel) literaltable.getModel();
						model.insertRow(model.getRowCount(), new String[] {String.valueOf(slr) , o , String.valueOf(count)});
						sr++;
						slr++;
					}
					else if(o.startsWith("\'")&& o.endsWith("\'"))
					{
						model=(DefaultTableModel) tokentable.getModel();
						model.insertRow(model.getRowCount(), new String[] {String.valueOf(sr),o,"Character",String.valueOf(count)});
						model=(DefaultTableModel) literaltable.getModel();
						model.insertRow(model.getRowCount(), new String[] {String.valueOf(slr) , o , String.valueOf(count)});
						sr++;
						slr++;
					}
					else 
					{
						boolean chk=false;
						char[] arr = o.toCharArray();
						int a ;
						a=arr[0];
						if(a== 95 || a==36 || a >= 65 && a<= 90 || a >= 97  && a<= 122 )
						{
							for(int j=0 ;j<arr.length;j++)
							{
								a=(int)arr[j];
								if(a== 95 || a==36 || a >= 65 && a<= 90 || a >= 97  && a<= 122 || (a >= 48 && a <= 57)) 
								{
									if(j==arr.length-1)
									{
										chk=true;
										model=(DefaultTableModel) tokentable.getModel();
										model.insertRow(model.getRowCount(), new String[] {String.valueOf(sr),o,"Identifier",String.valueOf(count)});
										model=(DefaultTableModel) literaltable.getModel();
										model.insertRow(model.getRowCount(), new String[] {String.valueOf(slr) , o , String.valueOf(count)});
										slr++;
										break;
									}
								}
								else
								{
									chk=true;
									model=(DefaultTableModel) tokentable.getModel();
									model.insertRow(model.getRowCount(), new String[] {String.valueOf(sr),o,"Invalid Token",String.valueOf(count)});
									sr++;
									break;
								}
								
							}
						}
						
						if(chk==false)
						{
							try 
							{
								check(o.toCharArray());
							}
							catch(Exception ee)
							{
								//nothing
							}
						}
					}
				}
				count++;
			}
			
			input.close();
		} 
		 catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	
	
	

	/**
	 * Combined token checking
	 */
	void check(char[] arra)
	{
		String ch="";
		int l=arra.length;
		String s = "";
		int ascii=(int)arra[0];
		
		for(int j=0;j<l;j++)
		{
			//checking for keyword
			
			for(int k=j;k<l;k++)
			{
				ascii=(int)arra[k];
				if(ascii >= 65 && ascii<= 90 || ascii >= 97  && ascii<= 122)
				{
					s = s + arra[k];
					if(checkkeyword(s)==s && (int)arra[k+1]!= 95 && (int)arra[k+1]!= 36 && !((int)arra[k+1] >= 65 && (int)arra[k+1]<= 90) && !((int)arra[k+1] >= 97  && (int)arra[k+1]<= 122) && !((int)arra[k+1]>=48 && (int)arra[k+1]<=57))
					{	
						model=(DefaultTableModel) tokentable.getModel();
						model.insertRow(model.getRowCount(), new String[] {String.valueOf(sr),s,"Keyword",String.valueOf(count)});
						sr++;
						s="";
						j=k;
						break;
					}
				}
				else
				{
					break;
				}
			}
			
			s="";
			ascii=(int)arra[j];
			
			// variable name checking
			
			if(ascii== 95 || (ascii >= 65 && ascii<= 90) || (ascii >= 97  && ascii<= 122) )
			{
			for(int k=j;k<arra.length;k++)
				{
					ascii=(int)arra[k];
					if(ascii== 95 || ascii== 36 || (ascii >= 65 && ascii<= 90) || (ascii >= 97  && ascii<= 122) || (ascii>=48 && ascii<=57) )
					{
						s = s + arra[k];
						//ch=Character.toString(arra[l-1]);
						if(checkkeyword(s)!=s && (int)arra[k+1]!= 95 && (int)arra[k+1]!= 36 && !((int)arra[k+1] >= 65 && (int)arra[k+1]<= 90) && !((int)arra[k+1] >= 97  && (int)arra[k+1]<= 122) && !((int)arra[k+1]>=48 && (int)arra[k+1]<=57) || k==l-1)
						{	
							model=(DefaultTableModel) tokentable.getModel();
							model.insertRow(model.getRowCount(), new String[] {String.valueOf(sr),s,"Identifier",String.valueOf(count)});
							sr++;
							model=(DefaultTableModel) literaltable.getModel();
							model.insertRow(model.getRowCount(), new String[] {String.valueOf(slr),s,String.valueOf(count)});
							slr++;
							s="";
							j=k;
							break;
						}
					}
					else
					{
						break;
					}
				}
			}
			
			s="";
			ascii=(int)arra[j];
			ch=Character.toString(arra[j]);
			
			//check special symbol
			
			if(checkspecialsymbol(ch) == ch )
			{
				model=(DefaultTableModel) tokentable.getModel();
				model.insertRow(model.getRowCount(), new String[] {String.valueOf(sr),ch,"Symbol",String.valueOf(count)});
				sr++;
				s="";
				continue;				
			}
			
			//check number
			
			if(ascii>=48 && ascii<=57)
			{
				
				model=(DefaultTableModel) tokentable.getModel();
				model.insertRow(model.getRowCount(), new String[] {String.valueOf(sr),ch,"Number",String.valueOf(count)});
				sr++;
				continue;
			}
		}
	}

}