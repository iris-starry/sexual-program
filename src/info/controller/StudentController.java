package info.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;

import info.view.StudentView;
import info.vo.StudentDAO;
import info.vo.StudentVO;


public class StudentController extends JFrame{
	StudentDAO dao;
	ArrayList<StudentVO> StudentVOList;
	StudentView view;
	JTable table;
	
	
	public StudentController() {
		dao = new StudentDAO();
		view = new StudentView();
		StudentVOList = dao.select();
		view.setStudentVOList(StudentVOList);
		view.initView();
		JButton btnAdd = view.getBtnAdd();
		btnAdd.addActionListener(btnAddL);
		table = view.getTable();
		table.addMouseListener(tableL);
		add(view, "Center");
		setTitle("성적관리프로그램");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(200,200);
		setSize(500, 500);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new StudentController();
	}
	
	ActionListener btnAddL = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			StudentVO vo = view.neededInsertData();
			dao.insert(vo);
			StudentVOList = dao.select();
			view.setStudentVOList(StudentVOList);
			view.putResult();
			view.initInsertData();
		}
	};
	
	MouseAdapter tableL = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int state = 1;
			if(e.getClickCount()==2) {
				state = JOptionPane.showConfirmDialog(StudentController.this,"정말 삭제하시겠습니까?","삭제여부", JOptionPane.YES_NO_OPTION);
				if(state == JOptionPane.YES_NO_OPTION) {
					dao.delete(table.getSelectedRow());
					StudentVOList = dao.select();
					view.setStudentVOList(StudentVOList);
					view.putResult();
				}
						
			}
		};
	};
	
	
}
