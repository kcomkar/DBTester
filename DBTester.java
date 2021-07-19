/*
 * DBTester.java
 *
 * Created on September 9, 2005, 9:28 PM
 */

/**
 *
 * @author  Omkar
 */
import java.sql.*;
import java.util.*;
public class DBTester extends javax.swing.JFrame {
    
    /** Creates new form DBTester */
    public static java.sql.Connection conn;
    public static java.sql.Statement st;
    public static java.sql.ResultSet rs;
    public DBTester() {
        initComponents();
        setSize(529,383);
        setLocation(150,130);
        setResizable(false);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        execute = new javax.swing.JButton();
        settings = new javax.swing.JButton();
        op = new java.awt.TextArea();
        query = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        con = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        dml = new javax.swing.JRadioButton();
        ddl = new javax.swing.JRadioButton();

        getContentPane().setLayout(null);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24));
        jLabel1.setText("DataBase Connectivity Testing Tool");
        jLabel1.setAutoscrolls(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 10, 400, 28);

        execute.setFont(new java.awt.Font("Tahoma", 1, 12));
        execute.setText("EXECUTE");
        execute.setToolTipText("Executes the query typed with the specified database");
        execute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeActionPerformed(evt);
            }
        });
        execute.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                executeKeyPressed(evt);
            }
        });

        getContentPane().add(execute);
        execute.setBounds(70, 60, 130, 25);

        settings.setFont(new java.awt.Font("Tahoma", 1, 12));
        settings.setText("SETTINGS");
        settings.setToolTipText("Set the values of DSN,Driver,Connection,UserName & Password");
        settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsActionPerformed(evt);
            }
        });
        settings.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                settingsKeyPressed(evt);
            }
        });

        getContentPane().add(settings);
        settings.setBounds(370, 60, 130, 25);

        op.setBackground(new java.awt.Color(0, 0, 0));
        op.setEditable(false);
        op.setFont(new java.awt.Font("Monospaced", 1, 14));
        op.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(op);
        op.setBounds(60, 190, 440, 110);

        query.setFont(new java.awt.Font("Monospaced", 0, 14));
        query.setToolTipText("Enter the query string here");
        getContentPane().add(query);
        query.setBounds(120, 100, 380, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("QUERY :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 110, 60, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("PROCESS/OUTPUT");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(230, 170, 120, 15);

        jButton3.setText("E X I T");
        jButton3.setToolTipText("Quits from the application");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton3KeyPressed(evt);
            }
        });

        getContentPane().add(jButton3);
        jButton3.setBounds(425, 320, 90, 23);

        con.setFont(new java.awt.Font("Tahoma", 1, 12));
        con.setText("CONNECTION");
        con.setToolTipText("Tests the establishment of connection with the specified data base");
        con.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conActionPerformed(evt);
            }
        });
        con.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                conKeyPressed(evt);
            }
        });

        getContentPane().add(con);
        con.setBounds(220, 60, 130, 25);

        jButton4.setText("RESET");
        jButton4.setToolTipText("Closes all database connections and resets the form");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton4KeyPressed(evt);
            }
        });

        getContentPane().add(jButton4);
        jButton4.setBounds(20, 320, 90, 23);

        dml.setSelected(true);
        dml.setText("D M L ");
        dml.setToolTipText("Supported queries:\n1.SELECT");
        buttonGroup1.add(dml);
        getContentPane().add(dml);
        dml.setBounds(140, 140, 90, 23);

        ddl.setText("D D L");
        ddl.setToolTipText("Supported Queries:\n1.INSERT\n2.DELETE\n3.UPDATE");
        buttonGroup1.add(ddl);
        getContentPane().add(ddl);
        ddl.setBounds(350, 140, 120, 23);

        pack();
    }//GEN-END:initComponents

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
       query.setText("");
        op.setText("");
        try
        {
            
            conn.close();
            st.close();
        }
        catch(Exception e)
        {
            javax.swing.JOptionPane.showMessageDialog(null,"ERROR IN CLOSING CONNECTIONS : \n"+e);
        }
    }//GEN-LAST:event_jButton4KeyPressed
   
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        query.setText("");
        op.setText("");
        try
        {
            
            conn.close();
            st.close();
        }
        catch(Exception e)
        {
            javax.swing.JOptionPane.showMessageDialog(null,"ERROR IN CLOSING CONNECTIONS : \n"+e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void conKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_conKeyPressed
       if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER)
       {
           checkConnection();
       }
    }//GEN-LAST:event_conKeyPressed

    private void conActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conActionPerformed
        checkConnection();
    }//GEN-LAST:event_conActionPerformed
    private void checkConnection()
    {
        int result=0;
        try
        {
            op.setText("");
            op.setText("Loading driver...");
            Class.forName(JDBCTester.DRIVER);
            op.setText(op.getText()+"[ OK ]");
        }
        catch(Exception e)
        {
            op.setText(op.getText()+"[ ERROR ]");
            op.setText(op.getText()+"\nError details are : \n"+e);
            result = 1;
        }
        try
        {
            op.setText(op.getText()+"\n\nEstablishing connection with the database...");
            if(JDBCTester.REQUIRES_AUTHENTICATION)
            {
                conn = DriverManager.getConnection(JDBCTester.CONNECTION,JDBCTester.USERNAME,JDBCTester.PASSWORD);   
            }
            else
            {
                conn = DriverManager.getConnection(JDBCTester.CONNECTION);
            }
            op.setText(op.getText()+"[ OK ]");
        }
        catch(Exception e1)
        {
            op.setText(op.getText()+"[ ERROR ]");
            op.setText(op.getText()+"\nError details are : \n"+e1);
            result++;
        }
        try
        {
            op.setText(op.getText()+"\n\nCreating statement...");
            st = conn.createStatement();   
            op.setText(op.getText()+"[ OK ]");
        }
        catch(Exception e2)
        {
            op.setText(op.getText()+"[ ERROR ]");
            op.setText(op.getText()+"\nError details are : \n"+e2);
            result++;
        }
        try
        {
            conn.close();
            st.close();
        }
        catch(Exception e9)
        {
            javax.swing.JOptionPane.showMessageDialog(null,"ERROR IN CLOSING CONNECTIONS : \n"+e9);
        }
        if(result==0)
           op.setText(op.getText()+"\n\n         RESULT : SUCCESS");
        else
           op.setText(op.getText()+"\n\nERRORS IN ABOVE PROCESS ARE VERY CRITICAL\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
         
    }
    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER)
            System.exit(0);
    }//GEN-LAST:event_jButton3KeyPressed

    private void executeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_executeKeyPressed
        executeQuery();
    }//GEN-LAST:event_executeKeyPressed

    private void executeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeActionPerformed
        executeQuery();
    }//GEN-LAST:event_executeActionPerformed
  
    private void executeQuery()
    {
        int result=0;
        try
        {
            op.setText("");
            op.setText("Loading driver...");
            Class.forName(JDBCTester.DRIVER);
            op.setText(op.getText()+"[ OK ]");
        }
        catch(Exception e)
        {
            op.setText(op.getText()+"[ ERROR ]");
            op.setText(op.getText()+"\nError details are : \n"+e);
            result = 1;
        }
        try
        {
            op.setText(op.getText()+"\n\nEstablishing connection with the database...");
            if(JDBCTester.REQUIRES_AUTHENTICATION)
            {
                conn = DriverManager.getConnection(JDBCTester.CONNECTION,JDBCTester.USERNAME,JDBCTester.PASSWORD);   
            }
            else
            {
                conn = DriverManager.getConnection(JDBCTester.CONNECTION);
            }
            op.setText(op.getText()+"[ OK ]");
        }
        catch(Exception e1)
        {
            op.setText(op.getText()+"[ ERROR ]");
            op.setText(op.getText()+"\nError details are : \n"+e1);
            result++;
        }
        try
        {
            op.setText(op.getText()+"\n\nCreating statement...");
            st = conn.createStatement();   
            op.setText(op.getText()+"[ OK ]");
        }
        catch(Exception e2)
        {
            op.setText(op.getText()+"[ ERROR ]");
            op.setText(op.getText()+"\nError details are : \n"+e2);
            result++;
        }
        if(result==0)
           op.setText("");
        else
           op.setText(op.getText()+"\n\nERRORS IN ABOVE PROCESS ARE VERY CRITICAL\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        try
        {
            if(dml.isSelected()==true)
            {
              rs = st.executeQuery(query.getText());
              java.sql.ResultSetMetaData rsmd = rs.getMetaData();
              int i = rsmd.getColumnCount();
              for (int j=1;j<=i;j++)
              {
                  op.setText(op.getText()+rsmd.getColumnLabel(j)+"           ");         
              }
              op.setText(op.getText()+"\n--------------------------------------------------------------------------------------\n");
              while(rs.next())
              {
                  op.setText(op.getText()+"\n");
                  for (int j=1;j<=i;j++)
                  {
                      op.setText(op.getText()+rs.getString(j)+"           ");
                  }
              }
            }
            else if(ddl.isSelected()==true)
            {
                int jkl = st.executeUpdate(query.getText());
                op.setText(op.getText()+"\n\n        "+jkl+"  RECORDS INSERTED/UPDATED SUCCESSFULLY");
            }
          }
        catch(Exception e3)
        {
            op.setText(op.getText()+"\n\n ERROR :  ");
            op.setText(op.getText()+"\nError details are : \n"+e3);
        }
        try
        {
            conn.close();
            st.close();
        }
        catch(Exception e4)
        {
            javax.swing.JOptionPane.showMessageDialog(null,"ERROR (Closing connections) : \n"+e4);
        }
    }
    private void settingsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_settingsKeyPressed
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER)
        {
            new JDBCTester(new javax.swing.JFrame(), true).show();
        }
    }//GEN-LAST:event_settingsKeyPressed

    private void settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsActionPerformed
         new JDBCTester(new javax.swing.JFrame(), true).show();
    }//GEN-LAST:event_settingsActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new DBTester().show();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton con;
    private javax.swing.JRadioButton ddl;
    private javax.swing.JRadioButton dml;
    private javax.swing.JButton execute;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private java.awt.TextArea op;
    private javax.swing.JTextField query;
    private javax.swing.JButton settings;
    // End of variables declaration//GEN-END:variables
    
}
