package hiberantepojo;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class baseFrame extends JFrame {

	static baseFrame frame;
	private JPanel contentPane;
	private JTextField container1_panel1_txtclassname;
	private JTextField container1_panel1_txttblname;
	private JTextField container1_panel2_txtfieldname;
	private JTextField container1_panel2_txtcolumnname;
	private JComboBox<String> container1_panel2_combofield_type;
	private JComboBox<String> container1_panel2_comboclmn_type;
	private JCheckBox chckbxonetoone,chckbxentity,chckbxautogenerator,chckbxid,chckbxjsonIgnore,chckbxtransient,
	chckbxNullable,chckbxUnsigned,chckbxJsonInclude,chckbxConstructor,chckbxPrivate,chckbxPublic;
	JEditorPane codeview_editorpanel_editorPane;
	JSpinner container1_panel2_lengthspinner,container1_panel2_db_lengthspinner;
	JRadioButton container1_panel2_rdbtnnull,container1_panel2_radiobtnzero,container1_panel2_rdbtnnone,
	container1_panel2_rdbtnNow,container1_panel2_nullradioButton,container1_panel2_rdbtnNone;
	ButtonGroup group = new ButtonGroup();
	ButtonGroup grouptime = new ButtonGroup();
	StringBuilder IMPORTS=new StringBuilder();
	List<String> ANNOTATIONS_ID=new ArrayList<String>();
	List<String> ANNOTATIONS_GENERATOR=new ArrayList<String>();
	List<String> ANNOTATIONS_JSONIGNORE=new ArrayList<String>();
	List<String> ANNOTATIONS_TRANSIENT=new ArrayList<String>();
	List<String> ANNOTATIONS_ONETOONE=new ArrayList<String>();
	List<String> ANNOTATIONS_UNSIGNED=new ArrayList<String>();
	List<String> ANNOTATIONS_NULLABLE=new ArrayList<String>();
	List<String> COLUMN_LENGTH=new ArrayList<String>();
	List<String> FIELD_LENGTH=new ArrayList<String>();
	List<String> DEFAULT=new ArrayList<String>();
	List<String> DEFAULT_TIMESTAMP=new ArrayList<String>();
	StringBuilder OVERALL_CODE=null;
	private JTable table;
	private JScrollPane container2_scrollPane;

	String main_Class="",class_Name="",Mapping_class="",field_Name="",column_Name;
	List<String> allfield_Name_count=new ArrayList<String>();
	String[] mapping_classes=new String[50];
	Map<Object,String>mapping_section=new HashMap<Object,String>();
	List<String> allfield_Name=new ArrayList<String>();
	List<String> allfield_Type=new ArrayList<String>();
	List<String> allcolumn_Name=new ArrayList<String>();
	List<String> allcolumn_Type=new ArrayList<String>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new baseFrame();
					frame.setVisible(true);
					frame.setTitle("Hibernate Class Generator");
					Image icon = Toolkit.getDefaultToolkit().getImage("src/java.png");
					frame.setIconImage(icon);
					common.centreWindow(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public baseFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 679);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel container1 = new JPanel();
		container1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		container1.setBackground(Color.WHITE);
		container1.setBounds(0, 70, 505, 575);
		contentPane.add(container1);
		container1.setLayout(null);
		
		JPanel container1_panel1 = new JPanel();
		container1_panel1.setBorder(new LineBorder(SystemColor.activeCaption, 1, true));
		container1_panel1.setBackground(Color.WHITE);
		container1_panel1.setBounds(10, 11, 485, 55);
		container1.add(container1_panel1);
		container1_panel1.setLayout(null);
		
		container1_panel1_txtclassname = new JTextField();
		container1_panel1_txtclassname.setToolTipText("Classname");
		container1_panel1_txtclassname.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		container1_panel1_txtclassname.setText("Classname");
		container1_panel1_txtclassname.setForeground(Color.DARK_GRAY);
		container1_panel1_txtclassname.setBounds(10, 11, 170, 33);
		container1_panel1.add(container1_panel1_txtclassname);
		container1_panel1_txtclassname.setColumns(10);
		
		container1_panel1_txttblname = new JTextField();
		container1_panel1_txttblname.setToolTipText("Tablename");
		container1_panel1_txttblname.setText("Tablename");
		container1_panel1_txttblname.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		container1_panel1_txttblname.setForeground(Color.DARK_GRAY);
		container1_panel1_txttblname.setColumns(10);
		container1_panel1_txttblname.setBounds(228, 11, 170, 33);
		container1_panel1.add(container1_panel1_txttblname);
		
		JPanel container1_panel2_combocolumntype = new JPanel();
		container1_panel2_combocolumntype.setBorder(new LineBorder(SystemColor.activeCaption, 1, true));
		container1_panel2_combocolumntype.setBackground(Color.WHITE);
		container1_panel2_combocolumntype.setBounds(10, 77, 485, 166);
		container1.add(container1_panel2_combocolumntype);
		container1_panel2_combocolumntype.setLayout(null);
		
		container1_panel2_txtfieldname = new JTextField();
		container1_panel2_txtfieldname.setToolTipText("Fieldname");
		container1_panel2_txtfieldname.setText("Fieldname");
		container1_panel2_txtfieldname.setForeground(Color.DARK_GRAY);
		container1_panel2_txtfieldname.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		container1_panel2_txtfieldname.setColumns(10);
		container1_panel2_txtfieldname.setBounds(10, 11, 170, 33);
		container1_panel2_combocolumntype.add(container1_panel2_txtfieldname);
		
		container1_panel2_txtcolumnname = new JTextField();
		container1_panel2_txtcolumnname.setToolTipText("Columnname");
		container1_panel2_txtcolumnname.setText("Columnname");
		container1_panel2_txtcolumnname.setForeground(Color.DARK_GRAY);
		container1_panel2_txtcolumnname.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		container1_panel2_txtcolumnname.setColumns(10);
		container1_panel2_txtcolumnname.setBounds(231, 11, 170, 33);
		container1_panel2_combocolumntype.add(container1_panel2_txtcolumnname);
		
		container1_panel2_combofield_type = new JComboBox<String>();
		container1_panel2_combofield_type.setForeground(Color.DARK_GRAY);
		container1_panel2_combofield_type.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		container1_panel2_combofield_type.setBackground(Color.WHITE);
		container1_panel2_combofield_type.setBounds(10, 64, 170, 33);
		
		container1_panel2_combofield_type.addItem("Select");
		container1_panel2_combofield_type.addItem("boolean");
		container1_panel2_combofield_type.addItem("int");
		container1_panel2_combofield_type.addItem("float");
		container1_panel2_combofield_type.addItem("double");
		container1_panel2_combofield_type.addItem("char");
		container1_panel2_combofield_type.addItem("String");
		container1_panel2_combofield_type.addItem("long");
		container1_panel2_combofield_type.addItem("Date");
		container1_panel2_combocolumntype.add(container1_panel2_combofield_type);
		
		container1_panel2_comboclmn_type = new JComboBox<String>();
		container1_panel2_comboclmn_type.setForeground(Color.DARK_GRAY);
		container1_panel2_comboclmn_type.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		container1_panel2_comboclmn_type.setBackground(Color.WHITE);
		container1_panel2_comboclmn_type.setBounds(231, 64, 170, 33);
		
		container1_panel2_comboclmn_type.addItem("Select");
		container1_panel2_comboclmn_type.addItem("boolean");
		container1_panel2_comboclmn_type.addItem("bit");
		container1_panel2_comboclmn_type.addItem("smallint");
		container1_panel2_comboclmn_type.addItem("int");
		container1_panel2_comboclmn_type.addItem("bigint");
		container1_panel2_comboclmn_type.addItem("tinyint");
		container1_panel2_comboclmn_type.addItem("float");
		container1_panel2_comboclmn_type.addItem("double");
		container1_panel2_comboclmn_type.addItem("varchar");
		container1_panel2_comboclmn_type.addItem("timestamp");		   
		container1_panel2_combocolumntype.add(container1_panel2_comboclmn_type);
		
		SpinnerModel model = new SpinnerNumberModel(10, 0,500, 1);
		container1_panel2_lengthspinner = new JSpinner(model);
		container1_panel2_lengthspinner.setBounds(92, 111, 63, 20);
		container1_panel2_lengthspinner.setValue(0);
		container1_panel2_combocolumntype.add(container1_panel2_lengthspinner);
		
		JLabel container1_panel2_lblLength = new JLabel("size");
		container1_panel2_lblLength.setForeground(Color.DARK_GRAY);
		container1_panel2_lblLength.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		container1_panel2_lblLength.setBounds(10, 145, 43, 14);
		container1_panel2_combocolumntype.add(container1_panel2_lblLength);
		
		container1_panel2_rdbtnnull = new JRadioButton("Null");
		container1_panel2_rdbtnnull.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		container1_panel2_rdbtnnull.setBackground(Color.WHITE);
		container1_panel2_rdbtnnull.setBounds(283, 110, 53, 23);
		container1_panel2_combocolumntype.add(container1_panel2_rdbtnnull);
		
		container1_panel2_radiobtnzero = new JRadioButton("0");
		container1_panel2_radiobtnzero.setBackground(Color.WHITE);
		container1_panel2_radiobtnzero.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		container1_panel2_radiobtnzero.setBounds(338, 110, 43, 23);
		container1_panel2_combocolumntype.add(container1_panel2_radiobtnzero);
		
		container1_panel2_rdbtnnone = new JRadioButton("None");
		container1_panel2_rdbtnnone.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		container1_panel2_rdbtnnone.setBackground(Color.WHITE);
		container1_panel2_rdbtnnone.setBounds(383, 110, 63, 23);
		container1_panel2_combocolumntype.add(container1_panel2_rdbtnnone);
		
		container1_panel2_rdbtnnone.setSelected(true);
		
		
        group.add(container1_panel2_rdbtnnull);
        group.add(container1_panel2_radiobtnzero);
        group.add(container1_panel2_rdbtnnone);
        
		JLabel container1_panel2_lblDefault = new JLabel("default ");
		container1_panel2_lblDefault.setForeground(Color.DARK_GRAY);
		container1_panel2_lblDefault.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		container1_panel2_lblDefault.setBounds(231, 114, 46, 14);
		container1_panel2_combocolumntype.add(container1_panel2_lblDefault);
		
		SpinnerModel lengthspinnermodel = new SpinnerNumberModel(10, 0, 500, 1);
		container1_panel2_db_lengthspinner = new JSpinner(lengthspinnermodel);
		container1_panel2_db_lengthspinner.setBackground(Color.WHITE);
		container1_panel2_db_lengthspinner.setForeground(Color.WHITE);
		container1_panel2_db_lengthspinner.setBounds(92, 142, 63, 20);
		container1_panel2_db_lengthspinner.setValue(0);
		container1_panel2_combocolumntype.add(container1_panel2_db_lengthspinner);
		
		JLabel container1_panel2_lblDefaultTimestamp = new JLabel("default  timestamp  ");
		container1_panel2_lblDefaultTimestamp.setForeground(Color.DARK_GRAY);
		container1_panel2_lblDefaultTimestamp.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		container1_panel2_lblDefaultTimestamp.setBounds(231, 140, 94, 14);
		container1_panel2_combocolumntype.add(container1_panel2_lblDefaultTimestamp);
		
		container1_panel2_rdbtnNow = new JRadioButton("Now");
		container1_panel2_rdbtnNow.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		container1_panel2_rdbtnNow.setBackground(Color.WHITE);
		container1_panel2_rdbtnNow.setBounds(317, 136, 53, 23);
		container1_panel2_combocolumntype.add(container1_panel2_rdbtnNow);
		
		container1_panel2_nullradioButton = new JRadioButton("Null");
		container1_panel2_nullradioButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		container1_panel2_nullradioButton.setBackground(Color.WHITE);
		container1_panel2_nullradioButton.setBounds(372, 136, 53, 23);
		container1_panel2_combocolumntype.add(container1_panel2_nullradioButton);
		
		
		
		
		JLabel lblColumnLength = new JLabel("column length ");
		lblColumnLength.setForeground(Color.DARK_GRAY);
		lblColumnLength.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblColumnLength.setBounds(10, 114, 82, 14);
		container1_panel2_combocolumntype.add(lblColumnLength);
		
		container1_panel2_rdbtnNone = new JRadioButton("None");
		container1_panel2_rdbtnNone.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		container1_panel2_rdbtnNone.setBackground(Color.WHITE);
		container1_panel2_rdbtnNone.setBounds(426, 136, 53, 23);
		container1_panel2_rdbtnNone.setSelected(true);
		container1_panel2_combocolumntype.add(container1_panel2_rdbtnNone);
		
		grouptime.add(container1_panel2_rdbtnNow);
		grouptime.add(container1_panel2_nullradioButton);
		grouptime.add(container1_panel2_rdbtnNone);
		
		JPanel container1_panel3 = new JPanel();
		container1_panel3.setBorder(new LineBorder(SystemColor.activeCaption, 1, true));
		container1_panel3.setBackground(Color.WHITE);
		container1_panel3.setBounds(10, 254, 485, 137);
		container1.add(container1_panel3);
		container1_panel3.setLayout(null);
		
		chckbxautogenerator = new JCheckBox("@Autogenerator");
		chckbxautogenerator.setForeground(Color.DARK_GRAY);
		chckbxautogenerator.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		chckbxautogenerator.setBackground(Color.WHITE);
		chckbxautogenerator.setBounds(6, 103, 111, 23);
		container1_panel3.add(chckbxautogenerator);
		
		chckbxid = new JCheckBox("@Id");
		chckbxid.setForeground(Color.DARK_GRAY);
		chckbxid.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		chckbxid.setBackground(Color.WHITE);
		chckbxid.setBounds(6, 61, 97, 23);
		container1_panel3.add(chckbxid);
		
		chckbxentity = new JCheckBox("@Entity");
		chckbxentity.setForeground(Color.DARK_GRAY);
		chckbxentity.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		chckbxentity.setBackground(Color.WHITE);
		chckbxentity.setBounds(6, 22, 97, 23);
		chckbxentity.setSelected(true);
		container1_panel3.add(chckbxentity);
		
		chckbxjsonIgnore = new JCheckBox("@Json Ignore");
		chckbxjsonIgnore.setForeground(Color.DARK_GRAY);
		chckbxjsonIgnore.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		chckbxjsonIgnore.setBackground(Color.WHITE);
		chckbxjsonIgnore.setBounds(119, 22, 97, 23);
		container1_panel3.add(chckbxjsonIgnore);
		
		chckbxtransient = new JCheckBox("@Transient");
		chckbxtransient.setForeground(Color.DARK_GRAY);
		chckbxtransient.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		chckbxtransient.setBackground(Color.WHITE);
		chckbxtransient.setBounds(119, 61, 97, 23);
		container1_panel3.add(chckbxtransient);
		
		chckbxonetoone = new JCheckBox("@OnetoOne");
		chckbxonetoone.setForeground(Color.DARK_GRAY);
		chckbxonetoone.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		chckbxonetoone.setBackground(Color.WHITE);
		chckbxonetoone.setBounds(119, 103, 97, 23);
		chckbxonetoone.addActionListener(actionListener);
		container1_panel3.add(chckbxonetoone);
		
		chckbxNullable = new JCheckBox("Nullable");
		chckbxNullable.setForeground(Color.DARK_GRAY);
		chckbxNullable.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		chckbxNullable.setBackground(Color.WHITE);
		chckbxNullable.setBounds(342, 103, 97, 23);
		container1_panel3.add(chckbxNullable);
		
		chckbxUnsigned = new JCheckBox("Unsigned");
		chckbxUnsigned.setForeground(Color.DARK_GRAY);
		chckbxUnsigned.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		chckbxUnsigned.setBackground(Color.WHITE);
		chckbxUnsigned.setBounds(342, 22, 97, 23);
		container1_panel3.add(chckbxUnsigned);
			
		chckbxJsonInclude = new JCheckBox("@Json include");
		chckbxJsonInclude.setForeground(Color.DARK_GRAY);
		chckbxJsonInclude.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		chckbxJsonInclude.setBackground(Color.WHITE);
		chckbxJsonInclude.setBounds(234, 22, 97, 23);
		chckbxJsonInclude.setSelected(true);
		container1_panel3.add(chckbxJsonInclude);
		
		chckbxConstructor = new JCheckBox("Constructor");
		chckbxConstructor.setForeground(Color.DARK_GRAY);
		chckbxConstructor.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		chckbxConstructor.setBackground(Color.WHITE);
		chckbxConstructor.setBounds(342, 61, 97, 23);
		container1_panel3.add(chckbxConstructor);
		
		chckbxPrivate = new JCheckBox("private");
		chckbxPrivate.setForeground(Color.DARK_GRAY);
		chckbxPrivate.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		chckbxPrivate.setBackground(Color.WHITE);
		chckbxPrivate.setBounds(234, 61, 97, 23);
		container1_panel3.add(chckbxPrivate);
		
		chckbxPublic = new JCheckBox("public");
		chckbxPublic.setForeground(Color.DARK_GRAY);
		chckbxPublic.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		chckbxPublic.setBackground(Color.WHITE);
		chckbxPublic.setBounds(234, 103, 97, 23);
		container1_panel3.add(chckbxPublic);
		
		JPanel container1_panel4 = new JPanel();
		container1_panel4.setBorder(new LineBorder(SystemColor.activeCaption, 1, true));
		container1_panel4.setBackground(Color.WHITE);
		container1_panel4.setBounds(10, 402, 485, 166);
		container1.add(container1_panel4);
		
		/********************************************* Column add function start *********************************************/
		Icon addIcon = new ImageIcon("src/add.png");
		JButton addcolumn = new JButton(addIcon);
		addcolumn.setBounds(76, 136, 43, 23);
		
		addcolumn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				class_Name=container1_panel1_txtclassname.getText();
				String table_Name=container1_panel1_txttblname.getText();
				field_Name=container1_panel2_txtfieldname.getText();
				column_Name=container1_panel2_txtcolumnname.getText();
				
				if(class_Name.trim().length()==0 || table_Name.trim().length()==0 || field_Name.trim().length()==0 || column_Name.trim().length()==0){
					JOptionPane.showMessageDialog(frame,"Fields should not be empty", "Error",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				else
				{
				if(container1_panel2_combofield_type.getSelectedItem().equals("Select"))
				{
					JOptionPane.showMessageDialog(frame,"Select field type...", "Error",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				else
				{
					allfield_Type.add(container1_panel2_combofield_type.getSelectedItem().toString());
				}
				if(container1_panel2_comboclmn_type.getSelectedItem().equals("Select"))
				{
					JOptionPane.showMessageDialog(frame,"Select column type...", "Error",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				else
				{
					allcolumn_Type.add(container1_panel2_comboclmn_type.getSelectedItem().toString());
				}
								
				/* Imports Append functions start */
				if(chckbxid.isSelected()){
					if(IMPORTS.toString().contains("import javax.persistence.Id;")==false)
					IMPORTS.append("import javax.persistence.Id;\n");
					ANNOTATIONS_ID.add("1");
					mapping_section.put(class_Name, column_Name);
				}else{
					ANNOTATIONS_ID.add("0");
				}
				if(chckbxautogenerator.isSelected()){
					if(IMPORTS.toString().contains("import javax.persistence.GeneratedValue;")==false)
					IMPORTS.append("import javax.persistence.GeneratedValue;\n");
					ANNOTATIONS_GENERATOR.add("1");
				}else{
					ANNOTATIONS_GENERATOR.add("0");
				}
				if(chckbxjsonIgnore.isSelected()){
					if(IMPORTS.toString().contains("import com.fasterxml.jackson.annotation.JsonIgnore;")==false)
					IMPORTS.append("import com.fasterxml.jackson.annotation.JsonIgnore;\n");
					ANNOTATIONS_JSONIGNORE.add("1");
				}else{
					ANNOTATIONS_JSONIGNORE.add("0");
				}
				if(chckbxtransient.isSelected()){
					if(IMPORTS.toString().contains("import javax.persistence.Transient;")==false)
					IMPORTS.append("import javax.persistence.Transient;\n");
					ANNOTATIONS_TRANSIENT.add("1");
				}else{
					ANNOTATIONS_TRANSIENT.add("0");
				}
				if(chckbxentity.isSelected()){
					if(IMPORTS.toString().contains("import javax.persistence.Entity;")==false)
					IMPORTS.append("import javax.persistence.Entity;\n");
				}else{

				}
				if(chckbxonetoone.isSelected()){
					if(IMPORTS.toString().contains("import javax.persistence.OneToOne;")==false)
					IMPORTS.append("import javax.persistence.OneToOne;\n");
					ANNOTATIONS_ONETOONE.add("1");
				}else{
					ANNOTATIONS_ONETOONE.add("0");
				}
				if(chckbxNullable.isSelected()){
					ANNOTATIONS_NULLABLE.add("1");
				}else{
					ANNOTATIONS_NULLABLE.add("0");
				}
				if(chckbxUnsigned.isSelected()){
					ANNOTATIONS_UNSIGNED.add("1");
				}else{
					ANNOTATIONS_UNSIGNED.add("0");
				}			
				if(chckbxJsonInclude.isSelected()){
					if(IMPORTS.toString().contains("import javax.persistence.Entity;")==false)
						IMPORTS.append("import javax.persistence.Entity;\n");
					if(IMPORTS.toString().contains("import javax.persistence.Table;")==false)
						IMPORTS.append("import javax.persistence.Table;\n");
					if(IMPORTS.toString().contains("import com.fasterxml.jackson.annotation.JsonInclude;")==false){
						IMPORTS.append("import com.fasterxml.jackson.annotation.JsonInclude;\n");
						IMPORTS.append("import com.fasterxml.jackson.annotation.JsonInclude.Include;\n");
					}
					main_Class="@Table(name=\""+table_Name+"\")\n@Entity\n@JsonInclude(Include.NON_NULL)\npublic class "+class_Name+" { ";
				}else{
					if(IMPORTS.toString().contains("import javax.persistence.Entity;")==false)
						IMPORTS.append("import javax.persistence.Entity;\n");
					if(IMPORTS.toString().contains("import javax.persistence.Table;")==false)
						IMPORTS.append("import javax.persistence.Table;\n");
					main_Class="@Table(name=\""+table_Name+"\")\n@Entity\npublic class "+class_Name+" { ";
				}
				
				/* Imports Append functions end */
				
				
				if(container1_panel2_rdbtnnull.isSelected())
					DEFAULT.add("1");
				else if(container1_panel2_radiobtnzero.isSelected())
						DEFAULT.add("2");
					else
							DEFAULT.add("0");
				
				if(container1_panel2_rdbtnNow.isSelected())
					DEFAULT_TIMESTAMP.add("1");
				else if(container1_panel2_rdbtnNone.isSelected())
					DEFAULT_TIMESTAMP.add("0");
				else
					DEFAULT_TIMESTAMP.add("2");
				
				allfield_Name.add(field_Name);
				allcolumn_Name.add(column_Name);
				allfield_Name_count.add(field_Name);
				COLUMN_LENGTH.add(container1_panel2_lengthspinner.getValue().toString());
				FIELD_LENGTH.add(container1_panel2_db_lengthspinner.getValue().toString());
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {allfield_Name_count.size(),field_Name,container1_panel2_combofield_type.getSelectedItem().toString()});
				createpojo_List(allfield_Name,allfield_Type);
				redraw_components();
				}
			
		}
		});
		container1_panel4.setLayout(null);
		container1_panel4.add(addcolumn);
		addcolumn.setBackground(Color.WHITE);
		
		JScrollPane container1_panel4_scrollPane = new JScrollPane();
		container1_panel4_scrollPane.setBorder(new LineBorder(new Color(130, 135, 144)));
		container1_panel4_scrollPane.setForeground(new Color(65, 105, 225));
		container1_panel4_scrollPane.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		container1_panel4_scrollPane.setBackground(Color.WHITE);
		container1_panel4_scrollPane.setBounds(10, 11, 465, 114);
		container1_panel4.add(container1_panel4_scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(Color.DARK_GRAY));
		table.setAutoCreateRowSorter(true);		
		table.setColumnSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		table.setForeground(new Color(65, 105, 225));
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"S.No", "Column Name", "Column Type"
				}
			));
		container1_panel4_scrollPane.setViewportView(table);
		
		Icon deleteIcon = new ImageIcon("src/delete.png");
		JButton deletecolumn = new JButton(deleteIcon);
		deletecolumn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				
				int row = table.getSelectedRow();
				
				if(allfield_Name.size()<=row+1){
					allfield_Name.remove(allfield_Name.size()-1);
					allfield_Type.remove(allfield_Type.size()-1);
				}else{
					allfield_Name.remove(row);
					allfield_Type.remove(row);
				}
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.removeRow(row);
				createpojo_List(allfield_Name,allfield_Type);
				redraw_components();
				JOptionPane.showMessageDialog(frame,"Deleted Successfully...");
			}
		});
		deletecolumn.setBackground(new Color(240, 248, 255));
		deletecolumn.setBounds(209, 136, 48, 23);
		container1_panel4.add(deletecolumn);
		
		Icon generatIcon = new ImageIcon("src/generat.png");
		JButton btnNewButton = new JButton(generatIcon);
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				
				 allfield_Name.removeAll(allfield_Name);
				 allfield_Type.removeAll(allfield_Type);
				 allcolumn_Name.removeAll(allcolumn_Name);
				 allcolumn_Type.removeAll(allcolumn_Type);
				 allfield_Name_count.removeAll(allfield_Name_count);
				 
				 ANNOTATIONS_ID.removeAll(ANNOTATIONS_ID);
				 ANNOTATIONS_GENERATOR.removeAll(ANNOTATIONS_GENERATOR);
				 ANNOTATIONS_JSONIGNORE.removeAll(ANNOTATIONS_JSONIGNORE);
				 ANNOTATIONS_TRANSIENT.removeAll(ANNOTATIONS_TRANSIENT);
				 ANNOTATIONS_ONETOONE.removeAll(ANNOTATIONS_ONETOONE);
				 ANNOTATIONS_UNSIGNED.removeAll(ANNOTATIONS_UNSIGNED);
				 ANNOTATIONS_NULLABLE.removeAll(ANNOTATIONS_NULLABLE);
				 
				 String constructor="";
				 container1_panel1_txtclassname.setEditable(true);
				 container1_panel1_txttblname.setEditable(true);
				 
				 DefaultTableModel model = (DefaultTableModel) table.getModel();
				 model.setRowCount(0);
				 
				 if(chckbxConstructor.isSelected()){
					 constructor="public "+class_Name+"() {}";
					}
				 
				IMPORTS.append("import javax.persistence.Column;\n");
				codeview_editorpanel_editorPane.setText(IMPORTS+"\n\n"+main_Class+"\n\n"+OVERALL_CODE.toString()+"\n\n"+constructor+"\n}");
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		btnNewButton.setBackground(new Color(240, 248, 255));
		btnNewButton.setBounds(432, 136, 43, 23);
		container1_panel4.add(btnNewButton);
		
		JLabel lblAddColumn = new JLabel("Add column");
		lblAddColumn.setForeground(new Color(178, 34, 34));
		lblAddColumn.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblAddColumn.setBounds(10, 140, 77, 14);
		container1_panel4.add(lblAddColumn);
		
		JLabel lblRemoveColumn = new JLabel("Remove column");
		lblRemoveColumn.setForeground(new Color(178, 34, 34));
		lblRemoveColumn.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblRemoveColumn.setBounds(124, 140, 77, 14);
		container1_panel4.add(lblRemoveColumn);
		
		/********************************************* Column add function end *********************************************/
		
		JPanel container2 = new JPanel();
		container2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		container2.setBackground(Color.WHITE);
		container2.setBounds(507, 70, 404, 575);
		contentPane.add(container2);
		container2.setLayout(null);
		
		container2_scrollPane = new JScrollPane();
		container2_scrollPane.setBackground(Color.WHITE);
		container2_scrollPane.setBounds(0, 0, 404, 575);
		container2.add(container2_scrollPane);
		
		codeview_editorpanel_editorPane = new JEditorPane();
		codeview_editorpanel_editorPane.setCaretColor(Color.WHITE);
		codeview_editorpanel_editorPane.setDisabledTextColor(Color.WHITE);
		codeview_editorpanel_editorPane.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		codeview_editorpanel_editorPane.setSelectedTextColor(SystemColor.activeCaption);
		codeview_editorpanel_editorPane.setSelectionColor(new Color(0, 0, 102));
		codeview_editorpanel_editorPane.setText("View Your Code Here.....");
		codeview_editorpanel_editorPane.setBackground(new Color(0, 0, 0));
		codeview_editorpanel_editorPane.setForeground(new Color(255, 255, 255));
		codeview_editorpanel_editorPane.setFont(new Font("Courier New", Font.PLAIN, 14));
		container2_scrollPane.setViewportView(codeview_editorpanel_editorPane);
		
		JPanel containerhead = new JPanel();
		containerhead.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		containerhead.setBackground(SystemColor.activeCaption);
		containerhead.setBounds(0, 0, 911, 70);
		contentPane.add(containerhead);
		containerhead.setLayout(null);
		
		JLabel label_header = new JLabel("Hibernate Class Generator");
		label_header.setToolTipText("Hibernate Code Generator");
		label_header.setBackground(Color.WHITE);
		label_header.setForeground(Color.WHITE);
		label_header.setFont(new Font("Courier New", Font.BOLD, 26));
		label_header.setBounds(270, 11, 425, 36);
		containerhead.add(label_header);
				
		Icon addheader = new ImageIcon("src/javaheader.png");
		JLabel lblNewLabel = new JLabel(addheader);
		lblNewLabel.setBounds(0, 0, 96, 70);
		containerhead.add(lblNewLabel);
		
	}
	
	public void createpojo_List(List<String> columnName,List<String> columnType){
		
		StringBuilder varibles=new StringBuilder();
		StringBuilder getters=new StringBuilder();
		StringBuilder setters=new StringBuilder();
		String datatype="private",p_Id="",generate_Value="",length="",dblength="",
				jsonignore="",transientstr="",unsigned="",nullable="",defaultvalue="",default_timestamp="";
		
		if(chckbxPublic.isSelected())
			datatype="public";			
		
		for(int indx=0;indx<columnName.size();indx++){
			if(ANNOTATIONS_ID.get(indx)=="1"){
				p_Id="@Id\n";
				if(IMPORTS.toString().contains("import javax.persistence.Id;")==false)
					IMPORTS.append("import javax.persistence.Id;\n");
			}else
				p_Id="";
			if(ANNOTATIONS_GENERATOR.get(indx)=="1"){
				generate_Value="@GeneratedValue\n";
				if(IMPORTS.toString().contains("import javax.persistence.GeneratedValue;")==false)
					IMPORTS.append("import javax.persistence.GeneratedValue;\n");
			}else
				generate_Value="";
			if(ANNOTATIONS_JSONIGNORE.get(indx)=="1"){
				jsonignore="@JsonIgnore\n";
				if(IMPORTS.toString().contains("import com.fasterxml.jackson.annotation.JsonIgnore;")==false)
					IMPORTS.append("import com.fasterxml.jackson.annotation.JsonIgnore;\n");
			}else
				jsonignore="";
			if(ANNOTATIONS_TRANSIENT.get(indx)=="1"){
				transientstr="@Transient\n";
				if(IMPORTS.toString().contains("import javax.persistence.Transient;")==false)
					IMPORTS.append("import javax.persistence.Transient;\n");
			}else
				transientstr="";
			if(ANNOTATIONS_UNSIGNED.get(indx)=="1"){
				unsigned="unsigned ";
			}else
				unsigned="";
			if(ANNOTATIONS_NULLABLE.get(indx)=="1"){
				nullable=",nullable=true";
			}else
				nullable=",nullable=false";
			if(COLUMN_LENGTH.get(indx).equals("0")){
				length="";
			}else{
				length=",length="+COLUMN_LENGTH.get(indx);
			}
			if(FIELD_LENGTH.get(indx).equals("0")){
				dblength="";
			}else{
				dblength=" ("+FIELD_LENGTH.get(indx)+")";
			}
			if(DEFAULT.get(indx).equals("1"))//null
				defaultvalue="default null";
				else if(DEFAULT.get(indx).equals("2"))//zero
					defaultvalue="default 0";
					else //none
						defaultvalue="";
			
			if(DEFAULT_TIMESTAMP.get(indx).equals("1"))
				 default_timestamp="default now()";
			else if(DEFAULT_TIMESTAMP.get(indx).equals("2"))
				 default_timestamp="null default null";
			else
				default_timestamp="";
			
			if(ANNOTATIONS_ONETOONE.get(indx)=="1"){
				
		    	varibles.append("@OneToOne\n"
		    			+ "@JoinColumn(referencedColumnName=\""+mapping_section.get(Mapping_class).trim()+"\","
		    					+ "name=\""+allcolumn_Name.get(indx)+"\","
		    							+ "columnDefinition=\""+allcolumn_Type.get(indx)+dblength+" "+default_timestamp+" "+defaultvalue+","+unsigned+"\" "+nullable+" "+length+")\n"
		    					+ datatype+" "+Mapping_class.trim()+" o"+Mapping_class.toLowerCase().trim()+";\n");
		    	
		    	getters.append(jsonignore+""+transientstr+" public "+Mapping_class.trim()+" get"+"o"+Mapping_class.toLowerCase().trim()+"() "
		    			+ "{\n return o"+Mapping_class.toLowerCase().trim()+";\n}\n");
		    	setters.append("\n public void set"+Mapping_class.trim()+"("+Mapping_class.trim()+" o"+Mapping_class.toLowerCase().trim()+") {\n"
						+ "this.o"+Mapping_class.toLowerCase().trim()+" = "+Mapping_class.toLowerCase().trim()+";\n}\n");
		    	
			}else{
				
			varibles.append(p_Id+generate_Value+"@Column(name=\""+allcolumn_Name.get(indx)+"\","
					+ "columnDefinition=\""+allcolumn_Type.get(indx)+dblength+" "+default_timestamp+" "+defaultvalue+","+unsigned+"\" "+nullable+" "+length+")\n"+datatype+" "
							+ ""+columnType.get(indx).trim()+" "+columnName.get(indx).trim()+";\n");
			
			getters.append(jsonignore+"\n"+transientstr+"\n public "+columnType.get(indx).trim()+" get"+columnName.get(indx).trim()+"() {\n return "+columnName.get(indx).trim()+";\n}\n");
			setters.append("\n public void set"+columnName.get(indx).trim()+"("+columnType.get(indx).trim()+" "+columnName.get(indx).trim()+") {\n"
					+ "this."+columnName.get(indx).trim()+" = "+columnName.get(indx).trim()+";\n}\n");
			}
		}
		
		OVERALL_CODE=new StringBuilder();
		OVERALL_CODE.append(varibles.toString()+getters.toString()+setters.toString());
		
		codeview_editorpanel_editorPane.setText(OVERALL_CODE.toString());
	}
	
	 ActionListener actionListener = new ActionListener() {      // One to one mapping checkbox functions starts
		public void actionPerformed(ActionEvent actionEvent) {
	    	if(chckbxonetoone.isSelected()==true){
	    	  List<Object> keys = new ArrayList<Object>(mapping_section.keySet());
	    	  Mapping_class=JOptionPane.showInputDialog(null, "Select the mapping class",
	    	        "Select the mapping class", JOptionPane.QUESTION_MESSAGE, null,
	    	        mapping_section.keySet().toArray(),
	    	        keys.get(0)).toString();
	    	}
	      }
	    };

 public void redraw_components()
 {
	chckbxonetoone.setSelected(false);
	chckbxautogenerator.setSelected(false);
	chckbxid.setSelected(false);
	chckbxjsonIgnore.setSelected(false);
	chckbxtransient.setSelected(false);
	chckbxNullable.setSelected(false);
	chckbxUnsigned.setSelected(false);
	chckbxConstructor.setSelected(false);
	chckbxPrivate.setSelected(false);
	chckbxPublic.setSelected(false);
	
	container1_panel2_txtfieldname.setText("");
	container1_panel2_txtcolumnname.setText("");
	
	container1_panel2_combofield_type.setSelectedItem("Select");
	container1_panel2_comboclmn_type.setSelectedItem("Select");
	
	container1_panel1_txtclassname.setEditable(false);
	container1_panel1_txttblname.setEditable(false);
	
	container1_panel2_lengthspinner.setValue(0);
	container1_panel2_db_lengthspinner.setValue(0);
	 
	container1_panel2_rdbtnnone.setSelected(true);
	container1_panel2_rdbtnNone.setSelected(true);
	    }
}
