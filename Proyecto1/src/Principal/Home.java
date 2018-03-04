package Principal;

import Acciones.Compilador;
import Acciones.CompiladorCJS;
import Acciones.CompiladorCSS;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Joaquin
 */
public class Home extends javax.swing.JFrame 
{

    public Home() 
    {
        initComponents();
    }

    @SuppressWarnings({"unchecked", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        split = new javax.swing.JSplitPane();
        scroll1 = new javax.swing.JScrollPane();
        txtentrada = new javax.swing.JTextPane();
        scroll2 = new javax.swing.JScrollPane();
        txtsalida = new javax.swing.JTextPane();
        barraMenu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        iabrir = new javax.swing.JMenuItem();
        iguardarcomo = new javax.swing.JMenuItem();
        isalir = new javax.swing.JMenuItem();
        menuEjecutar = new javax.swing.JMenu();
        ianalizar = new javax.swing.JMenuItem();
        ianalizar1 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuEjecutar1 = new javax.swing.JMenu();
        ianalizar2 = new javax.swing.JMenuItem();
        ianalizar3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        iacercade = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ejemplo AST 1");
        setResizable(false);

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(692, 609));

        split.setDividerLocation(300);
        split.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        txtentrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        scroll1.setViewportView(txtentrada);

        split.setLeftComponent(scroll1);

        txtsalida.setBackground(new java.awt.Color(0, 0, 0));
        txtsalida.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtsalida.setForeground(new java.awt.Color(0, 255, 0));
        scroll2.setViewportView(txtsalida);

        split.setRightComponent(scroll2);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(split, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(split, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );

        barraMenu.setForeground(new java.awt.Color(255, 255, 255));
        barraMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        menuArchivo.setBackground(new java.awt.Color(0, 0, 0));
        menuArchivo.setText("Archivo");
        menuArchivo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        iabrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document-open.png"))); // NOI18N
        iabrir.setText("Abrir");
        iabrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iabrirActionPerformed(evt);
            }
        });
        menuArchivo.add(iabrir);

        iguardarcomo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document-save-as.png"))); // NOI18N
        iguardarcomo.setText("Guardar Como");
        iguardarcomo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iguardarcomoActionPerformed(evt);
            }
        });
        menuArchivo.add(iguardarcomo);

        isalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/boot.png"))); // NOI18N
        isalir.setText("Salir");
        isalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isalirActionPerformed(evt);
            }
        });
        menuArchivo.add(isalir);

        barraMenu.add(menuArchivo);

        menuEjecutar.setBackground(new java.awt.Color(0, 0, 0));
        menuEjecutar.setText("Compilar");
        menuEjecutar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        ianalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/kt-start.png"))); // NOI18N
        ianalizar.setText("CHTML");
        ianalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ianalizarActionPerformed(evt);
            }
        });
        menuEjecutar.add(ianalizar);

        ianalizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/kt-start.png"))); // NOI18N
        ianalizar1.setText("CSS");
        ianalizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ianalizar1ActionPerformed(evt);
            }
        });
        menuEjecutar.add(ianalizar1);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/kt-start.png"))); // NOI18N
        jMenuItem1.setText("CJS");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuEjecutar.add(jMenuItem1);

        barraMenu.add(menuEjecutar);

        menuEjecutar1.setBackground(new java.awt.Color(0, 0, 0));
        menuEjecutar1.setText("Graficar");
        menuEjecutar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        ianalizar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/kt-start.png"))); // NOI18N
        ianalizar2.setText("CHTML");
        ianalizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ianalizar2ActionPerformed(evt);
            }
        });
        menuEjecutar1.add(ianalizar2);

        ianalizar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/kt-start.png"))); // NOI18N
        ianalizar3.setText("CSS");
        ianalizar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ianalizar3ActionPerformed(evt);
            }
        });
        menuEjecutar1.add(ianalizar3);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/kt-start.png"))); // NOI18N
        jMenuItem2.setText("jMenuItem1");
        menuEjecutar1.add(jMenuItem2);

        barraMenu.add(menuEjecutar1);

        menuAyuda.setText("?");
        menuAyuda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        iacercade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ajuda-sobre.png"))); // NOI18N
        iacercade.setText("Acerca de ...");
        iacercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iacercadeActionPerformed(evt);
            }
        });
        menuAyuda.add(iacercade);

        barraMenu.add(menuAyuda);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void iabrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iabrirActionPerformed
        JFileChooser filechooserabrir = new JFileChooser();
        filechooserabrir.setFileSelectionMode( JFileChooser.FILES_ONLY );
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Texto (*.txt)", "txt");
        filechooserabrir.setFileFilter(filtro);
        int seleccion = filechooserabrir.showOpenDialog(this);
        if(seleccion == JFileChooser.APPROVE_OPTION )
        {       
            try {
                BufferedReader bufferreader;                 
                File file = filechooserabrir.getSelectedFile();
                bufferreader = new BufferedReader(new FileReader(file.getAbsolutePath()));  
                String linea, contenido= "";
                
                //leeendo linea a linea
                while ((linea = bufferreader.readLine())!=null)
                {
                    contenido += linea +"\n";
                }
                            
                //Agregando texto al editor
                this.txtentrada.setText(contenido);                
                bufferreader.close();
            } 
            catch (IOException ex) 
            {Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);}
        }
    }//GEN-LAST:event_iabrirActionPerformed

    private void iguardarcomoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iguardarcomoActionPerformed
        FileNameExtensionFilter filtrotxt;
        JFileChooser dialogoguardar=new JFileChooser();

        //Filtro
        filtrotxt = new FileNameExtensionFilter("Archivos de Texto(*.txt)", "txt");
        dialogoguardar.setFileFilter(filtrotxt);

        dialogoguardar.showSaveDialog(this);
        File fichero =dialogoguardar.getSelectedFile();

        if(fichero !=null)
        {
            try (FileWriter ficheroguardando = new FileWriter(fichero+".txt")) 
            {
                ficheroguardando.write(this.txtentrada.getText());
                JOptionPane.showMessageDialog(null,"El archivo se a guardado Exitosamente","Compiladores 1 ~ Ejemplo 1 AST",JOptionPane.INFORMATION_MESSAGE);
            } 
            catch (IOException ex) 
            {
                JOptionPane.showMessageDialog(null,"Su archivo no se ha guardado","Compiladores 1 ~ Ejemplo 1 AST",JOptionPane.WARNING_MESSAGE);
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }            
        } 
    }//GEN-LAST:event_iguardarcomoActionPerformed

    private void isalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isalirActionPerformed
        Object [] opciones ={"Si","No"};
        String sms = "Esta a punto de salir, quiere continuar";
        int eleccion =  JOptionPane.showOptionDialog(this,sms,"Saliendo",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if (eleccion == JOptionPane.YES_OPTION)
        {System.exit(0);}
    }//GEN-LAST:event_isalirActionPerformed

    private void ianalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ianalizarActionPerformed
        if(txtentrada.getText().length()!=0 || !txtentrada.getText().equals(""))
        {
            Compilador c = new Compilador();
            c.Analizar(this.txtentrada.getText());
            //String salida = c.Analizar(archivo.txt_entrada.getText());
            //archivo.txt_salida.setText(salida);  
        } 
    }//GEN-LAST:event_ianalizarActionPerformed

    private void iacercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iacercadeActionPerformed
        JOptionPane.showMessageDialog(null,"José Joaquin Cacao Chub\nCarnet: 2012-12577\nGuatemala Febrero 2016","Acerca de",1);
    }//GEN-LAST:event_iacercadeActionPerformed

    private void ianalizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ianalizar1ActionPerformed
 if(txtentrada.getText().length()!=0 || !txtentrada.getText().equals(""))
        {
            CompiladorCSS c = new CompiladorCSS();
            c.Analizar(this.txtentrada.getText(),this.txtsalida);
          
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ianalizar1ActionPerformed

    private void ianalizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ianalizar2ActionPerformed

            CompiladorCSS c = new CompiladorCSS();
            //c.recorrido(nodoactual, txtsalida);

        // TODO add your handling code here:
    }//GEN-LAST:event_ianalizar2ActionPerformed

    private void ianalizar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ianalizar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ianalizar3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

if(txtentrada.getText().length()!=0 || !txtentrada.getText().equals(""))
        {
            CompiladorCJS c = new CompiladorCJS();
            c.Analizar(this.txtentrada.getText(),this.txtsalida);
          
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed
        
          
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenuItem iabrir;
    private javax.swing.JMenuItem iacercade;
    private javax.swing.JMenuItem ianalizar;
    private javax.swing.JMenuItem ianalizar1;
    private javax.swing.JMenuItem ianalizar2;
    private javax.swing.JMenuItem ianalizar3;
    private javax.swing.JMenuItem iguardarcomo;
    private javax.swing.JMenuItem isalir;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuEjecutar;
    private javax.swing.JMenu menuEjecutar1;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JScrollPane scroll2;
    private javax.swing.JSplitPane split;
    private javax.swing.JTextPane txtentrada;
    private javax.swing.JTextPane txtsalida;
    // End of variables declaration//GEN-END:variables
}
