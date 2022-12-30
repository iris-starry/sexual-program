package info.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import info.vo.StudentVO;

public class StudentView extends JPanel{
	JTable table;
	DefaultTableModel model;
	ArrayList<StudentVO> StudentVOList;
	String[] header = {"학번","성명","학년","반","국어","영어","수학","과학","총점","평균"};
	String[] Scholl_year_List = {"1학년","2학년","3학년"};
	String[] Scholl_class_List = {"1반","2반","3반","4반","5반","6반"};
	JPanel panS;
	JComboBox<String> yearCombo;
	JComboBox<String> classCombo;
	JLabel[] lbls = new JLabel[header.length-2];
	JTextField[] tf = new JTextField[header.length-4];
	JButton btnAdd = new JButton("성적추가");
	
	public StudentView() {
		setLayout(new BorderLayout());
		
		yearCombo = new JComboBox<String>(Scholl_year_List);
		classCombo = new JComboBox<String>(Scholl_class_List);
		
		panS = new JPanel();
		panS.setLayout(new GridLayout(5,4));
		
		for (int i = 0; i < tf.length; i++) {
			tf[i] = new JTextField();
		}
		for(int i=0; i < lbls.length; i++) {
			lbls[i] = new JLabel(header[i]);
			panS.add(lbls[i]);
			if(i==0) {
				panS.add(tf[0]);
			}
			if(i==1) {
				panS.add(tf[1]);
			}
			if(i==2) {
				panS.add(yearCombo);
			}
			if(i==3){
				panS.add(classCombo);
			}
			if(i==4) {
				panS.add(tf[2]);
			}
			if(i==5) {
				panS.add(tf[3]);
			}
			if(i==6) {
				panS.add(tf[4]);
			}
			if(i==7) {
				panS.add(tf[5]);
			}
			
		}
	
		
		for(int i=0; i<3; i++) {
			panS.add(new JLabel(" "));
		}
		
		panS.add(btnAdd);
	}
	
	//JTable 
	public void initView() {
		model = new DefaultTableModel(header, StudentVOList.size()) {
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.getColumnModel().getColumn(7).setPreferredWidth(50);
		
		JScrollPane scroll = new JScrollPane(table);
		
		putResult();
		
		add("Center", scroll);
		add("South", panS);
	}
	
	public void putResult() {
		model.setRowCount(StudentVOList.size());
		StudentVO vo = null;
		for(int i=0; i<StudentVOList.size(); i++) {
			vo=StudentVOList.get(i);
			model.setValueAt(vo.getSchool_number(), i, 0);
			model.setValueAt(vo.getName(), i,1);
			model.setValueAt(vo.getSchool_year(), i,2);
			model.setValueAt(vo.getSchool_class(), i,3);
			model.setValueAt(vo.getKorean(), i,4);
			model.setValueAt(vo.getEnglish(), i,5);
			model.setValueAt(vo.getMathematics(), i,6);
			model.setValueAt(vo.getScience(), i,7);
			model.setValueAt(vo.getTotal(), i,8);
			model.setValueAt(vo.getAverage(), i,9);
			
		}
	}
	
	public void setStudentVOList(ArrayList<StudentVO> StudentVOList) {
		this.StudentVOList = StudentVOList;
	}
	
	public JButton getBtnAdd() {
		return btnAdd;
	}
	
	public StudentVO neededInsertData() {
		StudentVO vo = new StudentVO();
		vo.setSchool_number(Integer.parseInt(tf[0].getText())); //학번
		vo.setName(tf[1].getText()); //성명
		vo.setSchool_year(yearCombo.getSelectedIndex()+1); //학년
		vo.setSchool_class(classCombo.getSelectedIndex()+1); //반
		vo.setKorean(Integer.parseInt(tf[2].getText())); //국어
		vo.setEnglish(Integer.parseInt(tf[3].getText()));//영어
		vo.setMathematics(Integer.parseInt(tf[4].getText())); //수학
		vo.setScience(Integer.parseInt(tf[5].getText())); //과학
		vo.setTotal(); //총점
		vo.setAverage(); //평균
		return vo;
	}
	
	public void initInsertData() {
		for(int i=0; i< tf.length; i++) {
			tf[i].setText("");
		}
		yearCombo.setSelectedIndex(0);
		classCombo.setSelectedIndex(1);
	}
	
	public JTable getTable() {
		return table;
	}
	

}
