package com.horses.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ViewQ9ProgressReports extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewQ9ProgressReports dialog = new ViewQ9ProgressReports();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initialLoadRecords() throws SQLException  {
		String cstmtString = "{call Query9_a_allHorses}";
        ResultSetTableModel tableModel = new ResultSetTableModel(cstmtString);
        table.setModel(tableModel);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        table.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);            
	}
	
	private void loadRecords_a(String year) throws SQLException  {
		boolean err = false;
    	int sel_year = 0;
        try { 
        	sel_year =  Integer.parseInt(year); 
        } catch(NumberFormatException e) { 
       	 	err=true;
        } catch(NullPointerException e) {
       	 	err=true;
        }
        
        if(err==true || sel_year==0){
    		
    		initialLoadRecords();
    	}
        else{
        	String cstmtString = "{call Query9_a_oneHorse(?)}";
            ResultSetTableModel tableModel = new ResultSetTableModel(cstmtString, year);
            table.setModel(tableModel);
            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
            table.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);            
        }
    }
	
	private void loadRecords_b(String year) throws SQLException  {
		boolean err = false;
    	int sel_year = 0;
        try { 
        	sel_year =  Integer.parseInt(year); 
        } catch(NumberFormatException e) { 
       	 	err=true;
        } catch(NullPointerException e) {
       	 	err=true;
        }
        
        if(err==true || sel_year==0){
    		
    		initialLoadRecords();
    	}
        else{
        	String cstmtString = "{call Query9_b_oneHorse(?)}";
            ResultSetTableModel tableModel = new ResultSetTableModel(cstmtString, year);
            table.setModel(tableModel);
            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
            table.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);            
        }
    }
	
	
	/**
	 * Create the dialog.
	 */
	public ViewQ9ProgressReports() {
		setTitle("Progress Reports");
		setBounds(100, 100, 519, 533);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 482, 439);
		contentPanel.add(tabbedPane);
		
		JPanel panel_Horses = new JPanel();
		tabbedPane.addTab("HORSES", null, panel_Horses, null);
		panel_Horses.setLayout(null);
		
		JLabel lblPleaseSelectA = new JLabel("Please select a horse:");
		lblPleaseSelectA.setBounds(10, 11, 153, 14);
		panel_Horses.add(lblPleaseSelectA);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					loadRecords_a(comboBox.getSelectedItem().toString());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		comboBox.insertItemAt("", 0);
		try {
		   	 String sql_stmt = "SELECT * FROM [dbo].[HORSE];";
		   	 ResultSetTableModel Combo = new ResultSetTableModel(sql_stmt);
		   	 for(int i=0; i< Combo.getRowCount(); i++){
		   		 String s = (Combo.getValueAt(i, 0).toString());
		   		comboBox.addItem(s);
		   	 }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		comboBox.setBounds(228, 8, 239, 20);
		panel_Horses.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 457, 314);
		panel_Horses.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblPleaseSelectA_3 = new JLabel("Please select a meeting date:");
		lblPleaseSelectA_3.setBounds(10, 49, 208, 14);
		panel_Horses.add(lblPleaseSelectA_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					loadRecords_a(comboBox_4.getSelectedItem().toString());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		comboBox_4.insertItemAt("", 0);
		try {
		   	 String sql_stmt = "SELECT * FROM [dbo].[MEETING];";
		   	 ResultSetTableModel Combo = new ResultSetTableModel(sql_stmt);
		   	 for(int i=0; i< Combo.getRowCount(); i++){
		   		 String s = (Combo.getValueAt(i, 0).toString());
		   		comboBox_4.addItem(s);
		   	 }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		comboBox_4.setBounds(228, 46, 239, 17);
		panel_Horses.add(comboBox_4);
		
		JPanel panel_Trainers = new JPanel();
		tabbedPane.addTab("TRAINERS", null, panel_Trainers, null);
		panel_Trainers.setLayout(null);
		
		JLabel lblPleaseSelectA_1 = new JLabel("Please select a trainer:");
		lblPleaseSelectA_1.setBounds(10, 11, 171, 14);
		panel_Trainers.add(lblPleaseSelectA_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(167, 8, 300, 20);
		panel_Trainers.add(comboBox_1);
		
		table_1 = new JTable();
		table_1.setBounds(10, 36, 457, 314);
		panel_Trainers.add(table_1);
		
		JPanel panel_Owners = new JPanel();
		tabbedPane.addTab("OWNERS", null, panel_Owners, null);
		panel_Owners.setLayout(null);
		
		JLabel lblPleaseSelectAn = new JLabel("Please select an owner:");
		lblPleaseSelectAn.setBounds(10, 11, 140, 14);
		panel_Owners.add(lblPleaseSelectAn);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(169, 8, 298, 20);
		panel_Owners.add(comboBox_2);
		
		table_2 = new JTable();
		table_2.setBounds(10, 36, 457, 314);
		panel_Owners.add(table_2);
		
		JPanel panel_OwnerFamilies = new JPanel();
		tabbedPane.addTab("OWNER FAMILIES", null, panel_OwnerFamilies, null);
		panel_OwnerFamilies.setLayout(null);
		
		JLabel lblPleaseSelectA_2 = new JLabel("Please select a family:");
		lblPleaseSelectA_2.setBounds(10, 11, 145, 14);
		panel_OwnerFamilies.add(lblPleaseSelectA_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(166, 8, 301, 20);
		panel_OwnerFamilies.add(comboBox_3);
		
		table_3 = new JTable();
		table_3.setBounds(10, 36, 457, 314);
		panel_OwnerFamilies.add(table_3);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("BACK");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						ViewMainQView mv = new ViewMainQView();
						mv.frmQueries.setVisible(true);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		try {
			initialLoadRecords();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
